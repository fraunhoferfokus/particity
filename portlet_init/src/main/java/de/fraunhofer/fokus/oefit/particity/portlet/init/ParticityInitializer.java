package de.fraunhofer.fokus.oefit.particity.portlet.init;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;

import org.apache.commons.io.IOUtils;
import org.apache.taglibs.standard.tag.common.core.RemoveTag;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutTemplate;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.Theme;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutTemplateLocalServiceUtil;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ThemeLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;
import de.particity.impexp.ImportFailedException;
import de.particity.impexp.ImportWriter;
import de.particity.impexp.ImporterFactory;

public class ParticityInitializer {

	//private static final String PARTICITY_GROUP_NAME = "Particity";
	
	private static Log m_objLog = LogFactoryUtil.getLog(ParticityInitializer.class);
	private static long globalCompanyId = -1;
	private static long globalGroupId = -1;
	private static long globalAdminId = -1;
	private static long homeLayoutId = LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;
	
	
	public static void init() {
		if (!isWizardAvailable()) {
			m_objLog.warn("Setup wizard was already initialized before. Delete portlet painit to remove this message for future server restarts.");
			return;
		}
		
		try {
			// init static globals
			if (globalCompanyId == -1)
				initGlobals();

			// add setup
			Layout layout = initLayout(globalCompanyId, globalAdminId, globalGroupId, E_ContextPath.HOME);
			
			if (layout != null) {
				String portletId = addPortletToPage(layout, "painit_WAR_painitportlet", E_ContextPath.HOME, globalAdminId);			
				m_objLog.debug("Created welcome with portlet id "+portletId);
			} else {
				m_objLog.debug("No home found under "+E_ContextPath.HOME.getPath());
			}
			
		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	public static void initGlobals() {
		try {
			// get default company
			Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			// fallback
			if (company == null)
				company = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());	
			
			globalCompanyId = company.getCompanyId();
			globalGroupId = company.getGroup().getGroupId();
			globalAdminId = company.getDefaultUser().getUserId(); 
			m_objLog.debug("Initial company is "+globalCompanyId+", group "+globalGroupId+", user "+globalAdminId);

			// get welcome page
			Layout layout = getLayout(globalGroupId, E_ContextPath.HOME.getPath());
			if (layout != null) {
				// correct values
				globalCompanyId = layout.getCompanyId();
				globalGroupId = layout.getGroupId();
				homeLayoutId = layout.getLayoutId();
				User admin = getDefaultAdmin(globalCompanyId);
				if (admin != null) {
					globalAdminId = admin.getUserId();
				} 
				m_objLog.debug("Corrected company is "+globalCompanyId+", group "+globalGroupId+", user "+globalAdminId);
			}
			
		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	public static boolean removeLayout(long groupId, String layoutPath) {
		boolean result = false;
		try {
			Layout layout = getLayout(groupId, layoutPath);
			if (layout != null) {
				layout = LayoutLocalServiceUtil.deleteLayout(layout);
				result = layout != null;
			}
		} catch (Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}
	
	public static void clearPage(Layout layout, E_ContextPath path, String newPath) {
		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
		
		long adminId = -1;
		try {
			// get admin for this layout
			User admin = getDefaultAdmin(layout.getCompanyId());
			if (admin != null)
				adminId = admin.getUserId();
			
			// set permissions for operations
			PermissionChecker permissionChecker = PermissionCheckerFactoryUtil.create( admin );
			PermissionThreadLocal.setPermissionChecker( permissionChecker );
		
		
			// count all portlets currently registered for this column
			List<String> portlets = layoutTypePortlet.getPortletIds();
			//layout.
			for (String portlet: portlets) {
				try {
						/*ResourceLocalServiceUtil.deleteResource(
								                      layout.getCompanyId(), portlet,
								            ResourceConstants.SCOPE_INDIVIDUAL,
								            PortletPermissionUtil.getPrimaryKey(
								            layout.getPlid(), portlet);*/
						layoutTypePortlet.removePortletId(adminId, portlet,true);
						// update the layout
						LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
			                    layout.isPrivateLayout(),
			                    layout.getLayoutId(),
			                    layout.getTypeSettings());
				} catch (Throwable t) {
					m_objLog.error(t);
				}
			}
			
			if ((path.isHidden() && !layout.isHidden())) {
				layout.setHidden(true);
				/*Locale defLocale = LocaleUtil.getDefault();
				if (defLocale == null)
					defLocale = Locale.GERMAN;
						
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(defLocale, path.getTitle());*/
				layout.setTitle(path.getTitle());
				layout.setName(path.getName());
				layout = LayoutLocalServiceUtil.updateLayout(layout);				
			}
			if (newPath != null && !path.getPath().equals(newPath)) {
				m_objLog.debug("Changing friendly URL for layout from "+layout.getFriendlyURL()+" to "+newPath);
				//layout.setFriendlyURL(newPath);
				//layout = LayoutLocalServiceUtil.updateLayout(layout);
				layout = LayoutLocalServiceUtil.updateFriendlyURL(layout.getPlid(), newPath, layout.getDefaultLanguageId());
			}

			
		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	public static Layout initLayout(long companyId, long adminId, long groupId, E_ContextPath path) {
		Layout site = getLayout(groupId, path.getPath());
		try {
			if (site == null) {
				site = createLayout(adminId, companyId, groupId, path, null);
			} else {
				// clear portlets
				clearPage(site, path, null);
			}
			Theme theme = getTheme(companyId, path.getThemeId());
			if (theme != null) {
				site.setThemeId(path.getThemeId());
				site = LayoutLocalServiceUtil.updateLookAndFeel(site.getGroupId(),
						false, site.getLayoutId(), path.getThemeId(), "01", "", false);
			} else
				m_objLog.warn("Did not find theme "+path.getThemeId()+"!");
            LayoutTemplate template = getLayoutTemplate(path.getTemplateId());
			
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) site.getLayoutType();
			if (template != null) {
				layoutTypePortlet.setLayoutTemplateId(0, path.getTemplateId(), false);
			} else
				m_objLog.warn("Did not find layout template "+path.getTemplateId()+"!");
			updatePermissions(site, path);
		} catch (Throwable t) {
			m_objLog.error(t);
		}
		return site;
	}
	
	public static void setup(Map<E_ContextPath, String> pathMap, Map<E_SetupParam, String> paramMap) {
		
		if (!isWizardAvailable()) {
			m_objLog.warn("Setup wizard was already initialized before. Delete portlet painit to remove this message for future server restarts.");
			return;
		}
		
		
		try {
			
			// init static globals
			if (globalCompanyId == -1)
				initGlobals();
			
			// initialize roles
			Map<E_Role, Role> roles = getRoles(globalAdminId, globalCompanyId);
			// initialize sites
			Map<E_ContextPath, Layout> layouts = clearLayouts(globalGroupId, globalAdminId, globalCompanyId, pathMap);
			
			// add administrator
			//User adminUser = CustomPortalServiceHandler.createPortalUser("Particity", "Administrator", "admin@particity.de", globalCompanyId, pGroup.getGroupId(), Locale.GERMAN, false, "test", true);
			// remove liferay admin
			/*try {
				User defaultAdmin = UserLocalServiceUtil.getUserByEmailAddress(globalCompanyId, "test@liferay.com");
				if (defaultAdmin != null)
					UserLocalServiceUtil.deleteUser(defaultAdmin.getUserId());
			} catch (NoSuchUserException e) {}*/
			// add sample content
			initSampleContent(globalGroupId, globalAdminId, globalCompanyId, layouts, pathMap);
			initCategories(paramMap);
			// call initialization of additional settings that require initialization, even if this wizard is not available
			CustomPortalServiceHandler.checkInit(globalGroupId, globalAdminId);
			// set wizard flag to prevent additional runs of this method on future restarts
			CustomPortalServiceHandler.setConfig(E_ConfigKey.WIZARDFLAG, "true");

		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	private static void initCategories(Map<E_SetupParam, String> paramMap) {
		if (paramMap != null && paramMap.size() > 0) {
			for (E_SetupParam param: paramMap.keySet()) {
				switch (param) {
					case SAMPLECONTENT:
						InputStream samples = ParticityInitializer.class.getResourceAsStream("/../../data/samplecontent.xml");
						if (samples != null) {
							try {
								ImporterFactory.importData(samples, globalCompanyId, globalGroupId, globalAdminId);
							} catch (ImportFailedException e) {
								m_objLog.error(e);
							}
						}
						break;
					case SAMPLEUSER:
						String user = paramMap.get(E_SetupParam.SAMPLEUSERNAME);
						String pass = paramMap.get(E_SetupParam.SAMPLEUSERPASS);
						//m_objLog.info("Got sample user request "+user+", "+pass);
						if (user != null && pass != null && user.trim().length() > 0 && pass.trim().length() > 0) {
							User mgmtUser = CustomPortalServiceHandler.createPortalUser("Particity", "Verwaltung", user, globalCompanyId, globalGroupId, Locale.GERMAN, false, pass, false, E_Role.MGMT);
							//Role mgmtRole = CustomPortalServiceHandler.checkRole(globalAdminId, globalCompanyId, E_Role.MGMT);
							/*try {
								RoleLocalServiceUtil.addUserRole(mgmtUser.getUserId(), mgmtRole.getRoleId());
							} catch (SystemException e) {
								m_objLog.error(e);
							}*/
						}
						break;
				}
			}
		}
	}

	/**
	 * Checks if the wizard was already run. Uses a portlet configuration setting.
	 *
	 * @return true, if wizard was already run once without error, false otherwise
	 */
	public static boolean isWizardAvailable() {
		boolean result = false;
		// check if liferay already initialized
		boolean isSystemSetupDone = !CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.WIZARDFLAG);
		// if initialized yet, check whether particity is initialized as well
		if (isSystemSetupDone) {
			result = !CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.INITFLAG);
		}
		return result;
	}
	
	public static void initSampleContent(long groupId, long adminId, long companyId, Map<E_ContextPath, Layout> layouts, Map<E_ContextPath, String> pathMap) {
		Layout layout = null;
		Map<String, JournalArticle> articles = new HashMap<String, JournalArticle>();
		for (E_SampleContent content: E_SampleContent.values()) {
			layout = layouts.get(content.getContext());
			if (layout == null) {
				m_objLog.debug("Could not find layout for sample content context path "+content.getContext().getPath());
				continue;
			}
			try {
				// add portlet to page
				if (content.isPorlet()) {
					addPortletToPage(layout, content.getDataPath(), content.getContext(), adminId);					
					m_objLog.debug("Added sample content "+content.name()+" with portlet "+content.getDataPath()+" for URL "+content.getContext().getPath());
				} 
				// import HTML as article + add to page
				else {
					JournalArticle article = articles.get(content.getDataPath());
					if (article == null)
						article = getArticle(layout.getGroupId(), content.name());
					if (article == null) {
						InputStream frontend = ParticityInitializer.class.getResourceAsStream(content.getDataPath());
						if (frontend != null) {
							String contentSrc = IOUtils.toString(frontend);
							if (contentSrc != null) {
								contentSrc = translatePaths(contentSrc, pathMap);
								article = addArticle(adminId, layout.getGroupId(), content.name(), content.getTitle(), contentSrc);
								//m_objLog.debug("Added article for "+content.name());
								articles.put(content.getDataPath(), article);									
							} else {
								m_objLog.warn("Could not load sample content "+content.name()+" for URL "+content.getContext().getPath()+" from "+content.getDataPath());
							}
						}
					}
					if (article != null) {
						layout = layouts.get(content.getContext());
						if (layout != null) {
							// is nested portlet?
							if (content.hasParent()) {
								setPortletArticle(content.getParentPortletId(), article.getArticleId(), layout, adminId, layout.getGroupId(), layout.getCompanyId());
							} 
							// is standalone portlet
							else {
								// check if article not added yet
								if (!checkArticleOnLayout(layout, article.getArticleId(), content.getContext().getColumnId(), layout.getCompanyId())) {
									addArticle(content.getContext(), article,layout, adminId, layout.getGroupId(), layout.getCompanyId());
									m_objLog.debug("Added sample content "+content.name()+" for URL "+content.getContext().getPath());
								} else {
									m_objLog.debug("Found existing sample content "+content.name()+" for URL "+content.getContext().getPath());
								}
							}
						} else {
							m_objLog.warn("Could not find layout for sample content context path "+content.getContext().getPath());			
						}
					} else {
						m_objLog.warn("Could not create sample content "+content.name()+" for URL "+content.getContext().getPath()+" (already exists?) ");
					}
				}
			} catch (Throwable t) {
				m_objLog.warn(t);
			}
		}
	}
	
	private static String translatePaths(String contentSrc,
			Map<E_ContextPath, String> pathMap) {
		String result = contentSrc;
		
		for (E_ContextPath path: pathMap.keySet()) {
			result = result.replaceAll(path.getPath(), pathMap.get(path));
		}
		
		return result;
	}

	public static Map<E_ContextPath, Layout> clearLayouts(long groupId, long adminId, long companyId, Map<E_ContextPath, String> pathMap) {
		Map<E_ContextPath, Layout> result = new HashMap<E_ContextPath, Layout>();
		
		for (E_ContextPath pth: E_ContextPath.values()) {
			String actualPath = pathMap.get(pth);
			if (actualPath == null)
				actualPath = pth.getPath();
			Layout layout = getLayout(groupId, actualPath);
			// if no layout at new path, try the original path setting
			if (layout == null && !pth.getPath().equals(actualPath))
				layout = getLayout(groupId, pth.getPath());
			if (layout == null) {
				layout = createLayout(adminId, companyId, groupId, pth, actualPath);
				m_objLog.debug("Created layout for URL "+actualPath);
			} else {
				m_objLog.debug("Found layout for URL "+actualPath);
				clearPage(layout, pth, actualPath);
			}
			result.put(pth, layout);
		}
		return result;
	}
	
	public static Map<E_Role, Role> getRoles(long adminUserId, long companyId) {
		Map<E_Role,Role> result = new HashMap<E_Role, Role>();
		for (E_Role role: E_Role.values()) {
			if (!role.equals(E_Role.NULL)) {
				Role lrRole = CustomPortalServiceHandler.checkRole(adminUserId, companyId, role);
				result.put(role, lrRole);
				m_objLog.debug("Got role "+lrRole.getName());
			}
		}
		return result;
	}
	
	/*public static Layout getLayout(String context) {
		Layout result = null;
		try {
			List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Layout layout: layouts) {
				if (layout.getFriendlyURL().equals(context)) {
					result = layout;
					break;
				} else
					m_objLog.debug("Found unmatching layout at "+layout.getFriendlyURL());
			}
		} catch (Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}*/
	
	public static Layout getLayout(long groupId, String context) {
		Layout result = null;
		try {
			result = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId,
					false, context);
			m_objLog.debug("Found layout registered for group " + groupId
					+ " and url " + context);
		} catch (Throwable t) {
			m_objLog.warn("No layout registered for group " + groupId
					+ " with url " + context);
			// retry searching manually
			if (result == null) {
				try {
					List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
					for (Layout layout: layouts) {
						if (layout.isPublicLayout() && layout.getFriendlyURL().equals(context)) {
							result = layout;
							m_objLog.debug("Found matching public layout "+context+" with group "+result.getGroupId()+", company "+result.getCompanyId());
							break;
						}
					}
				} catch (Throwable t2) {
					t2.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static Theme getTheme(long companyId, String themeId) {
		Theme result = null;
		
		List<Theme> themes = ThemeLocalServiceUtil.getThemes(companyId);
		for (Theme thm : themes) {
			if (thm.getThemeId().equals(themeId)) {
				result = thm;
				break;
			} else
				m_objLog.debug("Found theme: "+thm.getThemeId());
		}
		
		return result;
	}
	
	public static LayoutTemplate getLayoutTemplate(String templateId) {
		List<LayoutTemplate> ltemplates = LayoutTemplateLocalServiceUtil
				.getLayoutTemplates();
		LayoutTemplate template = null;
		for (LayoutTemplate ltmplt : ltemplates) {
			if (ltmplt.getLayoutTemplateId().equals(templateId)) {
				template = ltmplt;
				break;
			} else
				m_objLog.debug("Found template: "+ltmplt.getName()+", "+ltmplt.getLayoutTemplateId());
		}
		return template;
	}
	
	public static Layout createLayout(long adminId, long companyId, long groupId, E_ContextPath path, String actualPath) {
		Layout result = null;
		
		boolean privateLayout = false;
		String description = null;
		String type = path.getType();
		long parentLayoutId = path.isHidden() ?  homeLayoutId : LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;
		ServiceContext ctx = new ServiceContext();
		if (actualPath == null)
			actualPath = path.getPath();
		
		try {
			
			result = LayoutLocalServiceUtil.addLayout(adminId, groupId,
					privateLayout, parentLayoutId, path.getName(), path.getTitle(), description,
					type, path.isHidden(), actualPath, ctx);
			

			// layout.setLayoutPrototypeLinkEnabled(false);
			
			if (!type.equals(LayoutConstants.TYPE_URL)) {

				Theme theme = getTheme(companyId, path.getThemeId());
				if (theme != null) {
					result.setThemeId(path.getThemeId());
					result = LayoutLocalServiceUtil.updateLookAndFeel(groupId,
							false, result.getLayoutId(), path.getThemeId(), "01", "", false);
				} else
					m_objLog.warn("Did not find theme: " + path.getThemeId() + " for url "
							+ path.getPath());
	
				LayoutTemplate template = getLayoutTemplate(path.getTemplateId());
				
				LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) result
						.getLayoutType();
				if (template != null) {
					layoutTypePortlet.setLayoutTemplateId(0, path.getTemplateId(), false);
					m_objLog.debug("Set layout template: "
							+ template.getLayoutTemplateId() + " for url "
							+ path.getPath());
				} else
					m_objLog.warn("Did not find layout template: " + path.getTemplateId()
							+ " for url " + path.getPath());

			} else {
				// set the value of the "link to page"
				UnicodeProperties props = result.getTypeSettingsProperties();
				props.put( "url", path.getTitle() );
				result.setTypeSettingsProperties( props );
				LayoutLocalServiceUtil.updateLayout( result ); // 
			}
			
			m_objLog.debug("Added layout for url " + actualPath + ", group: "
					+ groupId + ", company: " + companyId + ", user: "
					+ adminId);

			updatePermissions(result, path);
			
		} catch (Throwable t) {
			m_objLog.error(t);
		}
		return result;
	}
	
	public static String addPortletToPage(Layout layout, String portletId, E_ContextPath path, long userId) {
		String result = null;
		try {
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
			
			// count all portlets currently registered for this column
			List<Portlet> portlets = layoutTypePortlet.getAllPortlets(path.getColumnId());
			int colSize = portlets != null ? portlets.size() : 0;
			// add new portlet at the very end
			result = layoutTypePortlet.addPortletId(userId, portletId, path.getColumnId(), colSize, false);
			
			// update the layout
			LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
                    layout.isPrivateLayout(),
                    layout.getLayoutId(),
                    layout.getTypeSettings());
			
		} catch (Throwable t) {
			m_objLog.warn(t);
		}
		return result;
	}
	
	public static void updatePermissions(Layout layout, E_ContextPath path) throws Exception {

		long companyId = layout.getCompanyId();

		/*Role guest = RoleLocalServiceUtil.getRole(companyId,
				RoleConstants.GUEST);*/

		String[] actionIds = new String[] { ActionKeys.VIEW };

		String name = Layout.class.getName();
		int scope = ResourceConstants.SCOPE_INDIVIDUAL;
		String primKey = String.valueOf(layout.getPrimaryKey());

		if (path.getRoles() != null) {
			boolean hasGuest = false;
			// remove regular site member role (restrict page down to specific roles only)
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId,
					name,
					scope,
					primKey,
					RoleLocalServiceUtil.getRole(companyId,
							RoleConstants.SITE_MEMBER).getRoleId(), new String[0]);
			
			for (E_Role role: path.getRoles()) {
				Role roleObj = RoleLocalServiceUtil.getRole(companyId,CustomPortalServiceHandler.getRoleName(role));
				if (roleObj != null) {
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
						companyId,
						name,
						scope,
						primKey,
						roleObj.getRoleId(), actionIds);
				}
				hasGuest |= role.equals(E_Role.SITEGUEST);
			}
			if (!hasGuest) {
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
						companyId,
						name,
						scope,
						primKey,
						RoleLocalServiceUtil.getRole(companyId,
								RoleConstants.GUEST).getRoleId(), new String[0]);
			}
		} 
		// if no roles specified, allow regular users only
		else {
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId,
					name,
					scope,
					primKey,
					RoleLocalServiceUtil.getRole(companyId,
							RoleConstants.GUEST).getRoleId(), new String[0]);
			
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId,
					name,
					scope,
					primKey,
					RoleLocalServiceUtil.getRole(companyId,
							RoleConstants.POWER_USER).getRoleId(), actionIds);
	
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId,
					name,
					scope,
					primKey,
					RoleLocalServiceUtil.getRole(companyId,
							RoleConstants.SITE_MEMBER).getRoleId(), actionIds);
		}

	}
	
	/*public static Group checkParticityGroup() throws PortalException, SystemException {
		Group group = getParticityGroup();

		// create new group if required
		if (group == null) {
			Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil
					.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			long adminId = company.getDefaultUser().getUserId();
			List<Group> groups = GroupLocalServiceUtil.getGroups(company.getCompanyId(), GroupConstants.DEFAULT_PARENT_GROUP_ID, true);
			for (Group grp: groups) {
				if (grp.getType() == GroupConstants.TYPE_SITE_OPEN) {
					group = grp;
					m_objLog.debug("Found group "+group.getName()+" with url "+group.getFriendlyURL());
					// remove the default "Welcome" page
					List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(grp.getGroupId(), false, com.liferay.portal.model.LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
					if (layouts != null) {
						for (Layout layout: layouts) {
							if (layout.getName(Locale.ENGLISH,true).equals("Welcome")) {
								LayoutLocalServiceUtil.deleteLayout(layout);
								//m_objLog.debug("Removed welcome layout");
							} 
						}
					}
				}
			}
			
			// create a custom site, if defaults do not exist
			if (group == null) {
				ServiceContext ctx = new ServiceContext();
				group = GroupLocalServiceUtil.addGroup(adminId, GroupConstants.DEFAULT_PARENT_GROUP_ID, Group.class.getName(), 0, GroupConstants.DEFAULT_LIVE_GROUP_ID, 
						PARTICITY_GROUP_NAME, PARTICITY_GROUP_NAME, GroupConstants.TYPE_SITE_OPEN, true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION, "/particity", true, true, ctx);
			}
			
			LayoutSet layoutsets = LayoutSetLocalServiceUtil.getLayoutSet(
					group.getGroupId(), false);
			layoutsets.setThemeId(E_ContextPath.getDefaultThemeName());
			layoutsets.setColorSchemeId("01");
			LayoutSetLocalServiceUtil.updateLayoutSet(layoutsets);
			
			//LayoutSetLocalServiceUtil.updateLayoutSetPrototypeLinkEnabled(group.getGroupId(), false, true, layoutsets.getUuid());

			//List newLayouts = LayoutLocalServiceUtil.getLayouts(group.getGroupId(), false, LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
			m_objLog.debug("Created/modfied group "+group.getName()+", "+group.getDescriptiveName());
		} else 
			m_objLog.debug("Found group "+PARTICITY_GROUP_NAME);
		return group;
	}*/
	
	/*public static Group getParticityGroup() throws SystemException {
		Group group = null;

		// check for existing group
		List<Group> groups = GroupLocalServiceUtil.getGroups(
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Group grp : groups) {
			if (grp.getName().equals(PARTICITY_GROUP_NAME)) {
				group = grp;
				break;
			}
		}

		return group;
	}*/
	
	public static JournalArticle getArticle(long groupId, String name) {
		JournalArticle result = null;
		
		try {
			List<JournalArticle>  articles = JournalArticleServiceUtil.getArticlesByArticleId(groupId, name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
			//JournalArticleServiceUtil.getArticles(groupId, 0);
			if (articles != null) {
				for (JournalArticle article: articles) {
					if (article.getArticleId().equals(name)) {
						result = article;
						break;
					}
				}
			}
		} catch (Throwable t) {}
		
		return result;
	}
	
	public static JournalArticle addArticle(long userId, long groupId, String name, String title, String srcContent) {
		JournalArticle result = null;
		try {
			
				Locale defLocale = LocaleUtil.getDefault();
				if (defLocale == null)
					defLocale = Locale.GERMAN;
		
				String localShort = defLocale.getLanguage()+"_"+defLocale.getCountry();
				
				
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(defLocale, title);
				
				
				
				//titleMap.put(Locale.GERMAN, title);
				//titleMap.put(Locale.ENGLISH, title);
				
				ServiceContext ctx = new ServiceContext();
				ctx.setScopeGroupId(groupId);
				
				String content = "<?xml version=\"1.0\"?><root available-locales=\""+localShort+"\" default-locale=\""+localShort+"\"><static-content language-id=\""+localShort+"\"><![CDATA[ "+srcContent+" ]]></static-content></root>";
				
				String lid = LocalizationUtil.getDefaultLocale(content);
				Locale defaultLocale = LocaleUtil.fromLanguageId(lid);
						
				m_objLog.debug("Adding title for locale "+defLocale+", short "+localShort+" with lid "+lid+" and defaultLocale "+defaultLocale+" with content "+title);

				
				result = JournalArticleLocalServiceUtil.addArticle(
				    userId,
				    groupId,
				    0, // folder id
				    0, 0, //classNameId, classPK, 
				    name, //articleId, 
				    false, //autoArticleId, 
				    JournalArticleConstants.VERSION_DEFAULT, 
				    titleMap,
				    null, //descriptionMap,
				    content, 
				    "general", // type, 
				    null,
				    null, // templateId, 
				    StringPool.BLANK, //layoutUuid,
				    1, 1, 1970, 0, 0, // displayDateMonth, displayDateDay, displayDateYear, 
				                      // displayDateHour, displayDateMinute, 
				    0, 0, 0, 0, 0, true, // expirationDateMonth, expirationDateDay, 
				                         // expirationDateYear, expirationDateHour, 
				                         //expirationDateMinute, neverExpire, 
				    0, 0, 0, 0, 0, true, // reviewDateMonth, reviewDateDay, reviewDateYear, 
				                        //reviewDateHour, reviewDateMinute, neverReview, 
				    true, // indexable, 
				    false, StringPool.BLANK, null, // smallImage, smallImageURL, smallImageFile, 
				    null, StringPool.BLANK, // images, articleURL,
				    ctx
				    );
				
		} catch (Throwable t) {
			m_objLog.warn(t);
		}
		return result;
	}
	
	public static boolean checkArticleOnLayout(Layout layout, String articleId, String columnId, long companyId) {
		boolean result = false;
		
		try {

			long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
			
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();

			List<Portlet> portlets = layoutTypePortlet.getAllPortlets(columnId);
			if (portlets != null) {
				for (Portlet portlet: portlets) {
					//m_objLog.debug("Found portlet "+portlet.getPortletId()+" =? "+PortletKeys.JOURNAL_CONTENT);
					if (portlet.getPortletId().startsWith(PortletKeys.JOURNAL_CONTENT+"_INSTANCE")) {
						PortletPreferences prefs = PortletPreferencesLocalServiceUtil.getPreferences(companyId,
				                ownerId,
				                ownerType,
				                layout.getPlid(),
				                portlet.getPortletId());
						String jArticleId = prefs.getValue("articleId", "");
						if (jArticleId.equals(articleId)) {
							result = true;
							break;
						}
					}
				}
			}
		} catch (Throwable t) {
			m_objLog.warn(t);
		}
		return result;
	}
	
	public static String addArticle(E_ContextPath path, JournalArticle article, Layout layout, long userId, long groupId, long companyId) {
		String journalPortletId = null;
		try {
			journalPortletId = addPortletToPage(layout, PortletKeys.JOURNAL_CONTENT, path, userId);

			setPortletArticle(journalPortletId, article.getArticleId() ,layout, userId, groupId, companyId);

		} catch (Throwable t) {
			journalPortletId = null;
			m_objLog.warn(t);
		}
		return journalPortletId;
	}
	
	public static void setPortletArticle(String portletId, String articleId, Layout layout, long userId, long groupId, long companyId) {
		try {
	
			long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
	
			//Retrieve the portlet preferences for the journal portlet instance just created
			PortletPreferences prefs = PortletPreferencesLocalServiceUtil.getPreferences(companyId,
	                ownerId,
	                ownerType,
	                layout.getPlid(),
					portletId);
	
			// set desired article id for content display portlet
			prefs.setValue("articleId", articleId);
			prefs.setValue("groupId", String.valueOf(groupId));
	
			//update the portlet preferences
			PortletPreferencesLocalServiceUtil.updatePreferences(ownerId, ownerType, layout
			                .getPlid(), portletId, prefs);
		} catch (Throwable t) {
			m_objLog.warn(t);
		}
	}
	
	
	
	public static User getDefaultAdmin(long companyId) {
		User result = null;
        Role role = null;
        try {
            role = RoleLocalServiceUtil.getRole(companyId, RoleConstants.ADMINISTRATOR);
            List<User> admins = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            if (admins != null && admins.size() > 0)
            	result = admins.get(0);
        } catch (final Exception e) {
            m_objLog.error("Utils::getAdmin Exception", e);
        }
        return result;
    }

	public static void test() {
		try {
			if (globalCompanyId == -1)
				initGlobals();
	
			Layout layout = getLayout(globalGroupId, E_ContextPath.HOME.getPath());
			
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
	
			List<Portlet> portlets = layoutTypePortlet.getAllPortlets();
			if (portlets != null) {
				for (Portlet portlet: portlets) {
					m_objLog.debug("Found portlet "+portlet.getPortletId()+" =? "+PortletKeys.JOURNAL_CONTENT);
					if (portlet.getPortletId().startsWith(E_SampleContent.FRONTEND_HEADER.getDataPath())) {
	
						long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
						int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
				
						PortletPreferences prefs = PortletPreferencesLocalServiceUtil.getPreferences(globalCompanyId,
				                ownerId,
				                ownerType,
				                layout.getPlid(),
				                portlet.getPortletId());
						
						if (prefs != null) {
							Enumeration<String> names = prefs.getNames();
							while (names.hasMoreElements()) {
								String name = names.nextElement();
								m_objLog.debug("Got preference "+name+"="+prefs.getValue(name, "N/A"));
							}
						} else {
							m_objLog.debug("Could not extract portlet prefs!");
						}
					}
				}
			}
		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
}

package de.fraunhofer.fokus.oefit.particity.portlet.init;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletPreferences;

import org.apache.commons.io.IOUtils;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
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
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutTemplateLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ThemeLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalArticleServiceUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

public class ParticityInitializer {

	private static final String PARTICITY_GROUP_NAME = "Particity";
	
	private static Log m_objLog = LogFactoryUtil.getLog(ParticityInitializer.class);
	
	public static void init() {
		if (!isWizardAvailable()) {
			m_objLog.warn("Setup wizard was already initialized before. Delete portlet painit to remove this message for future server restarts.");
			return;
		}
			
		
		try {
			// debug-list available portlets
			/*List<Portlet> portlets = PortletLocalServiceUtil.getPortlets();
			for (Portlet portlet: portlets)
				m_objLog.info("Found portlet: "+portlet.getPortletId());*/
			
			// get default company
			Group pGroup = checkParticityGroup();
			long globalCompanyId = -1;
			long globalGroupId = -1;
			long globalAdminId = -1;
			Company company = null;
			if (pGroup != null) {
				company = CompanyLocalServiceUtil.getCompany(pGroup.getCompanyId()); 
			} else {
				company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
				// fallback
				if (company == null)
					company = CompanyLocalServiceUtil.getCompany(PortalUtil.getDefaultCompanyId());	
			}
			
			globalCompanyId = company.getCompanyId();
			globalGroupId = pGroup.getGroupId();
			globalAdminId = company.getDefaultUser().getUserId(); 
			
			
			// initialize roles
			Map<E_Role, Role> roles = getRoles(globalAdminId, globalCompanyId);
			// initialize sites
			Map<E_ContextPath, Layout> layouts = getLayouts(globalGroupId, globalAdminId, globalCompanyId);
			// add administrator
			User adminUser = CustomPortalServiceHandler.createPortalUser("Particity", "Administrator", "admin@particity.de", globalCompanyId, pGroup.getGroupId(), Locale.GERMAN, false, "test", true);
			// remove liferay admin
			try {
				User defaultAdmin = UserLocalServiceUtil.getUserByEmailAddress(globalCompanyId, "test@liferay.com");
				if (defaultAdmin != null)
					UserLocalServiceUtil.deleteUser(defaultAdmin.getUserId());
			} catch (NoSuchUserException e) {}
			// add sample content
			initSampleContent(globalGroupId, globalAdminId, globalCompanyId, layouts);
			
			// call initialization of additional settings that require initialization, even if this wizard is not available
			CustomPortalServiceHandler.checkInit(globalGroupId, globalAdminId);
			// set wizard flag to prevent additional runs of this method on future restarts
			CustomPortalServiceHandler.setConfig(E_ConfigKey.WIZARDFLAG, "true");

		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	/**
	 * Checks if the wizard was already run. Uses a portlet configuration setting.
	 *
	 * @return true, if wizard was already run once without error, false otherwise
	 */
	public static boolean isWizardAvailable() {
		final String cfgVal = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.WIZARDFLAG);
		return cfgVal != null && cfgVal.equals("true");
	}
	
	public static void initSampleContent(long groupId, long adminId, long companyId, Map<E_ContextPath, Layout> layouts) {
		Layout layout = null;
		for (E_SampleContent content: E_SampleContent.values()) {
			try {
				// add portlet to page
				if (content.isPorlet()) {
					layout = layouts.get(content.getContext());
					if (layout != null) {
						addPortletToPage(layout, content.getDataPath(), content.getContext(), adminId);
						m_objLog.info("Added sample content "+content.name()+" with portlet "+content.getDataPath()+" for URL "+content.getContext().getPath());
					} else
						m_objLog.info("Could not find layout for sample content context path "+content.getContext().getPath());
					
				} 
				// import HTML as article + add to page
				else {
					InputStream frontend = ParticityInitializer.class.getResourceAsStream(content.getDataPath());
					if (frontend != null) {
						String contentSrc = IOUtils.toString(frontend);
						if (contentSrc != null) {
							JournalArticle article = getArticle(groupId, content.name());
							if (article == null)
								article = addArticle(adminId, groupId, content.name(), content.getTitle(), contentSrc);
							if (article != null) {
								layout = layouts.get(content.getContext());
								if (layout != null) {
									// check if article not added yet
									if (!checkArticleOnLayout(layout, article.getArticleId(), content.getContext().getColumnId(), companyId)) {
										addArticle(content.getContext(), article,layout, adminId, groupId, companyId);
										m_objLog.info("Added sample content "+content.name()+" for URL "+content.getContext().getPath());
									} else {
										m_objLog.info("Found existing sample content "+content.name()+" for URL "+content.getContext().getPath());
									}
								} else {
									m_objLog.info("Could not find layout for sample content context path "+content.getContext().getPath());			
								}
							} else {
								m_objLog.info("Could not create sample content "+content.name()+" for URL "+content.getContext().getPath()+" (already exists?) ");
							}
						}
					} else {
						m_objLog.info("Could not load sample content "+content.name()+" for URL "+content.getContext().getPath()+" from "+content.getDataPath());
					}
				}
			} catch (Throwable t) {
				m_objLog.warn(t);
			}
		}
	}
	
	public static Map<E_ContextPath, Layout> getLayouts(long groupId, long adminId, long companyId) {
		Map<E_ContextPath, Layout> result = new HashMap<E_ContextPath, Layout>();
		
		for (E_ContextPath pth: E_ContextPath.values()) {
			Layout layout = getLayout(groupId, pth.getPath());
			if (layout == null) {
				layout = createLayout(adminId, companyId, groupId, pth);
				m_objLog.info("Created layout for URL "+pth.getPath());
			} else
				m_objLog.info("Found layout for URL "+pth.getPath());
			result.put(pth, layout);
		}
		return result;
	}
	
	public static Map<E_Role, Role> getRoles(long adminUserId, long companyId) {
		Map<E_Role,Role> result = new HashMap<E_Role, Role>();
		for (E_Role role: E_Role.values()) {
			if (!role.equals(E_Role.NULL)) {
				Role lrRole = CustomPortalServiceHandler.checkRole(adminUserId, companyId, role.getName(), RoleConstants.TYPE_REGULAR);
				result.put(role, lrRole);
				m_objLog.info("Got role "+lrRole.getName());
			}
		}
		return result;
	}
	
	public static Layout getLayout(long groupId, String context) {
		Layout result = null;
		try {
			result = LayoutLocalServiceUtil.getFriendlyURLLayout(groupId,
					false, context);
			m_objLog.warn("Found layout registered for group " + groupId
					+ " and url " + context);
		} catch (Throwable t) {
			m_objLog.debug("No layout registered for group " + groupId
					+ " with url " + context);
		}
		return result;
	}
	
	public static Layout createLayout(long adminId, long companyId, long groupId, E_ContextPath path) {
		Layout result = null;
		
		boolean privateLayout = false;
		long parentLayoutId = com.liferay.portal.model.LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;
		String description = null;
		String type = LayoutConstants.TYPE_PORTLET;
		ServiceContext ctx = new ServiceContext();

		try {
			
			result = LayoutLocalServiceUtil.addLayout(adminId, groupId,
					privateLayout, parentLayoutId, path.getName(), path.getTitle(), description,
					type, path.isHidden(), path.getPath(), ctx);

			// layout.setLayoutPrototypeLinkEnabled(false);

			List<Theme> themes = ThemeLocalServiceUtil.getThemes(companyId);
			Theme theme = null;
			for (Theme thm : themes) {
				if (thm.getThemeId().equals(path.getThemeId())) {
					theme = thm;
					break;
				} 
				 else {
				 m_objLog.debug("Found theme: "+thm.getThemeId()+" with name "+thm.getName()); }
			}
			if (theme != null) {
				result.setThemeId(path.getThemeId());
				result = LayoutLocalServiceUtil.updateLookAndFeel(groupId,
						false, result.getLayoutId(), path.getThemeId(), "01", "", false);
			} else
				m_objLog.warn("Did not find theme: " + path.getThemeId() + " for url "
						+ path.getPath());

			List<LayoutTemplate> ltemplates = LayoutTemplateLocalServiceUtil
					.getLayoutTemplates();
			LayoutTemplate template = null;
			for (LayoutTemplate ltmplt : ltemplates) {
				if (ltmplt.getLayoutTemplateId().equals(path.getTemplateId())) {
					template = ltmplt;
					break;
				} else
					m_objLog.debug("Found template: "+ltmplt.getName()+", "+ltmplt.getLayoutTemplateId());
			}
			
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

			m_objLog.info("Added layout for url " + path.getPath() + ", group: "
					+ groupId + ", company: " + companyId + ", user: "
					+ adminId);

			updatePermissions(result, path);
			
		} catch (Throwable t) {
			t.printStackTrace();
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
			for (String role: path.getRoles()) {
				Role roleObj = RoleLocalServiceUtil.getRole(companyId,role);
				if (roleObj != null) {
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
						companyId,
						name,
						scope,
						primKey,
						roleObj.getRoleId(), actionIds);
				}
				hasGuest |= role.equals(RoleConstants.GUEST);
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
	
	public static Group checkParticityGroup() throws PortalException, SystemException {
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
					m_objLog.info("Found group "+group.getName()+" with url "+group.getFriendlyURL());
					// remove the default "Welcome" page
					List<Layout> layouts = LayoutLocalServiceUtil.getLayouts(grp.getGroupId(), false, com.liferay.portal.model.LayoutConstants.DEFAULT_PARENT_LAYOUT_ID);
					if (layouts != null) {
						for (Layout layout: layouts) {
							if (layout.getName(Locale.ENGLISH,true).equals("Welcome")) {
								LayoutLocalServiceUtil.deleteLayout(layout);
								//m_objLog.info("Removed welcome layout");
							} /*else {
								m_objLog.info("Ignored existing layout "+layout.getName()+" and friendly url "+layout.getFriendlyURL());
							}*/
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
			m_objLog.info("Created/modfied group "+group.getName()+", "+group.getDescriptiveName());
		} else 
			m_objLog.info("Found group "+PARTICITY_GROUP_NAME);
		return group;
	}
	
	public static Group getParticityGroup() throws SystemException {
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
	}
	
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
		
				String localShort = defLocale.getCountry()+"_"+defLocale.getLanguage();
				
				
				Map<Locale, String> titleMap = new HashMap<Locale, String>();
				titleMap.put(defLocale, title);
				
				ServiceContext ctx = new ServiceContext();
				ctx.setScopeGroupId(groupId);
				
				String content = "<?xml version=\"1.0\"?><root available-locales=\""+localShort+"\" default-locale=\""+localShort+"\"><static-content language-id=\""+localShort+"\"><![CDATA[ "+srcContent+" ]]></static-content></root>";
				
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
					//m_objLog.info("Found portlet "+portlet.getPortletId()+" =? "+PortletKeys.JOURNAL_CONTENT);
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
	
			long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
			int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;
	
			//Retrieve the portlet preferences for the journal portlet instance just created
			PortletPreferences prefs = PortletPreferencesLocalServiceUtil.getPreferences(companyId,
	                ownerId,
	                ownerType,
	                layout.getPlid(),
	                journalPortletId);
	
			// set desired article id for content display portlet
			prefs.setValue("articleId", article.getArticleId());
			prefs.setValue("groupId", String.valueOf(groupId));
	
			//update the portlet preferences
			PortletPreferencesLocalServiceUtil.updatePreferences(ownerId, ownerType, layout
			                .getPlid(), journalPortletId, prefs);
		} catch (Throwable t) {
			journalPortletId = null;
			m_objLog.warn(t);
		}
		return journalPortletId;
	}
}

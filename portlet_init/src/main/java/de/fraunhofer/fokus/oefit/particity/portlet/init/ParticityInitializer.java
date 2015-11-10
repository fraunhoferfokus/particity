package de.fraunhofer.fokus.oefit.particity.portlet.init;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
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
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ThemeLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

public class ParticityInitializer {

	private static final String PARTICITY_GROUP_NAME = "Particity";
	
	private static Log m_objLog = LogFactoryUtil.getLog(ParticityInitializer.class);
	
	public static void init() {
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
			User defaultAdmin = UserLocalServiceUtil.getUserByEmailAddress(globalCompanyId, "test@liferay.com");
			if (defaultAdmin != null)
				UserLocalServiceUtil.deleteUser(defaultAdmin.getUserId());
			
			
		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	public static Map<E_ContextPath, Layout> getLayouts(long groupId, long adminId, long companyId) {
		Map<E_ContextPath, Layout> result = new HashMap<E_ContextPath, Layout>();
		
		for (E_ContextPath pth: E_ContextPath.values()) {
			Layout layout = getLayout(groupId, pth.getPath());
			if (layout == null) {
				createLayout(adminId, companyId, groupId, pth);
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
	
	public static void createLayout(long adminId, long companyId, long groupId, E_ContextPath path) {
		boolean privateLayout = false;
		long parentLayoutId = com.liferay.portal.model.LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;
		String description = null;
		String type = LayoutConstants.TYPE_PORTLET;
		ServiceContext ctx = new ServiceContext();
		//ctx.setUuid(templateId);
		// ctx.setAttribute("inheritFromParentLayoutId", Boolean.FALSE);

		try {
			
			Layout layout = LayoutLocalServiceUtil.addLayout(adminId, groupId,
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
				layout.setThemeId(path.getThemeId());
				/*
				 * layout.setLayoutPrototypeLinkEnabled(false);
				 * UnicodeProperties props = layout.getTypeSettingsProperties();
				 * for (String key: props.keySet())
				 * m_objLog.debug("Prop: "+key+"="+props.get(key)); layout
				 * =LayoutLocalServiceUtil.updateLayout(layout);
				 */
				layout = LayoutLocalServiceUtil.updateLookAndFeel(groupId,
						false, layout.getLayoutId(), path.getThemeId(), "01", "", false);
				/*
				 * LayoutSet set = layout.getLayoutSet(); if (set != null) {
				 * set.setThemeId(themeId);
				 * LayoutSetLocalServiceUtil.updateLayoutSet(set);
				 * //LayoutSetUtil.update(set, true);
				 * m_objLog.debug("Update layout set for url " + friendlyURL); }
				 */
				/*m_objLog.debug("Set theme: " + theme.getThemeId() + " for url "
						+ friendlyURL);*/
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
			
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();
			if (template != null) {
				layoutTypePortlet.setLayoutTemplateId(0, path.getTemplateId(), false);
				m_objLog.debug("Set layout template: "
						+ template.getLayoutTemplateId() + " for url "
						+ path.getPath());
			} else
				m_objLog.warn("Did not find layout template: " + path.getTemplateId()
						+ " for url " + path.getPath());

			// LayoutLocalServiceUtil.updateLayout(layout);

			/*Portlet portlet = null;
			if (path.getPortletId() != null) {
				try {
					portlet = PortletLocalServiceUtil.getPortletById(path.getPortletId());
				} catch (Throwable t) {
					m_objLog.warn("Could not add unknown portlet " + path.getPortletId()
							+ " to context " + path.getPath());
				}
			}
			if (portlet != null) {*/
			
			// add portlet whether it is deployed or not
				layoutTypePortlet.addPortletId(0, path.getPortletId(), false);

				// long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
				// int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;

				//m_objLog.debug("Added portlet " + path.getPortletId() + " to context "
					//	+ path.getPath());

				/*
				 * PortletPreferences portletSetup =
				 * PortletPreferencesFactoryUtil.getLayoutPortletSetup( layout,
				 * portletId);
				 * 
				 * portletSetup.setValue("portletSetupShowBorders",
				 * String.valueOf(Boolean.FALSE)); portletSetup.store();
				 */

				// LayoutLocalServiceUtil.updateLayout(layout);
			/*} else {
				m_objLog.debug("Did not find portlet " + path.getPortletId() + " for context "
						+ path.getPath());
			}*/
			m_objLog.info("Added layout for url " + path.getPath() + ", group: "
					+ groupId + ", company: " + companyId + ", user: "
					+ adminId+" with portlet "+path.getPortletId());
			// layout = LayoutLocalServiceUtil.updateLookAndFeel(groupId, false,
			// layout.getLayoutId(), themeId, layout.getColorSchemeId(),
			// layout.getCss(), false);
			layout = LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
					layout.isPrivateLayout(), layout.getLayoutId(),
					layout.getTypeSettings());

			updatePermissions(layout, path);
			//layout = LayoutLocalServiceUtil.updateLayout(layout);
		} catch (Throwable t) {
			t.printStackTrace();
		}
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

}

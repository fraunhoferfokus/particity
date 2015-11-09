package de.fraunhofer.fokus.oefit.particity.portlet.init;

import java.util.HashMap;
import java.util.List;
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
import com.liferay.portal.util.PortalUtil;

import de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler;
import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

public class ParticityInitializer {

	private static final String PARTICITY_GROUP_NAME = "Particity";
	
	private static Log m_objLog = LogFactoryUtil.getLog(ParticityInitializer.class);
	
	public static void init() {
		try {
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
			globalGroupId = company.getGroup().getGroupId();
			globalAdminId = company.getDefaultUser().getUserId(); 
			
			// initialize roles
			Map<E_Role, Role> roles = getRoles(globalAdminId, globalCompanyId);
			// initialize sites
			Map<E_ContextPath, Layout> layouts = getLayouts(globalGroupId, globalAdminId, globalCompanyId);
			
		} catch (Throwable t) {
			m_objLog.error(t);
		}
	}
	
	public static Map<E_ContextPath, Layout> getLayouts(long groupId, long adminId, long companyId) {
		Map<E_ContextPath, Layout> result = new HashMap<E_ContextPath, Layout>();
		
		for (E_ContextPath pth: E_ContextPath.values()) {
			Layout layout = getLayout(groupId, pth.getPath());
			if (layout == null) {
				createLayout(adminId, companyId, groupId, pth.getThemeId(), pth.getTemplateId(), pth.getPortletId(), pth.getName(), pth.getTitle(), pth.getPath(), true, false);
			}
			result.put(pth, layout);
		}
		return result;
	}
	
	public static Map<E_Role, Role> getRoles(long adminUserId, long companyId) {
		Map<E_Role,Role> result = new HashMap<E_Role, Role>();
		for (E_Role role: E_Role.values()) {
			Role lrRole = CustomPortalServiceHandler.checkRole(adminUserId, companyId, role.getName());
			result.put(role, lrRole);
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
	
	public static void createLayout(long adminId, long companyId, long groupId,
			String themeId, String templateId, String portletId, String name,
			String title, String friendlyURL, boolean hidden,
			boolean allowGuests) {
		boolean privateLayout = false;
		long parentLayoutId = com.liferay.portal.model.LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;
		String description = null;
		String type = LayoutConstants.TYPE_PORTLET;
		ServiceContext ctx = new ServiceContext();
		//ctx.setUuid(templateId);
		// ctx.setAttribute("inheritFromParentLayoutId", Boolean.FALSE);

		try {
			Layout layout = LayoutLocalServiceUtil.addLayout(adminId, groupId,
					privateLayout, parentLayoutId, name, title, description,
					type, hidden, friendlyURL, ctx);

			// layout.setLayoutPrototypeLinkEnabled(false);

			List<Theme> themes = ThemeLocalServiceUtil.getThemes(companyId);
			Theme theme = null;
			for (Theme thm : themes) {
				if (thm.getThemeId().equals(themeId)) {
					theme = thm;
					break;
				} 
				 else {
				 m_objLog.debug("Found theme: "+thm.getThemeId()+" with name "+thm.getName()); }
			}
			if (theme != null) {
				layout.setThemeId(themeId);
				/*
				 * layout.setLayoutPrototypeLinkEnabled(false);
				 * UnicodeProperties props = layout.getTypeSettingsProperties();
				 * for (String key: props.keySet())
				 * m_objLog.debug("Prop: "+key+"="+props.get(key)); layout
				 * =LayoutLocalServiceUtil.updateLayout(layout);
				 */
				layout = LayoutLocalServiceUtil.updateLookAndFeel(groupId,
						false, layout.getLayoutId(), themeId, "01", "", false);
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
				m_objLog.warn("Did not find theme: " + themeId + " for url "
						+ friendlyURL);

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
			
			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();
			if (template != null) {
				layoutTypePortlet.setLayoutTemplateId(0, templateId, false);
				m_objLog.debug("Set layout template: "
						+ template.getLayoutTemplateId() + " for url "
						+ friendlyURL);
			} else
				m_objLog.warn("Did not find layout template: " + templateId
						+ " for url " + friendlyURL);

			// LayoutLocalServiceUtil.updateLayout(layout);

			Portlet portlet = null;
			if (portletId != null) {
				try {
					portlet = PortletLocalServiceUtil.getPortletById(portletId);
				} catch (Throwable t) {
					m_objLog.warn("Could not add unknown portlet " + portletId
							+ " to context " + friendlyURL);
				}
			}
			if (portlet != null) {
				layoutTypePortlet
						.addPortletId(0, portlet.getPortletId(), false);

				// long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
				// int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;

				m_objLog.debug("Added portlet " + portletId + " to context "
						+ friendlyURL);

				/*
				 * PortletPreferences portletSetup =
				 * PortletPreferencesFactoryUtil.getLayoutPortletSetup( layout,
				 * portletId);
				 * 
				 * portletSetup.setValue("portletSetupShowBorders",
				 * String.valueOf(Boolean.FALSE)); portletSetup.store();
				 */

				// LayoutLocalServiceUtil.updateLayout(layout);
			}
			m_objLog.info("Added layout for url " + friendlyURL + ", group: "
					+ groupId + ", company: " + companyId + ", user: "
					+ adminId+" with portlet "+portletId);
			// layout = LayoutLocalServiceUtil.updateLookAndFeel(groupId, false,
			// layout.getLayoutId(), themeId, layout.getColorSchemeId(),
			// layout.getCss(), false);
			layout = LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
					layout.isPrivateLayout(), layout.getLayoutId(),
					layout.getTypeSettings());

			updatePermissions(layout, true, allowGuests);
			layout = LayoutLocalServiceUtil.updateLayout(layout);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static void updatePermissions(Layout layout, boolean addDefaultActionIds,
			boolean allowGuests) throws Exception {

		long companyId = layout.getCompanyId();

		Role guest = RoleLocalServiceUtil.getRole(companyId,
				RoleConstants.GUEST);

		String[] actionIds = new String[0];

		String name = Layout.class.getName();
		int scope = ResourceConstants.SCOPE_INDIVIDUAL;
		String primKey = String.valueOf(layout.getPrimaryKey());

		/*
		 * Resource resource = ResourceLocalServiceUtil.getResource(companyId,
		 * name, scope, primKey);
		 */
		if (addDefaultActionIds) {
			actionIds = new String[] { ActionKeys.VIEW };
		}

		if (allowGuests) {
			/*
			 * PermissionLocalServiceUtil.setRolePermissions(guest.getRoleId(),
			 * actionIds, resource.getResourceId());
			 */
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId, name, scope, primKey, guest.getRoleId(),
					actionIds);
		} else {
			/*
			 * PermissionLocalServiceUtil.setRolePermissions(guest.getRoleId(),
			 * new String[]{}, resource.getResourceId());
			 */
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId, name, scope, primKey, guest.getRoleId(),
					new String[] {});
		}

		/*
		 * PermissionLocalServiceUtil.setRolePermissions(RoleLocalServiceUtil
		 * .getRole(companyId, RoleConstants.POWER_USER).getRoleId(), actionIds,
		 * resource.getResourceId());
		 */

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

		/*
		 * PermissionLocalServiceUtil.setRolePermissions(
		 * RoleLocalServiceUtil.getRole(companyId,
		 * RoleConstants.SITE_MEMBER).getRoleId(), actionIds,
		 * resource.getResourceId());
		 */
	}
	
	public static Group checkParticityGroup() throws PortalException, SystemException {
		Group group = getParticityGroup();

		// create new group if required
		/*if (group != null) {
			company = CompanyLocalServiceUtil.getCompany(group
					.getCompanyId());
			adminId = company.getDefaultUser().getUserId();*/
		if (group == null) {
			Company company = CompanyLocalServiceUtil.getCompanyByWebId(PropsUtil
					.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			long adminId = company.getDefaultUser().getUserId();

			ServiceContext ctx = new ServiceContext();
			group = GroupLocalServiceUtil.addGroup(adminId,
					Group.class.getName(), 0,
					PARTICITY_GROUP_NAME, PARTICITY_GROUP_NAME,
					GroupConstants.TYPE_SITE_OPEN, "", true, true, ctx);

			LayoutSet layoutsets = LayoutSetLocalServiceUtil.getLayoutSet(
					group.getGroupId(), false);
			layoutsets.setThemeId(E_ContextPath.getDefaultThemeName());
			layoutsets.setColorSchemeId("01");
			LayoutSetLocalServiceUtil.updateLayoutSet(layoutsets);
		}
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

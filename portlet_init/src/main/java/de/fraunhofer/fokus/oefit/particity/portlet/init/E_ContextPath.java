package de.fraunhofer.fokus.oefit.particity.portlet.init;

import com.liferay.portal.model.RoleConstants;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

public enum E_ContextPath {

	HOME("/welcome","Home","Home","paheader_WAR_pasiteportlet", true, RoleConstants.GUEST),
	SEARCH("/suche","Suche","Suche","pasearch_WAR_pasearchportlet", true, RoleConstants.GUEST),
	ADM("/int/administration","Administration","Administration","paadmin_WAR_padataportlet", false, E_Role.ADMIN.getName()),
	ORG("/int/organisation","Organisation","Organisation","paorgmain_WAR_paorgportlet", false, E_Role.ORG.getName()),
	MGMT("/int/verwaltung","Verwaltung","Verwaltung","pamgmt_WAR_pamgmtportlet", false,E_Role.MGMT.getName()),
	PROFILE("/int/profile","Profil","Profil","paloginprofile_WAR_pasiteportlet",false),
	ORG_REGISTRATION("/register/organization","Organisation Registration","Organisation Registrierung","paorgregistration_WAR_paorgportlet", true, RoleConstants.GUEST),
	USR_REGISTRATION("/register/user","Newsletter Registration","Newsletter Registration","pauserregistration_WAR_panewslportlet", true, RoleConstants.GUEST),
	USR_NEWSLETTER("/newsletter","Newsletter","Newsletter","pausermain_WAR_panewslportlet", true, RoleConstants.GUEST),
	
	;
	
	private static final String DEFAULT_THEME_NAME = "ah_theme_WAR_padefaulttheme";
	
	private String m_strPth;
	private String m_strName;
	private String m_strTitle;
	private String m_strThemeId;
	private String m_strTemplateId;
	private String m_strPortletId;
	private String m_strColumnId;
	private String[] m_objRoles;
	private boolean m_bNavHidden;
	
	private E_ContextPath(String path, String name, String title, String portletId, boolean hiddenFromNav, String... roles) { 
		this(path, name, title, DEFAULT_THEME_NAME, "paAllColumns", "column-1", portletId, hiddenFromNav, roles);
	}
	
	private E_ContextPath(String path, String name, String title, String themeId, String templateId, String columnId, String portletId, boolean hiddenFromNav, String... roles) {
		m_strPth = path;
		m_strName = name;
		m_strTitle = title;
		m_strThemeId = themeId;
		m_strTemplateId = templateId;
		m_strPortletId = portletId;
		m_strColumnId = columnId;
		m_objRoles = roles;
		m_bNavHidden = hiddenFromNav;
	}
	
	public boolean isHidden() {
		return m_bNavHidden;
	}
	
	public String[] getRoles() {
		return m_objRoles;
	}
	
	public String getPath() {
		return m_strPth;
	}
	
	public String getName() {
		return m_strName;
	}
	
	public String getTitle() {
		return m_strTitle;
	}
	
	public String getThemeId() {
		return m_strThemeId;
	}
	
	public String getTemplateId() {
		return m_strTemplateId;
	}
	
	public String getPortletId() {
		return m_strPortletId;
	}
	
	public String getColumnId() {
		return m_strColumnId;
	}
	
	public static String getDefaultThemeName() {
		return DEFAULT_THEME_NAME;
	}
}

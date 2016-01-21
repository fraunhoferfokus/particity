package de.fraunhofer.fokus.oefit.particity.portlet.init;

import com.liferay.portal.model.LayoutConstants;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

public enum E_ContextPath {

	//SETUP("/setup","Setup","Setup", true, E_Role.SITEGUEST),
	HOME("/home","Home","Home", true, E_Role.SITEGUEST),
	SEARCH("/search","Suche","Suche", true, E_Role.SITEGUEST),
	ADM(E_Role.ADMIN.getHomeUrl(),"Administration","Administration", false, E_Role.ADMIN),
	ORG(E_Role.ORG.getHomeUrl(),"Organisation","Organisation", false, E_Role.ORG),
	MGMT(E_Role.MGMT.getHomeUrl(),"Verwaltung","Verwaltung", false,E_Role.MGMT),
	PROFILE("/int/profile","Profil","Profil",false),
	ORG_REGISTRATION("/organization","Organisation Registration","Organisation Registrierung", true, E_Role.SITEGUEST),
	USR_REGISTRATION("/user","Newsletter Registration","Newsletter Registration", true, E_Role.SITEGUEST),
	USR_NEWSLETTER("/newsletter","Newsletter","Newsletter",true, E_Role.SITEGUEST),
	DATAPOLICY("/datenschutz","Datenschutz","Datenschutz", true, E_Role.SITEGUEST),
	LEGALDETAILS("/impressum","Impressum","Impressum", true, E_Role.SITEGUEST),
	LOGOUT(LayoutConstants.TYPE_URL,"/abmelden","Abmelden","/c/portal/logout",false,E_Role.ADMIN, E_Role.ORG, E_Role.MGMT),
	
	;
	
	private static final String DEFAULT_THEME_NAME = "patheme_WAR_padefaulttheme";
	
	private String m_strPth;
	private String m_strName;
	private String m_strTitle;
	private String m_strThemeId;
	private String m_strTemplateId;
	private String m_strColumnId;
	private E_Role[] m_objRoles;
	private boolean m_bNavHidden;
	private String m_strType;
	
	private E_ContextPath(String type, String path, String name, String title,  boolean hiddenFromNav, E_Role... roles) { 
		this(type, path, name, title, DEFAULT_THEME_NAME, "paAllColumns", "column-1", hiddenFromNav, roles);
	}
	
	private E_ContextPath(String path, String name, String title,  boolean hiddenFromNav, E_Role... roles) { 
		this(LayoutConstants.TYPE_PORTLET, path, name, title, DEFAULT_THEME_NAME, "paAllColumns", "column-1", hiddenFromNav, roles);
	}
	
	private E_ContextPath(String type, String path, String name, String title, String themeId, String templateId, String columnId, boolean hiddenFromNav, E_Role... roles) {
		m_strType = type;
		m_strPth = path;
		m_strName = name;
		m_strTitle = title;
		m_strThemeId = themeId;
		m_strTemplateId = templateId;
		m_strColumnId = columnId;
		m_objRoles = roles;
		m_bNavHidden = hiddenFromNav;
	}
	
	public boolean isHidden() {
		return m_bNavHidden;
	}
	
	public E_Role[] getRoles() {
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
	
	public String getColumnId() {
		return m_strColumnId;
	}
	
	public String getType() {
		return m_strType;
	}
	
	public static String getDefaultThemeName() {
		return DEFAULT_THEME_NAME;
	}
}

package de.fraunhofer.fokus.oefit.particity.portlet.init;

import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.util.PortletKeys;

import de.fraunhofer.fokus.oefit.adhoc.custom.E_Role;

public enum E_ContextPath {

	HOME("/welcome","Home","Home", true, RoleConstants.GUEST),
	SEARCH("/search","Suche","Suche", true, RoleConstants.GUEST),
	ADM(E_Role.ADMIN.getHomeUrl(),"Administration","Administration", false, E_Role.ADMIN.getName()),
	ORG(E_Role.ORG.getHomeUrl(),"Organisation","Organisation", false, E_Role.ORG.getName()),
	MGMT(E_Role.MGMT.getHomeUrl(),"Verwaltung","Verwaltung", false,E_Role.MGMT.getName()),
	PROFILE("/int/profile","Profil","Profil",false),
	ORG_REGISTRATION("/organization","Organisation Registration","Organisation Registrierung", true, RoleConstants.GUEST),
	USR_REGISTRATION("/user","Newsletter Registration","Newsletter Registration", true, RoleConstants.GUEST),
	USR_NEWSLETTER("/newsletter","Newsletter","Newsletter",true, RoleConstants.GUEST),
	DATAPOLICY("/datenschutz","Datenschutz","Datenschutz", true, RoleConstants.GUEST),
	LEGALDETAILS("/impressum","Impressum","Impressum", true, RoleConstants.GUEST),
	;
	
	private static final String DEFAULT_THEME_NAME = "patheme_WAR_padefaulttheme";
	
	private String m_strPth;
	private String m_strName;
	private String m_strTitle;
	private String m_strThemeId;
	private String m_strTemplateId;
	private String m_strColumnId;
	private String[] m_objRoles;
	private boolean m_bNavHidden;
	
	private E_ContextPath(String path, String name, String title,  boolean hiddenFromNav, String... roles) { 
		this(path, name, title, DEFAULT_THEME_NAME, "paAllColumns", "column-1", hiddenFromNav, roles);
	}
	
	private E_ContextPath(String path, String name, String title, String themeId, String templateId, String columnId, boolean hiddenFromNav, String... roles) {
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
	
	public String getColumnId() {
		return m_strColumnId;
	}
	
	public static String getDefaultThemeName() {
		return DEFAULT_THEME_NAME;
	}
}

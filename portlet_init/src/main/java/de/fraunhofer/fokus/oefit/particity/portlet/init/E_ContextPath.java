package de.fraunhofer.fokus.oefit.particity.portlet.init;

public enum E_ContextPath {

	ADM("/int/administration","Administration","Administration","paadmin_WAR_paadminportlet"),
	ORG("/int/organisation","Organisation","Organisation","paorg_WAR_paorgportlet"),
	MGMT("/int/verwaltung","Verwaltung","Verwaltung","pamgmt_WAR_pamgmtportlet")
	;
	
	private static final String DEFAULT_THEME_NAME = "ah_theme_WAR_padefaulttheme";
	
	private String m_strPth;
	private String m_strName;
	private String m_strTitle;
	private String m_strThemeId;
	private String m_strTemplateId;
	private String m_strPortletId;
	private String m_strColumnId;
	
	private E_ContextPath(String path, String name, String title, String portletId) { 
		this(path, name, title, DEFAULT_THEME_NAME, "paAllColumns", "column-1", portletId);
	}
	
	private E_ContextPath(String path, String name, String title, String themeId, String templateId, String columnId, String portletId) {
		m_strPth = path;
		m_strName = name;
		m_strTitle = title;
		m_strThemeId = themeId;
		m_strTemplateId = templateId;
		m_strPortletId = portletId;
		m_strColumnId = columnId;
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

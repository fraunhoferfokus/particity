package de.fraunhofer.fokus.oefit.particity.portlet.init;

public enum E_SampleContent {

	FRONTEND(E_ContextPath.HOME,"/../../data/frontend.html","Frontend"),
	FRONTEND_LATEST(E_ContextPath.HOME,"palatest_WAR_pasearchportlet"),
	FRONTEND_FOOTER(E_ContextPath.HOME,"/../../data/footer.html","Footer"),
	;
	
	private E_ContextPath m_objContextPath;
	private String m_strDataPath;
	private String m_strTitle;
	private boolean m_bIsPortlet = false;
	
	private E_SampleContent(E_ContextPath pth, String portletId) {
		m_objContextPath = pth;
		m_strDataPath = portletId;
		m_strTitle = null;
		m_bIsPortlet = true;
	}
	
	private E_SampleContent(E_ContextPath path, String file, String title) {
		m_objContextPath = path;
		m_strDataPath = file;
		m_strTitle = title;
	}
	
	public String getTitle() {
		return m_strTitle;
	}
	
	public String getDataPath() {
		return m_strDataPath;
	}
	
	public E_ContextPath getContext() {
		return m_objContextPath;
	}
	
	public boolean isPorlet() {
		return m_bIsPortlet;
	}
	
}

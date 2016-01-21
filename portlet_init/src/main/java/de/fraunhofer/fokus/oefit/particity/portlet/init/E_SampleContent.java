package de.fraunhofer.fokus.oefit.particity.portlet.init;

public enum E_SampleContent {

	// HEADER
	FRONTEND_HEADER(E_ContextPath.HOME, "paheader_WAR_pasiteportlet"),
	SEARCH_HEADER(E_ContextPath.SEARCH, "paheader_WAR_pasiteportlet"),
	NEWSL_HEADER(E_ContextPath.USR_NEWSLETTER, "paheader_WAR_pasiteportlet"),
	ORGREG_HEADER(E_ContextPath.ORG_REGISTRATION, "paheader_WAR_pasiteportlet"),
	LEGALDETAILS_HEADER(E_ContextPath.LEGALDETAILS, "paheader_WAR_pasiteportlet"),
	DATAPOLICY_HEADER(E_ContextPath.DATAPOLICY, "paheader_WAR_pasiteportlet"),
	
	// HEADER logo
	FRONTEND_LOGO(E_ContextPath.HOME, "/../../data/logo.html","Logo","56_INSTANCE_head1"),
	SEARCH_LOGO(E_ContextPath.SEARCH, "/../../data/logo.html","Logo","56_INSTANCE_head1"),
	NEWSL_LOGO(E_ContextPath.USR_NEWSLETTER, "/../../data/logo.html","Logo","56_INSTANCE_head1"),
	ORGREG_LOGO(E_ContextPath.ORG_REGISTRATION, "/../../data/logo.html","Logo","56_INSTANCE_head1"),
	LEGALDETAILS_LOGO(E_ContextPath.LEGALDETAILS, "/../../data/logo.html","Logo","56_INSTANCE_head1"),
	DATAPOLICY_LOGO(E_ContextPath.DATAPOLICY, "/../../data/logo.html","Logo","56_INSTANCE_head1"),
	
	// HEADER shariff
	FRONTEND_SHARIFF(E_ContextPath.HOME, "/../../data/shariff.html","Logo","56_INSTANCE_head2"),
	NEWSL_SHARIFF(E_ContextPath.USR_NEWSLETTER, "/../../data/shariff.html","Logo","56_INSTANCE_head2"),
	ORGREG_SHARIFF(E_ContextPath.ORG_REGISTRATION, "/../../data/shariff.html","Logo","56_INSTANCE_head2"),
	LEGALDETAILS_SHARIFF(E_ContextPath.LEGALDETAILS, "/../../data/shariff.html","Logo","56_INSTANCE_head2"),
	DATAPOLICY_SHARIFF(E_ContextPath.DATAPOLICY, "/../../data/shariff.html","Logo","56_INSTANCE_head2"),
	
	// HEADER newsletter ad
	SEARCH_NEWSAD(E_ContextPath.SEARCH, "/../../data/newsletter.html","Newsletter-Ad","56_INSTANCE_head2"),
	
	// BREADCRUMBS
	SEARCH_BREADCRUMBS(E_ContextPath.SEARCH, "73"),
	NEWSL_BREADCRUMBS(E_ContextPath.USR_NEWSLETTER, "73"),
	ORGREG_BREADCRUMBS(E_ContextPath.ORG_REGISTRATION, "73"),
	LEGALDETAILS_BREADCRUMBS(E_ContextPath.LEGALDETAILS, "73"),
	DATAPOLICY_BREADCRUMBS(E_ContextPath.DATAPOLICY, "73"),
	
	// FRONTEND
	FRONTEND(E_ContextPath.HOME,"/../../data/frontend.html","Frontend"),
	FRONTEND_LATEST(E_ContextPath.HOME,"palatest_WAR_pasearchportlet"),
	
	// Single-page default portlets
	SEARCH(E_ContextPath.SEARCH,"pasearch_WAR_pasearchportlet"),
	ADM(E_ContextPath.ADM,"paadmin_WAR_padataportlet"),
	ORG(E_ContextPath.ORG,"paorgmain_WAR_paorgportlet"),
	MGMT(E_ContextPath.MGMT,"pamgmt_WAR_pamgmtportlet"),
	PROFILE(E_ContextPath.PROFILE,"paloginprofile_WAR_pasiteportlet"),
	ORG_REGISTRATION(E_ContextPath.ORG_REGISTRATION,"paorgregistration_WAR_paorgportlet"),
	USR_REGISTRATION(E_ContextPath.USR_REGISTRATION,"pauserregistration_WAR_panewslportlet"),
	USR_NEWSLETTER(E_ContextPath.USR_NEWSLETTER,"pausermain_WAR_panewslportlet"),
	
	// FOOTER LINKS
	DATAPOLICY(E_ContextPath.DATAPOLICY,"/../../data/datapolicy.html","Data policy"),
	LEGALDETAILS(E_ContextPath.LEGALDETAILS,"/../../data/legaldetails.html","Legal details"),
	
	
	// FOOTER
	FRONTEND_FOOTER(E_ContextPath.HOME,"/../../data/footer.html","Footer"),
	SEARCH_FOOTER(E_ContextPath.SEARCH,"/../../data/footer.html","Footer"),
	MGMT_FOOTER(E_ContextPath.MGMT,"/../../data/footer.html","Footer"),
	ORG_FOOTER(E_ContextPath.ORG,"/../../data/footer.html","Footer"),
	ADMIN_FOOTER(E_ContextPath.ADM,"/../../data/footer.html","Footer"),
	PROFILE_FOOTER(E_ContextPath.PROFILE,"/../../data/footer.html","Footer"),
	NEWSL_FOOTER(E_ContextPath.USR_NEWSLETTER,"/../../data/footer.html","Footer"),
	ORGREG_FOOTER(E_ContextPath.ORG_REGISTRATION,"/../../data/footer.html","Footer"),
	LEGALDETAILS_FOOTER(E_ContextPath.LEGALDETAILS,"/../../data/footer.html","Footer"),
	DATAPOLICY_FOOTER(E_ContextPath.DATAPOLICY,"/../../data/footer.html","Footer"),
	;
	
	private E_ContextPath m_objContextPath;
	private String m_strDataPath;
	private String m_strTitle;
	private boolean m_bIsPortlet = false;
	private String m_strParentPortletId;
	
	private E_SampleContent(E_ContextPath pth, String portletId) {
		this(pth,portletId,null);
		m_bIsPortlet = true;
	}
	
	private E_SampleContent(E_ContextPath path, String file, String title) {
		this(path,file,title,null);
	}
	
	private E_SampleContent(E_ContextPath path, String file, String title, String parentPortletId) {
		m_objContextPath = path;
		m_strDataPath = file;
		m_strTitle = title;
		m_strParentPortletId = parentPortletId;
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
	
	public boolean hasParent() {
		return m_strParentPortletId != null;
	}
	
	public String getParentPortletId() {
		return m_strParentPortletId;
	}
}

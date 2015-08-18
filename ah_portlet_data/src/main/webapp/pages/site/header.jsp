<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.service.LayoutSetLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.LayoutSet"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<%
	Log log = LogFactoryUtil.getLog(this.getClass().getName());

  String logoPath = null;


  if (themeDisplay.getLayoutSet().getLogo()) {
	  logoPath = themeDisplay.getLayoutSetLogo();
  }
	  
	
%>

<div class="container-fluid header">

	<div class="row headertop">

		<div class="col-md-6 sitelogo">
			<%
		  // show site logo, if configured
		  if( logoPath != null ) {
			  %>
			<img src="<%=logoPath%>" />
			<%
		  }
		  // otherwise fallback to web content portlet    
		  else {
			  %>
			<liferay-portlet:runtime portletName="56_INSTANCE_head1" />
			<%
		  }
		  %>
		</div>
		<div class="col-md-6 login text-right">
			<liferay-portlet:runtime portletName="ahlogin_WAR_adhocdataportlet"
				queryString="?hide=true&_ahlogin_WAR_adhocdataportlet_hide=true" />
		</div>

	</div>

	<div class="row headerback">
		<liferay-portlet:runtime portletName="56_INSTANCE_head2" />
	</div>


</div>
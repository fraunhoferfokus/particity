<%@page import="com.liferay.portal.kernel.util.StringBundler"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<%
	Log log = LogFactoryUtil.getLog(this.getClass().getName());

  String logoPath = null;


  if (themeDisplay.getLayoutSet().getLogo()) {
	  logoPath = themeDisplay.getLayoutSetLogo();
  }
	  
	
%>

<div class="container-fluid header">

	<div class="row headerback">

		<div class="col-sm-4 sitelogo">
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
		<div class="col-sm-4">
		  <liferay-portlet:runtime portletName="56_INSTANCE_head2" />
		</div>
		<div class="col-sm-4 login text-right">
			<liferay-portlet:runtime portletName="palogin_WAR_pasiteportlet"
				queryString="?hide=true&_palogin_WAR_pasiteportlet_hide=true" />
		</div>

	</div>


</div>
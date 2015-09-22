<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page import="java.io.StringWriter"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.Constants"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<div class="loginWrapper">
	<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  boolean isLoggedIn = themeDisplay.isSignedIn();
  
  //m_objLog.info("Got hide parameter "+request.getParameter("hide"));
  //m_objLog.info("Got query string "+PortalUtil.getHttpServletRequest(request).getQueryString());
  //m_objLog.info("Got global hide parameter "+PortalUtil.getHttpServletRequest(request).getParameter("hide"));
  
  boolean hide = ParamUtil.get(request, "hide", Boolean.FALSE);
  
  
  
 if (!isLoggedIn) {
	 %>

	<portlet:actionURL var="loginUrl">
		<portlet:param name="action" value="login" />
	</portlet:actionURL>



	<liferay-ui:error key="common.form.login.failed">
		<spring:message code="common.form.login.failed" />
	</liferay-ui:error>

	<%
  if (hide) {
	  %>
	<div id="loginBtn">
		<spring:message code="common.form.login.orgintro" /> <a class="btn btn-adhoc btn-sm" onclick="hideLoginBtn();" 
			data-toggle="collapse" data-target="#loginForm"
			aria-expanded="false" aria-controls="loginForm">
			<spring:message code="common.form.login.preform" />
		</a>
	</div>
	<%
  }
  %>

	<div id="loginForm" class="<%= hide ? "collapse" : "collapse in"%>">
		<form:form class="form-inline" modelAttribute="userData"
			data-ajax="false" method="post" action="<%= loginUrl %>">
			<bform:bffield path="mail" cssClass="input-sm" insetLabel="true"
				label="common.form.profile.field.mail" type="text" required="true" />
			<bform:bffield path="pass1" cssClass="input-sm" insetLabel="true"
				label="common.form.profile.field.pass1" type="password"
				required="true" />
	    &nbsp;<button type="submit" class="btn btn-adhoc btn-sm">
				<span class="glyphicon glyphicon-log-in"></span>
			</button>
			<br />


		</form:form>
	</div>

	<%
    PortletURL url = PortletURLFactoryUtil.create(request, PortletKeys.LOGIN, layout.getPlid(), PortletRequest.ACTION_PHASE);
    //url.setWindowState(WindowState.MAXIMIZED);
    url.setPortletMode(PortletMode.VIEW);
    url.setParameter("saveLastPath", "0");
    url.setParameter("struts_action", "/login/forgot_password");
    StringWriter sw = new StringWriter();
    url.write(sw);
    String defOrgUrl = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.MGMT_PATH_ORG_REGISTRATION);
    %>
	<small>
	
	  <% if (demoDisabled.length() == 0) { %>
		  <a href="<%= sw.toString() %>"><spring:message
					code="common.form.pass.forgot" /></a>&nbsp;/&nbsp;
		<%
	  }
		%>
		<a href="<%= defOrgUrl %>">
		<spring:message code="common.form.register" /></a></small>

	<%
 } else {
	 String name = user.getFullName();
	 %>
	<spring:message code="common.form.logout.intro" />
	<strong>&nbsp;<%= name %></strong><br />
	<a href="/c/portal/logout" class="btn btn-adhoc btn-sm"><span
		class="glyphicon glyphicon-log-out"></span>&nbsp;<spring:message
			code="common.form.logout.submit" /></a>
	<%
 }
%>

</div>

<script>

function hideLoginBtn() {
	$("#loginBtn").hide();
}
</script>


<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.portlet.admin.AdminController"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.model.impl.AHCategoriesImpl"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  %>

<div class="container">


	<div class="jumbotron">
		<h1>
			<spring:message code="org.registration.loggedin.title" />
		</h1>
		<p>
			<spring:message code="org.registration.loggedin.descr" />
		</p>
		<a class="btn btn-lg btn-primary" href="/c/portal/logout"><span
			class="glyphicon glyphicon-log-out"></span>&nbsp;<spring:message
				code="org.registration.loggedin.btn" /></a>
	</div>

</div>
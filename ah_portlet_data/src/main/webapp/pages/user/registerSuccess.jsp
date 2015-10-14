
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.portlet.admin.AdminController"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.model.impl.AHCategoriesImpl"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
 
  %>

<div class="container" style="margin-top: 20px;">

	<div class="jumbotron">
		<h1>
			<spring:message code="user.registration.success.title" />
		</h1>
		<p>
			<spring:message code="user.registration.success.descr" />
		</p>
		<a class="btn btn-lg btn-primary" href="/"><span
			class="glyphicon glyphicon-home"></span>&nbsp;<spring:message
				code="user.registration.succes.btn" /></a>
	</div>

</div>
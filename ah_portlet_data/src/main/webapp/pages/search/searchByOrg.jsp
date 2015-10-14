<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHAddr"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHAddrLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil"%>
<%@page
	import="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOrg"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOffer"%>
<%@page import="org.springframework.ui.Model"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCategoriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());

  String orgIdStr = request.getParameter("orgId");
  
  AHOrg org = null;
  try {
	  Long orgId = Long.parseLong(orgIdStr);
	  org = AHOrgLocalServiceUtil.getAHOrg(orgId);
  } catch (Throwable t) {}
  
  String ctxPth = request.getContextPath();
  String orgName = org != null ? org.getName() : "";
  
  %>


<portlet:renderURL var="searchUrl">
</portlet:renderURL>

<portlet:renderURL var="orgUrl">
	<portlet:param name="orgId" value="ORGID"></portlet:param>
</portlet:renderURL>

<portlet:actionURL var="offerUrl">
	<portlet:param name="action" value="showOffer"></portlet:param>
	<portlet:param name="offerId" value="OFFERID"></portlet:param>
</portlet:actionURL>

<div class="container-fluid">


	<div class="page-header">
		<h1>
			<spring:message code="search.jsp.title" />
			&nbsp;&nbsp;<small><%= orgName %></small>
		</h1>
	</div>


	<div class="row">
		<div class="col-xs-12 resultset">
			<liferay-util:include page="/pages/search/searchresults.jsp"
				portletId="<%= portletDisplay.getId() %>"
				servletContext="<%= this.getServletContext() %>">
				<liferay-util:param name="orgId" value="<%= orgIdStr %>"></liferay-util:param>
				<liferay-util:param name="orgUrl" value="<%= orgUrl %>"></liferay-util:param>
				<liferay-util:param name="offerUrl" value="<%= offerUrl %>"></liferay-util:param>
			</liferay-util:include>
		</div>
	</div>

</div>

<script>
$(function() {
  setSearchData({
    "orgUrl" : "<%= orgUrl %>",
    "offerUrl" : "<%= offerUrl %>"
  });

})
</script>
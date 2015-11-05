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


  String[] paramValues = request.getParameterValues("types");
  StringBuffer paramSb = new StringBuffer(" ");
  if (paramValues != null) {
	  for (String paramValue: paramValues) {
		  paramSb.append(paramValue).append(" ");
	  }
  }
  String typesStr = paramSb.toString();
  
  String ctxPth = request.getContextPath();
  
  String baseUrl = PortalUtil.getCurrentCompleteURL(request);
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
			&nbsp;&nbsp;<small><spring:message code="search.jsp.descr" /></small>
		</h1>
	</div>

	<form id="searchForm" data-ajax="false" method="post"
		action="<%= searchUrl %>">

		<div class="row">
		  <liferay-util:include page="/pages/search/searchNavCat.jsp"
        portletId="<%= portletDisplay.getId() %>"
        servletContext="<%= this.getServletContext() %>">
        <liferay-util:param name="parentClass" value="col-md-3"></liferay-util:param>
      </liferay-util:include>
			<liferay-util:include page="/pages/search/searchNavType.jsp"
				portletId="<%= portletDisplay.getId() %>"
				servletContext="<%= this.getServletContext() %>">
				<liferay-util:param name="parentClass" value="col-md-3"></liferay-util:param>
			</liferay-util:include>
			<liferay-util:include page="/pages/search/searchNavRadial.jsp"
        portletId="<%= portletDisplay.getId() %>"
        servletContext="<%= this.getServletContext() %>">
        <liferay-util:param name="parentClass" value="col-md-3"></liferay-util:param>
      </liferay-util:include>

			<div class="row">
				<div class="col-xs-12 text-right">
					<button id="mainSearchBtn" type="submit" class="btn btn-lg btn-primary">
						<span class="glyphicon glyphicon-search"></span>&nbsp;
						<spring:message code="search.form.submit" />
					</button>
				</div>
			</div>
		</div>

		<div class="row">

			<div class="col-md-12 resultset">
				<div class="row">
					<div class="col-xs-12 searchfilter"></div>
				</div>
				<div class="row">
					<div class="col-xs-12 resultset">
						<liferay-util:include page="/pages/search/searchresults.jsp"
							portletId="<%= portletDisplay.getId() %>"
							servletContext="<%= this.getServletContext() %>">
							<liferay-util:param name="baseUrl" value="<%= baseUrl %>"></liferay-util:param>
							<liferay-util:param name="orgUrl" value="<%= orgUrl %>"></liferay-util:param>
							<liferay-util:param name="offerUrl" value="<%= offerUrl %>"></liferay-util:param>
						</liferay-util:include>
					</div>
				</div>

			</div>
		</div>

	</form>

</div>

<script>


$(function() {
	setSearchData({
    "orgUrl" : "<%= orgUrl %>",
    "offerUrl" : "<%= offerUrl %>"
  });

  var selectedStr = "<%=typesStr.trim()%>";
  var selectedArr = selectedStr.split(","); 
  setSelectedTypes(selectedArr);
})
</script>
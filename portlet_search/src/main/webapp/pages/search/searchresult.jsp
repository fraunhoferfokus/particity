
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil"%>
<%@page
	import="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOrg"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOffer"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHCatEntriesLocalServiceUtil"%>
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
 
  boolean isModal = ParamUtil.getBoolean(request, "modal",false);
  
  String orgUrl = request.getParameter("orgUrl");
  String offerUrl = request.getParameter("offerUrl");
  
  OfferForm data = null;
  Long offerId = ParamUtil.getLong(request, "offerId");
  if (offerId != null) {
	  data = CustomOfferServiceHandler.getOffer(offerId);
	  request.setAttribute("data", data);
  }
  else {
	  log.warn("Got no offerId!");
  }
  log.info("Got request, modal "+isModal+", offerId "+offerId+", orgUrl "+orgUrl+", offerUrl "+offerUrl);
  %>


<%
  
  RegistrationForm org = null;
  
  if (data != null) {
	  org = CustomOrgServiceHandler.getOrganisation(data.getOrgId());
	  String ofPublishDate = data.getPublishDate()+" "+data.getPublishTime();
	  E_OfferType ofType = E_OfferType.valueOf(data.getType());
	  String ofExpireDate = data.getExpireDate()+" "+data.getExpireTime();
	  E_OfferWorkType ofWType = E_OfferWorkType.valueOf(data.getWorkType());
	  String ofWHours = data.getWorkHours();
	  if (orgUrl != null) {
		  orgUrl = orgUrl.replace("ORGID", Long.toString(org.getOrgId()));
	  } else
		  orgUrl = "#";
	  if (offerUrl != null) {
	      offerUrl = offerUrl.replace("OFFERID", Long.toString(data.getOfferId()));
	    } else
	      offerUrl = "#";
	  
  %>


<div id="offerModal<%= Long.toString(offerId) %>"
	class="offermodal container-fluid">

	<%
   if (!isModal) {
   %>
	<a class="btn btn-default"
		href="<portlet:renderURL></portlet:renderURL>"><spring:message
			code="search.offer.back" /></a>
	<%
   }
  %>

	<div class="page-header row">

		<div class="col-xs-8">
			<h1><%= data.getTitle() %>
				<%
	  if (isModal) {
		  %>

				&nbsp;&nbsp;<a id="permalink" class="btn btn-default btn-xs"
					target="_blank" href="<%= offerUrl %>"><spring:message
						code="search.offer.perma" /></a>

				<%
	  }
	  %>
			</h1>
			<div class="shariff"
				data-services="[&quot;facebook&quot;,&quot;googleplus&quot;,&quot;twitter&quot;]"
				data-url="<%= offerUrl %>"></div>
		</div>
		<div class="col-xs-2 text-right">
			<spring:message code="search.offer.published" />
			<br />
			<spring:message code="search.offer.expires" />
			<br />
			<spring:message code="search.offer.type" />
		</div>
		<div class="col-xs-2">
			<%=  ofPublishDate %><br />
			<%=  ofExpireDate %><br />
			<spring:message code="<%= ofType.getMsgProperty() %>" />
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12"
			style="padding-bottom: 20px; word-wrap: break-word;">
			<%= data.getDescr() %>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<strong><spring:message code="search.offer.workType" /></strong>:
			<spring:message code="<%= ofWType.getMsgProperty() %>" />
			/
			<%= ofWHours %><br /> <strong><spring:message
					code="search.offer.categories" /></strong>:
			<%= AHOfferLocalServiceUtil.getCategoriesByOfferAsString(data.getOfferId(), E_CategoryType.SEARCH.getIntValue()) %><br />
			<strong><spring:message code="search.offer.services" /></strong>:
			<%= AHOfferLocalServiceUtil.getCategoriesByOfferAsString(data.getOfferId(), E_CategoryType.OFFERCATS.getIntValue()) %>
		</div>
	</div>
	<hr />
	<div class="row">
		<div class="col-sm-3 text-right">
			<h2>
				<spring:message code="search.offer.contact" />
			</h2>
			<div class="row">
				<div class="col-xs-12">
					<%= data.getContactSurname() %>,
					<%= data.getContactForename() %><br />
					<%= data.getContactTel() %><br /> <br />
					<%= data.getAddrStreet() %>
					<%= data.getAddrNum() %><br />
					<%= data.getRegionZip() %>
					<%= data.getRegionCity() %><br />
					<%= data.getRegionCountry() %><br /> <br /> <a
						class="btn btn-primary" href="mailto:<%= data.getContactMail() %>"><spring:message
							code="search.offer.contactMail" /></a>
				</div>
			</div>
		</div>
		<div class="col-sm-9">
			<h2>
				<spring:message code="search.offer.org" />
			</h2>
			<div class="row">
				<div class="col-md-4" style="margin-bottom: 20px;">
					<%= org.getName() %><br /> <small><%= org.getHolder() %></small><br />
					<br />
					<%=org.getAddrStreet()%>
					<%= org.getAddrNum() %><br />
					<%= org.getRegionZip() %>
					<%= org.getRegionCity() %><br />
					<%= org.getRegionCountry() %><br /> <br /> <a
						href="mailto:<%= org.getContactMail() %>" class="btn btn-primary"><spring:message
							code="search.offer.orgMail" /></a>&nbsp;<a
						href="<%= org.getContactWeb() %>" target="_blank"
						class="btn btn-primary"><spring:message
							code="search.offer.orgWeb" /></a> <a id="orglink"
						href="<%= orgUrl %>" class="btn btn-primary"><spring:message
							code="search.offer.orgOffers" /></a>
				</div>
				<div class="col-md-8">
					<% if (org.getLogoFilename() != null && org.getLogoFilename().trim().length() > 0) { %>
					<img src="<%=org.getLogoFilename()%>" class="offerlogo" />
					<% } %>
					<%= org.getDescr() %>
				</div>
			</div>
		</div>
	</div>

</div>
<script>
  enableModalShariff("#offerModal<%= Long.toString(offerId) %>");
 </script>
<%
  } else {
	  %>
<div id="offerModal<%= Long.toString(offerId) %>"
	class="offermodal container-fluid">
	<div class="page-header row">
		<div class="col-xs-12">
			<h1>
				<spring:message code="search.offer.notfound.title" />
			</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12 alert alert-error">
			<spring:message code="search.offer.notfound.descr" />
		</div>

	</div>
	<div class="row">
		<div class="col-xs-12">
			<a class="btn btn-lg btn-primary"
				href="<portlet:renderURL></portlet:renderURL>"><spring:message
					code="search.offer.notfound.btn" /></a>
		</div>
	</div>
</div>
<%
  }
%>

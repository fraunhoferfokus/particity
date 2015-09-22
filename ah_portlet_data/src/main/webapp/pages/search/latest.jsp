<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomSearchServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHAddr"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHAddrLocalServiceUtil"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHOfferLocalServiceUtil"%>
<%@page
	import="org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHOrg"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHOrgLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHOffer"%>
<%@page import="org.springframework.ui.Model"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHCatEntriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHCatEntries"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.service.AHCategoriesLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.model.AHCategories"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
  
  String baseUrl = PortalUtil.getCurrentCompleteURL(request);
  
  List<AHOffer> offers = CustomSearchServiceHandler.getLatestPublishedOffers(3);
  
  String ctxPth = request.getContextPath();

  %>

<script>
    $(function() {
      setMarkerBase("<%= ctxPth %>"); 
      setText("search.modal.close",'<spring:message code="search.modal.close" />');
      setText("search.modal.prev",'<spring:message code="search.modal.prev" />');
      setText("search.modal.next",'<spring:message code="search.modal.next" />');
    })
</script>

<portlet:actionURL var="offerUrl">
	<portlet:param name="action" value="showOffer"></portlet:param>
	<portlet:param name="offerId" value="OFFERID"></portlet:param>
</portlet:actionURL>

<portlet:renderURL var="orgUrl">
	<portlet:param name="orgId" value="ORGID"></portlet:param>
</portlet:renderURL>

<div class="container-fluid">

	<div class="row">

		<div
			class="col-md-8 col-md-offset-2 col-sm-10 col-sm-offset-1 col-xs-12">

			<div class="row">
				<%
			  if (offers.size() > 0 ) {
				  String count;
				  AHOffer offer;
				  for (int i=0; i<offers.size(); i++) {
					  offer = offers.get(i);
					  count = Integer.toString(i+1);
			      String offerId = Long.toString(offer.getOfferId());
			      AHAddr addr = null;
			      try {
			        addr = AHAddrLocalServiceUtil.getAHAddr(offer.getAdressId());
			      } catch (Throwable t) {
			        log.error(t);
			      }
			      if (addr != null) {
					  %>
				<div id="modal<%=count%>" class="searchmodal"></div>
				<div class="col-md-4 text-center">
					<a id="offerdetails<%= count %>"
						onclick="return triggerModal('<%= orgUrl %>','<%= offerUrl %>',<%= count %>,'<%= offerId %>',<%=Integer.toString(offers.size())%>); "
						href="<portlet:actionURL>
					      <portlet:param name="action" value="showOffer" />
					      <portlet:param name="offerId" value="<%= offerId %>" />
					      <portlet:param name="modal" value="false" />
					      </portlet:actionURL>"
						target="_blank"><%= offer.getTitle() %></a><br />
					<div id="offermap<%= count %>" class="offermap"></div>
					<script>
			            $(function() {
			              var imgelem = addSearchMap(<%=  count %>,<%= addr.getCoordLat() %>,<%= addr.getCoordLon() %>);
			              if (imgelem != undefined) {
			                $("#offer<%=count %> .offertitlenum").empty();
			                $("#offer<%=count %> .offertitlenum").append(imgelem);
			              }
			            })
			            </script>
				</div>
				<%
			      }
				  }
			  } else {
				  %>
				<div class="col-md-12 alert alert-info">Aktuell sind keine
					Angebote verfügbar.</div>
				<%	  
			  }
			  %>
			</div>
		</div>
	</div>
</div>
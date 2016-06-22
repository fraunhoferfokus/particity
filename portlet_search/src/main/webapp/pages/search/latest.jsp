<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler"%>
<%@page import="de.particity.model.I_AddressModel"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler"%>
<%@page import="de.particity.model.I_OrganizationModel"%>
<%@page import="de.particity.model.I_OfferModel"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.OfferForm"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomSearchServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.forms.RegistrationForm"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="java.util.LinkedList"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());
  
  String baseUrl = PortalUtil.getCurrentCompleteURL(request);
  
  List<I_OfferModel> offers = CustomSearchServiceHandler.getLatestPublishedOffers(3);
  
  String ctxPth = request.getContextPath();

  String mapUrl = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.OSM_URL);
  String mapAttrib = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.OSM_ATTRIB);
  String mapId = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.OSM_ID);
  String mapAt = CustomPortalServiceHandler.getConfigValue(E_ConfigKey.OSM_AT);
  
  %>

<script>
    $(function() {
      setMarkerBase("<%= ctxPth %>"); 
      setText("search.modal.close",'<spring:message code="search.modal.close" />');
      setText("search.modal.prev",'<spring:message code="search.modal.prev" />');
      setText("search.modal.next",'<spring:message code="search.modal.next" />');
      setMapData({
    	 url: "<%=mapUrl%>",
    	 attrib: '<%=mapAttrib%>',
    	 id: "<%=mapId%>",
    	 at: "<%=mapAt%>"
      });
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
				  String skipCount;
				  I_OfferModel offer;
				  I_OrganizationModel org;
				  for (int i=0; i<offers.size(); i++) {
					  offer = offers.get(i);
					  org = offer.getOrg();
					  count = Integer.toString(i);
					  skipCount = Integer.toString(i+1);
			      String offerId = Long.toString(offer.getId());
			      //E_OfferType ofType = E_OfferType.findByValue(offer.getType());
			      E_OfferWorkType ofWType = offer.getWorkType();
			      String ofWHours = offer.getWorkTime();
			      I_AddressModel addr = offer.getAddress();

			      if (addr != null) {
					  %>
				<div id="latestmodal<%=count%>" class="searchmodal"></div>
				<div class="col-md-4 text-center">
					<a id="latestdetails<%= count %>"
						onclick="return triggerModal('#latestmodal','#latestdetails','<%= orgUrl %>','<%= offerUrl %>',<%= count %>,'<%= offerId %>',<%=Integer.toString(offers.size())%>); "
						href="<portlet:actionURL>
					      <portlet:param name="action" value="showOffer" />
					      <portlet:param name="offerId" value="<%= offerId %>" />
					      <portlet:param name="modal" value="false" />
					      </portlet:actionURL>"
						target="_blank"><%= offer.getTitle() %></a><br />
					<div id="latestmap<%= skipCount %>" class="latestmap">
					<% if (Constants.PORTAL_MODE == Constants.PORTAL_MODE_OFFLINE) {
		          %>
		          <a id="latestdetails<%= count %>"
			            onclick="return triggerModal('#latestmodal','#latestdetails','<%= orgUrl %>','<%= offerUrl %>',<%= count %>,'<%= offerId %>',<%=Integer.toString(offers.size())%>); "
			            href="<portlet:actionURL>
			                <portlet:param name="action" value="showOffer" />
			                <portlet:param name="offerId" value="<%= offerId %>" />
			                <portlet:param name="modal" value="false" />
			                </portlet:actionURL>"
			            target="_blank">
		            <img src="<%= ctxPth+"/images/map_demo.png" %>">
		           </a>
		          <%
		        } %>
					</div>
					<% if (Constants.PORTAL_MODE != Constants.PORTAL_MODE_OFFLINE) {
              %>
					<script>
			            $(function() {
			              var imgelem = addSearchMap("#latestmap","#latestdetails",<%=  skipCount %>,<%= addr.getCoordLat() %>,<%= addr.getCoordLon() %>);
			              if (imgelem != undefined) {
			                $("#offer<%=count %> .offertitlenum").empty();
			                $("#offer<%=count %> .offertitlenum").append(imgelem);
			              }
			            })
			    </script>
			    <%
            } %>
			    <div class="row">
				    <div class="col-xs-12 text-center">
				      <spring:message code="<%= ofWType.getMsgProperty() %>" /> / <%= ofWHours %>
				    </div>
			    </div>
				</div>
				<%
			      }
				  }
			  } else {
				  %>
				<div class="col-md-12 alert alert-info"><spring:message code="latest.nooffer" /></div>
				<%	  
			  }
			  %>
			</div>
		</div>
	</div>
</div>
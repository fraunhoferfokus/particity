<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomSearchServiceHandler"%>
<%@page import="javax.portlet.RenderResponse"%>
<%@page import="org.springframework.web.portlet.util.PortletUtils"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.service.persistence.PortletUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.Constants"%>
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

  int maxOffers = 5;

  Log log = LogFactoryUtil.getLog(this.getClass().getName());

  //PortletPreferences prefs = renderRequest.getPreferences();
  String rCatParam = request.getParameter("categoryId");
  
  String orgIdStr = request.getParameter("orgId");
  String resultSkipStr = request.getParameter("resultSkip");
  String[] itemIdStr = request.getParameterValues("items");
  String[] typesStr = request.getParameterValues("types");
  String[] latLon = request.getParameterValues("latlon");
  //String baseUrl = request.getParameter("baseUrl");
  String orgUrl = request.getParameter("orgUrl");
  String offerUrl = request.getParameter("offerUrl");
  
  //String pportletId = request.getParameter("portletId");
  //String pplid = request.getParameter("plid");
  
  /*if (pportletId == null && themeDisplay != null)
	  pportletId = themeDisplay.getPortletDisplay().getId();
  if (pplid == null && themeDisplay != null)
	  pplid = Long.toString(themeDisplay.getPlid());
  
  log.info("Portlet ID is "+pportletId+", plid is "+pplid+", baseUrl is "+baseUrl);*/

  Float lat = null;
  Float lon = null;
  Integer dist = null;
  
  Integer resultSkip = 0;
  if (resultSkipStr != null && resultSkipStr.trim().length() > 0) {
	  resultSkip = Integer.parseInt(resultSkipStr);
  }
  
  Long orgId = -1L;
  if (orgIdStr != null && orgIdStr.trim().length() > 0) {
	  orgId = Long.parseLong(orgIdStr);
	}
  
  if (latLon != null && latLon.length == 1 && latLon[0].contains(","))
	  latLon = latLon[0].split(",");
  if (latLon != null && latLon.length == 3) {
	  try {
		  dist = Integer.parseInt(latLon[0]);
		  lat = Float.parseFloat(latLon[1]);
		  lon = Float.parseFloat(latLon[2]);
	  } catch (Throwable t) {
		  log.error(t);
	  }
  }
  
  if (itemIdStr != null && itemIdStr.length == 1 && itemIdStr[0].contains(","))
	  itemIdStr = itemIdStr[0].split(",");
  else if (itemIdStr != null && itemIdStr.length == 1 && itemIdStr[0].trim().length() == 0)
	  itemIdStr = null;
  StringBuffer itemIdSb = new StringBuffer();
  if (itemIdStr != null && itemIdStr.length > 0) {
	  for (int i=0; i<itemIdStr.length; i++) {
		  itemIdSb.append(itemIdStr[i]).append(",");
	  }
  }
  
  if (typesStr != null && typesStr.length == 1 && typesStr[0].contains(","))
	  typesStr = typesStr[0].split(",");
  else if (typesStr != null && typesStr.length == 1 && typesStr[0].trim().length() == 0)
	    typesStr = null;
  StringBuffer typeSb = new StringBuffer();
  //List<E_OfferType> types = null;
  if (typesStr != null && typesStr.length > 0) {
	  //types = new ArrayList<E_OfferType>();
    for (int i=0; i<typesStr.length; i++) {
    	/*E_OfferType type = null;
    	try {
    		log.info("Looking up type "+typesStr[i]);
    		type = E_OfferType.valueOf(typesStr[i]);
    		types.add(type);
    	  
    	} catch (Throwable t) {}
    	*/
    	typeSb.append(typesStr[i]).append(",");
    }
  }
  
  Long[] catId = null;;
  if (rCatParam != null && !rCatParam.equals("-1")) {
	  String[] rCatList = rCatParam.split(",");
    catId = new Long[rCatList.length];
    for (int i=0; i<rCatList.length; i++) {
      catId[i] = Long.parseLong(rCatList[i]);
    }
  }
  
  /*log.info("Got category "+rCatParam);
  log.info("Got resultskip "+resultSkipStr);
  log.info("Got orgId "+orgIdStr);
  log.info("Got itemIds "+itemIdSb.toString());
  log.info("Got types "+typeSb.toString());*/
  
  List<AHOffer> results = null;
  Integer resultSize = -1;
  results = CustomSearchServiceHandler.searchByTypesAndItemsAndOrg(typeSb.toString(), itemIdSb.toString(), orgId, resultSkip, resultSkip+maxOffers, lat, lon, dist);
  resultSize = CustomSearchServiceHandler.countByTypesAndItemsAndOrg(typeSb.toString(), itemIdSb.toString(), orgId, lat, lon, dist);
  
  /*log.debug("Resultsize is "+resultSize);
  log.debug("Result list is #"+results.size());*/
  
  /*if (types != null && types.size() > 0) {
	  results = CustomServiceHandler.searchByOfferTypes(types.toArray(new E_OfferType[0]), resultSkip, resultSkip+maxOffers);
	  resultSize = CustomServiceHandler.countByOfferTypes(types.toArray(new E_OfferType[0]));
  } else if (itemIdStr != null && itemIdStr.length > 0) {
	  results = CustomServiceHandler.searchByItemId(itemIdStr, resultSkip, resultSkip+maxOffers);
	  resultSize = CustomServiceHandler.countByItemId(itemIdStr);
  } else if (orgId != null) {
	  results = CustomServiceHandler.searchAllPublished(resultSkip, resultSkip+maxOffers, orgId);
	  resultSize = CustomServiceHandler.countAllPublished(orgId);
  } else if (catId != null) {
	    results = CustomServiceHandler.searchByCategoriyId(catId, resultSkip, resultSkip+maxOffers);
	    resultSize = CustomServiceHandler.countByCategoriyId(catId);
  } else {
	  resultSize = CustomServiceHandler.countAllPublished();
	  results = CustomServiceHandler.searchAllPublished(resultSkip, resultSkip+maxOffers);
  }*/
  
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
            attrib: "<%=mapAttrib%>",
            id: "<%=mapId%>",
            at: "<%=mapAt%>"
         });
    })
</script>


<div class="container-fluid">
	<%

  if (results != null) {
    %>
	<div class="row">
		<div class="col-md-6 text-info">
			<strong><%= resultSize %> <spring:message
					code="search.form.results.count" /></strong>
		</div>
		<div class="col-md-6">
			<%
      if (resultSkip >= resultSize)
          resultSkip = 0;
      
      int max = 5;
      int pageNum = (resultSkip > 0) ? (resultSkip/max)+1 : 1;
      int pagesNum = (resultSize > 0) ? (int) Math.ceil((((double) resultSize)/max)) : 1;
      
      
      
      // PAGINATION START
      if (resultSize > max) {
          %>

			<nav class="text-right">
				<ul class="pagination pagination-lg">
					<%
             if (pageNum != 1) {
           %>
					<li><a
						onclick="return searchPagination(<%=  Integer.toString(resultSkip-max)  %>)"
						href="<portlet:renderURL>
               <portlet:param name="resultSkip" value="<%=  Integer.toString(resultSkip-max)  %>" />
               <portlet:param name="items" value="<%=  itemIdSb.toString() %>" />
               <portlet:param name="types" value="<%=  typeSb.toString() %>" />
               <portlet:param name="orgId" value="<%=  orgIdStr %>" />
               </portlet:renderURL>"><span
							aria-hidden="true">&laquo;</span></a></li>
					<%
             }
           String liclass = "";
           for (int i=1;i<=pagesNum;i++) {
             liclass = "";
             if (i == pageNum)
               liclass = "active";
             %>
					<li class="<%= liclass %>"><a
						onclick="return searchPagination(<%=  Integer.toString((i-1)*max)  %>)"
						href="<portlet:renderURL>
               <portlet:param name="resultSkip" value="<%=  Integer.toString((i-1)*max)  %>" />
               <portlet:param name="items" value="<%=  itemIdSb.toString() %>" />
               <portlet:param name="types" value="<%=  typeSb.toString() %>" />
               <portlet:param name="orgId" value="<%=  orgIdStr %>" />
               </portlet:renderURL>"><%= Integer.toString(i) %></a></li>
					<%
           }
          
           if (pageNum != pagesNum) {
          %>
					<li><a
						onclick="return searchPagination(<%=  Integer.toString(resultSkip+max)  %>)"
						href="<portlet:renderURL>
               <portlet:param name="resultSkip" value="<%=  Integer.toString(resultSkip+max)  %>" />
               <portlet:param name="items" value="<%=  itemIdSb.toString() %>" />
               <portlet:param name="types" value="<%=  typeSb.toString() %>" />
               <portlet:param name="orgId" value="<%=  orgIdStr %>" />
               </portlet:renderURL>"><span
							aria-hidden="true">&raquo;</span></a></li>
					<%
           }
           %>
				</ul>
			</nav>

			<%
          }
      // PAGINATION END
      
      %>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-12">
			<%
				
			    AHOffer offer;
				  String count = "";
				  String skipCount = "";
			    for (int i=0; i< results.size(); i++) {
			    	count = Integer.toString(i);
			    	skipCount = Integer.toString(resultSkip+i+1);
			    	offer = results.get(i);
			    	String offerId = Long.toString(offer.getOfferId());
			    	E_OfferType type = E_OfferType.findByValue(offer.getType());
			    	String updated = CustomServiceUtils.formatZoneDateTime(offer.getUpdated());
			    	String expires = CustomServiceUtils.formatZoneDateTime(offer.getExpires());
			    	E_OfferWorkType workType = E_OfferWorkType.findByValue(offer.getWorkType());
			    	String workTime = offer.getWorkTime();
			    	//String cats = AHOfferLocalServiceUtil.getCategoriesByOfferAsString(offer.getOfferId(),E_CategoryType.SEARCH);
			    	AHAddr addr = null;
			    	try {
			    		addr = AHAddrLocalServiceUtil.getAHAddr(offer.getAdressId());
			    	} catch (Throwable t) {
			    		log.error(t);
			    	}
			    	AHOrg org = null;
			    	try {
			    		org = AHOrgLocalServiceUtil.getAHOrg(offer.getOrgId());
			    	} catch (Throwable t) {
			    		log.error(t);
			    	}
			    	if (org == null)
			    		continue;
			    %>
			<div id="offermodal<%=count%>" class="searchmodal"></div>
			<div id="offer<%=skipCount %>" class="row offer">
				<div class="col-xs-9" style="padding: 0px;">
					<div class="row">
						<div class="col-md-3 offerorg hidden-xs hidden-sm">
							<div class="row">
								<div class="col-xs-12 offerorgtitle">
									<%= org.getName() %>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 offerorgimg">
									<img src="<%= org.getLogoLocation()%>">
								</div>
							</div>
							<div class="row offerdate ">
								<div class="col-xs-12 text-right">
									<small><spring:message code="search.offer.updated" />:&nbsp;
										<%= updated %><br /> <spring:message
											code="search.offer.expires" />:&nbsp; <%= expires %></small>
								</div>
							</div>
						</div>
						<div class="col-md-9 col-xs-12">
							<div class="row offerheading">
								<div class="col-xs-12 offertitle">
									<span class="offertitlenum"><%=skipCount%>. &nbsp;</span> <a
										id="offerdetails<%= count %>"
										onclick="return triggerModal('#offermodal','#offerdetails','<%= orgUrl %>','<%= offerUrl %>',<%= count %>,'<%= offerId %>',<%=Integer.toString(results.size())%>); "
										href="<portlet:actionURL>
                        <portlet:param name="action" value="showOffer" />
                        <portlet:param name="offerId" value="<%= offerId %>" />
                        <portlet:param name="modal" value="false" />
                        </portlet:actionURL>"
										target="_blank"><%= offer.getTitle() %></a> <br /> <small><spring:message
											code="<%= type.getMsgProperty() %>" /> / <spring:message
											code="<%= workType.getMsgProperty() %>" /><%= workTime %></small>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 offerdescr">
									<%= offer.getDescription() %><br />
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 offercats">
							<strong><spring:message code="search.offer.categories" /></strong>:
							<%= AHOfferLocalServiceUtil.getCategoriesByOfferAsString(offer.getOfferId(), E_CategoryType.SEARCH.getIntValue()) %>
						</div>
					</div>
				</div>
				<div id="offermap<%= skipCount %>" class="col-xs-3 offermap">
				<% if (Constants.PORTAL_MODE == Constants.PORTAL_MODE_OFFLINE) {
					%>
					 <a
                    id="offerdetails<%= count %>"
                    onclick="return triggerModal('#offermodal','#offerdetails','<%= orgUrl %>','<%= offerUrl %>',<%= count %>,'<%= offerId %>',<%=Integer.toString(results.size())%>); "
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
			</div>
			<% if (Constants.PORTAL_MODE != Constants.PORTAL_MODE_OFFLINE && addr != null && addr.getCoordLat() != 0 && addr.getCoordLon() != 0) { %>
			<script>
				    $(function() {
				    	var imgelem = addSearchMap("#offermap","#offerdetails",<%=  skipCount %>,<%= addr.getCoordLat() %>,<%= addr.getCoordLon() %>);
				    	if (imgelem != undefined) {
				    		$("#offer<%=skipCount %> .offertitlenum").empty();
				    		$("#offer<%=skipCount %> .offertitlenum").append(imgelem);
				    	}
				    })
				    </script>
			<%
			     } else {
			    	 if (addr == null)
			    	  log.warn("Offer "+offerId+" has no address!");
			    	 else if (addr.getCoordLat() == 0 && addr.getCoordLon() == 0) {
			    		 log.warn("Offer "+offerId+" has no coordinates!");
			    	 } else
			    		 log.warn("Offer "+offerId+" has no valid coordinates "+addr.getCoordLat()+","+addr.getCoordLon());
			     }
			    }

			    // PAGINATION START
			     if (resultSize > max) {
			         %>

			<nav class="text-right">
				<ul class="pagination pagination-lg">
					<%
			            if (pageNum != 1) {
			          %>
					<li><a
						onclick="return searchPagination(<%=  Integer.toString(resultSkip-max)  %>)"
						href="<portlet:renderURL>
                    <portlet:param name="resultSkip" value="<%=  Integer.toString(resultSkip-max)  %>" />
                    <portlet:param name="items" value="<%=  itemIdSb.toString() %>" />
                    <portlet:param name="types" value="<%=  typeSb.toString() %>" />
                    <portlet:param name="orgId" value="<%=  orgIdStr %>" />
                    </portlet:renderURL>"><span
							aria-hidden="true">&laquo;</span></a></li>
					<%
			            }
			          String liclass = "";
			          for (int i=1;i<=pagesNum;i++) {
			            liclass = "";
			            if (i == pageNum)
			              liclass = "active";
			            %>
					<li class="<%= liclass %>"><a
						onclick="return searchPagination(<%=  Integer.toString((i-1)*max)  %>)"
						href="<portlet:renderURL>
                    <portlet:param name="resultSkip" value="<%=  Integer.toString((i-1)*max)  %>" />
                    <portlet:param name="items" value="<%=  itemIdSb.toString() %>" />
                    <portlet:param name="types" value="<%=  typeSb.toString() %>" />
                    <portlet:param name="orgId" value="<%=  orgIdStr %>" />
                    </portlet:renderURL>"><%= Integer.toString(i) %></a></li>
					<%
			          }
			         
			          if (pageNum != pagesNum) {
			         %>
					<li><a
						onclick="return searchPagination(<%=  Integer.toString(resultSkip+max)  %>)"
						href="<portlet:renderURL>
                    <portlet:param name="resultSkip" value="<%=  Integer.toString(resultSkip+max)  %>" />
                    <portlet:param name="items" value="<%=  itemIdSb.toString() %>" />
                    <portlet:param name="types" value="<%=  typeSb.toString() %>" />
                    <portlet:param name="orgId" value="<%=  orgIdStr %>" />
                    </portlet:renderURL>"><span
							aria-hidden="true">&raquo;</span></a></li>
					<%
			          }
			          %>
				</ul>
			</nav>

			<%
			         }
			     // PAGINATION END
			      %>
		</div>
	</div>

	<%
    
  } else {
	  %>
	<div class="row">
		<div class="col-xs-12 alert alert-info">
			<spring:message code="search.form.results.empty" />
		</div>
	</div>
	<%
  }
  
  %>
</div>

<script>
$(".offercats").hide();
</script>

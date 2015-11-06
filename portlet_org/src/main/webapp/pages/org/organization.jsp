
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomLockServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomOrgServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_TableColumn"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOffer"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOrg"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil"%>
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
  
  try {
 
  String userMail = user.getEmailAddress();
  AHOrg organisation = null;
  if (userMail != null)
	  organisation = CustomOrgServiceHandler.getOrgByLiferayUser(themeDisplay);
  
  log.debug("Got organisation for "+userMail+": "+(organisation != null));
  
  boolean isOrgOwner = organisation != null && organisation.getOwner().trim().toLowerCase().equals(userMail.trim().toLowerCase());
  
  String requestTabId = request.getParameter("tabId");
  if (requestTabId == null)
      requestTabId = (String) request.getAttribute("tabId");
  if (requestTabId == null)
    requestTabId = "offer";
  
  String offerTabClass = "";
  String offerColumn = E_TableColumn.OFFER_UPDATED.toString();
  offerColumn = ParamUtil.get(request, "column", offerColumn);
  String profileTabClass = "";
  String statsTabClass = "";
  String userTabClass = "";
  if (requestTabId.equals("offer")) {
	  offerTabClass = "active";
  }
  else if (requestTabId.equals("profile"))
	  profileTabClass = "active";
  else if (requestTabId.equals("stats"))
	  statsTabClass = "active";
  else if (requestTabId.equals("user"))
	    userTabClass = "active";
  
  String tablePage = request.getParameter("page");

  String orderStr = ParamUtil.get(request, "order", E_OrderType.ASC.toString());
  E_OrderType order = null;
  try {
   order = E_OrderType.valueOf(orderStr);
  } catch (Throwable t) {}
  
  %>

<div class="container-fluid">

  <!-- if demo-mode enabled, notify about denied actions -->
  <liferay-ui:error key="common.demo.denied">
       <spring:message code="common.demo.denied" />
   </liferay-ui:error>

	<div class="page-header">
		<div class="row">
			<div class="col-md-8">
				<h1>
					<spring:message code="org.intern.jsp.title" />
					&nbsp;&nbsp;<small><spring:message
							code="org.intern.jsp.descr" /></small>
				</h1>
			</div>
			<% if (organisation != null) { %>
			<div class="col-md-4 text-right">
				<spring:message code="org.intern.contact.intro" />
				<br /> <a
					href="mailto:<%= CustomPortalServiceHandler.getConfigValue(E_ConfigKey.MGMT_CONTACT_MAIL) %>?subject=<spring:message code="org.intern.contact.subject"/>&body=<spring:message code="org.intern.contact.opening"/>%0A%0A<spring:message code="org.intern.contact.footer"/>%0A<%= organisation.getName() %>"
					class="btn btn-default"><span
					class="glyphicon glyphicon-envelope"></span>&nbsp;<spring:message
						code="org.intern.contact.button" /></a>
			</div>
			<% } %>
		</div>

	</div>

	<%
  if (organisation == null) {
	  %>

	<div class="alert alert-error">
		<spring:message code="org.intern.noorg" />
	</div>

	<%
	
  } else if (E_OrgStatus.findByValue(organisation.getStatus()).equals(E_OrgStatus.NEW) || E_OrgStatus.findByValue(organisation.getStatus()).equals(E_OrgStatus.CHANGED)) {
	  %>
	<div class="alert alert-warning">
		<spring:message code="org.intern.neworg" />
	</div>
	<%
  } else if (E_OrgStatus.findByValue(organisation.getStatus()).equals(E_OrgStatus.DISABLED)){
	    %>
	<div class="alert alert-warning">
		<spring:message code="org.intern.disabledorg" />
	</div>
	<%
	}  else {
 
  if (isOrgOwner && organisation.getLogoLocation() == null || organisation.getLogoLocation().trim().length() == 0 ) {
	  %>
	<div class="alert alert-success alert-dismissible" role="alert">
		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<spring:message code="org.intern.nologoorg" />
	</div>
	<%
  }
		
 %>

	<div role="tabpanel">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="<%=offerTabClass%>"><a
				href="#offer" aria-controls="offer" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-map-marker"></span>&nbsp;<spring:message
						code="org.intern.tabs.offer.title" /></a></li>
			<li role="presentation" class="<%=profileTabClass%>"><a
				href="#profile" aria-controls="profile" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-globe"></span>&nbsp;<spring:message
						code="org.intern.tabs.profile.title" /></a></li>
			<li role="presentation" class="<%=userTabClass%>"><a
				href="#user" aria-controls="user" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-user"></span>&nbsp;<spring:message
						code="org.intern.tabs.user.title" /></a></li>
			<li role="presentation" class="<%=statsTabClass%>"><a
				href="#stats" aria-controls="stats" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-equalizer"></span>&nbsp;<spring:message
						code="org.intern.tabs.stats.title" /></a></li>
		</ul>

		<!-- Tab panes -->
		<div class="tab-content" style="min-height: 300px;">
			<div role="tabpanel" class="tab-pane <%=offerTabClass%>" id="offer">
				<small><spring:message code="org.intern.tabs.offer.descr" /></small>
				<%
       int offerSize = AHOfferLocalServiceUtil.countOffersForOrganization(organisation.getOrgId());
  
      
        if (offerSize == 0) {
        	%>

				<div class="alert alert-info">
					<spring:message code="org.intern.tabs.offer.empty" />
				</div>

				<%
        } else {
        %>
				<table class="table" style="margin-bottom: 50px;">
					<tr>
						<th><spring:message code="org.intern.tabs.offer.table.type" />&nbsp;
							<a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_TYPE.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_TYPE.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_TYPE.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_TYPE.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="org.intern.tabs.offer.table.title" />&nbsp;
							<a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_TITLE.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_TITLE.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_TITLE.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_TITLE.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message
								code="org.intern.tabs.offer.table.categories" /></th>
						<th><spring:message
								code="org.intern.tabs.offer.table.workType" /></th>
						<th><spring:message
								code="org.intern.tabs.offer.table.workTime" /></th>
						<th><spring:message
								code="org.intern.tabs.offer.table.updated" />&nbsp; <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_UPDATED.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_UPDATED.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_UPDATED.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_UPDATED.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message
								code="org.intern.tabs.offer.table.publish" />&nbsp; <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_PUBLISH.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_PUBLISH.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_PUBLISH.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_PUBLISH.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message
								code="org.intern.tabs.offer.table.expires" />&nbsp; <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_EXPIRE.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_EXPIRE.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_EXPIRE.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_EXPIRE.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="org.intern.tabs.offer.table.status" />&nbsp;
							<a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_STATUS.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_STATUS.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= offerColumn.equals(E_TableColumn.OFFER_STATUS.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="column" value="<%= E_TableColumn.OFFER_STATUS.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th></th>
					</tr>


					<%

        
        int skip = 0;
        int max = 5;
        // only check if tab is active
        if (offerTabClass.trim().length() > 0 && tablePage != null) {
          try {
            skip = Integer.parseInt(tablePage)-1;
          } catch (Throwable t) {
            skip = 0;
          }
          if (skip < 0)
            skip = 0;
          else
            skip*=max;
        }
        int start = skip;
        int end = start+max;
        if (end >= offerSize)
          end = offerSize;
        int pagesnum = offerSize/max;
        int pagenum = (start+max)/max;
        
        List<AHOffer> offers = AHOfferLocalServiceUtil.getOffersForOrganization(organisation.getOrgId(), start, end, E_TableColumn.valueOf(offerColumn).getColName(), order);
        
        for (AHOffer offer: offers) {
        	E_OfferType type = E_OfferType.findByValue(offer.getType());
        	E_OfferStatus status = E_OfferStatus.findByValue(offer.getStatus());
        	String title = offer.getTitle();
        	String hours = offer.getWorkTime();
        	//String strHours = hours > 0 ? hours+"h" : "-";
        	E_OfferWorkType workType = E_OfferWorkType.findByValue(offer.getWorkType());
        	if (workType == null)
        		workType = E_OfferWorkType.NONE;
        	long updated = offer.getUpdated();
        	long expires = offer.getExpires();
        	long publish = offer.getPublish();
        	String strUpdated = "";
        	String strExpires = "";
        	String strPublish = "";
        	if (updated > 0) {
        		strUpdated =  CustomServiceUtils.formatZoneDateTime(updated);
        	} 
        	if (expires > 0) {
        		  strExpires =  CustomServiceUtils.formatZoneDateTime(expires);
          } 
        	if (publish > 0) {
                strPublish = CustomServiceUtils.formatZoneDateTime(publish);
          } 
        	String strCategories = AHOfferLocalServiceUtil.getCategoriesByOfferAsString(offer.getOfferId(), E_CategoryType.SEARCH);
        	
        	String statusClass = "";
        	if (status.equals(E_OfferStatus.NEW) || status.equals(E_OfferStatus.CHANGED)) {
        		statusClass = "text-info";
        	}
        	else if (status.equals(E_OfferStatus.DISABLED))
                statusClass = "text-error";
        	else if (status.equals(E_OfferStatus.VALIDATED))
                statusClass = "text-success";
        	%>
					<tr>
						<td><spring:message code="<%= type.getMsgProperty() %>" /></td>
						<td><a
							title="<spring:message code="mgmt.tabs.org.item.action.view"/>"
							href="<portlet:actionURL>
                         <portlet:param name="action" value="viewOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><%= title %></a></td>
						<td><%= strCategories %></td>
						<td><spring:message code="<%= workType.getMsgProperty() %>" /></td>
						<td><%= hours %></td>
						<td><%= strUpdated %></td>
						<td><%= strPublish %></td>
						<td><%= strExpires %></td>
						<td class="<%= statusClass %>"><spring:message
								code="<%= status.getMsgProperty() %>" /></td>
						<td>
							<div class="btn-group pull-right">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-expanded="false">
									<spring:message code="org.intern.tabs.offer.item.action.title" />
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a
										href="<portlet:actionURL>
                         <portlet:param name="action" value="viewOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><span
											class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>&nbsp;&nbsp;<spring:message
												code="org.intern.tabs.offer.item.action.view" /></a></li>
									<%
                 
                 String editIcon = "glyphicon-pencil";
                 String deleteIcon = "glyphicon-trash";
                 String textClass = "";
                 boolean isLocked = CustomLockServiceHandler.isLocked(AHOffer.class.getName(), offer.getOfferId(), themeDisplay); 
                 if (isLocked) {
                	 deleteIcon = "glyphicon-lock";
                	 editIcon = "glyphicon-lock";
                	 textClass = "text-error";
                	 textClass+=" disabled";
                 } 
                 
                 %>
									<li class="<%=textClass%>"><a
										href="<portlet:actionURL>
                         <portlet:param name="action" value="editOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><span
											class="glyphicon <%= editIcon %>" aria-hidden="true"></span>&nbsp;&nbsp;<spring:message
												code="org.intern.tabs.offer.item.action.edit" /></a></li>
									<li class="divider"></li>
									<li><a
										href="<portlet:actionURL>
                         <portlet:param name="action" value="copyOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><span
											class="glyphicon glyphicon-duplicate" aria-hidden="true"></span>&nbsp;&nbsp;<spring:message
												code="org.intern.tabs.offer.item.action.copy" /></a></li>
									<li class="<%=textClass%>"><a class="<%= demoDisabled %>" 
										onclick="createModal('#modal','<spring:message code="org.intern.tabs.offer.item.action.deleteHeader"/>','<spring:message code="org.intern.tabs.offer.item.action.deleteBody"/><%= offer.getTitle().replaceAll("'","") %>','<spring:message code="org.intern.tabs.offer.item.action.deleteAbort"/>','<spring:message code="org.intern.tabs.offer.item.action.deleteOk"/>','<portlet:actionURL>
                         <portlet:param name="action" value="deleteOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>')"><span
											class="glyphicon <%= deleteIcon %>" aria-hidden="true"></span>&nbsp;&nbsp;<spring:message
												code="org.intern.tabs.offer.item.action.delete" /></a></li>
								</ul>
							</div>
						</td>
					</tr>
					<%
        }
        
        %>

				</table>

				<%
         // add pagination if more offers
         if (offerSize > max) {
         %>

				<nav>
					<ul class="pagination pagination-lg">
						<%
            String prevClass = "";
            String nextClass = "";
            
            if (pagenum != 1) {
          %>

						<li class="<%=prevClass%>"><a
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="page" value="<%= Integer.toString(pagenum-1) %>" />
                       </portlet:renderURL>"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						<%
            }
          String liclass = "";
          for (int i=1;i<=pagesnum+1;i++) {
            liclass = "";
            if (i == pagenum)
              liclass = "active";
            %>
						<li class="<%= liclass %>"><a
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="page" value="<%= Integer.toString(i) %>" />
                         <portlet:param name="column" value="<%= offerColumn %>" />
                         <portlet:param name="order" value="<%= orderStr %>" />
                       </portlet:renderURL>"><%= Integer.toString(i) %></a></li>
						<%
          }
         
          if (pagenum != (pagesnum+1)) {
         %>
						<li class="<%=nextClass%>"><a
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="page" value="<%= Integer.toString(pagenum+1) %>" />
                         <portlet:param name="column" value="<%= offerColumn %>" />
                         <portlet:param name="order" value="<%= orderStr %>" />
                       </portlet:renderURL>"
							aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						<%
          }
          %>
					</ul>
				</nav>

				<%
         }
        %>

				<%
        }
      %>

				<a class="btn btn-primary btn-lg"
					href="<portlet:actionURL>
        <portlet:param name="action" value="prepareOffer" />
        </portlet:actionURL>"><span
					class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				<spring:message code="org.intern.tabs.offer.add" /> </a>
			</div>
			<div role="tabpanel" class="tab-pane  <%=profileTabClass%>"
				id="profile">
				<small><spring:message code="org.intern.tabs.profile.descr" /></small>
				<jsp:include page="../shared/register.jsp"></jsp:include>
			</div>
			<div role="tabpanel" class="tab-pane  <%=userTabClass%>" id="user">
				<small><spring:message code="org.intern.tabs.user.descr" /></small>
				<%
          String userList = organisation.getUserlist();
          if (userList != null && userList.trim().length() > 0) {
        	  %>
				<table class="table" style="margin-bottom: 50px;">
					<tr>
						<th><spring:message code="org.intern.tabs.user.table.name" /></th>
						<th><spring:message code="org.intern.tabs.user.table.mail" /></th>
					</tr>
					<%
              String[] userArray = userList.split(",");
              for (String mail : userArray) {
            	  User orgUser = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), mail);
            	  %>
					<tr>
						<td><%= user.getFullName() %></td>
						<td><%= mail %></td>
					</tr>
					<%
              }
              %>
				</table>
				<%
          } else {
        	  %>
				<div class="alert alert-info">
					<spring:message code="org.intern.tabs.user.empty" />
				</div>
				<%
          }
          
          if (isOrgOwner) {
        	  %>
				<div class="jumbotron">
					<h2>
						<spring:message code="org.intern.tabs.user.form.addUser.title" />
					</h2>
					<p>
						<portlet:actionURL var="addUserUrl">
							<portlet:param name="action" value="addUser" />
						</portlet:actionURL>
						<form:form modelAttribute="userData" id="addUserForm"
							data-ajax="false" method="post" action="${addUserUrl}">
							<fieldset <%= demoDisabled %>>
								<bform:bffield path="forename"
									label="org.intern.tabs.user.form.addUser.field.forename"
									type="text" />
								<bform:bffield path="forename"
									label="org.intern.tabs.user.form.addUser.field.surname"
									type="text" />
								<bform:bffield path="mail"
									label="org.intern.tabs.user.form.addUser.field.mail" type="text" />
								<button type="submit" class="btn btn-lg btn-default">
									<span class="glyphicon glyphicon-ok"></span>&nbsp;
									<spring:message code="org.intern.tabs.user.form.addUser.submit" />
								</button>
							</fieldset>
						</form:form>
					</p>
				</div>
				<%
          }
        %>
			</div>
			<div role="tabpanel" class="tab-pane  <%=statsTabClass%>" id="stats">
				<small><spring:message code="org.intern.tabs.stats.descr" /></small>
			</div>
		</div>

	</div>

	<%
  } // organisation not null
%>
</div>

<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>

<%
  } catch (Throwable t) {
	  log.error(t);
  }
%>
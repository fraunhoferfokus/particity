
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="org.springframework.web.util.HtmlUtils"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigRole"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomLockServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.socialize.I_SocialMediaClient"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.socialize.SocialMediaFactory"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.E_SocialMediaPlugins"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigDomain"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OrderType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_TableColumn"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_CategoryType"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigCategory"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHSubscription"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferWorkType"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferStatus"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OfferType"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOfferLocalServiceUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOffer"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_OrgStatus"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHOrg"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHOrgLocalServiceUtil"%>
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
 
  //List<AHCategories> categories = AHCategoriesLocalServiceUtil.getCategories(E_CategoryType.SEARCH);
  
  
  String requestTabId = request.getParameter("tabId");
  if (requestTabId == null)
	    requestTabId = (String) request.getAttribute("tabId");
  if (requestTabId == null)
	  requestTabId = "orgs";
  
  String orgsTabClass = "";
  String orgColumn = E_TableColumn.ORG_UPDATED.toString();
  String offerTabClass = "";
  String offerColumn = E_TableColumn.OFFER_UPDATED.toString();
  String userTabClass = "";
  String cfgTabClass = "";
  String columnStr = "";
  if (requestTabId.equals("orgs")) {
	  orgsTabClass = "active";
	  orgColumn = ParamUtil.get(request, "column", orgColumn);
  }
  else if (requestTabId.equals("offer")) {
	  offerTabClass = "active";
	  offerColumn = ParamUtil.get(request, "column", offerColumn);
  }
  else if (requestTabId.equals("user")) {
	    userTabClass = "active";
  }
  else if (requestTabId.equals("cfg")) {
      cfgTabClass = "active";
  }
  
  log.info("Offer column is: "+offerColumn+", Orgcolumn is: "+orgColumn);
  
  String orderStr = ParamUtil.get(request, "order", E_OrderType.DESC.toString());
  E_OrderType order = null;
  try {
   order = E_OrderType.valueOf(orderStr);
  } catch (Throwable t) {}
  
  String tablePage = request.getParameter("page");
  String cfgCollaps = request.getParameter("cfgId");
  if (cfgCollaps == null)
	  cfgCollaps = "";
  
  int orgChangedSize = AHOrgLocalServiceUtil.countNewOrg();
  int offerChangedSize = AHOfferLocalServiceUtil.countNewOffer();
  
  boolean fbEnabled = CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.SOCIAL_FB_ENABLED);
  boolean twEnabled = CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.SOCIAL_TW_ENABLED);
  
  %>

<div class="container-fluid">

  <!-- if demo-mode enabled, notify about denied actions -->
  <liferay-ui:error key="common.demo.denied">
       <spring:message code="common.demo.denied" />
   </liferay-ui:error>

	<div class="page-header">
		<h1>
			<spring:message code="mgmt.jsp.title" />
			&nbsp;&nbsp;<small><spring:message code="mgmt.jsp.descr" /></small>
		</h1>
	</div>
	<div role="tabpanel">

		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="<%= orgsTabClass %>"><a
				href="#orgs" aria-controls="orgs" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-globe"></span>&nbsp;<spring:message
						code="mgmt.tabs.org.title" /> <%
      if (orgChangedSize > 0) {
    	  %> <span class="badge badge-primary"><%= Integer.toString(orgChangedSize) %></span>
					<%
      }
      %> </a></li>
			<li role="presentation" class="<%= offerTabClass %>"><a
				href="#offer" aria-controls="offer" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-map-marker"></span>&nbsp;<spring:message
						code="mgmt.tabs.offer.title" /> <%
      if (offerChangedSize > 0) {
        %> <span class="badge badge-primary"><%= Integer.toString(offerChangedSize) %></span>
					<%
      }
      %> </a></li>
			<li role="presentation" class="<%= userTabClass %>"><a
				href="#user" aria-controls="user" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-user"></span>&nbsp;<spring:message
						code="mgmt.tabs.user.title" /></a></li>
			<li role="presentation" class="<%= cfgTabClass %>"><a
				href="#cfg" aria-controls="cfg" role="tab" data-toggle="tab"><span
					class="glyphicon glyphicon-cog"></span>&nbsp;<spring:message
						code="mgmt.tabs.cfg.title" /></a></li>

		</ul>

		<!-- Tab panes -->
		<div class="tab-content" style="padding-bottom: 100px;">
			<!-- ORGANISATION START -->
			<div role="tabpanel" class="tab-pane <%= orgsTabClass %>" id="orgs">
				<small><spring:message code="mgmt.tabs.org.descr" /></small>
				<hr />
				<%
     int orgSize = AHOrgLocalServiceUtil.getAHOrgsCount();
     
     if (orgSize == 0) {
    	 
    	 %>

				<div class="alert alert-info">
					<spring:message code="mgmt.tabs.org.empty" />
				</div>


				<%
    	 
     } else {
       %>
				<table class="table">
					<tr>
						<th><spring:message code="mgmt.table.org.name" />&nbsp; <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_NAME.toString()) && order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="orgs" />
                         <portlet:param name="column" value="<%= E_TableColumn.ORG_NAME.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_NAME.toString()) && order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="orgs" />
                         <portlet:param name="column" value="<%= E_TableColumn.ORG_NAME.toString() %>" />
                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="mgmt.table.org.holder" />&nbsp; <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_HOLDER.toString()) &&  order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                           <portlet:param name="tabId" value="orgs" />
                           <portlet:param name="column" value="<%= E_TableColumn.ORG_HOLDER.toString() %>" />
                           <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                         </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_HOLDER.toString()) &&  order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                           <portlet:param name="tabId" value="orgs" />
                           <portlet:param name="column" value="<%= E_TableColumn.ORG_HOLDER.toString() %>" />
                           <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                         </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="mgmt.table.org.user" /></th>
						<th><spring:message code="mgmt.table.org.status" />&nbsp; <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_STATUS.toString()) &&  order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                           <portlet:param name="tabId" value="orgs" />
                           <portlet:param name="column" value="<%= E_TableColumn.ORG_STATUS.toString() %>" />
                           <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                         </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_STATUS.toString()) &&  order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                           <portlet:param name="tabId" value="orgs" />
                           <portlet:param name="column" value="<%= E_TableColumn.ORG_STATUS.toString() %>" />
                           <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                         </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="mgmt.table.org.created" />&nbsp; <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_CREATED.toString()) &&  order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
	                         <portlet:param name="tabId" value="orgs" />
	                         <portlet:param name="column" value="<%= E_TableColumn.ORG_CREATED.toString() %>" />
	                         <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
	                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_CREATED.toString()) &&  order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
	                         <portlet:param name="tabId" value="orgs" />
	                         <portlet:param name="column" value="<%= E_TableColumn.ORG_CREATED.toString() %>" />
	                         <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
	                       </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="mgmt.table.org.updated" />&nbsp; <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_UPDATED.toString()) &&  order.equals(E_OrderType.DESC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                           <portlet:param name="tabId" value="orgs" />
                           <portlet:param name="column" value="<%= E_TableColumn.ORG_UPDATED.toString() %>" />
                           <portlet:param name="order" value="<%= E_OrderType.DESC.toString() %>" />
                         </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.desc"/>"> <span
								class="glyphicon glyphicon-chevron-up"></span>
						</a> <a
							class="<%= orgColumn.equals(E_TableColumn.ORG_UPDATED.toString()) &&  order.equals(E_OrderType.ASC) ? "disabled" : "" %>"
							href="<portlet:renderURL>
                           <portlet:param name="tabId" value="orgs" />
                           <portlet:param name="column" value="<%= E_TableColumn.ORG_UPDATED.toString() %>" />
                           <portlet:param name="order" value="<%= E_OrderType.ASC.toString() %>" />
                         </portlet:renderURL>"
							data-toggle="tooltip" data-placement="top"
							title="<spring:message code="common.table.sort.asc"/>"> <span
								class="glyphicon glyphicon-chevron-down"></span>
						</a></th>
						<th><spring:message code="mgmt.table.org.lastOffer" /></th>
						<th></th>
					</tr>
					<% 
       
       
       int skip = 0;
       int max = 5;
       // only check if tab is active
       if (orgsTabClass.trim().length() > 0 && tablePage != null) {
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
       if (end >= orgSize)
         end = orgSize;
       
       //log.info("Got "+orgSize+" organisations!");
       int pagesnum = orgSize/max;
       int pagenum = (start+max)/max;
       List<AHOrg> organisations = null;
       
       try {
    	   //log.info("Got "+orgSize+" organisations, listing from "+start+"-"+end);
    	   organisations = AHOrgLocalServiceUtil.getOrganisations(start, end, E_TableColumn.valueOf(orgColumn).getColName(), order.name());
       } catch (Throwable t) {
    	   log.warn(t);
       }
       
       if (organisations != null) {
	    	 for (AHOrg organisation: organisations) {
	    		 E_OrgStatus status = E_OrgStatus.findByValue(organisation.getStatus());
	    		 long lastOffer = -1;
	    		 AHOffer offer = AHOfferLocalServiceUtil.getLastOfferForOrganization(organisation.getOrgId());
	    		 if (offer != null) {
	    			 lastOffer = offer.getUpdated();
	    		 }
	    		 long created = organisation.getCreated();
	    		 long updated = organisation.getUpdated();
	    		 String strCreated = "-";
	    		 String strUpdated = "-";
	    		 String strLastOffer = "-";
	    		 if (created > 0) {
	    			 strCreated = CustomServiceUtils.formatZoneDateTime(created);
	    		 }
	    		 if (lastOffer > 0) {
	    	     strLastOffer = CustomServiceUtils.formatZoneDateTime(lastOffer);
	    		 }
	    		 if (updated > 0) {
	    			 strUpdated = CustomServiceUtils.formatZoneDateTime(updated);
	    		 }
	    		 
	    		 String statusClass="";
	    		 switch (status) {
		    		 case NEW:
		    		 case CHANGED:
		    			 statusClass = "text-info";
		    			 break;
		    		 case VALIDATED:
		    			   statusClass = "text-success";
		    				 break;
		    		 case DISABLED:
		    			 statusClass = "text-error";
	             break;
	    		 }
	       %>
						<tr>
							<td><a
								title="<spring:message code="mgmt.tabs.org.item.action.view"/>"
								href="<portlet:actionURL>
	                         <portlet:param name="action" value="viewOrg" />
	                         <portlet:param name="orgId" value="<%= Long.toString(organisation.getOrgId()) %>" />
	                       </portlet:actionURL>"><%= organisation.getName() %></a></td>
							<td><%= organisation.getHolder() %></td>
							<td><%= organisation.getOwner() %></td>
							<td class="<%= statusClass %>"><spring:message
									code="<%= status.getMsgProperty() %>" /></td>
							<td><%= strCreated %></td>
							<td><%= strUpdated %></td>
							<td><%= strLastOffer %></td>
							<td>
								<div class="btn-group">
									<button type="button" class="btn btn-default dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										<spring:message code="mgmt.tabs.org.item.action.title" />
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a
											href="<portlet:actionURL>
	                         <portlet:param name="action" value="viewOrg" />
	                         <portlet:param name="orgId" value="<%= Long.toString(organisation.getOrgId()) %>" />
	                       </portlet:actionURL>"><span
												class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>&nbsp;<spring:message
													code="mgmt.tabs.org.item.action.view" /></a></li>
										<%
	                 if (!status.equals(E_OrgStatus.VALIDATED)) {
	                	 %>
										<li class="<%= statusClass %>"><a
											href="<portlet:actionURL>
	                         <portlet:param name="action" value="viewOrg" />
	                         <portlet:param name="actionType" value="approve" />
	                         <portlet:param name="orgId" value="<%= Long.toString(organisation.getOrgId()) %>" />
	                       </portlet:actionURL>"><span
												class="glyphicon glyphicon-pencil" aria-hidden="true"></span>&nbsp;<spring:message
													code="mgmt.tabs.org.item.action.edit" /></a></li>
										<%
	                 }
	                 %>
										<li class="divider"></li>
										<%
	                 if (!status.equals(E_OrgStatus.DISABLED)) {
	                 %>
										<li><a
											href="<portlet:actionURL>
	                         <portlet:param name="action" value="disableOrg" />
	                         <portlet:param name="orgId" value="<%= Long.toString(organisation.getOrgId()) %>" />
	                       </portlet:actionURL>"><span
												class="glyphicon glyphicon-ban-circle" aria-hidden="true"></span>&nbsp;<spring:message
													code="mgmt.tabs.org.item.action.disable" /></a></li>
										<%
	                 }
	                 %>
										<li><a
											onclick="createModal('#modal','<spring:message code="mgmt.tabs.org.item.action.deleteHeader"/>','<spring:message code="mgmt.tabs.org.item.action.deleteBody"/><%= organisation.getName().replaceAll("'","") %>','<spring:message code="mgmt.tabs.org.item.action.deleteAbort"/>','<spring:message code="mgmt.tabs.org.item.action.deleteOk"/>','<portlet:actionURL>
	                         <portlet:param name="action" value="deleteOrg" />
	                         <portlet:param name="orgId" value="<%= Long.toString(organisation.getOrgId()) %>" />
	                       </portlet:actionURL>')" class="<%= demoDisabled %>"><span
												class="glyphicon glyphicon-trash" aria-hidden="true"></span>&nbsp;<spring:message
													code="mgmt.tabs.org.item.action.delete" /></a></li>
									</ul>
								</div>
							</td>
						</tr>
						<%
		    	 } // organisations-loop
        }
	   	 %>
				</table>

				<%
         // add pagination if more offers
         if (orgSize > max) {
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
                         <portlet:param name="tabId" value="orgs" />
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
                         <portlet:param name="tabId" value="orgs" />
                         <portlet:param name="page" value="<%= Integer.toString(i) %>" />
                         <portlet:param name="column" value="<%= orgColumn %>" />
                         <portlet:param name="order" value="<%= orderStr %>" />
                       </portlet:renderURL>"><%= Integer.toString(i) %></a></li>
						<%
          }
         
          if (pagenum != (pagesnum+1)) {
         %>
						<li class="<%=nextClass%>"><a
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="orgs" />
                         <portlet:param name="page" value="<%= Integer.toString(pagenum+1) %>" />
                         <portlet:param name="column" value="<%= orgColumn %>" />
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

				<div class="row">
					<div class="col-xs-12 text-right">
						<a class="btn btn-default"
							href="<portlet:actionURL>
		                         <portlet:param name="tabId" value="orgs" />
		                         <portlet:param name="action" value="exportOrg" />
		                         <portlet:param name="page" value="<%= Integer.toString(pagenum) %>" />
		                       </portlet:actionURL>"><spring:message
								code="mgmt.tabs.org.export" /></a>
					</div>
				</div>

				<%
    	 
      } // list of organisations is empty
     %>


			</div>
			<!-- ORGANISATION END -->
			<!-- OFFER START -->
			<div role="tabpanel" class="tab-pane <%= offerTabClass %>" id="offer">
				<small><spring:message code="mgmt.tabs.offer.descr" /></small>
				<hr />
				<%
      
      int offersSize = AHOfferLocalServiceUtil.getAHOffersCount();
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
      if (end >= offersSize)
    	  end = offersSize;
      int pagesnum = offersSize/max;
      int pagenum = (start+max)/max;
      List<AHOffer> offers = null;
      
      try {
    	  offers = AHOfferLocalServiceUtil.getOffers(start, end, E_TableColumn.valueOf(offerColumn).getColName(), order.name());
      } catch (Throwable t) {}
      
      if (offers == null || offers.size() == 0) {
         %>

				<div class="alert alert-info">
					<spring:message code="mgmt.tabs.offer.empty" />
				</div>


				<%
      } else {
    	  %>
				<liferay-ui:error key="common.socialize.plugin.publishfail">
					<spring:message code="common.socialize.plugin.publishfail" />
				</liferay-ui:error>
				<table class="table" style="margin-bottom: 20px;">
					<tr>

						<th><spring:message code="mgmt.table.offer.title" />&nbsp; <a
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
						<th><spring:message code="mgmt.table.offer.type" />&nbsp; <a
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
						<th><spring:message code="mgmt.table.offer.org" /></th>
						<th><spring:message code="mgmt.table.offer.categories" /></th>
						<th><spring:message code="mgmt.table.offer.workType" /></th>
						<th><spring:message code="mgmt.table.offer.workTime" /></th>
						<th><spring:message code="mgmt.table.offer.updated" />&nbsp;
							<a
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
						<th><spring:message code="mgmt.table.offer.publish" />&nbsp;
							<a
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
						<th><spring:message code="mgmt.table.offer.expires" />&nbsp;
							<a
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
						<th><spring:message code="mgmt.table.offer.status" />&nbsp; <a
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
						<th><spring:message code="mgmt.table.offer.socialStatus" /></th>
						<th></th>
					</tr>

					<%
        Map<E_SocialMediaPlugins,Boolean> smOnlineMap = new HashMap<E_SocialMediaPlugins, Boolean>();
        log.info("Got "+offers.size()+" offers"+"("+start+","+end+")!"); 
        for (AHOffer offer: offers) {
        	try {
        	long orgId = offer.getOrgId();
        	// if orgId is invalid, assing new one
        	// TODO: this should be done manually in maintenance
        	if (orgId < 0) {
        		List<AHOrg> orgs = AHOrgLocalServiceUtil.getAHOrgs(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        		if (orgs.size() > 0) {
        			orgId = orgs.get(0).getOrgId();
        			offer.setOrgId(orgId);
        			AHOfferLocalServiceUtil.updateAHOffer(offer);
        		}
        		
        	}
        	
        	AHOrg org = AHOrgLocalServiceUtil.getAHOrg(orgId);
          E_OfferType type = E_OfferType.findByValue(offer.getType());
          E_OfferStatus status = E_OfferStatus.findByValue(offer.getStatus());
          String title = offer.getTitle();
          String hours = offer.getWorkTime();
          //String strHours = hours > 0 ? hours+"h" : "-";
          E_OfferWorkType workType = E_OfferWorkType.findByValue(offer.getWorkType());
          long updated = offer.getUpdated();
          long expires = offer.getExpires();
          long publish = offer.getPublish();
          String strUpdated = "";
          String strExpires = "";
          String strPublish = "";
          if (updated > 0) {
            strUpdated = CustomServiceUtils.formatZoneDateTime(updated);
          } 
          if (expires > 0) {
                strExpires = CustomServiceUtils.formatZoneDateTime(expires);
          } 
          if (publish > 0) {
                strPublish = CustomServiceUtils.formatZoneDateTime(publish);
          } 
          String strCategories = AHOfferLocalServiceUtil.getCategoriesByOfferAsString(offer.getOfferId(), E_CategoryType.SEARCH.getIntValue());
          
          String statusClass = "";
          if (status.equals(E_OfferStatus.VALIDATED))
              statusClass = "text-success";
          else if (status.equals(E_OfferStatus.NEW) || status.equals(E_OfferStatus.CHANGED)) {
            statusClass = "text-info";
          }
          else if (status.equals(E_OfferStatus.DISABLED))
                statusClass = "text-error";
          %>
					<tr>
						<td><a
							title="<spring:message code="mgmt.tabs.offer.item.action.view"/>"
							href="<portlet:actionURL>
                         <portlet:param name="action" value="viewOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><%= title %></a></td>
						<td><spring:message code="<%= type.getMsgProperty() %>" /></td>
						<td><a
							title="<spring:message code="mgmt.tabs.org.item.action.view"/>"
							href="<portlet:actionURL>
                         <portlet:param name="action" value="viewOrg" />
                         <portlet:param name="orgId" value="<%= Long.toString(org.getOrgId()) %>" />
                       </portlet:actionURL>"><%= org.getName() %></a></td>
						<td><%= strCategories %></td>
						<td><spring:message code="<%= workType.getMsgProperty() %>" /></td>
						<td><%= hours %></td>
						<td><%= strUpdated %></td>
						<td><%= strPublish %></td>
						<td><%= strExpires %></td>
						<td class="<%= statusClass %>"><spring:message
								code="<%= status.getMsgProperty() %>" /></td>
						<td>
							<%
							if (fbEnabled || twEnabled) {
		            String smLogo;
		            Boolean isOnline;
		            boolean isEnabled;
		            for (E_SocialMediaPlugins sm: E_SocialMediaPlugins.values()) {
		            	isOnline = smOnlineMap.get(sm);
		            	smLogo = "<i class='fa fa-square'></i>";
		            	if (isOnline == null) {
		            		I_SocialMediaClient smclient = SocialMediaFactory.getClient(sm);
		            		// skip display of logo, if not enabled at all
		            		if (!smclient.isEnabled())
		            			continue;
		            		if (smclient.getCssClass() != null)
		            			smLogo = "<span class='"+smclient.getCssClass()+"'></span>";
		            		isOnline = smclient != null && smclient.isConnected();
		            		smOnlineMap.put(sm,isOnline);
		            	}
		            
		            	  if (!status.equals(E_OfferStatus.VALIDATED)) {
		            		  %> <span data-toggle="tooltip" data-placement="top"
									title="<spring:message code="common.socialize.plugin.inactive"/>"
									class="smicon inactive"><%= smLogo %></span> <%
		            	  } else if (!isOnline) {
		                  %> <span data-toggle="tooltip"
									class="smicon noconnect" data-placement="top"
									title="<spring:message code="common.socialize.plugin.noconnect"/>"><%= smLogo %></span>
									<%
		            	  } else if (sm.matchesBitmask(offer.getSocialStatus())) {
		                  %> <span class="smicon" data-toggle="tooltip"
									data-placement="top"
									title="<spring:message code="common.socialize.plugin.published"/>"><%= smLogo %></span>
									<%
		                } else {
					            %> <a data-placement="top" data-toggle="tooltip"
									title="<spring:message code="common.socialize.plugin.publish"/> <spring:message code="<%= sm.getMsgTitleProp() %>"/>"
									href="<portlet:actionURL>
					                         <portlet:param name="action" value="publishSocial" />
					                         <portlet:param name="type" value="<%= sm.toString() %>" />
					                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
					                         <portlet:param name="tabId" value="offer" />
					                         <portlet:param name="page" value="<%= Integer.toString(pagenum) %>" />
					                         <portlet:param name="column" value="<%= offerColumn %>" />
					                         <portlet:param name="order" value="<%= orderStr %>" />
					                       </portlet:actionURL>"
									class="smicon active <%= demoDisabled %>"><%= smLogo %></a> <%
		              }
		            }
							}
            %>
						</td>
						<td>
							<div class="btn-group pull-right">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" aria-expanded="false">
									<spring:message code="mgmt.tabs.offer.item.action.title" />
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<li><a
										href="<portlet:actionURL>
                         <portlet:param name="action" value="viewOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><span
											class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>&nbsp;&nbsp;<spring:message
												code="mgmt.tabs.offer.item.action.view" /></a></li>
									<%
                 
                 String editIcon = "glyphicon-pencil";
                 String textClass = "";
                 boolean isLocked = CustomLockServiceHandler.isLocked(AHOffer.class.getName(), offer.getOfferId(), themeDisplay); 
                 if (isLocked) {
                   editIcon = "glyphicon-lock";
                   textClass = "text-error";
                   textClass+=" disabled";
                 } 
                 if (status.equals(E_OfferStatus.NEW) || status.equals(E_OfferStatus.CHANGED)) {
                 %>
									<li class="<%=textClass%>"><a
										href="<portlet:actionURL>
                         <portlet:param name="action" value="editOffer" />
                         <portlet:param name="offerId" value="<%= Long.toString(offer.getOfferId()) %>" />
                       </portlet:actionURL>"><span
											class="glyphicon <%= editIcon %>" aria-hidden="true"></span>&nbsp;&nbsp;<spring:message
												code="mgmt.tabs.offer.item.action.approve" /></a></li>
									<%
                 }
                 %>
								</ul>
							</div>
						</td>
					</tr>
					<%
        	} catch (Throwable t) {
        		log.error(t);
        	}
        }
        
        %>

				</table>

				<%
         // add pagination if more offers
         if (offersSize > max) {
         %>

				<nav>
					<ul class="pagination pagination-lg">
						<%
            String prevClass = "";
            String nextClass = "";
            
            	//prevClass = "disabled";
            
            if (pagenum != 1) {
          %>

						<li class="<%=prevClass%>"><a
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="offer" />
                         <portlet:param name="page" value="<%= Integer.toString(pagenum-1) %>" />
                         <portlet:param name="column" value="<%= offerColumn %>" />
                         <portlet:param name="order" value="<%= orderStr %>" />
                       </portlet:renderURL>"
							aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
						<%
            }
          String liclass = "";
          for (int i=1;i<=(pagesnum+1);i++) {
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
                       </portlet:renderURL>"
							aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						<%
          }
          %>
					</ul>
				</nav>

				<%
         }
      }
      
      %>

			</div>
			<!-- OFFER END -->
			<!-- USER START -->
			<div role="tabpanel" class="tab-pane <%= userTabClass %>" id="user">
				<small><spring:message code="mgmt.tabs.user.descr" /></small>
				<hr />
				<%
      int userSize = AHSubscriptionLocalServiceUtil.getAHSubscriptionsCount();
      skip = 0;
      max = 5;
      if (userTabClass.trim().length() > 0 && tablePage != null) {
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
      start = skip;
      end = start+max;
      if (end >= userSize)
        end = userSize;
      pagesnum = offersSize/max;
      pagenum = (start+max)/max;
      List<AHSubscription> subscriptions = null;
      
      try {
    	  subscriptions = AHSubscriptionLocalServiceUtil.getAHSubscriptions(start, end); 
      } catch (Throwable t) {}
      
      if (subscriptions == null || subscriptions.size() == 0) {
         %>

				<div class="alert alert-info">
					<spring:message code="mgmt.tabs.user.empty" />
				</div>


				<%
      } else {
        %>
				<table class="table" style="margin-bottom: 20px;">
					<tr>
						<th><spring:message code="mgmt.table.user.mail" /></th>
						<th><spring:message code="mgmt.table.user.created" /></th>
						<th><spring:message code="mgmt.table.user.status" /></th>
					</tr>

					<%
        log.info("Got "+subscriptions.size()+" subscriptions"+"("+start+","+end+")!"); 
        for (AHSubscription subscription: subscriptions) {
          try { 
          String created = CustomServiceUtils.formatZoneDateTime(subscription.getCreated());
        	E_SubscriptionStatus status = E_SubscriptionStatus.findByValue(subscription.getStatus());
          
          String statusClass = "";
          if (status.equals(E_SubscriptionStatus.VALIDATED))
              statusClass = "text-success";
          else if (status.equals(E_SubscriptionStatus.NEW)) {
            statusClass = "text-info";
          }
          %>
					<tr>
						<td><%= subscription.getEmail() %></td>
						<td><%= created %></td>
						<td><spring:message code="<%= status.getMsgProperty() %>" /></td>
					</tr>
					<%
          } catch (Throwable t) {
            log.error(t);
          }
        }
        
        %>

				</table>

				<%
         // add pagination if more offers
         if (userSize > max) {
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
                         <portlet:param name="tabId" value="user" />
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
                         <portlet:param name="tabId" value="user" />
                         <portlet:param name="page" value="<%= Integer.toString(i) %>" />
                       </portlet:renderURL>"><%= Integer.toString(i) %></a></li>
						<%
          }
         
          if (pagenum != (pagesnum+1)) {
         %>
						<li class="<%=nextClass%>"><a
							href="<portlet:renderURL>
                         <portlet:param name="tabId" value="user" />
                         <portlet:param name="page" value="<%= Integer.toString(pagenum+1) %>" />
                       </portlet:renderURL>"
							aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
						<%
          }
          %>
					</ul>
				</nav>

				<%
         }
      }
      
      %>

				<div class="row">
					<div class="col-xs-12 text-right">
						<a class="btn btn-default"
							href="<portlet:actionURL>
                <portlet:param name="tabId" value="user" />
                <portlet:param name="action" value="exportUser" />
                <portlet:param name="page" value="<%= Integer.toString(pagenum) %>" />
              </portlet:actionURL>"><spring:message
								code="mgmt.tabs.user.export" /></a>
					</div>
				</div>


			</div>
			<!-- USER END -->
			<!-- CFG START -->
			<div role="tabpanel" class="tab-pane <%= cfgTabClass %>" id="cfg">
				<small><spring:message code="mgmt.tabs.cfg.descr" /></small>
				<hr />
				<portlet:actionURL var="saveCfgUrl">
					<portlet:param name="action" value="saveCfg" />
				</portlet:actionURL>

				<form:form data-ajax="false" method="post" action="${saveCfgUrl}">
				  <fieldset <%= demoDisabled %>>
					<div class="row">
						<div class="col-md-3">
							<ul class="nav nav-pills nav-stacked">

								<%
		      for (E_ConfigDomain domain: E_ConfigDomain.values()) {
		    	  if (!domain.equals(E_ConfigDomain.NONE)) {
		    		  %>
								<li role="presentation"><a role="tab" data-toggle="tab"
									href="#<%=domain.toString()%>"><spring:message
											code="<%= domain.getMsgTitleKey() %>" /></a></li>
								<%	  
		    	  }
		      }
		      %>
							</ul>
							<hr />
							<button type="submit" class="btn btn-success <%= demoDisabled %>">
								<span class="glyphicon glyphicon-ok"></span>&nbsp;
								<spring:message code="mgmt.cfg.form.submit" />
							</button>
						</div>
						<div class="col-md-7 tab-content">
							<%
          for (E_ConfigDomain domain: E_ConfigDomain.values()) {
            if (!domain.equals(E_ConfigDomain.NONE)) {
              %>
							<div role="tabpanel" class="tab-pane" id="<%=domain.toString()%>">
								<h3>
									<spring:message code="<%= domain.getMsgDescrKey() %>" />
								</h3>
								<div class="panel-group" id="accordion" role="tablist"
									aria-multiselectable="true">
									<%
						      for (E_ConfigCategory category: E_ConfigCategory.getByDomain(domain)) {
						        // skip configuration not meant for our eyes
						        if (category.getRole() == null || !E_ConfigRole.MGMT.equals(category.getRole()))
						          continue;
						        String cName = category.toString().toLowerCase();
						        //String cForm = cName+"Form";
						        //String cData = cName+"CfgData";
						        //String cFormAction = cName+"CfgDataSave";
						        //String cFormAction = "cfgDataSave";
						        //String collapseClass = cName.equals(cfgCollaps) ? "in" : "";
						        //PortletURL actionURL = renderResponse.createActionURL();
						        //actionURL.setParameter("action", cFormAction);
						        %>
									<div class="panel panel-default">
										<div class="panel-heading" role="tab" id="<%= cName%>Heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#<%= cName%>Body" aria-expanded="true"
													aria-controls="<%= cName%>Body"> <spring:message
														code="<%= category.getMsgTitleKey() %>" />
												</a>
											</h4>
										</div>
										<div id="<%= cName%>Body" class="panel-collapse collapse"
											role="tabpanel" aria-labelledby="<%= cName%>Heading">
											<div class="panel-body">
												<div class="text-info">
													<spring:message code="<%= category.getMsgDescrKey() %>" />
												</div>
												<hr />
												<%
						                List<E_ConfigKey> keys = E_ConfigKey.getByCategory(category);
						                for (E_ConfigKey key: keys) {
						                  String value = CustomPortalServiceHandler.getConfigValue(key);
						                  %>
												<div class="form-group ">
													<label class="control-label" for="<%= key.toString() %>"><spring:message
															code="<%= key.getMsgProperty() %>" /></label>
													<%
						                      switch (key.getType()) {
						                       case TEXT:
						                         %>
													<input id="<%= key.toString() %>"
														name="<%= key.toString() %>" class="form-control input-lg"
														type="<%= key.getType().getHtmlType() %>"
														value="<%= HtmlUtil.escape(value) %>">
													<%
						                        break;
						                       case TEXTAREA:
						                         %>
													<textarea id="<%= key.toString() %>"
														name="<%= key.toString() %>" class="form-control input-lg wysiwyg"
														rows="5"><%= value %></textarea>
													<%
						                         break;
						                       case YESNO:
						                    	   String checkedTrue="checked=\"checked\"";
						                    	   String checkedFalse="checked=\"checked\"";
						                    	   if (value != null && value.trim().equalsIgnoreCase("true")) {
						                    		   checkedFalse = "";
						                    	   } else
						                    		   checkedTrue = "";
						                    	   %>
						                           <input id="<%= key.toString() %>True"
						                             name="<%= key.toString() %>" class=""
						                             type="<%= key.getType().getHtmlType() %>"
						                             value="true" <%= checkedTrue %>><spring:message code="common.html.radio.on" />
						                           <input id="<%= key.toString() %>False"
                                         name="<%= key.toString() %>" class=""
                                         type="<%= key.getType().getHtmlType() %>"
                                         value="false" <%= checkedFalse %>><spring:message code="common.html.radio.off" />
						                           <%
						                    	   break;
						                      }
						                     %>

												</div>
												<%
						                }
						                %>
											</div>
										</div>
									</div>

									<%
						      }
						      %>
								</div>
							</div>
							<%    
            }
          }
          %>
						</div>
					</div>
					</fieldset>
				</form:form>
			</div>
			<!-- CFG END -->
		</div>

	</div>
</div>

<div class="yui3-skin-sam">
	<div id="modal"></div>
</div>
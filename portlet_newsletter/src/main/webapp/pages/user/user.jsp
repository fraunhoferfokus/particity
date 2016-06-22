<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomOfferServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomCategoryServiceHandler"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPersistanceServiceHandler"%>
<%@page import="de.particity.model.I_SubscriptionModel"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.E_ConfigKey"%>
<%@page import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomPortalServiceHandler"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());

  String uuid = request.getParameter("uuid");
  if (uuid == null)
	  uuid = PortalUtil.getOriginalServletRequest(request).getParameter("uuid");
  
  boolean isEnabled = CustomPortalServiceHandler.isConfigEnabled(E_ConfigKey.ENABLE_NEWSLETTER);

  %>

<div class="container-fluid">

	<div class="page-header">
		<h1>
			<spring:message code="user.main.jsp.title" />
			&nbsp;&nbsp;<small><spring:message code="user.main.jsp.descr" /></small>
		</h1>
	</div>

	<%
	if (isEnabled) {
    if (uuid != null) {
		 List<I_SubscriptionModel> subscriptions = CustomPersistanceServiceHandler.getSubscriptionsByUuid(uuid);
		 if (subscriptions.size() == 0) {
		 %>
	<div class="alert alert-info">
		<spring:message code="user.news.empty" />
	</div> 
	   <%
	     } else {
		 
    		 String mail = subscriptions.get(0).getEmail();
		 
		 %>
		<p>
			<strong><spring:message code="user.news.email" /></strong>:
			<%= mail %></p>
		<p>
			<strong><spring:message code="user.news.size" /></strong>:
			<%= Integer.toString(subscriptions.size()) %></p>
	
		<table class="table" style="margin-bottom: 50px;">
			<tr>
				<th><spring:message code="user.news.table.categories" /></th>
				<th><spring:message code="user.news.table.created" /></th>
				<th></th>
			</tr>
			<%
			 for (I_SubscriptionModel subscription: subscriptions) {
				 
				  String strCategories = CustomPersistanceServiceHandler.getCategoryEntriesBySubscriptionAsString(subscription);
				  String createdDate = CustomServiceUtils.formatZoneDateTime(subscription.getCreated());
				  E_SubscriptionStatus status = subscription.getStatus();
				 %>
	
			<tr>
				<td><%= strCategories %></td>
				<td><%= createdDate %></td>
				<td>
					<%
				   switch (status) {
					   case NEW:
						   %> <a class="btn btn-info btn-lg"
					href="<portlet:actionURL>
	                         <portlet:param name="action" value="approveSub" />
	                         <portlet:param name="uuid" value="<%= uuid %>" />
	                       </portlet:actionURL>"><span
						class="glyphicon glyphicon-ok"></span>&nbsp;<spring:message
							code="user.news.table.action.approve" /></a> <%
						   break;
					   case VALIDATED:
						   %> <a class="btn btn-default btn-lg"
					href="<portlet:actionURL>
	                         <portlet:param name="action" value="deleteSub" />
	                         <portlet:param name="uuid" value="<%= uuid %>" />
	                       </portlet:actionURL>"><span
						class="glyphicon glyphicon-remove"></span>&nbsp;<spring:message
							code="user.news.table.action.delete" /></a> <%
				       break;
				   }
				   %>
				</td>
			</tr>
	
			<%
				 
			 }
	     %>
		</table>
	<%
	 }
		  } 
       // no uuid given
       else {
			 %>
			<div class="alert alert-error">
				<spring:message code="user.news.missingUuid" />
			</div>
			<%
			 }
	} 
	// newsletter not enabled
	else {
		%>
		  <div class="alert alert-info">
       <spring:message code="user.newsletter.disabled" />
      </div>
		<%
	}
 
 %>

</div>
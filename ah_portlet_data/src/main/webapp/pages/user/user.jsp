<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.CustomServiceUtils"%>
<%@page
	import="de.fraunhofer.fokus.oefit.adhoc.custom.E_SubscriptionStatus"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="de.fraunhofer.fokus.oefit.particity.model.AHSubscription"%>
<%@page
	import="de.fraunhofer.fokus.oefit.particity.service.AHSubscriptionLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@ include file="../shared/init.jsp"%>

<% 
  Log log = LogFactoryUtil.getLog(this.getClass().getName());

  String uuid = request.getParameter("uuid");
  if (uuid == null)
	  uuid = PortalUtil.getOriginalServletRequest(request).getParameter("uuid");
  %>

<div class="container-fluid">

	<div class="page-header">
		<h1>
			<spring:message code="user.main.jsp.title" />
			&nbsp;&nbsp;<small><spring:message code="user.main.jsp.descr" /></small>
		</h1>
	</div>

	<%
 if (uuid != null) {
	 
	 List<AHSubscription> subscriptions = AHSubscriptionLocalServiceUtil.getSubscriptionsByUuid(uuid);
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
		 for (AHSubscription subscription: subscriptions) {
			 
			  String strCategories = AHSubscriptionLocalServiceUtil.getCategoriesBySubscriptionAsString(subscription.getSubId());
			  String createdDate = CustomServiceUtils.formatZoneDateTime(subscription.getCreated());
			  E_SubscriptionStatus status = E_SubscriptionStatus.findByValue(subscription.getStatus());
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
                         <portlet:param name="subId" value="<%= Long.toString(subscription.getSubId()) %>" />
                         <portlet:param name="uuid" value="<%= uuid %>" />
                       </portlet:actionURL>"><span
					class="glyphicon glyphicon-ok"></span>&nbsp;<spring:message
						code="user.news.table.action.approve" /></a> <%
					   break;
				   case VALIDATED:
					   %> <a class="btn btn-default btn-lg"
				href="<portlet:actionURL>
                         <portlet:param name="action" value="deleteSub" />
                         <portlet:param name="subId" value="<%= Long.toString(subscription.getSubId()) %>" />
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
 } else {
	 %>
	<div class="alert alert-error">
		<spring:message code="user.news.missingUuid" />
	</div>
	<%

 }
 
 %>

</div>
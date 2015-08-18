<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/journal/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

JournalFeed feed = (JournalFeed)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= JournalFeedPermission.contains(permissionChecker, feed, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editeFeedURL">
			<portlet:param name="struts_action" value="/journal/edit_feed" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(feed.getGroupId()) %>" />
			<portlet:param name="feedId" value="<%= feed.getFeedId() %>" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" url="<%= editeFeedURL %>" />
	</c:if>

	<c:if test="<%= JournalFeedPermission.contains(permissionChecker, feed, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= JournalFeed.class.getName() %>"
			modelResourceDescription="<%= feed.getName() %>"
			resourcePrimKey="<%= String.valueOf(feed.getId()) %>"
			var="permissionsFeedURL"
		/>

		<liferay-ui:icon image="permissions" url="<%= permissionsFeedURL %>" />
	</c:if>

	<c:if test="<%= JournalFeedPermission.contains(permissionChecker, feed, ActionKeys.DELETE) %>">
		<portlet:actionURL var="deleteFeedURL">
			<portlet:param name="struts_action" value="/journal/edit_feed" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="groupId" value="<%= String.valueOf(feed.getGroupId()) %>" />
			<portlet:param name="deleteFeedIds" value="<%= feed.getFeedId() %>" />
		</portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteFeedURL %>" />
	</c:if>
</liferay-ui:icon-menu>
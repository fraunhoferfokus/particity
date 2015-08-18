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

<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

MBBan ban = (MBBan)row.getObject();
%>

<liferay-ui:icon-menu>
	<c:if test="<%= MBPermission.contains(permissionChecker, scopeGroupId, ActionKeys.BAN_USER) %>">
		<portlet:actionURL var="unbanUserURL">
			<portlet:param name="struts_action" value="/message_boards/ban_user" />
			<portlet:param name="<%= Constants.CMD %>" value="unban" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="banUserId" value="<%= String.valueOf(ban.getBanUserId()) %>" />
		</portlet:actionURL>

		<liferay-ui:icon
			image="../message_boards/unban_user"
			message="unban-this-user"
			url="<%= unbanUserURL %>"
		/>
	</c:if>
</liferay-ui:icon-menu>
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

<%@ include file="/html/portal/init.jsp" %>

<%
List<User> users = UserLocalServiceUtil.search(company.getCompanyId(), null, WorkflowConstants.STATUS_APPROVED, null, 0, 10, (OrderByComparator)null);

request.setAttribute("users", users);
%>

<display:table name="users">
	<display:column property="userId" title="User ID" />
	<display:column property="emailAddress" title="Email Address" />
</display:table>

<%
System.out.println(request.getClass().getName());
System.out.println("request.getRemoteUser() " + request.getRemoteUser());

PortalServiceUtil.testGetUserId();
%>

Test
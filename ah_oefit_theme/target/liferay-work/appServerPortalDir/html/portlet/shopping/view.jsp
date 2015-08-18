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

<%@ include file="/html/portlet/shopping/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "categories");
%>

<liferay-util:include page="/html/portlet/shopping/tabs1.jsp" />

<c:choose>
	<c:when test='<%= tabs1.equals("categories") %>'>
		<%@ include file="/html/portlet/shopping/categories.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("orders") && !user.isDefaultUser() %>'>
		<%@ include file="/html/portlet/shopping/orders.jspf" %>
	</c:when>
	<c:when test='<%= tabs1.equals("coupons") %>'>
		<%@ include file="/html/portlet/shopping/coupons.jspf" %>
	</c:when>
</c:choose>
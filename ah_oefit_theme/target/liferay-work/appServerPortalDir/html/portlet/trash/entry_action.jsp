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

<%@ include file="/html/portlet/trash/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

String redirect = ParamUtil.getString(request, "redirect");

if (searchContainer != null) {
	redirect = searchContainer.getIteratorURL().toString();
}

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TrashEntry entry = null;

if (row != null) {
	entry = (TrashEntry)row.getObject();
}
else {
	entry = (TrashEntry)request.getAttribute(WebKeys.TRASH_ENTRY);
}
%>

<liferay-ui:icon-menu showWhenSingleIcon="<%= true %>">
	<%@ include file="/html/portlet/trash/action/restore.jspf" %>
	<%@ include file="/html/portlet/trash/action/delete.jspf" %>
</liferay-ui:icon-menu>
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

<%@ include file="/html/taglib/init.jsp" %>

<%
List list = (List)request.getAttribute("liferay-ui:table-iterator:list");
int listPos = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:table-iterator:listPos"));
int rowLength = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:table-iterator:rowLength"));
String rowPadding = (String)request.getAttribute("liferay-ui:table-iterator:rowPadding");
String rowValign = (String)request.getAttribute("liferay-ui:table-iterator:rowValign");
String rowBreak = (String)request.getAttribute("liferay-ui:table-iterator:rowBreak");
String width = (String)request.getAttribute("liferay-ui:table-iterator:width");

// LEP-4752

if (rowLength == 0) {
	rowLength = 2;
}
%>
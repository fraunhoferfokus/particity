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

<%@ include file="/html/taglib/ui/tabs/init.jsp" %>

<%
String errorSection = (String)request.getAttribute("errorSection");
%>

<c:if test="<%= !themeDisplay.isFacebook() %>">
	<aui:script>
		Liferay.Portal.Tabs.show("<%= namespace + param %>", <%= namesJS %>, "<%= UnicodeFormatter.toString((errorSection == null) ? value : errorSection) %>");
	</aui:script>
</c:if>
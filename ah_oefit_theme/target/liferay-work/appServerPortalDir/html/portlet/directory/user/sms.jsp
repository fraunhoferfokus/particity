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

<%@ include file="/html/portlet/directory/init.jsp" %>

<%
Contact selContact = (Contact)request.getAttribute("user.selContact");
%>

<c:if test="<%= Validator.isNotNull(selContact.getSmsSn()) %>">
	<h3><liferay-ui:message key="sms" /></h3>

	<ul class="property-list">
		<li><%= HtmlUtil.escape(selContact.getSmsSn()) %></li>
	</ul>
</c:if>
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
String className = (String)request.getAttribute("websites.className");
long classPK = (Long)request.getAttribute("websites.classPK");

List<Website> websites = Collections.emptyList();

if (classPK > 0) {
	websites = WebsiteServiceUtil.getWebsites(className, classPK);
}
%>

<c:if test="<%= !websites.isEmpty() %>">
	<h3><liferay-ui:message key="websites" /></h3>

	<ul class="property-list">

	<%
	for (Website website: websites) {
		website = website.toEscapedModel();
	%>

		<li class="<%= website.isPrimary() ? "primary" : "" %>">
			<a href="<%= website.getUrl() %>"><%= website.getUrl() %></a>

			<%= LanguageUtil.get(pageContext, website.getType().getName()) %>
		</li>

	<%
	}
	%>

	</ul>
</c:if>
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
String className = (String)request.getAttribute("emailAddresses.className");
long classPK = (Long)request.getAttribute("emailAddresses.classPK");

List<EmailAddress> emailAddresses = Collections.emptyList();

if (classPK > 0) {
	emailAddresses = EmailAddressServiceUtil.getEmailAddresses(className, classPK);
}
%>

<c:if test="<%= !emailAddresses.isEmpty() %>">
	<h3><liferay-ui:message key="additional-email-addresses" /></h3>

	<ul class="property-list">

	<%
	for (int i = 0; i < emailAddresses.size(); i++) {
		EmailAddress emailAddress = emailAddresses.get(i);
	%>

		<li class="<%= emailAddress.isPrimary() ? "primary" : "" %>">
			<a href="mailto:<%= emailAddress.getAddress() %>"><%= emailAddress.getAddress() %></a>

			<%= LanguageUtil.get(pageContext, emailAddress.getType().getName()) %>
		</li>

	<%
	}
	%>

	</ul>
</c:if>
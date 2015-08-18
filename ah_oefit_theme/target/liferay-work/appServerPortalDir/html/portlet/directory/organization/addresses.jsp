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
String className = (String)request.getAttribute("addresses.className");
long classPK = (Long)request.getAttribute("addresses.classPK");

List<Address> addresses = Collections.emptyList();

if (classPK > 0) {
	addresses = AddressServiceUtil.getAddresses(className, classPK);
}
%>

<c:if test="<%= !addresses.isEmpty() %>">
	<h3><liferay-ui:message key="address" /></h3>

	<ul class="property-list">

	<%
	for (Address address: addresses) {
		String street1 = address.getStreet1();
		String street2 = address.getStreet2();
		String street3 = address.getStreet3();

		String zipCode = address.getZip();
		String city = address.getCity();

		String mailingName = LanguageUtil.get(pageContext, address.getType().getName());
	%>

		<li class="<%= address.isPrimary() ? "primary" : "" %>">
			<em class="mailing-name"><%= mailingName %></em>

			<c:if test="<%= Validator.isNotNull(street1) %>">
				<%= HtmlUtil.escape(street1) %><br />
			</c:if>

			<c:if test="<%= Validator.isNotNull(street2) %>">
				<%= HtmlUtil.escape(street2) %><br />
			</c:if>

			<c:if test="<%= Validator.isNotNull(street3) %>">
				<%= HtmlUtil.escape(street3) %><br />
			</c:if>

			<c:if test="<%= Validator.isNotNull(zipCode) %>">
				<%= HtmlUtil.escape(zipCode) %>,
			</c:if>

			<c:if test="<%= Validator.isNotNull(city) %>">
				<%= HtmlUtil.escape(city) %>
			</c:if>

			<c:if test="<%= address.isMailing() %>">(<liferay-ui:message key="mailing" />)</c:if>
		</li>

	<%
	}
	%>

	</ul>
</c:if>
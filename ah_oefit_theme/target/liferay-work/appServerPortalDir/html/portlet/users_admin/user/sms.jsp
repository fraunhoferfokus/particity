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

<%@ include file="/html/portlet/users_admin/init.jsp" %>

<%
Contact selContact = (Contact)request.getAttribute("user.selContact");
%>

<liferay-ui:error-marker key="errorSection" value="sms" />

<aui:model-context bean="<%= selContact %>" model="<%= Contact.class %>" />

<h3><liferay-ui:message key="sms" /></h3>

<c:choose>
	<c:when test="<%= selContact != null %>">
		<liferay-ui:error exception="<%= UserSmsException.class %>" message="please-enter-a-sms-id-that-is-a-valid-email-address" />

		<aui:fieldset>
			<aui:input label="" name="smsSn" />
		</aui:fieldset>
	</c:when>
	<c:otherwise>
		<div class="alert alert-info">
			<liferay-ui:message key="this-section-will-be-editable-after-creating-the-user" />
		</div>
	</c:otherwise>
</c:choose>
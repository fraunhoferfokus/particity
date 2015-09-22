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

<%@ include file="/html/portlet/login/init.jsp" %>

<%
String openId = ParamUtil.getString(request, "openId");
%>

<portlet:actionURL var="openIdURL">
	<portlet:param name="struts_action" value="/login/open_id" />
</portlet:actionURL>

<aui:form action="<%= openIdURL %>" method="post" name="fm">
	<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />

	<liferay-ui:error exception="<%= AssociationException.class %>" message="an-error-occurred-while-establishing-an-association-with-the-open-id-provider" />
	<liferay-ui:error exception="<%= ConsumerException.class %>" message="an-error-occurred-while-initializing-the-open-id-consumer" />
	<liferay-ui:error exception="<%= DiscoveryException.class %>" message="an-error-occurred-while-discovering-the-open-id-provider" />
	<liferay-ui:error exception="<%= DuplicateOpenIdException.class %>" message="a-user-with-that-open-id-already-exists" />
	<liferay-ui:error exception="<%= DuplicateUserEmailAddressException.class %>" message="the-email-address-associated-with-your-open-id-account-is-already-being-used" />
	<liferay-ui:error exception="<%= MessageException.class %>" message="an-error-occurred-while-communicating-with-the-open-id-provider" />

	<aui:fieldset>
		<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" cssClass="openid-login" name="openId" type="text" value="<%= openId %>" />

		<aui:button-row>
			<aui:button type="submit" value="sign-in" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>

<liferay-util:include page="/html/portlet/login/navigation.jsp" />
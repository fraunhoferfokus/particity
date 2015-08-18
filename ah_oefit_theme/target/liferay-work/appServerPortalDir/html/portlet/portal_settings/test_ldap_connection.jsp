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

<%@ include file="/html/portlet/portal_settings/init.jsp" %>

<%
long ldapServerId = ParamUtil.getLong(request, "ldapServerId", 0);

String postfix = LDAPSettingsUtil.getPropertyPostfix(ldapServerId);

String baseProviderURL = ParamUtil.getString(request, "baseProviderURL");
String principal = ParamUtil.getString(request, "principal");

String credentials = request.getParameter("credentials");

if (credentials.equals(Portal.TEMP_OBFUSCATION_VALUE)) {
	credentials = PrefsPropsUtil.getString(company.getCompanyId(), PropsKeys.LDAP_SECURITY_CREDENTIALS + postfix);
}

LdapContext ldapContext = PortalLDAPUtil.getContext(themeDisplay.getCompanyId(), baseProviderURL, principal, credentials);
%>

<c:choose>
	<c:when test="<%= ldapContext != null %>">
		<liferay-ui:message key="liferay-has-successfully-connected-to-the-ldap-server" />
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="liferay-has-failed-to-connect-to-the-ldap-server" />
	</c:otherwise>
</c:choose>

<%
if (ldapContext != null) {
	ldapContext.close();
}
%>
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
User selUser = (User)request.getAttribute("user.selUser");

String languageId = BeanParamUtil.getString(selUser, request, "languageId", user.getLanguageId());
String timeZoneId = BeanParamUtil.getString(selUser, request, "timeZoneId", user.getTimeZoneId());
%>

<aui:model-context bean="<%= selUser %>" model="<%= User.class %>" />

<h3><liferay-ui:message key="display-settings" /></h3>

<aui:fieldset>
	<aui:select label="language" name="languageId">

		<%
		Locale selLocale = LocaleUtil.fromLanguageId(languageId);

		Locale[] locales = LanguageUtil.getAvailableLocales();

		Locale languageLocale = locale;

		for (Locale curLocale : locales) {
			if (portletName.equals(PortletKeys.MY_ACCOUNT)) {
				languageLocale = curLocale;
			}
		%>

			<aui:option label="<%= curLocale.getDisplayName(languageLocale) %>" lang="<%= LocaleUtil.toW3cLanguageId(languageLocale) %>" selected="<%= (selLocale.getLanguage().equals(curLocale.getLanguage()) && selLocale.getCountry().equals(curLocale.getCountry())) %>" value="<%= LocaleUtil.toLanguageId(curLocale) %>" />

		<%
		}
		%>

	</aui:select>

	<aui:input label="time-zone" name="timeZoneId" type="timeZone" value="<%= timeZoneId %>" />

	<aui:input name="greeting" />
</aui:fieldset>
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

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.taglib.ui.LanguageTag" %>

<%
Locale[] availableLocales = LanguageUtil.getAvailableLocales(themeDisplay.getSiteGroupId());

String[] availableLanguageIds = LocaleUtil.toLanguageIds(availableLocales);

String[] languageIds = StringUtil.split(portletPreferences.getValue("languageIds", StringUtil.merge(availableLanguageIds)));
boolean displayCurrentLocale = GetterUtil.getBoolean(portletPreferences.getValue("displayCurrentLocale", null), true);
int displayStyle = GetterUtil.getInteger(portletPreferences.getValue("displayStyle", StringPool.BLANK));
%>

<%@ include file="/html/portlet/language/init-ext.jsp" %>
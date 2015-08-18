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

<%@ page import="com.liferay.portlet.social.model.SocialActivityCounter" %><%@
page import="com.liferay.portlet.social.model.SocialActivityCounterConstants" %><%@
page import="com.liferay.portlet.social.model.impl.SocialActivityCounterImpl" %><%@
page import="com.liferay.portlet.social.service.SocialActivityCounterLocalServiceUtil" %><%@
page import="com.liferay.portlet.social.util.SocialConfigurationUtil" %><%@
page import="com.liferay.portlet.social.util.comparator.SocialActivityCounterNameComparator" %>

<%
boolean displayAdditionalActivityCounters = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "displayAdditionalActivityCounters"), true);

int[] displayActivityCounterNameIndexes = null;

String displayActivityCounterNameIndexesParam = PrefsParamUtil.getString(portletPreferences, request, "displayActivityCounterNameIndexes");

if (Validator.isNotNull(displayActivityCounterNameIndexesParam)) {
	displayActivityCounterNameIndexes = StringUtil.split(displayActivityCounterNameIndexesParam, 0);
}
else {
	displayActivityCounterNameIndexes = new int[] {0};
}

boolean rankByContribution = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "rankByContribution"), true);
boolean rankByParticipation = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "rankByParticipation"), true);
boolean showHeaderText = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "showHeaderText"), true);
boolean showTotals = GetterUtil.getBoolean(PrefsParamUtil.getString(portletPreferences, request, "showTotals"), true);
%>

<%@ include file="/html/portlet/user_statistics/init-ext.jsp" %>
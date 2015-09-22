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

<%@ include file="/html/portlet/layouts_admin/init.jsp" %>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("liferay-ui:search:searchContainer");

String redirect = searchContainer.getIteratorURL().toString();

String closeRedirect = ParamUtil.getString(request, "closeRedirect");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

MDRRuleGroupInstance mdrRuleGroupInstance = (MDRRuleGroupInstance)row.getObject();

MDRRuleGroup mdrRuleGroup = MDRRuleGroupLocalServiceUtil.getMDRRuleGroup(mdrRuleGroupInstance.getRuleGroupId());
%>

<liferay-ui:icon-menu>
	<c:if test="<%= MDRRuleGroupInstancePermissionUtil.contains(permissionChecker, mdrRuleGroupInstance.getRuleGroupInstanceId(), ActionKeys.UPDATE) %>">
		<liferay-portlet:renderURL portletName="<%= PortletKeys.MOBILE_DEVICE_SITE_ADMIN %>" varImpl="viewRuleGroupInstanceActionsURL" windowState="<%= themeDisplay.isStateExclusive() ? LiferayWindowState.POP_UP.toString() : windowState.toString() %>">
			<portlet:param name="struts_action" value="/mobile_device_rules/view_actions" />
			<portlet:param name="redirect" value='<%= HttpUtil.setParameter(redirect, liferayPortletResponse.getNamespace() + "historyKey", "mobileDeviceRules") %>' />
			<portlet:param name="ruleGroupInstanceId" value="<%= String.valueOf(mdrRuleGroupInstance.getRuleGroupInstanceId()) %>" />
		</liferay-portlet:renderURL>

		<%
		String taglibActionHandler = renderResponse.getNamespace() + "mobileDeviceActionHandler('" + viewRuleGroupInstanceActionsURL.toString() + "');";
		%>

		<liferay-ui:icon image="manage_nodes" message="manage-actions" url='<%= "javascript:" + taglibActionHandler + ";" %>' />

	</c:if>

	<c:if test="<%= MDRRuleGroupInstancePermissionUtil.contains(permissionChecker, mdrRuleGroupInstance.getRuleGroupInstanceId(), ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="<%= MDRRuleGroupInstance.class.getName() %>"
			modelResourceDescription="<%= mdrRuleGroup.getName(locale) %>"
			resourcePrimKey="<%= String.valueOf(mdrRuleGroupInstance.getRuleGroupInstanceId()) %>"
			var="permissionsURL"
			windowState="<%= themeDisplay.isStateExclusive() ? LiferayWindowState.POP_UP.toString() : windowState.toString() %>"
		/>

		<%
		String taglibActionHandler = renderResponse.getNamespace() + "mobileDeviceActionHandler('" + permissionsURL + "');";
		%>

		<liferay-ui:icon image="permissions" url='<%= "javascript:" + taglibActionHandler + ";" %>' useDialog="<%= true %>" />
	</c:if>

	<c:if test="<%= MDRRuleGroupInstancePermissionUtil.contains(permissionChecker, mdrRuleGroupInstance.getRuleGroupInstanceId(), ActionKeys.DELETE) %>">

		<%
		redirect = themeDisplay.isStateExclusive() ? closeRedirect : HttpUtil.setParameter(redirect, liferayPortletResponse.getNamespace() + "historyKey", "mobileDeviceRules");
		%>

		<liferay-portlet:actionURL portletName="<%= PortletKeys.MOBILE_DEVICE_SITE_ADMIN %>" var="deleteURL">
			<portlet:param name="struts_action" value="/mobile_device_rules/edit_rule_group_instance" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= redirect %>" />
			<portlet:param name="ruleGroupInstanceId" value="<%= String.valueOf(mdrRuleGroupInstance.getRuleGroupInstanceId()) %>" />
		</liferay-portlet:actionURL>

		<liferay-ui:icon-delete url="<%= deleteURL %>" />
	</c:if>
</liferay-ui:icon-menu>
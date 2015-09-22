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

<%@ include file="/html/portlet/recent_bloggers/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

String organizationName = StringPool.BLANK;

Organization organization = null;

if (organizationId > 0) {
	organization = OrganizationLocalServiceUtil.getOrganization(organizationId);

	organizationName = organization.getName();
}
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="preferences--organizationId--" type="hidden" value="<%= organizationId %>" />

	<aui:fieldset>
		<aui:select name="preferences--selectionMethod--">
			<aui:option label="users" selected='<%= selectionMethod.equals("users") %>' />
			<aui:option label="scope" selected='<%= selectionMethod.equals("scope") %>' />
		</aui:select>

		<div id="<portlet:namespace />UsersSelectionOptions">
			<aui:field-wrapper label="organization">
				<div class="input-append">
					<liferay-ui:input-resource id="organizationName" url="<%= HtmlUtil.escape(organizationName) %>" />

					<aui:button name="selectOrganizationButton" value="select" />

					<aui:button disabled="<%= organizationId <= 0 %>" name="removeOrganizationButton" onClick='<%= renderResponse.getNamespace() + "removeOrganization();" %>' value="remove" />
				</div>
			</aui:field-wrapper>
		</div>

		<aui:select name="preferences--displayStyle--">
			<aui:option label="user-name-and-image" selected='<%= displayStyle.equals("user-name-and-image") %>' />
			<aui:option label="user-name" selected='<%= displayStyle.equals("user-name") %>' />
		</aui:select>

		<aui:select label="maximum-bloggers-to-display" name="preferences--max--">
			<aui:option label="1" selected="<%= max == 1 %>" />
			<aui:option label="2" selected="<%= max == 2 %>" />
			<aui:option label="3" selected="<%= max == 3 %>" />
			<aui:option label="4" selected="<%= max == 4 %>" />
			<aui:option label="5" selected="<%= max == 5 %>" />
			<aui:option label="10" selected="<%= max == 10 %>" />
			<aui:option label="15" selected="<%= max == 15 %>" />
			<aui:option label="20" selected="<%= max == 20 %>" />
			<aui:option label="25" selected="<%= max == 25 %>" />
			<aui:option label="30" selected="<%= max == 30 %>" />
			<aui:option label="40" selected="<%= max == 40 %>" />
			<aui:option label="50" selected="<%= max == 50 %>" />
			<aui:option label="60" selected="<%= max == 60 %>" />
			<aui:option label="70" selected="<%= max == 70 %>" />
			<aui:option label="80" selected="<%= max == 80 %>" />
			<aui:option label="90" selected="<%= max == 90 %>" />
			<aui:option label="100" selected="<%= max == 100 %>" />
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script use="aui-base">
	A.one('#<portlet:namespace />selectOrganizationButton').on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true
					},
					id: '<portlet:namespace />selectOrganization',
					title: '<liferay-ui:message arguments="organization" key="select-x" />',
					uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/portlet_configuration/select_organization" /><portlet:param name="tabs1" value="organizations" /></portlet:renderURL>'
				},
				function(event) {
					document.<portlet:namespace />fm.<portlet:namespace />organizationId.value = event.organizationid;

					document.getElementById('<portlet:namespace />organizationName').value = event.name;

					Liferay.Util.toggleDisabled('#<portlet:namespace />removeOrganizationButton', false);
				}
			);
		}
	);
</aui:script>

<aui:script>
	function <portlet:namespace />removeOrganization() {
		document.<portlet:namespace />fm.<portlet:namespace />organizationId.value = "";

		document.getElementById('<portlet:namespace />organizationName').value = "";

		Liferay.Util.toggleDisabled('#<portlet:namespace />removeOrganizationButton', true);
	}

	Liferay.Util.toggleSelectBox('<portlet:namespace />selectionMethod', 'users', '<portlet:namespace />UsersSelectionOptions');
</aui:script>
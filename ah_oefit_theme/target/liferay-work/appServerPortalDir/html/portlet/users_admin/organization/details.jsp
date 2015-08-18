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
Organization organization = (Organization)request.getAttribute(WebKeys.ORGANIZATION);

long parentOrganizationId = ParamUtil.getLong(request, "parentOrganizationSearchContainerPrimaryKeys", (organization != null) ? organization.getParentOrganizationId() : OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID);

String parentOrganizationName = ParamUtil.getString(request, "parentOrganizationName");

if (parentOrganizationId <= 0) {
	parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;

	if (organization != null) {
		parentOrganizationId = organization.getParentOrganizationId();
	}
}

String type = BeanParamUtil.getString(organization, request, "type", PropsValues.ORGANIZATIONS_TYPES[0]);
long regionId = BeanParamUtil.getLong(organization, request, "regionId");
long countryId = BeanParamUtil.getLong(organization, request, "countryId");

long groupId = 0;

if (organization != null) {
	groupId = organization.getGroupId();
}

User selUser = (User)request.getAttribute("user.selUser");
%>

<liferay-util:buffer var="removeOrganizationIcon">
	<liferay-ui:icon
		image="unlink"
		label="<%= true %>"
		message="remove"
	/>
</liferay-util:buffer>

<liferay-ui:error-marker key="errorSection" value="details" />

<aui:model-context bean="<%= organization %>" model="<%= Organization.class %>" />

<h3><liferay-ui:message key="details" /></h3>

<div class="row-fluid">
	<aui:fieldset cssClass="span6">
		<liferay-ui:error exception="<%= DuplicateOrganizationException.class %>" message="the-organization-name-is-already-taken" />
		<liferay-ui:error exception="<%= OrganizationNameException.class %>" message="please-enter-a-valid-name" />

		<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="name" />

		<c:choose>
			<c:when test="<%= PropsValues.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_ORGANIZATION_STATUS %>">
				<liferay-ui:error key="<%= NoSuchListTypeException.class.getName() + Organization.class.getName() + ListTypeConstants.ORGANIZATION_STATUS %>" message="please-select-a-type" />

				<aui:select label="status" listType="<%= ListTypeConstants.ORGANIZATION_STATUS %>" listTypeFieldName="statusId" name="statusId" showEmptyOption="<%= true %>" />
			</c:when>
			<c:otherwise>
				<aui:input name="statusId" type="hidden" value="<%= (organization != null) ? organization.getStatusId() : ListTypeConstants.ORGANIZATION_STATUS_DEFAULT %>" />
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="<%= organization == null %>">
				<aui:select name="type">

					<%
					for (String curType : PropsValues.ORGANIZATIONS_TYPES) {
					%>

						<aui:option label="<%= curType %>" selected="<%= type.equals(curType) %>" />

					<%
					}
					%>

				</aui:select>
			</c:when>
			<c:otherwise>
				<aui:field-wrapper label="type">
					<liferay-ui:input-resource url="<%= LanguageUtil.get(pageContext, organization.getType()) %>" />
				</aui:field-wrapper>

				<aui:input name="type" type="hidden" value="<%= organization.getType() %>" />
			</c:otherwise>
		</c:choose>

		<liferay-ui:error exception="<%= NoSuchCountryException.class %>" message="please-select-a-country" />

		<div class='<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.ORGANIZATIONS_COUNTRY_ENABLED, new Filter(String.valueOf(type)))) ? StringPool.BLANK : "hide" %>' id="<portlet:namespace />countryDiv">
			<aui:select label="country" name="countryId" />

			<aui:select label="region" name="regionId" />
		</div>

		<c:if test="<%= organization != null %>">
			<aui:field-wrapper label="site-id">
				<liferay-ui:input-resource url="<%= String.valueOf(groupId) %>" />
			</aui:field-wrapper>
		</c:if>
	</aui:fieldset>

	<aui:fieldset cssClass="span6">
		<div>
			<c:if test="<%= organization != null %>">

				<%
				long logoId = 0;

				LayoutSet publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, false);
				LayoutSet privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, true);

				if (publicLayoutSet.getLogoId() > 0) {
					logoId = publicLayoutSet.getLogoId();
				}
				else if (privateLayoutSet.getLogoId() > 0) {
					logoId = privateLayoutSet.getLogoId();
				}
				%>

				<portlet:renderURL var="editOrganizationLogoURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<portlet:param name="struts_action" value="/users_admin/edit_organization_logo" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
					<portlet:param name="publicLayoutSetId" value="<%= String.valueOf(publicLayoutSet.getLayoutSetId()) %>" />
				</portlet:renderURL>

				<liferay-ui:logo-selector
					defaultLogoURL='<%= themeDisplay.getPathImage() + "/organization_logo?img_id=0" %>'
					editLogoURL="<%= editOrganizationLogoURL %>"
					imageId="<%= logoId %>"
					logoDisplaySelector=".organization-logo"
				/>
			</c:if>
		</div>
	</aui:fieldset>
</div>

<%
Organization parentOrganization = null;

if ((organization == null) && (parentOrganizationId == OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID) && !permissionChecker.isCompanyAdmin()) {
	List<Organization> manageableOrganizations = new ArrayList<Organization>();

	for (Organization curOrganization : user.getOrganizations()) {
		if (OrganizationPermissionUtil.contains(permissionChecker, curOrganization.getOrganizationId(), ActionKeys.MANAGE_SUBORGANIZATIONS)) {
			manageableOrganizations.add(curOrganization);
		}
	}

	if (manageableOrganizations.size() == 1) {
		parentOrganizationId = manageableOrganizations.get(0).getOrganizationId();
	}
}

if (parentOrganizationId != OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID) {
	try {
		parentOrganization = OrganizationLocalServiceUtil.getOrganization(parentOrganizationId);

		parentOrganizationName = parentOrganization.getName();
	}
	catch (NoSuchOrganizationException nsoe) {
	}
}

List<Organization> parentOrganizations = new ArrayList<Organization>();

if (parentOrganization != null) {
	parentOrganizations.add(parentOrganization);
}
%>

<h3><liferay-ui:message key="parent-organization" /></h3>

<liferay-ui:error exception="<%= OrganizationParentException.class %>" message="please-enter-a-valid-parent-organization" />

<liferay-ui:search-container
	headerNames="name,type,null"
	id="parentOrganizationSearchContainer"
>
	<liferay-ui:search-container-results
		results="<%= parentOrganizations %>"
		total="<%= parentOrganizations.size() %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.portal.model.Organization"
		escapedModel="<%= true %>"
		keyProperty="organizationId"
		modelVar="curOrganization"
	>
		<portlet:renderURL var="rowURL">
			<portlet:param name="struts_action" value="/users_admin/edit_organization" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="organizationId" value="<%= String.valueOf(curOrganization.getOrganizationId()) %>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="name"
			property="name"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="type"
			value="<%= LanguageUtil.get(pageContext, curOrganization.getType()) %>"
		/>

		<liferay-ui:search-container-column-text>
			<a class="modify-link" data-rowId="<%= curOrganization.getOrganizationId() %>" href="javascript:;"><%= removeOrganizationIcon %></a>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= false %>" />
</liferay-ui:search-container>

<br />

<liferay-ui:icon
	cssClass="modify-link"
	iconCssClass="icon-search"
	id="selectOrganizationLink"
	label="<%= true %>"
	linkCssClass="btn"
	message="select"
	method="get"
	url="javascript:;"
/>

<aui:script use="liferay-dynamic-select,liferay-search-container">
	new Liferay.DynamicSelect(
		[
			{
				select: '<portlet:namespace />countryId',
				selectData: Liferay.Address.getCountries,
				selectDesc: 'nameCurrentValue',
				selectSort: '<%= true %>',
				selectId: 'countryId',
				selectVal: '<%= countryId %>'
			},
			{
				select: '<portlet:namespace />regionId',
				selectData: Liferay.Address.getRegions,
				selectDesc: 'name',
				selectId: 'regionId',
				selectVal: '<%= regionId %>'
			}
		]
	);

	var searchContainer = Liferay.SearchContainer.get('<portlet:namespace />parentOrganizationSearchContainer');

	searchContainer.get('contentBox').delegate(
		'click',
		function(event) {
			var link = event.currentTarget;
			var tr = link.ancestor('tr');

			searchContainer.deleteRow(tr, link.getAttribute('data-rowId'));
		},
		'.modify-link'
	);

	var selectOrganizationLink = A.one('#<portlet:namespace />selectOrganizationLink');

	if (selectOrganizationLink) {
		selectOrganizationLink.on(
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
						uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/users_admin/select_organization" /><portlet:param name="p_u_i_d" value='<%= (selUser == null) ? "0" : String.valueOf(selUser.getUserId()) %>' /></portlet:renderURL>'
					},
					function(event) {
						var rowColumns = [];

						var href = "<portlet:renderURL><portlet:param name="struts_action" value="/users_admin/edit_organization" /><portlet:param name="redirect" value="<%= currentURL %>" /></portlet:renderURL>&<portlet:namespace />organizationId=" + event.organizationid;

						rowColumns.push(<portlet:namespace />createURL(href, event.name));
						rowColumns.push(<portlet:namespace />createURL(href, event.type));
						rowColumns.push('<a class="modify-link" data-rowId="' + event.organizationid + '" href="javascript:;"><%= UnicodeFormatter.toString(removeOrganizationIcon) %></a>');

						searchContainer.deleteRow(1, searchContainer.getData());
						searchContainer.addRow(rowColumns, event.organizationid);
						searchContainer.updateDataStore(event.organizationid);
					}
				);
			}
		);
	}
</aui:script>

<c:if test="<%= organization == null %>">
	<aui:script use="aui-base">
		A.one('#<portlet:namespace />type').on(
			'change',
			function(event) {

				<%
				for (String curType : PropsValues.ORGANIZATIONS_TYPES) {
				%>

					if (event.target.val() == '<%= curType %>') {
						A.one('#<portlet:namespace />countryDiv').<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.ORGANIZATIONS_COUNTRY_ENABLED, new Filter(String.valueOf(curType)))) ? "show" : "hide" %>();
					}

				<%
				}
				%>

			}
		);
	</aui:script>
</c:if>
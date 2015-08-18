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

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
String className = ParamUtil.getString(request, "className");
long classTypeId = ParamUtil.getLong(request, "classTypeId");
String eventName = ParamUtil.getString(request, "eventName", liferayPortletResponse.getNamespace() + "selectDDMStructureField");

AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/asset_publisher/select_structure_field");
portletURL.setParameter("portletResource", portletResource);
portletURL.setParameter("className", className);
portletURL.setParameter("classTypeId", String.valueOf(classTypeId));
%>

<div id="<portlet:namespace />selectDDMStructureFieldForm">
	<liferay-ui:search-container
		iteratorURL="<%= portletURL %>"
		total="<%= assetRendererFactory.getClassTypeFieldNamesCount(classTypeId, locale) %>"
	>
		<liferay-ui:search-container-results
			results="<%= assetRendererFactory.getClassTypeFieldNames(classTypeId, locale, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.util.Tuple"
			modelVar="field"
		>

			<%
			String label = (String)field.getObject(0);
			String name = (String)field.getObject(1);
			String fieldType = (String)field.getObject(2);
			long ddmStructureId = GetterUtil.getLong(field.getObject(3));
			%>

			<liferay-ui:search-container-column-text>
				<input data-button-id="<%= renderResponse.getNamespace() + "applyButton" + name %>" data-form-id="<%= renderResponse.getNamespace() + name + "fieldForm" %>" name="<portlet:namespace />selectStructureFieldSubtype" type="radio" <%= name.equals(ddmStructureFieldName) ? "checked" : StringPool.BLANK %> />
			</liferay-ui:search-container-column-text>

			<%
			String fieldsNamespace = StringUtil.randomId();
			%>

			<liferay-ui:search-container-column-text
				name="field"
			>
				<liferay-portlet:resourceURL portletConfiguration="true" var="structureFieldURL">
					<portlet:param name="<%= Constants.CMD %>" value="getFieldValue" />
					<portlet:param name="portletResource" value="<%= portletResource %>" />
					<portlet:param name="structureId" value="<%= String.valueOf(ddmStructureId) %>" />
					<portlet:param name="name" value="<%= name %>" />
					<portlet:param name="fieldsNamespace" value="<%= fieldsNamespace %>" />
				</liferay-portlet:resourceURL>

				<aui:form action="<%= structureFieldURL %>" name='<%= name + "fieldForm" %>' onSubmit="event.preventDefault()">
					<aui:input disabled="<%= true %>" name="buttonId" type="hidden" value='<%= renderResponse.getNamespace() + "applyButton" + name %>' />

					<%
					com.liferay.portlet.dynamicdatamapping.storage.Field ddmField = new com.liferay.portlet.dynamicdatamapping.storage.Field();

					ddmField.setDefaultLocale(themeDisplay.getLocale());
					ddmField.setDDMStructureId(ddmStructureId);
					ddmField.setName(name);

					if (name.equals(ddmStructureFieldName)) {
						if (fieldType.equals(DDMImpl.TYPE_DDM_DATE)) {
							ddmStructureFieldValue = GetterUtil.getDate(ddmStructureFieldValue, DateFormatFactoryUtil.getSimpleDateFormat("yyyyMMddHHmmss"));
						}

						ddmField.setValue(themeDisplay.getLocale(), ddmStructureFieldValue);
					}
					%>

					<liferay-ddm:html-field
						classNameId="<%= PortalUtil.getClassNameId(DDMStructure.class) %>"
						classPK="<%= ddmStructureId %>"
						field="<%= ddmField %>"
						fieldsNamespace="<%= fieldsNamespace %>"
					/>
				</aui:form>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text>

				<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("form", renderResponse.getNamespace() + name + "fieldForm");
				data.put("label", label);
				data.put("name", name);
				%>

				<aui:button cssClass="selector-button" data="<%= data %>" disabled="<%= name.equals(ddmStructureFieldName) ? false : true %>" id='<%= renderResponse.getNamespace() + "applyButton" + name %>' value="apply" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
</div>

<aui:script use="aui-base,aui-io">
	var Util = Liferay.Util;

	var structureFormContainer = A.one('#<portlet:namespace />selectDDMStructureFieldForm');

	var fieldSubtypeForms = structureFormContainer.all('form');

	var toggleDisabledFormFields = function(form, state) {
		Util.toggleDisabled(form.all('input, select, textarea'), state);
	};

	var submitForm = function(applyButton) {
		var result = Util.getAttributes(applyButton, 'data-');

		var form = A.one('#' + result.form);

		A.io.request(
			form.attr('action'),
			{
				dataType: 'json',
				form: {
					id: form
				},
				on: {
					success: function(event, id, obj) {
						var respondData = this.get('responseData');

						result.className = '<%= AssetPublisherUtil.getClassName(assetRendererFactory) %>';
						result.displayValue = respondData.displayValue;
						result.value = respondData.value;

						Util.getOpener().Liferay.fire('<%= HtmlUtil.escapeJS(eventName) %>', result);

						Util.getWindow().hide();
					}
				}
			}
		);
	};

	structureFormContainer.delegate(
		'click',
		function(event) {
			submitForm(event.currentTarget);
		},
		'.selector-button'
	);

	structureFormContainer.delegate(
		'submit',
		function(event) {
			var buttonId = event.currentTarget.one('#<portlet:namespace />buttonId').attr('value');

			submitForm(structureFormContainer.one('#' + buttonId));
		},
		'form'
	);

	A.one('#<portlet:namespace />tuplesSearchContainer').delegate(
		'click',
		function(event) {
			var target = event.currentTarget;

			var buttonId = target.attr('data-button-id');
			var formId = target.attr('data-form-id');

			Util.toggleDisabled(structureFormContainer.all('.selector-button'), true);

			Util.toggleDisabled('#' + buttonId, false);

			toggleDisabledFormFields(fieldSubtypeForms, true);

			toggleDisabledFormFields(A.one('#' + formId), false);
		},
		'input[name=<portlet:namespace />selectStructureFieldSubtype]'
	);

	toggleDisabledFormFields(fieldSubtypeForms, true);
</aui:script>
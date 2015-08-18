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
Layout selLayout = (Layout)request.getAttribute("edit_pages.jsp-selLayout");
%>

<liferay-ui:error-marker key="errorSection" value="custom-fields" />

<aui:model-context bean="<%= selLayout %>" model="<%= Layout.class %>" />

<h3><liferay-ui:message key="custom-fields" /></h3>

<aui:fieldset>
	<liferay-ui:custom-attribute-list
		className="<%= Layout.class.getName() %>"
		classPK="<%= (selLayout != null) ? selLayout.getPlid() : 0 %>"
		editable="<%= true %>"
		label="<%= true %>"
	/>
</aui:fieldset>
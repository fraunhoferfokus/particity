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

<portlet:renderURL var="portletURL">
	<portlet:param name="struts_action" value="/asset_publisher/view" />
</portlet:renderURL>

<liferay-ui:header
	backURL="<%= portletURL.toString() %>"
	title="error"
/>

<liferay-ui:error exception="<%= NoSuchModelException.class %>" message="the-asset-could-not-be-found" />
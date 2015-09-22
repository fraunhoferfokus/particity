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

<%@ include file="/html/taglib/init.jsp" %>

<%
String contentId = GetterUtil.getString((String)request.getAttribute("liferay-ui:social-bookmark:contentId"));
String types = GetterUtil.getString((String)request.getAttribute("liferay-ui:social-bookmark:types"));
String url = GetterUtil.getString((String)request.getAttribute("liferay-ui:social-bookmark:url"));
String title = GetterUtil.getString((String)request.getAttribute("liferay-ui:social-bookmark:title"));
String target = GetterUtil.getString((String)request.getAttribute("liferay-ui:social-bookmark:target"));

String[] typesArray = null;

if (Validator.isNotNull(types)) {
	typesArray = StringUtil.split(types);
}
else {
	typesArray = PropsUtil.getArray(PropsKeys.SOCIAL_BOOKMARK_TYPES);
}
%>
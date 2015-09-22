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

@generated
--%>

<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:fieldset:dynamicAttributes");
Map<String, Object> scopedAttributes = (Map<String, Object>)request.getAttribute("aui:fieldset:scopedAttributes");

Map<String, Object> _options = new HashMap<String, Object>();

if ((scopedAttributes != null) && !scopedAttributes.isEmpty()) {
	_options.putAll(scopedAttributes);
}

if ((dynamicAttributes != null) && !dynamicAttributes.isEmpty()) {
	_options.putAll(dynamicAttributes);
}

boolean column = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:fieldset:column")));
java.lang.String cssClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:fieldset:cssClass"));
java.lang.String helpMessage = GetterUtil.getString((java.lang.String)request.getAttribute("aui:fieldset:helpMessage"));
java.lang.String id = GetterUtil.getString((java.lang.String)request.getAttribute("aui:fieldset:id"));
java.lang.String label = GetterUtil.getString((java.lang.String)request.getAttribute("aui:fieldset:label"));

_updateOptions(_options, "column", column);
_updateOptions(_options, "cssClass", cssClass);
_updateOptions(_options, "helpMessage", helpMessage);
_updateOptions(_options, "id", id);
_updateOptions(_options, "label", label);
%>

<%@ include file="/html/taglib/aui/fieldset/init-ext.jspf" %>

<%!
private static final String _NAMESPACE = "aui:fieldset:";
%>
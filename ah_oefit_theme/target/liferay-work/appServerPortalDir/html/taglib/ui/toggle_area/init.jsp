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
String id = (String)request.getAttribute("liferay-ui:toggle-area:id");
String showImage = (String)request.getAttribute("liferay-ui:toggle-area:showImage");
String hideImage = (String)request.getAttribute("liferay-ui:toggle-area:hideImage");
String showMessage = (String)request.getAttribute("liferay-ui:toggle-area:showMessage");
String hideMessage = (String)request.getAttribute("liferay-ui:toggle-area:hideMessage");
boolean defaultShowContent = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:toggle-area:defaultShowContent"));
String stateVar = (String)request.getAttribute("liferay-ui:toggle-area:stateVar");
String align = (String)request.getAttribute("liferay-ui:toggle-area:align");
%>
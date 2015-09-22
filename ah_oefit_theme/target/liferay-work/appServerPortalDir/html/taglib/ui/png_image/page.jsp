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
String image = (String)request.getAttribute("liferay-ui:png_image:image");
String height = (String)request.getAttribute("liferay-ui:png_image:height");
String width = (String)request.getAttribute("liferay-ui:png_image:width");
%>

<div style="
		<c:choose>
			<c:when test="<%= BrowserSnifferUtil.isIe(request) && (BrowserSnifferUtil.getMajorVersion(request) >= 5.5) %>">
				filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(src='<%= image %>', sizingMethod='scale');
			</c:when>
			<c:otherwise>
				background-image: url(<%= image %>);
			</c:otherwise>
		</c:choose>

		height: <%= height %>px; width: <%= width %>px;"></div>
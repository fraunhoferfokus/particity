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

<%@ include file="/html/portal/init.jsp" %>

<%
String title = ParamUtil.getString(request, "title");

String height = ParamUtil.getString(request, "height", "768");
String width = ParamUtil.getString(request, "width", "1024");

String movie = ParamUtil.getString(request, "movie");
%>

<html>

<head>
	<title><%= HtmlUtil.escape(title) %></title>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />

	<script src="<%= themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() %>/misc/swfobject.js" type="text/javascript"></script>
</head>

<body leftmargin="0" marginheight="0" marginwidth="0" rightmargin="0" topmargin="0">

<center>

<c:if test="<%= Validator.isNotNull(movie) %>">
	<div id="flashMovie"></div>

	<script type="text/javascript">
		var so = new SWFObject("<%= HtmlUtil.escapeJS(movie) %>", "flashMovie", "<%= HtmlUtil.escapeJS(width) %>", "<%= HtmlUtil.escapeJS(height) %>", "6", "#FFFFFF");

		so.write("flashMovie");
	</script>
</c:if>

</center>

</body>

</html>
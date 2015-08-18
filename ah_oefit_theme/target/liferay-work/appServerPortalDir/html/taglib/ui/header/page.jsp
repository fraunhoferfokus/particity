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

<%@ include file="/html/taglib/ui/header/init.jsp" %>

<%
if (Validator.isNull(backLabel)) {
	backLabel = LanguageUtil.get(pageContext, "back");
}

if (Validator.isNotNull(backURL) && !backURL.equals("javascript:history.go(-1);")) {
	backURL = HtmlUtil.escapeHREF(PortalUtil.escapeRedirect(backURL));
}

String headerTitle = (localizeTitle) ? LanguageUtil.get(pageContext, title) : title;
%>

<div class="taglib-header <%= cssClass %>">
	<c:if test="<%= showBackURL && Validator.isNotNull(backURL) %>">
		<span class="header-back-to">
			<a class="icon-circle-arrow-left previous-level" href="<%= backURL %>" id="<%= namespace %>TabsBack" title="<%= HtmlUtil.escapeAttribute(backLabel) %>">
				<span class="helper-hidden-accessible">
					<c:choose>
						<c:when test="<%= escapeXml %>">
							<%= HtmlUtil.escape(backLabel) %>
						</c:when>
						<c:otherwise>
							<%= backLabel %>
						</c:otherwise>
					</c:choose>
				</span>
			</a>
		</span>
	</c:if>

	<h3 class="header-title">
		<span>
			<c:choose>
				<c:when test="<%= escapeXml %>">
					<%= HtmlUtil.escape(headerTitle) %>
				</c:when>
				<c:otherwise>
					<%= headerTitle %>
				</c:otherwise>
			</c:choose>
		</span>
	</h3>
</div>
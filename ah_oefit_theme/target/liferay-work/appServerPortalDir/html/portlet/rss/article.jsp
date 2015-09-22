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

<%@ include file="/html/portlet/rss/init.jsp" %>

<%
String url = ParamUtil.getString(request, "url");
int index = ParamUtil.getInteger(request, "index");

SyndFeed feed = null;

try {
	ObjectValuePair ovp = RSSUtil.getFeed(url);

	feed = (SyndFeed)ovp.getValue();
}
catch (Exception e) {
}
%>

<c:if test="<%= (url != null) && (feed != null) %>">
	<div style="padding: 10px 10px 10px 10px;">

		<%
		List entries = feed.getEntries();

		if (index < entries.size()) {
			SyndEntry entry = (SyndEntry)entries.get(index);

			SyndContent description = entry.getDescription();

			String contentString = description.getValue();

			SyndContent content = null;

			try {
				content = (SyndContent)entry.getContents().get(0);

				if (Validator.isNotNull(content.getValue().trim())) {
					contentString = content.getValue();
				}
			}
			catch (Throwable t) {
			}
		%>

			<aui:a cssClass="font-large" href="<%= entry.getLink() %>" style="font-weight: bold;" target="_blank"><%= entry.getTitle() %></aui:a><br />

			<c:if test="<%= entry.getPublishedDate() != null %>">
				<%= dateFormatDateTime.format(entry.getPublishedDate()) %><br />
			</c:if>

			<div class="font-small">
				<%= contentString %>
			</div>

		<%
		}
		%>

	</div>
</c:if>
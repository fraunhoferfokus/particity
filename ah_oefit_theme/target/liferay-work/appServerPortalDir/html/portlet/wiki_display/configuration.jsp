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

<%@ include file="/html/portlet/wiki_display/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

nodeId = ParamUtil.getLong(request, "nodeId", nodeId);

List<WikiNode> nodes = WikiNodeServiceUtil.getNodes(scopeGroupId);

boolean nodeInGroup = false;
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<liferay-ui:error exception="<%= NoSuchNodeException.class %>" message="the-node-could-not-be-found" />

	<aui:fieldset>
		<c:choose>
			<c:when test="<%= !nodes.isEmpty() %>">
				<aui:select label="node" name="preferences--nodeId--">
					<aui:option value="" />

					<%
					for (WikiNode node : nodes) {
						node = node.toEscapedModel();

						if (nodeId == node.getNodeId()) {
							nodeInGroup = true;
						}
					%>

						<aui:option label="<%= node.getName() %>" selected="<%= nodeId == node.getNodeId() %>" value="<%= node.getNodeId() %>" />

					<%
					}
					%>

				</aui:select>
			</c:when>
			<c:otherwise>
				<div class="alert alert-info">
					<liferay-ui:message key="there-are-no-available-nodes-for-selection" />
				</div>
			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="<%= nodeInGroup %>">
				<aui:select label="page" name="preferences--title--">

					<%
					int total = WikiPageLocalServiceUtil.getPagesCount(nodeId, true);

					List pages = WikiPageLocalServiceUtil.getPages(nodeId, true, 0, total);

					for (int i = 0; i < pages.size(); i++) {
						WikiPage wikiPage = (WikiPage)pages.get(i);
					%>

						<aui:option label="<%= wikiPage.getTitle() %>" selected="<%= wikiPage.getTitle().equals(title) || (Validator.isNull(title) && wikiPage.getTitle().equals(WikiPageConstants.FRONT_PAGE)) %>" />

					<%
					}
					%>

				</aui:select>
			</c:when>
			<c:otherwise>
				<aui:input name="preferences--title--" type="hidden" value="<%= WikiPageConstants.FRONT_PAGE %>" />
			</c:otherwise>
		</c:choose>
	</aui:fieldset>

	<aui:button-row>
		<aui:button disabled="<%= nodes.isEmpty() %>" type="submit" />
	</aui:button-row>
</aui:form>
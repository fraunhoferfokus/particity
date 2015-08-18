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

<%@ include file="/html/portlet/wiki/init.jsp" %>

<%
String tabs2 = ParamUtil.getString(request, "tabs2");

String redirect = ParamUtil.getString(request, "redirect");

String uploadProgressId = PortalUtil.generateRandomKey(request, "portlet_wiki_import_pages_uploadProgressId");
String importProgressId = PortalUtil.generateRandomKey(request, "portlet_wiki_import_pages_importProgressId");

WikiNode node = (WikiNode)request.getAttribute(WebKeys.WIKI_NODE);

long nodeId = BeanParamUtil.getLong(node, request, "nodeId");

String[] importers = PropsValues.WIKI_IMPORTERS;

if (Validator.isNull(tabs2)) {
	tabs2 = importers[0];
}

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/wiki/import_pages");
portletURL.setParameter("redirect", redirect);
portletURL.setParameter("nodeId", String.valueOf(nodeId));
%>

<portlet:actionURL var="importPagesURL">
	<portlet:param name="struts_action" value="/wiki/import_pages" />
</portlet:actionURL>

<aui:form action="<%= importPagesURL %>" enctype="multipart/form-data" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "importPages();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="importProgressId" type="hidden" value="<%= importProgressId %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="nodeId" type="hidden" value="<%= nodeId %>" />
	<aui:input name="importer" type="hidden" value="<%= tabs2 %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="import-pages"
	/>

	<liferay-ui:tabs
		names="<%= StringUtil.merge(importers) %>"
		param="tabs2"
		url="<%= portletURL.toString() %>"
	/>

	<liferay-ui:error exception="<%= ImportFilesException.class %>" message="please-provide-all-mandatory-files-and-make-sure-the-file-types-are-valid" />
	<liferay-ui:error exception="<%= NoSuchNodeException.class %>" message="the-node-could-not-be-found" />

	<liferay-util:include page="<%= PropsUtil.get(PropsKeys.WIKI_IMPORTERS_PAGE, new Filter(tabs2)) %>" />

	<aui:button-row>
		<aui:button type="submit" value="import" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<liferay-ui:upload-progress
	id="<%= uploadProgressId %>"
	message="uploading"
	redirect="<%= HtmlUtil.escape(PortalUtil.escapeRedirect(redirect)) %>"
/>

<liferay-ui:upload-progress
	id="<%= importProgressId %>"
	message="importing"
	redirect="<%= HtmlUtil.escape(PortalUtil.escapeRedirect(redirect)) %>"
/>

<aui:script>
	function <portlet:namespace />importPages() {
		<%= uploadProgressId %>.startProgress();
		<%= importProgressId %>.startProgress();

		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>
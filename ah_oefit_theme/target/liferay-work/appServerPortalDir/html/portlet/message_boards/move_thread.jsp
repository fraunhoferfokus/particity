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

<%@ include file="/html/portlet/message_boards/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

MBMessage message = (MBMessage)request.getAttribute(WebKeys.MESSAGE_BOARDS_MESSAGE);

long messageId = message.getMessageId();

long categoryId = MBUtil.getCategoryId(request, message);

MBCategory category = MBCategoryLocalServiceUtil.getCategory(categoryId);

category = category.toEscapedModel();

MBThread thread = message.getThread();

MBMessage curParentMessage = null;
String parentAuthor = null;

String body = StringPool.BLANK;
boolean quote = false;
boolean splitThread = false;
%>

<portlet:actionURL var="moveThreadURL">
	<portlet:param name="struts_action" value="/message_boards/move_thread" />
</portlet:actionURL>

<aui:form action="<%= moveThreadURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "moveThread();" %>'>
	<aui:input name="threadId" type="hidden" value="<%= thread.getThreadId() %>" />
	<aui:input name="mbCategoryId" type="hidden" value="<%= categoryId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="move-thread"
	/>

	<liferay-ui:error exception="<%= MessageBodyException.class %>" message="please-enter-a-valid-message" />
	<liferay-ui:error exception="<%= MessageSubjectException.class %>" message="please-enter-a-valid-subject" />
	<liferay-ui:error exception="<%= NoSuchCategoryException.class %>" message="please-enter-a-valid-category" />

	<%
	long breadcrumbsMessageId = message.getMessageId();
	%>

	<aui:fieldset>
		<aui:field-wrapper label="category[message-board]">
			<div class="input-append">
				<liferay-ui:input-resource id="categoryName" url='<%= ((categoryId != MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID) && (categoryId != MBCategoryConstants.DISCUSSION_CATEGORY_ID)) ? category.getName() : LanguageUtil.get(pageContext, "message-boards-home") %>' />

				<aui:button name="selectCategoryButton" value="select" />
			</div>
		</aui:field-wrapper>

		<aui:input disabled="<%= thread.isLocked() %>" helpMessage='<%= thread.isLocked() ? LanguageUtil.get(pageContext, "unlock-thread-to-add-an-explanation-post") : StringPool.BLANK %>' label="add-explanation-post" name="addExplanationPost" onClick='<%= renderResponse.getNamespace() + "toggleExplanationPost();" %>' type="checkbox" />

		<div id="<portlet:namespace />explanationPost" style="display: none;">
			<aui:input maxlength="75" name="subject" style="width: 350px;" value="">
				<aui:validator name="required">
					function() {
						return A.one('#<portlet:namespace />addExplanationPostCheckbox').get('checked');
					}
				</aui:validator>
			</aui:input>

			<aui:field-wrapper label="body">
				<%@ include file="/html/portlet/message_boards/bbcode_editor.jspf" %>

				<aui:input name="body" type="hidden" />
			</aui:field-wrapper>
		</div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="move-thread" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />moveThread() {
		document.<portlet:namespace />fm.<portlet:namespace />body.value = <portlet:namespace />getHTML();

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />toggleExplanationPost() {
		if (document.getElementById('<portlet:namespace />addExplanationPostCheckbox').checked) {
			document.getElementById('<portlet:namespace />explanationPost').style.display = "";
		}
		else {
			document.getElementById('<portlet:namespace />explanationPost').style.display = "none";
		}
	}
</aui:script>

<%
MBUtil.addPortletBreadcrumbEntries(message, request, renderResponse);

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "move-thread"), currentURL);
%>

<aui:script use="aui-base">
	A.one('#<portlet:namespace />selectCategoryButton').on(
		'click',
		function(event) {
			Liferay.Util.selectEntity(
				{
					dialog: {
						constrain: true,
						modal: true,
						width: 680
					},
					id: '<portlet:namespace />selectCategory',
					title: '<liferay-ui:message arguments="category" key="select-x" />',
					uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="struts_action" value="/message_boards/select_category" /><portlet:param name="mbCategoryId" value="<%= String.valueOf(category.getParentCategoryId()) %>" /></portlet:renderURL>'
				},
				function(event) {
					document.<portlet:namespace />fm.<portlet:namespace />mbCategoryId.value = event.categoryid;

					document.getElementById('<portlet:namespace />categoryName').value = event.name;
				}
			);
		}
	);
</aui:script>
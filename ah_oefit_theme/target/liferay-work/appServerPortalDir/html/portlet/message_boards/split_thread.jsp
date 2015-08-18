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

MBCategory category = message.getCategory();

MBThread thread = MBThreadLocalServiceUtil.getThread(message.getThreadId());

long messageId = message.getMessageId();

long categoryId = message.getCategoryId();
long threadId = message.getThreadId();

MBMessage curParentMessage = null;
String parentAuthor = null;

String body = StringPool.BLANK;
boolean quote = false;
boolean splitThread = true;
%>

<portlet:actionURL var="splitThreadURL">
	<portlet:param name="struts_action" value="/message_boards/split_thread" />
</portlet:actionURL>

<aui:form action="<%= splitThreadURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "splitThread();" %>'>
	<aui:input name="messageId" type="hidden" value="<%= messageId %>" />
	<aui:input name="mbCategoryId" type="hidden" value="<%= categoryId %>" />

	<liferay-ui:header
		backURL="<%= redirect %>"
		title="message"
	/>

	<liferay-ui:error exception="<%= MessageBodyException.class %>" message="please-enter-a-valid-message" />
	<liferay-ui:error exception="<%= MessageSubjectException.class %>" message="please-enter-a-valid-subject" />
	<liferay-ui:error exception="<%= NoSuchCategoryException.class %>" message="please-enter-a-valid-category" />
	<liferay-ui:error exception="<%= SplitThreadException.class %>" message="a-thread-cannot-be-split-at-its-root-message" />

	<%
	long breadcrumbsMessageId = message.getMessageId();
	%>

	<div class="alert alert-info">
		<liferay-ui:message key="click-ok-to-create-a-new-thread-with-the-following-messages" />
	</div>

	<%
	MBMessageDisplay messageDisplay = MBMessageServiceUtil.getMessageDisplay(messageId, WorkflowConstants.STATUS_APPROVED, MBThreadConstants.THREAD_VIEW_TREE, false);

	MBTreeWalker treeWalker = messageDisplay.getTreeWalker();

	List messages = new ArrayList();

	messages.addAll(treeWalker.getMessages());

	messages = ListUtil.sort(messages, new MessageCreateDateComparator(true));
	%>

	<table class="toggle_id_message_boards_view_message_thread" id="toggle_id_message_boards_view_message_thread" style="display: <liferay-ui:toggle-value id="toggle_id_message_boards_view_message_thread" />;">

	<%
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER, treeWalker);
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CATEGORY, category);
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_CUR_MESSAGE, message);
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_DEPTH, new Integer(0));
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_LAST_NODE, Boolean.valueOf(false));
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_SEL_MESSAGE, message);
	request.setAttribute(WebKeys.MESSAGE_BOARDS_TREE_WALKER_THREAD, thread);
	%>

	<liferay-util:include page="/html/portlet/message_boards/view_thread_shortcut.jsp" />

	</table>

	<br />

	<aui:fieldset>
		<div id="<portlet:namespace />splitThreadSubject">
			<aui:input fieldParam="splitThreadSubject" label="subject-of-the-new-thread" model="<%= MBMessage.class %>" name="subject" value="<%= message.getSubject() %>" />
		</div>

		<aui:input disabled="<%= thread.isLocked() %>" helpMessage='<%= thread.isLocked() ? LanguageUtil.get(pageContext, "unlock-thread-to-add-an-explanation-post") : StringPool.BLANK %>' label="add-explanation-post-to-the-source-thread" name="addExplanationPost" onClick='<%= renderResponse.getNamespace() + "toggleExplanationPost();" %>' type="checkbox" />

		<div id="<portlet:namespace />explanationPost" style="display: none;">
			<div class="alert alert-info">
				<liferay-ui:message key="the-following-post-will-be-added-in-place-of-the-moved-message" />
			</div>

			<aui:input model="<%= MBMessage.class %>" name="subject" value='<%= LanguageUtil.get(pageContext, "thread-split") %>' />

			<aui:field-wrapper label="body">
				<c:choose>
					<c:when test="<%= message.isFormatBBCode() %>">
						<%@ include file="/html/portlet/message_boards/bbcode_editor.jspf" %>
					</c:when>
					<c:otherwise>
						<%@ include file="/html/portlet/message_boards/html_editor.jspf" %>
					</c:otherwise>
				</c:choose>

				<aui:input name="body" type="hidden" />
			</aui:field-wrapper>
		</div>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" value="ok" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />splitThread() {
		document.<portlet:namespace />fm.<portlet:namespace />body.value = <portlet:namespace />getHTML();

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />selectCategory(categoryId, categoryName) {
		document.<portlet:namespace />fm.<portlet:namespace />mbCategoryId.value = categoryId;

		var nameEl = document.getElementById("<portlet:namespace />categoryName");

		nameEl.href = "<portlet:renderURL><portlet:param name="struts_action" value="/message_boards/view" /></portlet:renderURL>&<portlet:namespace />mbCategoryId=" + categoryId;
		nameEl.innerHTML = categoryName + "&nbsp;";
	}

	function <portlet:namespace />toggleExplanationPost() {
		if (document.getElementById("<portlet:namespace />addExplanationPostCheckbox").checked) {
			document.getElementById("<portlet:namespace />explanationPost").style.display = "";
		}
		else {
			document.getElementById("<portlet:namespace />explanationPost").style.display = "none";
		}
	}
</aui:script>

<%
MBUtil.addPortletBreadcrumbEntries(message, request, renderResponse);

PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "split-thread"), currentURL);
%>
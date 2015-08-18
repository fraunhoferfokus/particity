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

<%@ include file="/html/portlet/blogs/init.jsp" %>

<%!
static final boolean EDITOR_INLINE_EDITING_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get("editor.inline.editing.enabled"));
%>

<%
SearchContainer searchContainer = (SearchContainer)request.getAttribute("view_entry_content.jsp-searchContainer");

BlogsEntry entry = (BlogsEntry)request.getAttribute("view_entry_content.jsp-entry");

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view_entry_content.jsp-assetEntry");
%>

<c:choose>
	<c:when test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.VIEW) && (entry.isVisible() || (entry.getUserId() == user.getUserId()) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE)) %>">
		<div class="entry <%= WorkflowConstants.getStatusLabel(entry.getStatus()) %>" id="<portlet:namespace /><%= entry.getEntryId() %>">
			<div class="entry-content">

				<%
				String strutsAction = ParamUtil.getString(request, "struts_action");
				%>

				<c:if test="<%= !entry.isApproved() %>">
					<h3>
						<liferay-ui:message key='<%= entry.isPending() ? "pending-approval" : WorkflowConstants.getStatusLabel(entry.getStatus()) %>' />
					</h3>
				</c:if>

				<portlet:renderURL var="viewEntryURL">
					<portlet:param name="struts_action" value="/blogs/view_entry" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
				</portlet:renderURL>

				<c:if test='<%= !strutsAction.equals("/blogs/view_entry") %>'>
					<div class="entry-title">
						<h2><aui:a href="<%= viewEntryURL %>"><%= HtmlUtil.escape(entry.getTitle()) %></aui:a></h2>
					</div>
				</c:if>

				<div class="entry-date">
					<span class="hide-accessible"><liferay-ui:message key="published-date" /></span>

					<%= dateFormatDateTime.format(entry.getDisplayDate()) %>
				</div>
			</div>

			<portlet:renderURL var="bookmarkURL" windowState="<%= WindowState.NORMAL.toString() %>">
				<portlet:param name="struts_action" value="/blogs/view_entry" />
				<portlet:param name="urlTitle" value="<%= entry.getUrlTitle() %>" />
			</portlet:renderURL>

			<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") %>'>
				<liferay-ui:social-bookmarks
					displayStyle="<%= socialBookmarksDisplayStyle %>"
					target="_blank"
					title="<%= entry.getTitle() %>"
					types="<%= socialBookmarksTypes %>"
					url="<%= PortalUtil.getCanonicalURL(bookmarkURL.toString(), themeDisplay, layout) %>"
				/>
			</c:if>

			<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) || BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
				<ul class="edit-actions entry icons-container lfr-meta-actions">
					<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) %>">
						<li class="edit-entry">
							<portlet:renderURL var="editEntryURL">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="redirect" value="<%= currentURL %>" />
								<portlet:param name="backURL" value="<%= currentURL %>" />
								<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
							</portlet:renderURL>

							<liferay-ui:icon
								image="edit"
								label="<%= true %>"
								url="<%= editEntryURL %>"
							/>
						</li>
					</c:if>

					<c:if test="<%= showEditEntryPermissions && BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.PERMISSIONS) %>">
						<li class="edit-entry-permissions">
							<liferay-security:permissionsURL
								modelResource="<%= BlogsEntry.class.getName() %>"
								modelResourceDescription="<%= entry.getTitle() %>"
								resourceGroupId="<%= String.valueOf(entry.getGroupId()) %>"
								resourcePrimKey="<%= String.valueOf(entry.getEntryId()) %>"
								var="permissionsEntryURL"
								windowState="<%= LiferayWindowState.POP_UP.toString() %>"
							/>

							<liferay-ui:icon
								image="permissions"
								label="<%= true %>"
								method="get"
								url="<%= permissionsEntryURL %>"
								useDialog="<%= true %>"
							/>
						</li>
					</c:if>

					<c:if test="<%= BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.DELETE) %>">
						<li class="delete-entry">
							<portlet:renderURL var="viewURL">
								<portlet:param name="struts_action" value="/blogs/view" />
							</portlet:renderURL>

							<portlet:actionURL var="deleteEntryURL">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="<%= Constants.CMD %>" value="<%= TrashUtil.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE %>" />
								<portlet:param name="redirect" value="<%= viewURL %>" />
								<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
							</portlet:actionURL>

							<liferay-ui:icon-delete
								label="<%= true %>"
								trash="<%= TrashUtil.isTrashEnabled(scopeGroupId) %>"
								url="<%= deleteEntryURL %>"
							/>
						</li>
					</c:if>
				</ul>
			</c:if>

			<div class="entry-body">
				<c:choose>
					<c:when test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_ABSTRACT) && !strutsAction.equals("/blogs/view_entry") %>'>
						<c:if test="<%= entry.isSmallImage() %>">
							<div class="asset-small-image">
								<img alt="" class="asset-small-image" src="<%= HtmlUtil.escape(entry.getEntryImageURL(themeDisplay)) %>" width="150" />
							</div>
						</c:if>

						<%
						String summary = entry.getDescription();

						if (Validator.isNull(summary)) {
							summary = entry.getContent();
						}
						%>

						<%= StringUtil.shorten(HtmlUtil.stripHtml(summary), pageAbstractLength) %>

						<br />

						<aui:a href="<%= viewEntryURL %>"><liferay-ui:message arguments='<%= new Object[] {"hide-accessible", HtmlUtil.escape(entry.getTitle())} %>' key="read-more-x-about-x" /> &raquo;</aui:a>
					</c:when>
					<c:when test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || strutsAction.equals("/blogs/view_entry") %>'>

						<%
						String entryContentId = "blogs-entry-content-" + entry.getEntryId();

						boolean inlineEditEnabled = EDITOR_INLINE_EDITING_ENABLED && BlogsEntryPermission.contains(permissionChecker, entry, ActionKeys.UPDATE) && BrowserSnifferUtil.isRtf(request) && !WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, BlogsEntry.class.getName()) && Validator.equals(GetterUtil.getString(SessionClicks.get(request, "liferay_toggle_controls", "visible")), "visible");
						%>

						<div id="<%= entryContentId %>" <%= inlineEditEnabled ? "class=\"lfr-editable\" contenteditable=\"true\" spellcheck=\"false\"" : StringPool.BLANK %>>
							<%= entry.getContent() %>
						</div>

						<liferay-ui:custom-attributes-available className="<%= BlogsEntry.class.getName() %>">
							<liferay-ui:custom-attribute-list
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
								editable="<%= false %>"
								label="<%= true %>"
							/>
						</liferay-ui:custom-attributes-available>

						<c:if test="<%= inlineEditEnabled %>">
							<portlet:actionURL var="updateEntryContent">
								<portlet:param name="struts_action" value="/blogs/edit_entry" />
								<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.UPDATE_CONTENT %>" />
								<portlet:param name="entryId" value="<%= String.valueOf(entry.getEntryId()) %>" />
							</portlet:actionURL>

							<liferay-ui:input-editor
								editorImpl="ckeditor"
								inlineEdit="<%= true %>"
								inlineEditSaveURL="<%= updateEntryContent %>"
								name="<%= entryContentId %>"
							/>
						</c:if>
					</c:when>
					<c:when test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_TITLE) && !strutsAction.equals("/blogs/view_entry") %>'>
						<aui:a href="<%= viewEntryURL %>"><liferay-ui:message arguments='<%= new Object[] {"hide-accessible", HtmlUtil.escape(entry.getTitle())} %>' key="read-more-x-about-x" /> &raquo;</aui:a>
					</c:when>
				</c:choose>
			</div>

			<div class="entry-footer">
				<div class="entry-author">
					<liferay-ui:message key="written-by" /> <%= HtmlUtil.escape(PortalUtil.getUserName(entry)) %>
				</div>

				<div class="stats">
					<c:if test="<%= assetEntry != null %>">
						<span class="view-count">
							<c:choose>
								<c:when test="<%= assetEntry.getViewCount() == 1 %>">
									<%= assetEntry.getViewCount() %> <liferay-ui:message key="view" />,
								</c:when>
								<c:when test="<%= assetEntry.getViewCount() > 1 %>">
									<%= assetEntry.getViewCount() %> <liferay-ui:message key="views" />,
								</c:when>
							</c:choose>
						</span>
					</c:if>

					<c:if test="<%= enableComments %>">
						<span class="comments">

							<%
							long classNameId = PortalUtil.getClassNameId(BlogsEntry.class.getName());

							int messagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(classNameId, entry.getEntryId(), WorkflowConstants.STATUS_APPROVED);
							%>

							<c:choose>
								<c:when test='<%= strutsAction.equals("/blogs/view_entry") %>'>
									<%= messagesCount %> <liferay-ui:message key='<%= (messagesCount == 1) ? "comment" : "comments" %>' />
								</c:when>
								<c:otherwise>
									<aui:a href='<%= PropsValues.PORTLET_URL_ANCHOR_ENABLE ? viewEntryURL : viewEntryURL + StringPool.POUND + "blogsCommentsPanelContainer" %>'><%= messagesCount %> <liferay-ui:message key='<%= (messagesCount == 1) ? "comment" : "comments" %>' /></aui:a>
								</c:otherwise>
							</c:choose>
						</span>
					</c:if>
				</div>

				<c:if test="<%= enableFlags %>">
					<liferay-ui:flags
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						contentTitle="<%= entry.getTitle() %>"
						reportedUserId="<%= entry.getUserId() %>"
					/>
				</c:if>

				<span class="entry-categories">
					<liferay-ui:asset-categories-summary
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<span class="entry-tags">
					<liferay-ui:asset-tags-summary
						className="<%= BlogsEntry.class.getName() %>"
						classPK="<%= entry.getEntryId() %>"
						portletURL="<%= renderResponse.createRenderURL() %>"
					/>
				</span>

				<c:if test='<%= displayStyle.equals(BlogsUtil.DISPLAY_STYLE_FULL_CONTENT) || strutsAction.equals("/blogs/view_entry") %>'>
					<c:if test="<%= enableRelatedAssets %>">
						<div class="entry-links">
							<liferay-ui:asset-links
								assetEntryId="<%= (assetEntry != null) ? assetEntry.getEntryId() : 0 %>"
								className="<%= BlogsEntry.class.getName() %>"
								classPK="<%= entry.getEntryId() %>"
							/>
						</div>
					</c:if>

					<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("bottom") %>'>
						<liferay-ui:social-bookmarks
							contentId="<%= String.valueOf(entry.getEntryId()) %>"
							displayStyle="<%= socialBookmarksDisplayStyle %>"
							target="_blank"
							title="<%= entry.getTitle() %>"
							types="<%= socialBookmarksTypes %>"
							url="<%= PortalUtil.getCanonicalURL(bookmarkURL.toString(), themeDisplay, layout) %>"
						/>
					</c:if>

					<c:if test="<%= enableRatings %>">
						<liferay-ui:ratings
							className="<%= BlogsEntry.class.getName() %>"
							classPK="<%= entry.getEntryId() %>"
						/>
					</c:if>
				</c:if>
			</div>
		</div>

		<div class="separator"><!-- --></div>
	</c:when>
	<c:otherwise>

		<%
		if (searchContainer != null) {
			searchContainer.setTotal(searchContainer.getTotal() - 1);
		}
		%>

	</c:otherwise>
</c:choose>
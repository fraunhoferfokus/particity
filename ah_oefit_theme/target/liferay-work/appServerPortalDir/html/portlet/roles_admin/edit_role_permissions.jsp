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

<%@ include file="/html/portlet/roles_admin/init.jsp" %>

<%
String cmd = ParamUtil.getString(request, Constants.CMD);

String tabs1 = "roles";
String tabs2 = ParamUtil.getString(request, "tabs2", "current");

String redirect = ParamUtil.getString(request, "redirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);

Role role = (Role)request.getAttribute(WebKeys.ROLE);

String portletResource = ParamUtil.getString(request, "portletResource");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/roles_admin/edit_role_permissions");
portletURL.setParameter(Constants.CMD, Constants.VIEW);
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("tabs2", tabs2);
portletURL.setParameter("backURL", backURL);
portletURL.setParameter("roleId", String.valueOf(role.getRoleId()));
%>

<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" varImpl="editPermissionsURL">
	<portlet:param name="struts_action" value="/roles_admin/edit_role_permissions" />
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.EDIT %>" />
	<portlet:param name="tabs1" value="roles" />
	<portlet:param name="redirect" value="<%= backURL %>" />
	<portlet:param name="roleId" value="<%= String.valueOf(role.getRoleId()) %>" />
</liferay-portlet:resourceURL>

<c:choose>
	<c:when test="<%= !portletName.equals(PortletKeys.ADMIN_SERVER) %>">
		<liferay-ui:header
			backURL="<%= backURL %>"
			localizeTitle="<%= false %>"
			title="<%= role.getTitle(locale) %>"
		/>

		<liferay-util:include page="/html/portlet/roles_admin/edit_role_tabs.jsp">
			<liferay-util:param name="tabs1" value="define-permissions" />
			<liferay-util:param name="backURL" value="<%= backURL %>" />
		</liferay-util:include>
	</c:when>
	<c:otherwise>

		<%
		request.setAttribute("edit_role_permissions.jsp-role", role);

		request.setAttribute("edit_role_permissions.jsp-portletResource", portletResource);
		%>

	</c:otherwise>
</c:choose>

<liferay-ui:success key="permissionDeleted" message="the-permission-was-deleted" />
<liferay-ui:success key="permissionsUpdated" message="the-role-permissions-were-updated" />

<aui:container id="permissionContainer">
	<aui:row>
		<c:if test="<%= !portletName.equals(PortletKeys.ADMIN_SERVER) %>">
			<aui:col width="<%= 25 %>">
				<%@ include file="/html/portlet/roles_admin/edit_role_permissions_navigation.jspf" %>
			</aui:col>
		</c:if>

		<aui:col id="permissionContentContainer" width="<%= portletName.equals(PortletKeys.ADMIN_SERVER) ? 100 : 75 %>">
			<c:choose>
				<c:when test="<%= cmd.equals(Constants.VIEW) %>">
					<liferay-util:include page="/html/portlet/roles_admin/edit_role_permissions_summary.jsp" />

					<c:if test="<%= portletName.equals(PortletKeys.ADMIN_SERVER) %>">
						<br />

						<aui:button href="<%= redirect %>" type="cancel" />
					</c:if>
				</c:when>
				<c:otherwise>
					<liferay-util:include page="/html/portlet/roles_admin/edit_role_permissions_form.jsp" />
				</c:otherwise>
			</c:choose>
		</aui:col>
	</aui:row>
</aui:container>

<aui:script>
	function <portlet:namespace />removeGroup(pos, target) {
		var selectedGroupIds = document.<portlet:namespace />fm['<portlet:namespace />groupIds' + target].value.split(",");
		var selectedGroupNames = document.<portlet:namespace />fm['<portlet:namespace />groupNames' + target].value.split("@@");

		selectedGroupIds.splice(pos, 1);
		selectedGroupNames.splice(pos, 1);

		<portlet:namespace />updateGroups(selectedGroupIds, selectedGroupNames, target);
	}

	function <portlet:namespace />selectOrganization(organizationId, groupId, name, type, target) {
		<portlet:namespace />selectGroup(groupId, name, target);
	}

	function <portlet:namespace />updateGroups(selectedGroupIds, selectedGroupNames, target) {
		document.<portlet:namespace />fm['<portlet:namespace />groupIds' + target].value = selectedGroupIds.join(',');
		document.<portlet:namespace />fm['<portlet:namespace />groupNames' + target].value = selectedGroupNames.join('@@');

		var nameEl = document.getElementById("<portlet:namespace />groupHTML" + target);

		var groupsHTML = '';

		for (var i = 0; i < selectedGroupIds.length; i++) {
			var id = selectedGroupIds[i];
			var name = selectedGroupNames[i];

			groupsHTML += '<span class="lfr-token"><span class="lfr-token-text">' + name + '</span><a class="icon icon-remove lfr-token-close" href="javascript:<portlet:namespace />removeGroup(' + i + ', \'' + target + '\' );"></a></span>';
		}

		if (groupsHTML == '') {
			groupsHTML = '<liferay-ui:message key="all-sites" />';
		}

		nameEl.innerHTML = groupsHTML;
	}
</aui:script>

<aui:script use="aui-io-request,aui-loading-mask-deprecated,aui-parse-content,aui-toggler,autocomplete-base,autocomplete-filters,liferay-notice">
	var AArray = A.Array;
	var AParseContent = A.Plugin.ParseContent;

	var notification;

	var permissionNavigationDataContainer = A.one('#<portlet:namespace />permissionNavigationDataContainer');

	var togglerDelegate;

	function createLiveSearch() {
		var instance = this;

		var trim = A.Lang.trim;

		var PermissionNavigationSearch = A.Component.create (
			{
				AUGMENTS: [A.AutoCompleteBase],

				EXTENDS: A.Base,

				NAME: 'searchpermissioNnavigation',

				prototype: {
					initializer: function() {
						var instance = this;

						instance._bindUIACBase();
						instance._syncUIACBase();
					}
				}
			}
		);

		var getItems = function() {
			var results = [];

			permissionNavigationItems.each(
				function(item, index, collection) {
					results.push(
						{
							node: item.ancestor(),
							data: trim(item.text())
						}
					);
				}
			);

			return results;
		};

		var getNoResultsNode = function() {
			if (!noResultsNode) {
				noResultsNode = A.Node.create('<div class="alert"><liferay-ui:message key="there-are-no-results" /></div>');
			}

			return noResultsNode;
		};

		var permissionNavigationItems = permissionNavigationDataContainer.all('.permission-navigation-item');

		var permissionNavigationSectionsNode = permissionNavigationDataContainer.all('.permission-navigation-section');

		var noResultsNode;

		var permissionNavigationSearch = new PermissionNavigationSearch(
			{
				inputNode: '#<portlet:namespace />permissionNavigationSearch',
				minQueryLength: 0,
				nodes: '.permission-navigation-item-container',
				resultFilters: 'phraseMatch',
				resultTextLocator: 'data',
				source: getItems()
			}
		);

		permissionNavigationSearch.on(
			'query',
			function(event) {
				if (event.query) {
					togglerDelegate.expandAll();
				}
				else {
					togglerDelegate.collapseAll();
				}
			}
		);

		permissionNavigationSearch.on(
			'results',
			function(event) {
				permissionNavigationItems.each(
					function(item, index, collection) {
						item.ancestor().addClass('hide');
					}
				);

				AArray.each(
					event.results,
					function(item, index, collection) {
						item.raw.node.removeClass('hide');
					}
				);

				var foundVisibleSection;

				permissionNavigationSectionsNode.each(
					function(item, index, collection) {
						var action = 'addClass';

						var visibleItem = item.one('.permission-navigation-item-container:not(.hide)');

						if (visibleItem) {
							action = 'removeClass';

							foundVisibleSection = true;
						}

						item[action]('hide');
					}
				);

				var noResultsNode = getNoResultsNode();

				if (foundVisibleSection) {
					noResultsNode.remove();
				}
				else {
					permissionNavigationDataContainer.appendChild(noResultsNode);
				}
			}
		);
	}

	function getNotification() {
		if (!notification) {
			notification = new Liferay.Notice(
				{
					closeText: false,
					content: '<liferay-ui:message key="sorry,-we-were-not-able-to-access-the-server" />' + '<button type="button" class="close">&times;</button>',
					noticeClass: 'hide',
					timeout: 10000,
					toggleText: false,
					type: 'warning',
					useAnimation: true
				}
			);
		}

		return notification;
	}

	function processNavigationLinks() {
		var permissionContainerNode = A.one('#<portlet:namespace />permissionContainer');

		var permissionContentContainerNode = permissionContainerNode.one('#<portlet:namespace />permissionContentContainer');

		var navigationLink = permissionContainerNode.delegate(
			'click',
			function(event) {
				event.preventDefault();

				permissionContentContainerNode.plug(A.LoadingMask);

				permissionContentContainerNode.loadingmask.show();

				permissionContentContainerNode.unplug(AParseContent);

				A.io.request(
					event.currentTarget.attr('href'),
					{
						on: {
							failure: function() {
								permissionContentContainerNode.loadingmask.hide();

								getNotification().show();
							},
							success: function(event, id, obj) {
								if (notification) {
									notification.hide();
								}

								permissionContentContainerNode.unplug(A.LoadingMask);

								permissionContentContainerNode.plug(AParseContent);

								var responseData = this.get('responseData');

								permissionContentContainerNode.empty();

								permissionContentContainerNode.setContent(responseData);
							}
						}
					}
				);
			},
			'.permission-navigation-link'
		);
	}

	Liferay.on(
		'<portlet:namespace />selectGroup',
		function(event) {
			var selectedGroupIds = [];

			var selectedGroupIdsField = document.<portlet:namespace />fm['<portlet:namespace />groupIds' + event.grouptarget].value;

			if (selectedGroupIdsField) {
				selectedGroupIds = selectedGroupIdsField.split(',');
			}

			var selectedGroupNames = [];
			var selectedGroupNamesField = document.<portlet:namespace />fm['<portlet:namespace />groupNames' + event.grouptarget].value;

			if (selectedGroupNamesField) {
				selectedGroupNames = selectedGroupNamesField.split('@@');
			}

			if (AUI().Array.indexOf(selectedGroupIds, event.groupid) == -1) {
				selectedGroupIds.push(event.groupid);
				selectedGroupNames.push(event.groupdescriptivename);
			}

			<portlet:namespace />updateGroups(selectedGroupIds, selectedGroupNames, event.grouptarget);
		}
	);

	A.on(
		'domready',
		function(event) {
			togglerDelegate = new A.TogglerDelegate(
				{
					animated: true,
					container: <portlet:namespace />permissionNavigationDataContainer,
					content: '.permission-navigation-item-content',
					header: '.permission-navigation-item-header'
				}
			);

			createLiveSearch();
			processNavigationLinks();
		}
	);

	Liferay.provide(
		window,
		'<portlet:namespace />updateActions',
		function() {
			var selectedTargets = Liferay.Util.listCheckedExcept(document.<portlet:namespace />fm, '<portlet:namespace />allRowIds');

			document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "actions";
			document.<portlet:namespace />fm.<portlet:namespace />redirect.value = "<%= portletURL.toString() %>";
			document.<portlet:namespace />fm.<portlet:namespace />selectedTargets.value = selectedTargets;

			submitForm(document.<portlet:namespace />fm);
		},
		['liferay-util-list-fields']
	);
</aui:script>
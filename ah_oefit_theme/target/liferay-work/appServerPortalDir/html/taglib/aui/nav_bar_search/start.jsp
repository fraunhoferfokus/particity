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

<%@ include file="/html/taglib/aui/nav_bar_search/init.jsp" %>

<div class="collapse nav-collapse" id="<%= id %>NavbarSearchCollapse">
	<div class="navbar-search <%= cssClass %>" id="<%= id %>" <%= InlineUtil.buildDynamicAttributes(dynamicAttributes) %>>
		<c:if test="<%= Validator.isNotNull(file) %>">
			<liferay-ui:search-form
				page="<%= file %>"
				searchContainer="<%= searchContainer %>"
			/>
		</c:if>

		<aui:script use="aui-base,event-outside">
			A.one('#<%= id %>NavbarBtn').on(
				['click', 'keypress'],
				function(event) {
					if ((event.type === 'click') || event.isKeyInSet('ENTER', 'SPACE')) {
						var btnNavbar = event.currentTarget;

						var navbar = btnNavbar.ancestor('.navbar');

						var navbarCollapse = A.one('#<%= id %>NavbarSearchCollapse');

						var handles = Liferay.Data['<%= id %>Handle'];

						var navbarWillOpen = !navbarCollapse.hasClass('open');

						if (!navbarWillOpen && handles && handles.length) {
							(new A.EventHandle(handles)).detach();

							handles = null;
						}
						else {
							handles = handles || [];

							var closeNavBar = function() {
								var handles = Liferay.Data['<%= id %>Handle'];

								(new A.EventHandle(handles)).detach();

								Liferay.Data['<%= id %>Handle'] = null;

								navbarCollapse.removeClass('open');

								if (navbar) {
									navbar.all('.btn-navbar, .nav').show();
								}

								btnNavbar.focus();
							};

							var handleMouseOutside = navbarCollapse.on(
								'mousedownoutside',
								function(event) {
									if (!btnNavbar.contains(event.target)) {
										closeNavBar();
									}
								}
							);

							var handleEscape = A.getDoc().on('key', closeNavBar, 'down:27');

							handles.push(handleEscape, handleMouseOutside);
						}

						navbarCollapse.toggleClass('open', navbarWillOpen);

						if (navbar) {
							navbar.all('.btn-navbar, .nav').hide();
						}

						if (navbarWillOpen) {
							Liferay.Util.focusFormField(navbarCollapse.one('input.search-query'));
						}

						Liferay.Data['<%= id %>Handle'] = handles;
					}
				}
			);
		</aui:script>
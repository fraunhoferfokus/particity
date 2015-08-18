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

<%@ include file="/html/taglib/init.jsp" %>

<%
String[] classNames = (String[])request.getAttribute("liferay-ui:my_sites:classNames");
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:my_sites:cssClass"));
boolean includeControlPanel = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:my_sites:includeControlPanel"));
int max = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:my_sites:max"));

if (max <= 0) {
	max = PropsValues.MY_SITES_MAX_ELEMENTS;
}

List<Group> mySiteGroups = user.getMySiteGroups(classNames, includeControlPanel, max);
%>

<c:if test="<%= !mySiteGroups.isEmpty() %>">
	<ul class="taglib-my-sites <%= cssClass %>">

		<%
		PortletURL portletURL = new PortletURLImpl(request, PortletKeys.SITE_REDIRECTOR, plid, PortletRequest.ACTION_PHASE);

		portletURL.setParameter("struts_action", "/my_sites/view");
		portletURL.setPortletMode(PortletMode.VIEW);
		portletURL.setWindowState(WindowState.NORMAL);

		for (Group mySiteGroup : mySiteGroups) {
			String escapedSiteName = HtmlUtil.escape(mySiteGroup.getName());

			boolean showPublicSite = mySiteGroup.isShowSite(permissionChecker, false);
			boolean showPrivateSite = mySiteGroup.isShowSite(permissionChecker, true);
		%>

			<c:if test="<%= showPublicSite || showPrivateSite %>">
				<c:choose>
					<c:when test='<%= PropsValues.MY_SITES_DISPLAY_STYLE.equals("simple") %>'>

						<%
						portletURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));

						boolean firstSite = false;

						if (mySiteGroups.indexOf(mySiteGroup) == 0) {
							firstSite = true;
						}

						boolean lastSite = false;

						if (mySiteGroups.size() == (mySiteGroups.indexOf(mySiteGroup) + 1)) {
							lastSite = true;
						}

						boolean selectedSite = false;

						if (layout != null) {
							if (layout.getGroupId() == mySiteGroup.getGroupId()) {
								selectedSite = true;
							}
							else if (mySiteGroup.hasStagingGroup()) {
								Group stagingGroup = mySiteGroup.getStagingGroup();

								if (layout.getGroupId() == stagingGroup.getGroupId()) {
									selectedSite = true;
								}
							}
						}

						String itemCssClass = StringPool.BLANK;

						if (firstSite) {
							itemCssClass += " first";
						}

						if (lastSite) {
							itemCssClass += " last";
						}

						String iconCssClass = "icon-spacer";

						portletURL.setParameter("privateLayout", Boolean.FALSE.toString());

						long stagingGroupId = 0;

						boolean showPublicSiteStaging = false;
						boolean showPrivateSiteStaging = false;

						if (mySiteGroup.hasStagingGroup()) {
							Group stagingGroup = mySiteGroup.getStagingGroup();

							stagingGroupId = stagingGroup.getGroupId();

							if (GroupPermissionUtil.contains(permissionChecker, mySiteGroup.getGroupId(), ActionKeys.VIEW_STAGING)) {
								if ((mySiteGroup.getPublicLayoutsPageCount() == 0) && (stagingGroup.getPublicLayoutsPageCount() > 0)) {
									showPublicSiteStaging = true;
								}

								if ((mySiteGroup.getPrivateLayoutsPageCount() == 0) && (stagingGroup.getPrivateLayoutsPageCount() > 0)) {
									showPrivateSiteStaging = true;
								}
							}
						}
						%>

						<c:if test="<%= showPublicSite && ((mySiteGroup.getPublicLayoutsPageCount() > 0) || showPublicSiteStaging) %>">

							<%
							if (showPublicSiteStaging) {
								portletURL.setParameter("groupId", String.valueOf(stagingGroupId));
							}
							%>

							<li class="<%= (selectedSite && layout.isPublicLayout()) ? "active" : "public-site" %> <%= itemCssClass %>">
								<a href="<%= HtmlUtil.escape(portletURL.toString()) %>" onclick="Liferay.Util.forcePost(this); return false;">

									<%
									String siteName = StringPool.BLANK;

									if (mySiteGroup.isUser()) {
										siteName = LanguageUtil.get(pageContext, "my-profile");
									}
									else if (escapedSiteName.equals(GroupConstants.GUEST)) {
										siteName = themeDisplay.getAccount().getName();
									}
									else {
										siteName = mySiteGroup.getDescriptiveName(locale);
									}

									if (showPublicSiteStaging) {
										StringBundler sb = new StringBundler(5);

										sb.append(HtmlUtil.escape(siteName));
										sb.append(StringPool.SPACE);
										sb.append(StringPool.OPEN_PARENTHESIS);
										sb.append(LanguageUtil.get(pageContext, "staging"));
										sb.append(StringPool.CLOSE_PARENTHESIS);

										siteName = sb.toString();
									}

									if ((mySiteGroup.getPrivateLayoutsPageCount() > 0) || showPrivateSiteStaging) {
										iconCssClass = "icon-eye-open";
									}
									%>

									<%@ include file="/html/taglib/ui/my_sites/page_site_name.jspf" %>

									<c:if test="<%= (mySiteGroup.getPrivateLayoutsPageCount() > 0) || showPrivateSiteStaging %>">
										<span class="badge site-type"><liferay-ui:message key="public" /></span>
									</c:if>
								</a>
							</li>

							<%
							if (showPublicSiteStaging) {
								portletURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
							}
							%>

						</c:if>

						<%
						portletURL.setParameter("privateLayout", Boolean.TRUE.toString());
						%>

						<c:if test="<%= showPrivateSite && ((mySiteGroup.getPrivateLayoutsPageCount() > 0) || showPrivateSiteStaging) %>">

							<%
							if (showPrivateSiteStaging) {
								portletURL.setParameter("groupId", String.valueOf(stagingGroupId));
							}
							%>

							<li class="<%= (selectedSite && layout.isPrivateLayout()) ? "active" : "private-site" %> <%= itemCssClass %>">
								<a href="<%= HtmlUtil.escape(portletURL.toString()) %>" onclick="Liferay.Util.forcePost(this); return false;">

									<%
									String siteName = StringPool.BLANK;

									if (mySiteGroup.isUser()) {
										siteName = LanguageUtil.get(pageContext, "my-dashboard");
									}
									else if (escapedSiteName.equals(GroupConstants.GUEST)) {
										siteName = themeDisplay.getAccount().getName();
									}
									else {
										siteName = mySiteGroup.getDescriptiveName(locale);
									}

									if (showPrivateSiteStaging) {
										StringBundler sb = new StringBundler(5);

										sb.append(siteName);
										sb.append(StringPool.SPACE);
										sb.append(StringPool.OPEN_PARENTHESIS);
										sb.append(LanguageUtil.get(pageContext, "staging"));
										sb.append(StringPool.CLOSE_PARENTHESIS);

										siteName = sb.toString();
									}

									if ((mySiteGroup.getPublicLayoutsPageCount() > 0) || showPublicSiteStaging) {
										iconCssClass = "icon-eye-close";
									}
									%>

									<%@ include file="/html/taglib/ui/my_sites/page_site_name.jspf" %>

									<c:if test="<%= (mySiteGroup.getPublicLayoutsPageCount() > 0) || showPublicSiteStaging %>">
										<span class="badge site-type"><liferay-ui:message key="private" /></span>
									</c:if>
								</a>
							</li>

							<%
							if (showPrivateSiteStaging) {
								portletURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
							}
							%>

						</c:if>
					</c:when>
					<c:when test='<%= PropsValues.MY_SITES_DISPLAY_STYLE.equals("classic") %>'>

						<%
						String publicAddPageHREF = null;
						String privateAddPageHREF = null;

						if (mySiteGroup.isSite() && GroupPermissionUtil.contains(permissionChecker, mySiteGroup.getGroupId(), ActionKeys.ADD_LAYOUT)) {
							PortletURL addPageURL = new PortletURLImpl(request, PortletKeys.SITE_REDIRECTOR, plid, PortletRequest.ACTION_PHASE);

							addPageURL.setParameter("struts_action", "/my_sites/edit_layouts");
							addPageURL.setParameter("redirect", currentURL);
							addPageURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
							addPageURL.setParameter("privateLayout", Boolean.FALSE.toString());
							addPageURL.setPortletMode(PortletMode.VIEW);
							addPageURL.setWindowState(WindowState.NORMAL);

							publicAddPageHREF = addPageURL.toString();

							addPageURL.setParameter("privateLayout", Boolean.TRUE.toString());

							privateAddPageHREF = addPageURL.toString();
						}
						else if (mySiteGroup.isUser()) {
							PortletURL publicAddPageURL = new PortletURLImpl(request, PortletKeys.MY_ACCOUNT, plid, PortletRequest.RENDER_PHASE);

							publicAddPageURL.setParameter("struts_action", "/my_account/edit_layouts");
							publicAddPageURL.setParameter("tabs1", "public-pages");
							publicAddPageURL.setParameter("redirect", currentURL);
							publicAddPageURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
							publicAddPageURL.setPortletMode(PortletMode.VIEW);
							publicAddPageURL.setWindowState(WindowState.MAXIMIZED);

							publicAddPageHREF = publicAddPageURL.toString();

							PortletURL privateAddPageURL = new PortletURLImpl(request, PortletKeys.MY_ACCOUNT, plid, PortletRequest.RENDER_PHASE);

							privateAddPageURL.setParameter("struts_action", "/my_account/edit_layouts");
							privateAddPageURL.setParameter("tabs1", "private-pages");
							privateAddPageURL.setParameter("redirect", currentURL);
							privateAddPageURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
							privateAddPageURL.setPortletMode(PortletMode.VIEW);
							privateAddPageURL.setWindowState(WindowState.MAXIMIZED);

							privateAddPageHREF = privateAddPageURL.toString();
						}

						boolean selectedSite = false;

						if (layout != null) {
							if (layout.getGroupId() == mySiteGroup.getGroupId()) {
								selectedSite = true;
							}
						}
						%>

						<li class="<%= selectedSite ? "active" : StringPool.BLANK %>">
							<c:choose>
								<c:when test="<%= mySiteGroup.isControlPanel() %>">
									<h3>
										<a href="<%= themeDisplay.getURLControlPanel() %>">
											<%= escapedSiteName %>
										</a>
									</h3>
								</c:when>
								<c:otherwise>
									<h3>
										<a href="javascript:;">
											<c:choose>
												<c:when test="<%= mySiteGroup.isUser() %>">
													<liferay-ui:message key="my-site" />
												</c:when>
												<c:otherwise>
													<%= escapedSiteName %>
												</c:otherwise>
											</c:choose>
										</a>
									</h3>

									<ul>

										<%
										portletURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
										portletURL.setParameter("privateLayout", Boolean.FALSE.toString());
										%>

										<c:if test="<%= showPublicSite %>">
											<li>
												<a href="<%= (mySiteGroup.getPublicLayoutsPageCount() > 0) ? HtmlUtil.escape(portletURL.toString()) : "javascript:;" %>"

												<c:if test="<%= mySiteGroup.isUser() %>">
													id="my-site-public-pages"
												</c:if>

												<c:if test="<%= (mySiteGroup.getPublicLayoutsPageCount() > 0) %>">
													onclick="Liferay.Util.forcePost(this); return false;"
												</c:if>

												><liferay-ui:message key="public-pages" /> <span class="page-count">(<%= mySiteGroup.getPublicLayoutsPageCount() %>)</span></a>

												<c:if test="<%= publicAddPageHREF != null %>">
													<a class="add-page" href="<%= HtmlUtil.escape(publicAddPageHREF) %>" onclick="Liferay.Util.forcePost(this); return false;"><liferay-ui:message key="manage-pages" /></a>
												</c:if>
											</li>
										</c:if>

										<%
										portletURL.setParameter("groupId", String.valueOf(mySiteGroup.getGroupId()));
										portletURL.setParameter("privateLayout", Boolean.TRUE.toString());
										%>

										<c:if test="<%= showPrivateSite %>">
											<li>
												<a href="<%= (mySiteGroup.getPrivateLayoutsPageCount() > 0) ? HtmlUtil.escape(portletURL.toString()) : "javascript:;" %>"

												<c:if test="<%= mySiteGroup.isUser() %>">
													id="my-site-private-pages"
												</c:if>

												<c:if test="<%= mySiteGroup.getPrivateLayoutsPageCount() > 0 %>">
													onclick="Liferay.Util.forcePost(this); return false;"
												</c:if>

												><liferay-ui:message key="private-pages" /> <span class="page-count">(<%= mySiteGroup.getPrivateLayoutsPageCount() %>)</span></a>

												<c:if test="<%= privateAddPageHREF != null %>">
													<a class="add-page" href="<%= HtmlUtil.escape(privateAddPageHREF) %>" onclick="Liferay.Util.forcePost(this); return false;"><liferay-ui:message key="manage-pages" /></a>
												</c:if>
											</li>
										</c:if>
									</ul>
								</c:otherwise>
							</c:choose>
						</li>
					</c:when>
				</c:choose>
			</c:if>

		<%
		}
		%>

	</ul>
</c:if>
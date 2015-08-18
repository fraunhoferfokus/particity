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

<%@ include file="/html/portlet/sites_admin/init.jsp" %>

<%
String viewOrganizationsRedirect = ParamUtil.getString(request, "viewOrganizationsRedirect", themeDisplay.getURLControlPanel());
String redirect = ParamUtil.getString(request, "redirect", viewOrganizationsRedirect);
String closeRedirect = ParamUtil.getString(request, "closeRedirect");
String backURL = ParamUtil.getString(request, "backURL", redirect);
boolean showBackURL = ParamUtil.getBoolean(request, "showBackURL", true);

Group group = (Group)request.getAttribute(WebKeys.GROUP);

long groupId = BeanParamUtil.getLong(group, request, "groupId");

long parentGroupId = ParamUtil.getLong(request, "parentGroupSearchContainerPrimaryKeys", GroupConstants.DEFAULT_PARENT_GROUP_ID);

Group liveGroup = null;

long liveGroupId = 0;

Group stagingGroup = null;

long stagingGroupId = 0;

UnicodeProperties liveGroupTypeSettings = null;

if (group != null) {
	if (group.isStagingGroup()) {
		liveGroup = group.getLiveGroup();

		stagingGroup = group;
	}
	else {
		liveGroup = group;

		if (group.hasStagingGroup()) {
			stagingGroup = group.getStagingGroup();
		}
	}

	liveGroupId = liveGroup.getGroupId();

	if (stagingGroup != null) {
		stagingGroupId = stagingGroup.getGroupId();
	}

	liveGroupTypeSettings = liveGroup.getTypeSettingsProperties();
}
else {
	liveGroupTypeSettings = new UnicodeProperties();
}

LayoutSetPrototype layoutSetPrototype = null;

long layoutSetPrototypeId = ParamUtil.getLong(request, "layoutSetPrototypeId");

if (layoutSetPrototypeId > 0) {
	layoutSetPrototype = LayoutSetPrototypeServiceUtil.getLayoutSetPrototype(layoutSetPrototypeId);
}

boolean showPrototypes = ParamUtil.getBoolean(request, "showPrototypes", true);

String[] mainSections = PropsValues.SITES_FORM_ADD_MAIN;
String[] seoSections = PropsValues.SITES_FORM_ADD_SEO;
String[] advancedSections = PropsValues.SITES_FORM_ADD_ADVANCED;
String[] miscellaneousSections = PropsValues.SITES_FORM_ADD_MISCELLANEOUS;

if (group != null) {
	mainSections = PropsValues.SITES_FORM_UPDATE_MAIN;
	seoSections = PropsValues.SITES_FORM_UPDATE_SEO;
	advancedSections = PropsValues.SITES_FORM_UPDATE_ADVANCED;
	miscellaneousSections = PropsValues.SITES_FORM_UPDATE_MISCELLANEOUS;
}

String[] analyticsTypes = PrefsPropsUtil.getStringArray(company.getCompanyId(), PropsKeys.ADMIN_ANALYTICS_TYPES, StringPool.NEW_LINE);

if ((analyticsTypes.length == 0) && ArrayUtil.contains(advancedSections, "analytics")) {
	advancedSections = ArrayUtil.remove(advancedSections, "analytics");
}

int contentSharingWithChildrenEnabledEnabled = PrefsPropsUtil.getInteger(company.getCompanyId(), PropsKeys.SITES_CONTENT_SHARING_WITH_CHILDREN_ENABLED);

if ((contentSharingWithChildrenEnabledEnabled == 0) && ArrayUtil.contains(advancedSections, "content-sharing")) {
	advancedSections = ArrayUtil.remove(advancedSections, "content-sharing");
}

boolean trashEnabled = PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.TRASH_ENABLED);

if (!trashEnabled && ArrayUtil.contains(advancedSections, "recycle-bin")) {
	advancedSections = ArrayUtil.remove(advancedSections, "recycle-bin");
}

if ((group != null) && group.isCompany()) {
	mainSections = ArrayUtil.remove(mainSections, "categorization");
	mainSections = ArrayUtil.remove(mainSections, "site-url");
	mainSections = ArrayUtil.remove(mainSections, "site-template");

	seoSections = new String[0];

	advancedSections = ArrayUtil.remove(advancedSections, "default-user-associations");
	advancedSections = ArrayUtil.remove(advancedSections, "analytics");
	advancedSections = ArrayUtil.remove(advancedSections, "content-sharing");

	miscellaneousSections = new String[0];
}

if ((group != null) && group.hasLocalOrRemoteStagingGroup()) {
	advancedSections = ArrayUtil.remove(advancedSections, "staging");
}

String[][] categorySections = {mainSections, seoSections, advancedSections, miscellaneousSections};
%>

<c:if test="<%= !portletName.equals(PortletKeys.SITE_SETTINGS) %>">

	<%
	if (group != null) {
		PortalUtil.addPortletBreadcrumbEntry(request, group.getDescriptiveName(locale), null);
		PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "edit"), currentURL);
	}
	else if (parentGroupId != GroupConstants.DEFAULT_PARENT_GROUP_ID) {
		Group parentGroup = GroupLocalServiceUtil.getGroup(parentGroupId);

		PortalUtil.addPortletBreadcrumbEntry(request, parentGroup.getDescriptiveName(locale), null);
	}
	%>

</c:if>

<c:if test="<%= (group == null) || !layout.isTypeControlPanel() %>">

	<%
	boolean localizeTitle = true;
	String title = "new-site";

	if (group != null) {
		localizeTitle= false;
		title = group.getDescriptiveName(locale);
	}
	else if (layoutSetPrototype != null) {
		localizeTitle= false;
		title = layoutSetPrototype.getName(locale);
	}
	else if (parentGroupId != GroupConstants.DEFAULT_PARENT_GROUP_ID) {
		title = "new-child-site";
	%>

		<div id="breadcrumb">
			<liferay-ui:breadcrumb showCurrentGroup="<%= false %>" showCurrentPortlet="<%= false %>" showGuestGroup="<%= false %>" showLayout="<%= false %>" showPortletBreadcrumb="<%= true %>" />
		</div>

	<%
	}
	%>

	<liferay-ui:header
		backURL="<%= backURL %>"
		escapeXml="<%= false %>"
		localizeTitle="<%= localizeTitle %>"
		showBackURL="<%= showBackURL %>"
		title="<%= HtmlUtil.escape(title) %>"
	/>
</c:if>

<portlet:actionURL var="editSiteURL">
	<portlet:param name="struts_action" value="/sites_admin/edit_site" />
</portlet:actionURL>

<aui:form action="<%= editSiteURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveGroup();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="closeRedirect" type="hidden" value="<%= closeRedirect %>" />
	<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
	<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
	<aui:input name="liveGroupId" type="hidden" value="<%= liveGroupId %>" />
	<aui:input name="stagingGroupId" type="hidden" value="<%= stagingGroupId %>" />

	<%
	request.setAttribute("site.group", group);
	request.setAttribute("site.liveGroup", liveGroup);
	request.setAttribute("site.liveGroupId", new Long(liveGroupId));
	request.setAttribute("site.stagingGroup", stagingGroup);
	request.setAttribute("site.stagingGroupId", new Long(stagingGroupId));
	request.setAttribute("site.liveGroupTypeSettings", liveGroupTypeSettings);
	request.setAttribute("site.layoutSetPrototype", layoutSetPrototype);
	request.setAttribute("site.showPrototypes", String.valueOf(showPrototypes));
	%>

	<liferay-ui:form-navigator
		backURL="<%= backURL %>"
		categoryNames="<%= _CATEGORY_NAMES %>"
		categorySections="<%= categorySections %>"
		jspPath="/html/portlet/sites_admin/site/"
		showButtons="<%= true %>"
	/>
</aui:form>

<aui:script>
	function <portlet:namespace />saveGroup() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (group == null) ? Constants.ADD : Constants.UPDATE %>";

		var ok = true;

		<c:if test="<%= liveGroup != null %>">
			A = AUI();

			var stagingTypeEl = A.one('input[name=<portlet:namespace />stagingType]:checked');

			<c:choose>
				<c:when test="<%= liveGroup.isStaged() && !liveGroup.isStagedRemotely() %>">
					var oldValue = 1;
				</c:when>
				<c:when test="<%= liveGroup.isStaged() && liveGroup.isStagedRemotely() %>">
					var oldValue = 2;
				</c:when>
				<c:otherwise>
					var oldValue = 0;
				</c:otherwise>
			</c:choose>

			if (stagingTypeEl && (stagingTypeEl.val() != oldValue)) {
				var currentValue = stagingTypeEl.val();

				ok = false;

				if (0 == currentValue) {
					ok = confirm('<%= UnicodeLanguageUtil.format(pageContext, "are-you-sure-you-want-to-deactivate-staging-for-x", liveGroup.getDescriptiveName(locale)) %>');
				}
				else if (1 == currentValue) {
					ok = confirm('<%= UnicodeLanguageUtil.format(pageContext, "are-you-sure-you-want-to-activate-local-staging-for-x", liveGroup.getDescriptiveName(locale)) %>');
				}
				else if (2 == currentValue) {
					ok = confirm('<%= UnicodeLanguageUtil.format(pageContext, "are-you-sure-you-want-to-activate-remote-staging-for-x", liveGroup.getDescriptiveName(locale)) %>');
				}
			}
		</c:if>

		if (ok) {
			<c:if test="<%= (group != null) && !group.isCompany() %>">
				<portlet:namespace />saveLocales();
			</c:if>

			submitForm(document.<portlet:namespace />fm);
		}
	}
</aui:script>

<aui:script use="aui-base">
	var applicationAdapter = A.one('#<portlet:namespace />customJspServletContextName');

	if (applicationAdapter) {
		var publicPages = A.one('#<portlet:namespace />publicLayoutSetPrototypeId');
		var privatePages = A.one('#<portlet:namespace />privateLayoutSetPrototypeId');

		var toggleCompatibleSiteTemplates = function(event) {
			var siteTemplate = applicationAdapter.val();

			var options = A.all([]);

			if (publicPages) {
				options = options.concat(publicPages.all('option[data-servletContextName]'));
			}

			if (privatePages) {
				options = options.concat(privatePages.all('option[data-servletContextName]'));
			}

			options.attr('disabled', false);

			options.filter(':not([data-servletContextName=' + siteTemplate + '])').attr('disabled', true);
		};

		applicationAdapter.on('change', toggleCompatibleSiteTemplates);

		toggleCompatibleSiteTemplates();
	}
</aui:script>

<%!
private static final String[] _CATEGORY_NAMES = {"basic-information", "search-engine-optimization", "advanced", "miscellaneous"};
%>
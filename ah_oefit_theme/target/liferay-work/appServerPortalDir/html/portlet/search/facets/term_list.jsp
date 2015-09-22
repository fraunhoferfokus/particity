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

<%@ include file="/html/portlet/search/facets/init.jsp" %>

<%
if (termCollectors.isEmpty()) {
	return;
}

int frequencyThreshold = dataJSONObject.getInt("frequencyThreshold");
int maxTerms = dataJSONObject.getInt("maxTerms");
%>

<div class="<%= cssClass %>" data-facetFieldName="<%= HtmlUtil.escapeAttribute(facet.getFieldId()) %>" id="<%= randomNamespace %>facet">
	<aui:input name="<%= HtmlUtil.escapeAttribute(facet.getFieldId()) %>" type="hidden" value="<%= fieldParam %>" />

	<ul class="nav nav-pills nav-stacked term-list">
		<li class="facet-value default <%= Validator.isNull(fieldParam) ? "active" : StringPool.BLANK %>">
			<a data-value="" href="javascript:;"><liferay-ui:message key="any-term" /></a>
		</li>

		<%
		for (int i = 0; i < termCollectors.size(); i++) {
			TermCollector termCollector = termCollectors.get(i);
		%>

			<c:if test="<%= fieldParam.equals(termCollector.getTerm()) %>">
				<aui:script use="liferay-token-list">
					Liferay.Search.tokenList.add(
						{
							clearFields: '<%= renderResponse.getNamespace() + HtmlUtil.escapeJS(facet.getFieldId()) %>',
							text: '<%= HtmlUtil.escapeJS(termCollector.getTerm()) %>'
						}
					);
				</aui:script>
			</c:if>

		<%
			if (((maxTerms > 0) && (i >= maxTerms)) || ((frequencyThreshold > 0) && (frequencyThreshold > termCollector.getFrequency()))) {
				break;
			}
		%>

			<li class="facet-value <%= fieldParam.equals(termCollector.getTerm()) ? "active" : StringPool.BLANK %>">
				<a data-value="<%= HtmlUtil.escapeAttribute(termCollector.getTerm()) %>" href="javascript:;">
					<%= HtmlUtil.escape(termCollector.getTerm()) %>

					<span class="badge badge-info frequency"><%= termCollector.getFrequency() %></span>
				</a>
			</li>

		<%
		}
		%>

	</ul>
</div>
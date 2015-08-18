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
String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_input_time_page") + StringPool.UNDERLINE;

String amPmParam = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-time:amPmParam"));
int amPmValue = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:input-time:amPmValue"));
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-time:cssClass"));
String dateParam = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-time:dateParam"), "date");
Date dateValue = (Date)GetterUtil.getObject(request.getAttribute("liferay-ui:input-time:dateValue"));
boolean disabled = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-time:disabled"));
String hourParam = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-time:hourParam"));
int hourValue = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:input-time:hourValue"));
String minuteParam = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-time:minuteParam"));
int minuteValue = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:input-time:minuteValue"));
int minuteInterval = GetterUtil.getInteger((String)request.getAttribute("liferay-ui:input-time:minuteInterval"));
String name = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-time:name"));

if (minuteInterval < 1) {
	minuteInterval = 30;
}

int hourOfDayValue = hourValue;

if (amPmValue == Calendar.PM) {
	hourOfDayValue += 12;
}

String amPmParamId = namespace + HtmlUtil.getAUICompatibleId(amPmParam);
String dateParamId = namespace + HtmlUtil.getAUICompatibleId(dateParam);
String hourParamId = namespace + HtmlUtil.getAUICompatibleId(hourParam);
String minuteParamId = namespace + HtmlUtil.getAUICompatibleId(minuteParam);
String nameId = namespace + HtmlUtil.getAUICompatibleId(name);

Calendar calendar = CalendarFactoryUtil.getCalendar(1970, 0, 1, hourOfDayValue, minuteValue);

String simpleDateFormatPattern = _SIMPLE_DATE_FORMAT_PATTERN_ISO;

if (BrowserSnifferUtil.isMobile(request)) {
	simpleDateFormatPattern = _SIMPLE_DATE_FORMAT_PATTERN_HTML5;
}
else if (DateUtil.isFormatAmPm(locale)) {
	simpleDateFormatPattern = _SIMPLE_DATE_FORMAT_PATTERN;
}

String placeholder = _PLACEHOLDER_DEFAULT;

if (!DateUtil.isFormatAmPm(locale)) {
	placeholder = _PLACEHOLDER_ISO;
}

Format format = FastDateFormatFactoryUtil.getSimpleDateFormat(simpleDateFormatPattern, locale);
%>

<span class="lfr-input-time <%= cssClass %>" id="<%= randomNamespace %>displayTime">
	<c:choose>
		<c:when test="<%= BrowserSnifferUtil.isMobile(request) %>">
			<input class="input-small" <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= nameId %>" name="<%= namespace + HtmlUtil.escapeAttribute(name) %>" type="time" value="<%= format.format(calendar.getTime()) %>" />
		</c:when>
		<c:otherwise>
			<input class="input-small" <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= nameId %>" name="<%= namespace + HtmlUtil.escapeAttribute(name) %>" type="text" placeholder="<%= placeholder %>" value="<%= format.format(calendar.getTime()) %>" />
		</c:otherwise>
	</c:choose>

	<input <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= hourParamId %>" name="<%= namespace + HtmlUtil.escapeAttribute(hourParam) %>" type="hidden" value="<%= hourValue %>" />
	<input <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= minuteParamId %>" name="<%= namespace + HtmlUtil.escapeAttribute(minuteParam) %>" type="hidden" value="<%= minuteValue %>" />
	<input <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= amPmParamId %>" name="<%= namespace + HtmlUtil.escapeAttribute(amPmParam) %>" type="hidden" value="<%= amPmValue %>" />
	<input <%= disabled ? "disabled=\"disabled\"" : "" %> id="<%= dateParamId %>" name="<%= namespace + HtmlUtil.escapeAttribute(dateParam) %>" type="hidden" value="<%= dateValue %>" />
</span>

<aui:script use='<%= "aui-timepicker" + (BrowserSnifferUtil.isMobile(request) ? "-native" : StringPool.BLANK) %>'>
	Liferay.component(
		'<%= nameId %>TimePicker',
		function() {
			var timePicker = new A.TimePicker<%= BrowserSnifferUtil.isMobile(request) ? "Native" : StringPool.BLANK %>(
				{
					container: '#<%= randomNamespace %>displayTime',
					mask: '<%= DateUtil.isFormatAmPm(locale) ? "%I:%M %p" : "%H:%M" %>',
					on: {
						selectionChange: function(event) {
							var instance = this;

							var container = instance.get('container');

							var date = event.newSelection[0];

							var hours = date.getHours();

							var amPm = 0;

							<c:if test="<%= DateUtil.isFormatAmPm(locale) %>">
								if (hours > 11) {
									amPm = 1;
									hours -= 12;
								}
							</c:if>

							if (date) {
								container.one('#<%= hourParamId %>').val(hours);
								container.one('#<%= minuteParamId %>').val(date.getMinutes());
								container.one('#<%= amPmParamId %>').val(amPm);
								container.one('#<%= dateParamId %>').val(date);
							}
						}
					},
					popover: {
						zIndex: Liferay.zIndex.TOOLTIP
					},
					trigger: '#<%= nameId %>',
					values: <%= _getHoursJSONArray(minuteInterval, locale) %>
				}
			);

			timePicker.getTime = function() {
				var instance = this;

				var container = instance.get('container');

				return A.Date.parse(container.one('#<%= dateParamId %>').val());
			};

			return timePicker;
		}
	);

	Liferay.component('<%= nameId %>TimePicker');
</aui:script>

<%!
private JSONArray _getHoursJSONArray(int minuteInterval, Locale locale) throws Exception {
	NumberFormat numberFormat = NumberFormat.getInstance(locale);

	numberFormat.setMinimumIntegerDigits(2);

	JSONArray hoursJSONArray = JSONFactoryUtil.createJSONArray();

	for (int h = 0; h < 24; h++) {
		for (int m = 0; m < 60; m += minuteInterval) {
			StringBundler sb = new StringBundler(3);

			sb.append(numberFormat.format(h));
			sb.append(StringPool.COLON);
			sb.append(numberFormat.format(m));

			hoursJSONArray.put(sb.toString());
		}
	}

	return hoursJSONArray;
}

private static final String _SIMPLE_DATE_FORMAT_PATTERN = "hh:mm a";

private static final String _SIMPLE_DATE_FORMAT_PATTERN_HTML5 = "HH:mm";

private static final String _SIMPLE_DATE_FORMAT_PATTERN_ISO = "HH:mm";

private static final String _PLACEHOLDER_DEFAULT = "h:mm am/pm";

private static final String _PLACEHOLDER_ISO = "h:mm";
%>
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

<%@ include file="/html/taglib/ui/custom_attribute/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "taglib_ui_custom_attribute_page") + StringPool.UNDERLINE;

String className = (String)request.getAttribute("liferay-ui:custom-attribute:className");
long classPK = GetterUtil.getLong((String)request.getAttribute("liferay-ui:custom-attribute:classPK"));
boolean editable = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:custom-attribute:editable"));
boolean label = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:custom-attribute:label"));
String name = (String)request.getAttribute("liferay-ui:custom-attribute:name");

ExpandoBridge expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(company.getCompanyId(), className, classPK);
%>

<c:if test="<%= expandoBridge.hasAttribute(name) %>">

	<%
	int type = expandoBridge.getAttributeType(name);
	Serializable value = expandoBridge.getAttribute(name);
	Serializable defaultValue = expandoBridge.getAttributeDefault(name);

	UnicodeProperties properties = expandoBridge.getAttributeProperties(name);

	boolean propertyHidden = GetterUtil.getBoolean(properties.get(ExpandoColumnConstants.PROPERTY_HIDDEN));
	boolean propertyVisibleWithUpdatePermission = GetterUtil.getBoolean(properties.get(ExpandoColumnConstants.PROPERTY_VISIBLE_WITH_UPDATE_PERMISSION));
	boolean propertySecret = GetterUtil.getBoolean(properties.getProperty(ExpandoColumnConstants.PROPERTY_SECRET));
	int propertyHeight = GetterUtil.getInteger(properties.getProperty(ExpandoColumnConstants.PROPERTY_HEIGHT));
	int propertyWidth = GetterUtil.getInteger(properties.getProperty(ExpandoColumnConstants.PROPERTY_WIDTH));
	String propertyDisplayType = GetterUtil.getString(properties.getProperty(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE), ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX);

	if (editable && propertyVisibleWithUpdatePermission) {
		propertyHidden = !ExpandoColumnPermissionUtil.contains(
			permissionChecker, company.getCompanyId(), className,
			ExpandoTableConstants.DEFAULT_TABLE_NAME, name, ActionKeys.UPDATE);
	}

	String localizedName = LanguageUtil.get(pageContext, name);

	if (name.equals(localizedName)) {
		localizedName = HtmlUtil.escape(TextFormatter.format(name, TextFormatter.J));
	}

	Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
	%>

	<c:if test="<%= !propertyHidden && ExpandoColumnPermissionUtil.contains(permissionChecker, company.getCompanyId(), className, ExpandoTableConstants.DEFAULT_TABLE_NAME, name, ActionKeys.VIEW) %>">

		<c:choose>
			<c:when test="<%= editable && ExpandoColumnPermissionUtil.contains(permissionChecker, company.getCompanyId(), className, ExpandoTableConstants.DEFAULT_TABLE_NAME, name, ActionKeys.UPDATE) %>">
				<aui:field-wrapper label="<%= label ? localizedName : StringPool.BLANK %>">
					<input name="<portlet:namespace />ExpandoAttributeName--<%= HtmlUtil.escapeAttribute(name) %>--" type="hidden" value="<%= HtmlUtil.escapeAttribute(name) %>" />

					<c:choose>
						<c:when test="<%= type == ExpandoColumnConstants.BOOLEAN %>">

							<%
							Boolean curValue = (Boolean)value;

							if (curValue == null) {
								curValue = (Boolean)defaultValue;
							}

							curValue = ParamUtil.getBoolean(request, "ExpandoAttribute--" + name + "--", curValue);
							%>

							<select id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">
								<option <%= curValue ? "selected" : "" %> value="1"><liferay-ui:message key="true" /></option>
								<option <%= !curValue ? "selected" : "" %> value="0"><liferay-ui:message key="false" /></option>
							</select>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.BOOLEAN_ARRAY %>">
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.DATE %>">
							<span id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>">

								<%
								Calendar valueDate = CalendarFactoryUtil.getCalendar(timeZone, locale);

								if (value != null) {
									valueDate.setTime((Date)value);
								}
								else if (defaultValue != null) {
									valueDate.setTime((Date)defaultValue);
								}
								else {
									valueDate.setTime(new Date());
								}

								String fieldParam = "ExpandoAttribute--" + name + "--";

								int day = ParamUtil.getInteger(request, fieldParam + "Day", -1);

								if ((day == -1) && (valueDate != null)) {
									day = valueDate.get(Calendar.DATE);
								}

								int month = ParamUtil.getInteger(request, fieldParam + "Month", -1);

								if ((month == -1) && (valueDate != null)) {
									month = valueDate.get(Calendar.MONTH);
								}

								int year = ParamUtil.getInteger(request, fieldParam + "Year", -1);

								if ((year == -1) && (valueDate != null)) {
									year = valueDate.get(Calendar.YEAR);
								}

								int amPm = ParamUtil.getInteger(request, fieldParam + "AmPm", -1);

								if ((amPm == -1) && (valueDate != null)) {
									amPm = Calendar.AM;

									if (DateUtil.isFormatAmPm(locale)) {
										amPm = valueDate.get(Calendar.AM_PM);
									}
								}

								int hour = ParamUtil.getInteger(request, fieldParam + "Hour", -1);

								if ((hour == -1) && (valueDate != null)) {
									hour = valueDate.get(Calendar.HOUR_OF_DAY);

									if (DateUtil.isFormatAmPm(locale)) {
										hour = valueDate.get(Calendar.HOUR);
									}
								}

								int minute = ParamUtil.getInteger(request, fieldParam + "Minute", -1);

								if ((minute == -1) && (valueDate != null)) {
									minute = valueDate.get(Calendar.MINUTE);
								}
								%>

								<liferay-ui:input-date
									dayParam='<%= fieldParam + "Day" %>'
									dayValue="<%= day %>"
									disabled="<%= false %>"
									firstDayOfWeek="<%= valueDate.getFirstDayOfWeek() - 1 %>"
									monthParam='<%= fieldParam + "Month" %>'
									monthValue="<%= month %>"
									name='<%= fieldParam + "Date" %>'
									yearParam='<%= fieldParam + "Year" %>'
									yearValue="<%= year %>"
								/>

								<liferay-ui:input-time
									amPmParam='<%= fieldParam + "AmPm" %>'
									amPmValue="<%= amPm %>"
									disabled="<%= false %>"
									hourParam='<%= fieldParam + "Hour" %>'
									hourValue="<%= hour %>"
									minuteParam='<%= fieldParam + "Minute" %>'
									minuteValue="<%= minute %>"
									name='<%= fieldParam + "Time" %>'
								/>
							</span>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.DATE_ARRAY %>">
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.DOUBLE_ARRAY %>">
							<c:choose>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									double[] curValue = (double[])value;

									for (double curDefaultValue : (double[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									double[] curValue = (double[])value;

									for (double curDefaultValue : (double[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										double[] curValue = (double[])value;

										for (double curDefaultValue : (double[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %>><%= curDefaultValue %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									if (((double[])value).length == 0) {
										value = defaultValue;
									}

									double[] values = ParamUtil.getDoubleValues(request, "ExpandoAttribute--" + name + "--", (double[])value);
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= StringUtil.merge(values, StringPool.NEW_LINE) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.FLOAT_ARRAY %>">
							<c:choose>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									float[] curValue = (float[])value;

									for (float curDefaultValue : (float[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br>

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									float[] curValue = (float[])value;

									for (float curDefaultValue : (float[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br>

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										float[] curValue = (float[])value;

										for (float curDefaultValue : (float[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %>><%= curDefaultValue %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									if (((float[])value).length == 0) {
										value = defaultValue;
									}

									float[] values = ParamUtil.getFloatValues(request, "ExpandoAttribute--" + name + "--", (float[])value);
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= StringUtil.merge((float[])value, StringPool.NEW_LINE) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.INTEGER_ARRAY %>">
							<c:choose>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									int[] curValue = (int[])value;

									for (int curDefaultValue : (int[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue,curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									int[] curValue = (int[])value;

									for (int curDefaultValue : (int[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue,curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										int[] curValue = (int[])value;

										for (int curDefaultValue : (int[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %>><%= curDefaultValue %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									if (((int[])value).length == 0) {
										value = defaultValue;
									}

									int[] values = ParamUtil.getIntegerValues(request, "ExpandoAttribute--" + name + "--", (int[])value);
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= StringUtil.merge(values, StringPool.NEW_LINE) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.LONG_ARRAY %>">
							<c:choose>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									long[] curValue = (long[])value;

									for (long curDefaultValue : (long[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									long[] curValue = (long[])value;

									for (long curDefaultValue : (long[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										long[] curValue = (long[])value;

										for (long curDefaultValue : (long[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %>><%= curDefaultValue %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									if (((long[])value).length == 0) {
										value = defaultValue;
									}

									long[] values = ParamUtil.getLongValues(request, "ExpandoAttribute--" + name + "--", (long[])value);
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= StringUtil.merge(values, StringPool.NEW_LINE) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.NUMBER_ARRAY %>">
							<c:choose>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									Number[] curValue = (Number[])value;

									for (Number curDefaultValue : (Number[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									Number[] curValue = (Number[])value;

									for (Number curDefaultValue : (Number[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										Number[] curValue = (Number[])value;

										for (Number curDefaultValue : (Number[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %>><%= curDefaultValue %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									if (((Number[])value).length == 0) {
										value = defaultValue;
									}

									Number[] values = ParamUtil.getNumberValues(request, "ExpandoAttribute--" + name + "--", (Number[])value);
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= StringUtil.merge(values, StringPool.NEW_LINE) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.SHORT_ARRAY %>">
							<c:choose>

								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									short[] curValue = (short[])value;

									for (short curDefaultValue : (short[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									short[] curValue = (short[])value;

									for (short curDefaultValue : (short[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= curDefaultValue %>"><%= curDefaultValue %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										short[] curValue = (short[])value;

										for (short curDefaultValue : (short[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %>><%= curDefaultValue %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									if (((short[])value).length == 0) {
										value = defaultValue;
									}

									short[] values = ParamUtil.getShortValues(request, "ExpandoAttribute--" + name + "--", (short[])value);
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= StringUtil.merge(values, StringPool.NEW_LINE) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.STRING_ARRAY %>">
							<c:choose>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX) %>">

									<%
									String[] curValue = (String[])value;

									for (String curDefaultValue : (String[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="checkbox" value="<%= HtmlUtil.escapeAttribute(curDefaultValue) %>"><%= HtmlUtil.escape(curDefaultValue) %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_RADIO) %>">

									<%
									String[] curValue = (String[])value;

									for (String curDefaultValue : (String[])defaultValue) {
									%>

										<input <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "checked" : "" %> name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--" type="radio" value="<%= HtmlUtil.escapeAttribute(curDefaultValue) %>"><%= HtmlUtil.escape(curDefaultValue) %></input><br />

									<%
									}
									%>

								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST) %>">
									<select name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--">

										<%
										String[] curValue = (String[])value;

										for (String curDefaultValue : (String[])defaultValue) {
										%>

											<option <%= ((curValue.length > 0) && ArrayUtil.contains(curValue, curDefaultValue)) ? "selected" : "" %> value="<%= HtmlUtil.escape(curDefaultValue) %>"><%= HtmlUtil.escape(curDefaultValue) %></option>

										<%
										}
										%>

									</select>
								</c:when>
								<c:when test="<%= propertyDisplayType.equals(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_TEXT_BOX) %>">

									<%
									String paramValue = ParamUtil.getString(request, "ExpandoAttribute--" + name + "--");

									if (value == null) {
										value = defaultValue;
									}

									String[] values = (String[])value;

									if (Validator.isNotNull(paramValue)) {
										values = new String[] {paramValue};
									}
									%>

									<textarea class="lfr-textarea" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"><%= HtmlUtil.escape(StringUtil.merge(values, StringPool.NEW_LINE)) %></textarea>
								</c:when>
							</c:choose>
						</c:when>
						<c:when test="<%= type == ExpandoColumnConstants.STRING_LOCALIZED %>">

							<%
							String xml = ParamUtil.getString(request, "ExpandoAttribute--" + name + "--");

							if (Validator.isNull(xml) && (value != null)) {
								xml = LocalizationUtil.updateLocalization((Map<Locale,String>)value, StringPool.BLANK, "Data", LocaleUtil.toLanguageId(locale));
							}

							if (Validator.isNull(xml) && (defaultValue != null)) {
								xml = LocalizationUtil.updateLocalization((Map<Locale,String>)defaultValue, StringPool.BLANK, "Data", LocaleUtil.toLanguageId(locale));
							}
							%>

							<liferay-ui:input-localized cssClass="lfr-input-text" id="<%= randomNamespace + name %>" name='<%= "ExpandoAttribute--" + name + "--" %>' xml="<%= xml %>" />
						</c:when>
						<c:otherwise>

							<%
							String paramValue = ParamUtil.getString(request, "ExpandoAttribute--" + name + "--");

							if (Validator.isNotNull(paramValue)) {
								value = paramValue;
							}

							if (Validator.isNull(String.valueOf(value))) {
								value = defaultValue;
							}
							%>

							<c:choose>
								<c:when test="<%= propertyHeight > 0 %>">
									<textarea class="lfr-input-text" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"
										style="
											<c:if test="<%= propertyHeight > 0 %>">
												height: <%= propertyHeight %>px;
											</c:if>

											<c:if test="<%= propertyWidth > 0 %>">
												width: <%= propertyWidth %>px;
											</c:if>"
									><%= HtmlUtil.escape(String.valueOf(value)) %></textarea>
								</c:when>
								<c:otherwise>
									<input class="lfr-input-text" id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>" name="<portlet:namespace />ExpandoAttribute--<%= HtmlUtil.escapeAttribute(name) %>--"
										style="
											<c:if test="<%= propertyWidth > 0 %>">
												width: <%= propertyWidth %>px;
											</c:if>"
										type="<%= propertySecret ? "password" : "text" %>" value="<%= HtmlUtil.escape(String.valueOf(value)) %>"
									/>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose>
				</aui:field-wrapper>
			</c:when>
			<c:otherwise>

				<%
				StringBundler sb = new StringBundler();

				if (type == ExpandoColumnConstants.BOOLEAN) {
					sb.append((Boolean)value);
				}
				else if (type == ExpandoColumnConstants.BOOLEAN_ARRAY) {
					if (!Arrays.equals((boolean[])value, (boolean[])defaultValue)) {
						sb.append(StringUtil.merge((boolean[])value));
					}
				}
				else if (type == ExpandoColumnConstants.DATE) {
					sb.append(dateFormatDateTime.format((Date)value));
				}
				else if (type == ExpandoColumnConstants.DATE_ARRAY) {
					if (!Arrays.deepEquals((Date[])value, (Date[])defaultValue)) {
						Date[] dates = (Date[])value;

						for (int i = 0; i < dates.length; i++) {
							if (i != 0) {
								sb.append(StringPool.COMMA_AND_SPACE);
							}

							sb.append(dateFormatDateTime.format(dates[i]));
						}
					}
				}
				else if (type == ExpandoColumnConstants.DOUBLE) {
					sb.append((Double)value);
				}
				else if (type == ExpandoColumnConstants.DOUBLE_ARRAY) {
					sb.append(StringUtil.merge((double[])value));
				}
				else if (type == ExpandoColumnConstants.FLOAT) {
					sb.append((Float)value);
				}
				else if (type == ExpandoColumnConstants.FLOAT_ARRAY) {
					sb.append(StringUtil.merge((float[])value));
				}
				else if (type == ExpandoColumnConstants.INTEGER) {
					sb.append((Integer)value);
				}
				else if (type == ExpandoColumnConstants.INTEGER_ARRAY) {
					sb.append(StringUtil.merge((int[])value));
				}
				else if (type == ExpandoColumnConstants.LONG) {
					sb.append((Long)value);
				}
				else if (type == ExpandoColumnConstants.LONG_ARRAY) {
					sb.append(StringUtil.merge((long[])value));
				}
				else if (type == ExpandoColumnConstants.NUMBER) {
					sb.append((Number)value);
				}
				else if (type == ExpandoColumnConstants.NUMBER_ARRAY) {
					sb.append(StringUtil.merge((Number[])value));
				}
				else if (type == ExpandoColumnConstants.SHORT) {
					sb.append((Short)value);
				}
				else if (type == ExpandoColumnConstants.SHORT_ARRAY) {
					sb.append(StringUtil.merge((short[])value));
				}
				else if (type == ExpandoColumnConstants.STRING_ARRAY) {
					sb.append(StringUtil.merge((String[])value));
				}
				else if (type == ExpandoColumnConstants.STRING_LOCALIZED) {
					Map<Locale, String> values = (Map<Locale, String>)value;

					sb.append(values.get(locale));
				}
				else {
					sb.append((String)value);
				}
				%>

				<c:if test="<%= editable || Validator.isNotNull(sb.toString()) %>">
					<aui:field-wrapper label="<%= label ? localizedName : StringPool.BLANK %>">
						<span id="<%= randomNamespace %><%= HtmlUtil.getAUICompatibleId(name) %>"><%= HtmlUtil.escape(sb.toString()) %></span>
					</aui:field-wrapper>
				</c:if>
			</c:otherwise>
		</c:choose>
	</c:if>
</c:if>
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

@generated
--%>

<%@ include file="/html/taglib/taglib-init.jsp" %>

<%
Map<String, Object> dynamicAttributes = (Map<String, Object>)request.getAttribute("aui:button-item:dynamicAttributes");
Map<String, Object> scopedAttributes = (Map<String, Object>)request.getAttribute("aui:button-item:scopedAttributes");

Map<String, Object> _options = new HashMap<String, Object>();

if ((scopedAttributes != null) && !scopedAttributes.isEmpty()) {
	_options.putAll(scopedAttributes);
}

if ((dynamicAttributes != null) && !dynamicAttributes.isEmpty()) {
	_options.putAll(dynamicAttributes);
}
%>

<%@ include file="/html/taglib/aui/init-alloy.jspf" %>

<%
boolean activeState = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:activeState")), false);
java.util.HashMap classNames = _toHashMap(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:button-item:classNames")));
java.lang.String cssClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:cssClass"));
boolean defaultState = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:defaultState")), true);
java.lang.Number depth = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:button-item:depth")), -1);
boolean destroyed = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:destroyed")), false);
boolean disabled = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:disabled")), false);
boolean focused = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:focused")), false);
java.lang.Object handler = (java.lang.Object)request.getAttribute("aui:button-item:handler");
java.lang.Object height = (java.lang.Object)request.getAttribute("aui:button-item:height");
java.lang.String hideClass = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:hideClass"), "aui-hide");
boolean hoverState = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:hoverState")), true);
java.lang.String icon = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:icon"));
java.lang.String iconNode = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:iconNode"));
java.lang.String buttonitemId = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:buttonitemId"));
java.lang.Number index = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:button-item:index")), 0);
boolean initialized = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:initialized")), false);
java.lang.String label = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:label"));
java.lang.String labelNode = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:labelNode"));
java.lang.Object buttonitemParent = (java.lang.Object)request.getAttribute("aui:button-item:buttonitemParent");
java.lang.Object render = (java.lang.Object)request.getAttribute("aui:button-item:render");
boolean rendered = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:rendered")), false);
java.lang.Object root = (java.lang.Object)request.getAttribute("aui:button-item:root");
java.lang.Number selected = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:button-item:selected")), 0);
java.util.HashMap strings = _toHashMap(GetterUtil.getObject((java.lang.Object)request.getAttribute("aui:button-item:strings")));
java.lang.Number tabIndex = GetterUtil.getNumber(String.valueOf(request.getAttribute("aui:button-item:tabIndex")), 0);
java.lang.String title = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:title"));
java.lang.String type = GetterUtil.getString((java.lang.String)request.getAttribute("aui:button-item:type"), "button");
boolean useARIA = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:useARIA")), true);
boolean visible = GetterUtil.getBoolean(String.valueOf(request.getAttribute("aui:button-item:visible")), true);
java.lang.Object width = (java.lang.Object)request.getAttribute("aui:button-item:width");
java.lang.Object afterActiveStateChange = (java.lang.Object)request.getAttribute("aui:button-item:afterActiveStateChange");
java.lang.Object afterBoundingBoxChange = (java.lang.Object)request.getAttribute("aui:button-item:afterBoundingBoxChange");
java.lang.Object afterClassNamesChange = (java.lang.Object)request.getAttribute("aui:button-item:afterClassNamesChange");
java.lang.Object afterContentBoxChange = (java.lang.Object)request.getAttribute("aui:button-item:afterContentBoxChange");
java.lang.Object afterCssClassChange = (java.lang.Object)request.getAttribute("aui:button-item:afterCssClassChange");
java.lang.Object afterDefaultStateChange = (java.lang.Object)request.getAttribute("aui:button-item:afterDefaultStateChange");
java.lang.Object afterDepthChange = (java.lang.Object)request.getAttribute("aui:button-item:afterDepthChange");
java.lang.Object afterDestroy = (java.lang.Object)request.getAttribute("aui:button-item:afterDestroy");
java.lang.Object afterDestroyedChange = (java.lang.Object)request.getAttribute("aui:button-item:afterDestroyedChange");
java.lang.Object afterDisabledChange = (java.lang.Object)request.getAttribute("aui:button-item:afterDisabledChange");
java.lang.Object afterFocusedChange = (java.lang.Object)request.getAttribute("aui:button-item:afterFocusedChange");
java.lang.Object afterHandlerChange = (java.lang.Object)request.getAttribute("aui:button-item:afterHandlerChange");
java.lang.Object afterHeightChange = (java.lang.Object)request.getAttribute("aui:button-item:afterHeightChange");
java.lang.Object afterHideClassChange = (java.lang.Object)request.getAttribute("aui:button-item:afterHideClassChange");
java.lang.Object afterHoverStateChange = (java.lang.Object)request.getAttribute("aui:button-item:afterHoverStateChange");
java.lang.Object afterIconChange = (java.lang.Object)request.getAttribute("aui:button-item:afterIconChange");
java.lang.Object afterIconNodeChange = (java.lang.Object)request.getAttribute("aui:button-item:afterIconNodeChange");
java.lang.Object afterIdChange = (java.lang.Object)request.getAttribute("aui:button-item:afterIdChange");
java.lang.Object afterIndexChange = (java.lang.Object)request.getAttribute("aui:button-item:afterIndexChange");
java.lang.Object afterInit = (java.lang.Object)request.getAttribute("aui:button-item:afterInit");
java.lang.Object afterInitializedChange = (java.lang.Object)request.getAttribute("aui:button-item:afterInitializedChange");
java.lang.Object afterLabelChange = (java.lang.Object)request.getAttribute("aui:button-item:afterLabelChange");
java.lang.Object afterLabelNodeChange = (java.lang.Object)request.getAttribute("aui:button-item:afterLabelNodeChange");
java.lang.Object afterParentChange = (java.lang.Object)request.getAttribute("aui:button-item:afterParentChange");
java.lang.Object afterRenderChange = (java.lang.Object)request.getAttribute("aui:button-item:afterRenderChange");
java.lang.Object afterRenderedChange = (java.lang.Object)request.getAttribute("aui:button-item:afterRenderedChange");
java.lang.Object afterRootChange = (java.lang.Object)request.getAttribute("aui:button-item:afterRootChange");
java.lang.Object afterSelectedChange = (java.lang.Object)request.getAttribute("aui:button-item:afterSelectedChange");
java.lang.Object afterSrcNodeChange = (java.lang.Object)request.getAttribute("aui:button-item:afterSrcNodeChange");
java.lang.Object afterStringsChange = (java.lang.Object)request.getAttribute("aui:button-item:afterStringsChange");
java.lang.Object afterTabIndexChange = (java.lang.Object)request.getAttribute("aui:button-item:afterTabIndexChange");
java.lang.Object afterTitleChange = (java.lang.Object)request.getAttribute("aui:button-item:afterTitleChange");
java.lang.Object afterTypeChange = (java.lang.Object)request.getAttribute("aui:button-item:afterTypeChange");
java.lang.Object afterUseARIAChange = (java.lang.Object)request.getAttribute("aui:button-item:afterUseARIAChange");
java.lang.Object afterVisibleChange = (java.lang.Object)request.getAttribute("aui:button-item:afterVisibleChange");
java.lang.Object afterContentUpdate = (java.lang.Object)request.getAttribute("aui:button-item:afterContentUpdate");
java.lang.Object afterRender = (java.lang.Object)request.getAttribute("aui:button-item:afterRender");
java.lang.Object afterWidthChange = (java.lang.Object)request.getAttribute("aui:button-item:afterWidthChange");
java.lang.Object onActiveStateChange = (java.lang.Object)request.getAttribute("aui:button-item:onActiveStateChange");
java.lang.Object onBoundingBoxChange = (java.lang.Object)request.getAttribute("aui:button-item:onBoundingBoxChange");
java.lang.Object onClassNamesChange = (java.lang.Object)request.getAttribute("aui:button-item:onClassNamesChange");
java.lang.Object onContentBoxChange = (java.lang.Object)request.getAttribute("aui:button-item:onContentBoxChange");
java.lang.Object onCssClassChange = (java.lang.Object)request.getAttribute("aui:button-item:onCssClassChange");
java.lang.Object onDefaultStateChange = (java.lang.Object)request.getAttribute("aui:button-item:onDefaultStateChange");
java.lang.Object onDepthChange = (java.lang.Object)request.getAttribute("aui:button-item:onDepthChange");
java.lang.Object onDestroy = (java.lang.Object)request.getAttribute("aui:button-item:onDestroy");
java.lang.Object onDestroyedChange = (java.lang.Object)request.getAttribute("aui:button-item:onDestroyedChange");
java.lang.Object onDisabledChange = (java.lang.Object)request.getAttribute("aui:button-item:onDisabledChange");
java.lang.Object onFocusedChange = (java.lang.Object)request.getAttribute("aui:button-item:onFocusedChange");
java.lang.Object onHandlerChange = (java.lang.Object)request.getAttribute("aui:button-item:onHandlerChange");
java.lang.Object onHeightChange = (java.lang.Object)request.getAttribute("aui:button-item:onHeightChange");
java.lang.Object onHideClassChange = (java.lang.Object)request.getAttribute("aui:button-item:onHideClassChange");
java.lang.Object onHoverStateChange = (java.lang.Object)request.getAttribute("aui:button-item:onHoverStateChange");
java.lang.Object onIconChange = (java.lang.Object)request.getAttribute("aui:button-item:onIconChange");
java.lang.Object onIconNodeChange = (java.lang.Object)request.getAttribute("aui:button-item:onIconNodeChange");
java.lang.Object onIdChange = (java.lang.Object)request.getAttribute("aui:button-item:onIdChange");
java.lang.Object onIndexChange = (java.lang.Object)request.getAttribute("aui:button-item:onIndexChange");
java.lang.Object onInit = (java.lang.Object)request.getAttribute("aui:button-item:onInit");
java.lang.Object onInitializedChange = (java.lang.Object)request.getAttribute("aui:button-item:onInitializedChange");
java.lang.Object onLabelChange = (java.lang.Object)request.getAttribute("aui:button-item:onLabelChange");
java.lang.Object onLabelNodeChange = (java.lang.Object)request.getAttribute("aui:button-item:onLabelNodeChange");
java.lang.Object onParentChange = (java.lang.Object)request.getAttribute("aui:button-item:onParentChange");
java.lang.Object onRenderChange = (java.lang.Object)request.getAttribute("aui:button-item:onRenderChange");
java.lang.Object onRenderedChange = (java.lang.Object)request.getAttribute("aui:button-item:onRenderedChange");
java.lang.Object onRootChange = (java.lang.Object)request.getAttribute("aui:button-item:onRootChange");
java.lang.Object onSelectedChange = (java.lang.Object)request.getAttribute("aui:button-item:onSelectedChange");
java.lang.Object onSrcNodeChange = (java.lang.Object)request.getAttribute("aui:button-item:onSrcNodeChange");
java.lang.Object onStringsChange = (java.lang.Object)request.getAttribute("aui:button-item:onStringsChange");
java.lang.Object onTabIndexChange = (java.lang.Object)request.getAttribute("aui:button-item:onTabIndexChange");
java.lang.Object onTitleChange = (java.lang.Object)request.getAttribute("aui:button-item:onTitleChange");
java.lang.Object onTypeChange = (java.lang.Object)request.getAttribute("aui:button-item:onTypeChange");
java.lang.Object onUseARIAChange = (java.lang.Object)request.getAttribute("aui:button-item:onUseARIAChange");
java.lang.Object onVisibleChange = (java.lang.Object)request.getAttribute("aui:button-item:onVisibleChange");
java.lang.Object onContentUpdate = (java.lang.Object)request.getAttribute("aui:button-item:onContentUpdate");
java.lang.Object onRender = (java.lang.Object)request.getAttribute("aui:button-item:onRender");
java.lang.Object onWidthChange = (java.lang.Object)request.getAttribute("aui:button-item:onWidthChange");

_updateOptions(_options, "activeState", activeState);
_updateOptions(_options, "boundingBox", boundingBox);
_updateOptions(_options, "classNames", classNames);
_updateOptions(_options, "contentBox", contentBox);
_updateOptions(_options, "cssClass", cssClass);
_updateOptions(_options, "defaultState", defaultState);
_updateOptions(_options, "depth", depth);
_updateOptions(_options, "destroyed", destroyed);
_updateOptions(_options, "disabled", disabled);
_updateOptions(_options, "focused", focused);
_updateOptions(_options, "handler", handler);
_updateOptions(_options, "height", height);
_updateOptions(_options, "hideClass", hideClass);
_updateOptions(_options, "hoverState", hoverState);
_updateOptions(_options, "icon", icon);
_updateOptions(_options, "iconNode", iconNode);
_updateOptions(_options, "buttonitemId", buttonitemId);
_updateOptions(_options, "index", index);
_updateOptions(_options, "initialized", initialized);
_updateOptions(_options, "label", label);
_updateOptions(_options, "labelNode", labelNode);
_updateOptions(_options, "buttonitemParent", buttonitemParent);
_updateOptions(_options, "render", render);
_updateOptions(_options, "rendered", rendered);
_updateOptions(_options, "root", root);
_updateOptions(_options, "selected", selected);
_updateOptions(_options, "srcNode", srcNode);
_updateOptions(_options, "strings", strings);
_updateOptions(_options, "tabIndex", tabIndex);
_updateOptions(_options, "title", title);
_updateOptions(_options, "type", type);
_updateOptions(_options, "useARIA", useARIA);
_updateOptions(_options, "visible", visible);
_updateOptions(_options, "width", width);
_updateOptions(_options, "afterActiveStateChange", afterActiveStateChange);
_updateOptions(_options, "afterBoundingBoxChange", afterBoundingBoxChange);
_updateOptions(_options, "afterClassNamesChange", afterClassNamesChange);
_updateOptions(_options, "afterContentBoxChange", afterContentBoxChange);
_updateOptions(_options, "afterCssClassChange", afterCssClassChange);
_updateOptions(_options, "afterDefaultStateChange", afterDefaultStateChange);
_updateOptions(_options, "afterDepthChange", afterDepthChange);
_updateOptions(_options, "afterDestroy", afterDestroy);
_updateOptions(_options, "afterDestroyedChange", afterDestroyedChange);
_updateOptions(_options, "afterDisabledChange", afterDisabledChange);
_updateOptions(_options, "afterFocusedChange", afterFocusedChange);
_updateOptions(_options, "afterHandlerChange", afterHandlerChange);
_updateOptions(_options, "afterHeightChange", afterHeightChange);
_updateOptions(_options, "afterHideClassChange", afterHideClassChange);
_updateOptions(_options, "afterHoverStateChange", afterHoverStateChange);
_updateOptions(_options, "afterIconChange", afterIconChange);
_updateOptions(_options, "afterIconNodeChange", afterIconNodeChange);
_updateOptions(_options, "afterIdChange", afterIdChange);
_updateOptions(_options, "afterIndexChange", afterIndexChange);
_updateOptions(_options, "afterInit", afterInit);
_updateOptions(_options, "afterInitializedChange", afterInitializedChange);
_updateOptions(_options, "afterLabelChange", afterLabelChange);
_updateOptions(_options, "afterLabelNodeChange", afterLabelNodeChange);
_updateOptions(_options, "afterParentChange", afterParentChange);
_updateOptions(_options, "afterRenderChange", afterRenderChange);
_updateOptions(_options, "afterRenderedChange", afterRenderedChange);
_updateOptions(_options, "afterRootChange", afterRootChange);
_updateOptions(_options, "afterSelectedChange", afterSelectedChange);
_updateOptions(_options, "afterSrcNodeChange", afterSrcNodeChange);
_updateOptions(_options, "afterStringsChange", afterStringsChange);
_updateOptions(_options, "afterTabIndexChange", afterTabIndexChange);
_updateOptions(_options, "afterTitleChange", afterTitleChange);
_updateOptions(_options, "afterTypeChange", afterTypeChange);
_updateOptions(_options, "afterUseARIAChange", afterUseARIAChange);
_updateOptions(_options, "afterVisibleChange", afterVisibleChange);
_updateOptions(_options, "afterContentUpdate", afterContentUpdate);
_updateOptions(_options, "afterRender", afterRender);
_updateOptions(_options, "afterWidthChange", afterWidthChange);
_updateOptions(_options, "onActiveStateChange", onActiveStateChange);
_updateOptions(_options, "onBoundingBoxChange", onBoundingBoxChange);
_updateOptions(_options, "onClassNamesChange", onClassNamesChange);
_updateOptions(_options, "onContentBoxChange", onContentBoxChange);
_updateOptions(_options, "onCssClassChange", onCssClassChange);
_updateOptions(_options, "onDefaultStateChange", onDefaultStateChange);
_updateOptions(_options, "onDepthChange", onDepthChange);
_updateOptions(_options, "onDestroy", onDestroy);
_updateOptions(_options, "onDestroyedChange", onDestroyedChange);
_updateOptions(_options, "onDisabledChange", onDisabledChange);
_updateOptions(_options, "onFocusedChange", onFocusedChange);
_updateOptions(_options, "onHandlerChange", onHandlerChange);
_updateOptions(_options, "onHeightChange", onHeightChange);
_updateOptions(_options, "onHideClassChange", onHideClassChange);
_updateOptions(_options, "onHoverStateChange", onHoverStateChange);
_updateOptions(_options, "onIconChange", onIconChange);
_updateOptions(_options, "onIconNodeChange", onIconNodeChange);
_updateOptions(_options, "onIdChange", onIdChange);
_updateOptions(_options, "onIndexChange", onIndexChange);
_updateOptions(_options, "onInit", onInit);
_updateOptions(_options, "onInitializedChange", onInitializedChange);
_updateOptions(_options, "onLabelChange", onLabelChange);
_updateOptions(_options, "onLabelNodeChange", onLabelNodeChange);
_updateOptions(_options, "onParentChange", onParentChange);
_updateOptions(_options, "onRenderChange", onRenderChange);
_updateOptions(_options, "onRenderedChange", onRenderedChange);
_updateOptions(_options, "onRootChange", onRootChange);
_updateOptions(_options, "onSelectedChange", onSelectedChange);
_updateOptions(_options, "onSrcNodeChange", onSrcNodeChange);
_updateOptions(_options, "onStringsChange", onStringsChange);
_updateOptions(_options, "onTabIndexChange", onTabIndexChange);
_updateOptions(_options, "onTitleChange", onTitleChange);
_updateOptions(_options, "onTypeChange", onTypeChange);
_updateOptions(_options, "onUseARIAChange", onUseARIAChange);
_updateOptions(_options, "onVisibleChange", onVisibleChange);
_updateOptions(_options, "onContentUpdate", onContentUpdate);
_updateOptions(_options, "onRender", onRender);
_updateOptions(_options, "onWidthChange", onWidthChange);
%>

<%@ include file="/html/taglib/aui/button_item/init-ext.jspf" %>

<%!
private static final String _NAMESPACE = "aui:button-item:";
%>
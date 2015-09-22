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
String portletId = portletDisplay.getRootPortletId();

String mainPath = themeDisplay.getPathMain();

String doAsUserId = themeDisplay.getDoAsUserId();

if (Validator.isNull(doAsUserId)) {
	doAsUserId = Encryptor.encrypt(company.getKeyObj(), String.valueOf(themeDisplay.getUserId()));
}

long doAsGroupId = themeDisplay.getDoAsGroupId();

if (doAsGroupId == 0) {
	doAsGroupId = (Long)request.getAttribute("liferay-ui:input-editor:groupId");
}

String ckEditorConfigFileName = ParamUtil.getString(request, "ckEditorConfigFileName");

if (!_ckEditorConfigFileNames.contains(ckEditorConfigFileName)) {
	ckEditorConfigFileName = "ckconfig.jsp";
}

boolean useCustomDataProcessor = false;

if (!ckEditorConfigFileName.equals("ckconfig.jsp")) {
	useCustomDataProcessor = true;
}

boolean hideImageResizing = ParamUtil.getBoolean(request, "hideImageResizing");

Map<String, String> configParamsMap = (Map<String, String>)request.getAttribute("liferay-ui:input-editor:configParams");
Map<String, String> fileBrowserParamsMap = (Map<String, String>)request.getAttribute("liferay-ui:input-editor:fileBrowserParams");

String configParams = marshallParams(configParamsMap);
String fileBrowserParams = marshallParams(fileBrowserParamsMap);

String contentsLanguageId = (String)request.getAttribute("liferay-ui:input-editor:contentsLanguageId");
String cssClass = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:cssClass"));
String cssClasses = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:cssClasses"));
String editorImpl = (String)request.getAttribute("liferay-ui:input-editor:editorImpl");
String name = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:name"));
String initMethod = (String)request.getAttribute("liferay-ui:input-editor:initMethod");
boolean inlineEdit = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-editor:inlineEdit"));
String inlineEditSaveURL = GetterUtil.getString((String)request.getAttribute("liferay-ui:input-editor:inlineEditSaveURL"));

String onBlurMethod = (String)request.getAttribute("liferay-ui:input-editor:onBlurMethod");

if (Validator.isNotNull(onBlurMethod)) {
	onBlurMethod = namespace + onBlurMethod;
}

String onChangeMethod = (String)request.getAttribute("liferay-ui:input-editor:onChangeMethod");

if (Validator.isNotNull(onChangeMethod)) {
	onChangeMethod = namespace + onChangeMethod;
}

String onFocusMethod = (String)request.getAttribute("liferay-ui:input-editor:onFocusMethod");

if (Validator.isNotNull(onFocusMethod)) {
	onFocusMethod = namespace + onFocusMethod;
}

boolean resizable = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-editor:resizable"));
boolean skipEditorLoading = GetterUtil.getBoolean((String)request.getAttribute("liferay-ui:input-editor:skipEditorLoading"));
String toolbarSet = (String)request.getAttribute("liferay-ui:input-editor:toolbarSet");

if (!inlineEdit) {
	name = namespace + name;
}
%>

<c:if test="<%= hideImageResizing %>">
	<liferay-util:html-top outputKey="js_editor_ckeditor_hide_image_resizing">
		<style type="text/css">
			a.cke_dialog_tab {
				display: none !important;
			}

			a.cke_dialog_tab_selected {
				display:block !important;
			}
		</style>
	</liferay-util:html-top>
</c:if>

<c:if test="<%= !skipEditorLoading %>">
	<liferay-util:html-top outputKey="js_editor_ckeditor_skip_editor_loading">
		<style type="text/css">
			table.cke_dialog {
				position: absolute !important;
			}
		</style>

		<%
		long javaScriptLastModified = ServletContextUtil.getLastModified(application, "/html/js/", true);
		%>

		<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/ckeditor/ckeditor.js", javaScriptLastModified)) %>" type="text/javascript"></script>

		<c:if test="<%= inlineEdit && Validator.isNotNull(inlineEditSaveURL) %>">
			<script src="<%= HtmlUtil.escape(PortalUtil.getStaticResourceURL(request, themeDisplay.getCDNHost() + themeDisplay.getPathJavaScript() + "/editor/ckeditor/main.js", javaScriptLastModified)) %>" type="text/javascript"></script>
		</c:if>

		<script type="text/javascript">
			Liferay.namespace('EDITORS')['<%= editorImpl %>'] = true;
		</script>
	</liferay-util:html-top>
</c:if>

<aui:script>
	window['<%= name %>'] = {
		destroy: function() {
			CKEDITOR.instances['<%= name %>'].destroy();

			window['<%= name %>'] = null;
		},

		focus: function() {
			CKEDITOR.instances['<%= name %>'].focus();
		},

		getCkData: function() {
			var data;

			if (!window['<%= name %>'].instanceReady && window['<%= HtmlUtil.escapeJS(namespace + initMethod) %>']) {
				data = window['<%= HtmlUtil.escapeJS(namespace + initMethod) %>']();
			}
			else {
				data = CKEDITOR.instances['<%= name %>'].getData();

				if (CKEDITOR.env.gecko && (CKEDITOR.tools.trim(data) == '<br />')) {
					data = '';
				}
			}

			return data;
		},

		getHTML: function() {
			return window['<%= name %>'].getCkData();
		},

		getText: function() {
			return window['<%= name %>'].getCkData();
		},

		instanceReady: false,

		<c:if test="<%= Validator.isNotNull(onBlurMethod) %>">
			onBlurCallback: function() {
				window['<%= HtmlUtil.escapeJS(onBlurMethod) %>'](CKEDITOR.instances['<%= name %>']);
			},
		</c:if>

		<c:if test="<%= Validator.isNotNull(onChangeMethod) %>">
			onChangeCallback: function() {
				var ckEditor = CKEDITOR.instances['<%= name %>'];
				var dirty = ckEditor.checkDirty();

				if (dirty) {
					window['<%= HtmlUtil.escapeJS(onChangeMethod) %>'](window['<%= name %>'].getText());

					ckEditor.resetDirty();
				}
			},
		</c:if>

		<c:if test="<%= Validator.isNotNull(onFocusMethod) %>">
			onFocusCallback: function() {
				window['<%= HtmlUtil.escapeJS(onFocusMethod) %>'](CKEDITOR.instances['<%= name %>']);
			},
		</c:if>

		setHTML: function(value) {
			CKEDITOR.instances['<%= name %>'].setData(value);

			window['<%= name %>']._setStyles();
		}
	};
</aui:script>

<%
String textareaName = name;

String modules = "aui-node-base";

if (inlineEdit && Validator.isNotNull(inlineEditSaveURL)) {
	textareaName = name + "_original";

	modules += ",inline-editor-ckeditor";
}
%>

<div class="<%= cssClass %>">
	<textarea id="<%= textareaName %>" name="<%= textareaName %>" style="display: none;"></textarea>
</div>

<script type="text/javascript">
	CKEDITOR.disableAutoInline = true;

	CKEDITOR.env.isCompatible = true;
</script>

<aui:script use="<%= modules %>">
	window['<%= name %>']._setStyles = function() {
		var iframe = A.one('#cke_<%= name %> iframe');

		if (iframe) {
			var iframeWin = iframe.getDOM().contentWindow;

			if (iframeWin) {
				var iframeDoc = iframeWin.document.documentElement;

				A.one(iframeDoc).addClass('aui');
			}
		}
	};

	<c:if test="<%= inlineEdit && Validator.isNotNull(inlineEditSaveURL) %>">
		var inlineEditor;

		Liferay.on(
			'toggleControls',
			function(event) {
				if (event.src === 'ui') {
					var ckEditor = CKEDITOR.instances['<%= name %>'];

					if (event.enabled && !ckEditor) {
						createEditor();
					}
					else if (ckEditor) {
						inlineEditor.destroy();
						ckEditor.destroy();

						ckEditor = null;

						var editorNode = A.one('#<%= name %>');

						editorNode.removeAttribute('contenteditable');
						editorNode.removeClass('lfr-editable');
					}
				}
			}
		);
	</c:if>

	var createEditor = function() {
		var Util = Liferay.Util;

		var editorNode = A.one('#<%= name %>');

		editorNode.setAttribute('contenteditable', true);

		editorNode.addClass('lfr-editable');

		function getToolbarSet(toolbarSet) {
			if (Util.isPhone()) {
				toolbarSet = 'phone';
			}
			else if (Util.isTablet()) {
				toolbarSet = 'tablet';
			}

			return toolbarSet;
		}

		function initData() {
			<c:if test="<%= Validator.isNotNull(initMethod) && !(inlineEdit && Validator.isNotNull(inlineEditSaveURL)) %>">
				ckEditor.setData(
					window['<%= HtmlUtil.escapeJS(namespace + initMethod) %>'](),
					function() {
						ckEditor.resetDirty();
					}
				);
			</c:if>

			window['<%= name %>']._setStyles();

			window['<%= name %>'].instanceReady = true;
		}

		<%
		StringBundler sb = new StringBundler(8);

		sb.append(mainPath);
		sb.append("/portal/fckeditor?p_p_id=");
		sb.append(HttpUtil.encodeURL(portletId));
		sb.append("&doAsUserId=");
		sb.append(HttpUtil.encodeURL(doAsUserId));
		sb.append("&doAsGroupId=");
		sb.append(HttpUtil.encodeURL(String.valueOf(doAsGroupId)));
		sb.append(fileBrowserParams);

		String connectorURL = HttpUtil.encodeURL(sb.toString());
		%>

		<c:choose>
			<c:when test="<%= inlineEdit %>">
				CKEDITOR.inline(
			</c:when>
			<c:otherwise>
				CKEDITOR.replace(
			</c:otherwise>
		</c:choose>

			'<%= name %>',
			{
				customConfig: '<%= PortalUtil.getPathContext() %>/html/js/editor/ckeditor/<%= HtmlUtil.escapeJS(ckEditorConfigFileName) %>?p_p_id=<%= HttpUtil.encodeURL(portletId) %>&p_main_path=<%= HttpUtil.encodeURL(mainPath) %>&contentsLanguageId=<%= HttpUtil.encodeURL(Validator.isNotNull(contentsLanguageId) ? contentsLanguageId : LocaleUtil.toLanguageId(locale)) %>&cssClasses=<%= HttpUtil.encodeURL(cssClasses) %>&cssPath=<%= HttpUtil.encodeURL(themeDisplay.getPathThemeCss()) %>&doAsGroupId=<%= HttpUtil.encodeURL(String.valueOf(doAsGroupId)) %>&doAsUserId=<%= HttpUtil.encodeURL(doAsUserId) %>&imagesPath=<%= HttpUtil.encodeURL(themeDisplay.getPathThemeImages()) %>&inlineEdit=<%= inlineEdit %><%= configParams %>&languageId=<%= HttpUtil.encodeURL(LocaleUtil.toLanguageId(locale)) %>&name=<%= name %>&resizable=<%= resizable %>',
				filebrowserBrowseUrl: '<%= PortalUtil.getPathContext() %>/html/js/editor/ckeditor/editor/filemanager/browser/liferay/browser.html?Connector=<%= connectorURL %><%= fileBrowserParams %>',
				filebrowserUploadUrl: null,
				toolbar: getToolbarSet('<%= TextFormatter.format(HtmlUtil.escapeJS(toolbarSet), TextFormatter.M) %>')
			}
		);

		if (window['<%= name %>Config']) {
			window['<%= name %>Config']();
		}

		var ckEditor = CKEDITOR.instances['<%= name %>'];

		<c:if test="<%= inlineEdit && (Validator.isNotNull(inlineEditSaveURL)) %>">
			inlineEditor = new Liferay.CKEditorInline(
				{
					editor: ckEditor,
					editorName: '<%= name %>',
					namespace: '<portlet:namespace />',
					saveURL: '<%= inlineEditSaveURL %>'
				}
			);
		</c:if>

		var customDataProcessorLoaded = false;

		<c:if test="<%= useCustomDataProcessor %>">
			ckEditor.on(
				'customDataProcessorLoaded',
				function() {
					customDataProcessorLoaded = true;

					if (instanceReady) {
						initData();
					}
				}
			);
		</c:if>

		var instanceReady = false;

		ckEditor.on(
			'instanceReady',
			function() {

				<c:choose>
					<c:when test="<%= useCustomDataProcessor %>">
						instanceReady = true;

						if (customDataProcessorLoaded) {
							initData();
						}
					</c:when>
					<c:otherwise>
						initData();
					</c:otherwise>
				</c:choose>

				<c:if test="<%= Validator.isNotNull(onBlurMethod) %>">
					CKEDITOR.instances['<%= name %>'].on('blur', window['<%= name %>'].onBlurCallback);
				</c:if>

				<c:if test="<%= Validator.isNotNull(onChangeMethod) %>">
					setInterval(
						function() {
							try {
								window['<%= name %>'].onChangeCallback();
							}
							catch (e) {
							}
						},
						300
					);
				</c:if>

				<c:if test="<%= Validator.isNotNull(onFocusMethod) %>">
					CKEDITOR.instances['<%= name %>'].on('focus', window['<%= name %>'].onFocusCallback);
				</c:if>

			}
		);

		ckEditor.on('dataReady', window['<%= name %>']._setStyles);

		<%
		if (toolbarSet.equals("creole")) {
		%>

			Liferay.provide(
				window,
				'<%= name %>creoleDialogHandlers',
				function(event) {
					var A = AUI();

					var MODIFIED = 'modified';

					var SELECTOR_HBOX_FIRST = '.cke_dialog_ui_hbox_first';

					var dialog = event.data.definition.dialog;

					if (dialog.getName() == 'image') {
						var lockButton = A.one('.cke_btn_locked');

						if (lockButton) {
							var imageProperties = lockButton.ancestor(SELECTOR_HBOX_FIRST);

							if (imageProperties) {
								imageProperties.hide();
							}
						}

						var imagePreviewBox = A.one('.ImagePreviewBox');

						if (imagePreviewBox) {
							imagePreviewBox.setStyle('width', 410);
						}
					}
					else if (dialog.getName() == 'cellProperties') {
						var containerNode = A.one('#' + dialog.getElement('cellType').$.id);

						if (!containerNode.getData(MODIFIED)) {
							containerNode.one(SELECTOR_HBOX_FIRST).hide();

							containerNode.one('.cke_dialog_ui_hbox_child').hide();

							var cellTypeWrapper = containerNode.one('.cke_dialog_ui_hbox_last');

							cellTypeWrapper.replaceClass('cke_dialog_ui_hbox_last', 'cke_dialog_ui_hbox_first');

							cellTypeWrapper.setStyle('width', '100%');

							cellTypeWrapper.all('tr').each(
								function(item, index, collection) {
									if (index > 0) {
										item.hide();
									}
								}
							);

							containerNode.setData(MODIFIED, true);
						}
					}
				},
				['aui-base']
			);

			ckEditor.on('dialogShow', window['<%= name %>creoleDialogHandlers']);

		<%
		}
		%>

	};

	<%
	String toogleControlsStatus = GetterUtil.getString(SessionClicks.get(request, "liferay_toggle_controls", "visible"));
	%>

	<c:if test='<%= (inlineEdit && toogleControlsStatus.equals("visible")) || !inlineEdit %>'>;
		createEditor();
	</c:if>

</aui:script>

<%!
public String marshallParams(Map<String, String> params) {
	StringBundler sb = new StringBundler();

	if (params != null) {
		for (Map.Entry<String, String> configParam : params.entrySet()) {
			sb.append(StringPool.AMPERSAND);
			sb.append(configParam.getKey());
			sb.append(StringPool.EQUAL);
			sb.append(HttpUtil.encodeURL(configParam.getValue()));
		}
	}

	return sb.toString();
}

private static Set<String> _ckEditorConfigFileNames = SetUtil.fromArray(new String[] {"ckconfig.jsp", "ckconfig_bbcode.jsp", "ckconfig_creole.jsp"});
%>
AUI.add(
	'liferay-portlet-dynamic-data-lists',
	function(A) {
		var AArray = A.Array;

		var DateMath = A.DataType.DateMath;

		var Lang = A.Lang;

		var EMPTY_FN = A.Lang.emptyFn;

		var JSON = A.JSON;

		var STR_DASH = '-';

		var STR_EMPTY = '';

		var STR_SPACE = ' ';

		var DLFileEntryCellEditor = A.Component.create(
			{
				NAME: 'document-library-file-entry-cell-editor',

				EXTENDS: A.BaseCellEditor,

				prototype: {
					ELEMENT_TEMPLATE: '<input type="hidden" />',

					initializer: function() {
						var instance = this;

						window[Liferay.Util.getPortletNamespace('166') + 'selectDocumentLibrary'] = A.bind('_selectFileEntry', instance);
					},

					getElementsValue: function() {
						var instance = this;

						return instance.get('value');
					},

					_defInitToolbarFn: function() {
						var instance = this;

						DLFileEntryCellEditor.superclass._defInitToolbarFn.apply(instance, arguments);

						instance.toolbar.add(
							{
								on: {
									click: A.bind('_onClickChoose', instance)
								},
								label: Liferay.Language.get('choose')
							},
							1
						);
					},

					_onClickChoose: function() {
						var instance = this;

						var portletURL = Liferay.PortletURL.createURL(themeDisplay.getURLControlPanel());

						portletURL.setParameter('groupId', themeDisplay.getScopeGroupId());
						portletURL.setParameter('struts_action', '/dynamic_data_mapping/select_document_library');

						portletURL.setPortletId('166');

						portletURL.setWindowState('pop_up');

						Liferay.Util.openWindow(
							{
								id: 'selectDocumentLibrary',
								title: Liferay.Language.get('javax.portlet.title.20'),
								uri: portletURL.toString()
							}
						);
					},

					_selectFileEntry: function(url, uuid, groupId, title, version) {
						var instance = this;

						instance.selectedTitle = title;
						instance.selectedURL = url;

						instance.set(
							'value',
							JSON.stringify(
								{
									groupId: groupId,
									title: title,
									uuid: uuid,
									version: version
								}
							)
						);
					},

					_syncFileLabel: function(title, url) {
						var instance = this;

						var contentBox = instance.get('contentBox');

						var linkNode = contentBox.one('a');

						if (!linkNode) {
							linkNode = A.Node.create('<a></a>');

							contentBox.prepend(linkNode);
						}

						linkNode.setAttribute('href', url);
						linkNode.setContent(Liferay.Util.escapeHTML(title));
					},

					_uiSetValue: function(val) {
						var instance = this;

						if (val) {
							var selectedTitle = instance.selectedTitle;
							var selectedURL = instance.selectedURL;

							if (selectedTitle && selectedURL) {
								instance._syncFileLabel(selectedTitle, selectedURL);
							}
							else {
								SpreadSheet.Util.getFileEntry(
									val,
									function(fileEntry) {
										var url = SpreadSheet.Util.getFileEntryURL(fileEntry);

										instance._syncFileLabel(fileEntry.title, url);
									}
								);
							}
						}
						else {
							instance._syncFileLabel(STR_EMPTY, STR_EMPTY);

							val = STR_EMPTY;
						}

						instance.elements.val(val);
					}
				}
			}
		);

		var LinkToPageCellEditor = A.Component.create(
			{
				NAME: 'link-to-page-cell-editor',

				EXTENDS: A.DropDownCellEditor,

				prototype: {
					OPT_GROUP_TEMPLATE: '<optgroup label="{label}">{options}</optgroup>',

					renderUI: function(val) {
						var instance = this;

						var options = {};

						LinkToPageCellEditor.superclass.renderUI.apply(instance, arguments);

						A.io.request(
							themeDisplay.getPathMain() + '/layouts_admin/get_layouts',
							{
								after: {
									success: function() {
										var	response = A.JSON.parse(this.get('responseData'));

										if (response && response.layouts) {
											instance._createOptionElements(response.layouts, options, STR_EMPTY);

											instance.set('options', options);
										}
									}
								},
								data: {
									cmd: 'getAll',
									expandParentLayouts: true,
									groupId: themeDisplay.getScopeGroupId(),
									p_auth: Liferay.authToken,
									paginate: false
								}
							}
						);
					},

					_createOptions: function(val) {
						var instance = this;

						var privateOptions = [];
						var publicOptions = [];

						A.each(
							val,
							function(item, index, collection) {
								var values = {
									id: A.guid(),
									label: index,
									value: Liferay.Util.escapeHTML(JSON.stringify(item))
								};

								var optionsArray = publicOptions;

								if (item.privateLayout) {
									optionsArray = privateOptions;
								}

								optionsArray.push(
									Lang.sub(instance.OPTION_TEMPLATE, values)
								);
							}
						);

						var optGroupTemplate = instance.OPT_GROUP_TEMPLATE;

						var publicOptGroup = Lang.sub(
							optGroupTemplate,
							{
								label: Liferay.Language.get('public-pages'),
								options: publicOptions.join(STR_EMPTY)
							}
						);

						var privateOptGroup = Lang.sub(
							optGroupTemplate,
							{
								label: Liferay.Language.get('private-pages'),
								options: privateOptions.join(STR_EMPTY)
							}
						);

						var elements = instance.elements;

						elements.setContent(publicOptGroup + privateOptGroup);

						instance.options = elements.all('option');
					},

					_createOptionElements: function(layouts, options, prefix) {
						var instance = this;

						AArray.each(
							layouts,
							function(item, index, collection) {
								options[prefix + item.name] = {
									groupId: item.groupId,
									layoutId: item.layoutId,
									name: item.name,
									privateLayout: item.privateLayout
								};

								if (item.hasChildren) {
									instance._createOptionElements(
										item.children.layouts,
										options,
										prefix + STR_DASH + STR_SPACE
									);
								}
							}
						);
					},

					_uiSetValue: function(val) {
						var instance = this;

						var options = instance.options;

						if (options && options.size()) {
							options.set('selected', false);

							if (Lang.isValue(val)) {
								var selLayout = SpreadSheet.Util.parseJSON(val);

								options.each(
									function(item, index, collection) {
										var curLayout = SpreadSheet.Util.parseJSON(item.attr('value'));

										if ((curLayout.groupId === selLayout.groupId) &&
											(curLayout.layoutId === selLayout.layoutId) &&
											(curLayout.privateLayout === selLayout.privateLayout)) {

											item.set('selected', true);
										}
									}
								);
							}
						}

						return val;
					}
				}
			}
		);

		var SpreadSheet = A.Component.create(
			{
				ATTRS: {
					portletNamespace: {
						validator: Lang.isString,
						value: STR_EMPTY
					},

					recordsetId: {
						validator: Lang.isNumber,
						value: 0
					},

					structure: {
						validator: Lang.isArray,
						value: []
					}
				},

				CSS_PREFIX: 'table',

				DATATYPE_VALIDATOR: {
					'date': 'date',
					'double': 'number',
					'integer': 'digits',
					'long': 'digits'
				},

				EXTENDS: A.DataTable,

				NAME: A.DataTable.Base.NAME,

				TYPE_EDITOR: {
					'checkbox': A.CheckboxCellEditor,
					'ddm-date': A.DateCellEditor,
					'ddm-decimal': A.TextCellEditor,
					'ddm-integer': A.TextCellEditor,
					'ddm-number': A.TextCellEditor,
					'radio': A.RadioCellEditor,
					'select': A.DropDownCellEditor,
					'text': A.TextCellEditor,
					'textarea': A.TextAreaCellEditor
				},

				prototype: {
					initializer: function() {
						var instance = this;

						instance._setDataStableSort(instance.get('data'));

						instance.set('scrollable', true);

						instance.on('dataChange', instance._onDataChange);
						instance.on('model:change', instance._onRecordUpdate);
					},

					addEmptyRows: function(num) {
						var instance = this;

						var columns = instance.get('columns');
						var data = instance.get('data');

						var keys = AArray.map(
							columns,
							function(item, index, collection) {
								return item.key;
							}
						);

						data.add(SpreadSheet.buildEmptyRecords(num, keys));
					},

					updateMinDisplayRows: function(minDisplayRows, callback) {
						var instance = this;

						callback = (callback && A.bind(callback, instance)) || EMPTY_FN;

						var recordsetId = instance.get('recordsetId');

						Liferay.Service(
							'/ddlrecordset/update-min-display-rows',
							{
								recordSetId: recordsetId,
								minDisplayRows: minDisplayRows,
								serviceContext: JSON.stringify(
									{
										scopeGroupId: themeDisplay.getScopeGroupId(),
										userId: themeDisplay.getUserId()
									}
								)
							},
							callback
						);
					},

					_afterActiveCellIndexChange: function(event) {
						var instance = this;

						var activeCell = instance.get('activeCell');
						var boundingBox = instance.get('boundingBox');

						var scrollableElement = boundingBox.one('.table-x-scroller');

						var tableHighlightBorder = instance.highlight.get('activeBorderWidth')[0];

						var activeCellWidth = activeCell.outerWidth() + tableHighlightBorder;
						var scrollableWidth = scrollableElement.outerWidth();

						var activeCellOffsetLeft = activeCell.get('offsetLeft');
						var scrollLeft = scrollableElement.get('scrollLeft');

						var activeCellOffsetRight = activeCellOffsetLeft + activeCellWidth;

						var scrollTo = scrollLeft;

						if ((scrollLeft + scrollableWidth) < activeCellOffsetRight) {
							scrollTo = activeCellOffsetRight - scrollableWidth;
						}
						else if (activeCellOffsetLeft < scrollLeft) {
							scrollTo = activeCellOffsetLeft;
						}

						scrollableElement.set('scrollLeft', scrollTo);
					},

					_normalizeRecordData: function(record) {
						var instance = this;

						var structure = instance.get('structure');

						var normalized = {};

						A.each(
							structure,
							function(item, index, collection) {
								var type = item.type;
								var value = record.get(item.name);

								if (type === 'ddm-link-to-page') {
									value = SpreadSheet.Util.parseJSON(value);

									delete value.name;

									value = JSON.stringify(value);
								}
								else if ((type === 'radio') || (type === 'select')) {
									if (!Lang.isArray(value)) {
										value = AArray(value);
									}

									value = JSON.stringify(value);
								}

								normalized[item.name] = instance._normalizeValue(value);
							}
						);

						delete normalized.displayIndex;
						delete normalized.recordId;

						return normalized;
					},

					_normalizeValue: function(value) {
						var instance = this;

						return String(value);
					},

					_onDataChange: function(event) {
						var instance = this;

						instance._setDataStableSort(event.newVal);
					},

					_onEditCell: function(event) {
						var instance = this;

						SpreadSheet.superclass._onEditCell.apply(instance, arguments);

						var activeCell = instance.get('activeCell');

						var alignNode = event.alignNode || activeCell;

						var column = instance.getColumn(alignNode);
						var record = instance.getRecord(alignNode);

						var data = instance.get('data');
						var recordsetId = instance.get('recordsetId');
						var structure = instance.get('structure');

						var editor = instance.getEditor(record, column);

						if (editor) {
							editor.setAttrs(
								{
									data: data,
									record: record,
									recordsetId: recordsetId,
									structure: structure,
									zIndex: Liferay.zIndex.OVERLAY
								}
							);
						}
					},

					_onRecordUpdate: function(event) {
						var instance = this;

						if (!A.Object.owns(event.changed, 'recordId')) {
							var data = instance.get('data');
							var recordsetId = instance.get('recordsetId');

							var record = event.target;

							var recordId = record.get('recordId');

							var fieldsMap = instance._normalizeRecordData(record);

							var recordIndex = data.indexOf(record);

							if (recordId > 0) {
								SpreadSheet.updateRecord(recordId, recordIndex, fieldsMap, true);
							}
							else {
								SpreadSheet.addRecord(
									recordsetId,
									recordIndex,
									fieldsMap,
									function(json) {
										if (json.recordId > 0) {
											record.set(
												'recordId',
												json.recordId,
												{
													silent: true
												}
											);
										}
									}
								);
							}
						}
					},

					_setDataStableSort: function(data) {
						var instance = this;

						data.sort = function(options) {
							if (this.comparator) {
								options = options || {};

								var models = this._items.concat();

								A.ArraySort.stableSort(models, A.bind(this._sort, this));

								var facade = A.merge(
									options,
									{
										models: models,
										src: 'sort'
									}
								);

								if (options.silent) {
									this._defResetFn(facade);
								}
								else {
									this.fire('reset', facade);
								}
							}

							return this;
						};
					}
				},

				addRecord: function(recordsetId, displayIndex, fieldsMap, callback) {
					var instance = this;

					callback = (callback && A.bind(callback, instance)) || EMPTY_FN;

					Liferay.Service(
						'/ddlrecord/add-record',
						{
							groupId: themeDisplay.getScopeGroupId(),
							recordSetId: recordsetId,
							displayIndex: displayIndex,
							fieldsMap: JSON.stringify(fieldsMap),
							serviceContext: JSON.stringify(
								{
									scopeGroupId: themeDisplay.getScopeGroupId(),
									userId: themeDisplay.getUserId(),
									workflowAction: Liferay.Workflow.ACTION_PUBLISH
								}
							)
						},
						callback
					);
				},

				buildDataTableColumns: function(columns, structure, editable) {
					var instance = this;

					AArray.each(
						columns,
						function(item, index, collection) {
							var dataType = item.dataType;
							var name = item.name;
							var type = item.type;

							item.key = name;

							var EditorClass = instance.TYPE_EDITOR[type] || A.TextCellEditor;

							var config = {
								elementName: name,
								validator: {
									rules: {}
								}
							};

							var required = item.required;

							var structureField;

							if (required) {
								item.label += ' (' + Liferay.Language.get('required') + ')';
							}

							if (type === 'checkbox') {
								config.options = {
									'true': Liferay.Language.get('true')
								};

								config.inputFormatter = function(value) {
									return String(value.length > 0);
								};

								item.formatter = function(obj) {
									var data = obj.data;

									var value = data[name];

									if (value === 'true') {
										value = Liferay.Language.get('true');
									}
									else if (value === 'false') {
										value = Liferay.Language.get('false');
									}

									return value;
								};
							}
							else if (type === 'ddm-date') {
								config.inputFormatter = function(val) {
									return AArray.map(
										val,
										function(item, index, collection) {
											return item.getTime();
										}
									);
								};

								config.outputFormatter = function(val) {
									return AArray.map(
										val,
										function(item, index, collection) {
											var date = new Date(Lang.toInt(item));

											date = DateMath.add(date, DateMath.MINUTES, date.getTimezoneOffset());

											return date;
										}
									);
								};

								item.formatter = function(obj) {
									var data = obj.data;

									var value = data[name];

									if (value !== STR_EMPTY) {
										var date = new Date(Lang.toInt(value));

										date = DateMath.add(date, DateMath.MINUTES, date.getTimezoneOffset());

										value = A.DataType.Date.format(date);
									}

									return value;
								};
							}
							else if ((type === 'ddm-decimal') || (type === 'ddm-integer') || (type === 'ddm-number')) {
								config.outputFormatter = function(value) {
									var number = A.DataType.Number.parse(value);

									var numberValue = STR_EMPTY;

									if (Lang.isNumber(number)) {
										numberValue = number;
									}

									return numberValue;
								};

								item.formatter = function(obj) {
									var data = obj.data;

									var value = A.DataType.Number.parse(data[name]);

									if (!Lang.isNumber(value)) {
										value = STR_EMPTY;
									}

									return value;
								};
							}
							else if (type === 'ddm-documentlibrary') {
								item.formatter = function(obj) {
									var data = obj.data;

									var label = STR_EMPTY;
									var value = data[name];

									if (value !== STR_EMPTY) {
										var fileData = SpreadSheet.Util.parseJSON(value);

										if (fileData.title) {
											label = fileData.title;
										}
									}

									return label;
								};
							}
							else if (type === 'ddm-link-to-page') {
								item.formatter = function(obj) {
									var data = obj.data;

									var label = STR_EMPTY;
									var value = data[name];

									if (value !== STR_EMPTY) {
										var linkToPageData = SpreadSheet.Util.parseJSON(value);

										if (linkToPageData.name) {
											label = linkToPageData.name;
										}
									}

									return label;
								};
							}
							else if ((type === 'radio') || (type === 'select')) {
								structureField = instance.findStructureFieldByAttribute(structure, 'name', name);

								var multiple = A.DataType.Boolean.parse(structureField.multiple);
								var options = instance.getCellEditorOptions(structureField.options);

								item.formatter = function(obj) {
									var data = obj.data;

									var label = [];
									var value = data[name];

									AArray.each(
										value,
										function(item1, index1, collection1) {
											label.push(options[item1]);
										}
									);

									return label.join(', ');
								};

								config.inputFormatter = AArray;
								config.multiple = multiple;
								config.options = options;
							}

							var validatorRuleName = instance.DATATYPE_VALIDATOR[dataType];

							var validatorRules = config.validator.rules;

							validatorRules[name] = A.mix(
								{
									required: required
								},
								validatorRules[name]
							);

							if (validatorRuleName) {
								validatorRules[name][validatorRuleName] = true;
							}

							if (editable && item.editable) {
								item.editor = new EditorClass(config);
							}
						}
					);

					return columns;
				},

				buildEmptyRecords: function(num, keys) {
					var instance = this;

					var emptyRows = [];

					for (var i = 0; i < num; i++) {
						emptyRows.push(instance.getRecordModel(keys));
					}

					return emptyRows;
				},

				findStructureFieldByAttribute: function(structure, attributeName, attributeValue) {
					var found = null;

					AArray.some(
						structure,
						function(item, index, collection) {
							found = item;

							return (found[attributeName] === attributeValue);
						}
					);

					return found;
				},

				getCellEditorOptions: function(options) {
					var normalized = {};

					AArray.each(
						options,
						function(item, index, collection) {
							normalized[item.value] = item.label;
						}
					);

					return normalized;
				},

				getRecordModel: function(keys) {
					var instance = this;

					var recordModel = {};

					AArray.each(
						keys,
						function(item, index, collection) {
							recordModel[item] = STR_EMPTY;
						}
					);

					return recordModel;
				},

				updateRecord: function(recordId, displayIndex, fieldsMap, merge, callback) {
					var instance = this;

					callback = (callback && A.bind(callback, instance)) || EMPTY_FN;

					Liferay.Service(
						'/ddlrecord/update-record',
						{
							recordId: recordId,
							displayIndex: displayIndex,
							fieldsMap: JSON.stringify(fieldsMap),
							mergeFields: merge,
							serviceContext: JSON.stringify(
								{
									scopeGroupId: themeDisplay.getScopeGroupId(),
									userId: themeDisplay.getUserId(),
									workflowAction: Liferay.Workflow.ACTION_PUBLISH
								}
							)
						},
						callback
					);
				}
			}
		);

		SpreadSheet.Util = {
			getFileEntry: function(fileJSON, callback) {
				var instance = this;

				fileJSON = instance.parseJSON(fileJSON);

				Liferay.Service(
					'/dlapp/get-file-entry-by-uuid-and-group-id',
					{
						uuid: fileJSON.uuid,
						groupId: fileJSON.groupId
					},
					callback
				);
			},

			getFileEntryURL: function(fileEntry) {
				var instance = this;

				var buffer = [
					themeDisplay.getPathContext(),
					'documents',
					fileEntry.groupId,
					fileEntry.folderId,
					encodeURIComponent(fileEntry.title)
				];

				return buffer.join('/');
			},

			parseJSON: function(value) {
				var instance = this;

				var data = {};

				try {
					data = JSON.parse(value);
				}
				catch (e) {
				}

				return data;
			}
		};

		SpreadSheet.TYPE_EDITOR['ddm-documentlibrary'] = DLFileEntryCellEditor;
		SpreadSheet.TYPE_EDITOR['ddm-link-to-page'] = LinkToPageCellEditor;

		Liferay.SpreadSheet = SpreadSheet;

		var DDLUtil = {
			previewDialog: null,

			openPreviewDialog: function(content) {
				var instance = this;

				var previewDialog = instance.previewDialog;

				if (!previewDialog) {
					previewDialog = Liferay.Util.Window.getWindow(
						{
							dialog: {
								bodyContent: content
							},
							title: Liferay.Language.get('preview')
						}
					);

					instance.previewDialog = previewDialog;
				}
				else {
					previewDialog.show();

					previewDialog.set('bodyContent', content);
				}
			}
		};

		Liferay.DDLUtil = DDLUtil;
	},
	'',
	{
		requires: ['aui-arraysort', 'aui-datatable', 'datatable-sort', 'json', 'liferay-portlet-url', 'liferay-util-window']
	}
);
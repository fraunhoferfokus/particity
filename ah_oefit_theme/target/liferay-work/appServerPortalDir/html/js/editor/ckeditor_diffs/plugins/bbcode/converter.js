;(function() {
	var BBCodeUtil = Liferay.BBCodeUtil;
	var Util = Liferay.Util;

	var Parser = Liferay.BBCodeParser;

	var hasOwnProperty = Object.prototype.hasOwnProperty;

	var MAP_FONT_SIZE = {
		1: 10,
		2: 12,
		3: 16,
		4: 18,
		5: 24,
		6: 32,
		7: 48,
		defaultSize: 12
	};

	var MAP_HANDLERS = {
		b: '_handleStrong',
		code: '_handleCode',
		email: '_handleEmail',
		font: '_handleFont',
		i: '_handleEm',
		img: '_handleImage',
		list: '_handleList',
		s: '_handleStrikeThrough',
		size: '_handleSize',
		table: '_handleTable',
		td: '_handleTableCell',
		th: '_handleTableHeader',
		tr: '_handleTableRow',
		url: '_handleURL',

		color: '_handleColor',
		colour: '_handleColor',

		'*': '_handleListItem',
		li: '_handleListItem',

		q: '_handleQuote',
		quote: '_handleQuote',

		center: '_handleTextAlign',
		justify: '_handleTextAlign',
		left: '_handleTextAlign',
		right: '_handleTextAlign'
	};

	var MAP_LIST_STYLES = {
		1: 'list-style-type: decimal;',
		a: 'list-style-type: lower-alpha;'
	};

	var MAP_TOKENS_EXCLUDE_NEW_LINE = {
		'*': 3,
		li: 3,
		tr: 3,
		td: 3,
		th: 3,
		table: 2
	};

	var REGEX_COLOR = /^(:?aqua|black|blue|fuchsia|gray|green|lime|maroon|navy|olive|purple|red|silver|teal|white|yellow|#(?:[0-9a-f]{3})?[0-9a-f]{3})$/i;

	var REGEX_IMAGE_SRC = /^(?:https?:\/\/|\/)[-;\/\?:@&=\+\$,_\.!~\*'\(\)%0-9a-z]{1,512}$/i;

	var REGEX_LASTCHAR_NEWLINE = /\r?\n$/;

	var REGEX_NEW_LINE = /\r?\n/g;

	var REGEX_NUMBER = /^[\\.0-9]{1,8}$/;

	var REGEX_STRING_IS_NEW_LINE = /^\r?\n$/;

	var REGEX_TAG_NAME = /^\/?(?:b|center|code|colou?r|email|i|img|justify|left|pre|q|quote|right|\*|s|size|table|tr|th|td|li|list|font|u|url)$/i;

	var REGEX_URI = /^[-;\/\?:@&=\+\$,_\.!~\*'\(\)%0-9a-z#]{1,512}$|\${\S+}/i;

	var STR_BLANK = '';

	var STR_CODE = 'code';

	var STR_EMAIL = 'email';

	var STR_IMG = 'img';

	var STR_MAILTO = 'mailto:';

	var STR_NEW_LINE = '\n';

	var STR_TAG_ATTR_CLOSE = '">';

	var STR_TAG_ATTR_HREF_OPEN = '<a href="';

	var STR_TAG_A_CLOSE = '</a>';

	var STR_TAG_END_CLOSE = '>';

	var STR_TAG_END_OPEN = '</';

	var STR_TAG_LIST_ITEM_SHORT = '*';

	var STR_TAG_OPEN = '<';

	var STR_TAG_P_CLOSE = '</p>';

	var STR_TAG_SPAN_CLOSE = '</span>';

	var STR_TAG_SPAN_STYLE_OPEN = '<span style="';

	var STR_TAG_URL = 'url';

	var STR_TEXT_ALIGN = '<p style="text-align: ';

	var TOKEN_DATA = Parser.TOKEN_DATA;

	var TOKEN_TAG_END = Parser.TOKEN_TAG_END;

	var TOKEN_TAG_START = Parser.TOKEN_TAG_START;

	var Converter = function(config) {
		var instance = this;

		config = config || {};

		instance.init(config);

		instance._config = config;
	};

	Converter.prototype = {
		constructor: Converter,

		convert: function(data) {
			var instance = this;

			var parsedData = instance._parser.parse(data);

			instance._parsedData = parsedData;

			var length = parsedData.length;

			for (instance._tokenPointer = 0; instance._tokenPointer < length; instance._tokenPointer++) {
				var token = parsedData[instance._tokenPointer];

				var type = token.type;

				if (type == TOKEN_TAG_START) {
					instance._handleTagStart(token);
				}
				else if (type == TOKEN_TAG_END) {
					instance._handleTagEnd(token);
				}
				else if (type == TOKEN_DATA) {
					instance._handleData(token);
				}
				else {
					throw 'Internal error. Invalid token type';
				}
			}

			var result = instance._result.join(STR_BLANK);

			instance._reset();

			return result;
		},

		init: function(config) {
			var instance = this;

			instance._parser = new Parser(config.parser);

			instance._result = [];
			instance._stack = [];
		},

		_escapeHTML: Util.escapeHTML,

		_extractData: function(toTagName, consume) {
			var instance = this;

			var result = [];

			var index = instance._tokenPointer + 1;

			var token;

			do {
				token = instance._parsedData[index++];

				if (token.type == TOKEN_DATA) {
					result.push(token.value);
				}

			} while((token.type != TOKEN_TAG_END) && (token.value != toTagName));

			if (consume) {
				instance._tokenPointer = index - 1;
			}

			return result.join(STR_BLANK);
		},

		_getFontSize: function(fontSize) {
			return MAP_FONT_SIZE[fontSize] || MAP_FONT_SIZE.defaultSize;
		},

		_handleCode: function(token) {
			var instance = this;

			instance._noParse = true;

			instance._handleSimpleTag('pre');

			instance._result.push(STR_NEW_LINE);
		},

		_handleColor: function(token) {
			var instance = this;

			var colorName = token.attribute;

			if (!colorName || !REGEX_COLOR.test(colorName)) {
				colorName = 'inherit';
			}

			instance._result.push(STR_TAG_SPAN_STYLE_OPEN + 'color: ' + colorName + STR_TAG_ATTR_CLOSE);

			instance._stack.push(STR_TAG_SPAN_CLOSE);
		},

		_handleData: function(token) {
			var instance = this;

			var value = instance._escapeHTML(token.value);

			value = instance._handleNewLine(value);

			instance._result.push(value);
		},

		_handleEm: function(token) {
			var instance = this;

			instance._handleSimpleTag('em');
		},

		_handleEmail: function(token) {
			var instance = this;

			var href = STR_BLANK;

			var hrefInput = token.attribute || instance._extractData(STR_EMAIL, false);

			if (REGEX_URI.test(hrefInput)) {
				if (hrefInput.indexOf(STR_MAILTO) !== 0) {
					hrefInput = STR_MAILTO + hrefInput;
				}

				href = CKEDITOR.tools.htmlEncodeAttr(hrefInput);
			}

			instance._result.push(STR_TAG_ATTR_HREF_OPEN + href + STR_TAG_ATTR_CLOSE);

			instance._stack.push(STR_TAG_A_CLOSE);
		},

		_handleFont: function(token) {
			var instance = this;

			var fontName = token.attribute;

			fontName = CKEDITOR.tools.htmlEncodeAttr(fontName);

			instance._result.push(STR_TAG_SPAN_STYLE_OPEN + 'font-family: ' + fontName + STR_TAG_ATTR_CLOSE);

			instance._stack.push(STR_TAG_SPAN_CLOSE);
		},

		_handleImage: function(token) {
			var instance = this;

			var imageSrc = STR_BLANK;

			var imageSrcInput = instance._extractData(STR_IMG, true);

			if (REGEX_IMAGE_SRC.test(imageSrcInput)) {
				imageSrc = CKEDITOR.tools.htmlEncodeAttr(imageSrcInput);
			}

			instance._result.push('<img src="', imageSrc, STR_TAG_ATTR_CLOSE);
		},

		_handleList: function(token) {
			var instance = this;

			var tag = 'ul';
			var styleAttr;

			var listAttribute = token.attribute;

			if (listAttribute) {
				tag = 'ol';

				styleAttr = MAP_LIST_STYLES[listAttribute];
			}

			var result = STR_TAG_OPEN + tag + STR_TAG_END_CLOSE;

			if (styleAttr) {
				result = STR_TAG_OPEN + tag + ' style="' + styleAttr + STR_TAG_ATTR_CLOSE;
			}

			instance._result.push(result);

			instance._stack.push(STR_TAG_END_OPEN + tag + STR_TAG_END_CLOSE);
		},

		_handleNewLine: function(value) {
			var instance = this;

			var nextToken;

			if (!instance._noParse) {
				if (REGEX_STRING_IS_NEW_LINE.test(value)) {
					nextToken = instance._parsedData[instance._tokenPointer + 1];

					if (nextToken &&
						hasOwnProperty.call(MAP_TOKENS_EXCLUDE_NEW_LINE, nextToken.value) &&
						(nextToken.type & MAP_TOKENS_EXCLUDE_NEW_LINE[nextToken.value])) {

							value = STR_BLANK;
					}
				}
				else if(REGEX_LASTCHAR_NEWLINE.test(value)) {
					nextToken = instance._parsedData[instance._tokenPointer + 1];

					if (nextToken &&
						(nextToken.type == TOKEN_TAG_END) &&
						(nextToken.value == STR_TAG_LIST_ITEM_SHORT)) {

						value = value.substring(0, value.length - 1);
					}
				}

				if (value) {
					value = value.replace(
						REGEX_NEW_LINE,
						'<br>'
					);
				}
			}

			return value;
		},

		_handleTagStart: function(token) {
			var instance = this;

			var tagName = token.value;

			if (instance._isValidTag(tagName)) {
				var handlerName = MAP_HANDLERS[tagName] || '_handleSimpleTags';

				instance[handlerName](token);
			}
		},

		_handleTagEnd: function(token) {
			var instance = this;

			var tagName = token.value;

			if (instance._isValidTag(tagName)) {
				instance._result.push(instance._stack.pop());

				if (tagName == STR_CODE) {
					instance._noParse = false;
				}
			}
		},

		_handleTextAlign: function(token) {
			var instance = this;

			instance._result.push(STR_TEXT_ALIGN, token.value, STR_TAG_ATTR_CLOSE);

			instance._stack.push(STR_TAG_P_CLOSE);
		},

		_handleListItem: function(token) {
			var instance = this;

			instance._handleSimpleTag('li');
		},

		_handleQuote: function(token) {
			var instance = this;

			var cite = token.attribute;

			var result = '<blockquote>';

			if (cite && cite.length) {
				cite = BBCodeUtil.escape(cite);

				result = '<blockquote><cite>' + cite + '</cite>';
			}

			instance._result.push(result);

			instance._stack.push('</blockquote>');
		},

		_handleSize: function(token) {
			var instance = this;

			var size = token.attribute;

			if (!size || !REGEX_NUMBER.test(size)) {
				size = '1';
			}

			instance._result.push(STR_TAG_SPAN_STYLE_OPEN, 'font-size: ', instance._getFontSize(size), 'px', STR_TAG_ATTR_CLOSE);

			instance._stack.push(STR_TAG_SPAN_CLOSE);
		},

		_handleSimpleTag: function(tagName) {
			var instance = this;

			instance._result.push(STR_TAG_OPEN, tagName, STR_TAG_END_CLOSE);

			instance._stack.push(STR_TAG_END_OPEN + tagName + STR_TAG_END_CLOSE);
		},

		_handleSimpleTags: function(token) {
			var instance = this;

			instance._handleSimpleTag(token.value);
		},

		_handleStrikeThrough: function(token) {
			var instance = this;

			instance._handleSimpleTag('strike');
		},

		_handleStrong: function(token) {
			var instance = this;

			instance._handleSimpleTag('strong');
		},

		_handleTable: function(token) {
			var instance = this;

			instance._handleSimpleTag('table');
		},

		_handleTableCell: function(token) {
			var instance = this;

			instance._handleSimpleTag('td');
		},

		_handleTableHeader: function(token) {
			var instance = this;

			instance._handleSimpleTag('th');
		},

		_handleTableRow: function(token) {
			var instance = this;

			instance._handleSimpleTag('tr');
		},

		_handleURL: function(token) {
			var instance = this;

			var href = STR_BLANK;

			var hrefInput = token.attribute || instance._extractData(STR_TAG_URL, false);

			if (REGEX_URI.test(hrefInput)) {
				href = CKEDITOR.tools.htmlEncodeAttr(hrefInput);
			}

			instance._result.push(STR_TAG_ATTR_HREF_OPEN + href + STR_TAG_ATTR_CLOSE);

			instance._stack.push(STR_TAG_A_CLOSE);
		},

		_isValidTag: function(tagName) {
			var valid = false;

			if (tagName && tagName.length) {
				valid = REGEX_TAG_NAME.test(tagName);
			}

			return valid;
		},

		_reset: function() {
			var instance = this;

			instance._result.length = 0;
			instance._stack.length = 0;

			instance._parsedData = null;

			instance._noParse = false;
		}
	};

	CKEDITOR.BBCode2HTML = Converter;
})();
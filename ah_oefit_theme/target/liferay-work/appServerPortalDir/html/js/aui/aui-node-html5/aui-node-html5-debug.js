YUI.add('aui-node-html5', function (A, NAME) {

/**
 * Provides support for HTML shiv natively on the Alloy DOM
 * methods. The HTML5 shiv just affects IE.
 *
 * @module aui-node
 * @submodule aui-node-html5
 */

if (A.UA.ie) {
    /**
     * <p>An object that encapsulates util methods for HTML5 shiving.</p>
     * <h2>What is a "shiv"?</h1>
     * <p>To the world, a shiv is a slang term for a sharp object used as a
     * knife-like weapon. To Internet Explorer, a shiv is a script that, when
     * executed, forces the browser to recognize HTML5 elements.</p>
     *
     * @class A.HTML5
     */
    var HTML5 = A.namespace('HTML5'),
        DOM_create = A.DOM._create;

    if (!HTML5._fragHTML5Shived) {
        /**
         * A global DocumentFragment already HTML5 shived, for performance
         * reasons. (i.e., all nodes and its HTML5 children appended to this
         * fragment iherits the styles on IE).
         *
         * @property A.HTML._fragHTML5Shived
         * @type DocumentFragment (shived)
         * @protected
         */
        HTML5._fragHTML5Shived = A.html5shiv(
            A.config.doc.createDocumentFragment()
        );
    }

    A.mix(
        HTML5, {
            /**
             * Receive a <code>frag</code> and a HTML content. This method
             * shivs the HTML5 nodes appended to a Node or fragment which is not
             * on the document yet.
             *
             * @method IECreateFix
             * @param {Node | DocumentFragment} frag Fragment to be fixed.
             * @param {String} content HTML to be set (using innerHTML) on the <code>frag</code>.
             * @return {Node | DocumentFragment}
             */
            IECreateFix: function(frag, content) {
                var shivedFrag = HTML5._fragHTML5Shived;

                shivedFrag.appendChild(frag);

                frag.innerHTML = content;

                shivedFrag.removeChild(frag);

                return frag;
            },

            /**
             * AOP listener to the A.DOM._create method. This method
             * intercepts all the calls to the A.DOM._create and append the
             * generated fragment to <a
             * href="A.HTML5.html#property_A.HTML._fragHTML5Shived">A.HTML._fragHTML5Shived</a>,
             * this fixes the IE bug for painting the HTML5 nodes on the HTML
             * fragment.
             *
             * @method _doBeforeCreate
             * @param {String} html HTML content
             * @param {String} doc
             * @param {String} tag
             * @protected
             * @return {DocumentFragment}
             */
            _doBeforeCreate: function(html, doc, tag) {
                var createdFrag = DOM_create.apply(this, arguments);

                var shivedFrag = HTML5.IECreateFix(createdFrag, html);

                return new A.Do.Halt(null, shivedFrag);
            }
        }
    );

    A.Do.before(HTML5._doBeforeCreate, A.DOM, '_create', A.DOM);
}
/**
 * The Node Utility.
 *
 * @module aui-node
 * @submodule aui-node-html5-print
 */

var CONFIG = A.config,
    DOC = CONFIG.doc,
    WIN = CONFIG.win,
    UA = A.UA,
    IE = UA.ie,

    isShivDisabled = function() {
        return WIN.AUI_HTML5_IE === false;
    };

if (!IE || IE >= 9 || isShivDisabled()) {
    return;
}

var BUFFER_CSS_TEXT = [],

    CSS_PRINTFIX = 'printfix',
    CSS_PRINTFIX_PREFIX = 'printfix-',

    LOCATION = WIN.location,

    DOMAIN = LOCATION.protocol + '//' + LOCATION.host,

    HTML = DOC.documentElement,

    HTML5_ELEMENTS = A.HTML5_ELEMENTS,
    HTML5_ELEMENTS_LENGTH = HTML5_ELEMENTS.length,
    HTML5_ELEMENTS_LIST = HTML5_ELEMENTS.join('|'),

    REGEX_CLONE_NODE_CLEANUP = new RegExp('<(/?):(' + HTML5_ELEMENTS_LIST + ')', 'gi'),
    REGEX_ELEMENTS = new RegExp('(' + HTML5_ELEMENTS_LIST + ')', 'gi'),
    REGEX_ELEMENTS_FAST = new RegExp('\\b(' + HTML5_ELEMENTS_LIST + ')\\b', 'i'),

    REGEX_PRINT_MEDIA = /print|all/,

    REGEX_RULE = new RegExp('(^|[^\\n{}]*?\\s)(' + HTML5_ELEMENTS_LIST + ').*?{([^}]*)}', 'gim'),
    REGEX_TAG = new RegExp('<(\/*)(' + HTML5_ELEMENTS_LIST + ')', 'gi'),

    SELECTOR_REPLACE_RULE = '.' + CSS_PRINTFIX_PREFIX + '$1',

    STR_ALL = 'all',
    STR_BLANK = ' ',
    STR_EMPTY = '',

    STR_BRACKET_OPEN = '{',
    STR_BRACKET_CLOSE = '}',

    STR_CHECKBOX = 'checkbox',
    STR_CHECKED = 'checked',
    STR_HTTPS = 'https',
    STR_INPUT = 'INPUT',
    STR_OPTION = 'OPTION',
    STR_RADIO = 'radio',
    STR_SELECTED = 'selected',
    STR_STAR = '*',
    STR_URL = 'url(',
    STR_URL_DOMAIN = STR_URL + DOMAIN,

    TAG_REPLACE_ORIGINAL = '<$1$2',
    TAG_REPLACE_FONT = '<$1font';

var html5shiv = A.html5shiv,
    // Yes, IE does this wackiness; converting an object
    // to a string should never result in undefined, but
    // IE's styleSheet object sometimes becomes inaccessible
    // after trying to print the second time
    isStylesheetDefined = function(obj) {
        return obj && (obj + STR_EMPTY !== undefined);
    },

    toggleNode = function(node, origNode, prop) {
        var state = origNode[prop];

        if (state) {
            node.setAttribute(prop, state);
        }
        else {
            node.removeAttribute(prop);
        }
    };

html5shiv(DOC);

var PrintFix = function() {
    var afterPrint = function() {
        if (isShivDisabled()) {
            destroy();
        }
        else {
            PrintFix.onAfterPrint();
        }
    };

    var beforePrint = function() {
        if (isShivDisabled()) {
            destroy();
        }
        else {
            PrintFix.onBeforePrint();
        }
    };

    var destroy = function() {
        WIN.detachEvent('onafterprint', afterPrint);
        WIN.detachEvent('onbeforeprint', beforePrint);
    };

    var init = function() {
        WIN.attachEvent('onafterprint', afterPrint);
        WIN.attachEvent('onbeforeprint', beforePrint);
    };

    init();

    PrintFix.destroy = destroy;
    PrintFix.init = init;
};

A.mix(
    PrintFix, {
        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method onAfterPrint
         */
        onAfterPrint: function() {
            var instance = this;

            instance.restoreHTML();

            var styleSheet = instance._getStyleSheet();

            styleSheet.styleSheet.cssText = STR_EMPTY;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method onBeforePrint
         */
        onBeforePrint: function() {
            var instance = this;

            var styleSheet = instance._getStyleSheet();
            var cssRules = instance._getAllCSSText();

            styleSheet.styleSheet.cssText = instance.parseCSS(cssRules);

            instance.writeHTML();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method parseCSS
         * @param cssText
         */
        parseCSS: function(cssText) {
            var instance = this;

            var css = STR_EMPTY;
            var rules = cssText.match(REGEX_RULE);

            if (rules) {
                css = rules.join('\n').replace(REGEX_ELEMENTS, SELECTOR_REPLACE_RULE);
            }

            return css;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method restoreHTML
         */
        restoreHTML: function() {
            var instance = this;

            var bodyClone = instance._getBodyClone();
            var bodyEl = instance._getBodyEl();

            bodyClone.innerHTML = STR_EMPTY;

            HTML.removeChild(bodyClone);
            HTML.appendChild(bodyEl);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method writeHTML
         */
        writeHTML: function() {
            var instance = this;

            var i = -1;
            var j;

            var bodyEl = instance._getBodyEl();

            var html5Element;

            var cssClass;

            var nodeList;
            var nodeListLength;
            var node;
            var buffer = [];

            while (++i < HTML5_ELEMENTS_LENGTH) {
                html5Element = HTML5_ELEMENTS[i];

                nodeList = DOC.getElementsByTagName(html5Element);
                nodeListLength = nodeList.length;

                j = -1;

                while (++j < nodeListLength) {
                    node = nodeList[j];

                    cssClass = node.className;

                    if (cssClass.indexOf(CSS_PRINTFIX_PREFIX) == -1) {
                        buffer[0] = CSS_PRINTFIX_PREFIX + html5Element;
                        buffer[1] = cssClass;

                        node.className = buffer.join(STR_BLANK);
                    }
                }
            }

            var docFrag = instance._getDocFrag();
            var bodyClone = instance._getBodyClone();

            docFrag.appendChild(bodyEl);
            HTML.appendChild(bodyClone);

            bodyClone.className = bodyEl.className;
            bodyClone.id = bodyEl.id;

            var originalNodes = bodyEl.getElementsByTagName(STR_STAR);
            var length = originalNodes.length;

            // IE will throw a mixed content warning when using https
            // and calling clone node if the body contains elements with
            // an inline background-image style that is relative to the domain.
            if (UA.secure) {
                var bodyElStyle = bodyEl.style;

                var elStyle;
                var backgroundImage;

                bodyElStyle.display = 'none';

                for (i = 0; i < length; i++) {
                    elStyle = originalNodes[i].style;

                    backgroundImage = elStyle.backgroundImage;

                    if (backgroundImage &&
                        backgroundImage.indexOf(STR_URL) > -1 &&
                        backgroundImage.indexOf(STR_HTTPS) == -1) {

                        elStyle.backgroundImage = backgroundImage.replace(STR_URL, STR_URL_DOMAIN);
                    }
                }

                bodyElStyle.display = STR_EMPTY;
            }

            var bodyElClone = bodyEl.cloneNode(true);

            var newNodes = bodyElClone.getElementsByTagName(STR_STAR);

            if (length == newNodes.length) {
                while (length--) {
                    var newNode = newNodes[length];
                    var newNodeName = newNode.nodeName;

                    if (newNodeName == STR_INPUT || newNodeName == STR_OPTION) {
                        var originalNode = originalNodes[length];
                        var originalNodeName = originalNode.nodeName;

                        if (originalNodeName == newNodeName) {
                            var prop = null;

                            if (newNodeName == STR_OPTION) {
                                prop = STR_SELECTED;
                            }
                            else if (newNodeName == STR_INPUT && (newNode.type == STR_CHECKBOX || newNode.type ==
                                STR_RADIO)) {
                                prop = STR_CHECKED;
                            }

                            if (prop !== null) {
                                toggleNode(newNode, originalNode, prop);
                            }
                        }
                    }
                }
            }

            var bodyHTML = bodyElClone.innerHTML;

            bodyHTML = bodyHTML.replace(REGEX_CLONE_NODE_CLEANUP, TAG_REPLACE_ORIGINAL).replace(REGEX_TAG,
                TAG_REPLACE_FONT);

            bodyClone.innerHTML = bodyHTML;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getAllCSSText
         * @protected
         */
        _getAllCSSText: function() {
            var instance = this;

            var buffer = [];
            var styleSheets = instance._getAllStyleSheets(DOC.styleSheets, STR_ALL);
            var rule;
            var cssText;

            for (var i = 0; styleSheet = styleSheets[i]; i++) {
                var rules = styleSheet.rules;

                if (rules && rules.length) {
                    for (var j = 0, ruleLength = rules.length; j < ruleLength; j++) {
                        rule = rules[j];

                        if (!rule.href) {
                            cssText = instance._getCSSTextFromRule(rule);

                            buffer.push(cssText);
                        }
                    }
                }
            }

            return buffer.join(STR_BLANK);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getCSSTextFromRule
         * @param rule
         * @protected
         */
        _getCSSTextFromRule: function(rule) {
            var instance = this;

            var cssText = STR_EMPTY;

            var ruleStyle = rule.style;
            var ruleCSSText;
            var ruleSelectorText;

            if (ruleStyle && (ruleCSSText = ruleStyle.cssText) && (ruleSelectorText = rule.selectorText) &&
                REGEX_ELEMENTS_FAST.test(ruleSelectorText)) {
                BUFFER_CSS_TEXT.length = 0;

                BUFFER_CSS_TEXT.push(ruleSelectorText, STR_BRACKET_OPEN, ruleCSSText, STR_BRACKET_CLOSE);

                cssText = BUFFER_CSS_TEXT.join(STR_BLANK);
            }

            return cssText;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getAllStyleSheets
         * @param styleSheet
         * @param mediaType
         * @param level
         * @param buffer
         * @protected
         */
        _getAllStyleSheets: function(styleSheet, mediaType, level, buffer) {
            var instance = this;

            level = level || 1;

            buffer = buffer || [];

            var i;

            if (isStylesheetDefined(styleSheet)) {
                var imports = styleSheet.imports;

                mediaType = styleSheet.mediaType || mediaType;

                if (REGEX_PRINT_MEDIA.test(mediaType)) {
                    var length;

                    // IE can crash when trying to access imports more than 3 levels deep
                    if (level <= 3 && isStylesheetDefined(imports) && imports.length) {
                        for (i = 0, length = imports.length; i < length; i++) {
                            instance._getAllStyleSheets(imports[i], mediaType, level + 1, buffer);
                        }
                    }
                    else if (styleSheet.length) {
                        for (i = 0, length = styleSheet.length; i < length; i++) {
                            instance._getAllStyleSheets(styleSheet[i], mediaType, level, buffer);
                        }
                    }
                    else {
                        var rules = styleSheet.rules;
                        var ruleStyleSheet;

                        if (rules && rules.length) {
                            for (i = 0, length = rules.length; i < length; i++) {
                                ruleStyleSheet = rules[i].styleSheet;

                                if (ruleStyleSheet) {
                                    instance._getAllStyleSheets(ruleStyleSheet, mediaType, level, buffer);
                                }
                            }
                        }
                    }

                    if (!styleSheet.disabled && styleSheet.rules) {
                        buffer.push(styleSheet);
                    }
                }
            }

            mediaType = STR_ALL;

            return buffer;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getBodyEl
         * @protected
         */
        _getBodyEl: function() {
            var instance = this;

            var bodyEl = instance._bodyEl;

            if (!bodyEl) {
                bodyEl = DOC.body;

                instance._bodyEl = bodyEl;
            }

            return bodyEl;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getBodyClone
         * @protected
         */
        _getBodyClone: function() {
            var instance = this;

            var bodyClone = instance._bodyClone;

            if (!bodyClone) {
                bodyClone = DOC.createElement('body');

                instance._bodyClone = bodyClone;
            }

            return bodyClone;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getDocFrag
         * @protected
         */
        _getDocFrag: function() {
            var instance = this;

            var docFrag = instance._docFrag;

            if (!docFrag) {
                docFrag = DOC.createDocumentFragment();

                html5shiv(docFrag);

                instance._docFrag = docFrag;
            }

            return docFrag;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getStyleSheet
         * @protected
         */
        _getStyleSheet: function() {
            var instance = this;

            var styleSheet = instance._styleSheet;

            if (!styleSheet) {
                styleSheet = DOC.createElement('style');

                var head = DOC.documentElement.firstChild;

                head.insertBefore(styleSheet, head.firstChild);

                styleSheet.media = 'print';
                styleSheet.className = CSS_PRINTFIX;

                instance._styleSheet = styleSheet;
            }

            return styleSheet;
        }
    }
);

A.namespace('HTML5').PrintFix = PrintFix;

PrintFix();


}, '2.0.0', {"requires": ["collection", "aui-node-base"]});

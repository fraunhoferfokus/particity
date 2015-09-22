YUI.add('aui-char-counter', function (A, NAME) {

/**
 * The CharCounter Utility
 *
 * @module aui-char-counter
 */

var L = A.Lang,
    isNumber = L.isNumber,

    CHAR_COUNTER = 'char-counter',
    COUNTER = 'counter',
    INPUT = 'input',
    MAX_LENGTH = 'maxLength',
    SCROLL_LEFT = 'scrollLeft',
    SCROLL_TOP = 'scrollTop';

/**
 *
 * A base class for CharCounter, providing:
 * <ul>
 *    <li>Limit the number of characters allowed in an input box</li>
 *    <li>Display the number of characters left</li>
 * </ul>
 *
 * Check the [live demo](http://alloyui.com/examples/char-counter/).
 *
 * @class A.CharCounter
 * @extends A.Base
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var CharCounter = A.Component.create({
    /**
     * Static property provides a string to identify the class.
     *
     * @property CharCounter.NAME
     * @type String
     * @static
     */
    NAME: CHAR_COUNTER,

    /**
     * Static property used to define the default attribute
     * configuration for the CharCounter.
     *
     * @property CharCounter.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {
        /**
         * Node or Selector to display the information of the counter.
         *
         * @attribute counter
         * @default null
         * @type {Node | String}
         */
        counter: {
            setter: A.one
        },

        /**
         * Node or Selector for the input field. Required.
         *
         * @attribute input
         * @default null
         * @type {Node | String}
         */
        input: {
            setter: A.one
        },

        /**
         * Max number of characters the [input](A.CharCounter.html#attr_input)
         * can have.
         *
         * @attribute maxLength
         * @default Infinity
         * @type Number
         */
        maxLength: {
            lazyAdd: false,
            setter: function(v) {
                return this._setMaxLength(v);
            },
            validator: isNumber,
            value: Infinity
        }
    },

    /**
     * Static property used to define which component it extends.
     *
     * @property CharCounter.EXTENDS
     * @type Object
     * @static
     */
    EXTENDS: A.Base,

    prototype: {

        /**
         * Event handler for the input <a
         * href="module_aui-event.html">aui-event</a> event.
         *
         * @property handler
         * @type EventHandle
         * @protected
         */
        handler: null,

        /**
         * Construction logic executed during CharCounter instantiation. Lifecycle.
         *
         * @method initializer
         * @protected
         */
        initializer: function() {
            var instance = this;

            instance.bindUI();

            instance.checkLength();
        },

        /**
         * Bind the events on the CharCounter UI. Lifecycle.
         *
         * @method bindUI
         * @protected
         */
        bindUI: function() {
            var instance = this;
            var input = instance.get(INPUT);

            instance.publish('maxLength');

            instance.after('maxLengthChange', instance.checkLength);

            if (input) {
                // use cross browser input-handler event
                instance.handler = input.on(INPUT, A.bind(instance._onInputChange, instance));
            }
        },

        /**
         * Sync the CharCounter UI. Lifecycle.
         *
         * @method syncUI
         * @protected
         */
        syncUI: function() {
            var instance = this;
            var counter = instance.get(COUNTER);

            if (counter) {
                var value = instance.get(INPUT).val();

                var counterValue = instance.get(MAX_LENGTH) - instance._getNormalizedLength(value);

                counter.html(counterValue);
            }
        },

        /**
         * Destructor lifecycle implementation for the CharCounter class.
         * Purges events attached to the node (and all child nodes).
         *
         * @method destroy
         * @protected
         */
        destroy: function() {
            var instance = this;

            if (instance.handler) {
                instance.handler.detach();
            }
        },

        /**
         * Check the current value of the <a
         * href="CharCounter.html#config_input">input</a>, truncate the data if
         * needed, and re-sync the UI. Fired from <a
         *  href="CharCounter.html#method__onInputChange">_onInputChange</a>.
         *
         * @method checkLength
         */
        checkLength: function() {
            var instance = this;

            var input = instance.get(INPUT);

            if (input) {
                var maxLength = instance.get(MAX_LENGTH);
                var value = input.val();

                var normalizedLength = instance._getNormalizedLength(value);

                if (normalizedLength > maxLength) {
                    var scrollTop = input.get('scrollTop');
                    var scrollLeft = input.get('scrollLeft');

                    var trimLength = maxLength - (normalizedLength - value.length);

                    value = value.substring(0, trimLength);

                    input.val(value);

                    input.set(SCROLL_TOP, scrollTop);
                    input.set(SCROLL_LEFT, scrollLeft);
                }

                instance.syncUI();

                if (normalizedLength >= maxLength) {
                    instance.fire('maxLength');
                }
            }
            else {
                return false;
            }
        },

        /**
         * Normalize reported length between browsers.
         *
         * @method _getNormalizedLength
         * @param {String} value.
         * @protected
         * @return {Number}
         */
        _getNormalizedLength: function(value) {
            var newLines = value.match(/(\r\n|\n|\r)/g);

            var newLinesCorrection = 0;

            if (newLines !== null) {
                newLinesCorrection = newLines.length;
            }

            return value.length + newLinesCorrection;
        },

        /**
         * Fired on input value change.
         *
         * @method _onInputChange
         * @param {EventFacade} event
         * @protected
         */
        _onInputChange: function(event) {
            var instance = this;

            instance.checkLength();
        },

        /**
         * Setter for <a href="CharCounter.html#config_maxLength">maxLength</a>.
         *
         * @method _setMaxLength
         * @param {Number} v Value of the new <a href="CharCounter.html#config_maxLenght">maxLenght</a>.
         * @protected
         * @return {Number}
         */
        _setMaxLength: function(v) {
            var instance = this;
            var input = instance.get(INPUT);

            if (input && (v < Infinity)) {
                input.set(MAX_LENGTH, v);
            }

            return v;
        }
    }
});

A.CharCounter = CharCounter;


}, '2.0.0', {"requires": ["aui-node", "aui-event-input", "aui-component"]});

YUI.add('aui-event-input', function (A, NAME) {

/**
 * An object that encapsulates text changed events for textareas and input
 * element of type text and password. This event only occurs when the element
 * is focused.
 *
 * @module aui-event
 * @submodule aui-event-input
 */

var DOM_EVENTS = A.Node.DOM_EVENTS;

// Input event feature check should be done on textareas. WebKit before
// version 531 (3.0.182.2) did not support input events for textareas.
// See http://dev.chromium.org/developers/webkit-version-table
if (A.Features.test('event', 'input')) {
    // http://yuilibrary.com/projects/yui3/ticket/2533063
    DOM_EVENTS.input = 1;
    return;
}

DOM_EVENTS.cut = 1;
DOM_EVENTS.dragend = 1;
DOM_EVENTS.paste = 1;

var ACTIVE_ELEMENT = 'activeElement',
    OWNER_DOCUMENT = 'ownerDocument',

    _HANDLER_DATA_KEY = '~~aui|input|event~~',
    _INPUT_EVENT_TYPE = ['keydown', 'paste', 'drop', 'cut'],
    _SKIP_FOCUS_CHECK_MAP = {
        cut: 1,
        drop: 1,
        paste: 1
    };

/**
 * TODO. Wanna help? Please send a Pull Request.
 *
 * @event input
 */
A.Event.define('input', {

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method on
     * @param node
     * @param subscription
     * @param notifier
     */
    on: function(node, subscription, notifier) {
        var instance = this;

        subscription._handler = node.on(
            _INPUT_EVENT_TYPE, A.bind(instance._dispatchEvent, instance, notifier));
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method delegate
     * @param node
     * @param subscription
     * @param notifier
     * @param filter
     */
    delegate: function(node, subscription, notifier, filter) {
        var instance = this;

        subscription._handles = [];
        subscription._handler = node.delegate('focus', function(event) {
            var element = event.target,
                handler = element.getData(_HANDLER_DATA_KEY);

            if (!handler) {
                handler = element.on(
                    _INPUT_EVENT_TYPE,
                    A.bind(instance._dispatchEvent, instance, notifier));

                subscription._handles.push(handler);
                element.setData(_HANDLER_DATA_KEY, handler);
            }
        }, filter);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method detach
     * @param node
     * @param subscription
     * @param notifier
     */
    detach: function(node, subscription, notifier) {
        subscription._handler.detach();
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method detachDelegate
     * @param node
     * @param subscription
     * @param notifier
     */
    detachDelegate: function(node, subscription, notifier) {
        A.Array.each(subscription._handles, function(handle) {
            var element = A.one(handle.evt.el);
            if (element) {
                element.setData(_HANDLER_DATA_KEY, null);
            }
            handle.detach();
        });
        subscription._handler.detach();
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _dispatchEvent
     * @param notifier
     * @param event
     * @protected
     */
    _dispatchEvent: function(notifier, event) {
        var instance = this,
            input = event.target;

        if ( // Since cut, drop and paste events fires before the element is focused, skip focus checking.
            _SKIP_FOCUS_CHECK_MAP[event.type] ||
            (input.get(OWNER_DOCUMENT).get(ACTIVE_ELEMENT) === input)) {

            notifier.fire(event);
        }
    }
});


}, '2.0.0', {"requires": ["aui-event-base", "event-delegate", "event-synthetic"]});

YUI.add('aui-sortable-layout', function (A, NAME) {

/**
 * The SortableLayout Utility
 *
 * @module aui-sortable-layout
 */

var Lang = A.Lang,
    isBoolean = Lang.isBoolean,
    isFunction = Lang.isFunction,
    isObject = Lang.isObject,
    isString = Lang.isString,
    isValue = Lang.isValue,

    toInt = Lang.toInt,

    ceil = Math.ceil,

    DDM = A.DD.DDM,

    APPEND = 'append',
    CIRCLE = 'circle',
    DELEGATE_CONFIG = 'delegateConfig',
    DOWN = 'down',
    DRAG = 'drag',
    DRAG_NODE = 'dragNode',
    DRAG_NODES = 'dragNodes',
    DROP_CONTAINER = 'dropContainer',
    DROP_NODES = 'dropNodes',
    GROUPS = 'groups',
    ICON = 'icon',
    INDICATOR = 'indicator',
    L = 'l',
    LAZY_START = 'lazyStart',
    LEFT = 'left',
    MARGIN_BOTTOM = 'marginBottom',
    MARGIN_TOP = 'marginTop',
    NODE = 'node',
    OFFSET_HEIGHT = 'offsetHeight',
    OFFSET_WIDTH = 'offsetWidth',
    PLACE_AFTER = 'placeAfter',
    PLACE_BEFORE = 'placeBefore',
    PLACEHOLDER = 'placeholder',
    PREPEND = 'prepend',
    PROXY = 'proxy',
    PROXY_NODE = 'proxyNode',
    R = 'r',
    REGION = 'region',
    RIGHT = 'right',
    SORTABLE_LAYOUT = 'sortable-layout',
    SPACE = ' ',
    TARGET = 'target',
    TRIANGLE = 'triangle',
    UP = 'up',

    EV_PLACEHOLDER_ALIGN = 'placeholderAlign',
    EV_QUADRANT_ENTER = 'quadrantEnter',
    EV_QUADRANT_EXIT = 'quadrantExit',
    EV_QUADRANT_OVER = 'quadrantOver',

    // caching these values for performance
    PLACEHOLDER_MARGIN_BOTTOM = 0,
    PLACEHOLDER_MARGIN_TOP = 0,
    PLACEHOLDER_TARGET_MARGIN_BOTTOM = 0,
    PLACEHOLDER_TARGET_MARGIN_TOP = 0,

    isNodeList = function(v) {
        return (v instanceof A.NodeList);
    },

    concat = function() {
        return Array.prototype.slice.call(arguments).join(SPACE);
    },

    nodeListSetter = function(val) {
        return isNodeList(val) ? val : A.all(val);
    },

    getNumStyle = function(elem, styleName) {
        return toInt(elem.getStyle(styleName));
    },

    getCN = A.getClassName,

    CSS_DRAG_INDICATOR = getCN(SORTABLE_LAYOUT, DRAG, INDICATOR),
    CSS_DRAG_INDICATOR_ICON = getCN(SORTABLE_LAYOUT, DRAG, INDICATOR, ICON),
    CSS_DRAG_INDICATOR_ICON_LEFT = getCN(SORTABLE_LAYOUT, DRAG, INDICATOR, ICON, LEFT),
    CSS_DRAG_INDICATOR_ICON_RIGHT = getCN(SORTABLE_LAYOUT, DRAG, INDICATOR, ICON, RIGHT),
    CSS_DRAG_TARGET_INDICATOR = getCN(SORTABLE_LAYOUT, DRAG, TARGET, INDICATOR),
    CSS_ICON = getCN(ICON),
    CSS_ICON_CIRCLE_TRIANGLE_L = getCN(ICON, CIRCLE, TRIANGLE, L),
    CSS_ICON_CIRCLE_TRIANGLE_R = getCN(ICON, CIRCLE, TRIANGLE, R),

    TPL_PLACEHOLDER = '<div class="' + CSS_DRAG_INDICATOR + '">' +
        '<div class="' + concat(CSS_DRAG_INDICATOR_ICON, CSS_DRAG_INDICATOR_ICON_LEFT, CSS_ICON,
            CSS_ICON_CIRCLE_TRIANGLE_R) + '"></div>' +
        '<div class="' + concat(CSS_DRAG_INDICATOR_ICON, CSS_DRAG_INDICATOR_ICON_RIGHT, CSS_ICON,
            CSS_ICON_CIRCLE_TRIANGLE_L) + '"></div>' +
        '<div>';

/**
 * A base class for SortableLayout, providing:
 * <ul>
 *    <li>Widget Lifecycle (initializer, renderUI, bindUI, syncUI, destructor)</li>
 *    <li>DragDrop utility for drag lists, portal layouts (portlets)</li>
 * </ul>
 *
 * Check the [live demo](http://alloyui.com/examples/sortable-layout/).
 *
 * @class A.SortableLayout
 * @extends A.Base
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var SortableLayout = A.Component.create({
    /**
     * Static property provides a string to identify the class.
     *
     * @property SortableLayout.NAME
     * @type String
     * @static
     */
    NAME: SORTABLE_LAYOUT,

    /**
     * Static property used to define the default attribute
     * configuration for the SortableLayout.
     *
     * @property SortableLayout.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute delegateConfig
         * @default null
         * @type Object
         */
        delegateConfig: {
            value: null,
            setter: function(val) {
                var instance = this;

                var config = A.merge({
                        bubbleTargets: instance,
                        dragConfig: {},
                        nodes: instance.get(DRAG_NODES),
                        target: true
                    },
                    val
                );

                A.mix(config.dragConfig, {
                    groups: instance.get(GROUPS),
                    startCentered: true
                });

                return config;
            },
            validator: isObject
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute proxyNode
         */
        proxyNode: {
            setter: function(val) {
                return isString(val) ? A.Node.create(val) : val;
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute dragNodes
         * @type String
         */
        dragNodes: {
            validator: isString
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute dropContainer
         * @type Function
         */
        dropContainer: {
            value: function(dropNode) {
                return dropNode;
            },
            validator: isFunction
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute dropNodes
         */
        dropNodes: {
            setter: '_setDropNodes'
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute groups
         */
        groups: {
            value: [SORTABLE_LAYOUT]
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute lazyStart
         * @default false
         * @type Boolean
         */
        lazyStart: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute placeholder
         */
        placeholder: {
            value: TPL_PLACEHOLDER,
            setter: function(val) {
                var placeholder = isString(val) ? A.Node.create(val) : val;

                if (!placeholder.inDoc()) {
                    A.getBody().prepend(
                        placeholder.hide()
                    );
                }

                PLACEHOLDER_MARGIN_BOTTOM = getNumStyle(placeholder, MARGIN_BOTTOM);
                PLACEHOLDER_MARGIN_TOP = getNumStyle(placeholder, MARGIN_TOP);

                placeholder.addClass(CSS_DRAG_TARGET_INDICATOR);

                PLACEHOLDER_TARGET_MARGIN_BOTTOM = getNumStyle(placeholder, MARGIN_BOTTOM);
                PLACEHOLDER_TARGET_MARGIN_TOP = getNumStyle(placeholder, MARGIN_TOP);

                return placeholder;
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute proxy
         * @default null
         */
        proxy: {
            value: null,
            setter: function(val) {
                var instance = this;

                var defaults = {
                    moveOnEnd: false,
                    positionProxy: false
                };

                // if proxyNode is set remove the border from the default proxy
                if (instance.get(PROXY_NODE)) {
                    defaults.borderStyle = null;
                }

                return A.merge(defaults, val || {});
            }
        }
    },

    /**
     * Static property used to define which component it extends.
     *
     * @property SortableLayout.EXTENDS
     * @type Object
     * @static
     */
    EXTENDS: A.Base,

    prototype: {

        /**
         * Construction logic executed during SortableLayout instantiation. Lifecycle.
         *
         * @method initializer
         * @protected
         */
        initializer: function() {
            var instance = this;

            instance.bindUI();
        },

        /**
         * Bind the events on the SortableLayout UI. Lifecycle.
         *
         * @method bindUI
         * @protected
         */
        bindUI: function() {
            var instance = this;

            // publishing placeholderAlign event
            instance.publish(EV_PLACEHOLDER_ALIGN, {
                defaultFn: instance._defPlaceholderAlign,
                queuable: false,
                emitFacade: true,
                bubbles: true
            });

            instance._bindDDEvents();
            instance._bindDropZones();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method addDropNode
         * @param node
         * @param config
         */
        addDropNode: function(node, config) {
            var instance = this;

            node = A.one(node);

            if (!DDM.getDrop(node)) {
                instance.addDropTarget(
                    // Do not use DropPlugin to create the DropZones on
                    // this component, the ".drop" namespace is used to check
                    // for the DD.Delegate target nodes
                    new A.DD.Drop(
                        A.merge({
                                bubbleTargets: instance,
                                groups: instance.get(GROUPS),
                                node: node
                            },
                            config
                        )
                    )
                );
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method addDropTarget
         * @param drop
         */
        addDropTarget: function(drop) {
            var instance = this;

            drop.addToGroup(
                instance.get(GROUPS)
            );
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method alignPlaceholder
         * @param region
         * @param isTarget
         */
        alignPlaceholder: function(region, isTarget) {
            var instance = this;
            var placeholder = instance.get(PLACEHOLDER);

            if (!instance.lazyEvents) {
                placeholder.show();
            }

            // sync placeholder size
            instance._syncPlaceholderSize();

            placeholder.setXY(
                instance.getPlaceholderXY(region, isTarget)
            );
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method calculateDirections
         * @param drag
         */
        calculateDirections: function(drag) {
            var instance = this;
            var lastY = instance.lastY;
            var lastX = instance.lastX;

            var x = drag.lastXY[0];
            var y = drag.lastXY[1];

            // if the x change
            if (x != lastX) {
                // set the drag direction
                instance.XDirection = (x < lastX) ? LEFT : RIGHT;
            }

            // if the y change
            if (y != lastY) {
                // set the drag direction
                instance.YDirection = (y < lastY) ? UP : DOWN;
            }

            instance.lastX = x;
            instance.lastY = y;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method calculateQuadrant
         * @param drag
         * @param drop
         */
        calculateQuadrant: function(drag, drop) {
            var instance = this;
            var quadrant = 1;
            var region = drop.get(NODE).get(REGION);
            var mouseXY = drag.mouseXY;
            var mouseX = mouseXY[0];
            var mouseY = mouseXY[1];

            var top = region.top;
            var left = region.left;

            // (region.bottom - top) finds the height of the region
            var vCenter = top + (region.bottom - top) / 2;
            // (region.right - left) finds the width of the region
            var hCenter = left + (region.right - left) / 2;

            if (mouseY < vCenter) {
                quadrant = (mouseX > hCenter) ? 1 : 2;
            }
            else {
                quadrant = (mouseX < hCenter) ? 3 : 4;
            }

            instance.quadrant = quadrant;

            return quadrant;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getPlaceholderXY
         * @param region
         * @param isTarget
         */
        getPlaceholderXY: function(region, isTarget) {
            var instance = this;
            var placeholder = instance.get(PLACEHOLDER);
            var marginBottom = PLACEHOLDER_MARGIN_BOTTOM;
            var marginTop = PLACEHOLDER_MARGIN_TOP;

            if (isTarget) {
                // update the margin values in case of the target placeholder has a different margin
                marginBottom = PLACEHOLDER_TARGET_MARGIN_BOTTOM;
                marginTop = PLACEHOLDER_TARGET_MARGIN_TOP;
            }

            // update the className of the placeholder when interact with target (drag/drop) elements
            placeholder.toggleClass(CSS_DRAG_TARGET_INDICATOR, isTarget);

            var regionBottom = ceil(region.bottom);
            var regionLeft = ceil(region.left);
            var regionTop = ceil(region.top);

            var x = regionLeft;

            // 1 and 2 quadrants are the top quadrants, so align to the region.top when quadrant < 3
            var y = (instance.quadrant < 3) ?
                (regionTop - (placeholder.get(OFFSET_HEIGHT) + marginBottom)) : (regionBottom + marginTop);

            return [x, y];
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method removeDropTarget
         * @param drop
         */
        removeDropTarget: function(drop) {
            var instance = this;

            drop.removeFromGroup(
                instance.get(GROUPS)
            );
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _alignCondition
         * @protected
         */
        _alignCondition: function() {
            var instance = this;
            var activeDrag = DDM.activeDrag;
            var activeDrop = instance.activeDrop;

            if (activeDrag && activeDrop) {
                var dragNode = activeDrag.get(NODE);
                var dropNode = activeDrop.get(NODE);

                return !dragNode.contains(dropNode);
            }

            return true;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _bindDDEvents
         * @protected
         */
        _bindDDEvents: function() {
            var instance = this;
            var delegateConfig = instance.get(DELEGATE_CONFIG);
            var proxy = instance.get(PROXY);

            // creating DD.Delegate instance
            instance.delegate = new A.DD.Delegate(delegateConfig);

            // plugging the DDProxy
            instance.delegate.dd.plug(A.Plugin.DDProxy, proxy);

            instance.on('drag:end', A.bind(instance._onDragEnd, instance));
            instance.on('drag:enter', A.bind(instance._onDragEnter, instance));
            instance.on('drag:exit', A.bind(instance._onDragExit, instance));
            instance.on('drag:over', A.bind(instance._onDragOver, instance));
            instance.on('drag:start', A.bind(instance._onDragStart, instance));
            instance.after('drag:start', A.bind(instance._afterDragStart, instance));

            instance.on(EV_QUADRANT_ENTER, instance._syncPlaceholderUI);
            instance.on(EV_QUADRANT_EXIT, instance._syncPlaceholderUI);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _bindDropZones
         * @protected
         */
        _bindDropZones: function() {
            var instance = this;
            var dropNodes = instance.get(DROP_NODES);

            if (dropNodes) {
                dropNodes.each(function(node, i) {
                    instance.addDropNode(node);
                });
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _defPlaceholderAlign
         * @param event
         * @protected
         */
        _defPlaceholderAlign: function(event) {
            var instance = this;
            var activeDrop = instance.activeDrop;
            var placeholder = instance.get(PLACEHOLDER);

            if (activeDrop && placeholder) {
                var node = activeDrop.get('node');
                // DD.Delegate use the Drop Plugin on its "target" items. Using Drop Plugin a "node.drop" namespace is created.
                // Using the .drop namespace to detect when the node is also a "target" DD.Delegate node
                var isTarget = !! node.drop;

                instance.lastAlignDrop = activeDrop;

                instance.alignPlaceholder(
                    activeDrop.get(NODE).get(REGION),
                    isTarget
                );
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _evOutput
         * @protected
         */
        _evOutput: function() {
            var instance = this;

            return {
                drag: DDM.activeDrag,
                drop: instance.activeDrop,
                quadrant: instance.quadrant,
                XDirection: instance.XDirection,
                YDirection: instance.YDirection
            };
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _fireQuadrantEvents
         * @protected
         */
        _fireQuadrantEvents: function() {
            var instance = this;
            var evOutput = instance._evOutput();
            var lastQuadrant = instance.lastQuadrant;
            var quadrant = instance.quadrant;

            if (quadrant != lastQuadrant) {
                // only trigger exit if it has previously entered in any quadrant
                if (lastQuadrant) {
                    // merging event with the "last" information
                    instance.fire(
                        EV_QUADRANT_EXIT,
                        A.merge({
                                lastDrag: instance.lastDrag,
                                lastDrop: instance.lastDrop,
                                lastQuadrant: instance.lastQuadrant,
                                lastXDirection: instance.lastXDirection,
                                lastYDirection: instance.lastYDirection
                            },
                            evOutput
                        )
                    );
                }

                // firing EV_QUADRANT_ENTER event
                instance.fire(EV_QUADRANT_ENTER, evOutput);
            }

            // firing EV_QUADRANT_OVER, align event fires like the drag over without bubbling for performance reasons
            instance.fire(EV_QUADRANT_OVER, evOutput);

            // updating "last" information
            instance.lastDrag = DDM.activeDrag;
            instance.lastDrop = instance.activeDrop;
            instance.lastQuadrant = quadrant;
            instance.lastXDirection = instance.XDirection;
            instance.lastYDirection = instance.YDirection;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getAppendNode
         * @protected
         */
        _getAppendNode: function() {
            return DDM.activeDrag.get(NODE);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _positionNode
         * @param event
         * @protected
         */
        _positionNode: function(event) {
            var instance = this;
            var activeDrop = instance.lastAlignDrop || instance.activeDrop;

            if (activeDrop) {
                var dragNode = instance._getAppendNode();
                var dropNode = activeDrop.get(NODE);

                // detects if the activeDrop is a dd target (portlet) or a drop area only (column)
                // DD.Delegate use the Drop Plugin on its "target" items. Using Drop Plugin a "node.drop" namespace is created.
                // Using the .drop namespace to detect when the node is also a "target" DD.Delegate node
                var isTarget = isValue(dropNode.drop);
                var topQuadrants = (instance.quadrant < 3);

                if (instance._alignCondition()) {
                    if (isTarget) {
                        dropNode[topQuadrants ? PLACE_BEFORE : PLACE_AFTER](dragNode);
                    }
                    // interacting with the columns (drop areas only)
                    else {
                        // find the dropContainer of the dropNode, the default DROP_CONTAINER function returns the dropNode
                        var dropContainer = instance.get(DROP_CONTAINER).apply(instance, [dropNode]);

                        dropContainer[topQuadrants ? PREPEND : APPEND](dragNode);
                    }
                }
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _syncPlaceholderUI
         * @param event
         * @protected
         */
        _syncPlaceholderUI: function(event) {
            var instance = this;

            if (instance._alignCondition()) {
                // firing placeholderAlign event
                instance.fire(EV_PLACEHOLDER_ALIGN, {
                    drop: instance.activeDrop,
                    originalEvent: event
                });
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _syncPlaceholderSize
         * @protected
         */
        _syncPlaceholderSize: function() {
            var instance = this;
            var node = instance.activeDrop.get(NODE);

            var placeholder = instance.get(PLACEHOLDER);

            if (placeholder) {
                placeholder.set(
                    OFFSET_WIDTH,
                    node.get(OFFSET_WIDTH)
                );
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _syncProxyNodeUI
         * @param event
         * @protected
         */
        _syncProxyNodeUI: function(event) {
            var instance = this;
            var dragNode = DDM.activeDrag.get(DRAG_NODE);
            var proxyNode = instance.get(PROXY_NODE);

            if (proxyNode && !proxyNode.compareTo(dragNode)) {
                dragNode.append(proxyNode);

                instance._syncProxyNodeSize();
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _syncProxyNodeSize
         * @protected
         */
        _syncProxyNodeSize: function() {
            var instance = this;
            var node = DDM.activeDrag.get(NODE);
            var proxyNode = instance.get(PROXY_NODE);

            if (node && proxyNode) {
                proxyNode.set(
                    OFFSET_HEIGHT,
                    node.get(OFFSET_HEIGHT)
                );

                proxyNode.set(
                    OFFSET_WIDTH,
                    node.get(OFFSET_WIDTH)
                );
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterDragStart
         * @param event
         * @protected
         */
        _afterDragStart: function(event) {
            var instance = this;

            if (instance.get(PROXY)) {
                instance._syncProxyNodeUI(event);
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onDragEnd
         * @param event
         * @protected
         */
        _onDragEnd: function(event) {
            var instance = this;
            var placeholder = instance.get(PLACEHOLDER);
            var proxyNode = instance.get(PROXY_NODE);

            if (!instance.lazyEvents) {
                instance._positionNode(event);
            }

            if (proxyNode) {
                proxyNode.remove();
            }

            if (placeholder) {
                placeholder.hide();
            }

            // reset the last information
            instance.lastQuadrant = null;
            instance.lastXDirection = null;
            instance.lastYDirection = null;
        },

        /**
         * Fire after drag:start.
         *
         * @method _onDragEnter
         * @param event
         * @protected
         */
        _onDragEnter: function(event) {
            var instance = this;

            instance.activeDrop = DDM.activeDrop;

            // check if lazyEvents is true and if there is a lastActiveDrop
            // the checking for lastActiveDrop prevents fire the _syncPlaceholderUI when quadrant* events fires
            if (instance.lazyEvents && instance.lastActiveDrop) {
                instance.lazyEvents = false;

                instance._syncPlaceholderUI(event);
            }

            // lastActiveDrop is always updated by the drag exit,
            // but if there is no lastActiveDrop update it on drag enter update it
            if (!instance.lastActiveDrop) {
                instance.lastActiveDrop = DDM.activeDrop;
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onDragExit
         * @param event
         * @protected
         */
        _onDragExit: function(event) {
            var instance = this;

            instance._syncPlaceholderUI(event);

            instance.activeDrop = DDM.activeDrop;

            instance.lastActiveDrop = DDM.activeDrop;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onDragOver
         * @param event
         * @protected
         */
        _onDragOver: function(event) {
            var instance = this;
            var drag = event.drag;

            // prevent drag over bubbling, filtering the top most element
            if (instance.activeDrop == DDM.activeDrop) {
                instance.calculateDirections(drag);

                instance.calculateQuadrant(drag, instance.activeDrop);

                instance._fireQuadrantEvents();
            }
        },

        /**
         * Fire before drag:enter.
         *
         * @method _onDragStart
         * @param event
         * @protected
         */
        _onDragStart: function(event) {
            var instance = this;

            if (instance.get(LAZY_START)) {
                instance.lazyEvents = true;
            }

            instance.lastActiveDrop = null;

            instance.activeDrop = DDM.activeDrop;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _setDropNodes
         * @param val
         * @protected
         */
        _setDropNodes: function(val) {
            var instance = this;

            if (isFunction(val)) {
                val = val.call(instance);
            }

            return nodeListSetter(val);
        }
    }
});

A.SortableLayout = SortableLayout;


}, '2.0.0', {
    "requires": [
        "dd-delegate",
        "dd-drag",
        "dd-drop",
        "dd-proxy",
        "aui-node",
        "aui-component"
    ],
    "skinnable": true
});

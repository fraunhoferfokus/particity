YUI.add('aui-tree-view', function (A, NAME) {

/**
 * The TreeView Utility
 *
 * @module aui-tree
 * @submodule aui-tree-view
 */

var L = A.Lang,
    isBoolean = L.isBoolean,
    isString = L.isString,

    UA = A.UA,

    BOUNDING_BOX = 'boundingBox',
    CHILDREN = 'children',
    CONTAINER = 'container',
    CONTENT = 'content',
    CONTENT_BOX = 'contentBox',
    DOT = '.',
    FILE = 'file',
    HITAREA = 'hitarea',
    ICON = 'icon',
    INVALID = 'invalid',
    LABEL = 'label',
    LAST_SELECTED = 'lastSelected',
    LEAF = 'leaf',
    NODE = 'node',
    OWNER_TREE = 'ownerTree',
    ROOT = 'root',
    SELECT_ON_TOGGLE = 'selectOnToggle',
    SPACE = ' ',
    TREE = 'tree',
    TREE_NODE = 'tree-node',
    TREE_VIEW = 'tree-view',
    TYPE = 'type',
    VIEW = 'view',

    concat = function() {
        return Array.prototype.slice.call(arguments).join(SPACE);
    },

    isTreeNode = function(v) {
        return (v instanceof A.TreeNode);
    },

    getCN = A.getClassName,

    CSS_TREE_HITAREA = getCN(TREE, HITAREA),
    CSS_TREE_ICON = getCN(TREE, ICON),
    CSS_TREE_LABEL = getCN(TREE, LABEL),
    CSS_TREE_NODE_CONTENT = getCN(TREE, NODE, CONTENT),
    CSS_TREE_NODE_CONTENT_INVALID = getCN(TREE, NODE, CONTENT, INVALID),
    CSS_TREE_ROOT_CONTAINER = getCN(TREE, ROOT, CONTAINER),
    CSS_TREE_VIEW_CONTENT = getCN(TREE, VIEW, CONTENT);

/**
 * A base class for TreeView, providing:
 * <ul>
 *    <li>Widget Lifecycle (initializer, renderUI, bindUI, syncUI, destructor)</li>
 * </ul>
 *
 * Check the [live demo](http://alloyui.com/examples/tree/).
 *
 * @class A.TreeView
 * @extends A.TreeData
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var TreeView = A.Component.create({
    /**
     * Static property provides a string to identify the class.
     *
     * @property TreeView.NAME
     * @type String
     * @static
     */
    NAME: TREE_VIEW,

    /**
     * Static property used to define the default attribute
     * configuration for the TreeView.
     *
     * @property TreeView.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {

        /**
         * Type of the treeview (i.e. could be 'file' or 'normal').
         *
         * @attribute type
         * @default 'file'
         * @type String
         */
        type: {
            value: FILE,
            validator: isString
        },

        /**
         * Last selected TreeNode.
         *
         * @attribute lastSelected
         * @default null
         * @type TreeNode
         */
        lastSelected: {
            value: null,
            validator: isTreeNode
        },

        /**
         * Determine if its going to be lazy loaded or not.
         *
         * @attribute lazyLoad
         * @default true
         * @type Boolean
         */
        lazyLoad: {
            validator: isBoolean,
            value: true
        },

        /**
         * Determine if its going to be selected on toggle.
         *
         * @attribute selectOnToggle
         * @default false
         * @type Boolean
         */
        selectOnToggle: {
            validator: isBoolean,
            value: false
        }
    },

    AUGMENTS: [A.TreeData, A.TreeViewPaginator, A.TreeViewIO],

    prototype: {
        CONTENT_TEMPLATE: '<ul></ul>',

        /**
         * Construction logic executed during TreeView instantiation. Lifecycle.
         *
         * @method initializer
         * @protected
         */
        initializer: function() {
            var instance = this;
            var boundingBox = instance.get(BOUNDING_BOX);

            boundingBox.setData(TREE_VIEW, instance);
        },

        /**
         * Bind the events on the TreeView UI. Lifecycle.
         *
         * @method bindUI
         * @protected
         */
        bindUI: function() {
            var instance = this;

            instance.after('childrenChange', A.bind(instance._afterSetChildren, instance));

            instance._delegateDOM();
        },

        /**
         * Create the DOM structure for the TreeView. Lifecycle.
         *
         * @method renderUI
         * @protected
         */
        renderUI: function() {
            var instance = this;

            instance._renderElements();
        },

        /**
         * Fire after set children.
         *
         * @method _afterSetChildren
         * @param {EventFacade} event
         * @protected
         */
        _afterSetChildren: function(event) {
            var instance = this;

            instance._syncPaginatorUI();
        },

        /**
         * Create TreeNode from HTML markup.
         *
         * @method _createFromHTMLMarkup
         * @param {Node} container
         * @protected
         */
        _createFromHTMLMarkup: function(container) {
            var instance = this;

            container.all('> li').each(function(node) {
                // use firstChild as label
                var labelEl = node.one('> *').remove();
                var label = labelEl.outerHTML();
                var deepContainer = node.one('> ul');

                var treeNode = new A.TreeNode({
                    boundingBox: node,
                    container: deepContainer,
                    label: label,
                    leaf: !deepContainer,
                    ownerTree: instance
                });

                if (instance.get('lazyLoad')) {
                    A.setTimeout(function() {
                        treeNode.render();
                    }, 50);
                }
                else {
                    treeNode.render();
                }

                // find the parent TreeNode...
                var parentNode = node.get(PARENT_NODE).get(PARENT_NODE);
                var parentInstance = parentNode.getData(TREE_NODE);

                if (!A.instanceOf(parentInstance, A.TreeNode)) {
                    parentInstance = parentNode.getData(TREE_VIEW);
                }

                // and simulate the appendChild.
                parentInstance.appendChild(treeNode);

                if (deepContainer) {
                    // propagating markup recursion
                    instance._createFromHTMLMarkup(deepContainer);
                }
            });
        },

        /**
         * Create Node container.
         *
         * @method _createNodeContainer
         * @protected
         */
        _createNodeContainer: function() {
            var instance = this;
            var contentBox = instance.get(CONTENT_BOX);

            instance.set(CONTAINER, contentBox);

            return contentBox;
        },

        /**
         * Render elements.
         *
         * @method _renderElements
         * @protected
         */
        _renderElements: function() {
            var instance = this;
            var contentBox = instance.get(CONTENT_BOX);
            var children = instance.get(CHILDREN);
            var type = instance.get(TYPE);
            var CSS_TREE_TYPE = getCN(TREE, type);

            contentBox.addClass(CSS_TREE_VIEW_CONTENT);

            contentBox.addClass(
                concat(CSS_TREE_TYPE, CSS_TREE_ROOT_CONTAINER)
            );

            if (!children.length) {
                // if children not specified try to create from markup
                instance._createFromHTMLMarkup(contentBox);
            }
        },

        /**
         * Delegate events.
         *
         * @method _delegateDOM
         * @protected
         */
        _delegateDOM: function() {
            var instance = this;

            var boundingBox = instance.get(BOUNDING_BOX);

            // expand/collapse delegations
            boundingBox.delegate('click', A.bind(instance._onClickNodeEl, instance), DOT + CSS_TREE_NODE_CONTENT);
            boundingBox.delegate('dblclick', A.bind(instance._onClickHitArea, instance), DOT + CSS_TREE_ICON);
            boundingBox.delegate('dblclick', A.bind(instance._onClickHitArea, instance), DOT + CSS_TREE_LABEL);
            // other delegations
            boundingBox.delegate(
                'mouseenter', A.bind(instance._onMouseEnterNodeEl, instance), DOT + CSS_TREE_NODE_CONTENT);
            boundingBox.delegate(
                'mouseleave', A.bind(instance._onMouseLeaveNodeEl, instance), DOT + CSS_TREE_NODE_CONTENT);
        },

        /**
         * Fire on click the TreeView (i.e. set the select/unselect state).
         *
         * @method _onClickNodeEl
         * @param {EventFacade} event
         * @protected
         */
        _onClickNodeEl: function(event) {
            var instance = this;

            var treeNode = instance.getNodeByChild(event.currentTarget);

            if (treeNode) {
                if (event.target.test(DOT + CSS_TREE_HITAREA)) {
                    treeNode.toggle();

                    if (!instance.get(SELECT_ON_TOGGLE)) {
                        return;
                    }
                }

                if (!treeNode.isSelected()) {
                    var lastSelected = instance.get(LAST_SELECTED);

                    // select drag node
                    if (lastSelected) {
                        lastSelected.unselect();
                    }

                    treeNode.select();
                }
            }
        },

        /**
         * Fire on <code>mouseEnter</code> the TreeNode.
         *
         * @method _onMouseEnterNodeEl
         * @param {EventFacade} event
         * @protected
         */
        _onMouseEnterNodeEl: function(event) {
            var instance = this;
            var treeNode = instance.getNodeByChild(event.currentTarget);

            if (treeNode) {
                treeNode.over();
            }
        },

        /**
         * Fire on <code>mouseLeave</code> the TreeNode.
         *
         * @method _onMouseLeaveNodeEl
         * @param {EventFacade} event
         * @protected
         */
        _onMouseLeaveNodeEl: function(event) {
            var instance = this;
            var treeNode = instance.getNodeByChild(event.currentTarget);

            if (treeNode) {
                treeNode.out();
            }
        },

        /**
         * Fire on <code>click</code> the TreeNode hitarea.
         *
         * @method _onClickHitArea
         * @param {EventFacade} event
         * @protected
         */
        _onClickHitArea: function(event) {
            var instance = this;
            var treeNode = instance.getNodeByChild(event.currentTarget);

            if (treeNode) {
                treeNode.toggle();
            }
        }
    }
});

A.TreeView = TreeView;

/*
 * TreeViewDD - Drag & Drop
 */
var isNumber = L.isNumber,

    ABOVE = 'above',
    APPEND = 'append',
    BELOW = 'below',
    BLOCK = 'block',
    BODY = 'body',
    CLEARFIX = 'clearfix',
    DEFAULT = 'default',
    DISPLAY = 'display',
    DOWN = 'down',
    DRAG = 'drag',
    DRAGGABLE = 'draggable',
    DRAG_CURSOR = 'dragCursor',
    DRAG_NODE = 'dragNode',
    EXPANDED = 'expanded',
    HELPER = 'helper',
    INSERT = 'insert',
    OFFSET_HEIGHT = 'offsetHeight',
    PARENT_NODE = 'parentNode',
    SCROLL_DELAY = 'scrollDelay',
    STATE = 'state',
    TREE_DRAG_DROP = 'tree-drag-drop',
    UP = 'up',

    DDM = A.DD.DDM,

    CSS_CLEARFIX = getCN(CLEARFIX),
    CSS_ICON = getCN(ICON),
    CSS_TREE_DRAG_HELPER = getCN(TREE, DRAG, HELPER),
    CSS_TREE_DRAG_HELPER_CONTENT = getCN(TREE, DRAG, HELPER, CONTENT),
    CSS_TREE_DRAG_HELPER_LABEL = getCN(TREE, DRAG, HELPER, LABEL),
    CSS_TREE_DRAG_INSERT_ABOVE = getCN(TREE, DRAG, INSERT, ABOVE),
    CSS_TREE_DRAG_INSERT_APPEND = getCN(TREE, DRAG, INSERT, APPEND),
    CSS_TREE_DRAG_INSERT_BELOW = getCN(TREE, DRAG, INSERT, BELOW),
    CSS_TREE_DRAG_STATE_APPEND = getCN(TREE, DRAG, STATE, APPEND),
    CSS_TREE_DRAG_STATE_INSERT_ABOVE = getCN(TREE, DRAG, STATE, INSERT, ABOVE),
    CSS_TREE_DRAG_STATE_INSERT_BELOW = getCN(TREE, DRAG, STATE, INSERT, BELOW),

    HELPER_TPL = '<div class="' + CSS_TREE_DRAG_HELPER + '">' +
        '<div class="' + [CSS_TREE_DRAG_HELPER_CONTENT, CSS_CLEARFIX].join(SPACE) + '">' +
        '<span class="' + CSS_ICON + '"></span>' +
        '<span class="' + CSS_TREE_DRAG_HELPER_LABEL + '"></span>' +
        '</div>' +
        '</div>';

/**
 * A base class for TreeViewDD, providing:
 * <ul>
 *    <li>Widget Lifecycle (initializer, renderUI, bindUI, syncUI, destructor)</li>
 *    <li>DragDrop support for the TreeNodes</li>
 * </ul>
 *
 * @class A.TreeViewDD
 * @extends A.TreeView
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var TreeViewDD = A.Component.create({
    /**
     * Static property provides a string to identify the class.
     *
     * @property TreeViewDD.NAME
     * @type String
     * @static
     */
    NAME: TREE_DRAG_DROP,

    /**
     * Static property used to define the default attribute
     * configuration for the TreeViewDD.
     *
     * @property TreeViewDD.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {
        /**
         * Dragdrop helper element.
         *
         * @attribute helper
         * @default null
         * @type Node | String
         */
        helper: {
            value: null
        },

        /**
         * Delay of the scroll while dragging the TreeNodes.
         *
         * @attribute scrollDelay
         * @default 100
         * @type Number
         */
        scrollDelay: {
            value: 100,
            validator: isNumber
        }
    },

    EXTENDS: A.TreeView,

    prototype: {

        /**
         * Direction of the drag (i.e. could be 'up' or 'down').
         *
         * @property direction
         * @type String
         * @protected
         */
        direction: BELOW,

        /**
         * Drop action (i.e. could be 'append', 'below' or 'above').
         *
         * @attribute dropAction
         * @default null
         * @type String
         */
        dropAction: null,

        /**
         * Last Y.
         *
         * @attribute lastY
         * @default 0
         * @type Number
         */
        lastY: 0,

        /**
         * Node.
         *
         * @attribute node
         * @default null
         */
        node: null,

        /**
         * Reference for the current drop node.
         *
         * @attribute nodeContent
         * @default null
         * @type Node
         */
        nodeContent: null,

        /**
         * Destructor lifecycle implementation for the TreeViewDD class.
         * Purges events attached to the node (and all child nodes).
         *
         * @method destructor
         * @protected
         */
        destructor: function() {
            var instance = this;
            var helper = instance.get(HELPER);

            if (helper) {
                helper.remove(true);
            }

            if (instance.ddDelegate) {
                instance.ddDelegate.destroy();
            }
        },

        /**
         * Bind the events on the TreeViewDD UI. Lifecycle.
         *
         * @method bindUI
         * @protected
         */
        bindUI: function() {
            var instance = this;

            A.TreeViewDD.superclass.bindUI.apply(this, arguments);

            instance._bindDragDrop();
        },

        /**
         * Create the DOM structure for the TreeViewDD. Lifecycle.
         *
         * @method renderUI
         * @protected
         */
        renderUI: function() {
            var instance = this;

            A.TreeViewDD.superclass.renderUI.apply(this, arguments);

            // creating drag helper and hiding it
            var helper = A.Node.create(HELPER_TPL).hide();

            // append helper to the body
            A.one(BODY).append(helper);

            instance.set(HELPER, helper);

            // set DRAG_CURSOR to the default arrow
            DDM.set(DRAG_CURSOR, DEFAULT);
        },

        /**
         * Bind DragDrop events.
         *
         * @method _bindDragDrop
         * @protected
         */
        _bindDragDrop: function() {
            var instance = this,
                boundingBox = instance.get(BOUNDING_BOX),
                dragInitHandle = null;

            instance._createDragInitHandler = function() {
                instance.ddDelegate = new A.DD.Delegate({
                    bubbleTargets: instance,
                    container: boundingBox,
                    invalid: DOT + CSS_TREE_NODE_CONTENT_INVALID,
                    nodes: DOT + CSS_TREE_NODE_CONTENT,
                    target: true
                });

                var dd = instance.ddDelegate.dd;

                dd.plug(A.Plugin.DDProxy, {
                    moveOnEnd: false,
                    positionProxy: false,
                    borderStyle: null
                })
                    .plug(A.Plugin.DDNodeScroll, {
                        scrollDelay: instance.get(SCROLL_DELAY),
                        node: boundingBox
                    });

                dd.removeInvalid('a');

                if (dragInitHandle) {
                    dragInitHandle.detach();
                }

            };

            // Check for mobile devices and execute _createDragInitHandler before events
            if (!UA.touch) {
                // only create the drag on the init elements if the user mouseover the boundingBox for init performance reasons
                dragInitHandle = boundingBox.on(['focus', 'mousedown', 'mousemove'], instance._createDragInitHandler);
            }
            else {
                instance._createDragInitHandler();
            }

            // drag & drop listeners
            instance.on('drag:align', instance._onDragAlign);
            instance.on('drag:start', instance._onDragStart);
            instance.on('drop:exit', instance._onDropExit);
            instance.after('drop:hit', instance._afterDropHit);
            instance.on('drop:hit', instance._onDropHit);
            instance.on('drop:over', instance._onDropOver);
        },

        /**
         * Set the append CSS state on the passed <code>nodeContent</code>.
         *
         * @method _appendState
         * @param {Node} nodeContent
         * @protected
         */
        _appendState: function(nodeContent) {
            var instance = this;

            instance.dropAction = APPEND;

            instance.get(HELPER).addClass(CSS_TREE_DRAG_STATE_APPEND);

            nodeContent.addClass(CSS_TREE_DRAG_INSERT_APPEND);
        },

        /**
         * Set the going down CSS state on the passed <code>nodeContent</code>.
         *
         * @method _goingDownState
         * @param {Node} nodeContent
         * @protected
         */
        _goingDownState: function(nodeContent) {
            var instance = this;

            instance.dropAction = BELOW;

            instance.get(HELPER).addClass(CSS_TREE_DRAG_STATE_INSERT_BELOW);

            nodeContent.addClass(CSS_TREE_DRAG_INSERT_BELOW);
        },

        /**
         * Set the going up CSS state on the passed <code>nodeContent</code>.
         *
         * @method _goingUpState
         * @param {Node} nodeContent
         * @protected
         */
        _goingUpState: function(nodeContent) {
            var instance = this;

            instance.dropAction = ABOVE;

            instance.get(HELPER).addClass(CSS_TREE_DRAG_STATE_INSERT_ABOVE);

            nodeContent.addClass(CSS_TREE_DRAG_INSERT_ABOVE);
        },

        /**
         * Set the reset CSS state on the passed <code>nodeContent</code>.
         *
         * @method _resetState
         * @param {Node} nodeContent
         * @protected
         */
        _resetState: function(nodeContent) {
            var instance = this;
            var helper = instance.get(HELPER);

            helper.removeClass(CSS_TREE_DRAG_STATE_APPEND);
            helper.removeClass(CSS_TREE_DRAG_STATE_INSERT_ABOVE);
            helper.removeClass(CSS_TREE_DRAG_STATE_INSERT_BELOW);

            if (nodeContent) {
                nodeContent.removeClass(CSS_TREE_DRAG_INSERT_ABOVE);
                nodeContent.removeClass(CSS_TREE_DRAG_INSERT_APPEND);
                nodeContent.removeClass(CSS_TREE_DRAG_INSERT_BELOW);
            }
        },

        /**
         * Update the CSS node state (i.e. going down, going up, append etc).
         *
         * @method _updateNodeState
         * @param {EventFacade} event
         * @protected
         */
        _updateNodeState: function(event) {
            var instance = this;
            var drag = event.drag;
            var drop = event.drop;
            var nodeContent = drop.get(NODE);
            var dropNode = nodeContent.get(PARENT_NODE);
            var dragNode = drag.get(NODE).get(PARENT_NODE);
            var dropTreeNode = dropNode.getData(TREE_NODE);

            // reset the classNames from the last nodeContent
            instance._resetState(instance.nodeContent);

            // cannot drop the dragged element into any of its children
            // nor above an undraggable element
            // using DOM contains method for performance reason
            if (!!dropTreeNode.get(DRAGGABLE) && !dragNode.contains(dropNode)) {
                // nArea splits the height in 3 areas top/center/bottom these
                // areas are responsible for defining the state when the mouse
                // is over any of them
                var nArea = nodeContent.get(OFFSET_HEIGHT) / 3;
                var yTop = nodeContent.getY();
                var yCenter = yTop + nArea;
                var yBottom = yTop + nArea * 2;
                var mouseY = drag.mouseXY[1];

                // UP: mouse on the top area of the node
                if ((mouseY > yTop) && (mouseY < yCenter)) {
                    instance._goingUpState(nodeContent);
                }
                // DOWN: mouse on the bottom area of the node
                else if (mouseY > yBottom) {
                    instance._goingDownState(nodeContent);
                }
                // APPEND: mouse on the center area of the node
                else if ((mouseY > yCenter) && (mouseY < yBottom)) {
                    // if it's a folder set the state to append
                    if (dropTreeNode && !dropTreeNode.isLeaf()) {
                        instance._appendState(nodeContent);
                    }
                    // if it's a leaf we need to set the ABOVE or BELOW state instead of append
                    else {
                        if (instance.direction === UP) {
                            instance._goingUpState(nodeContent);
                        }
                        else {
                            instance._goingDownState(nodeContent);
                        }
                    }
                }
            }

            instance.nodeContent = nodeContent;
        },

        /**
         * Fire after the drop hit event.
         *
         * @method _afterDropHit
         * @param {EventFacade} event drop hit event facade
         * @protected
         */
        _afterDropHit: function(event) {
            var instance = this;
            var dropAction = instance.dropAction;
            var dragNode = event.drag.get(NODE).get(PARENT_NODE);
            var dropNode = event.drop.get(NODE).get(PARENT_NODE);

            var dropTreeNode = dropNode.getData(TREE_NODE);
            var dragTreeNode = dragNode.getData(TREE_NODE);

            var output = instance.getEventOutputMap(instance);

            output.tree.dropNode = dropTreeNode;
            output.tree.dragNode = dragTreeNode;

            if (dropAction === ABOVE) {
                dropTreeNode.insertBefore(dragTreeNode);

                instance.bubbleEvent('dropInsert', output);
            }
            else if (dropAction === BELOW) {
                dropTreeNode.insertAfter(dragTreeNode);

                instance.bubbleEvent('dropInsert', output);
            }
            else if (dropAction === APPEND) {
                if (dropTreeNode && !dropTreeNode.isLeaf()) {
                    if (!dropTreeNode.get(EXPANDED)) {
                        // expand node when drop a child on it
                        dropTreeNode.expand();
                    }

                    dropTreeNode.appendChild(dragTreeNode);

                    instance.bubbleEvent('dropAppend', output);
                }
            }

            instance._resetState(instance.nodeContent);

            // bubbling drop event
            instance.bubbleEvent('drop', output);

            instance.dropAction = null;
        },

        /**
         * Fire on drag align event.
         *
         * @method _onDragAlign
         * @param {EventFacade} event append event facade
         * @protected
         */
        _onDragAlign: function(event) {
            var instance = this;
            var lastY = instance.lastY;
            var y = event.target.lastXY[1];

            // if the y change
            if (y !== lastY) {
                // set the drag direction
                instance.direction = (y < lastY) ? UP : DOWN;
            }

            instance.lastY = y;
        },

        /**
         * Fire on drag start event.
         *
         * @method _onDragStart
         * @param {EventFacade} event append event facade
         * @protected
         */
        _onDragStart: function(event) {
            var instance = this;
            var drag = event.target;
            var dragNode = drag.get(NODE).get(PARENT_NODE);
            var dragTreeNode = dragNode.getData(TREE_NODE);
            var lastSelected = instance.get(LAST_SELECTED);

            // select drag node
            if (lastSelected) {
                lastSelected.unselect();
            }

            dragTreeNode.select();

            // initialize drag helper
            var helper = instance.get(HELPER);
            var helperLabel = helper.one(DOT + CSS_TREE_DRAG_HELPER_LABEL);

            // show helper, we need display block here, yui dd hide it with display none
            helper.setStyle(DISPLAY, BLOCK).show();

            // set the CSS_TREE_DRAG_HELPER_LABEL html with the label of the dragged node
            helperLabel.html(dragTreeNode.get(LABEL));

            // update the DRAG_NODE with the new helper
            drag.set(DRAG_NODE, helper);
        },

        /**
         * Fire on drop over event.
         *
         * @method _onDropOver
         * @param {EventFacade} event append event facade
         * @protected
         */
        _onDropOver: function(event) {
            var instance = this;

            instance._updateNodeState(event);
        },

        /**
         * Fire on drop hit event.
         *
         * @method _onDropHit
         * @param {EventFacade} event append event facade
         * @protected
         */
        _onDropHit: function(event) {
            var dropNode = event.drop.get(NODE).get(PARENT_NODE);
            var dropTreeNode = dropNode.getData(TREE_NODE);

            if (!isTreeNode(dropTreeNode)) {
                event.preventDefault();
            }
        },

        /**
         * Fire on drop exit event.
         *
         * @method _onDropExit
         * @param {EventFacade} event append event facade
         * @protected
         */
        _onDropExit: function() {
            var instance = this;

            instance.dropAction = null;

            instance._resetState(instance.nodeContent);
        }
    }
});

A.TreeViewDD = TreeViewDD;


}, '2.0.0', {
    "requires": [
        "dd-delegate",
        "dd-proxy",
        "aui-tree-node",
        "aui-tree-paginator",
        "aui-tree-io"
    ],
    "skinnable": true
});

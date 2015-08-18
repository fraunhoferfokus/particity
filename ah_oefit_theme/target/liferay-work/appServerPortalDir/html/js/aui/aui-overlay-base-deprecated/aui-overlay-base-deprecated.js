YUI.add('aui-overlay-base-deprecated', function (A, NAME) {

/**
 * Provides a basic Overlay widget, with Standard Module content support. The Overlay widget
 * provides Page XY positioning support, alignment and centering support along with basic
 * stackable support (z-index and shimming).
 *
 * @module aui-overlay
 * @submodule aui-overlay-base
 */

/**
 * A basic Overlay Widget, which can be positioned based on Page XY co-ordinates and is stackable (z-index support).
 * It also provides alignment and centering support and uses a standard module format for it's content, with header,
 * body and footer section support.
 *
 * @class OverlayBase
 * @constructor
 * @extends Component
 * @uses WidgetStdMod
 * @uses WidgetPosition
 * @uses WidgetStack
 * @uses WidgetPositionAlign
 * @uses WidgetPositionConstrain
 * @param {Object} object The user configuration for the instance.
 */
A.OverlayBase = A.Component.create(
	{
		NAME: 'overlay',
		ATTRS: {
			hideClass: {
				value: false
			}
		},
		AUGMENTS: [A.WidgetPosition, A.WidgetStack, A.WidgetPositionAlign, A.WidgetPositionConstrain, A.WidgetStdMod]
	}
);

}, '2.0.0', {
    "requires": [
        "widget-position",
        "widget-stack",
        "widget-position-align",
        "widget-position-constrain",
        "widget-stdmod",
        "aui-component"
    ]
});

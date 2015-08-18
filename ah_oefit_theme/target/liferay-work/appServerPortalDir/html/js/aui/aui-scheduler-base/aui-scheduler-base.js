YUI.add('aui-scheduler-base', function (A, NAME) {

/**
 * The Scheduler Component
 *
 * @module aui-scheduler
 * @submodule aui-scheduler-base-event
 */

var Lang = A.Lang,
    isArray = Lang.isArray,
    isBoolean = Lang.isBoolean,
    isDate = Lang.isDate,
    isFunction = Lang.isFunction,
    isNumber = Lang.isNumber,
    isObject = Lang.isObject,
    isString = Lang.isString,
    isValue = Lang.isValue,

    Color = A.Color,
    DateMath = A.DataType.DateMath,
    WidgetStdMod = A.WidgetStdMod,

    _COLON = ':',
    _DOT = '.',
    _EMPTY_STR = '',
    _N_DASH = '&ndash;',
    _SPACE = ' ',

    isModelList = function(val) {
        return val instanceof A.ModelList;
    },

    isSchedulerView = function(val) {
        return val instanceof A.SchedulerView;
    },

    TITLE_DT_FORMAT_ISO = '%H:%M',
    TITLE_DT_FORMAT_US_HOURS = '%l',
    TITLE_DT_FORMAT_US_MINUTES = '%M',

    getUSDateFormat = function(date) {
        var format = [TITLE_DT_FORMAT_US_HOURS];

        if (date.getMinutes() > 0) {
            format.push(_COLON);
            format.push(TITLE_DT_FORMAT_US_MINUTES);
        }

        if (date.getHours() >= 12) {
            format.push('pm');
        }

        return format.join(_EMPTY_STR);
    },

    DATA_VIEW_NAME = 'data-view-name',
    SCHEDULER_BASE = 'scheduler-base',
    SCHEDULER_CALENDAR = 'scheduler-calendar',
    SCHEDULER_VIEW = 'scheduler-view',

    ACTIVE_VIEW = 'activeView',
    ALL = 'all',
    ALL_DAY = 'allDay',
    BUTTON = 'button',
    COLOR = 'color',
    COLOR_BRIGHTNESS_FACTOR = 'colorBrightnessFactor',
    COLOR_SATURATION_FACTOR = 'colorSaturationFactor',
    CONTENT = 'content',
    CONTROLS = 'controls',
    CONTROLS_NODE = 'controlsNode',
    DATE = 'date',
    DAY = 'day',
    DISABLED = 'disabled',
    END_DATE = 'endDate',
    EVENT_RECORDER = 'eventRecorder',
    HD = 'hd',
    HEADER = 'header',
    HEADER_NODE = 'headerNode',
    HIDDEN = 'hidden',
    ICON = 'icon',
    ICON_NEXT_NODE = 'iconNextNode',
    ICON_PREV_NODE = 'iconPrevNode',
    ICONS = 'icons',
    ISO_TIME = 'isoTime',
    LOCALE = 'locale',
    MEETING = 'meeting',
    NAME = 'name',
    NAV = 'nav',
    NAV_NODE = 'navNode',
    NAVIGATION_DATE_FORMATTER = 'navigationDateFormatter',
    NEXT = 'next',
    NEXT_DATE = 'nextDate',
    NODE = 'node',
    NOSCROLL = 'noscroll',
    PALETTE = 'palette',
    PAST = 'past',
    PREV = 'prev',
    PREV_DATE = 'prevDate',
    REMINDER = 'reminder',
    RENDERED = 'rendered',
    REPEATED = 'repeated',
    SCHEDULER = 'scheduler',
    SCHEDULER_EVENT = 'scheduler-event',
    SCROLLABLE = 'scrollable',
    SHORT = 'short',
    START_DATE = 'startDate',
    STRINGS = 'strings',
    TITLE = 'title',
    TITLE_DATE_FORMAT = 'titleDateFormat',
    TODAY = 'today',
    TODAY_DATE = 'todayDate',
    TODAY_NODE = 'todayNode',
    TRIGGER_NODE = 'triggerNode',
    VIEW = 'view',
    VIEW_DATE_NODE = 'viewDateNode',
    VIEW_STACK = 'viewStack',
    VIEWS = 'views',
    VIEWS_NODE = 'viewsNode',
    VISIBLE = 'visible',
    RIGHT = 'right',
    ACTIVE = 'active',
    CHEVRON = 'chevron',
    BTN = 'btn',
    LEFT = 'left',

    getCN = A.getClassName,

    CSS_ICON = getCN(ICON),
    CSS_SCHEDULER_CONTROLS = getCN(SCHEDULER_BASE, CONTROLS),

    CSS_SCHEDULER_HD = getCN(SCHEDULER_BASE, HD),
    CSS_SCHEDULER_ICON_NEXT = getCN(SCHEDULER_BASE, ICON, NEXT),
    CSS_SCHEDULER_ICON_PREV = getCN(SCHEDULER_BASE, ICON, PREV),
    CSS_SCHEDULER_NAV = getCN(SCHEDULER_BASE, NAV),
    CSS_SCHEDULER_TODAY = getCN(SCHEDULER_BASE, TODAY),
    CSS_SCHEDULER_VIEW = getCN(SCHEDULER_BASE, VIEW),
    CSS_SCHEDULER_VIEW_ = getCN(SCHEDULER_BASE, VIEW, _EMPTY_STR),
    CSS_SCHEDULER_VIEW_DATE = getCN(SCHEDULER_BASE, VIEW, DATE),
    CSS_SCHEDULER_VIEW_NOSCROLL = getCN(SCHEDULER_VIEW, NOSCROLL),
    CSS_SCHEDULER_VIEW_SCROLLABLE = getCN(SCHEDULER_VIEW, SCROLLABLE),
    CSS_SCHEDULER_VIEW_SELECTED = getCN(ACTIVE),
    CSS_BTN = getCN(BTN),
    CSS_ICON_CHEVRON_RIGHT = getCN(ICON, CHEVRON, RIGHT),
    CSS_ICON_CHEVRON_LEFT = getCN(ICON, CHEVRON, LEFT),
    CSS_SCHEDULER_VIEWS = getCN(SCHEDULER_BASE, VIEWS),

    CSS_SCHEDULER_EVENT = getCN(SCHEDULER_EVENT),
    CSS_SCHEDULER_EVENT_ALL_DAY = getCN(SCHEDULER_EVENT, ALL, DAY),
    CSS_SCHEDULER_EVENT_CONTENT = getCN(SCHEDULER_EVENT, CONTENT),
    CSS_SCHEDULER_EVENT_DISABLED = getCN(SCHEDULER_EVENT, DISABLED),
    CSS_SCHEDULER_EVENT_HIDDEN = getCN(SCHEDULER_EVENT, HIDDEN),
    CSS_SCHEDULER_EVENT_ICON_DISABLED = getCN(SCHEDULER_EVENT, ICON, DISABLED),
    CSS_SCHEDULER_EVENT_ICON_MEETING = getCN(SCHEDULER_EVENT, ICON, MEETING),
    CSS_SCHEDULER_EVENT_ICON_REMINDER = getCN(SCHEDULER_EVENT, ICON, REMINDER),
    CSS_SCHEDULER_EVENT_ICON_REPEATED = getCN(SCHEDULER_EVENT, ICON, REPEATED),
    CSS_SCHEDULER_EVENT_ICONS = getCN(SCHEDULER_EVENT, ICONS),
    CSS_SCHEDULER_EVENT_MEETING = getCN(SCHEDULER_EVENT, MEETING),
    CSS_SCHEDULER_EVENT_PAST = getCN(SCHEDULER_EVENT, PAST),
    CSS_SCHEDULER_EVENT_REMINDER = getCN(SCHEDULER_EVENT, REMINDER),
    CSS_SCHEDULER_EVENT_REPEATED = getCN(SCHEDULER_EVENT, REPEATED),
    CSS_SCHEDULER_EVENT_SHORT = getCN(SCHEDULER_EVENT, SHORT),
    CSS_SCHEDULER_EVENT_TITLE = getCN(SCHEDULER_EVENT, TITLE),

    TPL_HTML_OPEN_SPAN = '<span>',
    TPL_HTML_CLOSE_SPAN = '</span>',
    TPL_SCHEDULER_CONTROLS = '<div class="span7 ' + CSS_SCHEDULER_CONTROLS + '"></div>',
    TPL_SCHEDULER_HD = '<div class="row-fluid ' + CSS_SCHEDULER_HD + '"></div>',
    TPL_SCHEDULER_ICON_NEXT = '<button type="button" class="' + [CSS_SCHEDULER_ICON_NEXT, CSS_BTN].join(_SPACE) +
        '"><i class="' + CSS_ICON_CHEVRON_RIGHT + '"></i></button>',
    TPL_SCHEDULER_ICON_PREV = '<button type="button" class="' + [CSS_SCHEDULER_ICON_PREV, CSS_BTN].join(_SPACE) +
        '"><i class="' + CSS_ICON_CHEVRON_LEFT + '"></i></button>',
    TPL_SCHEDULER_NAV = '<div class="btn-group"></div>',
    TPL_SCHEDULER_TODAY = '<button type="button" class="' + [CSS_SCHEDULER_TODAY, CSS_BTN].join(_SPACE) +
        '">{today}</button>',
    TPL_SCHEDULER_VIEW = '<button type="button" class="' + [CSS_SCHEDULER_VIEW, CSS_SCHEDULER_VIEW_].join(_SPACE) +
        '{name}" data-view-name="{name}">{label}</button>',
    TPL_SCHEDULER_VIEW_DATE = '<span class="' + CSS_SCHEDULER_VIEW_DATE + '"></span>',
    TPL_SCHEDULER_VIEWS = '<div class="span5 ' + CSS_SCHEDULER_VIEWS + '"></div>';

/**
 * A base class for SchedulerEvent.
 *
 * @class A.SchedulerEvent
 * @extends A.Model
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var SchedulerEvent = A.Component.create({

    /**
     * Static property provides a string to identify the class.
     *
     * @property SchedulerEvent.NAME
     * @type String
     * @static
     */
    NAME: SCHEDULER_EVENT,

    /**
     * Static property used to define the default attribute
     * configuration for the SchedulerEvent.
     *
     * @property SchedulerEvent.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute allDay
         * @default false
         * @type Boolean
         */
        allDay: {
            setter: A.DataType.Boolean.parse,
            value: false
        },

        /**
         * Determines the CSS border color of a calendar event.
         *
         * @attribute borderColor
         * @default '#FFFFFF'
         * @type String
         */
        borderColor: {
            value: '#FFFFFF',
            validator: isString
        },

        /**
         * Determines the CSS border style of a calendar event.
         *
         * @attribute borderStyle
         * @default 'solid'
         * @type String
         */
        borderStyle: {
            value: 'solid',
            validator: isString
        },

        /**
         * Determines the CSS border width of a calendar event.
         *
         * @attribute borderWidth
         * @default '2px'
         * @type String
         */
        borderWidth: {
            value: '2px',
            validator: isString
        },

        /**
         * Contains the content of Scheduler event's body section.
         *
         * @attribute content
         */
        content: {
            setter: String,
            validator: isValue
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute color
         * @default '#D96666'
         * @type String
         */
        color: {
            lazyAdd: false,
            value: '#376cd9',
            validator: isString
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute colorBrightnessFactor
         * @default 1.4
         * @type Number
         */
        colorBrightnessFactor: {
            value: 1.4,
            validator: isNumber
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute colorSaturationFactor
         * @default 0.88
         * @type Number
         */
        colorSaturationFactor: {
            value: 0.88,
            validator: isNumber
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute titleDateFormat
         * @type Function
         */
        titleDateFormat: {
            getter: '_getTitleDateFormat',
            value: function() {
                var instance = this,
                    scheduler = instance.get(SCHEDULER),
                    isoTime = scheduler && scheduler.get(ACTIVE_VIEW).get(ISO_TIME),

                    format = {
                        endDate: TPL_HTML_OPEN_SPAN + _N_DASH + _SPACE + TITLE_DT_FORMAT_ISO + TPL_HTML_CLOSE_SPAN,
                        startDate: TITLE_DT_FORMAT_ISO
                    };

                if (!isoTime) {
                    format.endDate = TPL_HTML_OPEN_SPAN + _N_DASH + _SPACE + getUSDateFormat(instance.get(END_DATE)) +
                        TPL_HTML_CLOSE_SPAN;
                    format.startDate = getUSDateFormat(instance.get(START_DATE));
                }

                if (instance.getMinutesDuration() <= 30) {
                    delete format.endDate;
                }
                else if (instance.get(ALL_DAY)) {
                    format = {};
                }

                return format;
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute endDate
         */
        endDate: {
            setter: '_setDate',
            valueFn: function() {
                var date = DateMath.clone(this.get(START_DATE));

                date.setHours(date.getHours() + 1);

                return date;
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute disabled
         * @default false
         * @type Boolean
         */
        disabled: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute meeting
         * @default false
         * @type Boolean
         */
        meeting: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute node
         */
        node: {
            valueFn: function() {
                return A.NodeList.create(A.Node.create(this.EVENT_NODE_TEMPLATE).setData(SCHEDULER_EVENT, this));
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute reminder
         * @default false
         * @type Boolean
         */
        reminder: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute repeated
         * @default false
         * @type Boolean
         */
        repeated: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute scheduler
         */
        scheduler: {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute startDate
         */
        startDate: {
            setter: '_setDate',
            valueFn: function() {
                return new Date();
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute visible
         * @default true
         * @type Boolean
         */
        visible: {
            value: true,
            validator: isBoolean
        }
    },

    /**
     * Static property used to define which component it extends.
     *
     * @property SchedulerEvent.EXTENDS
     * @type Object
     * @static
     */
    EXTENDS: A.Model,

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @property SchedulerEvent.PROPAGATE_ATTRS
     * @type Array
     * @static
     */
    PROPAGATE_ATTRS: [ALL_DAY, START_DATE, END_DATE, CONTENT, COLOR, COLOR_BRIGHTNESS_FACTOR,
        COLOR_SATURATION_FACTOR, TITLE_DATE_FORMAT, VISIBLE, DISABLED],

    prototype: {
        EVENT_NODE_TEMPLATE: '<div class="' + CSS_SCHEDULER_EVENT + '">' + '<div class="' + CSS_SCHEDULER_EVENT_TITLE + '"></div>' + '<div class="' + CSS_SCHEDULER_EVENT_CONTENT + '"></div>' + '<div class="' + CSS_SCHEDULER_EVENT_ICONS + '">' + '<span class="' + [
            CSS_ICON, CSS_SCHEDULER_EVENT_ICON_DISABLED].join(_SPACE) + '"></span>' + '<span class="' + [CSS_ICON,
            CSS_SCHEDULER_EVENT_ICON_MEETING].join(_SPACE) + '"></span>' + '<span class="' + [CSS_ICON,
            CSS_SCHEDULER_EVENT_ICON_REMINDER].join(_SPACE) + '"></span>' + '<span class="' + [CSS_ICON,
            CSS_SCHEDULER_EVENT_ICON_REPEATED].join(_SPACE) + '"></span>' + '</div>' + '</div>',

        /**
         * Construction logic executed during SchedulerEvent instantiation. Lifecycle.
         *
         * @method initializer
         * @protected
         */
        initializer: function() {
            var instance = this;

            instance.bindUI();
            instance.syncUI();
        },

        /**
         * Bind the events on the SchedulerEvent UI. Lifecycle.
         *
         * @method bindUI
         * @protected
         */
        bindUI: function() {
            var instance = this;

            instance.after({
                allDayChange: instance._afterAllDayChange,
                colorChange: instance._afterColorChange,
                disabledChange: instance._afterDisabledChange,
                endDateChange: instance._afterEndDateChange,
                meetingChange: instance._afterMeetingChange,
                reminderChange: instance._afterReminderChange,
                repeatedChange: instance._afterRepeatedChange,
                visibleChange: instance._afterVisibleChange
            });
        },

        /**
         * Sync the SchedulerEvent UI. Lifecycle.
         *
         * @method syncUI
         * @protected
         */
        syncUI: function() {
            var instance = this;

            instance._uiSetAllDay(
                instance.get(ALL_DAY));

            instance._uiSetColor(
                instance.get(COLOR));

            instance._uiSetDisabled(
                instance.get(DISABLED));

            instance._uiSetEndDate(
                instance.get(END_DATE));

            instance._uiSetMeeting(
                instance.get(MEETING));

            instance._uiSetPast(
                instance._isPastEvent());

            instance._uiSetReminder(
                instance.get(REMINDER));

            instance._uiSetRepeated(
                instance.get(REPEATED));

            instance._uiSetVisible(
                instance.get(VISIBLE));

            instance.syncNodeTitleUI();
            instance.syncNodeContentUI();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request. Lifecycle.
         *
         * @method destroy
         * @protected
         */
        destroy: function() {
            var instance = this;

            instance.get(NODE).remove(true);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method addPaddingNode
         */
        addPaddingNode: function() {
            var instance = this;

            instance.get(NODE).push(A.Node.create(instance.EVENT_NODE_TEMPLATE).setData(SCHEDULER_EVENT, instance));

            instance.syncUI();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method clone
         */
        clone: function() {
            var instance = this,
                cloned = null,
                scheduler = instance.get(SCHEDULER);

            if (scheduler) {
                cloned = new scheduler.eventModel();
                cloned.copyPropagateAttrValues(instance, null, {
                    silent: true
                });
            }

            return cloned;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method copyDates
         * @param evt
         * @param options
         */
        copyDates: function(evt, options) {
            var instance = this;

            instance.setAttrs({
                    endDate: DateMath.clone(evt.get(END_DATE)),
                    startDate: DateMath.clone(evt.get(START_DATE))
                },
                options);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method copyPropagateAttrValues
         * @param evt
         * @param dontCopyMap
         * @param options
         */
        copyPropagateAttrValues: function(evt, dontCopyMap, options) {
            var instance = this,
                attrMap = {};

            instance.copyDates(evt, options);

            A.Array.each(instance.constructor.PROPAGATE_ATTRS, function(attrName) {
                if (!((dontCopyMap || {}).hasOwnProperty(attrName))) {
                    var value = evt.get(attrName);

                    if (!isObject(value)) {
                        attrMap[attrName] = value;
                    }
                }
            });

            instance.setAttrs(attrMap, options);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getDaysDuration
         */
        getDaysDuration: function() {
            var instance = this;

            return DateMath.getDayOffset(
                instance.get(END_DATE), instance.get(START_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getHoursDuration
         */
        getHoursDuration: function() {
            var instance = this;

            return DateMath.getHoursOffset(
                instance.get(END_DATE), instance.get(START_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getMinutesDuration
         */
        getMinutesDuration: function() {
            var instance = this;

            return DateMath.getMinutesOffset(
                instance.get(END_DATE), instance.get(START_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getSecondsDuration
         */
        getSecondsDuration: function() {
            var instance = this;

            return DateMath.getSecondsOffset(
                instance.get(END_DATE), instance.get(START_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method sameEndDate
         * @param evt
         */
        sameEndDate: function(evt) {
            var instance = this;

            return DateMath.compare(instance.get(END_DATE), evt.get(END_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method sameStartDate
         * @param evt
         */
        sameStartDate: function(evt) {
            var instance = this;

            return DateMath.compare(
                instance.get(START_DATE), evt.get(START_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method isAfter
         * @param evt
         */
        isAfter: function(evt) {
            var instance = this;
            var startDate = instance.get(START_DATE);
            var evtStartDate = evt.get(START_DATE);

            return DateMath.after(startDate, evtStartDate);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method isBefore
         * @param evt
         */
        isBefore: function(evt) {
            var instance = this;
            var startDate = instance.get(START_DATE);
            var evtStartDate = evt.get(START_DATE);

            return DateMath.before(startDate, evtStartDate);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method intersects
         * @param evt
         */
        intersects: function(evt) {
            var instance = this;
            var endDate = instance.get(END_DATE);
            var startDate = instance.get(START_DATE);
            var evtStartDate = evt.get(START_DATE);

            return (instance.sameStartDate(evt) ||
                DateMath.between(evtStartDate, startDate, endDate));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method intersectHours
         * @param evt
         */
        intersectHours: function(evt) {
            var instance = this;
            var endDate = instance.get(END_DATE);
            var startDate = instance.get(START_DATE);
            var evtModifiedStartDate = DateMath.clone(startDate);

            DateMath.copyHours(evtModifiedStartDate, evt.get(START_DATE));

            return (DateMath.compare(startDate, evtModifiedStartDate) ||
                DateMath.between(evtModifiedStartDate, startDate, endDate));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method isDayBoundaryEvent
         */
        isDayBoundaryEvent: function() {
            var instance = this;

            return DateMath.isDayBoundary(
                instance.get(START_DATE), instance.get(END_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method isDayOverlapEvent
         */
        isDayOverlapEvent: function() {
            var instance = this;

            return DateMath.isDayOverlap(
                instance.get(START_DATE), instance.get(END_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getClearEndDate
         */
        getClearEndDate: function() {
            var instance = this;

            return DateMath.safeClearTime(instance.get(END_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getClearStartDate
         */
        getClearStartDate: function() {
            var instance = this;

            return DateMath.safeClearTime(instance.get(START_DATE));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method move
         * @param date
         * @param options
         */
        move: function(date, options) {
            var instance = this;
            var duration = instance.getMinutesDuration();

            instance.setAttrs({
                    endDate: DateMath.add(DateMath.clone(date), DateMath.MINUTES, duration),
                    startDate: date
                },
                options);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method setContent
         * @param content
         */
        setContent: function(content) {
            var instance = this;

            instance.get(NODE).each(function(node) {
                var contentNode = node.one(_DOT + CSS_SCHEDULER_EVENT_CONTENT);

                contentNode.setContent(content);
            });
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method setTitle
         * @param content
         */
        setTitle: function(content) {
            var instance = this;

            instance.get(NODE).each(function(node) {
                var titleNode = node.one(_DOT + CSS_SCHEDULER_EVENT_TITLE);

                titleNode.setContent(content);
            });
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method syncNodeContentUI
         */
        syncNodeContentUI: function() {
            var instance = this;

            instance.setContent(instance.get(CONTENT));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method syncNodeTitleUI
         */
        syncNodeTitleUI: function() {
            var instance = this,
                format = instance.get(TITLE_DATE_FORMAT),
                startDate = instance.get(START_DATE),
                endDate = instance.get(END_DATE),
                title = [];

            if (format.startDate) {
                title.push(instance._formatDate(startDate, format.startDate));
            }

            if (format.endDate) {
                title.push(instance._formatDate(endDate, format.endDate));
            }

            instance.setTitle(title.join(_EMPTY_STR));
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method split
         */
        split: function() {
            var instance = this,
                s1 = DateMath.clone(instance.get(START_DATE)),
                e1 = DateMath.clone(instance.get(END_DATE));

            if (instance.isDayOverlapEvent() && !instance.isDayBoundaryEvent()) {
                var s2 = DateMath.clone(s1);
                s2.setHours(24, 0, 0, 0);

                return [[s1, DateMath.toMidnight(DateMath.clone(s1))], [s2, DateMath.clone(e1)]];
            }

            return [[s1, e1]];
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterAllDayChange
         * @param event
         * @protected
         */
        _afterAllDayChange: function(event) {
            var instance = this;

            instance._uiSetAllDay(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterColorChange
         * @param event
         * @protected
         */
        _afterColorChange: function(event) {
            var instance = this;

            instance._uiSetColor(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterDisabledChange
         * @param event
         * @protected
         */
        _afterDisabledChange: function(event) {
            var instance = this;

            instance._uiSetDisabled(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterEndDateChange
         * @param event
         * @protected
         */
        _afterEndDateChange: function(event) {
            var instance = this;

            instance._uiSetEndDate(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterMeetingChange
         * @param event
         * @protected
         */
        _afterMeetingChange: function(event) {
            var instance = this;

            instance._uiSetMeeting(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterReminderChange
         * @param event
         * @protected
         */
        _afterReminderChange: function(event) {
            var instance = this;

            instance._uiSetReminder(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterRepeatedChange
         * @param event
         * @protected
         */
        _afterRepeatedChange: function(event) {
            var instance = this;

            instance._uiSetRepeated(event.newVal);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterVisibleChange
         * @param event
         * @protected
         */
        _afterVisibleChange: function(event) {
            var instance = this;

            instance._uiSetVisible(event.newVal);
        },

        /**
         * Returns true if the event ends before the current date.
         *
         * @method _isPastEvent
         * @protected
         */
        _isPastEvent: function() {
            var instance = this,
                endDate = instance.get(END_DATE);

            return (endDate.getTime() < (new Date()).getTime());
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _setDate
         * @param val
         * @protected
         */
        _setDate: function(val) {
            var instance = this;

            if (isNumber(val)) {
                val = new Date(val);
            }

            return val;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _formatDate
         * @param date
         * @param format
         * @protected
         */
        _formatDate: function(date, format) {
            var instance = this;
            var locale = instance.get(LOCALE);

            return A.DataType.Date.format(date, {
                format: format,
                locale: locale
            });
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getTitleDateFormat
         * @param val
         * @protected
         */
        _getTitleDateFormat: function(val) {
            var instance = this;

            if (isString(val)) {
                val = {
                    endDate: val,
                    startDate: val
                };
            }
            else if (isFunction(val)) {
                val = val.call(instance);
            }

            return val;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetAllDay
         * @param val
         * @protected
         */
        _uiSetAllDay: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_ALL_DAY, !! val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetColor
         * @param val
         * @protected
         */
        _uiSetColor: function(val) {
            var instance = this;
            var node = instance.get(NODE);

            var color = Color.toHSL(val);
            var backgroundColor = Color.toArray(color);

            backgroundColor[1] *= instance.get(COLOR_SATURATION_FACTOR);
            backgroundColor[2] *= instance.get(COLOR_BRIGHTNESS_FACTOR);
            backgroundColor = Color.fromArray(backgroundColor, Color.TYPES.HSL);

            // Some browsers doesn't support HSL colors, convert to RGB for
            // compatibility.
            color = Color.toRGB(color);
            backgroundColor = Color.toRGB(backgroundColor);

            if (node) {
                node.setStyles({
                    backgroundColor: backgroundColor,
                    borderColor: instance.get('borderColor'),
                    borderStyle: instance.get('borderStyle'),
                    borderWidth: instance.get('borderWidth'),
                    color: color
                });
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetDisabled
         * @param val
         * @protected
         */
        _uiSetDisabled: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_DISABLED, !! val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetEndDate
         * @param val
         * @protected
         */
        _uiSetEndDate: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_SHORT, instance.getMinutesDuration() <= 30);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetMeeting
         * @param val
         * @protected
         */
        _uiSetMeeting: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_MEETING, !! val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetPast
         * @param val
         * @protected
         */
        _uiSetPast: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_PAST, !! val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetReminder
         * @param val
         * @protected
         */
        _uiSetReminder: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_REMINDER, !! val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetRepeated
         * @param val
         * @protected
         */
        _uiSetRepeated: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_REPEATED, !! val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetVisible
         * @param val
         * @protected
         */
        _uiSetVisible: function(val) {
            var instance = this;

            instance.get(NODE).toggleClass(CSS_SCHEDULER_EVENT_HIDDEN, !val);
        }
    }
});

A.SchedulerEvent = SchedulerEvent;
/**
 * The Scheduler Component
 *
 * @module aui-scheduler
 * @submodule aui-scheduler-base-calendar
 */

/**
 * A base class for SchedulerCalendar.
 *
 * @class A.SchedulerCalendar
 * @extends A.ModelList
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var SchedulerCalendar = A.Base.create(SCHEDULER_CALENDAR, A.ModelList, [], {
    model: A.SchedulerEvent,

    /**
     * Construction logic executed during SchedulerCalendar instantiation. Lifecycle.
     *
     * @method initializer
     * @protected
     */
    initializer: function() {
        var instance = this;

        instance.after('colorChange', instance._afterColorChange);
        instance.after('disabledChange', instance._afterDisabledChange);
        instance.after('visibleChange', instance._afterVisibleChange);
        instance.after(['add', 'remove', 'reset'], instance._afterEventsChange);
        instance.on(['remove', 'reset'], instance._onRemoveEvents);

        instance._uiSetEvents(
            instance.toArray()
        );

        instance._setModelsAttrs({
            color: instance.get(COLOR),
            disabled: instance.get(DISABLED),
            visible: instance.get(VISIBLE)
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _afterColorChange
     * @param event
     * @protected
     */
    _afterColorChange: function(event) {
        var instance = this;

        instance._setModelsAttrs({
            color: instance.get(COLOR)
        }, {
            silent: event.silent
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _afterDisabledChange
     * @param event
     * @protected
     */
    _afterDisabledChange: function(event) {
        var instance = this;

        instance._setModelsAttrs({
            disabled: instance.get(DISABLED)
        }, {
            silent: event.silent
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _afterEventsChange
     * @param event
     * @protected
     */
    _afterEventsChange: function(event) {
        var instance = this;

        instance._setModelsAttrs({
            color: instance.get(COLOR),
            disabled: instance.get(DISABLED),
            visible: instance.get(VISIBLE)
        }, {
            silent: true
        });

        instance._uiSetEvents(instance.toArray());
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _afterVisibleChange
     * @param event
     * @protected
     */
    _afterVisibleChange: function(event) {
        var instance = this;

        instance._setModelsAttrs({
            visible: instance.get(VISIBLE)
        }, {
            silent: event.silent
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _onRemoveEvents
     * @param event
     * @protected
     */
    _onRemoveEvents: function(event) {
        var instance = this;
        var scheduler = instance.get(SCHEDULER);

        if (scheduler) {
            scheduler.removeEvents(instance);
        }
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _setModelsAttrs
     * @param attrMap
     * @param options
     * @protected
     */
    _setModelsAttrs: function(attrMap, options) {
        var instance = this;

        instance.each(function(schedulerEvent) {
            schedulerEvent.setAttrs(attrMap, options);
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _uiSetEvents
     * @param val
     * @protected
     */
    _uiSetEvents: function(val) {
        var instance = this;
        var scheduler = instance.get(SCHEDULER);

        if (scheduler) {
            scheduler.addEvents(val);
            scheduler.syncEventsUI();
        }
    }
}, {

    /**
     * Static property used to define the default attribute
     * configuration for the SchedulerCalendar.
     *
     * @property SchedulerCalendar.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute color
         * @type String
         */
        color: {
            valueFn: function() {
                var instance = this;
                var palette = instance.get(PALETTE);
                var randomIndex = Math.ceil(Math.random() * palette.length) - 1;

                return palette[randomIndex];
            },
            validator: isString
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute disabled
         * @default false
         * @type Boolean
         */
        disabled: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute name
         * @default '(no name)'
         * @type String
         */
        name: {
            value: '(no name)',
            validator: isString
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute palette
         * @type Array
         */
        palette: {
            value: ['#d93636', '#e63973', '#b22eb3', '#6e36d9', '#2d70b3', '#376cd9', '#25998c', '#249960',
                '#24992e', '#6b9926', '#999926', '#a68f29', '#b3782d', '#bf6030', '#bf6060', '#997399', '#617181',
                '#6b7a99', '#548c85', '#747446', '#997e5c', '#b34d1b', '#993d48', '#802d70'],
            validator: isArray
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute scheduler
         */
        scheduler: {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute visible
         * @default true
         * @type Boolean
         */
        visible: {
            value: true,
            validator: isBoolean
        }
    }
});

A.SchedulerCalendar = SchedulerCalendar;
/**
 * The Scheduler Component
 *
 * @module aui-scheduler
 * @submodule aui-scheduler-base
 */

/**
 * A base class for SchedulerEvents.
 *
 * @class A.SchedulerEvents
 * @extends A.ModelList
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
A.SchedulerEvents = A.Base.create('scheduler-events', A.ModelList, [], {

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method comparator
     * @param model
     */
    comparator: function(model) {
        var startDateTime = model.get(START_DATE),
            endDateTime = model.get(END_DATE);

        return startDateTime + 1 / (endDateTime - startDateTime);
    },

    model: A.SchedulerEvent
}, {

    /**
     * Static property used to define the default attribute
     * configuration for the SchedulerEvents.
     *
     * @property SchedulerEvents.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {
        scheduler: {}
    }
});

/**
 * A base class for SchedulerEventSupport.
 *
 * @class A.SchedulerEventSupport
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var SchedulerEventSupport = function() {};

/**
 * Static property used to define the default attribute
 * configuration for the SchedulerEventSupport.
 *
 * @property SchedulerEventSupport.ATTRS
 * @type Object
 * @static
 */
SchedulerEventSupport.ATTRS = {};

A.mix(SchedulerEventSupport.prototype, {
    calendarModel: A.SchedulerCalendar,

    eventModel: A.SchedulerEvent,

    eventsModel: A.SchedulerEvents,

    /**
     * Construction logic executed during SchedulerEventSupport instantiation. Lifecycle.
     *
     * @method initializer
     * @param config
     * @protected
     */
    initializer: function(config) {
        var instance = this;

        instance._events = new instance.eventsModel({
            after: {
                add: A.bind(instance._afterAddEvent, instance)
            },
            bubbleTargets: instance,
            scheduler: instance
        });

        instance.addEvents(config.items || config.events);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method addEvents
     * @param models
     */
    addEvents: function(models) {
        var instance = this,
            events = instance._toSchedulerEvents(models);

        return instance._events.add(events);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method eachEvent
     * @param fn
     */
    eachEvent: function(fn) {
        var instance = this;

        return instance._events.each(fn);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method flushEvents
     */
    flushEvents: function() {
        var instance = this;

        instance._events.each(function(evt) {
            delete evt._filtered;
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method getEventByClientId
     * @param clientId
     */
    getEventByClientId: function(clientId) {
        var instance = this;

        return instance._events.getByClientId(clientId);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method getEvents
     * @param filterFn
     */
    getEvents: function(filterFn) {
        var instance = this,
            events = instance._events;

        // TODO: Check why the items are not being sorted on add
        events.sort({
            silent: true
        });

        if (filterFn) {
            events = events.filter(filterFn);
        }
        else {
            events = events.toArray();
        }

        return events;
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method getEventsByDay
     * @param date
     * @param includeOverlap
     */
    getEventsByDay: function(date, includeOverlap) {
        var instance = this;

        date = DateMath.safeClearTime(date);

        return instance.getEvents(function(evt) {
            return DateMath.compare(evt.getClearStartDate(), date) ||
                (includeOverlap && DateMath.compare(evt.getClearEndDate(), date));
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method getIntersectEvents
     * @param date
     */
    getIntersectEvents: function(date) {
        var instance = this;

        date = DateMath.safeClearTime(date);

        return instance.getEvents(function(evt) {
            var startDate = evt.getClearStartDate();
            var endDate = evt.getClearEndDate();

            return (evt.get(VISIBLE) &&
                (DateMath.compare(date, startDate) ||
                    DateMath.compare(date, endDate) ||
                    DateMath.between(date, startDate, endDate)));
        });
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method removeEvents
     * @param models
     */
    removeEvents: function(models) {
        var instance = this,
            events = instance._toSchedulerEvents(models);

        return instance._events.remove(events);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method resetEvents
     * @param models
     */
    resetEvents: function(models) {
        var instance = this,
            events = instance._toSchedulerEvents(models);

        return instance._events.reset(events);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _afterAddEvent
     * @param event
     * @protected
     */
    _afterAddEvent: function(event) {
        var instance = this;

        event.model.set(SCHEDULER, instance);
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @method _toSchedulerEvents
     * @param values
     * @protected
     */
    _toSchedulerEvents: function(values) {
        var instance = this,
            events = [];

        if (isModelList(values)) {
            events = values.toArray();
            values.set(SCHEDULER, instance);
        }
        else if (isArray(values)) {
            A.Array.each(values, function(value) {
                if (isModelList(value)) {
                    events = events.concat(value.toArray());
                    value.set(SCHEDULER, instance);
                }
                else {
                    events.push(value);
                }
            });
        }
        else {
            events = values;
        }

        return events;
    }
});

A.SchedulerEventSupport = SchedulerEventSupport;

/**
 * A base class for SchedulerBase.
 *
 * @class A.SchedulerBase
 * @extends A.Component
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var SchedulerBase = A.Component.create({

    /**
     * Static property provides a string to identify the class.
     *
     * @property SchedulerBase.NAME
     * @type String
     * @static
     */
    NAME: SCHEDULER_BASE,

    /**
     * Static property used to define the default attribute
     * configuration for the SchedulerBase.
     *
     * @property SchedulerBase.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute activeView
         * @type SchedulerView
         */
        activeView: {
            validator: isSchedulerView
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute date
         * @type Date
         */
        date: {
            value: new Date(),
            validator: isDate
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute eventRecorder
         */
        eventRecorder: {
            setter: '_setEventRecorder'
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute strings
         * @type Object
         */
        strings: {
            value: {
                agenda: 'Agenda',
                day: 'Day',
                month: 'Month',
                today: 'Today',
                week: 'Week',
                year: 'Year'
            }
        },

        /**
         * The function to format the navigation header date.
         *
         * @attribute navigationDateFormatter
         * @default %A - %d %b %Y
         * @type Function
         */
        navigationDateFormatter: {
            value: function(date) {
                var instance = this;

                return A.DataType.Date.format(
                    date, {
                        format: '%B %d, %Y',
                        locale: instance.get(LOCALE)
                    }
                );
            },
            validator: isFunction
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute views
         * @default []
         */
        views: {
            setter: '_setViews',
            value: []
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute viewDate
         * @readOnly
         */
        viewDate: {
            getter: '_getViewDate',
            readOnly: true
        },

        /**
         * First day of the week: Sunday is 0, Monday is 1.
         *
         * @attribute firstDayOfWeek
         * @default 0
         * @type Number
         */
        firstDayOfWeek: {
            value: 0,
            validator: isNumber
        },

        /*
         * HTML_PARSER attributes
         */
        controlsNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_CONTROLS);
            }
        },

        viewDateNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_VIEW_DATE);
            }
        },

        headerNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_HD);
            }
        },

        iconNextNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_ICON_NEXT);
            }
        },

        iconPrevNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_ICON_PREV);
            }
        },

        navNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_NAV);
            }
        },

        /**
         * Today date representation. This option allows the developer to
         * specify the date he wants to be used as the today date.
         *
         * @attribute todayDate
         * @default new Date()
         * @type Date
         */
        todayDate: {
            value: new Date(),
            validator: isDate
        },

        todayNode: {
            valueFn: function() {
                return A.Node.create(
                    this._processTemplate(TPL_SCHEDULER_TODAY)
                );
            }
        },

        viewsNode: {
            valueFn: function() {
                return A.Node.create(TPL_SCHEDULER_VIEWS);
            }
        }
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @property SchedulerBase.HTML_PARSER
     * @type Object
     * @static
     */
    HTML_PARSER: {
        controlsNode: _DOT + CSS_SCHEDULER_CONTROLS,
        viewDateNode: _DOT + CSS_SCHEDULER_VIEW_DATE,
        headerNode: _DOT + CSS_SCHEDULER_HD,
        iconNextNode: _DOT + CSS_SCHEDULER_ICON_NEXT,
        iconPrevNode: _DOT + CSS_SCHEDULER_ICON_PREV,
        navNode: _DOT + CSS_SCHEDULER_NAV,
        todayNode: _DOT + CSS_SCHEDULER_TODAY,
        viewsNode: _DOT + CSS_SCHEDULER_VIEWS
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @property SchedulerBase.UI_ATTRS
     * @type Array
     * @static
     */
    UI_ATTRS: [DATE, ACTIVE_VIEW],

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @property SchedulerBase.AUGMENTS
     * @type Array
     * @static
     */
    AUGMENTS: [A.SchedulerEventSupport, A.WidgetStdMod],

    prototype: {
        viewStack: null,

        /**
         * Construction logic executed during SchedulerBase instantiation. Lifecycle.
         *
         * @method initializer
         * @protected
         */
        initializer: function() {
            var instance = this;

            instance[VIEW_STACK] = {};

            instance[CONTROLS_NODE] = instance.get(CONTROLS_NODE);
            instance[VIEW_DATE_NODE] = instance.get(VIEW_DATE_NODE);
            instance[HEADER] = instance.get(HEADER_NODE);
            instance[ICON_NEXT_NODE] = instance.get(ICON_NEXT_NODE);
            instance[ICON_PREV_NODE] = instance.get(ICON_PREV_NODE);
            instance[NAV_NODE] = instance.get(NAV_NODE);
            instance[TODAY_NODE] = instance.get(TODAY_NODE);
            instance[VIEWS_NODE] = instance.get(VIEWS_NODE);

            instance.after({
                activeViewChange: instance._afterActiveViewChange,
                render: instance._afterRender
            });
        },

        /**
         * Bind the events on the SchedulerBase UI. Lifecycle.
         *
         * @method bindUI
         * @protected
         */
        bindUI: function() {
            var instance = this;

            instance._bindDelegate();
        },

        /**
         * Sync the SchedulerBase UI. Lifecycle.
         *
         * @method syncUI
         * @protected
         */
        syncUI: function() {
            var instance = this;

            instance.syncStdContent();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getViewByName
         * @param name
         */
        getViewByName: function(name) {
            var instance = this;

            return instance[VIEW_STACK][name];
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getStrings
         */
        getStrings: function() {
            var instance = this;

            return instance.get(STRINGS);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getString
         * @param key
         */
        getString: function(key) {
            var instance = this;

            return instance.getStrings()[key];
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method renderView
         * @param view
         */
        renderView: function(view) {
            var instance = this;

            if (view) {
                view.show();

                if (!view.get(RENDERED)) {
                    if (!instance.bodyNode) {
                        instance.setStdModContent(WidgetStdMod.BODY, _EMPTY_STR);
                    }

                    view.render(instance.bodyNode);
                }
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method plotViewEvents
         * @param view
         */
        plotViewEvents: function(view) {
            var instance = this;

            view.plotEvents(
                instance.getEvents()
            );
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method syncEventsUI
         */
        syncEventsUI: function() {
            var instance = this,
                activeView = instance.get(ACTIVE_VIEW);

            if (activeView) {
                instance.plotViewEvents(activeView);
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method renderButtonGroup
         */
        renderButtonGroup: function() {
            var instance = this;

            instance.buttonGroup = new A.ButtonGroup({
                boundingBox: instance[VIEWS_NODE],
                on: {
                    selectionChange: A.bind(instance._onButtonGroupSelectionChange, instance)
                }
            }).render();
        },

        /**
         * Sync SchedulerBase StdContent.
         *
         * @method syncStdContent
         */
        syncStdContent: function() {
            var instance = this;
            var views = instance.get(VIEWS);

            instance[NAV_NODE].append(instance[ICON_PREV_NODE]);
            instance[NAV_NODE].append(instance[ICON_NEXT_NODE]);

            instance[CONTROLS_NODE].append(instance[TODAY_NODE]);
            instance[CONTROLS_NODE].append(instance[NAV_NODE]);
            instance[CONTROLS_NODE].append(instance[VIEW_DATE_NODE]);

            A.Array.each(views, function(view) {
                instance[VIEWS_NODE].append(instance._createViewTriggerNode(view));
            });

            instance[HEADER].append(instance[CONTROLS_NODE]);
            instance[HEADER].append(instance[VIEWS_NODE]);

            instance.setStdModContent(WidgetStdMod.HEADER, instance[HEADER].getDOM());
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterActiveViewChange
         * @param event
         * @protected
         */
        _afterActiveViewChange: function(event) {
            var instance = this;

            if (instance.get(RENDERED)) {
                var activeView = event.newVal;
                var lastActiveView = event.prevVal;

                if (lastActiveView) {
                    lastActiveView.hide();
                }

                instance.renderView(activeView);

                var eventRecorder = instance.get(EVENT_RECORDER);

                if (eventRecorder) {
                    eventRecorder.hidePopover();
                }

                instance._uiSetDate(instance.get(DATE));
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterRender
         * @param event
         * @protected
         */
        _afterRender: function(event) {
            var instance = this,
                activeView = instance.get(ACTIVE_VIEW);

            instance.renderView(activeView);
            instance.renderButtonGroup();

            instance._uiSetDate(instance.get(DATE));
            instance._uiSetActiveView(activeView);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _bindDelegate
         * @protected
         */
        _bindDelegate: function() {
            var instance = this;

            instance[CONTROLS_NODE].delegate('click', instance._onClickPrevIcon, _DOT + CSS_SCHEDULER_ICON_PREV,
                instance);
            instance[CONTROLS_NODE].delegate('click', instance._onClickNextIcon, _DOT + CSS_SCHEDULER_ICON_NEXT,
                instance);
            instance[CONTROLS_NODE].delegate('click', instance._onClickToday, _DOT + CSS_SCHEDULER_TODAY, instance);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _createViewTriggerNode
         * @param view
         * @protected
         */
        _createViewTriggerNode: function(view) {
            var instance = this;

            if (!view.get(TRIGGER_NODE)) {
                var name = view.get(NAME);

                view.set(
                    TRIGGER_NODE,
                    A.Node.create(
                        Lang.sub(TPL_SCHEDULER_VIEW, {
                            name: name,
                            label: (instance.getString(name) || name)
                        })
                    )
                );
            }

            return view.get(TRIGGER_NODE);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _getViewDate
         * @protected
         */
        _getViewDate: function() {
            var instance = this,
                date = instance.get(DATE),
                activeView = instance.get(ACTIVE_VIEW);

            if (activeView) {
                date = activeView.getAdjustedViewDate(date);
            }

            return date;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onClickToday
         * @param event
         * @protected
         */
        _onClickToday: function(event) {
            var instance = this,
                activeView = instance.get(ACTIVE_VIEW);

            if (activeView) {
                instance.set(DATE, instance.get(TODAY_DATE));
            }

            event.preventDefault();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onClickNextIcon
         * @param event
         * @protected
         */
        _onClickNextIcon: function(event) {
            var instance = this,
                activeView = instance.get(ACTIVE_VIEW);

            if (activeView) {
                instance.set(DATE, activeView.get(NEXT_DATE));
            }

            event.preventDefault();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onClickPrevIcon
         * @param event
         * @protected
         */
        _onClickPrevIcon: function(event) {
            var instance = this,
                activeView = instance.get(ACTIVE_VIEW);

            if (activeView) {
                instance.set(DATE, activeView.get(PREV_DATE));
            }

            event.preventDefault();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _onButtonGroupSelectionChange
         * @param event
         * @protected
         */
        _onButtonGroupSelectionChange: function(event) {
            var instance = this,
                viewName = event.originEvent.target.attr(DATA_VIEW_NAME);

            instance.set(ACTIVE_VIEW, instance.getViewByName(viewName));

            event.preventDefault();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _processTemplate
         * @param tpl
         * @protected
         */
        _processTemplate: function(tpl) {
            var instance = this;

            return Lang.sub(tpl, instance.getStrings());
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _setEventRecorder
         * @param val
         * @protected
         */
        _setEventRecorder: function(val) {
            var instance = this;

            if (val) {
                val.setAttrs({
                    scheduler: instance
                }, {
                    silent: true
                });

                val.addTarget(instance);
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _setViews
         * @param val
         * @protected
         */
        _setViews: function(val) {
            var instance = this;
            var views = [];

            A.Array.each(val, function(view) {
                if (isSchedulerView(view) && !view.get(RENDERED)) {
                    view.setAttrs({
                        scheduler: instance
                    });

                    views.push(view);

                    instance[VIEW_STACK][view.get(NAME)] = view;
                }
            });

            if (!instance.get(ACTIVE_VIEW)) {
                instance.set(ACTIVE_VIEW, val[0]);
            }

            return views;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetActiveView
         * @param val
         * @protected
         */
        _uiSetActiveView: function(val) {
            var instance = this;

            if (val) {
                var activeView = val.get(NAME),
                    activeNav = instance[VIEWS_NODE].one(_DOT + CSS_SCHEDULER_VIEW_ + activeView);

                if (activeNav) {
                    instance[VIEWS_NODE].all(BUTTON).removeClass(CSS_SCHEDULER_VIEW_SELECTED);
                    activeNav.addClass(CSS_SCHEDULER_VIEW_SELECTED);
                }
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetDate
         * @param val
         * @protected
         */
        _uiSetDate: function(val) {
            var instance = this;

            var formatter = instance.get(NAVIGATION_DATE_FORMATTER);
            var navigationTitle = formatter.call(instance, val);

            if (instance.get(RENDERED)) {
                var activeView = instance.get(ACTIVE_VIEW);

                if (activeView) {
                    activeView._uiSetDate(val);

                    formatter = activeView.get(NAVIGATION_DATE_FORMATTER);
                    navigationTitle = formatter.call(activeView, val);
                }

                instance[VIEW_DATE_NODE].html(navigationTitle);

                instance.syncEventsUI();
            }
        }
    }
});

A.Scheduler = SchedulerBase;
/**
 * The Scheduler Component
 *
 * @module aui-scheduler
 * @submodule aui-scheduler-base-view
 */

/**
 * A base class for SchedulerView.
 *
 * @class A.SchedulerView
 * @extends A.Component
 * @param config {Object} Object literal specifying widget configuration properties.
 * @constructor
 */
var SchedulerView = A.Component.create({

    /**
     * Static property provides a string to identify the class.
     *
     * @property SchedulerView.NAME
     * @type String
     * @static
     */
    NAME: SCHEDULER_VIEW,

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @property SchedulerView.AUGMENTS
     * @type Array
     * @static
     */
    AUGMENTS: [A.WidgetStdMod],

    /**
     * Static property used to define the default attribute
     * configuration for the SchedulerView.
     *
     * @property SchedulerView.ATTRS
     * @type Object
     * @static
     */
    ATTRS: {

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute bodyContent
         * @default ''
         * @type String
         */
        bodyContent: {
            value: _EMPTY_STR
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute filterFn
         */
        filterFn: {
            validator: isFunction,
            value: function(evt) {
                return true;
            }
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute height
         * @default 600
         * @type Number
         */
        height: {
            value: 600
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute isoTime
         * @default false
         * @type Boolean
         */
        isoTime: {
            value: false,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute name
         * @default ''
         * @type String
         */
        name: {
            value: _EMPTY_STR,
            validator: isString
        },

        /**
         * The function to format the navigation header date.
         *
         * @attribute navigationDateFormatter
         * @default %A - %d %b %Y
         * @type Function
         */
        navigationDateFormatter: {
            value: function(date) {
                var instance = this;
                var scheduler = instance.get(SCHEDULER);

                return A.DataType.Date.format(date, {
                    format: '%A, %d %B, %Y',
                    locale: scheduler.get(LOCALE)
                });
            },
            validator: isFunction
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute nextDate
         * @readOnly
         */
        nextDate: {
            getter: 'getNextDate',
            readOnly: true
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute prevDate
         * @readOnly
         */
        prevDate: {
            getter: 'getPrevDate',
            readOnly: true
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute scheduler
         */
        scheduler: {
            lazyAdd: false,
            setter: '_setScheduler'
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute scrollable
         * @default true
         * @type Boolean
         */
        scrollable: {
            value: true,
            validator: isBoolean
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute triggerNode
         */
        triggerNode: {
            setter: A.one
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @attribute visible
         * @default false
         * @type Boolean
         */
        visible: {
            value: false
        }
    },

    /**
     * TODO. Wanna help? Please send a Pull Request.
     *
     * @property SchedulerView.BIND_UI_ATTRS
     * @type Array
     * @static
     */
    BIND_UI_ATTRS: [SCROLLABLE],

    prototype: {

        /**
         * Construction logic executed during SchedulerView instantiation. Lifecycle.
         *
         * @method initializer
         * @protected
         */
        initializer: function() {
            var instance = this;

            instance.after('render', instance._afterRender);
        },

        /**
         * Sync the SchedulerView UI. Lifecycle.
         *
         * @method syncUI
         * @protected
         */
        syncUI: function() {
            var instance = this;

            instance.syncStdContent();
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getAdjustedViewDate
         * @param val
         */
        getAdjustedViewDate: function(val) {
            var instance = this;

            return DateMath.toMidnight(val);
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method flushViewCache
         */
        flushViewCache: function() {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getNextDate
         */
        getNextDate: function() {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getPrevDate
         */
        getPrevDate: function() {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method getToday
         */
        getToday: function() {
            return DateMath.clearTime(new Date());
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method limitDate
         * @param date
         * @param maxDate
         */
        limitDate: function(date, maxDate) {
            var instance = this;

            if (DateMath.after(date, maxDate)) {
                date = DateMath.clone(maxDate);
            }

            return date;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method plotEvents
         */
        plotEvents: function() {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method syncStdContent
         */
        syncStdContent: function() {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method syncEventUI
         * @param evt
         */
        syncEventUI: function(evt) {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetDate
         * @param val
         * @protected
         */
        _uiSetDate: function(val) {},

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _afterRender
         * @param event
         * @protected
         */
        _afterRender: function(event) {
            var instance = this;
            var scheduler = instance.get(SCHEDULER);

            instance._uiSetScrollable(
                instance.get(SCROLLABLE)
            );
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _setScheduler
         * @param val
         * @protected
         */
        _setScheduler: function(val) {
            var instance = this;
            var scheduler = instance.get(SCHEDULER);

            if (scheduler) {
                instance.removeTarget(scheduler);
            }

            if (val) {
                instance.addTarget(val);

                val.after(['*:add', '*:remove', '*:reset'], A.bind(instance.flushViewCache, instance));
            }

            return val;
        },

        /**
         * TODO. Wanna help? Please send a Pull Request.
         *
         * @method _uiSetScrollable
         * @param val
         * @protected
         */
        _uiSetScrollable: function(val) {
            var instance = this;
            var bodyNode = instance.bodyNode;

            if (bodyNode) {
                bodyNode.toggleClass(CSS_SCHEDULER_VIEW_SCROLLABLE, val);
                bodyNode.toggleClass(CSS_SCHEDULER_VIEW_NOSCROLL, !val);
            }
        }
    }
});

A.SchedulerView = SchedulerView;


}, '2.0.0', {
    "requires": [
        "model",
        "model-list",
        "widget-stdmod",
        "color-hsl",
        "aui-event-base",
        "aui-node-base",
        "aui-component",
        "aui-datatype",
        "aui-button"
    ],
    "skinnable": true
});

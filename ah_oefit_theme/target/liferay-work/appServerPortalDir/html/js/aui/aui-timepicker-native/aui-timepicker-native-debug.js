YUI.add('aui-timepicker-native', function (A, NAME) {

var Lang = A.Lang,

    TIME = 'time';

function TimePickerNativeBase() {}

TimePickerNativeBase.ATTRS = {
    nativeMask: {
        validator: Lang.isString,
        value: '%H:%M'
    },

    nativeType: {
        validator: Lang.isString,
        value: TIME
    }
};

A.TimePickerNativeBase = TimePickerNativeBase;

A.TimePickerNative = A.Base.create('timepicker-native', A.Base, [A.DatePickerDelegate, A.DatePickerNativeBase, A.TimePickerNativeBase]);


}, '2.0.0', {"requires": ["base", "base-build", "aui-node-base", "aui-datepicker-delegate", "aui-datepicker-native"]});

// For details about this file see: LPS-2155

// LPS-5741

Liferay.namespace('Util');

Liferay.Util.checkMaxLength = function(box, maxLength) {
	if ((box.value.length) >= maxLength) {
		box.value = box.value.substring(0, maxLength - 1);
	}
};

// LPS-5802

Liferay.namespace('Events');

Liferay.bind = Liferay.on;
Liferay.trigger = Liferay.fire;
Liferay.unbind = Liferay.detach;

Liferay.Events.on = Liferay.on;
Liferay.Events.trigger = Liferay.fire;
Liferay.Events.unbind = Liferay.detach;

// LPS-6237

Liferay.Popup = function(){};
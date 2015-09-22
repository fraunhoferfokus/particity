/*
 * init date/time picker in forms
 */

YUI().use('aui-datepicker', function(Y) {
	new Y.DatePicker({
		trigger : '.datepicker',
		mask : '%d.%m.%Y',
		popover : {
			zIndex : 1
		},
	});
});

YUI().use('aui-timepicker', function(Y) {
	new Y.TimePicker({
		trigger : '.timepicker',
		mask : '%H:%M',
		popover : {
			zIndex : 1
		},
	});
});

var map = null;
var marker = [];
var geocoder = null;
var geocontrol = null;
var markerbase = null;
var markerobj = [];
var searchData = {};
var selectedItems = [];
var selectedTypes = [];

function resetMarkers() {
	markerobj = [];
	marker = [];
}

function setMarkerBase(base) {
	markerbase = base;
}

function initSearchMap(elem) {
	if (elem != null && elem.length > 0) {

		console.log("Map init ...");
		map = L.map(elem.attr("id"), {
			center : [ 0, 0 ], // TODO: get from config
			zoom : 13,
			dragging : false,
			touchZoom : false,
			keyboard : false,
			scrollWheelZoom : false,
			doubleClickZoom : false,
			boxZoom : false,
			tap : false,
			zoomControl : false,
			attributionControl : false
		});

		console.log("Map tiles init ...");
		L
				.tileLayer(
						'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
						{
							attribution : '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
						}).addTo(map);

		map.on('locationerror', function() {
			console.log("browser-geolocation NOT found!")
		});

		map.on('locationfound', function(e) {
			mapview = true;
			console.log("browser-geolocation found!")
			map.panTo(e.latlng);
		});

		// map.locate();
		var count = 0;
		for (var i = 0; i < marker.length; i++) {
			count = marker[i].cnt;
			if (count == null)
				count = i + 1;
			addMarkerToMap(marker[i].lat, marker[i].lng, count);
		}

		var group = new L.featureGroup(markerobj);
		map.fitBounds(group.getBounds());
	}
}

function initOfferMap(elem) {

	if (elem != null && elem.length > 0) {

		console.log("Map init ...");
		map = L.map(elem.attr("id"), {
			center : [ 0, 0 ], // TODO: get from config
			zoom : 13,
			dragging : false,
			touchZoom : false,
			keyboard : false,
			scrollWheelZoom : false,
			doubleClickZoom : false,
			boxZoom : false,
			tap : false,
			zoomControl : false,
			attributionControl : false
		});

		console.log("Map tiles init ...");
		L
				.tileLayer(
						'http://{s}.tile.osm.org/{z}/{x}/{y}.png',
						{
							attribution : '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
						}).addTo(map);
		console.log("Map geocoder init ...");
		// var geocoder = L.Control.geocoder().addTo(map);
		geocoder = L.Control.Geocoder.nominatim({
			limit : 1,
			countrycodes : "de" // TODO: configure
		}), geocontrol = L.Control.geocoder({
			geocoder : geocoder
		})
		geocontrol.markGeocode = function(result) {
			console.log("markgeocode::start");
			customMarker(result);
			console.log("markgeocode::end")
		};

		map.on('locationerror', function() {
		});

		var customMarker = function(result) {
			console.log("customMarker::start");
			if (result != null && result.length > 0) {
				result = result[0];
				console.log("lat: " + result.center.lat + ", lon: "
						+ result.center.lng)
				if (markerobj.length == 0) {
					addMarkerToMap(result.center.lat, result.center.lng, 1);
				} else {
					markerobj[0].setLatLng(result.center);
					markerobj[0].update();
				}
				map.panTo(result.center);
				$("input[id='addrLat']").val(result.center.lat);
				$("input[id='addrLon']").val(result.center.lng);
			}
			console.log("customMarker::end");
		}

		function checkAddr() {
			var zip = $("input[id='regionZip']").val();
			var city = $("input[id='regionCity']").val();
			var countryElem = $("select[id='regionCountry']");
			var country = "";
			/*
			 * if (countryElem.length == 0) countryElem = $(
			 * "input[id='regionCountry']" ); var country = countryElem.val();
			 */
			var street = $("input[id='addrStreet']").val();
			var num = $("input[id='addrNum']").val();
			if (zip == null)
				zip = "";
			if (city == null)
				city = "";
			if (country == null)
				country = "";
			if (street == null)
				street = "";
			if (num == null)
				num = "";
			var query = street + " " + num + ", " + zip + " " + city + ", "
					+ country;
			var cmpQuery = "Weg 1, 00000 Ort";
			if (query.length > cmpQuery.length) {
				console.log("Searching for " + query);
				geocoder.geocode(query, customMarker);
			} else {
				console.log("Skipping short query " + query);
			}
		}

		$("input[id='regionZip']").change(function() {
			checkAddr();
		});
		$("input[id='regionCity']").change(function() {
			checkAddr();
		});
		$("input[id='regionCountry']").change(function() {
			checkAddr();
		});
		$("input[id='addrStreet']").change(function() {
			checkAddr();
		});
		$("input[id='addrNum']").change(function() {
			checkAddr();
		});

		// if disabled, show existing location
		if ($('input[id="regionZip"]').is(':disabled')) {
			console.log("disabled view, looking up coordinates")
			var lat = $("input[id='addrLat']").val();
			var lon = $("input[id='addrLon']").val();
			if (lat != null && lat.length > 0 && lon != null && lon.length > 0) {
				var result = [];
				result.push({
					center : {
						lat : lat,
						lng : lon
					}
				});
				customMarker(result);
			} else {
				setTimeout(checkAddr, 2000);
			}
		} else if (marker.length > 0) {
			console.log("got preconfigured marker, adding to map ...")
			var result = [];
			result.push({
				center : {
					lat : marker[0].lat,
					lng : marker[0].lng
				}
			});
			customMarker(result);
		} else {
			console.log("not using any markers yet ...")
		}

	}
}

function initMapDefaults() {
	L.NumberedDivIcon = L.Icon.extend({
		options : {
			iconUrl : 'images/marker_hole.png',
			number : '',
			shadowUrl : null,
			iconSize : new L.Point(25, 41),
			iconAnchor : new L.Point(13, 41),
			popupAnchor : new L.Point(0, -33),
			/*
			 * iconAnchor: (Point) popupAnchor: (Point)
			 */
			className : 'leaflet-div-icon'
		},

		createIcon : function() {
			var div = document.createElement('div');
			var img = this._createImg(this.options['iconUrl']);
			var numdiv = document.createElement('div');
			numdiv.setAttribute("class", "number");
			numdiv.innerHTML = this.options['number'] || '';
			div.appendChild(img);
			div.appendChild(numdiv);
			this._setIconStyles(div, 'icon');
			return div;
		},

		// you could change this to add a shadow like in the normal marker if
		// you really wanted
		createShadow : function() {
			return null;
		}
	});
}

function createMarkerIcon(number) {
	var div = document.createElement('div');
	div.setAttribute("class", "leaflet-marker-icon leaflet-div-icon");
	var img = document.createElement('img');
	img.setAttribute('src', markerbase + "/images/marker_hole.png");
	var numdiv = document.createElement('div');
	numdiv.setAttribute("class", "number");
	numdiv.innerHTML = number;
	div.appendChild(img);
	div.appendChild(numdiv);
	return div;
}

function initMap() {
	if (typeof L != "undefined") {
		initMapDefaults();
		initOfferMap($("#offerMap"));
		initSearchMap($("#searchMap"));
	}

}

function addMarkerToArray(lat, lng, count) {

	marker.push({
		lat : lat,
		lng : lng,
		cnt : count
	});
	if (count != undefined)
		return createMarkerIcon(count);
}

function addMarkerToMap(lat, lng, i) {

	var marker = new L.Marker(new L.LatLng(lat, lng), {
		icon : new L.NumberedDivIcon({
			number : i,
			iconUrl : markerbase + "/images/marker_hole.png"
		}),
	});
	marker.on('click', function() {
		// showModal(i);
		console.log("Klick on marker " + i);
		$("#offerdetails" + i).click();
	})
	marker.addTo(map);
	markerobj.push(marker);
}

$(function() {
	// disable search button, when JS is used
	$("#searchForm button").hide();
	$('[data-toggle="tooltip"]').tooltip()

	transformCheckBoxes();
	initMap();
})

function transformCheckBoxes() {
	$(".checkbox").addClass("js");
	$(".checkbox input[type=checkbox][checked]").each(function() {
		$(this).parent().parent().toggleClass("active");
	})

	$(".checkbox input[type=checkbox]").each(function() {
		var that = $(this);
		var label = that.parent();
		var root = label.parent();
		if (!that.is('[readonly="true"]')) {
			root.unbind("click");
			root.on("click", function(event) {
				event.stopPropagation();
				event.preventDefault();
				root.toggleClass("active");
				that.prop("checked", !that.prop("checked"));
				that.change();
				if (root.hasClass("search")) {
					toggleButton(that.val());
				}
			});
		} else if (!$(this).is(":checked")) {
			root.remove();
		}
	});

	$("#searchForm .list-group-item.search input").change(function() {
		toggleButton($(this).val());
	});
}

function toggleButton(val) {
	var found = false;
	//console.log("Looking up selection " + val);
	
	var cb = $("#searchForm input[value=" + val + "]");
	var type = cb.attr("name");
	var selectedArr = null;;
	if (type == "items") {
		selectedArr = selectedItems;
	} else if (type == "types") {
		selectedArr = selectedTypes;
	}
	
	if (selectedArr != null) {
		selectedArr = jQuery.grep(selectedArr, function(value) {
			if (value == val) {
				console.log("Removing selection for " + val+" in "+type);
				found = true;
				var cb = $("#searchForm input[value=" + val + "]");
				var filterelem = $(".searchfilter #label" + val);
				if (filterelem.length != 0) {
					filterelem.remove();
					if (cb.prop("checked"))
						cb.removeProp("checked");
				}
	
			}
			return value != val;
		});
		if (!found) {
			console.log("Adding selection for " + val+" in "+type);
			var filterelem = $(".searchfilter");
			if (filterelem.length != 0) {
				var cb = $("#searchForm input[value=" + val + "]");
				if (cb.length != 0) {
					var cblabel = cb.parent().text();
					if (!cb.prop("checked"))
						cb.prop("checked", true);
					filterelem.prepend("<div class='filterlabel' id='label" + val
							+ "'><span aria-hidden='true' class='glyphicon glyphicon-remove' onclick='toggleButton("
							+ val + ")'></span>" + cblabel + "</div>");
				}
			}
			selectedArr.push(val);
		}
		
		if (type == "items") {
			selectedItems = selectedArr;
		} else if (type == "types") {
			selectedTypes = selectedArr;
		}
		search();
	} else {
		console.log("Found no search type for checkbox with name "+type)
	}
}

function setSearchData(data) {
	searchData = data;
}

function setSelectedTypes(arr) {
	selectedTypes = arr;
}

function setSelectedItems(arr) {
	selectedItems = arr;
}

function search() {
	searchData["items"] = selectedItems.join();
	searchData["types"] = selectedTypes.join();
	$.ajax({
		type : "GET",
		async : false,
		url : "/adhocdata-portlet/pages/search/searchresults.jsp",
		data : searchData,
		success : function(data) {
			// resetMarkers();
			$(".resultset").empty();
			$(".resultset").html(data);
			// initMap();
		},
		dataType : "html"
	});
}

function searchPagination(skipSize) {
	searchData["resultSkip"] = skipSize;
	try {
		search();
	} catch (e) {
		console.log("Error in search: " + e);
	}
	return false;
}
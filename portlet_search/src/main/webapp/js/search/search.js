var modals = new Object();
var texts = new Object();
var mapUrl = "http://{s}.tile.osm.org/{z}/{x}/{y}.png";
var mapAttrib = "&copy; <a href=\"http://osm.org/copyright\">OpenStreetMap</a> contributors";
var mapId = "";
var mapAt = "";

function setMapData(opts) {
	if (opts != null) {
		if (opts.url != null && opts.url.length > 0) {
			mapUrl = opts.url;
		}
		if (opts.attrib != null && opts.attrib.length > 0) {
			mapAttrib = opts.attrib;
		}
		if (opts.id != null && opts.id.length > 0) {
			mapId = opts.id;
		}
		if (opts.at != null && opts.at.length > 0) {
			mapAt = opts.at;
		}
	}
}

L.NumberedDivIcon = L.Icon.extend({
	options: {
    iconUrl: 'images/marker_hole.png',
    number: '',
    shadowUrl: null,
    iconSize: new L.Point(25, 41),
		iconAnchor: new L.Point(13, 41),
		popupAnchor: new L.Point(0, -33),
		/*
		iconAnchor: (Point)
		popupAnchor: (Point)
		*/
		className: 'leaflet-div-icon'
	},
 
	createIcon: function () {
		var div = document.createElement('div');
		var img = this._createImg(this.options['iconUrl']);
		var numdiv = document.createElement('div');
		numdiv.setAttribute ( "class", "number" );
		numdiv.innerHTML = this.options['number'] || '';
		div.appendChild ( img );
		div.appendChild ( numdiv );
		this._setIconStyles(div, 'icon');
		return div;
	},
 
	//you could change this to add a shadow like in the normal marker if you really wanted
	createShadow: function () {
		return null;
	}
});

function setText(id,value) {
	texts[id] = value;
}

function addModal(modalid,detailid,count, maxcount) {
	
	var id = modalid+count;
	var elem = $(id);
	
	var footer = [];
	var header = [];
	if (count > 0) {
		header.push({
            label: texts["search.modal.prev"],
            icon: 'glyphicon glyphicon-chevron-left',
        	on: {
                click: function() {
                  hideModal(modalid,count);
                  showModal(modalid,detailid,(count-1))
                }
              }
          });
	}
	if (count < maxcount-1) {
		header.push({
            label: texts["search.modal.next"],
            icon: 'glyphicon glyphicon-chevron-right',
        	on: {
                click: function() {
                  hideModal(modalid,count);
                  showModal(modalid,detailid,(count+1))
                }
              }
          });
	}
	
	footer.push({
        label: texts["search.modal.close"],
        icon: 'glyphicon glyphicon-remove',
    	on: {
            click: function() {
              hideModal(modalid,count);
            }
          }
      });
	
	if (elem != null && elem.length > 0) {
		
		var body = elem.html();
		//console.log("Got modal body "+body);
		elem.empty();
		elem.show();
		
		YUI().use(
		  'aui-modal',
		  function(Y) {
		    modals[id] = new Y.Modal(
		      {
		    	//headerContent: '<div class="shariff" data-services="[&quot;facebook&quot;,&quot;googleplus&quot;,&quot;twitter&quot;]" data-url="'+permalink+'" ></div>',
		        bodyContent: body,
		        centered: true,
		        destroyOnHide: false,
		        draggable: false,
		        resizable: false,
		        modal: true,
		        focused: true,
		        visible: false,
		        width: "80%",
		        height: "80%",
		        render: id,
		        toolbars: {
		        	header: header,
		            footer: footer
		          }
		      }
		    );
		    //console.log("Stored modal with id "+id);
		    showModal(modalid,detailid,count);
		  }
		);
		//validateModal(modals[id]);
		//console.log("Modal "+id+" initialized!");
		//$(id+" .modal-body").scrollTop(0);
		
	}
}

function validateModal(modal) {
	if (modal != null) {
		var h = $(window).height();
		var w = $(window).width();
		
		if (h < 600 || w < 400) {
			//console.log("Changing modal size due to window size being "+w+"x"+h)	
			modal.set("height","100%");
			modal.set("width","100%");
		} //else
			//console.log("Window size is "+w+"x"+h)
	}
}

function showModal(modalid,detailid,count) {
	var id = modalid+count;
	var modal = modals[id];
	if (modal != null) {
		validateModal(modal);
		modal.show();
		console.log("Modal "+id+" shown!");
	} else {
		$(detailid+count).click();
		//console.log("Modal "+id+" unknown!");
	}
	$(id+" .modal-body").scrollTop(0);
}

function hideModal(modalid,count) {
	var id = modalid+count;
	var modal = modals[id];
	if (modal != null) {
		modal.hide();
		console.log("Modal "+id+" hidden!");
	} else {
		console.log("Modal "+id+" unknown!");
	}
}

function enableModalShariff(id, infoUrl) {
	//var id = "#modal"+count;
	if (typeof Shariff == 'function') {
		var mheader = $(id+' .shariff');
		if (mheader.length == 0 || mheader[0] == null)
			console.log("Did not find header at >"+id+' .shariff<');
		else {
			
			if (infoUrl != null) {
				console.log("Enabling shariff in modal headers >"+id+" .shariff< with classes "+mheader.attr("class")+" for url "+infoUrl);
				new Shariff(mheader, {
				    services: ["facebook", "googleplus","twitter"],
				    url: infoUrl
				});
			} else {
				console.log("Enabling shariff in modal headers >"+id+" .shariff< with classes "+mheader.attr("class"));
				new Shariff(mheader);
			}
		}
	} else {
		console.log("Shariff is not defined!")
	}
}

function enableModalShariffByElem(elem) {
	if (typeof Shariff == 'function') {
		if (elem.length == 0)
			console.log("Did not find shariff elem!");
		else {
			console.log("Enabling shariff");
			Shariff(elem);
		}
	} else {
		console.log("Shariff is not defined!")
	}
}

function loadModal(modalid,orgUrl, offerUrl, count, offerId) {
	var elem = $(modalid+count)
	$.ajax({
	      type: "GET",
	      async: false,
	      url: "/pasearch-portlet/pages/search/searchresult.jsp",
	      data: {
	        "offerId" : offerId,
	        "modal" : true,
	        "orgUrl" : orgUrl,
	        "offerUrl" : offerUrl
	      },
	      success: function(data) {
	        elem.empty();
	        //console.log("Got data "+data);
	        elem.html(data);
	      },
	      dataType: "html"
	    });
}

 function triggerModal(modalid,detailid,orgUrl, offerUrl, count, offerId, maxcount) {
	 console.log("Triggering modal "+modalid+count);
	 var modalelem = $(modalid+count);
	 if (modalelem.children().length == 0) {
		 loadModal(modalid,orgUrl, offerUrl, count,offerId);
		 addModal(modalid, detailid, count, maxcount);
	 } else {
		 showModal(modalid,detailid,count);
	 }
	 return false;
 }
 
 function addSearchMap(mapid, detailid, i, lat, lng) {
	 var elem = $(mapid+i);
	 if (elem != null && elem.length > 0) {
	
		 console.log("Map init ...");
		 map = L.map(elem.attr("id"),{
		   center: [lat,lng], // TODO: get from config
		   zoom: 13,
		   dragging: false,
		   touchZoom: false,
		   keyboard: false,
		   scrollWheelZoom: false,
		   doubleClickZoom: false,
		   boxZoom: false,
		   tap: false,
		   zoomControl: false,
		   attributionControl: true
		 });
	

		 L.tileLayer(mapUrl, {
		     attribution: mapAttrib,
		     id: mapId,
		 	 accessToken: mapAt
		 }).addTo(map);
		 
		 
		 map.on('locationfound', function(e) {
			 mapview = true;
			 console.log("browser-geolocation found!")
			    map.panTo(e.latlng);
		 });
		 
		
		 var marker = new L.Marker(new L.LatLng(lat, lng), {
			    icon:	new L.NumberedDivIcon({number: i,
			    iconUrl: markerbase+"/images/marker_hole.png"}),
			});
		 
		
		/*marker.on('click',function() {
			//showModal(i);
			console.log("Klick on marker "+i);
			$("#offerdetails"+(i-1)).click();
		})*/
		
		map.on('click',function() {
			//showModal(i);
			console.log("Click on map "+i);
			$(detailid+(i-1)).click();
		})
		marker.addTo(map);
		
	 }
	 return createMarkerIcon(i);
}

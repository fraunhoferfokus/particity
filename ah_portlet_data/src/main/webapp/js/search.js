var modals = new Object();
var texts = new Object();

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

function addModal(count, maxcount) {
	
	var id = "#modal"+count;
	var elem = $(id);
	
	var footer = [];
	var header = [];
	if (count > 0) {
		header.push({
            label: texts["search.modal.prev"],
            icon: 'glyphicon glyphicon-chevron-left',
        	on: {
                click: function() {
                  hideModal(count);
                  showModal((count-1))
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
                  hideModal(count);
                  showModal((count+1))
                }
              }
          });
	}
	
	footer.push({
        label: texts["search.modal.close"],
        icon: 'glyphicon glyphicon-remove',
    	on: {
            click: function() {
              hideModal(count);
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
		        width: "80%",
		        height: "80%",
		        render: id,
		        toolbars: {
		        	header: header,
		            footer: footer
		          }
		      }
		    );
		  }
		);
		console.log("Modal "+id+" initialized!");
		$(id+" .modal-body").scrollTop(0);
	}
}

function showModal(count) {
	var id = "#modal"+count;
	var modal = modals[id];
	if (modal != null) {
		modal.show();
		console.log("Modal "+id+" shown!");
	} else {
		$("#offerdetails"+count).click();
		//console.log("Modal "+id+" unknown!");
	}
	$(id+" .modal-body").scrollTop(0);
}

function hideModal(count) {
	var id = "#modal"+count;
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

function loadModal(orgUrl, offerUrl, count, offerId) {
	var elem = $('#modal'+count)
	$.ajax({
	      type: "GET",
	      async: false,
	      url: "/adhocdata-portlet/pages/search/searchresult.jsp",
	      data: {
	        "offerId" : offerId,
	        "modal" : true,
	        "orgUrl" : orgUrl,
	        "offerUrl" : offerUrl
	      },
	      success: function(data) {
	        elem.empty();
	        elem.html(data);
	      },
	      dataType: "html"
	    });
}

 function triggerModal(orgUrl, offerUrl, count, offerId, maxcount) {
	 console.log("Triggering modal #modal"+count);
	 var modalelem = $("#modal"+count);
	 if (modalelem.children().length == 0) {
		 loadModal(orgUrl, offerUrl, count,offerId);
		 addModal(count, maxcount);
	 } else {
		 showModal(count);
	 }
	 return false;
 }
 
 function addSearchMap(i, lat, lng) {
	 var elem = $("#offermap"+i);
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
		   attributionControl: false
		 });
	

		 L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
		     attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
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
			$("#offerdetails"+(i-1)).click();
		})
		marker.addTo(map);
		
	 }
	 return createMarkerIcon(i);
}

function createModal(id, headerMsg, bodyMsg, closeMsg, okMsg, okUrl) {
	var modal = null;
	YUI().use(
	  'aui-modal',
	  function(Y) {
	    modal = new Y.Modal(
	      {
	    	headerContent: headerMsg,
	        bodyContent: bodyMsg,
	        centered: true,
	        destroyOnHide: true,
	        draggable: false,
	        resizable: false,
	        modal: true,
	        focused: true,
	        //width: "80%",
	        //height: "80%",
	        render: id,
	        toolbars: {
	            footer: [
                 {
			        label: closeMsg,
			        icon: 'glyphicon glyphicon-remove',
			    	on: {
			            click: function() {
			              modal.hide();
			            }
			          }
			      },
			      {
				        label: okMsg,
				        icon: 'glyphicon glyphicon-ok',
				    	on: {
				            click: function() {
				              window.location = okUrl;
				            }
				          }
				      }
                 ]
	          }
	      }
	    ).render();
	  }
	);
}

$(function() {
	 var elem = $("#databaseImport");
	 if (elem.length > 0) {
		    elem.fileinput({
		    	//uploadUrl: elem.data("url"),
		        //uploadAsync: true,
		        maxFileCount: 1,
		        browseClass: "btn btn-default",
		        browseLabel: elem.data("browsetext"),
		        browseIcon: "<i class=\"glyphicon glyphicon-open\"></i> ",
		        removeClass: "btn btn-default",
		        removeLabel: elem.data("deletetext"),
		        removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
		        uploadClass: "btn btn-success",
		        uploadLabel: elem.data("uploadtext"),
		        uploadIcon: "<i class=\"glyphicon glyphicon-transfer\"></i> "
		    });
	 }
	  
})
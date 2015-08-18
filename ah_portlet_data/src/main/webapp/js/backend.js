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
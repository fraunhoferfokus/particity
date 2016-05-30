$(function () {
  $('[data-toggle="tooltip"]').tooltip()
})

// ignore enter on text-inputs? Not globally!
function stopRKey(evt) { 
  var evt = (evt) ? evt : ((event) ? event : null); 
  var node = (evt.target) ? evt.target : ((evt.srcElement) ? evt.srcElement : null); 
  if ((evt.keyCode == 13) && (node.type=="text"))  {return false;} 
} 

document.onkeypress = stopRKey; 

//initilalize WYSIWYG-editor where requested
$(".wysiwyg").each(function() {
	CKEDITOR.replace( this, {
		// Define the toolbar groups as it is a more accessible solution.
		toolbarGroups: [
			{"name":"basicstyles","groups":["basicstyles"]},
			{"name":"paragraph","groups":["list","blocks"]},
			{"name":"document","groups":["mode"]},
			{"name":"styles","groups":["styles"]},
		]
	}  );
})
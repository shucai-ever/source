/**
 * 
 */
function CsrfToken(){
			 var token = $("meta[name='_csrf']").attr("content");
		     var header = $("meta[name='_csrf_header']").attr("content");
		     $.ajaxSetup({
		          beforeSend: function (xhr) {
		           if(header && token ){
		               xhr.setRequestHeader(header, token);
		           }
		      }
		   });
	   }
(function(){
	new CsrfToken();
})()
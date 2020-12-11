$(function() {
	
	$('#chatingFrm').submit( function( e ) {
		var frm = $("#chatingFrm");
	
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Chatting", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				getPage("/message?wuid="+data.wuid);
				}else{
				toastr.warning(data.message,"Chatting", {
					closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
				});
				}
				
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
});


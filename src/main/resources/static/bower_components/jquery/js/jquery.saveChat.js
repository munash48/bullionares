$(function() {
	alert("inside saveChat");

	$('#articleFrm')
	.submit( function( e ) {
		var frm = $("#articleFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				getPage("/mainpost");
				
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
	$('#OpinionFrm')
	.submit( function( e ) {
		var frm = $("#OpinionFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				getPage("/mainpost");
				
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
	$('#chatingFrm').submit( function( e ) {
		var frm = $("#chatingFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				getPage("/message?wuid="+data.wuid);
				
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
});


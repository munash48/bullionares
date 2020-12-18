$(function() {
	$("#submitRegForm").submit(function(e) {
		e.preventDefault();
		var frm = $("#submitRegForm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];

		});
		var nurl="/reset?email="+data.email;
		
		saveRequestedData(frm, data,nurl);

	});
	
	$("#resetEmail").submit(function(e) {
		e.preventDefault();
		var frm = $("#submitRegForm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];

		});
		var nurl="/reset?email="+data.email;
		//saveUpdatedResetCode(frm, data,nurl);
		getPage(nurl);

	
});
//	$("#submitPassRest").submit(function(e) {
//		 alert("submit by ajax");
//		e.preventDefault();
//		var frm = $("#submitPassRest");
//		var data = {};
//		$.each(this, function(i, v) {
//			var input = $(v);
//			data[input.attr("name")] = input.val();
//			delete data["undefined"];
//			
//		});
//		
//		var nurl="/?logout=resseted";
//		
//		saveRequestedData(frm, data,nurl);
//		
//		
//	});
	
	$('#submitPassRest')
	.submit( function( e ) {
		var frm = $("#submitPassRest");
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"RESET SUCCESS", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				getPage("/?reset=success");
				
				}else{
				toastr.warning(data.message,"RESET FAILED", {
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

function saveRequestedData(frm, data,nurl){
	$.ajax({
		contentType:"application/json; charset=utf-8",
		type:frm.attr("method"),
		url:frm.attr("action"),
		dataType:'json', 
		data:JSON.stringify(data),
		
		success: function (data) {
			
			if(data.status=="success"){
			toastr.success(data.message,"Registered", {
	    		closeButton: true,
				progressBar: true,
				positionClass:"toast-top-center"
	   	 });
			getPage(nurl);
			
			}else{
				toastr.warning(data.message,"Registration Failed", {
					closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
				});
			}
			
			}
		});
}
//function saveUpdatedResetCode(frm, data,nurl){	
//
//$.ajax({
//	contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
////		 contentType: "application/json",
//	url:frm.attr("action"),
//	type:frm.attr("method"),
//	data: {
//		"email": email
//	},
//	success: function(response){
//		
//		alert(data.message);
//		getPage(nurl);
//		
//	},
//	error:function(response){
//		alert("something went wrong");
//	}
//});
//}		


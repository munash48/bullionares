$(function() {

	
	$("#submitPassRest").submit(function(e) {
		e.preventDefault();
		var frm = $("#submitPassRest");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/?error=reg";
		
		saveUpdatedData(frm, data,nurl);
		
		
	});
	
	$("#resetEmail").submit(function(e) {
		e.preventDefault();
		alert("we are seding the email");
		var frm = $("#resetEmail");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/reset?email="+data.email;
		
		saveUpdatedResetCode(frm, data,nurl);
		
	});

});

function saveUpdatedData(frm, data,nurl){		
		 $.ajax({
			 contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
//			 contentType: "application/json",
			 url:frm.attr("action"),
		     type:frm.attr("method"),
		     data: {
		        "resetcode": resetcode,
		        "password":password,
		        "confirm":confirm
		     },
		     success: function(response){
				
		        alert("sucess");
		        getPage(nurl);

		     },
		     error:function(response){
		         alert("something went wrong");
		     }
		 });
}


function saveUpdatedResetCode(frm, data,nurl){	
	
	$.ajax({
		contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
//			 contentType: "application/json",
		url:frm.attr("action"),
		type:frm.attr("method"),
		data: {
			"email": email
		},
		success: function(response){
			
			alert(data.message);
			getPage(nurl);
			
		},
		error:function(response){
			alert("something went wrong");
		}
	});
}
		


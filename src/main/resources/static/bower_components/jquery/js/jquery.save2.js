$(function() {
	alert("inside save 2");
	
	$("#profileEditFrm").submit(function(e) {
		e.preventDefault();
		alert("submit by jquery");
		var frm = $("#profileEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/profile";
		
		saveUpdatedData(frm, data,nurl);
		
		
	});
	$("#companyEditFrm").submit(function(e) {
		e.preventDefault();
		alert("submit by jquery");
		var frm = $("#companyEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/profile";
		
		saveUpdatedData(frm, data,nurl);
		
		
	});

	
	$("#careerEditFrm").submit(function(e) {
		e.preventDefault();
		alert("submit by jquery");
		var frm = $("#careerEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/profile";
		
		saveUpdatedData(frm, data,nurl);
		
		
	});
	$("#educationEditFrm").submit(function(e) {
		e.preventDefault();
		alert("submit by jquery");
		var frm = $("#educationEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/profile";
		
		saveUpdatedData(frm, data,nurl);
		
		
	});
	
	$("#addressEditFrm").submit(function(e) {
		e.preventDefault();
		alert("submit by jquery");
		var frm = $("#addressEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/profile";
		
		saveUpdatedData(frm, data,nurl);
		
		
	});
	$("#skillEditFrm").submit(function(e) {
		e.preventDefault();
		alert("submit by jquery");
		var frm = $("#skillEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];
			
		});
		
		var nurl="/profile";
		
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
			// contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
		 contentType: "application/json; charset=utf-8",
			 url:frm.attr("action"),
		     type:frm.attr("method"),
		     dataType:'json', 
				data:JSON.stringify(data),
		     success: function(data){
				
		    	 alert(data.message);
		    	 getPage(nurl);
		    	 $('.modal').modal('hide');

		     },
		     error:function(response){
		         alert("something went wrong");
		     }
		 });
}

function saveUpdatedResetCode(frm, data,nurl){		
	 $.ajax({
		 //contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
		 //contentType: "application/json",
		 contentType: "multipart/form-data",
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


$(function() {
	alert("save 2 is active");
	$("#profileEditFrm").submit(function(e) {
		e.preventDefault();
		alert("happeing by jquery");	
		var frm = $("#profileEditFrm");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];

		});	
		
		saveProfileData(frm, data);
	});
	
//	$("#companyEditFrm").submit(function(e) {
//		
//		alert("happeing by jquery");
//		
//		e.preventDefault();
//		var frm = $("#companyEditFrm");
//		var data = {};
//		$.each(this, function(i, v) {
//			var input = $(v);
//			data[input.attr("name")] = input.val();
//			delete data["undefined"];
//			
//		});		
//		saveRequestedData(frm, data,);
//				
//	});
	
});

//function saveProfileData(frm, data){
//	
//	 $.ajax({
//		 contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
////		 contentType: "application/json",
//		 url:frm.attr("action"),
//	     type:frm.attr("method"),
//	     data: {
//	        "id":id,
//	        "firstName":firstName,
//	        "otherNames":otherNames,
//	        "phoneNumber":phoneNumber,
//	        "email":email,
//	        "profession":profession,
//	        "birthDate":birthDate
//	     },
//	     success: function(response){
//			
//	        alert(data.message);
//	        
//	        getHomePage("/profile");
//
//	     },
//	     error:function(response){
//	    	 
//	         alert("something went wrong");
//	     }
//	 });
//}

function saveUpdatedData(frm, data){		
	 $.ajax({
		 contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
//		 contentType: "application/json",
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
		


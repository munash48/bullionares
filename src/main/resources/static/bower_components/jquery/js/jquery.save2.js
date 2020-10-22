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
	

});

function saveUpdatedData(frm, data,nurl){		
		 $.ajax({
			 contentType (default: 'application/x-www-form-urlencoded; charset=UTF-8'),
	//	 contentType: "application/json",
			 url:frm.attr("action"),
		     type:frm.attr("method"),
		     data: {
		        "id": id,
		        "firstName":firstName,
		        "otherNames":otherNames,
		        "phoneNumber":phoneNumber,
		        "email":email,
		        "profession":profession,
		        "birthDate":birthDate
		     },
		     success: function(response){
				
		        alert("sucess");
		        getHomePage(nurl);

		     },
		     error:function(response){
		         alert("something went wrong");
		     }
		 });
}




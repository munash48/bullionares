$(function() {
 alert("inside save");
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
	
});

function saveRequestedData(frm, data,nurl){
	$.ajax({
		contentType:"application/json; charset=utf-8",
		type:frm.attr("method"),
		url:frm.attr("action"),
		dataType:'json', 
		data:JSON.stringify(data),
		
		success: function (data) {
			
			alert(data.message);
			getPage(nurl);
			
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


$(function() {
	alert("save 2 is active");

	$("#profileEditBtn").submit(function(e) {
		
		alert("happeing by jquery");
		e.preventDefault();
		var frm = $("#profileEditBtn");
		var data = {};
		$.each(this, function(i, v) {
			var input = $(v);
			data[input.attr("name")] = input.val();
			delete data["undefined"];

		});
		
		saveRequestedData(frm, data);


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
			
			}
		});
}

		


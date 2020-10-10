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

		


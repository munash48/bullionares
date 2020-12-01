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
	
	$( '#submitEventFrm' )
	  .submit( function( e ) {
		  var frm = $("#submitEventFrm");
		  alert("Submitting by jquery");
	    $.ajax( {
	      url:frm.attr("action"),
		  type:frm.attr("method"),
	      data: new FormData( this ),
	      processData: false,
	      contentType: false,
	      success: function(data){
				
		    	 alert(data.message);
		    	 getPage("/profile");
		    	 $('.modal').modal('hide');

		     },
	      error:function(response){
	    	  
		         alert("Some thing went wrong");
		         
	      }
	    } );
	    e.preventDefault();
	    
	  
	  } );
	$( '#imageEditFrm' )
	.submit( function( e ) {
		var frm = $("#imageEditFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				getPage("/profile");
				$(".Tpoints").html(data.noTVotes);
				$(".VoPoints").html(data.noVotes);
				$(".oldImage").hide();
				$(".newImage").show();
				$(".newImage").html(data.img);
				$(".newpImage").show();
				$(".newpImage").html(data.pimg);
				
				$('.modal').modal('hide');
				
				
			},
			error:function(response){
				
				alert("Some thing went wrong");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	$('#advertEditFrm')
	.submit( function( e ) {
		var frm = $("#advertEditFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				getPage("/profile");
				$('.modal').modal('hide');
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
	$('#jobAddFrm')
	.submit( function( e ) {
		var frm = $("#jobAddFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				getPage("/profile");
				$('.modal').modal('hide');
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
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
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	

//	$('#articleFrm')
//	.submit( function( e ) {
//		var frm = $("#articleFrm");
//		
//		alert("Submitting by jquery");
//		$.ajax( {
//			url:frm.attr("action"),
//			type:frm.attr("method"),
//			data: new FormData( this ),
//			processData: false,
//			contentType: false,
//			success: function(data){
//				
//				alert(data.message);
//				getPage("/mainpost");
//				
//				
//			},
//			error:function(response){
//				
//				alert("ALERT! Fill all fields");
//				
//			}
//		} );
//		e.preventDefault();
//		
//		
//	} );
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
				$(".noOpinions"+data.id).html(data.newOpinion);
				$(".realtimeOpinion").show();
				$(".thisopinion").html(data.opinion);
				document.getElementById("OpinionFrm").reset();
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	$('#addReviewFrm')
	.submit( function( e ) {
		var frm = $("#addReviewFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				$(".noReview"+data.id).html(data.newReview);
				$(".realtimeReview").show();
				$(".thisreview").html(data.review);
				document.getElementById("addReviewFrm").reset();
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	$('#addAnalyisFrm')
	.submit( function( e ) {
		var frm = $("#addAnalyisFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				$(".noAnalysis"+data.id).html(data.newAnaysis);
				$(".realtimeAnalysis").show();
				$(".thisanalysis").html(data.analysis);
				$(".Tpoints").html(data.Tpoints);
				$(".OpPoints").html(data.OpPoints);
				
				document.getElementById("addAnalyisFrm").reset();
			
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	$('#addRecommendFrm')
	.submit( function( e ) {
		var frm = $("#addRecommendFrm");
		
		alert("Submitting by jquery");
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				
				alert(data.message);
				$(".noRecommendations"+data.id).html(data.newRecommendations);
				$(".realtimeRecomm").show();
				$(".thisRecomm").html(data.recommendation);
				document.getElementById("addRecommendFrm").reset();
				
				
			},
			error:function(response){
				
				alert("ALERT! Fill all fields");
				
			}
		} );
		e.preventDefault();
		
		
	} );
	
//	$("#submitEventFrm").submit(function(e) {
//		e.preventDefault();
//		alert("Submitting by jquery");
//		var frm = $("#submitEventFrm");
//		
//		var data: new FormData( this ),
//	      processData: false,
//	      contentType: false
//	    } );
//
//		var nurl="/profile";
//		saveUpdatedWPhoto(frm, data, nurl);
//		
//	});
	

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
		    	 $(".Tpoints").html(data.noTVotes);
		 		$(".VoPoints").html(data.noVotes);
		 		$(".newAbout").html(data.about);
		 		$(".newComp").html(data.newComp);
		 		$(".newAddress").html(data.newAddress);
		 		$(".newSkill").html(data.newSkill);
		 		$(".newEvent").html(data.newEvent);
		 		$(".newJob").html(data.newJob);
		 		$(".newCar").html(data.newCar);
		 		$(".newEduc").html(data.newEduc);
		    	 $('.modal').modal('hide');

		     },
		     error:function(response){
		         alert("something went wrong");
		     }
		 });
}



//function saveUpdatedWPhoto(frm, data, nurl){		
//	 $.ajax({
//		//contentType: "application/json",
//	//		contentType: "application/x-www-form-urlencoded",
//	//	 contentType (default: "application/x-www-form-urlencoded; charset=UTF-8"),
//		 
//		 url:frm.attr("action"),
//	     type:frm.attr("method"),
//	     cache: false,
//	     processData: false,
//	     data: {
//	        "id": id,
//	        "uid":uid,
//	        "ename":ename,
//	        "description":description,
//	        "imageFIile":imageFile,
//	        "eventDate":eventDate
//	        
//	     },
//	     success: function(data){
//			
//	        alert(data.message);
//	        getPage(nurl);
//	        $('.modal').modal('hide');
//
//	     },
//	     error:function(response){
//	         alert("something went wrong");
//	     }
//	 });
//}


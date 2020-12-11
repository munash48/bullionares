$(function() {

	$("#profileEditFrm").submit(function(e) {
		e.preventDefault();
		
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
		  
	    $.ajax( {
	      url:frm.attr("action"),
		  type:frm.attr("method"),
	      data: new FormData( this ),
	      processData: false,
	      contentType: false,
	      success: function(data){
	    	  if(data.status=="success"){
	    	  toastr.success(data.message,"Updated", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
	    		 
	    		getPage("/profile");
		    	 $(".noVotes").html(data.noVotes);
		    	 $(".noTVotes").html(data.noTVotes);
		    	 $(".newEvent").html(data.newEvent);
		    	 if(data.newEventImg!=null){
		    	 $(".newEventImg").html(data.newEventImg);
		    	 }
		    	 $('.modal').modal('hide');
	    	  }else{
		    	 toastr.warning(data.message,"Failed", {
		    		 closeButton: true,
		    		 progressBar: true,
		    		 positionClass:"toast-top-center"
		    	 });
		    	 
	    	  }

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
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Image Uploaded", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				getPage("/profile");
				$(".Tpoints").html(data.noTVotes);
				$(".VoPoints").html(data.noVotes);
				$(".oldImage").hide();
				$(".newImage").show();
				$(".newImage").html(data.img);
				$(".newpImage").show();
				$(".newpImage").html(data.pimg);
				
				$('.modal').modal('hide');
				}else{
				toastr.warning(data.message,"Image Upload Failed", {
					closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
				});
				}
				
				
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
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Advert Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				getPage("/profile");
				$('.modal').modal('hide');
				}else{
				toastr.warning(data.message,"Advert Add Failed", {
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
	
	$('#jobAddFrm')
	.submit( function( e ) {
		var frm = $("#jobAddFrm");
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Job Updated", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				getPage("/profile");
				$('.modal').modal('hide');
				}else{
				toastr.warning(data.message,"Job Update Failed", {
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
	
	$('#articleFrm')
	.submit( function( e ) {
		var frm = $("#articleFrm");
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Article Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				}else{
				toastr.warning(data.message,"Article Failed", {
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
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Opinion Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				$(".noOpinions"+data.id).html(data.newOpinion);
				$(".realtimeOpinion").show();
				$(".thisopinion").html(data.opinion);
				document.getElementById("OpinionFrm").reset();
				}else{
				toastr.warning(data.message,"Opinion Failed", {
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
	$('#addReviewFrm')
	.submit( function( e ) {
		var frm = $("#addReviewFrm");
		

		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Review Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				$(".noReview"+data.id).html(data.newReview);
				$(".realtimeReview").show();
				$(".thisreview").html(data.review);
				document.getElementById("addReviewFrm").reset();
				}else{
				toastr.warning(data.message,"Review Failed", {
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
	$('#addAnalyisFrm')
	.submit( function( e ) {
		var frm = $("#addAnalyisFrm");
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Analysis Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				$(".noAnalysis"+data.id).html(data.newAnaysis);
				$(".realtimeAnalysis").show();
				$(".thisanalysis").html(data.analysis);
				$(".Tpoints").html(data.Tpoints);
				$(".OpPoints").html(data.OpPoints);
				
				document.getElementById("addAnalyisFrm").reset();
				}else{
				toastr.warning(data.message,"Analysis Failed", {
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
	$('#addRecommendFrm')
	.submit( function( e ) {
		var frm = $("#addRecommendFrm");
		
		
		$.ajax( {
			url:frm.attr("action"),
			type:frm.attr("method"),
			data: new FormData( this ),
			processData: false,
			contentType: false,
			success: function(data){
				if(data.status=="success"){
				toastr.success(data.message,"Recommendation Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
				$(".noRecommendations"+data.id).html(data.newRecommendations);
				$(".realtimeRecomm").show();
				$(".thisRecomm").html(data.recommendation);
				document.getElementById("addRecommendFrm").reset();
				}else{
				toastr.warning(data.message,"Recommendation Failed", {
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
		    	 if(data.status=="success"){
		    	 toastr.success(data.message,"Update Made", {
			    		closeButton: true,
						progressBar: true,
						positionClass:"toast-top-center"
			   	 });
		    	 
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
		    	 }else{
		    	 toastr.warning(data.message,"Update Failed", {
		    		 closeButton: true,
		    		 progressBar: true,
		    		 positionClass:"toast-top-center"
		    	 });
		    	 }

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


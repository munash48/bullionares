 $(function(){

		 

	 $("#profile").click(function(){
		 
		 getPage("/profile");
	 });
	 $("#fullprofile").click(function(){
		
		 getPage("/profile");
	 });
	 
	 $("#mainpost").click(function(){
		 getPage("/mainpost");
	 });
	 $("#mainpostbtn").click(function(){
		 getPage("/mainpost");
	 });
	 $("#chart").click(function(){
		 getPage("/chart");
		 $(".chartNotice").hide();
	 });
	 $("#chart1").click(function(){
		 getPage("/chart");
		 $(".chartNotice").hide();
	 });
	 $("#editProfile").click(function(){
		 getPage("/editProfile");
	 });
	 
 });
 
 function getPage(url){
	 
	 $.ajax({
		 type:"GET",
		 url:url,
		 success:function(data){
			 $(".inner-jsp").html(data);
		 }
	 });
 }
 
 function getArticle(url){
	 
	 $.ajax({
		 type:"GET",
		 url:url,
		 success:function(data){
			 $(".article-react").html(data);
		 }
	 });
 }
 
 function chatForm(id){	
	 getPage("/message?wuid="+id);
	 $(".chatNotice").hide();
		
	}
 function getProfile(id){	
	 getPage("/profile?wuid="+id);
	 
 }
 
 function countVote(uid,aid,duid){	
	 
	 
	 $.ajax({
			type: "GET",
			url: "/addVote?uid="+uid+"&aid="+aid+"&duid="+duid,
	    	success: function(data){
	    	if(data.status=="success"){
	    		toastr.success(data.message,"Counted", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
		    	$(".noVotes"+aid).html(data.newvotes);
		    	$(".VoPoints").html(data.noVotes);
		    	$(".Tpoints").html(data.noTVotes);
	    		
	    	} else{
	    		toastr.warning(data.message,"Failed", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
		    	$(".noVotes"+aid).html(data.newvotes);
	    	}
	    	
	    }
		
		});
	 
 }
 function countCross(uid,aid,duid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addCross?uid="+uid+"&aid="+aid+"&duid="+duid,
		 success: function(data){
			 
			 if(data.status=="success"){
	
			 toastr.success(data.message,"Crossed", {
				 closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noReports"+aid).html(data.newCrosses);
			 $(".noReports").html(data.noReports);
			 $(".Tpoints").html(data.noTVotes);
			 }else{
				 toastr.warning(data.message,"Failed", {
					 closeButton: true,
						progressBar: true,
						positionClass:"toast-top-center"
			   	 });
				 
			 }
		 }
	 
	 });
	 	 
 }
 function countNegative(uid,adid,aduid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addNegative?uid="+uid+"&adid="+adid+"&aduid="+aduid,
		 success: function(data){
			 
			 if(data.status=="success"){
			 toastr.success(data.message,"Added",  {
				 closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noNegative"+adid).html(data.newNegative);
			 $(".noReports").html(data.noReports);
			 $(".Tpoints").html(data.noTVotes);
			 }else{
			 toastr.warning(data.message,"Failed",  {
				 closeButton: true,
				 progressBar: true,
				 positionClass:"toast-top-center"
			 });
			 }
		 }
	 
	 });
	 
 }
 function countPositive(uid,adid,aduid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addPositive?uid="+uid+"&adid="+adid+"&aduid="+aduid,
		 success: function(data){
			 if(data.status=="success"){
				toastr.success(data.message,"Added", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noPositive"+adid).html(data.newPositive);
			 $(".VoPoints").html(data.noVotes);
			 $(".Tpoints").html(data.noTVotes);
			 
			 }else{
			 toastr.warning(data.message,"Failed", {
				 closeButton: true,
				 progressBar: true,
				 positionClass:"toast-top-center"
			 });
			 }
		 }
	 
	 });
	 
 }
 function countGoing(uid,eid,euid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addGoing?uid="+uid+"&eid="+eid+"&euid="+euid,
		 success: function(data){
			 if(data.status=="success"){
				toastr.success(data.message,"Going Counted", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noGoing"+eid).html(data.newGoing);
			 $(".VoPoints").html(data.noVotes);
			 $(".Tpoints").html(data.noTVotes);
			 }else{
			 toastr.warning(data.message,"Failed", {
				 closeButton: true,
				 progressBar: true,
				 positionClass:"toast-top-center"
			 });
			 }
		 }
	 
	 });
	 
 }
 function countNotGoing(uid,eid,euid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addNotGoing?uid="+uid+"&eid="+eid+"&euid="+euid,
		 success: function(data){
			 if(data.status=="success"){
				toastr.success(data.message,"Not-Going Counted", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noNotGoing"+eid).html(data.newNotGoing);
			 $(".noReports").html(data.noReports);
			 $(".Tpoints").html(data.noTVotes);
			 }else{
			 toastr.warning(data.message,"Failed", {
				 closeButton: true,
				 progressBar: true,
				 positionClass:"toast-top-center"
			 });
			 }
		 }
	 
	 });
	 
 }
 function countRecommed(uid,jaid,jauid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addRecomend?uid="+uid+"&jaid="+jaid+"&jauid="+jauid,
		 success: function(data){
			 if(data.status=="success"){
				toastr.success(data.message,"Recommended", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noRecommend"+jaid).html(data.newRecommend);
			 $(".VoPoints").html(data.noVotes);
			 $(".Tpoints").html(data.noTVotes);
			 }else{
			 toastr.warning(data.message,"Failed", {
				 closeButton: true,
				 progressBar: true,
				 positionClass:"toast-top-center"
			 });
			 }
		 }
	 
	 });
	 
 }
 function countNotRecommed(uid,jaid,jauid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addNotRecomend?uid="+uid+"&jaid="+jaid+"&jauid="+jauid,
		 success: function(data){
			 if(data.status=="success"){
				toastr.success(data.message,"Not Recommended", {
		    		closeButton: true,
					progressBar: true,
					positionClass:"toast-top-center"
		   	 });
			 $(".noNotRecomend"+jaid).html(data.newNotRecomend);
			 $(".noReports").html(data.noReports);			 
			 $(".Tpoints").html(data.noTVotes);
			 }else{
			 toastr.warning(data.message,"Failed", {
				 closeButton: true,
				 progressBar: true,
				 positionClass:"toast-top-center"
			 });
			 }
		 }
	 
	 });
	 
 }
 function countClick(eaid){	
		 
	 $.ajax({
		 type: "GET",
		 url: "/countClick?eaid="+eaid,
		 success: function(data){
			 if(data.status=="success"){
				 toastr.success(data.message,"Thank you Rating", {
					 closeButton: true,
					 progressBar: true,
					 positionClass:"toast-top-center"
				 });
				
			 }else{
				 toastr.warning(data.message,"Failed", {
					 closeButton: true,
					 progressBar: true,
					 positionClass:"toast-top-center"
				 });
			 }
		 }
	 
	 });
	 
 }
 
 
 
 function articleForm(id){
	 getArticle("/articleReact?id="+id);
			
		}
 
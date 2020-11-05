 $(function(){

	 $("#profile").click(function(){
		 alert("inside profile");
		 getPage("/profile");
	 });
	 $("#fullprofile").click(function(){
		 alert("inside profile");
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
 
 function getOpinions(url){
	 
	 $.ajax({
		 type:"GET",
		 url:url,
		 success:function(data){
			 $(".inner-opinion").html(data);
		 }
	 });
 }
 
 function chatForm(id){	
	 getPage("/message?wuid="+id);
		
	}
 
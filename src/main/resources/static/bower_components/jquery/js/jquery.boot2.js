 $(function(){

	 $("#profile").click(function(){
		 alert("inside profile");
		 getPage("/profile");
	 });
	 $("#chart").click(function(){
		 getPage("/chart");
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
 
 function getHomePage(url){
	 
	 $.ajax({
		 type:"GET",
		 url:url,
		 success:function(data){
			 $(".innerHome-jsp").html(data);
		 }
	 });
 }
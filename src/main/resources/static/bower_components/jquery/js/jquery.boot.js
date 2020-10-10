 $(function(){
	 $("#regForm").click(function(){
		 getPage("/register");
	 });
	 $("#rules").click(function(){
		 getPage("/rules");
	 });
	 $("#loginForm").click(function(){
		 getPage("/");
	 });
	 $("#restForm").click(function(){
		 getPage("/reset");
	 });
	 $("#profile").click(function(){
		 getPage("/reset");
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
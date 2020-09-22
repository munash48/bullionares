 $(function(){
	 $("#regForm").click(function(){
		 getPage("/register");
	 });
	 $("#loginForm").click(function(){
		 getPage("/login");
	 });
	 $("#rules").click(function(){
		 getPage("/");
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
 $(function(){
	 alert("inside boot 2");

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
		
	}
 function countVote(uid,aid,duid){	
	 
	 
	 $.ajax({
			type: "GET",
			url: "/addVote?uid="+uid+"&aid="+aid+"&duid="+duid,
	    	success: function(data){
	    	
	    	alert(data.message);
	    	$(".noVotes"+aid).html(data.newvotes);
	    }
		
		});
	 
 }
 function countCross(uid,aid,duid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addCross?uid="+uid+"&aid="+aid+"&duid="+duid,
		 success: function(data){
			 
			 alert(data.message);
			 $(".noReports"+aid).html(data.newCrosses);
		 }
	 
	 });
	 	 
 }
 function countNegative(uid,adid,aduid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addNegative?uid="+uid+"&adid="+adid+"&aduid="+aduid,
		 success: function(data){
			 
			 alert(data.message);
			 $(".noNegative"+adid).html(data.newNegative);
		 }
	 
	 });
	 
 }
 function countPositive(uid,adid,aduid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addPositive?uid="+uid+"&adid="+adid+"&aduid="+aduid,
		 success: function(data){
			 
			 alert(data.message);
			 $(".noPositive"+adid).html(data.newPositive);
		 }
	 
	 });
	 
 }
 function countGoing(uid,eid,euid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addGoing?uid="+uid+"&eid="+eid+"&euid="+euid,
		 success: function(data){
			 
			 alert(data.message);
			 $(".noGoing"+eid).html(data.newGoing);
		 }
	 
	 });
	 
 }
 function countNotGoing(uid,eid,euid){	
	 
	 
	 $.ajax({
		 type: "GET",
		 url: "/addNotGoing?uid="+uid+"&eid="+eid+"&euid="+euid,
		 success: function(data){
			 
			 alert(data.message);
			 $(".noNotGoing"+eid).html(data.newNotGoing);
		 }
	 
	 });
	 
 }
 
 
 
 function articleForm(id){
	 getArticle("/articleReact?id="+id);
			
		}
 
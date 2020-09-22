<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>print profile</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="shortcut icon" href="images/billionaire-icon3.png" />
<link rel="stylesheet"
	href="bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="bower_components/Ionicons/css/ionicons.min.css">
<!-- jvectormap -->
<link rel="stylesheet"
	href="bower_components/jvectormap/jquery-jvectormap.css">
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.css">
<link rel="stylesheet" href="dist/css/searchbar.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="dist/css/skins/_all-skins.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body onload="window.print();">
	<!-- Main content -->
	<section class="invoice">
		<!-- title row -->
		<div class="row">
			<div class="col-xs-12">
				<h2 class="page-header">
					<i class="fa fa-globe"></i> Billionare Profile  <small class="pull-right">Member since
						${user.joinDate} | points ${counter.total} </small>
				</h2>
			</div>
			<!-- /.col -->
		</div>
		<!-- info row -->
		<div class="row invoice-info">
			<div class="col-sm-4 invoice-col text-center">
			<c:if test="${user.imageLink!=''}">
					<img class="profile-user-img img-responsive img-rounded"
						src="/uploads/${user.id}/profile/${user.imageLink}"
						alt="User profile picture." data-toggle="tooltip"
						data-placement="top" title="click edit to update">

				</c:if>
				<c:if test="${user.imageLink==''}">
					<img class="profile-user-img img-responsive img-rounded"
						src="/dist/img/profile.jpg" alt="User profile picture."
						data-toggle="tooltip" data-placement="top"
						title="click edit to update">

				</c:if>
				<strong>${user.firstName} ${user.otherNames}</strong><br>
				<b>${user.profession}</b> <br>
				
			</div>
			<!-- /.col -->
			<div class="col-sm-4 invoice-col">
				<u>Bio data</u>
				<address>
					
					D.O.B: <b>${user.birthDate} </b><br>
					E-Mail: <b>${user.email} </b><br>
					Tel.: <b>${user.phoneNumber} </b><br>
					<u>Specialization</u> <br>
					Education: <b>${education.award}</b> <br>

				</address>
			</div>
			<!-- /.col -->
			<div class="col-sm-4 invoice-col">
			<u>Personal Address</u> <br>
				Country: <b>${address.country}</b><br> 
				District: <b>${address.district}</b><br> 
				Division: <b>${address.division}</b><br> 
				Village: <b>${address.village}</b><br> 
				Street: <b>${address.street}</b><br> 
				P.O.Box: <b>${address.boxNumber}</b><br> 

			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		<div class="text-muted well well-sm no-shadow">
		<u><b>About</b></u> <br>
		<p>${user.aboutme}</p>
		
		
		
		</div>
		<div class="text-muted well well-sm no-shadow">
		<u><b>Career</b></u> <br>
		<p>I am a ${career.jobTitle} at ${company.name} specializing in ${career.specialization}. ${career.description}</p>
		<P>We deal in ${company.type}My company is located at ${company.website} and ${company.address}</P>
		
		
		
		</div>
		<div class="text-muted well well-sm no-shadow">
		<u><b>Education</b></u> <br>
		<p>My highest level of education is a ${education.level} as at ${education.completionDate}. I have a ${education.award} from ${education.institution} found on ${education.website}.</p>
		
		
		
		</div>
		<div class="text-muted well well-sm no-shadow">
		<u><b>Hobbies</b></u> <br>
		<p>I have the following hobbies and skills.</p>
		<p>${skillTalent.name1}</p>
		<p>${skillTalent.name2}</p>
		<p>${skillTalent.name3}</p>
		<p>${skillTalent.name5}</p>
		<p>${skillTalent.name5}</p>
		
			
		</div>

		<!-- Table row -->
		


		<!-- this row will not appear when printing -->
	</section>
	<!-- /.content -->
	<div class="clearfix"></div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Billionares KB</title>
<!-- Tell the browser to be responsive to screen width -->
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
<body class="hold-transition skin-blue register-page">
	<%@include file="./shared/header.jsp"%>


	<div class="row">

		<!-- REGSITER LOGIN OR DOCUEMNTATION -->
		<%@include file="./shared/user.jsp"%>


	</div>
	<div class="row">

		<footer class="footer p-3">
			<div class="text-center hidden-xs">
				<b>Version</b> 2.4.18 <strong>Copyright &copy; 2020 <a
					href="http://kalimagezi.com/">Kalimagezi ltd</a>.
				</strong> All rights reserved.
			</div>
		</footer>
	</div>

	<div class="row">
		<div class="modal fade" id="imageEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Update Profile Image</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form enctype="multipart/form-data" action="/home/uploadImage"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uImageId"
								value="${user.id}" /> <input type="hidden" name="email"
								value="${user.email}" />

							<div class="row">
								<div class="col-xs-8">

									<div class="form-group has-feedback">
										<input type="file" class="form-control" name="imageFile"
											id="otherNames" /> <span
											class="glyphicon glyphicon-camera form-control-feedback"></span>
									</div>
								</div>
								<!-- /.col -->
								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Upload</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="profileEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Update Bio Data Update</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form enctype="multipart/form-data" action="/home/updateUser"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uId"
								value="${user.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="firstName"
									id="firstName" placeholder="First Name"
									value="${user.firstName}" /> <span
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="otherNames"
									id="otherNames" placeholder="Other Names"
									value="${user.otherNames}" /> <span
									class="glyphicon glyphicon-plus form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="phoneNumber"
									id="phoneNumber" placeholder="Phone Number"
									value="${user.phoneNumber}" /> <span
									class="glyphicon glyphicon-phone form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Email" value="${user.email}" /> <span
									class="glyphicon glyphicon-envelope form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="profession"
									id="profession" placeholder="Your Profession"
									value="${user.profession}" /> <span
									class="glyphicon glyphicon-star form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="birthDate"
									id="birthDate" value="${user.birthDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="addressEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Address Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/updateAddress" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="aId"
								value="${address.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="country"
									id="country" placeholder="Country" value="${address.country}" />
								<span class="glyphicon glyphicon-flag form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="district"
									id="district" placeholder="District"
									value="${address.district}" /> <span
									class="glyphicon glyphicon-globe form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="division"
									id="division" placeholder="Division"
									value="${address.division}" /> <span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="village"
									id="village" placeholder="Village" value="${address.village}" />
								<span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="street"
									id="street" placeholder="Street" value="${address.street}" />
								<span
									class="glyphicon glyphicon-dashboard form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="boxNumber"
									id="boxNumber" placeholder="Box Number"
									value="${address.boxNumber}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="companyEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Company Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/updateCompany" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="cId"
								value="${company.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name=name id="name"
									placeholder="Company Name" value="${company.name}" /> <span
									class="glyphicon glyphicon-flag form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="type" id="type"
									placeholder="Company Type" value="${company.type}" /> <span
									class="glyphicon glyphicon-zoom-in form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="address"
									id="address" placeholder="Company Address"
									value="${company.address}" /> <span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="website"
									id="website" placeholder="Company Website"
									value="${company.website}" /> <span
									class="glyphicon glyphicon-cloud form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="jobCapacity"
									id="jobCapacity" placeholder="jobCapacity"
									value="${company.jobCapacity}" /> <span
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="Description"
									value="${company.description}" /> <span
									class="glyphicon glyphicon-list-alt form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="workingHours"
									id="workingHours" placeholder="Working Hours"
									value="${company.workingHours}" /> <span
									class="glyphicon glyphicon-time form-control-feedback"></span>
							</div>


							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="creationDate"
									id="creationDate" value="${company.creationDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="careerEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Career Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/updateCareer" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="cId"
								value="${career.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="jobTitle"
									id="jobTitle" placeholder="Job Title"
									value="${career.jobTitle}" /> <span
									class="glyphicon glyphicon-briefcase form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="specialization"
									id="specialization" placeholder="Your Specialization"
									value="${career.specialization}" /> <span
									class="glyphicon glyphicon-star-empty form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="website"
									id="website" placeholder="Career Website"
									value="${career.website}" /> <span
									class="glyphicon glyphicon-cloud form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="Description"
									value="${career.description}" /> <span
									class="glyphicon glyphicon-list-alt form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="startDate"
									id="startDate" value="${career.startDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>



	<div class="row">
		<div class="modal fade" id="educationEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Highest Education Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/updateEducation" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="eId"
								value="${education.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="level" id="level"
									placeholder="Level" value="${education.level}" /> <span
									class="glyphicon glyphicon-book form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="award" id="award"
									placeholder="Award e.g BSc" value="${education.award}" /> <span
									class="glyphicon glyphicon-education form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="institution"
									id="institution" placeholder="Institution"
									value="${education.institution}" /> <span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="website"
									id="website" placeholder="Career Website"
									value="${education.website}" /> <span
									class="glyphicon glyphicon-cloud form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="completionDate"
									id="completionDate" value="${education.completionDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="row">
		<div class="modal fade" id="eventEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Event Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form enctype="multipart/form-data" action="/home/updateEvent"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="eId"
								value="${event.id}" /><input type="hidden" name="uImageId"
								value="${user.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="ename" id="ename"
									placeholder="Event Name" value="${event.ename}" /> <span
									class="glyphicon glyphicon-info-sign form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="Description"
									value="${event.description}" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="eventDate"
									id="eventDate" value="${event.eventDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="file" class="form-control" name="imageFile"
									id="imageLink" placeholder="imageLink"
									value="${event.imageLink}" /> <span
									class="glyphicon glyphicon-picture form-control-feedback"></span>
							</div>



							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="modal fade" id="skillEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Skill / Talent / Hobbies Dialog
							Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/updateSkill" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="sId"
								value="${skill.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="name1" id="name1"
									placeholder="First Skill / Telent Name"
									value="${skillTalent.name1}" /> <span
									class="glyphicon glyphicon-education form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="name2" id="name2"
									placeholder="Second Skill / Telent Name"
									value="${skillTalent.name2}" /> <span
									class="glyphicon glyphicon-heart-empty form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="name3" id="name3"
									placeholder="Third Skill / Telent Name"
									value="${skillTalent.name3}" /> <span
									class="glyphicon glyphicon glyphicon-heart form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="name4" id="name4"
									placeholder="Fourth Skill / Telent Name"
									value="${skillTalent.name4}" /> <span
									class="glyphicon glyphicon-star form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="name5" id="name5"
									placeholder="Fifth Skill / Telent Name"
									value="${skillTalent.name5}" /> <span
									class="glyphicon glyphicon-star-empty form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="Description"
									value="${skillTalent.description}" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="aboutmeEdit" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Update About you info</h4>
						<p>${user.aboutme}</p>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/updateAboutme" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uImageId"
								value="${user.id}" /> <input type="hidden" name="email"
								value="${user.email}" />

							<div class="form-group has-feedback">
								<textarea class="form-control" rows="3"
									placeholder="Who are you ??" name="aboutme" spellcheck="true"></textarea>

								<span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>


							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="addAdvert" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Create Advert Dialog Box</h4>
						<h5 class="modal-title">Pay to +256-773-284953</h5>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form enctype="multipart/form-data" action="/home/addAdvert"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uid"
								value="${user.id}" /> <input type="hidden" name="cid"
								value="${user.catid}" />
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="title" id="title"
									placeholder="Advert Title" /> <span
									class="glyphicon glyphicon-info-sign form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="Description" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="advertDate"
									id="advertDate" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="noDays"
									id="noDays" placeholder="No of Days" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="advertAmount"
									id="advertAmount" placeholder="Advert Cost" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="itemAmount"
									id="itemAmount" placeholder="Cost Item / Service" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="website"
									id="website" placeholder="Product Website" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="transactionId"
									id="transactionId" placeholder="Mobile Money Transaction Id" />
								<span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="file" class="form-control" name="imageFile"
									id="imageLink" placeholder="imageLink" /> <span
									class="glyphicon glyphicon-picture form-control-feedback"></span>
							</div>



							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="modal fade" id="advertReview" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Review Adverts Dialog box</h4>

					</div>


					<div class="modal-body">

						<div class="box box-success">

							<c:forEach items="${displayadds}" var="displayadd">
								<a><h5>${displayadd.title}</h5></a>
								<p>
								<h5>${displayadd.description}</h5>
								</p>
								<h4>
									<span class="label label-warning pull-right">$${displayadd.itemAmount}</span>
								</h4>
								<a>${displayadd.website} </a>


								<div class="product-img">
									<c:if test="${displayadd.imageLink!=''}">



										<a target="_blank"
											href="/uploads/${displayadd.uid}/aaaaa/${displayadd.imageLink}"><img
											class="img-responsive"
											src="/uploads/${displayadd.uid}/aaaaa/${displayadd.imageLink}"
											alt="user image"> </a>

									</c:if>
									<c:if test="${displayadd.imageLink==''}">
										<img class="img-responsive" src="dist/img/default-50x50.gif"
											alt="Product Image">

									</c:if>

								</div>

								<ul class="list-inline">
									<li>
										<form action="/home/addNegative" method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="aid"
												value="${displayadd.id}" />



											<button type="submit" class="btn btn-trans">
												<i class="fa fa-times fa-2x margin-r-5"></i> Negative
											</button>

										</form>



									</li>

									<li>
										<form class="form-horizontal" action="/home/addPositive"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="aid"
												value="${displayadd.id}" />



											<button type="submit" class="btn btn-trans">


												<i class="fa fa-check fa-2x margin-r-5"></i> Positive

											</button>


										</form>

									</li>
									<li class="pull-right"><a href="#"
										class="link-black text-sm"><i
											class="fa fa-comments-o fa-2x margin-r-5"></i>Written Reviews
											(${displayadd.noReviews})</a></li>
									<li class="pull-right"><a href="#"
										class="link-black text-sm"> <i
											class="fa fa-check fa-2x margin-r-5"></i>Positives
											(${displayadd.noPositives})
									</a></li>

									<li class="pull-right"><a href="#"
										class="link-black text-sm"><i
											class="fa fa-times fa-2x margin-r-5"></i>Negatives
											(${displayadd.noNegatives})</a></li>


								</ul>
								<div class="box-body no-padding">
									<div class="row">
										<div class="col-md-12 col-sm-12">
											<div class="pad">

												<c:if test="${displayadd.uid==user.id}">

													<c:forEach items="${displayadd.reviews}" var="review">

														<!-- the comments comme hear -->
														<div class="direct-chat-msg">
															<div class="direct-chat-info clearfix">
																<span class="direct-chat-name pull-left">${review.uid}</span>
																<span class="direct-chat-timestamp pull-right">
																	${review.createDate }</span>
															</div>
															<!-- /.direct-chat-info -->


															<!-- /.direct-chat-img -->
															<div class="direct-chat-text">${review.description}</div>
															<!-- /.direct-chat-text -->
														</div>

													</c:forEach>
												</c:if>



												<div class="box-footer">
													<form action="/home/addReview" method="post">

														<input type="hidden" name="${_csrf.parameterName}"
															value="${_csrf.token}" /> <input type="hidden"
															name="aid" value="${displayadd.id}" /><input
															type="hidden" name="uid" value="${user.id}" />
														<div class="input-group">
															<input type="text" name="description"
																placeholder="Type your Advert Review ..."
																class="form-control"> <span
																class="input-group-btn">
																<button type="submit" name="submit"
																	class="btn btn-warning btn-flat">Add Review</button>
															</span>
														</div>
													</form>
												</div>


											</div>
										</div>


										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>

							</c:forEach>


						</div>


						<!--modal form-->


					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="modal fade" id="eventReview" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Review Events Dialog box</h4>

					</div>


					<div class="modal-body">

						<div class="box box-success">

							<c:forEach items="${catEvents}" var="catEvent">
							<c:if test="${not empty catEvent.ename}">
								<a><h5>${catEvent.ename}</h5></a>
								<p>
								<h5>${catEvent.description}</h5>
								</p>
								<h4>
									<a href="/profile?wuid=${catEvent.uid}"> <span class="label label-success pull-left"> By ${catEvent.byname}</span></a>
									<span class="label label-success pull-right">${catEvent.eventDate}</span>
								</h4>


								<div class="product-img">
									<c:if test="${catEvent.imageLink!=''}">



										<a
											href="/uploads/${catEvent.uid}/events/${catEvent.imageLink}"><img
											class="img-responsive"
											src="/uploads/${catEvent.uid}/events/${catEvent.imageLink}"
											alt="user image"> </a>

									</c:if>
									<c:if test="${catEvent.imageLink==''}">
										<img class="img-responsive" src="dist/img/default-50x50.gif"
											alt="Product Image">

									</c:if>

								</div>

								<ul class="list-inline">
									<li>
										<form action="/home/addNotGoing" method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="eid"
												value="${catEvent.id}" />



											<button type="submit" class="btn btn-trans">
												<i class="fa fa-times fa-2x margin-r-5"></i> Not Going
											</button>

										</form>



									</li>

									<li>
										<form class="form-horizontal" action="/home/addGoing"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="eid"
												value="${catEvent.id}" />



											<button type="submit" class="btn btn-trans">


												<i class="fa fa-check fa-2x margin-r-5"></i> Going

											</button>


										</form>

									</li>
									<li class="pull-right"><a href="#"
										class="link-black text-sm"> <i
											class="fa fa-check fa-2x margin-r-5"></i>Not Going
											(${catEvent.notGoing})
									</a></li>

									<li class="pull-right"><a href="#"
										class="link-black text-sm"><i
											class="fa fa-times fa-2x margin-r-5"></i>Going
											(${catEvent.going})</a></li>


								</ul>
								</c:if>


							</c:forEach>


						</div>


						<!--modal form-->


					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="modal fade" id="addJob" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Create Job Advert Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form enctype="multipart/form-data" action="/home/addJobadd"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uid"
								value="${user.id}" /> <input type="hidden" name="catid"
								value="${user.catid}" /> <input type="hidden" name="compid"
								value="${company.id}" />
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="title" id="title"
									placeholder="Job Title" /> <span
									class="glyphicon glyphicon-info-sign form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="jobCategory"
									id="jobCategory" placeholder="Job Category" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="description"
									id="description" placeholder="Description" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>


							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="noPositions"
									id="noPositions" placeholder="No of Positions" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="salary"
									id="salary" placeholder="Salary or Range" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
							<label for="deadline">Deadline</label>
								<input type="date" class="form-control" name="deadline"
									id="advertDate" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="file" class="form-control" name="imageFile"
									id="imageLink" placeholder="advert poster" /> <span
									class="glyphicon glyphicon-picture form-control-feedback"></span>
							</div>



							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Add Job</button>
								</div>
							</div>


						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="modal fade" id="jobReview" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Review Jobs Dialog box</h4>

					</div>


					<div class="modal-body">

						<div class="box box-success">

							<c:forEach items="${catJobadds}" var="catJobadd">
							<c:if test="${not empty catJobadd.jobTitle}">
								<a><h5>(${catJobadd.noPositions}) ${catJobadd.jobTitle} (s)</h5></a>
								<p>
								<h5>${catJobadd.description}</h5>
								</p>
								<h4>
									<span class="label label-success pull-left">${catJobadd.salary}</span>
									<span class="label label-danger pull-right">${catJobadd.deadline}</span>
								</h4>


								<div class="product-img">
									<c:if test="${catJobadd.imageLink!=''}">



										<a target="_blank"
											href="/uploads/${catJobadd.uid}/jobadds/${catJobadd.imageLink}"><img
											class="img-responsive"
											src="/uploads/${catJobadd.uid}/jobadds/${catJobadd.imageLink}"
											alt="user image"> </a>

									</c:if>
									<c:if test="${catJobadd.imageLink==''|| catJobadd.imageLink==null}">
										<img class="img-responsive" src="dist/img/default-50x50.gif"
											alt="Product Image">

									</c:if>

								</div>

								<ul class="list-inline">
									<li>
										<form action="/home/addNotRecomend" method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="jaid"
												value="${catJobadd.id}" />



											<button type="submit" class="btn btn-trans">
												<i class="fa fa-times fa-2x margin-r-5"></i> Not Recomended
											</button>

										</form>



									</li>

									<li>
										<form class="form-horizontal" action="/home/addRecomend"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="jaid"
												value="${catJobadd.id}" />



											<button type="submit" class="btn btn-trans">


												<i class="fa fa-check fa-2x margin-r-5"></i> Recomended

											</button>


										</form>

									</li>
									<li class="pull-right"><a href="#"
										class="link-black text-sm"> <i
											class="fa fa-check fa-2x margin-r-5"></i>Recomended
											(${catJobadd.recomended})
									</a></li>

									<li class="pull-right"><a href="#"
										class="link-black text-sm"><i
											class="fa fa-times fa-2x margin-r-5"></i>Not Recomemded
											(${catJobadd.notRecomended})</a></li>


								</ul>
								</c:if>


							</c:forEach>


						</div>


						<!--modal form-->


					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="modal fade" id="inviteUser" role="dialog">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Invite User</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<form action="/home/inviteUser" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uid"
								value="${user.id}" /> <input type="hidden" name="uemail"
								value="${user.email}" />

							<div class="form-group has-feedback">
								<input type="email" class="form-control" name="iemail" id="iemail"
									placeholder="Enter Email of Invitie"  /> <span
									class="glyphicon glyphicon-envelope form-control-feedback"></span>
							</div>


							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Invite</button>
								</div>
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 3 -->
	<script src="bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="dist/js/adminlte.min.js"></script>
	<!-- Sparkline -->
	<script
		src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
	<!-- jvectormap  -->
	<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- SlimScroll -->
	<script
		src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- ChartJS -->
	<script src="bower_components/chart.js/Chart.js"></script>
	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="dist/js/pages/dashboard2.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/dist/js/demo.js"></script>
</body>
</html>
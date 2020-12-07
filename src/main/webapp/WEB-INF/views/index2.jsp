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
						<form enctype="multipart/form-data" action="/uploadImage"
							method="post" id="imageEditFrm">
							<input type="hidden" name="uImageId"
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
						modal form
						<sf:form action="/updateUser" method="post" id="profileEditFrm" modelAttribute="user">
							<sf:input type="hidden" path="id"
								id="id" value="${user.id}" />

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="firstName"
									id="firstName" placeholder="First Name"
									value="${user.firstName}" /> <span
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="otherNames"
									id="otherNames" placeholder="Other Names"
									value="${user.otherNames}" /> <span
									class="glyphicon glyphicon-plus form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="phoneNumber"
									id="phoneNumber" placeholder="Phone Number"
									value="${user.phoneNumber}" /> <span
									class="glyphicon glyphicon-phone form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="email" class="form-control" path="email" id="email"
									placeholder="Email" value="${user.email}" readonly="true"/> <span
									class="glyphicon glyphicon-envelope form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="profession"
									id="profession" placeholder="Your Profession"
									value="${user.profession}" /> <span
									class="glyphicon glyphicon-star form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
							<label class="control-label"> Date of Birth: </label>
								<sf:input type="date" class="form-control" path="birthDate"
									id="birthDate" value="${user.birthDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:textarea class="form-control" rows="3" value="${user.aboutme}"
									placeholder="Paragraph about who you are? (Max=150)" path="aboutme" spellcheck="true" maxlength = "150"></sf:textarea>

								<span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<sf:hidden path="imageLink" value="${user.imageLink}"/>
							<sf:hidden path="resetcode" value="${user.resetcode}"/>
							<sf:hidden path="catid" value="${user.catid}"/>
							<sf:hidden path="password" value="${user.password}"/>
							<sf:hidden path="role" value="${user.role}" />
							<sf:hidden path="enabled" value="${user.enabled}"/>
							<sf:hidden path="joinDate"  value="${user.joinDate}"/>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</sf:form>

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
						<button type="button" class="close" data-dismiss="modal" >
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Edit Current Company Info Dialog Box</h4>

					</div>
					<div class="modal-body">
						<!--modal form-->
						<sf:form action="/updateCompany" method="post" id="companyEditFrm" modelAttribute="company">
							 <sf:input type="hidden" path="id"
								value="${company.id}" />
							 <sf:input type="hidden" path="uid"
								value="${company.uid}" />

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="name" id="name"
									placeholder="Company Name" value="${company.name}" /> <span 
									class="glyphicon glyphicon-flag form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="type" id="type"
								placeholder="Company Type eg ICT/Education" value="${company.type}" /> <span 
									class="glyphicon glyphicon-zoom-in form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="address"
									id="address" placeholder="Company Address e.g Mutungo P.O.Box 4578" 
									value="${company.address}" /> <span 
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="website"
									id="website" placeholder="Company Website eg. www.kalimagezi.com" 
 									value="${company.website}" /> <span 
									class="glyphicon glyphicon-cloud form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
							<label class="control-label">No of Employees </label>
								<sf:input type="text" class="form-control" path="jobCapacity"
									id="jobCapacity" placeholder="No of Employees / Capacity" 
									value="${company.jobCapacity}" /> <span 
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="description"
									id="description" placeholder="Description" 
									value="${company.description}" /> <span 
									class="glyphicon glyphicon-list-alt form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="workingHours"
									id="workingHours" placeholder="Working Hours eg Monday to Friday 8:00Am to 5:00 PM" maxlength="100"
									value="${company.workingHours}" /> <span 
									class="glyphicon glyphicon-time form-control-feedback"></span>
							</div>


							<div class="form-group has-feedback">
							<label class="control-label"> Date of Company Creation: </label>
								<sf:input type="date" class="form-control" path="creationDate"
									id="creationDate" value="${company.creationDate}" /> <span 
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</sf:form>

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
						<sf:form action="/updateAddress" method="post" id="addressEditFrm" modelAttribute="address">
							 <sf:input type="hidden" path="id"
								value="${address.id}" />
							 <sf:input type="hidden" path="uid"
								value="${address.uid}" />

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="country"
									id="country" placeholder="Country" value="${address.country}" />
								<span class="glyphicon glyphicon-flag form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="district"
									id="district" placeholder="District"
									value="${address.district}" /> <span
									class="glyphicon glyphicon-globe form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="division"
									id="division" placeholder="Division"
									value="${address.division}" /> <span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="village"
									id="village" placeholder="Village" value="${address.village}" />
								<span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="street"
									id="street" placeholder="Street" value="${address.street}" />
								<span
									class="glyphicon glyphicon-dashboard form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="boxNumber"
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


						</sf:form>

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
						<sf:form action="/updateCareer" method="post" id="careerEditFrm" modelAttribute="career">
							 
								<sf:input type="hidden" path="id"
								value="${career.id}" />
								<sf:input type="hidden" path="uid"
								value="${career.uid}" />

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="jobTitle"
									id="jobTitle" placeholder="Job Title" maxlength="30"
									value="${career.jobTitle}" /> <span
									class="glyphicon glyphicon-briefcase form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="specialization"
									id="specialization" placeholder="Your Specialization" maxlength="30"
									value="${career.specialization}" /> <span
									class="glyphicon glyphicon-star-empty form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="website"
									id="website" placeholder="Career Website eg. www.w3schools.com" maxlength="30"
									value="${career.website}" /> <span
									class="glyphicon glyphicon-cloud form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="description"
									id="description" placeholder="Description" maxlength="150"
									value="${career.description}" /> <span
									class="glyphicon glyphicon-list-alt form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
							<label class="control-label"> Date of Current Appointment </label>
								<sf:input type="date" class="form-control" path="startDate"
									id="startDate" value="${career.startDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</sf:form>

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
						<sf:form action="/updateEducation" method="post" id="educationEditFrm" modelAttribute="education">
							 <sf:input type="hidden" path="id"
								value="${education.id}" />
							 <sf:input type="hidden" path="uid"
								value="${education.uid}" />

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="level" id="level" maxlength="20"
									placeholder="Level eg. Degree" value="${education.level}" /> <span
									class="glyphicon glyphicon-book form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="award" id="award" maxlength="40"
									placeholder="Award e.g BSc.Envirometal Management" value="${education.award}" /> <span
									class="glyphicon glyphicon-education form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="institution"
									id="institution" placeholder="Institution eg Makerere University" maxlength="50"
									value="${education.institution}" /> <span
									class="glyphicon glyphicon-map-marker form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="website"
									id="website" placeholder="Institutional Website eg www.kyu.ac.ug" maxlength="30"
									value="${education.website}" /> <span
									class="glyphicon glyphicon-cloud form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
							<label class="control-label"> Date of Completion: </label>
								<sf:input type="date" class="form-control" path="completionDate"
									id="completionDate" value="${education.completionDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback float-right">

								<div class="col-xs-4">
									<button type="submit" name="submit"
										class="btn btn-primary btn-block btn-flat">Update</button>
								</div>
							</div>


						</sf:form>

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
						<form enctype="multipart/form-data" action="/updateEvent"
							method="post" id="submitEventFrm">
							 <input type="hidden" name="id"
								value="${event.id}" /><input type="hidden" name="uid"
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
									id="imageFile" placeholder="imageFile"
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
						<sf:form action="/updateSkill" method="post" id="skillEditFrm" modelAttribute="skillTalent">
							<sf:input type="hidden" path="id"
								value="${skill.id}" />
							<sf:input type="hidden" path="uid"
								value="${skill.uid}" />

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="name1" id="name1"
									placeholder="First Skill / Telent Name"
									value="${skillTalent.name1}" /> <span
									class="glyphicon glyphicon-education form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="name2" id="name2"
									placeholder="Second Skill / Telent Name"
									value="${skillTalent.name2}" /> <span
									class="glyphicon glyphicon-heart-empty form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="name3" id="name3"
									placeholder="Third Skill / Telent Name"
									value="${skillTalent.name3}" /> <span
									class="glyphicon glyphicon glyphicon-heart form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="name4" id="name4"
									placeholder="Fourth Skill / Telent Name"
									value="${skillTalent.name4}" /> <span
									class="glyphicon glyphicon-star form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="name5" id="name5"
									placeholder="Fifth Skill / Telent Name"
									value="${skillTalent.name5}" /> <span
									class="glyphicon glyphicon-star-empty form-control-feedback"></span>
							</div>

							<div class="form-group has-feedback">
								<sf:input type="text" class="form-control" path="description"
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


						</sf:form>

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
						<form enctype="multipart/form-data" action="/addAdvert"
							method="post" id ="advertEditFrm">
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
							<label class="control-label">Start running on:</label>
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
									id="itemAmount" placeholder="Price of Item / Service" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="website"
									id="website" placeholder="Product Website" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="transactionId"
									id="transactionId" placeholder="Mobile Money Transaction Id and/or Phone number" />
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
										class="btn btn-primary btn-block btn-flat">Create</button>
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
						<c:set var="count1" value="0" scope="page" />

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
									
									<a href="javascript:void(0);" onclick="countNegative('${user.id}','${displayadd.id}','${displayadd.uid}')">
						
						
											<i class="fa fa-times fa-2x margin-r-5"></i> Negative
					

									</a>
										

									</li>

									<li>
									
									
									<a href="javascript:void(0);" onclick="countPositive('${user.id}','${displayadd.id}','${displayadd.uid}')">
						
						
							<i class="fa fa-check fa-2x margin-r-5"></i> Positive
					

					</a>
					

									</li>
									
									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm noReview${displayadd.id}">Reviews
											(${displayadd.noReviews})</a></li>
									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm noPositive${displayadd.id}" > 
											Positives
											(${displayadd.noPositives})
									</a></li>

									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm  noNegative${displayadd.id}">Negatives
											(${displayadd.noNegatives})</a></li>


								</ul>
								
								
								<div class="box-body no-padding">
									<div class="row">
										<div class="col-md-12 col-sm-12">
											<div class="pad">
											<div class="direct-chat-msg realtimeReview" style="display:none" >
											
											<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${user.firstName} ${user.otherNames}</span>
									<span class="direct-chat-timestamp pull-right">
										Right Now</span>
								</div>
								
								<img class="direct-chat-img"
										src="/uploads/${user.id}/profile/${user.imageLink}"
										alt="message user image">
											
											<div class="direct-chat-text thisreview"></div>
											</div>

												
													<c:forEach items="${displayadd.reviews}" var="dreview">

							<!-- the comments comme hear -->
							<div class="direct-chat-msg pad">
								<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${dreview.fullName }</span>
									<span class="direct-chat-timestamp pull-right">
										${dreview.rCreateDate }</span>
								</div>
								<!-- /.direct-chat-info -->

								<c:if test="${dreview.rImageLink!=''}">
									<img class="direct-chat-img"
										src="/uploads/${dreview.rUid}/profile/${dreview.rImageLink}"
										alt="message user image">

								</c:if>
								<c:if test="${dreview.rImageLink==''}">
									<img class="direct-chat-img" src="/dist/img/profile.jpg"
										alt="message user image">

								</c:if>

								<!-- /.direct-chat-img -->
								<div class="direct-chat-text">${dreview.rDescription}</div>
								<!-- /.direct-chat-text -->
							</div>

						</c:forEach>
												

										<c:if test="${count1<=0}">
												<div class="box-footer">
													<form action="/addReview" method="post" id="addReviewFrm">

														 <input type="hidden"
															name="auid" value="${displayadd.uid}" />
														 <input type="hidden"
															name="aid" value="${displayadd.id}" />
															
															<input
															type="hidden" name="uid" value="${user.id}" />
														<div class="input-group">
															<input type="text" name="description"
																placeholder="Write your Advert Review ... before another advert is added "
																class="form-control"> <span
																class="input-group-btn">
																<button type="submit" name="submit"
																	class="btn btn-warning btn-flat">Add Review</button>
															</span>
														</div>
													</form>
												</div>
												
												</c:if>


											</div>
										</div>


										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>
								<c:set var="count1" value="${count1 + 1}" scope="page"/>

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
						<c:set var="count4" value="0" scope="page" />

							<c:forEach items="${dcatEvents}" var="dcatEvent">
							<c:if test="${not empty dcatEvent.ename}">
							
								<a><h5>${dcatEvent.ename}</h5></a>
								<p>
								<h5>${dcatEvent.description}</h5>
								</p>
								<h4>
										<a href="/profile?wuid=${dcatEvent.uid}"> <span
											class="label label-success pull-left"> By
												${dcatEvent.byname}</span></a> <span
											class="label label-success pull-right">${dcatEvent.eventDate}</span>
									</h4>
								


								<div class="product-img">
										<c:if test="${dcatEvent.imageLink!=''}">



											<a
												href="/uploads/${dcatEvent.uid}/events/${dcatEvent.imageLink}"><img
												class="img-responsive"
												src="/uploads/${dcatEvent.uid}/events/${dcatEvent.imageLink}"
												alt="user image"> </a>

										</c:if>
										<c:if test="${dcatEvent.imageLink==''}">
											<img class="img-responsive" src="dist/img/default-50x50.gif"
												alt="Product Image">

										</c:if>

									</div>

								<ul class="list-inline">
									<li>
									
									<a href="javascript:void(0);" onclick="countNotGoing('${user.id}','${dcatEvent.id}','${dcatEvent.uid}')">
						
						
											<i class="fa fa-times fa-2x margin-r-5"></i> Not going
					

									</a>
										

									</li>

									<li>
									
									
									<a href="javascript:void(0);" onclick="countGoing('${user.id}','${dcatEvent.id}','${dcatEvent.uid}')">
						
						
							<i class="fa fa-check fa-2x margin-r-5"></i> Going
					

					</a>
					

									</li>
									
									
									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm noGoing${dcatEvent.id}" > 
											Going
											(${dcatEvent.going})
									</a></li>

									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm  noNotGoing${dcatEvent.id}">Not Going
											(${dcatEvent.notGoing})</a></li>
											
									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm noAnalysis${dcatEvent.id}">Analysis
											(${dcatEvent.noAnalysis})</a></li>


								</ul>
								
								
								<div class="box-body no-padding">
									<div class="row">
										<div class="col-md-12 col-sm-12">
											<div class="pad">
											
											<div class="direct-chat-msg realtimeAnalysis"  style="display:none">
								<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${user.firstName} ${user.otherNames}</span>
									<span class="direct-chat-timestamp pull-right">
										Right Now</span>
								</div>
								<img class="direct-chat-img"
										src="/uploads/${user.id}/profile/${user.imageLink}"
										alt="message user image">
								
								<div class="direct-chat-text thisanalysis"></div>
								</div>

												
													<c:forEach items="${dcatEvent.danalysiss}" var="danalysis">

							<!-- the comments comme hear -->
							<div class="direct-chat-msg">
								<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${danalysis.fullName }</span>
									<span class="direct-chat-timestamp pull-right">
										${danalysis.aCreateDate }</span>
								</div>
								<!-- /.direct-chat-info -->

								<c:if test="${danalysis.aImageLink!=''}">
									<img class="direct-chat-img"
										src="/uploads/${danalysis.aUid}/profile/${danalysis.aImageLink}"
										alt="message user image">

								</c:if>
								<c:if test="${danalysis.aImageLink==''}">
									<img class="direct-chat-img" src="/dist/img/profile.jpg"
										alt="message user image">

								</c:if>

								<!-- /.direct-chat-img -->
								<div class="direct-chat-text">${danalysis.aDescription}</div>
								<!-- /.direct-chat-text -->
							</div>
							

						</c:forEach>
						
											

										<c:if test="${count4<=0}">
												<div class="box-footer">
													<form action="/addAnalysis" method="post" id="addAnalyisFrm">

														 <input type="hidden"
															name="euid" value="${dcatEvent.uid}" />
														 <input type="hidden"
															name="eid" value="${dcatEvent.id}" />
															<input
															type="hidden" name="uid" value="${user.id}" />
														<div class="input-group">
															<input type="text" name="description"
																placeholder="Write your Event Review ... before another event is added "
																class="form-control"> <span
																class="input-group-btn">
																<button type="submit" name="submit"
																	class="btn btn-warning btn-flat">Add Analysis</button>
															</span>
														</div>
													</form>
												</div>
												
												</c:if>


											</div>
										</div>


										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>
								<c:set var="count4" value="${count4 + 1}" scope="page"/>
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
						<form enctype="multipart/form-data" action="/addJobadd"
							method="post" id ="jobAddFrm">

							 <input type="hidden" name="uid"
								value="${user.id}" /> <input type="hidden" name="catid"
								value="${user.catid}" /> 
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
								<input type="text" class="form-control" name="compName"
									id="compName" placeholder="Company Name" /> <span
									class="glyphicon glyphicon-align-justify form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="compWeb"
									id="compWeb" placeholder="Company Website" /> <span
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
								<label for="deadline">Deadline Applying</label> <input type="date"
									class="form-control" name="deadline" id="advertDate" /> <span
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
						<h4 class="modal-title">Review Jobs Adverts Dialog box</h4>

					</div>


					<div class="modal-body">

						<div class="box box-success">
						<c:set var="count4" value="0" scope="page" />

							<c:forEach items="${dcatJobadds}" var="dcatjob">
							<c:if test="${not empty dcatjob.adByName}">
							
								<a><h5>${dcatjob.compName} wants (${dcatjob.noPositions}) ${dcatjob.jobTitle}(s)</h5></a>
								<p>
								<h5>${dcatjob.description}</h5>
								
								<h5> Website:<a href="https://${dcatjob.compWeb}" target="_blank">${dcatjob.compWeb} </a></h5>
								</p>
								
								<h4>
										<a href="/profile?wuid=${dcatjob.jauid}"> <span
											class="label label-warning">Added By
												${dcatjob.adByName} on ${dcatjob.addDate}</span></a>
									</h4>
									
									<h4>
 										<span class="label label-success pull-left">Salary ${dcatjob.salary}</span> 
 										<span class="label label-danger pull-right">Deadline ${dcatjob.deadline}</span> 
 									</h4>
								


								<div class="product-img">
										<c:if test="${dcatjob.imageLink!=''}">
											<a
												href="/uploads/${dcatjob.jauid}/jobadds/${dcatjob.imageLink}"><img
												class="img-responsive"
												src="/uploads/${dcatjob.jauid}/jobadds/${dcatjob.imageLink}"
												alt="user image"> </a>

										</c:if>
										<c:if test="${dcatjob.imageLink==''}">
											<img class="img-responsive" src="dist/img/default-50x50.gif"
												alt="Product Image">

										</c:if>

									</div>
									<div class="pt-2">

								<ul class="list-inline">
									<li>
									
									<a href="javascript:void(0);" onclick="countNotRecommed('${user.id}','${dcatjob.jaid}','${dcatjob.jauid}')">
						
						
											<i class="fa fa-times fa-2x margin-r-5"></i> Un-Recommend 
					

									</a>
										

									</li>

									<li>
									
									
									<a href="javascript:void(0);" onclick="countRecommed('${user.id}','${dcatjob.jaid}','${dcatjob.jauid}')">
						
						
							<i class="fa fa-check fa-2x margin-r-5"></i> Recommend
					

					</a>
					

									</li>
									
									
									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm noRecommend${dcatjob.jaid}" > 
											Recommends
											(${dcatjob.noRecom})
									</a></li>

									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm  noNotRecomend${dcatjob.jaid}">Un-Recommends
											(${dcatjob.noNotRecom})</a></li>
											
									<li class="pull-right"><a href="javascript:void(0);"
										class="link-black text-sm noRecommendations${dcatjob.jaid}">Written
											(${dcatjob.noRecomendations})</a></li>


								</ul>
								</div>
								
								
								<div class="box-body no-padding">
									<div class="row">
										<div class="col-md-12 col-sm-12">
											<div class="pad">
											
											<div class="direct-chat-msg realtimeRecomm"  style="display:none">
								<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${user.firstName} ${user.otherNames}</span>
									<span class="direct-chat-timestamp pull-right">
										Right Now</span>
								</div>
								<img class="direct-chat-img"
										src="/uploads/${user.id}/profile/${user.imageLink}"
										alt="message user image">
								
								<div class="direct-chat-text thisRecomm"></div>
								</div>

												
													<c:forEach items="${dcatjob.dwRecos}" var="drecommeds">

							<!-- the comments comme hear -->
							<div class="direct-chat-msg">
								<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${drecommeds.fullName }</span>
									<span class="direct-chat-timestamp pull-right">
										${drecommeds.rCreateDate }</span>
								</div>
								<!-- /.direct-chat-info -->

								<c:if test="${drecommeds.rImageLink!=''}">
									<img class="direct-chat-img"
										src="/uploads/${drecommeds.rUid}/profile/${drecommeds.rImageLink}"
										alt="message user image">

								</c:if>
								<c:if test="${drecommeds.rImageLink==''}">
									<img class="direct-chat-img" src="/dist/img/profile.jpg"
										alt="message user image">

								</c:if>

								<!-- /.direct-chat-img -->
								<div class="direct-chat-text">${drecommeds.rDescription}</div>
								<!-- /.direct-chat-text -->
							</div>
							

						</c:forEach>
						
											

										<c:if test="${count4<=0}">
												<div class="box-footer">
													<form action="/addRecommend" method="post" id="addRecommendFrm">

														 <input type="hidden"
															name="jaid" value="${dcatjob.jaid}" />
														 <input type="hidden"
															name="jauid" value="${dcatjob.jauid}" /><input
															type="hidden" name="uid" value="${user.id}" />
														<div class="input-group">
															<input type="text" name="description"
																placeholder="Write your Recommendations ... before another event is added "
																class="form-control"> <span
																class="input-group-btn">
																<button type="submit" name="submit"
																	class="btn btn-warning btn-flat">Add Recommendations</button>
															</span>
														</div>
													</form>
												</div>
												
												</c:if>


											</div>
										</div>


										<!-- /.col -->
									</div>
									<!-- /.row -->
								</div>
								<c:set var="count4" value="${count4 + 1}" scope="page"/>
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
								<input type="email" class="form-control" name="iemail"
									id="iemail" placeholder="Enter Email of Invitie" /> <span
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
	<script src="bower_components/jquery/js/jquery.boot2.js"></script>
	<script src="bower_components/jquery/js/jquery.save2.js"></script>
	

	<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
	<script src="dist/js/pages/dashboard2.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/dist/js/demo.js"></script>
</body>
</html>
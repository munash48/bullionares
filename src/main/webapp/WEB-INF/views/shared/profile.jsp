<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-8">
	<!-- Content Header (Page header) -->
	<div class="pad margin no-print">
		<div class="callout callout-info" style="margin-bottom: 0 !important;">
			<h4>
				<i class="fa fa-info"></i> User Profile:
			</h4>
			The profile has been enhanced for printing.
		</div>
	</div>

	<!-- Main content -->
	<section class="invoice">
		<!-- title row -->
		<div class="row">
			<div class="col-xs-12">
				<h2 class="page-header">
					<i class="fa fa-globe"></i> Billionare Profile <small
						class="pull-right">Member since ${user.joinDate} | points
						${counter.total} </small>
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
				<strong>${user.firstName} ${user.otherNames}</strong><br> <b>${user.profession}</b>
				<br>

			</div>
			<!-- /.col -->
			<div class="col-sm-4 invoice-col">
				<u>Bio data</u>
				<address>

					D.O.B: <b>${user.birthDate} </b><br> E-Mail: <b>${user.email}
					</b><br> Tel.: <b>${user.phoneNumber} </b><br> <u>Specialization</u>
					<br> Education: <b>${education.award}</b> <br>

				</address>
			</div>
			<!-- /.col -->
			<div class="col-sm-4 invoice-col">
				<u>Personal Address</u> <br> Country: <b>${address.country}</b><br>
				District: <b>${address.district}</b><br> Division: <b>${address.division}</b><br>
				Village: <b>${address.village}</b><br> Street: <b>${address.street}</b><br>
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
			<p>I am a ${career.jobTitle} at ${company.name} specializing in
				${career.specialization}. ${career.description}</p>
			<P>We deal in ${company.type}My company is located at
				${company.website} and ${company.address}</P>



		</div>
		<div class="text-muted well well-sm no-shadow">
			<u><b>Education</b></u> <br>
			<p>My highest level of education is a ${peducation.level} as at
				${education.completionDate}. I have a ${education.award} from
				${education.institution} found on ${education.website}.</p>



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
		<div class="row no-print">
			<div class="col-xs-12">
				<a href="/profile-print?wuid=${puser.id}" target="_blank"
					class="btn btn-default"><i class="fa fa-print"></i> Print</a>

				<button type="button" class="btn btn-primary pull-right"
					style="margin-right: 5px;">
					<i class="fa fa-download"></i> Generate PDF
				</button>
			</div>
		</div>
	</section>
	<!-- /.content -->
	<div class="clearfix"></div>
</div>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-md-3 pt-4">

	<!-- Profile Image -->
	<div class="box box-warning">
		<div class="box-body box-profile">
			<div class="imgcontainer">


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



				<button type="button" data-toggle="modal" data-target="#imageEdit"
					class="imgbtn">Edit</button>
			</div>
			<div class="row">
				<div class="col-md-8 text-right">
					<h3 class="profile-username text-right">${user.firstName}
						${user.otherNames}</h3>
				</div>

				<div class="col-md-4 text-left">
					<button type="button" data-toggle="modal"
						data-target="#profileEdit" class="btn probtn">
						<i class="fa fa-pencil" title="click to edit"
							data-toggle="tooltip" data-placement="right"></i>
					</button>
				</div>
			</div>

			<p class="text-muted text-center">${user.profession}</p>

			<ul class="list-group list-group-unbordered">
				<li class="list-group-item"><b>TOTAL POINTS</b> <a
					class="pull-right"> ${counter.total}</a></li>

				<li class="list-group-item"><b>COMPANY</b>

					<button type="button" data-toggle="modal"
						data-target="#companyEdit" class="btn probtn">
						<i class="fa fa-pencil" title="click to edit"
							data-toggle="tooltip" data-placement="right"></i>
					</button> <a class="pull-right">${company.name}</a></li>
				<li class="list-group-item"><b>JOB TITLE</b>

					<button type="button" data-toggle="modal" data-target="#careerEdit"
						class="btn probtn">
						<i class="fa fa-pencil" title="click to edit"
							data-toggle="tooltip" data-placement="right"></i>
					</button> <a class="pull-right">${career.jobTitle},
						${career.specialization}</a></li>
			</ul>
			<div class="col-xs-12 col-md-6 margin-b-5">
				<button type="button" data-toggle="modal" data-target="#inviteUser"
						class="btn btn-primary btn-block">
						<b>Invite</b>
						
					</button>
			</div>
			
			<div class="col-xs-12 col-md-6 pt-2">
				<a href="javascript:void(0);" class="btn btn-primary btn-block" id ="fullprofile"><b>Full
						Profile</b></a>
			</div>
		</div>
		<!-- /.box-body -->
	</div>
	<!-- /.box -->

	<!-- About Me Box -->
	<div class="box box-warning">
		<div class="box-header with-border">
			<h3 class="box-title">About Me</h3>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<strong><i class="fa fa-briefcase margin-r-5"
				aria-hidden="true"></i>Work & Career</strong>

			<p class="text-muted">${career.description}</p>
			<hr>

			<strong><i class="fa fa-book margin-r-5"></i> Education</strong>
			<button type="button" data-toggle="modal"
				data-target="#educationEdit" class="btn probtn">
				<i class="fa fa-pencil" title="click to edit" data-toggle="tooltip"
					data-placement="right"></i>
			</button>

			<p class="text-muted">${education.award}</p>

			<hr>

			<strong><i class="fa fa-map-marker margin-r-5"></i>Address</strong>
			<button type="button" data-toggle="modal" data-target="#addressEdit"
				class="btn probtn">
				<i class="fa fa-pencil" title="click to edit" data-toggle="tooltip"
					data-placement="right"></i>
			</button>
			<p class="text-muted">${address.country},${address.district},
				${address.division}</p>

			<hr>

			<strong><i class="fa fa-certificate margin-r-5"
				aria-hidden="true"></i> Skills / Talent / Hobbies</strong>
			<button type="button" data-toggle="modal" data-target="#skillEdit"
				class="btn probtn">
				<i class="fa fa-pencil" title="click to edit" data-toggle="tooltip"
					data-placement="right"></i>
			</button>

			<p>
				<span class="label label-danger">${skillTalent.name1} </span> <span
					class="label label-success">${skillTalent.name2}</span> <span
					class="label label-info">${skillTalent.name3} </span> <span
					class="label label-warning">${skillTalent.name4}</span> <span
					class="label label-primary">${skillTalent.name5}</span>
			</p>
			<hr>
			<strong><i class="fa fa-map-marker margin-r-5"></i>My events</strong>
			<button type="button" data-toggle="modal" data-target="#eventEdit"
				class="btn probtn">
				<i class="fa fa-pencil" title="click to edit" data-toggle="tooltip"
					data-placement="right"></i>
			</button>
			<p class="text-muted">
				Don't miss my <i>${event.ename},</i> ${event.description} .
				Scheduled for ${event.eventDate}
			</p>
			<c:if test="${event.imageLink==''|| event.imageLink==null}">
				<img class="img-responsive pad" src="/dist/img/photo2.jpg"
					alt="No Event Photo">
			</c:if>
			<c:if test="${event.imageLink!=''&& event.imageLink!=null}">
				<img class="img-responsive pad"
					src="/uploads/${user.id}/events/${event.imageLink}"
					alt="Event Photo">
			</c:if>



			<hr>

			<strong><i class="fa fa-file-text-o margin-r-5"></i> Who I
				am</strong>
	

			<p>${user.aboutme}</p>
		</div>
		<!-- /.box-body -->
	</div>
	<div class="box box-warning">
		<div class="box-header with-border">
			<h3 class="box-title">Latest Category Members</h3>

			<div class="box-tools pull-right">
				<span class="label label-danger">8 New Members</span>
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-widget="remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<ul class="users-list clearfix">
			
				<c:forEach items="${cUsers}" var="cUser">

					<li>
					<c:if test="${cUser.imageLink!=''}">
					<img class="img-circle img-bordered-sm"
						src="/uploads/${cUser.id}/profile/${cUser.imageLink}"
						alt="User Image" >

				</c:if>
				<c:if test="${cUser.imageLink==''}">
					<img class="img-circle img-bordered-sm"
						src="/dist/img/profile.jpg" alt="User Image"
						>

				</c:if>
					
						<a class="users-list-name" href="/message?wuid=${cUser.id}">${cUser.firstName}<br> ${cUser.otherNames}</a> </li>
				</c:forEach>
			</ul>
			<!-- /.users-list -->
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-center">
			<a href="javascript:void(0)" class="uppercase">View Top Category
				Users</a>
		</div>
		<!-- /.box-footer -->
	</div>
	<!-- /.box -->
	

</div>


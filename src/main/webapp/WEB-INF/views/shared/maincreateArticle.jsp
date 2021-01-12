<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
	<c:if test="${ModeImgUpload==true}">
		<div class="col-md-12">
			<div class="col-md-8">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>

					${imgupload}

				</div>
			</div>
			<div class="col-md-4">
				<button type="button"
					class="btn btn-info btn-lg btn-block spinner-glow  spinner-glow-sm"
					id="mainpostbtn1">
					<span class="glyphicon glyphicon-bullhorn"></span> Create Article

				</button>
			</div>

		</div>
	</c:if>
	<c:if test="${ModeJustLogged==true}">
		<div class="col-xs-12">
			<div class="col-md-8">
				<div class="alert alert-warning alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${greeting} 

				</div>
			</div>
			<div class="col-md-4">
				<a type="button"
					class="btn btn-info btn-lg btn-block spinner-glow  spinner-glow-sm"
					href="/home">
					 <i
						class="glyphicon glyphicon-bullhorn"></i> Create Article
				

				</a>
			</div>


		</div>
	</c:if>
	<c:if test="${ModeJustFailedVote==true}">
		<div class="col-xs-12">
			<div class="alert alert-danger alert-dismissible">

				<button type="button" class="close" data-dismiss="alert">&times;</button>
				${votefail}

			</div>

		</div>
	</c:if>
	<c:if test="${ModeNotUpdated==true}">

		<div class="col-xs-12">
			<div class="alert alert-danger alert-dismissible">

				<button type="button" class="close" data-dismiss="alert">&times;</button>

				<p>-------------------------------------------</p>
				<h3>Your profile is not complete</h3>
				<h4> Use the <i class="fa fa-pencil" title="click to edit"
							data-toggle="tooltip" data-placement="right"></i>(button) to edit or update your profile, adverts and job adds</h4>
				<h4>Use the <i class="fa fa-eye" title="click to view all adds" data-toggle="tooltip"
						data-placement="right"></i> (button) to view entries in Adverts, Upcoming events and Job adds</h4>		


				<h3>Complete your profile in order to post</h3>
				<p>--------------------------------------------</p>


			</div>

		</div>
	</c:if>


</div>
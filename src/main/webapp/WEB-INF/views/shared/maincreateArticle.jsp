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
					id="mainpostbtn">
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
				<button type="button"
					class="btn btn-info btn-lg btn-block spinner-glow  spinner-glow-sm"
					id="mainpostbtn">
					 <i
						class="glyphicon glyphicon-bullhorn"></i> Create Post
				

				</button>
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


				<h3>Complete your profile in order to post</h3>
				<p>--------------------------------------------</p>


			</div>

		</div>
	</c:if>


</div>

<section class="content">


	<div class="row">
		<section class="content-header">
			<h1>.</h1>

		</section>
	</div>
	<div class="row">
		<!-- USER SIDE BAR -->
		<%@include file="usersidebar.jsp"%>
		<!-- /.col -->
		<div class="col-md-9 pt-4">
			<div class="row">

				<%@include file="userpoints.jsp"%>
			</div>

			<div class="rrow">
				<!-- MAIN POST  -->
				<c:if test="${ModeLogged==true}">
				<%@include file="./mainpost.jsp"%>
				</c:if>
				<c:if test="${modeMessage==true}">
				<%@include file="./chat.jsp"%>
				</c:if>
				<c:if test="${modeProfile==true}">
				<%@include file="./profile.jsp"%>
				</c:if>
				<c:if test="${modeEvents==true}">
				<%@include file="./events.jsp"%>
				</c:if>
				<c:if test="${modeJobs==true}">
				<%@include file="./jobs.jsp"%>
				</c:if>
				<c:if test="${modeChart==true}">
				<%@include file="./chart.jsp"%>
				</c:if>
				<%@include file="./advertbar.jsp"%>
				


				

			</div>
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->

</section>

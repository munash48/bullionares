<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="bower_components/jquery/js/jquery.save.js"></script>
<script src="bower_components/jquery/js/jquery.boot.js"></script>

<div class="login-box">
	<!-- /.login-logo -->

	<div class="row">

		<c:if test="${success!=null}">
		
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${success}
				</div>

			</div>
		</c:if>
			
			<c:if test="${logout!=null}">
			<div class="col-xs-12">
				<div class="alert alert-warning alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${logout}

				</div>

			</div>
		</c:if>
		<c:if test="${error!=null}">
			<div class="col-xs-12">
				<div class="alert alert-danger alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${error}

				</div>

			</div>
		</c:if>


	</div>
	<c:if test="${ModeReset}">

	<div class="login-box-body">
		<p class="login-box-msg">Get reset link</p>


		<form action="/resete" method="post" id="resetEmail">
			<div class="form-group has-feedback">
				<input name="email" type="email" class="form-control" placeholder="Enter your Email">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>

			</div>

			<div class="row">

				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" name="submit" class="btn btn-primary btn-block btn-flat">Send Link
						</button>
				</div>
				<!-- /.col -->
			</div>
		</form>


	</div>
	
	</c:if>
	
	<!-- /.login-box-body -->

</div>

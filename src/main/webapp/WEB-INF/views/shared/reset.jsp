
<div class="login-box">
	<!-- /.login-logo -->

	<div class="row">

		<c:if test="${ModeJustRegistered==true}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${success}


				</div>

			</div>
		</c:if>
			
			<c:if test="${ModeReset==true||ModeResetLink==true||ModeResetCode==true}">
			<div class="col-xs-12">
				<div class="alert alert-warning alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${logout}

				</div>

			</div>
		</c:if>
		<c:if test="${logingin==true}">
			<div class="col-xs-12">
				<div class="alert alert-danger alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${error}

				</div>

			</div>
		</c:if>


	</div>
	<c:if test="${ModeReset==true}">

	<div class="login-box-body">
		<p class="login-box-msg">Get reset link</p>


		<form action="/resete" method="post">
			<div class="form-group has-feedback">
				<input name="email" type="email" class="form-control" placeholder="Enter your Email">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				<sec:csrfInput /> 
			</div>

			<div class="row">

				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">Send Link
						</button>
				</div>
				<!-- /.col -->
			</div>
		</form>


	</div>
	</c:if>
	<c:if test="${ModeResetCode==true}">
	
	<div class="login-box-body">
		<p class="login-box-msg">Reset your password</p>


		<form action="/reset" method="post">
			<div class="form-group has-feedback">
				<input name="password" type="password" class="form-control" placeholder="Enter new password">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				
			</div>
			<div class="form-group has-feedback">
				<input name="confirm" type="password" class="form-control" placeholder="Confirm new password">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				<sec:csrfInput /> 
			</div>
			<div class="row">

				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat"> Save Password
						</button>
				</div>
				<!-- /.col -->
			</div>
			<input name="resetcode" type="hidden" class="form-control" value="${resetcode}">
		</form>


	</div>
	</c:if>
	<!-- /.login-box-body -->

</div>

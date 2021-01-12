<div class="login-box">
	<!-- /.login-logo -->

	<c:if test="${ModeLogin}">
	

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
				<div class="alert alert-success alert-dismissible">

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

	<div class="login-box-body">
		<p class="login-box-msg">Sign in to start your session</p>


		<form action="/" method="post">
			<div class="form-group has-feedback">
				<input name="username" type="email" class="form-control" placeholder="Email">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name ="password" type="password" class="form-control" placeholder="Password">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				<sec:csrfInput /> 
			</div>
			<div class="row">
				<div class="col-xs-8">
					<div class="checkbox icheck">
						<label> <input type="checkbox"> Remember Me
						</label>
					</div>
				</div>
				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
						In</button>
				</div>
				<!-- /.col -->
			</div>
		</form>


		<!-- /.social-auth-links -->


		<a href="javascript:void(0);" id="restForm">I forgot my password</a><br> <a href="javascript:void(0);" id="regForm2"
			class="text-center">Register a new membership</a>

	</div>
	<script src="bower_components/jquery/js/jquery.save.js"></script>
	<!-- /.login-box-body -->
</c:if>

<c:if test="${ModeResetCode}">
<c:if test="${reset!=null}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${logout}

				</div>

			</div>
		</c:if>
	<script src="bower_components/jquery/js/jquery.save.js"></script>
	
	<div class="login-box-body">
		<p class="login-box-msg">Reset your password</p>


		<form action="/reset" method="post" id="submitPassRest">
			<div class="form-group has-feedback">
				<input name="password" type="password" class="form-control" placeholder="Enter new password" required pattern = "(?=.*\d)(?=.*[a-z])(?=.*?[0-9])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{6,}" title="Must contain at least 1 no., 1 upper, 1 lowercase letter and 1 special character at least 6">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				
			</div>
			<div class="form-group has-feedback">
				<input name="confirm" type="password" class="form-control" placeholder="Confirm new password" required  pattern = "(?=.*\d)(?=.*[a-z])(?=.*?[0-9])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{6,}" title="Must contain at least 1 no., 1 upper, 1 lowercase letter and 1 special character at least 6" >
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				<sec:csrfInput /> 
			</div>
			<input  type="hidden" name="resetcode" class="form-control" value="${resetcode}">
			<div class="row">

				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat"> Save Password
						</button>
				</div>
				<!-- /.col -->
			</div>
			
		</form>


	</div>
	<script src="bower_components/jquery/js/jquery.update.js"></script>
	</c:if>
</div>

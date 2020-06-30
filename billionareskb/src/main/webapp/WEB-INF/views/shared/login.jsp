
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
			<c:if test="${ModeJustLoggedOut==true}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${logout}

				</div>

			</div>
		</c:if>
			<c:if test="${ModeSessionEx==true}">
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

	<div class="login-box-body">
		<p class="login-box-msg">Sign in to start your session</p>


		<form action="/login" method="post">
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


		<a href="#">I forgot my password</a><br> <a href="register.html"
			class="text-center">Register a new membership</a>

	</div>
	<!-- /.login-box-body -->

</div>

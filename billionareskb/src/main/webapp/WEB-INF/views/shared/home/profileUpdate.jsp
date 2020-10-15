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
						<!--modal form-->
						<form enctype="multipart/form-data" action="/home/updateUser"
							method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uId"
								value="${user.id}" />

							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="firstName"
									id="firstName" placeholder="First Name"
									value="${user.firstName}" /> <span
									class="glyphicon glyphicon-user form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="otherNames"
									id="otherNames" placeholder="Other Names"
									value="${user.otherNames}" /> <span
									class="glyphicon glyphicon-plus form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="phoneNumber"
									id="phoneNumber" placeholder="Phone Number"
									value="${user.phoneNumber}" /> <span
									class="glyphicon glyphicon-phone form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Email" value="${user.email}" /> <span
									class="glyphicon glyphicon-envelope form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="text" class="form-control" name="profession"
									id="profession" placeholder="Your Profession"
									value="${user.profession}" /> <span
									class="glyphicon glyphicon-star form-control-feedback"></span>
							</div>
							<div class="form-group has-feedback">
								<input type="date" class="form-control" name="birthDate"
									id="birthDate" value="${user.birthDate}" /> <span
									class="glyphicon glyphicon-calendar form-control-feedback"></span>
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
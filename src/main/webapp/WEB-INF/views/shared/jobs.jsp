<div class="col-md-8">
	<div class="box box-info">
		<div class="row">

			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Review Jobs page</h4>

					</div>


					<div class="modal-body">

						<div class="box box-success">

							<c:forEach items="${catJobadds}" var="catJobadd">
								<c:if test="${not empty catJobadd.jobTitle}">
									<a><h5>(${catJobadd.noPositions})
											${catJobadd.jobTitle} (s)</h5></a>
									<p>
									<h5>${catJobadd.description}</h5>
									</p>
									<h4>
										<span class="label label-success pull-left">${catJobadd.salary}</span>
										<span class="label label-danger pull-right">${catJobadd.deadline}</span>
									</h4>


									<div class="product-img">
										<c:if test="${catJobadd.imageLink!=''}">



											<a target="_blank"
												href="/uploads/${catJobadd.uid}/jobadds/${catJobadd.imageLink}"><img
												class="img-responsive"
												src="/uploads/${catJobadd.uid}/jobadds/${catJobadd.imageLink}"
												alt="user image"> </a>

										</c:if>
										<c:if
											test="${catJobadd.imageLink==''|| catJobadd.imageLink==null}">
											<img class="img-responsive" src="dist/img/default-50x50.gif"
												alt="Product Image">

										</c:if>

									</div>

									<ul class="list-inline">
										<li>
											<form action="/home/addNotRecomend" method="post">
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" /> <input type="hidden" name="uid"
													value="${user.id}" /> <input type="hidden" name="jaid"
													value="${catJobadd.id}" />



												<button type="submit" class="btn btn-trans">
													<i class="fa fa-times fa-2x margin-r-5"></i> Not Recomended
												</button>

											</form>



										</li>

										<li>
											<form class="form-horizontal" action="/home/addRecomend"
												method="post">
												<input type="hidden" name="${_csrf.parameterName}"
													value="${_csrf.token}" /> <input type="hidden" name="uid"
													value="${user.id}" /> <input type="hidden" name="jaid"
													value="${catJobadd.id}" />



												<button type="submit" class="btn btn-trans">


													<i class="fa fa-check fa-2x margin-r-5"></i> Recomended

												</button>


											</form>

										</li>
										<li class="pull-right"><a href="#"
											class="link-black text-sm"> <i
												class="fa fa-check fa-2x margin-r-5"></i>Recomended
												(${catJobadd.recomended})
										</a></li>

										<li class="pull-right"><a href="#"
											class="link-black text-sm"><i
												class="fa fa-times fa-2x margin-r-5"></i>Not Recomemded
												(${catJobadd.notRecomended})</a></li>


									</ul>
								</c:if>


							</c:forEach>


						</div>


						<!--modal form-->

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
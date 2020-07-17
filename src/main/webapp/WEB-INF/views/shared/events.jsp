	<div class="col-md-8">
	<div class="box box-info">
	<div class="row">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span>&times;</span>
						</button>
						<h4 class="modal-title">Upcomming Events</h4>

					</div>


					<div class="modal-body">

						<div class="box box-success">

							<c:forEach items="${catEvents}" var="catEvent">
							<c:if test="${not empty catEvent.ename}">
								<a><h5>${catEvent.ename}</h5></a>
								<p>
								<h5>${catEvent.description}</h5>
								</p>
								<h4>
									<a href="/profile?wuid=${catEvent.uid}"> <span class="label label-success pull-left"> By ${catEvent.byname}</span></a>
									<span class="label label-success pull-right">${catEvent.eventDate}</span>
								</h4>


								<div class="product-img">
									<c:if test="${catEvent.imageLink!=''}">



										<a
											href="/uploads/${catEvent.uid}/events/${catEvent.imageLink}"><img
											class="img-responsive"
											src="/uploads/${catEvent.uid}/events/${catEvent.imageLink}"
											alt="user image"> </a>

									</c:if>
									<c:if test="${catEvent.imageLink==''}">
										<img class="img-responsive" src="dist/img/default-50x50.gif"
											alt="Product Image">

									</c:if>

								</div>

								<ul class="list-inline">
									<li>
										<form action="/home/addNotGoing" method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="eid"
												value="${catEvent.id}" />



											<button type="submit" class="btn btn-trans">
												<i class="fa fa-times fa-2x margin-r-5"></i> Not Going
											</button>

										</form>



									</li>

									<li>
										<form class="form-horizontal" action="/home/addGoing"
											method="post">
											<input type="hidden" name="${_csrf.parameterName}"
												value="${_csrf.token}" /> <input type="hidden" name="uid"
												value="${user.id}" /> <input type="hidden" name="eid"
												value="${catEvent.id}" />



											<button type="submit" class="btn btn-trans">


												<i class="fa fa-check fa-2x margin-r-5"></i> Going

											</button>


										</form>

									</li>
									<li class="pull-right"><a href="#"
										class="link-black text-sm"> <i
											class="fa fa-check fa-2x margin-r-5"></i>Not Going
											(${catEvent.notGoing})
									</a></li>

									<li class="pull-right"><a href="#"
										class="link-black text-sm"><i
											class="fa fa-times fa-2x margin-r-5"></i>Going
											(${catEvent.going})</a></li>


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
	
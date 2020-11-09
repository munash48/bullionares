<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<%-- 	//<c:if test="${not empty event.ename && not empty education.level &&not empty career.jobTitle&&not empty company.name&&not empty address.country&&not empty skillTalent.name1}"> --%>
	

	
	<!-- MAP & BOX PANE -->
	
	
<%-- 	</c:if> --%>

		<div class="box box-success">
			<div class="post">
				<div class="user-block">

					<c:if test="${display.userImageLink!=''}">
						<img class="img-circle img-bordered-sm"
							src="/uploads/${display.uid}/profile/${display.userImageLink}"
							alt="user image">

					</c:if>
					<c:if test="${display.userImageLink==''}">
						<img class="img-circle img-bordered-sm"
							src="/dist/img/profile.jpg" alt="user image">

					</c:if>

					<span class="username"> <a href="/profile?wuid=${display.uid}">${display.fullName}</a> <span
						class="description pull-right margin-r-5">Shared publicly -
							${display.artCreateDate}</span>
					</span>

				</div>
				<!-- /.user-block -->
				<p class="postcontent">${display.artDescription}</p>

				<c:if
					test="${not empty display.artVideoLink}">
					<iframe width="90%" height="315"
						src="https://www.youtube.com/embed/${display.artVideoLink}?&autoplay=1"
						frameborder="0" allowfullscreen></iframe>
				</c:if>
				<c:if
					test="${not empty display.artImageLink}">
					<img class="img-responsive"
						src="/uploads/${display.uid}/articles/${display.artImageLink}"
						alt="Photo">
				</c:if>
				<ul class="list-inline">
					<li>
						<form action="/home/addReportVote" method="post">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" /> <input type="hidden" name="uid"
								value="${user.id}" /> <input type="hidden" name="aid"
								value="${display.artid}" /> <input type="hidden" name="ouid"
								value="${display.uid}" />



							<button type="submit" class="btn btn-trans">
								<i class="fa fa-times fa-2x margin-r-5"></i> Cross
							</button>

						</form>



					</li>

					<li>
						<form class="form-horizontal" action="/home/addVote" method="post">
						 <input type="hidden" name="uid"
								value="${user.id}" /> <input type="hidden" name="aid"
								value="${display.artid}" /> <input type="hidden" name="ouid"
								value="${display.uid}" />


							<button type="submit" class="btn btn-trans">


								<i class="fa fa-check fa-2x margin-r-5"></i> Vote

							</button>


						</form>

					</li>
					<li class="pull-right"><a href="#" class="link-black text-sm">
							<i class="fa fa-check fa-2x margin-r-5"></i>Article Votes
							(${display.noVotes})
					</a></li>
					<li class="pull-right"><a href="#" class="link-black text-sm"><i
							class="fa fa-comments-o fa-2x margin-r-5"></i> All Opinions
							(${display.noOpinions})</a></li>
					<li class="pull-right"><a href="#" class="link-black text-sm"><i
							class="fa fa-times fa-2x margin-r-5"></i> All Reports
							(${display.noReports})</a></li>


				</ul>
			</div>
			<!-- /.box-header -->
			<div class="box-body no-padding inner-opinion">
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<div class="pad">

							<c:forEach items="${display.opinions}" var="dopinion">

								<!-- the comments comme hear -->
								<div class="direct-chat-msg">
									<div class="direct-chat-info clearfix">
										<span class="direct-chat-name pull-left">${dopinion.fullName }</span>
										<span class="direct-chat-timestamp pull-right">
											${dopinion.opCreateDate }</span>
									</div>
									<!-- /.direct-chat-info -->

									<c:if test="${dopinion.opImageLink!=''}">
										<img class="direct-chat-img"
											src="/uploads/${dopinion.opUid}/profile/${dopinion.opImageLink}"
											alt="message user image">

									</c:if>
									<c:if test="${dopinion.opImageLink==''}">
										<img class="direct-chat-img" src="/dist/img/profile.jpg"
											alt="message user image">

									</c:if>

									<!-- /.direct-chat-img -->
									<div class="direct-chat-text">${dopinion.opDescription}</div>
									<!-- /.direct-chat-text -->
								</div>

							</c:forEach>



							<div class="box-footer">
								<form action="/createOpinion" method="post" id="OpinionFrm">

									 <input type="hidden" name="artid"
										value="${display.artid}" /><input type="hidden" name="uid"
										value="${user.id}" />
									<div class="input-group">
										<input type="text" name="description"
											placeholder="Type Message ..." class="form-control">
										<span class="input-group-btn">
											<button type="submit" name="submit"
												class="btn btn-warning btn-flat">Add Opinion</button>
										</span>
									</div>
								</form>
							</div>


						</div>
					</div>


					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.box-body -->
		</div>



<script src="bower_components/jquery/js/jquery.saveChat.js"></script>


	<!-- /.box -->

	<!-- /.row -->

	<!-- TABLE: LATEST ORDERS -->

	<!-- /.box -->


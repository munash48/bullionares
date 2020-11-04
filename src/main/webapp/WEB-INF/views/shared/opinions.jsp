		<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

									<input type="hidden" name="${_csrf.parameterName}"
										value="${_csrf.token}" /> <input type="hidden" name="artid"
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
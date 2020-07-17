<div class="col-md-8">
	<div class="box box-warning direct-chat direct-chat-warning">
		<div class="box-header with-border">
			<h3 class="box-title">Direct Chat</h3>
			<h3 class="box-title">
				( <a href="/profile?wuid=${wuid}">${wFullName}</a> )
			</h3>

			<div class="box-tools pull-right">
				<span data-toggle="tooltip" title="3 New Messages"
					class="badge bg-yellow">3</span>
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-toggle="tooltip"
					title="Contacts" data-widget="chat-pane-toggle">
					<i class="fa fa-comments"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-widget="remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<!-- Conversations are loaded here -->
			<div class="direct-chat-messages">

				<c:forEach items="${myMassages}" var="mess">

					<c:if test="${mess.uid==user.id}">
						<!-- Message. Default to the left -->
						<div class="direct-chat-msg">
							<div class="direct-chat-info clearfix">
								<span class="direct-chat-name pull-left">${user.firstName}
									${user.otherNames}</span> <span
									class="direct-chat-timestamp pull-right">${mess.mdate}</span>
							</div>
							<!-- /.direct-chat-info -->

							<c:if test="${user.imageLink!=''}">
								<img class="direct-chat-img"
									src="/uploads/${user.id}/profile/${user.imageLink}"
									alt="message user image">

							</c:if>
							<c:if test="${user.imageLink==''}">
								<img class="direct-chat-img" src="/dist/img/profile.jpg"
									alt="message user image">

							</c:if>

							<!-- /.direct-chat-img -->
							<div class="direct-chat-text">${mess.message}</div>
							<!-- /.direct-chat-text -->
						</div>
						<!-- /.direct-chat-msg -->
					</c:if>
					<c:if test="${mess.uid==wuid}">


						<!-- Message to the right -->
						<div class="direct-chat-msg right">
							<div class="direct-chat-info clearfix">
								<span class="direct-chat-name pull-right">${wFullName}</span> <span
									class="direct-chat-timestamp pull-left">${mess.mdate}</span>
							</div>
							<!-- /.direct-chat-info -->
							<c:if test="${wImageLink!=''}">
								<img class="direct-chat-img"
									src="/uploads/${wuid}/profile/${wImageLink}"
									alt="message user image">

							</c:if>
							<c:if test="${wImageLink==''}">
								<img class="direct-chat-img" src="/dist/img/profile.jpg"
									alt="message user image">

							</c:if>
							<!-- /.direct-chat-img -->
							<div class="direct-chat-text">${mess.message}</div>
							<!-- /.direct-chat-text -->
						</div>
						<!-- /.direct-chat-msg -->
					</c:if>

				</c:forEach>



			</div>
			<!--/.direct-chat-messages-->




			<!-- Contacts are loaded here -->
			<div class="direct-chat-contacts">
				<ul class="contacts-list">
					<c:forEach items="${dmessages}" var="dmessage">
						<li><a href="/message?wuid=${dmessage.duid}"> <c:if test="${dmessage.dimageLink!=''}">
									<img class="direct-chat-img"
										src="/uploads/${dmessage.duid}/profile/${dmessage.dimageLink}"
										alt="message user image">

								</c:if> <c:if test="${dmessage.dimageLink==''}">
									<img class="direct-chat-img" src="/dist/img/profile.jpg"
										alt="message user image">

								</c:if>

								<div class="contacts-list-info">
									<span class="contacts-list-name"> ${dmessage.dfullName}
										<small class="contacts-list-date pull-right">${dmessage.dmdate}</small>
									</span> <span class="contacts-list-msg">${dmessage.dmessage}</span>
								</div> <!-- /.contacts-list-info -->
						</a></li>
					</c:forEach>
					
					
					<!-- End Contact Item -->
				</ul>
				<!-- /.contatcts-list -->
			</div>
			<!-- /.direct-chat-pane -->
		</div>
		<!-- /.box-body -->
		<div class="box-footer">
			<form action="/message/sendMessage" method="post">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <input type="hidden" name="uid"
					value="${user.id}" /> <input type="hidden" name="wuid"
					value="${wuid}" />
				<div class="input-group">
					<input type="text" name="message" placeholder="Type Message ..."
						class="form-control"> <span class="input-group-btn">
						<button type="submit" class="btn btn-warning btn-flat">Send</button>
					</span>
				</div>
			</form>
		</div>
		<!-- /.box-footer-->
	</div>
</div>

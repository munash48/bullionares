
<div class="row">

	<header class="main-header">
		<a href="/home" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini"><b>B</b>KB</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>Bilionares</b>KB</span>
		</a>


		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-fixed-top">

			<!-- Logo -->

			<!-- Sidebar toggle button-->
			<a href="#" class="sidebar-toggle" data-toggle="push-menu"
				role="button"> <span class="sr-only">Toggle navigation</span>
			</a>
			<!-- Navbar Right Menu -->

			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">


					<!-- Messages: style can be found in dropdown.less-->
					<c:if
						test="${ModeWelcome==true||ModeLogin==true||ModeRegister==true||ModeResetLink==true||ModeResetCode==true||ModeResetLink==true||ModeReset==true}">
						<li><a href="javascript:void(0);" id="rules">Rules</a></li>
						<li><a href="javascript:void(0);" id="regForm">Register</a></li>
						<li><a href="/">Login</a></li>

					</c:if>

					<c:if
						test="${ModeLogged==true||modeMessage==true||modeProfile==true||modeEvents==true||modeChart==true||modeJobs==true}">
						
						<li><a>Your Category : <b> ${category.catName} </b>
								Highest points: <b>${topCatCounter.total}</b> Overall Highest<b>
									${topCounter.total}</a></b></li>
						<li class="dropdown tasks-menu"><a href="javascript:void(0);" id="mainpost"> <i
								class="fa fa-home"></i> Home
						</a></li>
						<li class="dropdown tasks-menu"><a href="javascript:void(0);" id ="chart"> <i
								class="fa fa-bar-chart"></i> <c:if
									test="${notification.chart>0}">
									<span class="label label-danger">${notification.chart}</span>
								</c:if>
						</a></li>


						<li class="dropdown messages-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-envelope-o"></i> <c:if
									test="${notification.message>0}">
									<span class="label label-danger">${notification.message}</span>
								</c:if>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have ${notification.message} new
									message(s)</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<c:forEach items="${dmessages}" var="dmessage">

												<li>
													<!-- start message --> <a href="/message?wuid=${dmessage.duid}">
														<div class="pull-left">

															<c:if test="${dmessage.dimageLink!=''}">
																<img class="direct-chat-img"
																	src="/uploads/${dmessage.duid}/profile/${dmessage.dimageLink}"
																	alt="message user image">

															</c:if>
															<c:if test="${dmessage.dimageLink==''}">
																<img class="direct-chat-img" src="/dist/img/profile.jpg"
																	alt="message user image">

															</c:if>
														</div>
														<h4>
															${dmessage.dfullName} <small><i class="fa fa-clock-o"></i>
																${dmessage.dmdate}</small>
														</h4>
														<p>${dmessage.dmessage}</p>
												</a>
												</li>
										</c:forEach>
										
									</ul>
								</li>
								<li class="footer"><a >See All Chats</a></li>
							</ul></li>
						<!-- Notifications: style can be found in dropdown.less -->
						<li class="dropdown notifications-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-calendar"></i> <c:if
									test="${notification.events>0}">
									<span class="label label-danger">${notification.events}</span>
								</c:if>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have ${notification.events} new
									event(s)</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<c:forEach items="${catEvents}" var="catEvent">
											<c:if test="${not empty catEvent.ename}">
												<li><a href="javascript:void(0);" data-toggle="modal" data-target="#eventReview" data-toggle="tooltip"> <i
														class="fa fa-users text-aqua"></i>
														${(catEvent.going/noCUsers)*100} % will attend the
														${catEvent.ename}
												</a></li>
											</c:if>
										</c:forEach>


									</ul>
								</li>
								<li class="footer"><a href="#">View all</a></li>
							</ul></li>
						<!-- Tasks: style can be found in dropdown.less -->

						<li class="dropdown tasks-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <i
								class="fa fa-money"></i> <c:if test="${notification.jobad>0}">
									<span class="label label-danger">${notification.jobad}</span>
								</c:if>
						</a>
							<ul class="dropdown-menu">
								<li class="header">You have ${notification.jobad} new Job
									Add(s)</li>
								<li>
									<!-- inner menu: contains the actual data -->
									<ul class="menu">
										<c:forEach items="${catJobadds}" var="catJobadd">
											<c:if test="${not empty catJobadd.jobTitle}">
												<li>
													<!-- Task item --> <a href="javascript:void(0);" data-toggle="modal" data-target="#jobReview" data-toggle="tooltip">
														<h3>
															${catJobadd.jobTitle} (s)<span
																class="label label-success pull-right">${catJobadd.noPositions}</span>
														</h3>
														<div class="progress xs">
															<div class="progress-bar progress-bar-aqua"
																style="width: 100%" role="progressbar"
																aria-valuenow="100" aria-valuemin="0"
																aria-valuemax="100"></div>
														</div>
												</a>
												</li>
											</c:if>
										</c:forEach>
										<!-- end task item -->

									</ul>
								</li>
								<li class="footer"><a href="javascript:void(0);" data-toggle="modal" data-target="#jobReview" data-toggle="tooltip">View all Job listing</a></li>
							</ul></li>
						<!-- User Account: style can be found in dropdown.less -->
						<li class="dropdown user user-menu"><a href="#"
							class="dropdown-toggle" data-toggle="dropdown"> <c:if
									test="${user.imageLink!=''}">
									<img class="user-image"
										src="/uploads/${user.id}/profile/${user.imageLink}"
										alt="User Image">

								</c:if> <c:if test="${user.imageLink==''}">
									<img class="user-image" src="/dist/img/profile.jpg"
										alt="User Image">

								</c:if> <span class="hidden-xs">${user.firstName}
									${user.otherNames} </span>
						</a>
							<ul class="dropdown-menu">
								<!-- User image -->
								<li class="user-header"><c:if test="${user.imageLink!=''}">
										<img class="img-circle"
											src="/uploads/${user.id}/profile/${user.imageLink}"
											alt="User Image">

									</c:if> <c:if test="${user.imageLink==''}">
										<img class="img-circle" src="/dist/img/profile.jpg"
											alt="User Image">

									</c:if>

									<p>
										${user.firstName} ${user.otherNames} - ${user.profession} <small>Member
											since ${user.joinDate}</small>
									</p></li>
								<!-- Menu Body -->

								<!-- Menu Footer-->
								<li class="user-footer">
								
									<div class="pull-left">
										<a href="javascript:void(0);" class="btn btn-default btn-flat" id ="profile">Profile</a>
									</div>
									
									<div class="pull-right">
										<a href="perform-logout" class="btn btn-default btn-flat">Sign
											out</a>
									</div>
									<div class="pull-right">
										<a href="/reset?email=${user.email}&within=yes" class="btn btn-default btn-flat">Reset Password</a>
									</div>
									
								</li>
							</ul></li>
						<!-- Control Sidebar Toggle Button -->
						<li><a href="#" data-toggle="control-sidebar"><i
								class="fa fa-search"></i></a></li>
					</c:if>
				</ul>
			</div>

		</nav>
	</header>

</div>

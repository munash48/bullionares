<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 	//<c:if test="${not empty event.ename && not empty education.level &&not empty career.jobTitle&&not empty company.name&&not empty address.country&&not empty skillTalent.name1}"> --%>



<!-- MAP & BOX PANE -->
<c:if test="${ModeNotUpdated!=true}">
<div class="box box-info">
	<div class="box-header with-border">
		<h3 class="box-title">Create Article</h3>


	</div>
	<!-- /.box-header -->
	<div class="box-body">
		<form class="form-horizontal pad" enctype="multipart/form-data"
			action="/createArticle" method="post" id="articleFrm">
			<input type="hidden" name="cid" value="${category.catid}" /><input
				type="hidden" name="uid" value="${user.id}" />

			<div class="form-group">
				<label for="image" class="col-sm-2 control-label">Article
					text</label>

				<div class="col-sm-10">
					<textarea class="form-control" id="description" name="description"
						placeholder="Type your Article here ..."></textarea>
				</div>

			</div>
			<div class="form-group">
				<label for="image" class="col-sm-2 control-label">Add Image</label>

				<div class="col-sm-10">

					<input type="file" class="form-control" name="imageFile"
						accept="image/*" id="ImageFile" placeholder="Add image file"><span
						class="glyphicon glyphicon-picture form-control-feedback"></span>
				</div>
			</div>

			<div class="form-group has-feedback">
				<label for="text" class="col-sm-2 control-label">Youtube
					link</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" name="videoLink" pattern="https://www.youtube.com/watch+\?+v=.+"
               title="Copy from Youtube https://www.youtube.com/watch?v=yfnsfhfn" size="90"
						id="description" placeholder="Video Link eg https://www.youtube.com/watch?v=M5kVoH3746k" /> <span
						class="glyphicon glyphicon-facetime-video form-control-feedback"></span>
				</div>
			</div>

			<!-- /.table-responsive -->


			<!-- /.box-body -->
			<div class="box-footer clearfix">
				<a href="javascript:void(0)"
					class="btn btn-sm btn-default btn-flat pull-left">Clear</a>
				<button type="submit" name="submit"
					class="btn btn-sm btn-info btn-flat pull-right">Add
					Article</button>

			</div>
		</form>
	</div>
	<!-- /.box-footer -->
</div>
<%-- 	</c:if> --%>
</c:if>


<c:set var="count" value="0" scope="page" />

<c:forEach items="${displays}" var="display">


	<div class="box box-success">
		<div class="post">
			<div class="user-block">

				<c:if test="${display.userImageLink!=''}">
					<img class="img-circle img-bordered-sm"
						src="/uploads/${display.uid}/profile/${display.userImageLink}"
						alt="user image">

				</c:if>
				<c:if test="${display.userImageLink==''}">
					<img class="img-circle img-bordered-sm" src="/dist/img/profile.jpg"
						alt="user image">

				</c:if>

				<span class="username"> <a
					href="/profile?wuid=${display.uid}">${display.fullName}</a> <span
					class="description pull-right margin-r-5">Shared publicly -
						${display.artCreateDate}</span>
				</span>

			</div>
			<!-- /.user-block -->
			<p class="postcontent">${display.artDescription}</p>

			<c:if test="${not empty display.artVideoLink}">
				<iframe width="90%" height="315"
					src="https://www.youtube.com/embed/${display.artVideoLink}?&autoplay=1"
					frameborder="0" allowfullscreen></iframe>
			</c:if>
			<c:if test="${not empty display.artImageLink}">
				<img class="img-responsive"
					src="/uploads/${display.uid}/articles/${display.artImageLink}"
					alt="Photo">
			</c:if>
			<ul class="list-inline">
				<li>
					<a href="javascript:void(0);" onclick="countCross('${user.id}','${display.artid}','${display.uid}')">
						
						
							<i class="fa fa-times fa-2x margin-r-5"></i> Cross
					

					</a>



				</li>

				<li>
					<a href="javascript:void(0);" onclick="countVote('${user.id}','${display.artid}','${display.uid}')">
						
						
							<i class="fa fa-check fa-2x margin-r-5"></i> Vote
					

					</a>

					</form>

				</li>
				<li class="pull-right "><a href="javascript:void(0);" class="link-black text-sm noVotes${display.artid}">
						Votes
						(${display.noVotes})
				</a></li>
				
				<li class="pull-right"><a href="javascript:void(0);" class="link-black text-sm noReports${display.artid}">Crosses
						(${display.noReports})</a></li>
						<li class="pull-right"><a href="javascript:void(0);" class="link-black text-sm noOpinions${display.artid}">Opinions
						(${display.noOpinions})</a></li>


			</ul>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding inner-opinion">
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="pad">
					<div class="direct-chat-msg realtimeOpinion" style="display:none" >
											
											<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">${user.firstName} ${user.otherNames}</span>
									<span class="direct-chat-timestamp pull-right">
										Right Now</span>
								</div>
								
								<img class="direct-chat-img"
										src="/uploads/${user.id}/profile/${user.imageLink}"
										alt="message user image">
											
											<div class="direct-chat-text thisopinion"></div>
											</div>

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


				<c:if test="${count<=0}">
						<div class="box-footer">
							<form action="/createOpinion" method="post" id="OpinionFrm">

								<input type="hidden" name="artid" value="${display.artid}" />
								<input type="hidden" name="artuid" value="${display.uid}" />
								<input
									type="hidden" name="uid" value="${user.id}" />
								<div class="input-group">
									<input type="text" name="description"
										placeholder="Add your opinion... You can only react to the first Article " class="form-control"> <span
										class="input-group-btn">
										<button type="submit" name="submit"
											class="btn btn-warning btn-flat">Add Opinion</button>
									</span>
								</div>
							</form>

						</div>
</c:if>

					</div>
				</div>


				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.box-body -->
	</div>

<c:set var="count" value="${count + 1}" scope="page"/>
</c:forEach>




<!-- /.box -->

<!-- /.row -->

<!-- TABLE: LATEST ORDERS -->

<!-- /.box -->


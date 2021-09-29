
<div class="col-md-4">
	<!-- Info Boxes Style 2 -->
	<!-- /.info-box -->
		<!-- PRODUCT LIST -->
	<div class="box box-primary">
		<div class="box-header with-border">
			<h3 class="box-title">Advertisements</h3>
			<button type="button" data-toggle="modal"
						data-target="#addAdvert" class="btn btn-trans probtn">
						<i class="fa fa-pencil" title="click to add your advert" data-toggle="tooltip"
						data-placement="right"></i>
					</button>
					
					<button type="button" data-toggle="modal" data-target="#advertReview"
						class="btn btn-trans probtn">
						<i class="fa fa-eye" title="click to view all adds" data-toggle="tooltip"
						data-placement="right"></i>
					</button>
					

		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<ul class="products-list product-list-in-box">
			
			<c:forEach items="${displayadds}" var="eadvert">	
				
				<li class="item">
					<div class="product-img">
					<c:if test="${eadvert.imageLink!=''}">
					
					
					<a href="/uploads/${eadvert.uid}/aaaaa/${eadvert.imageLink}" target="_blank">
						<img class="img-prod"
							src="/uploads/${eadvert.uid}/aaaaa/${eadvert.imageLink}"
							alt="user image"> </a>

					</c:if>
					<c:if test="${eadvert.imageLink==''}">
						<img class="img-square img-bordered-sm"
							src="dist/img/default-50x50.gif" alt="Product Image">

					</c:if>

					</div>
					<div class="product-info">
						<a href="javascript:void(0)" class="product-title">${eadvert.title}
							<span class="label label-warning pull-right">$${eadvert.itemAmount}</span>
						</a> <span class="product-description">${eadvert.description}</span>
						<a>${eadvert.website} </a>
						
					</div>
				</li>
				</c:forEach>
				
		
			</ul>
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-center">
			<a href="javascript:void(0)" class="uppercase"></a>

					
		</div>
		<!-- /.box-footer -->
	</div>
	

	<div class="box box-default">
		<div class="box-header with-border">
			<h3 class="box-title">Upcoming Category Events</h3>

					<button type="button" data-toggle="modal" data-target="#eventReview"
						class="btn btn-trans probtn">
						<i class="fa fa-eye" title="click chose to go" data-toggle="tooltip"
						data-placement="right"></i>
					</button>
		</div>
		<!-- /.box-header -->
		<div class="box-body">
			<div class="row">
				<c:forEach items="${catEvents}" var="catEvent">
			   <c:if test="${not empty catEvent.ename}">
				<div class="info-box bg-green info-box-left">
					<span class="info-box-icon"><i
						class="ion ion-ios-heart-outline"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">${catEvent.ename}</span> 
						<span class="progress-description"> ${catEvent.description}
						</span>
							<span class="info-box-number">${(catEvent.going/noCUsers)*100} % going</span>

						<div class="progress">
							<div class="progress-bar" style="width: ${(catEvent.going/noCUsers)*100}%"></div>
						</div>
						
					</div>
					
					<!-- /.info-box-content -->
				</div>
				</c:if>
				
			</c:forEach>	

			
				

				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.box-body -->

		<!-- /.footer -->
	</div>
	<!-- /.box -->
	<div class="box box-default">
		<div class="box-header with-border">
			<h3 class="box-title">Job Advertisements</h3>
			<button type="button" data-toggle="modal"
						data-target="#addJob" class="btn btn-trans probtn">
						<i class="fa fa-pencil" title="click to add job advert" data-toggle="tooltip"
						data-placement="right"></i>
					</button>
					
					<button type="button" data-toggle="modal" data-target="#jobReview"
						class="btn btn-trans probtn">
						<i class="fa fa-eye" title="click to recomend" data-toggle="tooltip"
						data-placement="right"></i>
					</button>

		</div>
		<!-- /.box-header -->
		<div class="box-body">
		
		
			<div class="row">
			<c:forEach items="${catJobadds}" var="catJobadd">
			 <c:if test="${not empty catJobadd.jobTitle}">
			
				<div class="info-box bg-yellow info-box-left">
					<span class="info-box-icon"><i
						class="ion ion-ios-pricetag-outline"></i></span>

					<div class="info-box-content">
						<span class="info-box-text">${catJobadd.jobTitle}</span> <span
							class="info-box-number">${catJobadd.jobCategory}  ${catJobadd.salary} ugx</span>

						<div class="progress">
							<div class="progress-bar" style="width: ${(catJobadd.recomended/noCUsers)*100}%"></div>
						</div>
						<span class="progress-description"> (${(catJobadd.recomended/noCUsers)*100} % recommended)
						</span>
					</div>
					<!-- /.info-box-content -->
				</div>
				</c:if>
				</c:forEach>


				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.box-body -->

		<!-- /.footer -->
	</div>
	<!-- /.box -->
	
	<div class="box box-warning">
		<div class="box-header with-border">
			<h3 class="box-title">Latest Category Members</h3>

			<div class="box-tools pull-right">
				<span class="label label-danger">8 New Members</span>
				<button type="button" class="btn btn-box-tool"
					data-widget="collapse">
					<i class="fa fa-minus"></i>
				</button>
				<button type="button" class="btn btn-box-tool" data-widget="remove">
					<i class="fa fa-times"></i>
				</button>
			</div>
		</div>
		<!-- /.box-header -->
		<div class="box-body no-padding">
			<ul class="users-list clearfix">
			
				<c:forEach items="${cUsers}" var="cUser">

					<li>
					<c:if test="${cUser.imageLink!=''}">
					<img class="img-circle img-bordered-sm"
						src="/uploads/${cUser.id}/profile/${cUser.imageLink}"
						alt="User Image" >

				</c:if>
				<c:if test="${cUser.imageLink==''}">
					<img class="img-circle img-bordered-sm"
						src="/dist/img/profile.jpg" alt="User Image"
						>

				</c:if>
					
						<a class="users-list-name" href="javascript:void(0);" onclick="chatForm('${cUser.id}')" >${cUser.firstName}<br> ${cUser.otherNames}</a> </li>
				</c:forEach>
			</ul>
			<!-- /.users-list -->
		</div>
		<!-- /.box-body -->
		<div class="box-footer text-center">
			<a href="javascript:void(0)" class="uppercase">View Top Category
				Users</a>
		</div>
		<!-- /.box-footer -->
	</div>
	<!-- /.box -->


	<!-- /.box -->
</div>

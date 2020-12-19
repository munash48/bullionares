<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix ="t" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:set var="contextRoot" value ="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html >
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Billionares KB ${title}</title>
  <link rel="shortcut icon" href="images/billionaire-icon3.png" />
  
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" />
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="bower_components/jvectormap/jquery-jvectormap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.css">
  <link rel="shortcut icon" type="image/jpg" href="/resources/favicon.io"/>
  <script src="bower_components/jquery/dist/jquery.min.js"></script>
<script src="bower_components/jquery/js/jquery.boot.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>



  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue register-page">
<%@include file="./shared/header.jsp" %>


<div class="row ">

<div class="inner-jsp">


<div class="login-box">
	<!-- /.login-logo -->

	<c:if test="${ModeLogin}">
	

	<div class="row">

		<c:if test="${success!=null}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${success}

				</div>

			</div>
		</c:if>
			<c:if test="${logout!=null}">
			
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${logout}

				</div>

			</div>
		</c:if>

		<c:if test="${error!=null}">
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


		<form action="/" method="post">
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


		<a href="javascript:void(0);" id="restForm">I forgot my password</a><br> <a href="javascript:void(0);" id="regForm2"
			class="text-center">Register a new membership</a>

	</div>
	<script src="bower_components/jquery/js/jquery.save.js"></script>
	<!-- /.login-box-body -->
</c:if>

<c:if test="${ModeResetCode}">
<c:if test="${reset!=null}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${logout}

				</div>

			</div>
		</c:if>
	<script src="bower_components/jquery/js/jquery.save.js"></script>
	
	<div class="login-box-body">
		<p class="login-box-msg">Reset your password</p>


		<form action="/reset" method="post" id="submitPassRest">
			<div class="form-group has-feedback">
				<input name="password" type="password" class="form-control" placeholder="Enter new password" required pattern = "(?=.*\d)(?=.*[a-z])(?=.*?[0-9])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{6,}" title="Must contain at least 1 no., 1 upper, 1 lowercase letter and 1 special character at least 6">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				
			</div>
			<div class="form-group has-feedback">
				<input name="confirm" type="password" class="form-control" placeholder="Confirm new password" required  pattern = "(?=.*\d)(?=.*[a-z])(?=.*?[0-9])(?=.*?[~`!@#$%\^&*()\-_=+[\]{};:\x27.,\x22\\|/?><]).{6,}" title="Must contain at least 1 no., 1 upper, 1 lowercase letter and 1 special character at least 6" >
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				<sec:csrfInput /> 
			</div>
			<input  type="hidden" name="resetcode" class="form-control" value="${resetcode}">
			<div class="row">

				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat"> Save Password
						</button>
				</div>
				<!-- /.col -->
			</div>
			
		</form>


	</div>
	<script src="bower_components/jquery/js/jquery.update.js"></script>
	</c:if>
</div>





</div>
<!-- REGSITER LOGIN OR DOCUEMNTATION -->
<%-- <c:if test="${ModeRegister==true}"> --%>
<%-- <%@include file ="./shared/register.jsp" %> --%>
<%-- </c:if> --%>
<%--  <c:if test="${ModeLogin==true}">  --%>
<%-- <%@include file ="./shared/login.jsp" %> --%>
<%--  </c:if>  --%>
<%-- <c:if test="${ModeWelcome==true}"> --%>
<%-- <%@include file ="./shared/message.jsp" %> --%>
<%-- </c:if> --%>
<%-- <c:if test="${modeErrorAccess==true}"> --%>
<%-- <%@include file ="./shared/error.jsp" %> --%>
<%-- </c:if> --%>
<%-- <c:if test="${ModeReset==true||ModeResetLink==true||ModeResetCode==true}"> --%>
<%-- <%@include file ="./shared/reset.jsp" %> --%>
<%-- </c:if> --%>
</div>
<div class="row">

<footer class="footer text-center">
    <div class="row  hidden-xs">
      <b>Version</b> 2.4.18
    
    <strong>Copyright &copy; 2020 <a href="http://kalimagezi.com/" target="_blank">Kalimagezi ltd</a>.</strong> All rights
    reserved.
	</div>
  </footer>
</div>
</div>
<!-- ./wrapper -->

<!-- jQuery 3 -->

<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- Sparkline -->
<script src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap  -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS -->
<script src="bower_components/chart.js/Chart.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>

</body>
</html>
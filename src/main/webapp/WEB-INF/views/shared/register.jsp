<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="bower_components/jquery/js/jquery.save.js"></script>

<div class="register-box">


  <div class="register-box-body">
  
  <c:if test="${failed!=null}">
			<div class="col-xs-12">
				<div class="alert alert-warning alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${failed}

				</div>

			</div>
		</c:if>
    <p class="login-box-msg">Register a new Billionare</p>

    <sf:form action="/register" modelAttribute="user" method="POST" id="submitRegForm">
      <div class="form-group has-feedback">
        <sf:input type="text" class="form-control" path="firstName" id ="firstName" placeholder="First Name" size="30" required="true"/>
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <sf:input type="text" class="form-control" path="otherNames" id ="otherNames" placeholder="Other Names"/>
        <span class="glyphicon glyphicon-plus form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
      <label>Select Category</label>
        <sf:select class="form-control" path="catid" id ="catid" 
        items="${ecategories}"
        itemLabel="catName"
        itemValue="catid"
        /> 
     
        <span class="glyphicon glyphicon-cd form-control-feedback"></span>
        
      </div>
      <div class="form-group has-feedback">
        <sf:input type="text" class="form-control" path="profession" id ="profession" placeholder="Your Profession"/>
        <span class="glyphicon glyphicon-star form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <sf:input type="text" class="form-control" path="phoneNumber" id ="phoneNumber" placeholder="Phone Number"/>
        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <sf:input type="email" class="form-control" path="email" id ="email" placeholder="Email" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Email should be in the format munash@mail.co"/>
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
     
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" /> I agree to the <a href="#">terms</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" name ="submit"  class="btn btn-primary btn-block btn-flat">Register</button>
        </div>
        <!-- /.col -->
      </div>
      <!-- HEDEN FIELDS -->
      <sf:hidden path="id"/>
      <sf:hidden path="imageLink"/>
      <sf:hidden path="resetcode"/>
      <sf:hidden path="password"/>
      <sf:hidden path="aboutme"/>
      <sf:hidden path="role"/>
      <sf:hidden path="enabled"/>
      <sf:hidden path="birthDate"/>
      <sf:hidden path="joinDate"/>
    </sf:form>


    <a href="/" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>

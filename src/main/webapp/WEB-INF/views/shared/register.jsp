<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="register-box">


  <div class="register-box-body">
  <c:if test="${ModeJustRegistered==true}">
			<div class="col-xs-12">
				<div class="alert alert-warning alert-dismissible">

					<button type="button" class="close" data-dismiss="alert">&times;</button>
					${failed}

				</div>

			</div>
		</c:if>
    <p class="login-box-msg">Register a new Billionare</p>

    <sf:form action="/register" modelAttribute="user" method="POST">
      <div class="form-group has-feedback">
        <sf:input type="text" class="form-control" path="firstName" id ="firstName" placeholder="First Name"/>
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
        <sf:input type="email" class="form-control" path="email" id ="email" placeholder="Email"/>
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
      <sf:hidden path="role"/>
      <sf:hidden path="enabled"/>
      <sf:hidden path="birthDate"/>
      <sf:hidden path="joinDate"/>
    </sf:form>


    <a href="/login" class="text-center">I already have a membership</a>
  </div>
  <!-- /.form-box -->
</div>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-7">
			<div class="panel panel-default">
				<c:if test="${not empty error}">
					<div class="error">${error}</div>
				</c:if>
				<c:if test="${not empty msg}">
					<div class="msg">${msg}</div>
				</c:if>
				<div class="panel-heading"> <strong class="">Login</strong>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="<c:url value='/login' />" role="form" method="POST">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-3 control-label">Email</label>
                            <input type="email" class="form-control col-sm-8 col-centered" id="inputEmail3" placeholder="Email" name='username' required>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
                            <input type="password" class="form-control col-sm-8 col-centered" id="inputPassword3" placeholder="Password"name="password" required="">
						</div>
						<div class="form-group">
                            <div class="form-check col-sm-8 col-centered">
                                <input type="checkbox" id="rememberMe" class="form-check-input">
                                    <label class="form-check-label" for="rememberMe">Remember me</label>
                            </div>
						</div>
						<div class="form-group last">
							<div class="col-sm-8 col-centered">
								<button type="submit" class="btn btn-success btn-sm">Sign in</button>
								<button type="reset" class="btn btn-default btn-sm">Reset</button>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form>
                    <form action="/signin/facebook" method="POST">
                        <input type="hidden" name="scope" value="public_profile, email" />
                        <button class="btn btn-primary" type="submit"><i class="fa fa-facebook-square"></i> Log in With Facebook</button>
                    </form>
				</div>
				<div class="panel-footer">Not Registered? <a href="/registration" class="">Register here</a>
				</div>
			</div>
		</div>

        <div class="col-md-8" >
            <div class="panel panel-default" style="padding-bottom: unset">
                <h2>Dish of the week with the best price!</h2>
                <img src="../images/picLogin.jpg" alt="Carry" class="fluid" width="100%">
            </div>
        </div>

	</div>
</div>
<div id="fb-root"></div>

    <style>
        .error {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }

        .msg {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
            color: #31708f;
            background-color: #d9edf7;
            border-color: #bce8f1;
        }
		body {
			background: url('/images/sezar.jpg') no-repeat center center fixed;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
        }

		.panel-default {
			opacity: 0.9;
			padding-top: 30px;
            padding-bottom: 50px;
			background: white;
            max-height: 500px;
		}
		.form-group.last {
			margin-bottom:0px;
		}
        .col-centered{
            float: none;
            margin: 0 auto;
        }
    </style>

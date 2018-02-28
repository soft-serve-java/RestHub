<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-7" style="background: white">
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
							<div class="col-sm-9">
								<input type="email" class="form-control" id="inputEmail3" placeholder="Email"  name='username'  required="">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-3 control-label">Password</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="inputPassword3" placeholder="Password"name="password" required="">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-3 col-sm-9">
								<div class="checkbox">
									<label class="">
										<input type="checkbox" class="">Remember me</label>
								</div>
							</div>
						</div>
						<div class="form-group last">
							<div class="col-sm-offset-3 col-sm-9">
								<button type="submit" class="btn btn-success btn-sm">Sign in</button>
								<button type="reset" class="btn btn-default btn-sm">Reset</button>
							</div>
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							   value="${_csrf.token}" />
					</form>
				</div>
				<div class="panel-footer">Not Registered? <a href="/registration" class="">Register here</a>
				</div>
			</div>
		</div>
	</div>
</div>
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
			margin-top:30px;
			background: white;
			height: 70%;
		}
		.form-group.last {
			margin-bottom:0px;
		}
    </style>

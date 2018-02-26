<%@ include file="header.jsp" %>
<div class="container">
	<div class="row">
	<div class="col-md-2">
<div id="login-box">
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
	<div class="form">
		<form class="form-horizontal" action="<c:url value='/login' />" role="form" method="POST">
			<div class="form-group">
				<div class="form-group">
					<label class="col-sm-2 control-label">Email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" placeholder="E-mail" name='username'>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">Password</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" placeholder="Password" name="password">
					</div>
				</div>
				<div class="btn-group">
						<button type="submit" class="btn btn-default">Submit</button>
						<a href="/registration" class="btn btn-primary">Registration</a>
				</div>
				<input type="hidden" name="${_csrf.parameterName}"
					   value="${_csrf.token}" />
			</div>
		</form>
	</div>
</div>
</div>
	<div class="col-md-6">
		<div class="imgWithContent">

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
		.imgWithContent{
			background-color: #31708f;
		}
    </style>
<%@ include file="footer.jsp" %>
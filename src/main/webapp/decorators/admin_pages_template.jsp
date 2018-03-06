<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html lang="en" style="position: relative; min-height: 100%">
<html>

<head>
    <meta charset="UTF-8">
    <title>RestHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel='stylesheet' type="text/css" href="/css/Styles.css">
</head>

<body>
<c:url value="/logout" var="logoutUrl" />

<form action="${logoutUrl}" method="post" id="logoutForm">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>

<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/welcome"><img src="/images/logo.png"></a>
    <div class="navbar-collapse collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/admin/user/all">Users</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/dish/all">Dish</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/category/all">Category</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/order">Order</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/role/all">Role</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/status/all">Status</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/reviews">Reviews</a>
            </li>
        </ul>
        <form action="#" class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button type="button" class="btn btn-default btn-lg nav-button btn-nav-search" style="margin-top: 10px">
                <i class="fa fa-search"></i>
            </button>
        </form>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h6 style="color: lightgrey">
                Hi, ${pageContext.request.userPrincipal.name}
                <a href="javascript:formSubmit()"> Logout</a>
            </h6>
        </c:if>
        <%--            <a class="nav-link a-nav" href="#">Log in <i class="fa fa-user" aria-hidden="true"></i></a>--%>
    </div>
</nav>
<decorator:body />

<footer class="footer">
    <div class="container">
        <span class="add-text"> RestHub Inc. 	&#169;</span>
        <a href="#" class="add-text">Contact us </a>
        <span class="align-middle">Join us
              <button class="i-button" style="margin-left: 20px">
                  <i class="fa fa-facebook" aria-hidden="true"></i></button>
        <button class="i-button"><i class="fa fa-twitter" aria-hidden="true"></i></button>
            <button class="i-button"><i class="fa fa-instagram" aria-hidden="true"></i></button>
        </span>
        <a href="#" class="add-text">Help</a>
    </div>
</footer>
</body>
</html>
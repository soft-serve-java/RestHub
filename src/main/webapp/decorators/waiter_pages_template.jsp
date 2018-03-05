<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src = "/js/angular.min.js"></script>
    <script src="/js/ng-stomp.standalone.min.js"></script>
    <link rel='stylesheet' type="text/css" href="/css/Styles.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/welcome"><img src="/images/logo.png"></a>
    <div class="navbar-collapse collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <c:forEach items="${categoryItems}" var="item">
                <li class="nav-item">
                    <a class="nav-link" href="/menu/${item.name}">${item.name}</a>
                </li>
            </c:forEach>
            <a class="nav-link" href="/waiter/tab">Tables</a>
        </ul>
        <form action="/menu" method="get" class="form-inline">
            <input class="form-control mr-sm-2" name="search" type="text" placeholder="Search dish"/>
            <button type="submit" class="btn btn-default btn-lg nav-button btn-nav-search" style="margin-top: 10px">
                <i class="fa fa-search"></i>
            </button>
        </form>
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

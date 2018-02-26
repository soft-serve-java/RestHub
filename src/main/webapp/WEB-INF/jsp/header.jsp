<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>
<html lang="en" style="position: relative; min-height: 100%">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel='stylesheet' type="text/css" href="/css/Styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script src="/js/ng-stomp.standalone.min.js"></script>
    <script>
        function doPOSTonCallWaiter() {
            $.ajax({
                url: '/callWaiterClient',
                type: 'POST',
                data:{"table":1},
                success: function () {
                },
                error: function () {
                }
            });
        }
    </script>
</head>
<body onload='document.loginForm.username.focus();'>

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
            <c:forEach items="${categoryItems}" var="item">
                <li class="nav-item">
                    <a class="nav-link" href="/menu/${item.name}">${item.name}</a>
                </li>
            </c:forEach>
            <button onclick="doPOSTonCallWaiter()" class="btn btn-success nav-button" style="margin-right:10px;">
                <span class="left-span"> Call a waiter  <i class="fa fa-bell" aria-hidden="true"></i></span>
            </button>
            </li>
            <li>

                <c:if test="${not empty orderMap || not empty orderedList}">
                    <a href="/order">
                        <button class="btn btn-info nav-button" style="margin-right:10px;">
                            <span class="left-span">Order  <i class="fa fa-coffee" aria-hidden="true"></i></span>
                        </button>
                    </a>
                </c:if>
                <c:if test="${empty orderMap && empty orderedList}">
                    <button class="btn btn-info nav-button" disabled style="margin-right:10px;">
                        <span class="left-span">Order  <i class="fa fa-coffee" aria-hidden="true"></i></span>
                    </button>
                </c:if>

            </li>
        </ul>
        <form action="/menu" method="get" class="form-inline">
            <input class="form-control mr-sm-2" name="search" type="text" placeholder="Search dish"/>
            <button type="submit" class="btn btn-default btn-lg nav-button btn-nav-search" style="margin-top: 10px">
                <i class="fa fa-search"></i>
            </button>
        </form>

        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <h6 style="color: lightgrey">
                Hi, ${pageContext.request.userPrincipal.name}
                <a href="javascript:formSubmit()"> Logout</a>
            </h6>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a class="nav-link a-nav" href="/login">Log in <i class="fa fa-user" aria-hidden="true"></i></a>
        </c:if>
    </div>
</nav>

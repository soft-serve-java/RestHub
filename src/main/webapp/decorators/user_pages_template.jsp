<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="/WEB-INF/jsp/error.jsp" %>
<html lang="en" style="position: relative; min-height: 100%">
<head>
    <meta charset="UTF-8">
    <title>RestHub</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <!-- changed css location 'cause of swagger-->
    <link rel='stylesheet' type="text/css" href="/Styles.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.min.js"></script>
    <script src = "/js/angular.min.js"></script>
    <script src="/js/ng-stomp.standalone.min.js"></script>
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
<script type="text/javascript">
    var app = angular.module('kswaughsLiveScore', ['ngStomp']);

    app.controller('LiveController', function ($stomp, $scope) {
        $scope.myres;
        $stomp.connect('/call', {})
            .then(function (frame) {
                console.log("123");
                var subscription = $stomp.subscribe('/user/${tables.currentTable}/callBackInfo',
                    function (payload, headers, res) {
                        $scope.myres = payload;
                        $scope.$apply($scope.myres);
                        console.log(payload);
                        $("#waiterIsComingModal").modal("show");
                    });

                $stomp.send('/app/waiterCallBack', '');
            });
    });
    function doPOSTonCallWaiter() {
        $.ajax({
            url: '/callWaiterClient',
            type: 'POST',
            data:{"table":${sessionScope.tables.currentTable}},
            success: function () {
            },
            error: function () {
            }
        });
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

            <button type="button" class="btn btn-success nav-button" style="margin-right:10px;"
                    data-toggle="modal" data-target="#exampleModalWaiter">
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
                Your table is ${tables.currentTable}
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
<div class="modal fade" id="waiterIsComingModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Your waiter is coming</h4>
            </div>
            <div class="modal-body">
                <div class="liveScore" ng-app="kswaughsLiveScore"
                     ng-controller="LiveController">
                    <img src="{{myres.avatar}}" class="avatarWaiter pull-left">
                    <div style="text-align: center"> <h3> {{myres.name}}</h3></div>
                </div>
            </div>
        </div>
    </div>
</div>
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

<%@ include file="/WEB-INF/jsp/ModalWaiter.jsp" %>
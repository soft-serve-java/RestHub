
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel='stylesheet' type="text/css" href="/css/Styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">


<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
            aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/welcome"><img src="/images/logo.png"></a>
    <div class="navbar-collapse collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto" >
            <li class="nav-item">
                <button class="btn btn-success" style="margin-left:10px;">
                    Edit dishes <span class="fa fa-check"></span>
                </button>
            </li>

            <li class="nav-item">
                <button class="btn btn-success" style="margin-left:10px;">
                    Edit users <span class="fa fa-check"></span>
                </button>
            </li>

            <li class="nav-item">
                <button class="btn btn-success" style="margin-left:10px;">
                    Edit category <span class="fa fa-check"></span>
                </button>
            </li>

            <li class="nav-item">
                <button class="btn btn-success" style="margin-left:10px;">
                    Edit order <span class="fa fa-check"></span>
                </button>
            </li>

            <li class="nav-item">
                <button class="btn btn-success" style="margin-left:10px;">
                    Edit role <span class="fa fa-check"></span>
                </button>
            </li>

            <li class="nav-item">
                <button class="btn btn-success" style="margin-left:10px;">
                    Edit status <span class="fa fa-check"></span>
                </button>
            </li>
        </ul>

        <form action="#" class="form-inline">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button type="button" class="btn btn-default btn-lg nav-button btn-nav-search" style="margin-top: 10px">
                <i class="fa fa-search"></i>
            </button>
        </form>

        <a class="nav-link a-nav" href="#">Log in <i class="fa fa-user" aria-hidden="true"></i></a>

    </div>
</nav>

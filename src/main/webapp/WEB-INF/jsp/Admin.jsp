<%--
  Created by IntelliJ IDEA.
  User: arthurvartanyan
  Date: 1/29/18
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


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
                <a class="nav-link" href="/menu/soups">Soups</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/menu/meals">Meals</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/menu/drinks">Drinks</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/menu/deserts">Deserts</a>
            </li>

            <li class="nav-item">
                <form  action="#" class="nav-form">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" >
                </form>
            </li>

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
        </ul>
    </div>
</nav>

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
<%@ include file = "Admin.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
    <table class="table table-hover">
        <tbody>
        <td>
            <h4 >Admin panel for Dishes</h4>
            <button class="btn btn-success">
                Add new dish <span class="fa fa-check"></span>
            </button>
            <p>
                <label>Find by name: </label>
                <input placeholder="Enter dish name" required>

                <button class="btn btn-success">
                    Search <span class="fa fa-check"></span>
                </button>
            </p>
            <div class="row">

            </div>
            <p class="text-muted">Dishes:</p>
            <div class="row">

                <div class="col-md-1">
                    <img src="https://mafia.ua/storage/editor/fotos/450x450/filadelfiya-miks.jpeg"  style="width: 3rem">

                </div>

                <div class="col-md-8">
                    <h6 >${dish.name}</h6>
                </div>

                <div class="col-md-3">
                    <button class="btn btn-success" style="margin-bottom: 10%">
                        Edit <span class="fa fa-check"></span>
                    </button>
                    <button class="btn btn-success" style="margin-bottom: 10%">
                        Remove <span class="fa fa-check"></span>
                    </button>
                </div>
            </div>
        </td>
        </tbody>
    </table>
</div>

<%@ include file = "footer.jsp" %>
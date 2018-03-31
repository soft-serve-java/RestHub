<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<div class="container">
    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Name</th>
            <th colspan="2" > <a href="/admin/dish/new"><button type="submit" class="btn btn-primary">New Dish</button> </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${dish}" var="dish">
            <c:if test="${!dish.availability}"><tr class="table-warning"></c:if>
            <c:if test="${dish.availability}"><tr></c:if>
                <td>${dish.id}</td>
                <td>${dish.name}</td>
                <td>
                    <a class="btn btn-info" href="/admin/dish/tweakAvail/${dish.id}">
                        <c:choose>
                            <c:when test="${dish.availability}">Remove from menu</c:when>
                            <c:otherwise>Add to menu</c:otherwise>
                        </c:choose>
                    </a>
                </td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            data-whatever="${dish.name}" data-href="/admin/dish/delete/${dish.id}">Delete
                    </button>
                </td>
                <td>
                    <a href="/admin/dish/edit/${dish.id}" class="btn btn-warning inline"><span class="fa fa-pen">Edit</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="Modal.jsp"%>

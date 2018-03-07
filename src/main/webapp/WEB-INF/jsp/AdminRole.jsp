<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Name</th>
            <th colspan="2" > <a href="/admin/role/new"><button type="submit" class="btn btn-primary">New Role</button> </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${role}" var="role">
            <tr>
                <td>${role.id}</td>
                <td>${role.name}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            data-whatever="${role.name}" data-href="/admin/role/delete/${role.id}">Delete
                    </button>
                </td>
<%--                <td>
                    <a href="/admin/role/edit/${role.id}" class="btn btn-warning inline"><span class="fa fa-pen">Edit</span></a>
                </td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file = "Modal.jsp" %>
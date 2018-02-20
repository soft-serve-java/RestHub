<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Admin.jsp" %>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Email</th>
            <th>Password</th>
            <th>Role</th>
            <th colspan="2"><a href="/admin/user/new">
                <button type="submit" class="btn btn-primary">New User</button>
            </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${user.role.name}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            data-whatever="${user.email}" data-href="/admin/user/delete/${user.id}">Delete
                    </button>
                </td>
                <td>
                    <a href="/admin/user/edit/${user.id}" class="btn btn-warning inline"><span
                            class="fa fa-pen">Edit</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="Modal.jsp" %>
<%@ include file="footer.jsp" %>

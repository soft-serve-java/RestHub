<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="Admin.jsp" %>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Name</th>
            <th colspan="2"><a href="/admin/category/new">
                <button type="submit" class="btn btn-primary">New Category</button>
            </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Categories}" var="category">
            <tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            data-whatever="${category.name}" data-href="/admin/category/delete/${category.id}">Delete
                    </button>
                </td>
                <td>
                    <a href="/admin/category/edit/${category.id}" class="btn btn-warning inline"><span
                            class="fa fa-pen">Edit</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="Modal.jsp" %>
<%@ include file="footer.jsp" %>

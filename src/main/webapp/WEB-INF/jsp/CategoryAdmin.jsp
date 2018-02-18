<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="Admin.jsp" %>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Name</th>
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

    <hr>
    <form:form method="POST" action="/admin/category/save" modelAttribute="category">
        <div class="form-row align-items-center">
            <form:hidden path="id"/>
            <div class="form-group col-md-6">
                <label for="inputName">Name</label>
                <form:input path="name" type="text" class="form-control" id="inputName" placeholder="Name of new category"/>
                <form:errors path="name" class="control-label"/>
            </div>

            <div class="col-md-2 align-items-center">
                <button type="submit" class="btn btn-primary">Add New Category</button>
            </div>
        </div>
    </form:form>
</div>
<%@ include file="Modal.jsp" %>
<%@ include file="footer.jsp" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file = "header.jsp" %>
<div class="container">

    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Name</th>
            <th colspan="2" > <a href="/admin/status/new"><button type="submit" class="btn btn-primary">New Status</button> </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${status}" var="status">
            <tr>
                <td>${status.id}</td>
                <td>${status.name}</td>
                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModalDish"
                            data-whatever="${status.name}" data-id = "${status.id}">Delete</button>
                </td>
                <td>
                    <a href="/admin/status/edit/${status.id}" class="btn btn-warning inline"><span class="fa fa-pen">Edit</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file = "footer.jsp" %>
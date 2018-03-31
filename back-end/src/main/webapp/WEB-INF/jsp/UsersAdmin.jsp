<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
    <div class="col1" style="text-align: right; padding-top: 10px;">
        <div class="btn-group">

            <button type="button" class="btn btn-danger" style="margin-right:10px;"
                    data-toggle="modal" data-target="#exampleModalDeleteNotConfirmedUsers">
                <span class="left-span"> Delete not confirmed </span>
            </button>



            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">
                Show
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="/admin/user/all">All</a>
                <a class="dropdown-item" href="/admin/user/all?show=confirmed">Confirmed</a>
                <a class="dropdown-item" href="/admin/user/all?show=notconfirmed">Not confirmed</a>
            </div>
        </div>
    </div>

    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Email</th>
            <th>Name</th>
            <th>Role</th>
            <th>Enable</th>
            <th colspan="2"><a href="/admin/user/new">
            </a>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.email}</td>
                <td>${user.name}</td>
                <td>
                    <c:forEach items="${user.roles}" var="role">
                        ${role.name}
                    </c:forEach>
                </td>
                <td>${user.enabled}</td>
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


    <div class="menuPagination">
        <nav aria-label="RestHub menu pagination">
            <ul class="pagination">
                <c:choose>
                <c:when test="${page == 1}">
                <li class="page-item disabled">
                    </c:when>
                    <c:otherwise>
                <li class="page-item">
                    </c:otherwise>
                    </c:choose>
                    <a class="page-link" href="/admin/user/all?show=${showBy}&{page-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">Previous</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${maxPages}" varStatus="loop">
                    <c:choose>
                        <c:when test="${page == loop.index}">
                            <li class="page-item active">
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                        </c:otherwise>
                    </c:choose>
                    <a class="page-link" href="/admin/user/all?show=${showBy}&page=${loop.index}">${loop.index}</a>
                    </li>
                </c:forEach>
                <c:choose>
                <c:when test="${page == maxPages}">
                <li class="page-item disabled">
                    </c:when>
                    <c:otherwise>
                <li class="page-item">
                    </c:otherwise>
                    </c:choose>
                    <a class="page-link" href="/admin/user/all?show=${showBy}&=page=${page+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                        <span class="sr-only">Next</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<%@ include file="Modal.jsp" %>
<%@ include file="ModalDeleteNotConfirmUser.jsp" %>

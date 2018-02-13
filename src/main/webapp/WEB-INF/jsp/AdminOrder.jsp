<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file = "Admin.jsp" %>
<div class="container">
<%--    <c:if test="${not empty order}"><p>test- BD Empty</p></c:if>   --%>
    <table class="table table-hover">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Order</th>

            <%--<th colspan="2" >
                <a href="/admin/order/new"><button type="submit" class="btn btn-primary">New order</button> </a>
            </th>--%>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Order}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.time}</td>
                <td>${order.tablenumber}</td>

                <td>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#exampleModal"
                            data-whatever="${order.login}" data-href = "/admin/order/delete/${order.id}">Delete</button>
                </td>
                <td>
                    <a href="/admin/order/edit/${order.id}" class="btn btn-warning inline"><span class="fa fa-pen">Edit</span></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="Modal.jsp"%>
<%@ include file = "footer.jsp" %>

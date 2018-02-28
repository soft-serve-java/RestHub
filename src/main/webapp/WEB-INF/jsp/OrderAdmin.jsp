<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
    <table class="table">
        <thead>
        <tr style="text-align: center;">
            <th>#</th>
            <th>Date</th>
            <th>Table</th>
            <th>Closed</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${Orders}" var="order">
            <tr data-toggle="collapse" data-target="#accordion${order.id}" class="clickable">
                <td>${order.id}</td>
                <td>${order.time}</td>
                <td>${order.tablenumber}</td>
                <td>${order.closed}</td>
                <td>
                <span class="plus-icon">
                <i class="sign fa fa-plus fa-2x" style="margin-top: -4px;"></i>
                </span>
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <div id="accordion${order.id}" class="collapse">
                        <table class="table">
                            <thead>
                            <tr style="text-align: center;">
                                <th>Name</th>
                                <th>Quantity</th>
                                <th>Price</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${order.orderedFood}" var="food">
                                <tr>
                                    <td>${food.dish.name} </td>
                                    <td>${food.quantity}</td>
                                    <td>${food.dish.price}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

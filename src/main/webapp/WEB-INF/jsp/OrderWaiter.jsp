<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
    <h1>Order details about table ${table}</h1>
    <table class="table table-hover">
        <thead class="thead-light">
        <tr>
            <th style="width: 40%">Title</th>
            <th style="width: 20%">Price</th>
            <th style="width: 15%">Quantity</th>
            <th style="width: 30%"></th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty order}">
            <c:forEach items="${order}" var="orderItem">
                <c:if test="${orderItem.status.name=='preparing'}">
                    <tr class="table-info">
                </c:if>
                <c:if test="${orderItem.status.name=='cooking'}">
                    <tr class="table-warning">
                </c:if>
                <c:if test="${orderItem.status.name=='delivery'}">
                    <tr class="table-success">
                </c:if>
                <td>
                    <div class="row">
                        <div class="col-md-4">
                            <img src="${orderItem.dish.images[0].url}" class="w-100">
                        </div>
                        <div class="col-md-6">
                            <h4>${orderItem.dish.name}</h4>
                            <p class="text-muted">${orderItem.dish.weight}</p>
                        </div>
                    </div>
                </td>
                <td>${orderItem.dish.price}$</td>
                <td>
                    <div class="row">
                        <div class="input-group">
                            <button type="button" class="btn btn-secondary" disabled="disabled">
                                <span class="fa fa-minus"></span>
                            </button>
                            <input type="text" name="quant[1]" class="form-control input-number"
                                   value="${orderItem.quantity}" min="1" max="10" disabled>
                            <button type="button" class="btn btn-secondary" disabled>
                                <span class="fa fa-plus"></span>
                            </button>
                        </div>
                    </div>
                </td>
                <c:if  test="${orderItem.status.name!='delivery'}">
                    <td style="text-align: center">
                        <button type="button" class="btn btn-secondary" disabled>${orderItem.status.name}</button>
                    </td>
                </c:if>
                <c:if  test="${orderItem.status.name=='delivery'}">
                    <td style="text-align: center">
                        <a href="/waiter/deliver/${orderItem.id}" type="button" class="btn btn-secondary">${orderItem.status.name}</a>
                    </td>
                </c:if>

                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <hr/>
    <div class="row">
        <h5 class="col-md-6">
            Customer has ${fn:length(order)} items in his cart
        </h5>
        <h4 class="col-md-4">
            Total amount: ${ordersTotalAmount}$
        </h4>
        <c:if test="${user!=null}">
        <h4 class="col-md-3">
         Customer's name: ${user.name}
        </h4>
        </c:if>
    </div>
    <a href="/waiter/close/${table}" class="btn btn-danger btn-block" style="margin-bottom: 10%">
        Close this order</span>
    </a>
</div>

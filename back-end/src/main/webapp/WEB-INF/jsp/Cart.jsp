<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
    <h3 class="reviews">The number of your table is ${tables.currentTable}</h3>
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
        <c:if test="${not empty orderedList}">
            <c:forEach items="${orderedList}" var="orderItem">
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
                <td style="text-align: center">
                    <button type="button" class="btn btn-secondary" disabled>${orderItem.status.name}</button>
                </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${not empty orderMap}">
            <c:forEach items="${orderMap}" var="orderItem">
                <tr>
                    <td>
                        <div class="row">
                            <div class="col-md-4">
                                <img src="${orderItem.key.images[0].url}" class="w-100">

                            </div>
                            <div class="col-md-6">
                                <h4>${orderItem.key.name}</h4>
                                <p class="text-muted">${orderItem.key.weight}</p>
                            </div>
                        </div>
                    </td>
                    <td>${orderItem.key.price}$</td>
                    <td>
                        <div class="row">
                            <div class="input-group">
                                <c:if test="${orderItem.value > 1}">
                                <a href="/reduce/${orderItem.key.id}" class="btn btn-secondary">
                                    <span class="sign fa fa-minus"></span>
                                </a>
                                </c:if>
                                <c:if test="${orderItem.value == 1}">
                                    <a href="/reduce/${orderItem.key.id}" class="btn btn-secondary disabled"
                                       style="cursor: not-allowed">
                                        <span class="sign fa fa-minus"></span>
                                    </a>
                                </c:if>
                                <input type="text" name="quant${orderItem.key.id}" class="form-control input-number"
                                       value="${orderItem.value}" min="1" max="10">
                                    <a href="/increase/${orderItem.key.id}" class="btn btn-secondary">
                                        <span class="sign fa fa-plus"></span>
                                    </a>
                            </div>
                        </div>
                    </td>
                    <td style="text-align: center">
                        <a href="/submitOne/${orderItem.key.id}" class="btn btn-success inline"><span
                                class="fa fa-check"></span></a>
                        <a href="/removeFromOrder/${orderItem.key.id}" class="btn btn-danger inline"><span
                                class="fa fa-times"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
    <hr/>
    <div class="row">
        <h5 class="col-md-4">
            You have ${fn:length(orderMap) + fn:length(orderedList)} items in your cart
        </h5>
        <h4 class="col-md-5">
            Total amount: ${ordersTotalAmount}$
        </h4>
        <c:if test="${not empty orderMap}">
            <c:if test="${tables.currentTable!=0}">
                <button type="button" class="btn btn-success col-md-2" style="margin-bottom: 10%"
                        data-toggle="modal" data-target="#exampleModal">
                    Submit All<span class="fa fa-check"></span>
                </button>
            </c:if>
            <c:if test="${tables.currentTable==0}">
                <button type="button" class="btn btn-success col-md-2" style="margin-bottom: 10%"
                        data-toggle="modal" data-target="#exampleModal2">
                    Submit All<span class="fa fa-check"></span>
                </button>
            </c:if>

        </c:if>
        <c:if test="${empty orderMap}">
            <a href="/submitOrder" class="btn btn-success col-md-2 disabled" style="margin-bottom: 10%">
                Submit All <span class="fa fa-check"></span>
            </a>
        </c:if>
    </div>
</div>
<%@ include file="ModalTableSelect.jsp" %>
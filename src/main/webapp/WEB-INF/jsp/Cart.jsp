<%--
  Created by IntelliJ IDEA.
  User: arthurvartanyan
  Date: 1/29/18
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="header.jsp" %>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<div class="container py-2" style="width: 50rem">
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
        <c:if test="${not empty orderMap}">
            <c:forEach items="${orderMap}" var="orderItem">
                <tr>
                    <td>
                        <div class="row">
                            <div class="col-md-4">
                                <img src="${orderItem.key.picture}" class="w-100">

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
                                <a href="/increase/${orderItem.key.id}" class="btn btn-secondary">
                                    <!--{orderItem.value}/{orderItem.key.id}"--> <span
                                        class="sign fa fa-plus"></span></a>
                                <input type="text" name="quant${orderItem.key.id}" class="form-control input-number"
                                       value="${orderItem.value}" min="1" max="10">
                                <c:if test="${orderItem.value == 1}">
                                    <a href="/reduce/${orderItem.key.id}" class="btn btn-secondary"
                                       style="cursor: not-allowed">
                                        <span class="sign fa fa-minus"></span></a>
                                </c:if>
                                <c:if test="${orderItem.value > 1}">
                                    <a href="/reduce/${orderItem.key.id}" class="btn btn-secondary">
                                        <span class="sign fa fa-minus"></span></a>
                                </c:if>
                            </div>
                        </div>
                    </td>
                    <td style="text-align: center">
                        <a href="/" class="btn btn-success inline"><span class="fa fa-check"></span></a>

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
            You have ${fn:length(orderMap)} items in your cart
        </h5>
        <h4 class="col-md-5">
            Total amount: ${ordersTotalAmount}$
        </h4>
        <a href="/submitOrder" class="btn btn-success col-md-2" style="margin-bottom: 10%">
            Submit All <span class="fa fa-check"></span>
        </a>

    </div>


</div>
<%@ include file="footer.jsp" %>
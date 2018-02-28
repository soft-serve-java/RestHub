<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>

<script src="/js/liveCall.js"></script>
<div class="container" >
<div class="row">
<div class="liveTables" ng-app="liveCall" ng-controller="LiveController">
    <div class="card-deck">
            <c:forEach begin="1" end="${tables.quantityOfTables}" varStatus="loop">
                <div class="col-md-4 col-sm-6 col-xs-6">
                    <div class="card">
                        <img ng-if="isOnDelivery(${loop.index})" class="imageforDelivery" src="/images/delivery.jpg"/>
                        <div ng-class="{hasNullWaiter:hasNullWaiter(${loop.index}),
                             isOfCurrentWaiter:getCurrentWaiter(${loop.index})=='${pageContext.request.userPrincipal.name}',
                            isOfOtherWaiter:isOfOtherWaiter(${loop.index}+'${pageContext.request.userPrincipal.name}')}">
                            <div class="bell" ng-if="isCalling(${loop.index})">
                                <i class="fa fa-bell fa-2x" aria-hidden="true"></i>
                            </div>
                            <div class="card-body">
                            <h1 class="card-title">${loop.index}</h1>
                                <a href="/waiter/orderdetails/${loop.index}" class="btn btn-default btn-sm">Order details</a>
                                <div class="row">
                                    <button onclick="doPOSTonGettingTable(${loop.index})" class="btn btn-success btn-sm">Get this table</button>
                                    <button onclick="doPOSTonCloseCalling(${loop.index})" class="btn btn-default btn-sm">Accept calling</button>
                                </div>
                        </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
</div>
</div>
</div>
<style>
    .isOfCurrentWaiter{
        background-color: lemonchiffon;
    }
    .hasNullWaiter{
        background-color: palegreen;
    }
    .isOnDelivery{

    }
    .isOfOtherWaiter{
        pointer-events: none;
        opacity: 0.4;
        background: gainsboro;
    }
    .imageforDelivery{
        position: absolute;
        width: 25%;
        height: 25%;
        margin-right: 100px;

    }
    .bell{
        position: absolute;
        margin-top: 0%;
        margin-left: 80%;

    }
</style>

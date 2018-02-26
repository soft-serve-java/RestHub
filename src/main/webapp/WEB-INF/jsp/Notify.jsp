<%@ include file="header.jsp" %>
<script src="/js/liveCall.js"></script>
<div class="container" >
<div class="row">
<div class="liveTables" ng-app="liveCall" ng-controller="LiveController">
    <div class="card-deck">
            <c:forEach begin="1" end="${tables.quantityOfTables}" varStatus="loop">
                <div class="col-md-4 col-sm-6 col-xs-6">
                    <div class="card" style="width: 18rem;">
                        <!--,
                              isOfCurrentWaiter:isOfCurrentWaiter(${loop.index},${pageContext.request.userPrincipal.name}),
                              hasNullWaiter:hasNullWaiter(${loop.index}),
                              isNotOfCurrentWaiter:isNotOfCurrentWaiter(${loop.index}, ${pageContext.request.userPrincipal.name})-->

                        <div onclick="doPOSTonCloseCalling(${loop.index})"
                             ng-class="{hasNullWaiter:hasNullWaiter(${loop.index}),
                             isOfCurrentWaiter:getCurrentWaiter(${loop.index})=='${pageContext.request.userPrincipal.name}',
                            isOfOtherWaiter:isOfOtherWaiter(${loop.index}+'${pageContext.request.userPrincipal.name}')}">
                            <div ng-if="isCalling(${loop.index})">
                                <i class="fa fa-bell fa-3x" aria-hidden="true"></i>
                            </div>
                            <div class="card-body">
                            <h1 class="card-title">${loop.index}</h1>
                        </div>
                        </div>
                        <div ng-if="hasNullWaiter(${loop.index})">Has Null Waiter</div>
                        <img ng-if="isOnDelivery(${loop.index})" class="imageforDelivery" src="/images/delivery.jpg"/>
                    </div>
                </div>
            </c:forEach>
        </div>
</div>
</div>
</div>
<style>
    .isOfCurrentWaiter{
        background-color: sandybrown;
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
        margin-top: -25%;
        width: 25%;
        height: 10%;
    }
</style>
<%@ include file="footer.jsp" %>
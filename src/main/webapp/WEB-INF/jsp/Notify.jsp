<%@ include file="header.jsp" %>
<script type="text/javascript">
    $('.callingTable').fadeTo(100, 0.3, function() { $(this).fadeTo(500, 1.0); });
    var app = angular.module('liveCall', ['ngStomp']);
    app.controller('LiveController', function ($stomp, $scope) {
        $scope.myres = [];
        $scope.tables = [];
        $scope.isCalling = function(table){
            angular.forEach( $scope.tables, function (value) {
                console.log(value);
                if (value.currentTable==table&&value.tableStatus=='CALLING_WAITER'){
                    return true;
                }
            });
            return false;
        };
        $stomp.connect('/call', {})
            .then(function (frame) {
                var subscription = $stomp.subscribe('/waiter/tables',
                    function (payload, headers, res) {
                        $scope.myres = payload;
                        $scope.$apply($scope.myres);
                        $scope.tables = [];
                        angular.forEach( $scope.myres, function(value, key) {
                                $scope.tables.push(value);
                            console.log(value);
                        });
                    });
                $stomp.send('app/waiterCall', '');
            });
    });
    function doPOSTonCloseCalling(table, $scope) {
            console.log("POST");
            $.ajax({
                url: '/acceptCalling',
                type: 'POST',
                data: {"table": table},
                success: function () {
                },
                error: function () {
                }
            });
    }
</script>
<div class="container" >
<div class="row">

<div class="liveTables" ng-app="liveCall" ng-controller="LiveController">
    <!--<ul>
        <li ng-repeat="x in myres">{{x.table.currentTable}}</li>
    </ul>-->
    <div class="card-deck">
            <c:forEach begin="1" end="${tables.quantityOfTables}" varStatus="loop">
                <div class="col-md-4 col-sm-6 col-xs-6">
                    <div class="card" style="width: 18rem;">
                        <div onclick="doPOSTonCloseCalling(${loop.index})
                                "ng-class="{'callingTable':isCalling(${loop.index})}">
                        <div class="card-body">
                            <div class="animated pulse">
                            <h1 class="card-title">${loop.index}</h1>
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
<%@ include file="footer.jsp" %>
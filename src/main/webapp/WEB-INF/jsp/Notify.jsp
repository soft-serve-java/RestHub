<%@ include file="header.jsp" %>
<script type="text/javascript">

    var app = angular.module('liveCall', ['ngStomp']);

    app.controller('LiveController', function ($stomp, $scope) {

        $scope.myres = [];
        $stomp.connect('/call', {})
            .then(function (frame) {
                var subscription = $stomp.subscribe('/waiter/tables',
                    function (payload, headers, res) {
                        $scope.myres = payload;
                        $scope.$apply($scope.myres);
                    });
                $stomp.send('app/waiterCall', '');
            });
    });

</script>
<div class="liveScore" ng-app="liveCall" ng-controller="LiveController">
    <ul>
        <li ng-repeat="x in myres">{{x.table.currentTable}}</li>
    </ul>
</div>
<%@ include file="footer.jsp" %>
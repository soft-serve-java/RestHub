var app = angular.module('liveCall', ['ngStomp']);

app.controller('LiveController', function ($stomp, $scope) {
    $scope.myres = [];
    $scope.tables = [];
    $scope.isCalling = function(table){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            if (value.currentTable==table&&value.tableStatus=='CALLING_WAITER'){
                i =  true;
            }
        });
        return i;
    };
    $scope.getCurrentWaiter = function(table){
        var i = "no";
        angular.forEach( $scope.tables, function (value) {
            if (value.currentTable==table&&value.tableStatus=='HAS_WAITER'){
                i = value.currentWaiter.email;
            }
        });
        console.log(i);
        return i;
    };
    $scope.isOfOtherWaiter = function(tableWaiter){
        var i = false;
        var table = Number(tableWaiter.substring(0,1));
        angular.forEach( $scope.tables, function (value) {
            var test = "";
            if (table==value.currentTable&&value.tableStatus=='HAS_WAITER'){
                var test =  table+value.currentWaiter.email;
                if(test!=tableWaiter) {
                    i = true;
                }
            }
        });
        return i;
    };
    $scope.hasNullWaiter = function(table){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            if (value.currentTable==table&&value.tableStatus=='HAS_NULL_WAITER'){
                i =  true;
            }
        });
        return i;
    };
    $scope.isOnDelivery = function(table){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            if (value.currentTable==table&&value.tableStatus=='IS_ON_DELIVERY'){
                i =  true;
            }
        });
        return i;
    };
    $stomp.connect('/call', {})
        .then(function (frame) {
            console.log("connected");
            var subscription = $stomp.subscribe('/waiter/tables',
                function (payload, headers, res) {
                    $scope.myres = payload;
                    $scope.$apply($scope.myres);
                    $scope.tables = [];
                    angular.forEach( $scope.myres, function(value, key) {
                        $scope.tables.push(value);
                    });
                });
            $stomp.send('app/waiterCall', '');
        });
});
function doPOSTonCloseCalling(table, $scope) {
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
function doPOSTonGettingTable(table) {
    $.ajax({
        url: '/getTable',
        type: 'POST',
        data: {"table": table},
        success: function () {
        },
        error: function () {
        }
    });
}
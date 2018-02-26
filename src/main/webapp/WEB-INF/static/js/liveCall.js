var app = angular.module('liveCall', ['ngStomp']);
app.service('ngUserService', ['$http', function($http){
    var me = this;
    function getUser(callback) {
        if(me.currentUser)
            calback(me.currentUser);
        $http.get('/api/current_user').then(function(res){
            me.currentUser = res.data;
            callback(me.currentUser);
        });
    }
    return {getUser:getUser}
}]);
app.controller('LiveController', function ($stomp, $scope) {
    $scope.myres = [];
    $scope.tables = [];
    $scope.isCalling = function(table){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            if (value.currentTable==table&&value.tableStatus=='CALLING_WAITER'){
                console.log(value);
                i =  true;
            }
        });
        return i;
    };
    $scope.getCurrentWaiter = function(table){
        var i = "no";
        angular.forEach( $scope.tables, function (value) {
            if (value.currentTable==table&&value.tableStatus=='HAS_WAITER'){
                i =  value.currentWaiter;
            }
        });
        console.log(i);
        return true;
    };
    $scope.isOfOtherWaiter = function(table, waiter){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            console.log(value.currentWaiter.email)
            if (value.currentTable==table&&value.tableStatus=='HAS_WAITER'&&waiter==value.currentWaiter.email){
                i =  true;
                console.log(value.currentWaiter.email)
            }
        });
        console.log(i);
        return true;
    };
    $scope.hasNullWaiter = function(table){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            console.log($scope.currentUser);
            if (value.currentTable==table&&value.tableStatus=='HAS_NULL_WAITER'){
                console.log("HasNullWaiter");
                i =  true;
            }
        });
        return i;
    };
    $scope.isOnDelivery = function(table){
        var i = false;
        angular.forEach( $scope.tables, function (value) {
            console.log($scope.currentUser);
            if (value.currentTable==table&&value.tableStatus=='IS_ON_DELIVERY'){
                console.log("onDelivery");
                i =  true;
            }
        });
        console.log(i);
        return i;
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
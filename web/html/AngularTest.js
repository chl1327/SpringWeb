/**
 * Created by 心痕 on 2017-6-30.
 */
var app = angular.module('myApp', []);
app.controller('MyController', function($scope,$http) {
    $scope.book={
        id:null,
        name:null,
        author:null
    };
    $scope.showBook = false;
    $scope.Test = function(data) {
        $http({
            url: "json/setJson",
            method: "POST",
            data: {id: $scope.book.id,name:$scope.book.name}
        }).then(function (data) {
            console.log("success!");
            $scope.showBook = true;
            $scope.book.author = data.data.author;
            console.log(data);
        }).catch(function () {
            console.log("error");
        })
    };
});
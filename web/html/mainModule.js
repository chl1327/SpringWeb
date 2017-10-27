/**
 * Created by chl1327 on 2017/7/1.
 */
var app = angular.module('mainApp', ['ngResource','ngCookies']);
app.controller('mainController', function($scope,$resource,$cookies) {
    $scope.book_list = [];
    $scope.book={
        id:'',
        image:'',
        name:'',
        author:'',
        publication:'',
        publicationdate:'',
        price:'',
        remark:''
    };

    $scope.userVo={
        id:'',
        loginname:'',
        password:'',
        username:'',
        filekey:'',
        phone:'',
        address:''
    };


    //$scope.userVo = $cookies.getObject("CASTGC");
    /*if (!$scope.userVo) {
        window.location.href='loginForm';
    }else{*/
        var LoadInit = $resource('/book/main/:method',{method:'@method'});
        LoadInit.get({method:'list'},function(result){
            if (result.success){
                $scope.book_list = result.data;
                $scope.userVo = result.userVo;
                console.log(result);
            }else if (result.error){
                window.location.href = 'loginForm';
                console.log(result);
            }else{
                $scope.message = result.data.message;
                $.messager.alert('',$scope.message,'warning');
            }
        });
    //}
    $scope.showBook = function(bid){
        var LoadInit = $resource('/book/selectBook/:id',{id:'@id'});
        LoadInit.get({id:bid},function(result){
            if (result.success){
                $scope.book = result.data;
                //window.location.href = 'AngularTest';
                console.log(result);
            }else{
                console.log(result);
            }
        });
    };
        /*$http({
         url: "user/login",
         method: "GET",
         params: {loginname: $scope.userVo.loginname,password:$scope.userVo.password}
         }).then(function (data) {
         console.log("success!");
         $scope.showUser = true;
         $scope.userVo = data.data.data;
         console.log(data);
         }).catch(function (data) {
         console.log(data);
         console.log("error");
         })*/

});
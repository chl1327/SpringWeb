/**
 * Created by chl1327 on 2017/7/1.
 */
var app = angular.module('myApp', ['ngResource','ngCookies']);
app.controller('loginController', function($scope,$resource,$cookies) {
    $scope.userVo={
        id:'',
        loginname:'',
        password:'',
        username:'',
        filekey:'',
        phone:'',
        address:''
    };

    $scope.loginSub = function() {
        if (!$scope.userVo.loginname || !$scope.userVo.password){
            $.messager.alert('','用户名或密码为空！','warning');
        }else{
            var LoadInit = $resource('/user/login',{});
            LoadInit.save($scope.userVo,function(result){
                if (result.success){
                    $scope.showUser = true;
                    $scope.userVo = result.data;
                    //$cookies.putObject($scope.userVo.id,$scope.userVo);
                    window.location.href = 'main';

                }else{
                    reset();
                    $.messager.alert('','用户名或密码错误！','error');
                }
            });
        }
    };

    var reset = function(){
        $scope.userVo={
            loginname:'',
            password:''
        };
    };
});
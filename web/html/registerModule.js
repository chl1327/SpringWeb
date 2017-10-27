/**
 * Created by 心痕 on 2017-7-4.
 */
var app = angular.module('regApp', ['ngResource']);
app.controller('registController', function($scope,$resource,$http) {
    $scope.userVo={
        loginname:'',
        password:'',
        username:'',
        filekey:'',
        phone:'',
        address:''
    };

    $scope.pShow = false;
    $.extend($.fn.validatebox.defaults.rules, {
        mobile: {// 验证手机号码
            validator: function (value) {
                return /^(13|15|18)\d{9}$/i.test(value);
            },
            message: '手机号码格式不正确！'
        },
        equalTo: {
            validator: function (value, param) {
                if ($(param[0]).val() != "" && value != "") {
                    return $(param[0]).val() == value;
                } else {
                    return true;
                }
            },
            message: '密码不匹配，请重新输入！'
        }
    });

    $("input[name=file]").change(function() {
        $scope.pShow = true;
        $('#p').progressbar('setValue', 0);
        $scope.uploadFile();
        $('#p').progressbar('setValue', 100);
    });

    $scope.uploadFile = function(){
        var file = document.querySelector('input[type=file]').files[0];
        var fd = new FormData();
        fd.append("file",file);
        $http({
            method:'POST',
            url:"/file/upload",
            data: fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then( function (result) {
            $scope.message = result.data.message;
            $scope.userVo.filekey = result.data.filekey;
            if ($scope.message != "success"){
                $.messager.alert('',$scope.message,'warning');
            }
        });

    };

    $scope.SubmitForm = function(){
        var isValid = $('#regist').form('enableValidation').form('validate');
        if (isValid){
            var subForm = $resource('/user/register',{});
            subForm.save($scope.userVo,function(result){
                if (result.success){
                    window.location.href = 'loginForm';
                }
            });
        }

    };

    $scope.ClearForm = function(){
        $scope.userVo={
            loginname:'',
            password:'',
            username:'',
            phone:'',
            address:''
        };
    };
});
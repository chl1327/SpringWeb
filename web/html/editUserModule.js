/**
 * Created by 心痕 on 2017-7-11.
 */
var app = angular.module('editApp', ['ngResource','ngRoute']);

app.config(['$locationProvider', function($locationProvider) {
    // $locationProvider.html5Mode(true);
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false
    });
}])

    .controller('editUserController', function($scope,$resource,$http,$location) {
        $scope.userVo={
            id:'',
            loginname:'',
            password:'',
            username:'',
            filekey:'',
            phone:'',
            address:''
        };

        $scope.imgShow = false;
        $scope.fileVo = {
            filekey:'',
            filename:''
        };
        $scope.userVo.id = $location.search().userId;

        document.onreadystatechange = subSomething;//当页面加载状态改变的时候执行这个方法.
        function subSomething() {
            if (document.readyState == "complete") { //当页面加载状态
                $('#regist').form('resetValidation').form('validate');
            }
        }
        /*if (document.referrer = $location.absUrl()){
            $('#regist').form('resetValidation').form('validate');
        }*/
        $(function(){
             $('.validatebox-text').bind('focus', function(){
                $(this).validatebox('enableValidation').validatebox('validate');
             });
        });

        var LoadInit = $resource('/user/getUserInfo/:userId',{userId:'@userId'});
        LoadInit.get({userId:$scope.userVo.id},function(result){
            if (result.success){
                $scope.userVo = result.data;
                $scope.fileVo.filekey = result.data.filekey;
                $scope.imgShow = true;
                $('#regist').form('disableValidation').form('validate');
            }else{
                $scope.message = result.error;
                $.messager.alert('',$scope.message,'warning');
            }
        });

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
            $scope.fileVo.filename = file.name;
            $http({
                method:'POST',
                url:"/file/upload",
                data: fd,
                headers: {'Content-Type':undefined},
                transformRequest: angular.identity
            }).then( function (result) {
                $scope.message = result.data.message;
                $scope.userVo.filekey = result.data.filekey;
                $scope.fileVo.filekey = result.data.filekey;
                $scope.imgShow = true;
                if ($scope.message != "success"){
                    $.messager.alert('',$scope.message,'warning');
                }
            });

        };

        $scope.SubmitForm = function(){
            var isValid = $('#regist').form('enableValidation').form('validate');
            if (isValid){
                var subForm = $resource('/user/updateUser',{});
                subForm.save($scope.userVo,function(result){
                    if (result.success){
                        window.location.href = 'main';
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
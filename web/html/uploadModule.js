/**
 * Created by 心痕 on 2017-7-5.
 */
var app = angular.module('uploadApp', ['ngResource']);
app.controller('uploadController', function($scope,$resource,$http) {
    $scope.fileVo = {
        filekey:'',
        filename:''
    };

    $("input[name=file]").change(function() {
        $scope.test();
    });

    $scope.test = function() {
        var fd = new FormData();
        var file = document.querySelector('input[type=file]').files[0];
        fd.append("file",file);
        $scope.fileVo.filename = file.name;
        $http({
            method:'POST',
            url:"/file/upload",
            data: fd,
            headers: {'Content-Type':undefined},
            transformRequest: angular.identity
        }).then( function ( result ) {
            $scope.message = result.data.message;
            $scope.fileVo.filekey = result.data.filekey;
            if ($scope.message == "success"){
                $.messager.alert('','success！','success');
            }else{
                $.messager.alert('',$scope.message,'warning');
            }
            //上传成功的操作
        });

    };

});
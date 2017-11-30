/**
 * Created by 心痕 on 2017-11-28.
 */
$(function(){

    var userVo={
        'loginname':'tom',
        'password':'1234'
    };

    var payData = '';
    $(document).ready(function(){
        $.ajax({
            url:"/user/login",
            data:JSON.stringify(userVo),
            type:'post',
            contentType: 'application/json;charset=utf-8',
            success:function(data){
                payData = data.data;
                console.info(payData);
                var obj = {
                    callback:function(data){
                        $('#payContentTip').text(data.loginname);
                    },
                    payData:payData
                };
                $('#paymentCponent').PaymentComponent(obj);
            }
        });
        $("button").click(function(){

        });
    });


});
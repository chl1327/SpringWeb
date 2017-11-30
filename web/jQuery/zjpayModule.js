/**
 * Created by 心痕 on 2017-11-28.
 */
(function (window,$){

    function createStyle(){
        var style = '*{margin: 0;padding:0;}'+
                'ul>li{list-style:none;}'+
                '#paymentCponent{width: 100%;}'+
                /*Tab框*/
                '.wrap{width: 1060px;margin: 10px auto;font-size: 14px;}'+
                '.clearfix{*zoom: 1;}'+
                '.clearfix:after {content: "";clear: both;display: block;height: 0;font-size: 0;visibility: hidden;}'+
                '.blist {border:1px solid #d9d9d9;width: 275px;height: 32px;}'+
                '.blist li:first-child{border-left: none;}'+
                '.blist li{list-style: none;width: 68px;height: 32px;border-left:1px solid #d9d9d9;font-size: 14px;font-family: "楷体";line-height: 32px;text-align: center;float: left;cursor: pointer; -webkit-user-select: none;}'+
                '.blsit-list{width: 275px;}'+
                '.blsit-list li{list-style: none;width: 275px;border:1px solid #ccc;height: 200px;border-top: none;}'+
                '.wrap .blist li.active{font-weight: bold;color: red;border-top: 2px solid red;position: relative;top:-1px;height: 31px;}'+
                '.blsit-list li:first-child{display: block;}'+
                '.blsit-list li{display: none;}';
        $('<style></style>').html(style).appendTo($('head'));
    }
    createStyle();

    function PaymentComponent(dom,data){
        this.dom = dom;
        this.data = data.payData;
        console.log(this.data);
        this.callback = data.callback;
        this.params = {
            type:1
        };
        this.init();
    }

    PaymentComponent.prototype.init = function(){
        this.createList();
        var self = this;

    };

    PaymentComponent.prototype.createList = function(){
        var list = [],list1 = [],
            self = this;
        var _data=this.data,_li,li1;

        _li = $('<li class="active">'+_data.loginname+'</li>');
        list.push(_li);
        _li = $('<li>movie</li>');
        list.push(_li);
        li1 = $('<li>A</li>');
        list1.push(li1);
        li1 = $('<li>B</li>');
        list1.push(li1);
        var cashPayCptHtml = '<div class="wrap">'+
                '<ul class="blist clearfix"></ul>'+
                '<ul class="blsit-list"></ul>'+
                '</div>';
        var cashPayCpt = $(cashPayCptHtml);
        cashPayCpt.find('.blist').html(list);
        cashPayCpt.find('.blsit-list').html(list1);
        this.dom.html(cashPayCpt);
        $(".blist").on("click","li",function() {
            self.chooseLi.call(this,self);
        });
    };

    PaymentComponent.prototype.chooseLi=function(obj,self){
        var index = $(this).index();
        $(this).addClass("active").siblings().removeClass("active");
        $(this).parents(".wrap").find(".blsit-list li").eq(index).show().siblings().hide();
    };

    $.fn.PaymentComponent = function(obj){
        new PaymentComponent(this,obj);
    }
})(window,$);
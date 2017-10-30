/**
 * Created by 心痕 on 2017-10-27.
 */
$(function(){
    $(".blist").on("click","li",function(){
        // 设index为当前点击
        var index = $(this).index();
        // 点击添加样式利用siblings清除其他兄弟节点样式
        $(this).addClass("active").siblings().removeClass("active");
        // 同理显示与隐藏
        $(this).parents(".wrap").find(".blsit-list li").eq(index).show().siblings().hide();
    })
    var list = '1111';
    $("#name").text(list);
    /*单击按钮方法*/
    $("p").click(function(){
        // 动作触发后执行的代码!!
    });
    var newText = "111";
    $("#name").text(function(newText,origText){
        return  newText;
    });

    /*鼠标移入输入框*/
    $(document).ready(function(){
        $("input").focus(function(){
            $(this).css("background-color","#cccccc");
        });
        $("input").blur(function(){
            $(this).css("background-color","#ffffff");
        });
    });
    /*显示和隐藏*/
    $("#hide").click(function(){
        $("p").hide();
    });

    $("#show").click(function(){
        $("p").show();
    });

    /*获取输入值*/
    $(document).ready(function(){
        $("button").click(function(){
            alert("值为: " + $("#test").val());
        });
    });

    function DataBinder(object_id){
        //使用一个jQuery对象作为简单的订阅者发布者
        var pubSub = jQuery({});

        //我们希望一个data元素可以在表单中指明绑定：data-bind-<object_id>="<property_name>"

        var data_attr = "bind-" + object_id,
            message = object_id + ":change";

        //使用data-binding属性和代理来监听那个元素上的变化事件
        // 以便变化能够“广播”到所有的关联对象

        jQuery(document).on("change","[data-" + data_attr + "]",function(evt){
            var input = jQuery(this);
            pubSub.trigger(message, [ $input.data(data_attr),$input.val()]);
        });

        //PubSub将变化传播到所有的绑定元素，设置input标签的值或者其他标签的HTML内容

        pubSub.on(message,function(evt,prop_name,new_val){
            jQuery("[data-" + data_attr + "=" + prop_name + "]").each(function(){
                var $bound = jQuery(this);

                if($bound.is("input,text area,select")){
                    $bound.val(new_val);
                }else{
                    $bound.html(new_val);
                }
            });
        });

        return pubSub;
    }

    function User(uid){
        var binder = new DataBinder(uid),

            user = {
                atttibutes: {},

                //属性设置器使用数据绑定器PubSub来发布变化

                set: function(attr_name,val){
                    this.attriures[attr_name] = val;
                    binder.trigger(uid + ":change", [attr_name, val, this]);
                },

                get: function(attr_name){
                    return this.attributes[attr_name];
                },

                _binder: binder
            };

        binder.on(uid +":change",function(vet,attr_name,new_val,initiator){
            if(initiator !== user){
                user.set(attr_name,new_val);
            }
        })
    }

    var user = new User(123);
    user.set("name","Wolfgang");

});

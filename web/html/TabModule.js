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
    $("#name").text(111);
    /*单击按钮方法*/
    $("p").click(function(){
        // 动作触发后执行的代码!!

    });
    var newText = "111";
    $("name").text(function(newText,origText){
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

    var showii = false;
    $("#ii").show(showii);
    $("#btn").click(function(){
        showii = ~showii;
        $("#ii").show(showii);
    })

});

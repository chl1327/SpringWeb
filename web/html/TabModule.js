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
});

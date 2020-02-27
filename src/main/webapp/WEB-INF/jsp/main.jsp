<%--
  Created by IntelliJ IDEA.
  User: Yeoma
  Date: 2020/1/12
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yeoman管理系统</title>
    <link rel="stylesheet" href="extend/layui/css/layui.css">
</head>
<body>
    <div id="left-side">
        <ul class="layui-nav layui-nav-tree layui-nav-side" lay-filter="test" style="height: 100%;">
            <li class="show layui-nav-item layui-nav-itemed"><i class="layui-icon layui-icon-face-smile" aria-hidden="true"></i></li>
            <!-- 侧边导航: <ul class="layui-nav layui-nav-tree layui-nav-side"> -->
            <li class="layui-nav-item layui-nav-itemed">
                <a href="javascript:;">默认展开</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"><i class="layui-icon layui-icon-home" style="margin-right: 3px;"></i><span>选项1</span></a></dd>
                    <dd><a href="javascript:;">选项2</a></dd>
                    <dd><a href="">跳转</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">解决方案</a>
                <dl class="layui-nav-child">
                    <dd><a href="">移动模块</a></dd>
                    <dd><a href="">后台模版</a></dd>
                    <dd><a href="">电商平台</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">产品</a></li>
            <li class="layui-nav-item"><a href="">大数据</a></li>
        </ul>
    </div>
</body>
<script src="extend/layui/layui.all.js"></script>
<script>
    var $;
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
        $ = layui.$;
        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });

    let isShow = true;
    $(".show").click(function () {
        $(".layui-nav-item span").each(function () {
            if ($(this).is(":hidden")) {
                $(this).show();
            } else {
                $(this).hide();
            }
        });

        if(isShow){
            $('#left-side').width(60); //设置宽度
            $('#left-side i').css('margin-right', '70%');  //修改图标的位置
            //将footer和body的宽度修改
            $('.layui-body').css('left', 60+'px');
            $('.layui-footer').css('left', 60+'px');
            //将二级导航栏隐藏
            $('dd span').each(function(){
                $(this).hide();
            });
            //修改标志位
            isShow =false;
        }else{
            $('#left-side').width(200);
            $('#left-side i').css('margin-right', '10%');
            $('.layui-body').css('left', 200+'px');
            $('.layui-footer').css('left', 200+'px');
            $('dd span').each(function(){
                $(this).show();
            });
            isShow =true;
        }
    });

</script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Yeoma
  Date: 2020/1/12
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yeoman管理系统</title>
    <link rel="stylesheet" href="extend/layui/css/layui.css">
</head>
<body>
<div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
        <div title="菜单缩放" class="kit-side-fold"><i class="layui-icon layui-icon-face-smile" aria-hidden="true"></i></div>
        <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
        <ul class="layui-nav layui-nav-tree"  lay-filter="test">
            <li class="layui-nav-item layui-nav-itemed">
                <a class="" href="javascript:;"><i class="layui-icon layui-icon-face-smile"></i> <span >生源追踪</span></a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"><i class="layui-icon layui-icon-face-smile"></i> <span >生源列表</span></a></dd>
                    <dd><a href="javascript:;"><i class="layui-icon layui-icon-face-smile"></i> <span >学校信息</span></a></dd>
                    <dd><a href="javascript:;"><i class="layui-icon layui-icon-face-smile"></i> <span >工做计划</span></a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="fa fa-vcard fa-lg"></i> <span >学员管理</span></a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"><i class="fa fa-th-list fa-lg"></i> <span >学员列表</span></a></dd>
                    <dd><a href="javascript:;"><i class="fa fa-user-o fa-lg"></i> <span >考勤管理</span></a></dd>
                    <dd><a href="javascript:;"><i class="fa fa-send-o fa-lg"></i> <span >沟通计划</span></a></dd>
                    <dd><a href="javascript:;"><i class="fa fa-frown-o fa-lg"></i> <span >成绩管理</span></a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="fa fa-diamond fa-lg"></i> <span >管理设置</span></a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"><i class="fa fa-address-book fa-lg"></i> <span >账号管理</span></a></dd>
                    <dd><a href="javascript:;"><i class="fa fa-check-square fa-lg"></i> <span >授权管理</span></a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;"><i class="fa fa-gear fa-lg"></i> <span >系统管理</span></a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;"><i class="fa fa-window-restore fa-lg"></i> <span >系统信息</span></a></dd>
                    <dd><a href="javascript:;"><i class="fa fa-database fa-lg"></i> <span >操作日志</span></a></dd>
                </dl>
            </li>
        </ul>
    </div>
</div>
</body>
<script src="extend/layui/layui.all.js"></script>
<script src="js/jquery-3.3.1.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
    var isShow = true;  //定义一个标志位
    $('.kit-side-fold').click(function(){
        //选择出所有的span，并判断是不是hidden
        $('.layui-nav-item span').each(function(){
            if($(this).is(':hidden')){
                $(this).show();
            }else{
                $(this).hide();
            }
        });
        //判断isshow的状态
        if(isShow){
            $('.layui-side.layui-bg-black').width(60); //设置宽度
            $('.kit-side-fold i').css('margin-right', '70%');  //修改图标的位置
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
            $('.layui-side.layui-bg-black').width(200);
            $('.kit-side-fold i').css('margin-right', '10%');
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

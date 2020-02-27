<%--
  Created by IntelliJ IDEA.
  User: Yeoma
  Date: 2019/12/29
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yeoman管理系统</title>
    <link rel="stylesheet" href="css/register.css">
    <link rel="stylesheet" href="extend/layui/css/layui.css">
</head>
<body class="bg">
    <div>
        <form class="layui-form" id="registerDiv">
            <div class="layui-form-item" style="margin-top: 10px;">
                <div class="layui-inline">
                    <label class="layui-form-label">登录名：</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" placeholder="登录名" autocomplete="off" name="loginName">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" class="layui-input" autocomplete="off" placeholder="密码">
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">密码确认：</label>
                    <div class="layui-input-inline">
                        <input type="password" name="pwd" class="layui-input" autocomplete="off" placeholder="密码确认">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">用户名：</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" placeholder="用户名" autocomplete="off" name="userName">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">邮箱：</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" placeholder="邮箱" autocomplete="off" name="email">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">电话：</label>
                    <div class="layui-input-inline">
                        <input type="text" class="layui-input" placeholder="电话" autocomplete="off" name="phoneNumber">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">性别：</label>
                    <div class="layui-input-block" style="color: black;margin-left: 0;float: left;">
                        <input type="radio" class="layui-input" title="男" name="gender" value="man" checked>
                        <input type="radio" class="layui-input" title="女" name="gender" value="woman">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <%--<div class="layui-input-inline">--%>
                        <button class="layui-btn layui-btn-normal" type="button" style="float: right;">注册提交</button>
                    <%--</div>--%>
                </div>
            </div>


        </form>
    </div>
</body>
<script src="extend/layui/layui.all.js"></script>
<script>
    layui.use(['form'], function () {
        var  form = layui.form;
    });
</script>
</html>

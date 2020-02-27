<%--
  Created by IntelliJ IDEA.
  User: Yeoma
  Date: 2019/12/21
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Yeoman管理系统</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="extend/layui/css/layui.css">
</head>
<body class="bg">
    <div class="main">
        <div class="layui-row">
            <div class="m-b" id="loginDiv">
                <form class="layui-form">
                    <div class="layui-form-item login-input" style="margin-top: 20px;">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="text" name="username" lay-verify="required" lay-reqtext="用户名是必填项，岂能为空？" placeholder="用户名"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <i class="layui-icon layui-icon-friends sub-icon"></i>
                        </div>
                    </div>
                    <div class="layui-form-item login-input">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="text" name="password" lay-verify="required" lay-reqtext="密码是必填项，岂能为空？" placeholder="密码"
                                       autocomplete="off" class="layui-input">
                            </div>
                            <i class="layui-icon layui-icon-password sub-icon"></i>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-inline" style="width: 45%;">
                            <div class="layui-input-inline">
                                <input type="tel" name="phone" lay-verify="required|phone" autocomplete="off" class="layui-input" placeholder="验证码">
                            </div>
                        </div>
                        <div class="layui-inline" style="width: 32%;">
                            <div class="layui-input-inline">
                                <%--<input type="text" name="email" lay-verify="email" autocomplete="off" class="layui-input">--%>
                                <img src="/common/code" alt="验证码" style="border: 1px solid black;">
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item" style="height: 38px;float: left;margin-left: 10%;">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <input type="checkbox" name="rememberMe" lay-skin="primary" title="记住我" checked="">
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <button type="button" class="layui-btn layui-btn-fluid layui-btn-normal">登录</button>
                            </div>
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <h4><p style="">没有账号？<a href="/register">立即注册</a></p></h4>
                    </div>

                </form>
            </div>
        </div>
        <div class="footer-outer">
            <div class="footer">
                &copy; 2019 All Rights Reserved. Yeoman <br>
            </div>
        </div>
    </div>
</body>
<script src="extend/layui/layui.all.js"></script>
<script>
    layui.use(['form'], function () {
        var  form = layui.form;
    });
</script>
</html>

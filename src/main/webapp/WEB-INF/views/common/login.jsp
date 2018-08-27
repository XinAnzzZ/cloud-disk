<%--
  Created by IntelliJ IDEA.
  User: 心安
  Date: 2018/8/26 0026
  Time: 1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <div id="app" style="width: 40%;margin-top: 200px;margin-left: 30%">
        <el-form ref="loginForm" :model="loginForm" label-width="80px">
            <el-form-item label="用户名">
                <el-input v-model="loginForm.username" placeholder="请输入用户名"></el-input>
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="loginForm.password" @keydown.native="keyDown" type="password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="login">登录</el-button>
                <el-button @click="register">注册</el-button>
            </el-form-item>
        </el-form>
    </div>
    <script type="application/javascript">
        new Vue({
            el: "#app",
            data: {
                loginForm: {
                    username: '',
                    password: ''
                }
            },
            methods: {
                keyDown(event) {
                    if (event.keyCode === 13) {
                        this.login();
                    }
                },
                login() {
                    console.log("login run");
                },
                register() {
                    window.location.href = '/register';
                }
            }
        });
    </script>
</body>
</html>

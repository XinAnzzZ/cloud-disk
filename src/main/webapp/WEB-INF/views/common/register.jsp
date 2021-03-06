<%--
  Created by IntelliJ IDEA.
  User: 心安
  Date: 2018/8/26 0026
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div id="app" style="width: 40%;margin-top: 200px;margin-left: 30%">
    <el-form ref="registerForm" :model="registerForm" label-width="80px">
        <el-form-item label="用户名">
            <el-input v-model="registerForm.username" placeholder="请输入用户名"></el-input>
        </el-form-item>
        <el-form-item label="密码">
            <el-input v-model="registerForm.password" @keydown.native="keyDown" type="password"
                      placeholder="请输入密码"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="register()">注册</el-button>
            <el-button @click="login()">登录</el-button>
        </el-form-item>
    </el-form>
</div>
<script type="application/javascript">
    new Vue({
        el: "#app",
        data: {
            registerForm: {
                username: '',
                password: ''
            }
        },
        methods: {
            keyDown(event) {
                // 按下enter
                if (event.keyCode === 13) {
                    this.register();
                }
            },
            login() {
                window.location.href = '/login';
            },
            register() {
                $.ajax({
                    url: "/register",
                    type: 'post',
                    contentType: "application/json",
                    data: JSON.stringify(this.registerForm),
                    success: function (response) {
                        console.log(response);
                    }
                });
            }
        }
    });
</script>
</body>
</html>

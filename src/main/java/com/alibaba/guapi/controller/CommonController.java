package com.alibaba.guapi.controller;

import com.alibaba.guapi.common.enums.ResponseEnum;
import com.alibaba.guapi.common.util.ResponseJson;
import com.alibaba.guapi.entity.User;
import com.alibaba.guapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author XinAnzzZ
 * @date 2018/8/13 11:13
 */
@Slf4j
@Controller
public class CommonController {

    @Autowired
    private UserService userService;

    /**
     * 404
     */
    @RequestMapping("/not/found")
    public String to404() {
        return "common/404";
    }

    /**
     * unauthorized
     */
    @RequestMapping("/common/unauthorized")
    public String unauthorizedPage() {
        return "/common/unauthorized";
    }

    /**
     * login页面
     * 关于请求方式：http 1.1 之后有了8种method 其中有  post delete put get 分别对应增删改查
     * 获取数据使用get 插入或者更新数据用post或者put  删除数据用delete
     * restful 注意，url中尽量不要出现动词
     */
    @GetMapping("/login")
    public String toLoginPage() {
        return "/common/login";
    }

    /**
     * 登陆逻辑处理
     */
    @PostMapping("/login")
    @ResponseBody
    public ResponseJson login(@RequestBody User user) {
        // 第一步，表单校验
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException e) {
            return ResponseJson.fail(ResponseEnum.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e2) {
            return ResponseJson.fail(ResponseEnum.INCORRECT_CREDENTIAL);
        } catch (Exception e3) {
            return ResponseJson.fail(ResponseEnum.LOGIN_FAILURE);
        }
        return ResponseJson.success();
    }

    /**
     * 注册页面
     */
    @GetMapping("/register")
    public String toRegister() {
        return "/common/register";
    }

    /**
     * 用户注册，前台传递json数据，即content-type = application/json时，后台spring mvc接收数据需要使用@RequestBody注解
     */
    @ResponseBody
    @PostMapping("/register")
    public ResponseJson register(@RequestBody User user) {
        // 表单校验
        return userService.register(user);
    }
}

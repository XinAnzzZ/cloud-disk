package com.alibaba.guapi.common.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/8/14 15:11
 */
@Getter
public enum ResponseEnum {

    /*** 账号不存在 */
    UNKNOWN_ACCOUNT(401, "账号不存在！"),

    /*** 密码错误 */
    INCORRECT_CREDENTIAL(402, "密码错误！"),

    /*** 没有访问权限 */
    UNAUTHORIZED(403, "没有访问权限！"),

    /*** 登陆失败 */
    LOGIN_FAILURE(406, "登陆失败！"),

    /*** 未知错误 */
    UNKNOWN_ERROR(500, "未知错误!");

    private int code;

    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

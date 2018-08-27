package com.alibaba.guapi.common.enums;

/**
 * @author XinAnzzZ
 * @date 2018/8/22 16:14
 */
@SuppressWarnings("unused")
public enum RoleEnum {

    /*** 管理员 */
    ADMIN(1, "ADMIN"),

    /*** 用户 */
    USER(2, "USER");

    private int code;

    private String msg;

    RoleEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

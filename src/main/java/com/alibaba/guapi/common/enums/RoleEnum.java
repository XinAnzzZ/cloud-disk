package com.alibaba.guapi.common.enums;

import lombok.Getter;

/**
 * @author XinAnzzZ
 * @date 2018/8/22 16:14
 */
@Getter
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
}

package com.feoyang.application.statistics.api.rest.model.enums;

import lombok.Getter;

/**
 * @author: feoyang
 * @date: 2024/1/11 0:32
 * @description: TODO
 */
@Getter
public enum LoginResultEnum implements ResultEnum {
    SUCCESS(0, "登录成功"),
    UNKNOWN_ACCOUNT(1, "该账号不存在！"),
    UNMATCHED_PASSWORD(2, "密码错误！");

    private final int code;
    private final String message;

    LoginResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

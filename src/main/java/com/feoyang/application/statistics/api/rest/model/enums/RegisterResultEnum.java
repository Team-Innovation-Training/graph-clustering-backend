package com.feoyang.application.statistics.api.rest.model.enums;

import lombok.Getter;

/**
 * @author: feoyang
 * @date: 2024/1/11 2:46
 * @description: TODO
 */
@Getter
public enum RegisterResultEnum implements ResultEnum {
    SUCCESS(0, "注册成功！"),
    EXISTED_ACCOUNT(1, "该账号已被注册！");

    private final int code;
    private final String message;

    RegisterResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

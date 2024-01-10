package com.feoyang.application.statistics.api.controller.model.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: feoyang
 * @date: 2024/1/11 0:32
 * @description: TODO
 */
@Getter
public enum LoginResultEnum implements ResultEnumInterface {
    SUCCESS(0, "登录成功"),
    UNKNOWN_ACCOUNT(1, "账号不存在！"),
    UNMATCHED_PASSWORD(2, "密码错误！");

    private int code;
    private String message;

    LoginResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

package com.feoyang.application.statistics.api.rest.model.enums;

import lombok.Getter;

/**
 * @author: feoyang
 * @date: 2024/1/12 11:40
 * @description: TODO
 */
@Getter
public enum ProfileResultEnum implements ResultEnum {
    SUCCESS(0, "成功获取用户基本信息！"),
    TOKEN_UNVERIFIED(1, "token 验证失败，请重新登录!");

    private final int code;
    private final String message;

    ProfileResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

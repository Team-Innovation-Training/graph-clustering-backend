package com.feoyang.application.statistics.api.controller.model;

import com.feoyang.application.statistics.api.controller.model.enums.ResultEnumInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: feoyang
 * @date: 2024/1/11 0:19
 * @description: TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;
    private String message;
    private Object data;

    private Result(ResultEnumInterface resultEnum, Object data) {
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
}

package com.feoyang.application.statistics.api.rest.model;

import com.feoyang.application.statistics.api.rest.model.enums.ResultEnum;
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
    private boolean success;
    private int code;
    private String message;
    private Object data;

    private Result(Boolean success, ResultEnum resultEnum, Object data) {
        this.success = success;
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
        this.data = data;
    }
}

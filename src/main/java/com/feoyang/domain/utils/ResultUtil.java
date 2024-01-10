package com.feoyang.domain.utils;

import com.feoyang.application.statistics.api.controller.model.Result;
import com.feoyang.application.statistics.api.controller.model.enums.ResultEnumInterface;

/**
 * @author: feoyang
 * @date: 2024/1/11 0:52
 * @description: TODO
 */
public class ResultUtil {
    public static Result success(ResultEnumInterface resultEnum, Object object) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setData(object);
        return result;
    }

    public static Result success(ResultEnumInterface resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    public static Result error(ResultEnumInterface resultEnum) {
        Result result = new Result();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
}

package com.feoyang.domain.utils;

import com.feoyang.application.statistics.api.rest.model.Result;
import com.feoyang.application.statistics.api.rest.model.enums.ResultEnum;

/**
 * @author: feoyang
 * @date: 2024/1/11 0:52
 * @description: TODO
 */
public class ResultUtil {
    public static Result success(ResultEnum resultEnum, Object object) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        result.setData(object);
        return result;
    }

    public static Result success(ResultEnum resultEnum) {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }

    public static Result error(ResultEnum resultEnum) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMessage());
        return result;
    }
}

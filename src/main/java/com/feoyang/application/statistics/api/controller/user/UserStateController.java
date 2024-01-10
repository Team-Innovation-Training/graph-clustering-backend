package com.feoyang.application.statistics.api.controller.user;

import com.feoyang.application.statistics.api.controller.model.Result;
import com.feoyang.application.statistics.api.controller.model.enums.LoginResultEnum;
import com.feoyang.application.statistics.api.controller.model.enums.RegisterResultEnum;
import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.domain.statistics.entity.UserLoginEntity;
import com.feoyang.domain.statistics.service.user.UserStateService;
import com.feoyang.domain.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: feoyang
 * @date: 2024/1/10 1:37
 * @description: TODO
 */
@RestController
@RequestMapping("")
public class UserStateController {
    @Autowired
    private UserStateService userStateService;

    @PostMapping("/login")
    public Result login(@RequestBody UserLoginDTO userLoginDTO) {
        UserLoginEntity userLoginEntity = userStateService.loginUser(userLoginDTO);
        if (userLoginEntity == null) {
            return ResultUtil.error(LoginResultEnum.UNKNOWN_ACCOUNT);
        } else if (userLoginEntity.getToken() == null) {
            return ResultUtil.error(LoginResultEnum.UNMATCHED_PASSWORD);
        } else {
            return ResultUtil.success(LoginResultEnum.SUCCESS, userLoginEntity);
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO) {
        Boolean registered = userStateService.registerUser(userRegisterDTO);
        if (registered) {
            return ResultUtil.success(RegisterResultEnum.SUCCESS);
        } else {
            return ResultUtil.error(RegisterResultEnum.EXISTED_ACCOUNT);
        }
    }
}

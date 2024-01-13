package com.feoyang.domain.statistics.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.feoyang.application.statistics.api.rest.model.Result;
import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.domain.statistics.entity.UserEntity;

import java.util.Optional;

/**
 * @author: feoyang
 * @date: 2024/1/10 3:40
 * @description: TODO
 */
public interface UserStateService {
    Result loginUser(UserLoginDTO userLoginDTO);
    Result registerUser(UserRegisterDTO userRegisterDTO);
    Result getUserProfile();
}

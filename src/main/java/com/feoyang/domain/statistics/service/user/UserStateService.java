package com.feoyang.domain.statistics.service.user;

import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.domain.statistics.entity.UserLoginEntity;

/**
 * @author: feoyang
 * @date: 2024/1/10 3:40
 * @description: TODO
 */
public interface UserStateService {
    UserLoginEntity loginUser(UserLoginDTO userLoginDTO);
    Boolean registerUser(UserRegisterDTO userRegisterDTO);

}

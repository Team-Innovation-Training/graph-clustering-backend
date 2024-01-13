package com.feoyang.domain.statistics.service.user.impl;

import com.feoyang.application.statistics.api.rest.model.Result;
import com.feoyang.application.statistics.api.rest.model.enums.LoginResultEnum;
import com.feoyang.application.statistics.api.rest.model.enums.ProfileResultEnum;
import com.feoyang.application.statistics.api.rest.model.enums.RegisterResultEnum;
import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.application.statistics.security.UserAuthProvider;
import com.feoyang.domain.statistics.entity.UserEntity;
import com.feoyang.domain.utils.ResultUtil;
import com.feoyang.infrastructure.statistics.persistence.repository.user.UserStateRepository;
import com.feoyang.domain.statistics.service.user.UserStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: feoyang
 * @date: 2024/1/10 3:41
 * @description: TODO
 */
@Service
public class UserStateServiceImpl implements UserStateService {
    @Autowired
    private UserStateRepository userStateRepository;
    @Autowired
    private UserAuthProvider userAuthProvider;
    private final BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Result loginUser (UserLoginDTO userLoginDTO) {
        Optional<String> selectedEncryptedPasswordByAccount = userStateRepository
                .selectEncryptedPasswordByAccount(userLoginDTO.getAccount());
        if (selectedEncryptedPasswordByAccount.isEmpty()) {
            return ResultUtil.error(LoginResultEnum.UNKNOWN_ACCOUNT);
        }
        // 验证输入密码和加密密码是否匹配
        if (!bcryptPasswordEncoder.matches(userLoginDTO.getPassword(), selectedEncryptedPasswordByAccount.get())) {
            return ResultUtil.error(LoginResultEnum.UNMATCHED_PASSWORD);
        }
        return ResultUtil.success(LoginResultEnum.SUCCESS, userAuthProvider.createToken(userLoginDTO.getAccount()));
    }

    @Override
    public Result registerUser(UserRegisterDTO userRegisterDTO){
        int accountCount = userStateRepository.getAccountCount(userRegisterDTO.getAccount());
        if (accountCount != 0) {
            return ResultUtil.error(RegisterResultEnum.EXISTED_ACCOUNT);
        }
        userStateRepository.registerUser(userRegisterDTO);
        return ResultUtil.success(RegisterResultEnum.SUCCESS);
    }

    @Override
    public Result getUserProfile() {
        try {
            UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return ResultUtil.success(ProfileResultEnum.SUCCESS, userEntity);
        } catch (Exception e) {
            return ResultUtil.error(ProfileResultEnum.TOKEN_UNVERIFIED);
        }
    }
}

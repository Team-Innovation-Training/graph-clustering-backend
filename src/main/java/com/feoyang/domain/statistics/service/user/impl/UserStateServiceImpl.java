package com.feoyang.domain.statistics.service.user.impl;

import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.domain.statistics.entity.UserLoginEntity;
import com.feoyang.domain.statistics.converter.UserLoginConverter;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;
import com.feoyang.infrastructure.statistics.persistence.repository.user.UserStateRepository;
import com.feoyang.domain.statistics.service.user.UserStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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
    private UserLoginConverter userLoginConverter;
    private BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserLoginEntity loginUser(UserLoginDTO userLoginDTO) {
        UserPO userPO = userStateRepository.selectUserByAccount(userLoginDTO.getAccount());
        // 如果没查到用户，返回null
        if (userPO == null) {
            return null;
        }
        // 验证输入密码和加密密码是否匹配
        String loginPassword = userLoginDTO.getPassword();
        String encryptedPassword = userPO.getEncryptedPassword();
        if (!bcryptPasswordEncoder.matches(loginPassword, encryptedPassword)) {
            return new UserLoginEntity();
        }
        // 如果密码正确
        UserLoginEntity userLoginEntity = userLoginConverter.convertToUserLoginEntity(userPO);
        // 生成token
        // String token = TokenUtil.generateToken(userLoginEntity.getUsername());
        userLoginEntity.setToken("token");
        return  userLoginEntity;
    }

    @Override
    public Boolean registerUser(UserRegisterDTO userRegisterDTO) {
        Boolean accountExisted = userStateRepository.isAccountExisted(userRegisterDTO.getAccount());
        if (accountExisted) {
            return false;
        }
        userStateRepository.registerUser(userRegisterDTO);
        return true;
    }
}

package com.feoyang.infrastructure.statistics.persistence.repository.user.impl;

import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.infrastructure.statistics.persistence.mapper.user.UserStateMapper;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;
import com.feoyang.infrastructure.statistics.persistence.repository.user.UserStateRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author: feoyang
 * @date: 2024/1/10 3:32
 * @description: TODO
 */
@Repository
public class UserStateRepositoryImpl implements UserStateRepository {
    @Autowired
    private UserStateMapper userStateMapper;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserPO selectUserByAccount(String account) {
        return userStateMapper.selectUserByAccount(account);
    }

    @Override
    public void registerUser(UserRegisterDTO userRegisterDTO) {
        UserPO userPO = new UserPO();
        String account = userRegisterDTO.getAccount();
        String encodedPassword = passwordEncoder.encode(userRegisterDTO.getPassword());
        String nickname = "Genius";
        String avatar = "https://img.zcool.cn/community/01f4865b2625d3a8012034f70e2a54.jpg@1280w_1l_2o_100sh.jpg";
        userPO.setAccount(account);
        userPO.setEncryptedPassword(encodedPassword);
        userPO.setNickname(nickname);
        userPO.setAvatar(avatar);
        userStateMapper.registerUser(userPO);
    }

    @Override
    public Boolean isAccountExisted(String account) {
        if (userStateMapper.isAccountExisted(account) == 0) {
            return false;
        } else {
            return true;
        }
    }
}

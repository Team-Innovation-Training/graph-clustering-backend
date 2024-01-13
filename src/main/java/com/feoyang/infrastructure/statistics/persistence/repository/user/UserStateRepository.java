package com.feoyang.infrastructure.statistics.persistence.repository.user;

import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.domain.statistics.entity.UserEntity;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author: feoyang
 * @date: 2024/1/10 2:37
 * @description: TODO
 */
public interface UserStateRepository {
    UserPO selectUserByAccount(String username);
    void registerUser(UserRegisterDTO userRegisterDTO);
    int getAccountCount(String account);
    Optional<String> selectEncryptedPasswordByAccount(String account);
    UserPO getUserProfileByAccount(String account);
}

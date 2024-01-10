package com.feoyang.infrastructure.statistics.persistence.repository.user;

import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;

/**
 * @author: feoyang
 * @date: 2024/1/10 2:37
 * @description: TODO
 */
public interface UserStateRepository {
    UserPO selectUserByAccount(String username);
    void registerUser(UserRegisterDTO userRegisterDTO);
    Boolean isAccountExisted(String account);
}

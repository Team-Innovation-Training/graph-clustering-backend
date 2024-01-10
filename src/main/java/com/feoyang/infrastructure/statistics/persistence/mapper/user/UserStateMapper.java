package com.feoyang.infrastructure.statistics.persistence.mapper.user;

import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: feoyang
 * @date: 2024/1/10 1:53
 * @description: TODO
 */
@Mapper
public interface UserStateMapper {
    UserPO selectUserByAccount(String account);
    int isAccountExisted(String account);
    void registerUser(UserPO userPO);
}

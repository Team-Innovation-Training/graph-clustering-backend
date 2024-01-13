package com.feoyang.infrastructure.statistics.persistence.mapper.user;

import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author: feoyang
 * @date: 2024/1/10 1:53
 * @description: TODO
 */
@Mapper
public interface UserStateMapper {
    UserPO selectUserByAccount(String account);
    int getAccountCount(String account);
    void registerUser(UserPO userPO);
    Optional<String> selectEncryptedPasswordByAccount(String account);

    UserPO getUserProfileByAccount(String account);
}

package com.feoyang.domain.statistics.converter;

import com.feoyang.domain.statistics.entity.UserEntity;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:55s
 * @description: TODO
 */
public class UserEntityConverter{

    public static UserEntity convertToUserEntity(UserPO userPO) {
        return new UserEntity(
                userPO.getAccount(),
                userPO.getNickname(),
                userPO.getAvatar(),
                userPO.getCreateTime());
    }
}

package com.feoyang.domain.statistics.converter;

import com.feoyang.domain.statistics.entity.UserLoginEntity;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:52
 * @description: TODO
 */
public interface UserLoginConverter {
    UserLoginEntity convertToUserLoginEntity(UserPO userPO);
}

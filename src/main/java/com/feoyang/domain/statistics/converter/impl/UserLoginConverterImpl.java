package com.feoyang.domain.statistics.converter.impl;

import com.feoyang.domain.statistics.converter.UserLoginConverter;
import com.feoyang.domain.statistics.entity.UserLoginEntity;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;
import org.springframework.stereotype.Component;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:55
 * @description: TODO
 */
@Component
public class UserLoginConverterImpl implements UserLoginConverter {
    @Override
    public UserLoginEntity convertToUserLoginEntity(UserPO userPO) {
        return new UserLoginEntity(userPO.getAccount(), userPO.getNickname(), userPO.getAvatar(), userPO.getCreateTime());
    }
}

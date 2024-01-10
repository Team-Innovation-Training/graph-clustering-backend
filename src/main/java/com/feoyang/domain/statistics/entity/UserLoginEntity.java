package com.feoyang.domain.statistics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:33
 * @description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginEntity {
    private String account;
    private String nickname;
    private String avatar;
    private String createTime;
    private String token;

    public UserLoginEntity(String account, String nickname, String avatar, String createTime) {
        this.account = account;
        this.nickname = nickname;
        this.avatar = avatar;
        this.createTime = createTime;
    }
}

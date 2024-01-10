package com.feoyang.infrastructure.statistics.persistence.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:07
 * @description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPO {
    private int id;
    private String account;
    private String encryptedPassword;
    private String nickname;
    private String avatar;
    private String createTime;
    private String updateTime;
}

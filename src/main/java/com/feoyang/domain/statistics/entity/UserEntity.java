package com.feoyang.domain.statistics.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:33
 * @description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private String account;
    private String nickname;
    private String avatar;
    private String createTime;
}

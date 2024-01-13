package com.feoyang.application.statistics.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: feoyang
 * @date: 2024/1/10 4:23
 * @description: TODO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginDTO {
    private String account;
    private String password;
}

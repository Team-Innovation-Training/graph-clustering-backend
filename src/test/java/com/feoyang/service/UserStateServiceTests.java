package com.feoyang.service;

import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.domain.statistics.entity.UserEntity;
import com.feoyang.domain.statistics.service.user.UserStateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: feoyang
 * @date: 2024/1/10 5:40
 * @description: TODO
 */
@SpringBootTest
public class UserStateServiceTests {
    @Autowired
    private UserStateService userStateService;

    @Test
    public void testLogin() {
        System.out.println("-------------------------------- start");
        userStateService.loginUser(new UserLoginDTO("feoyang", "feoyang", true));
        System.out.println("-------------------------------- end");
    }

}

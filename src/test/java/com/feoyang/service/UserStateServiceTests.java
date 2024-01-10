package com.feoyang.service;

import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.domain.statistics.entity.UserLoginEntity;
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
    public void testUserStateService() {
        UserLoginDTO userLoginDTO = new UserLoginDTO("feoyang", "feoyang");
        UserLoginEntity userLoginEntity = userStateService.loginUser(userLoginDTO);
        System.out.println(userLoginEntity.toString());
    }

}

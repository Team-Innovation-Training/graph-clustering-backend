package com.feoyang.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.feoyang.application.statistics.api.rest.controller.user.UserStateController;
import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * @author: feoyang
 * @date: 2024/1/13 4:58
 * @description: TODO
 */
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTests {
    @Autowired
    private UserStateController userStateController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void testCorsWithOrigin() throws Exception {
        UserLoginDTO loginDto = new UserLoginDTO("feoyang", "feoyang", true);
        String json = objectMapper.writeValueAsString(loginDto);
        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                        .header("Origin", "http://localhost:5173")
                        .contentType("application/json")
                        .content(json)); //添加请求体
    }

}

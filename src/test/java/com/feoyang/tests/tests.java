package com.feoyang.tests;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.feoyang.domain.statistics.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collections;
import java.util.Date;

/**
 * @author: feoyang
 * @date: 2024/1/13 2:02
 * @description: TODO
 */
@SpringBootTest
public class tests {
    @Test
    public void testLogin() {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3_600_000 * 24);
        System.out.println(validity);
    }
}

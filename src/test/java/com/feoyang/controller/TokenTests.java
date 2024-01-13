package com.feoyang.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureGenerationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
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
 * @date: 2024/1/13 15:04
 * @description: TODO
 */
@SpringBootTest
public class TokenTests {
    @Value("${security.jwt.token.secret-key:secret-value}")
    private String secretKey;

    @Test
    public void testToken() {
        try {
            Date now = new Date();
            Date validity = new Date(now.getTime() + 3_600_000 * 24);

            String token =  JWT.create()
                    .withIssuer("feoyang")
                    .withIssuedAt(now)
                    .withExpiresAt(validity)
                    .sign(Algorithm.HMAC256(secretKey)) + "1";

            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
            DecodedJWT decoded = verifier.verify(token);
            System.out.println("decoded.getIssuer(): " + decoded.getIssuer());

            UserEntity user =new UserEntity("111","111","111","111");
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            System.out.println("usernamePasswordAuthenticationToken: " + usernamePasswordAuthenticationToken);
            System.out.println("UserEntity: " + usernamePasswordAuthenticationToken.getPrincipal());

            SecurityContextHolder.getContext().setAuthentication(
                    usernamePasswordAuthenticationToken
            );
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("Authentication_UserEntity: " + authentication.getPrincipal());
        } catch (SignatureVerificationException e) {
            System.out.println("e: " + e);
        }

    }
}

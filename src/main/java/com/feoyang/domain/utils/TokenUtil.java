package com.feoyang.domain.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author: feoyang
 * @date: 2024/1/10 18:37
 * @description: TODO
 */
public class TokenUtil {
    public static String generateToken(String username) {
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + 28800000; // 8 hours in milliseconds
        Date exp = new Date(expMillis);

        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(nowMillis))
                .expiration(exp)
                .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // 使用一个安全的密钥
                .compact();
    }
}

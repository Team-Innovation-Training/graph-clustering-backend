package com.feoyang.security;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: feoyang
 * @date: 2024/1/10 3:20
 * @description: TODO
 */
@SpringBootTest
public class EncryptedPasswordTests {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    public void testEncryptedPassword() {
        System.out.println("-------------------- start");
        String password = "feoyang";

        String encode1 = passwordEncoder.encode(password);
        System.out.println("encod1 = " + encode1);
        String encode2 = passwordEncoder.encode(password);
        System.out.println("encod2 = " + encode2);

        boolean matches1 = passwordEncoder.matches(password, encode1);
        boolean matches2 = passwordEncoder.matches(password, encode2);
        System.out.println("matches1 = " + matches1);
        System.out.println("matches2 = " + matches2);

        boolean matches = passwordEncoder.matches(password, "$2a$10$GaApoBu/tluAZbCT2JkE4uRpCDpBE9MC5S3AZe8vUODHIfe1WOVfW");
        System.out.println("matches = " + matches);
        System.out.println("-------------------- end");
    }
}

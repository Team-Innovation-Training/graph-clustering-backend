package com.feoyang.application.statistics.security;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.feoyang.domain.statistics.converter.UserEntityConverter;
import com.feoyang.domain.statistics.entity.UserEntity;
import com.feoyang.infrastructure.statistics.persistence.po.UserPO;
import com.feoyang.infrastructure.statistics.persistence.repository.user.UserStateRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;


/**
 * @author: feoyang
 * @date: 2024/1/12 13:23
 * @description: TODO
 */
@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    @Value("${security.jwt.token.secret-key:secret-value}")
    private String secretKey;

    @Autowired
    private UserStateRepository userStateRepository;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String account) {
        Date now = new Date();
        // 设置一个很远的未来日期作为过期时间
        // 例如，100年后
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.YEAR, 100); // 加上100年
        Date validity = calendar.getTime();

        return JWT.create()
                .withIssuer(account)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey)).build();
        DecodedJWT decoded = verifier.verify(token);
        UserPO userPO = userStateRepository.getUserProfileByAccount(decoded.getIssuer());
        UserEntity userEntity = UserEntityConverter.convertToUserEntity(userPO);
        return new UsernamePasswordAuthenticationToken(userEntity, null, Collections.emptyList());
    }
}

package com.feoyang.application.statistics.api.rest.controller.user;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.feoyang.application.statistics.api.rest.model.Result;
import com.feoyang.application.statistics.api.rest.model.enums.ProfileResultEnum;
import com.feoyang.application.statistics.api.rest.model.enums.RegisterResultEnum;
import com.feoyang.application.statistics.dto.user.UserLoginDTO;
import com.feoyang.application.statistics.dto.user.UserRegisterDTO;
import com.feoyang.domain.statistics.entity.UserEntity;
import com.feoyang.domain.statistics.service.user.UserStateService;
import com.feoyang.domain.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * @author: feoyang
 * @date: 2024/1/10 1:37
 * @description: TODO
 */
@RestController
@RequestMapping("")
public class UserStateController {
    @Autowired
    private UserStateService userStateService;


    @PostMapping("/login")
    public ResponseEntity<Result> login(@RequestBody UserLoginDTO userLoginDTO) {
        Result result = userStateService.loginUser(userLoginDTO);
        if (result.getCode() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Result> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        Result result = userStateService.registerUser(userRegisterDTO);
        if (result.getCode() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<Result> profile() {
        Result result = userStateService.getUserProfile();
        if (result.getCode() > 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        } else {
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<?> register() {
        return ResponseEntity.ok("this is a test!");
    }

}

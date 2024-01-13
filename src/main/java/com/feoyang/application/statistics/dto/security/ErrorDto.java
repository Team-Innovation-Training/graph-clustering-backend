package com.feoyang.application.statistics.dto.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author: feoyang
 * @date: 2024/1/12 13:14
 * @description: TODO
 */
@Data
@AllArgsConstructor
@Builder
public class ErrorDto {
    private String message;
}

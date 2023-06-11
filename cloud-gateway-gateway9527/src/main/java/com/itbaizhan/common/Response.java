package com.itbaizhan.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private Integer code;
    private String message;
}

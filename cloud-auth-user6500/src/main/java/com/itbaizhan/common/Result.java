package com.itbaizhan.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Result {

    // 返回状态码
    private int code;

    // 返回描述信息
    private String msg;

    // 返回token信息 令牌
    private String token;


}

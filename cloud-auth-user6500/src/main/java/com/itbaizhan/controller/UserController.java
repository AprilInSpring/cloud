package com.itbaizhan.controller;

import com.itbaizhan.common.Result;
import com.itbaizhan.utils.JWTUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 */
@RestController
@RequestMapping("user")
public class UserController {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     */
    @PostMapping("login")
    public Result login(String username, String password){
        // 1. 验证用户名和密码
        // TODO 模拟数据库操作
        if("admin".equals(username) && "123456".equals(password)){
            // 2. 生成令牌
            String token = JWTUtils.token();
            return  Result.builder()
                    .code(200)
                    .msg("succes")
                    .token(token).build();
        }else {
            return  Result.builder()
                    .code(500)
                    .msg("用户名或密码不正确")
                  .build();
        }

    }

}

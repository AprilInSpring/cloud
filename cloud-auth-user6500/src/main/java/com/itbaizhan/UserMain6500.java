package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class UserMain6500 {
    public static void main(String[] args) {
        SpringApplication.run(UserMain6500.class,args);
        log.info("************** UserMain6500 启动成功 **********");
    }
}

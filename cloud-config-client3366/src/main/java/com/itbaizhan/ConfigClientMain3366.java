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
public class ConfigClientMain3366 {
    public static void main(String[] args) {

        SpringApplication.run(ConfigClientMain3366.class,args);
        log.info("*********** ConfigClientMain3366 服务启动成功 *********");
    }
}

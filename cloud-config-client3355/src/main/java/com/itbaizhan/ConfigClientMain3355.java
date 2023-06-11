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
public class ConfigClientMain3355 {
    public static void main(String[] args) {

        SpringApplication.run(ConfigClientMain3355.class,args);
        log.info("*********** ConfigClientMain3355 服务启动成功 *********");
    }
}

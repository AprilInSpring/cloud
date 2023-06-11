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
public class ConsumerMain8003 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8003.class,args);
        log.info("********** ConsumerMain8003 启动成功 *******");
    }
}

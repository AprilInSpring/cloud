package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 */
// 开启把自己注册到eurea server上
@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
        log.info("***********PaymentMain8002 服务启动成功 ******* ");
    }
}

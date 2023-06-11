package com.itbaizhan;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 主启动类
 */
// 开启把自己注册到eurea server上
@EnableEurekaClient
@MapperScan("com.itbaizhan.mapper")
@SpringBootApplication
@Slf4j
public class SkywalkingPaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(SkywalkingPaymentMain8001.class,args);
        log.info("***********PaymentMain8001 服务启动成功 ******* ");
    }


}

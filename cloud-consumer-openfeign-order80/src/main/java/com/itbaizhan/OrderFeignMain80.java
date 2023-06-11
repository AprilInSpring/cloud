package com.itbaizhan;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 主启动类
 */
// 开启服务调用
@EnableFeignClients
@SpringBootApplication
@Slf4j
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class,args);
        log.info("********** OrderMain80  openFegin 启动成功 ********");

    }
}

package com.itbaizhan;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 */
@SpringBootApplication
@Slf4j
public class Alarm9090 {
    public static void main(String[] args) {
        SpringApplication.run(Alarm9090.class,args);
        log.info("************** 网络钩子服务启动成功 *************");
    }
}

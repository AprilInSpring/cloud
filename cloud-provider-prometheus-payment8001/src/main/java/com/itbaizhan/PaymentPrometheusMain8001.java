package com.itbaizhan;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * 主启动类
 */
// 开启把自己注册到eurea server上
@EnableEurekaClient
@SpringBootApplication
@Slf4j
public class PaymentPrometheusMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentPrometheusMain8001.class,args);
        log.info("***********PaymentMain8001 服务启动成功 ******* ");
    }


    @Bean
    MeterRegistryCustomizer<MeterRegistry> configurer(@Value("${spring.application.name}") String applicationName) {
        return registry -> registry.config().commonTags("application", applicationName);
    }


}

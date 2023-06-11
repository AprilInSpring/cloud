package com.itbaizhan.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

/**
 * 通过java api 方法构建路由规则
 * @return
 */
@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){

        // 获取路由
        RouteLocatorBuilder.Builder routes = builder.routes();
        // 设置路由
        // 第一个字符串 路由id
        // 第二个字符串 路径匹配规则
        // 第三个字符串  目标地址
        routes.route("path_rote",r -> r.path("/guonei").
                uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }

}

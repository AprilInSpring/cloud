package com.itbaizhan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 支付远程调用openfeign接口
 */
// 声明为openfeign客户端 调用服务生产者名
@FeignClient("CLOUD-PAYMENT-PROVIDER")
public interface PaymentFeignService {

    @GetMapping("/payment/index")
    String index();

    @GetMapping("/payment/timeout")
    String timeout();
}

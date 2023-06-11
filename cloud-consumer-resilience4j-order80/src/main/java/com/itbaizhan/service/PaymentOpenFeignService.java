package com.itbaizhan.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("CLOUD-PAYMENT-PROVIDER")
public interface PaymentOpenFeignService {


    @GetMapping("/payment/timeout")
    String timeout();

    @GetMapping("/payment/index")
    String index();

}

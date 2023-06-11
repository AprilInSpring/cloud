package com.itbaizhan.controller;

import com.itbaizhan.service.PaymentOpenFeignService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * 订单控制层
 */
@Slf4j
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private PaymentOpenFeignService paymentOpenFeignService;

    /**
     * 测试 超时降级
     * @return
     */
    @GetMapping("timeout")
    @TimeLimiter(name = "delay",fallbackMethod = "timeoutfallback")
    public CompletableFuture<String> timeout(){

        log.info("*********  进入方法 ******");
        // 异步操作
        CompletableFuture<String> stringCompletableFuture = CompletableFuture
                .supplyAsync(new Supplier<String>() {
                    @Override
                    public String get() {
                        return paymentOpenFeignService.timeout();
                    }
                });
        log.info("*********  进入方法 ******");

        return stringCompletableFuture;
    }


    /**
     * 超时降级方法
     * @param e
     * @return
     */
    public CompletableFuture<String> timeoutfallback(Exception e){
        e.printStackTrace();
        return CompletableFuture.completedFuture("超时啦");
    }


    /**
     * 重试机制
     * @return
     */
    @GetMapping("retry")
    @Retry(name = "backendA")
    public CompletableFuture<String> retry(){
        log.info("********** 进入方式 ********");
        // 异步操作
        CompletableFuture<String> stringCompletableFuture
                = CompletableFuture.supplyAsync((Supplier<String>) () -> paymentOpenFeignService.index());
        log.info("********** 离开方式 ********");
        return stringCompletableFuture;

    }

    /**
     * 测试异常比例熔断机制
     * @return
     */
    @GetMapping("circuitbreaker")
    @CircuitBreaker(name = "backendA",fallbackMethod = "circuitbreakerfallback")
    public String circuitbreaker(){
        log.info("********** 进入方式 ********");
        String index = paymentOpenFeignService.index();
        log.info("********** 离开方式 ********");
        return index;
    }

    /**
     * 异常比例熔断降级
     * @param e
     * @return
     */
    public String circuitbreakerfallback(Exception e){
        e.printStackTrace();
        return "客观服务繁忙 稍等一会";
    }


    /**
     * 慢调用熔断降级
     * @return
     */
    @GetMapping("slowcircuitbreaker")
    @CircuitBreaker(name = "backendB",fallbackMethod = "slowcircuitbreakerfallback")
    public String slowcircuitbreaker(){
        log.info("********** 进入方式 ********");
        String index = paymentOpenFeignService.index();
        log.info("********** 离开方式 ********");
        return index;
    }

    /**
     * 慢调用熔断降级
     * @return
     */
    public String slowcircuitbreakerfallback(Exception e){
        e.printStackTrace();
        return "太慢了。 。。。。";
    }


    /**
     * 信号量隔离
     * Bulkhead.Type.SEMAPHORE 信号量
     * @return
     */
    @GetMapping("bulkhead")
    @Bulkhead(name = "backendA",type = Bulkhead.Type.SEMAPHORE)
    public String bulkhead() throws InterruptedException {
        log.info("************ 进入方法**********");
        TimeUnit.SECONDS.sleep(10);
        String index = paymentOpenFeignService.index();
        log.info("************ 离开方法**********");
        return index;
    }


    /**
     * 测试线程池服务隔离
     * Bulkhead.Type.THREADPOOL 线程池
     * @return
     */
    @Bulkhead(name = "backendA",type = Bulkhead.Type.THREADPOOL)
    @GetMapping("thread")
    public  CompletableFuture future () throws InterruptedException {

        log.info("************ 进入方法**********");
        TimeUnit.SECONDS.sleep(10);
        log.info("************ 离开方法**********");
        return CompletableFuture.supplyAsync(()->"线程池隔离......");
    }


    /**
     * 测试限流
     * @return
     */
    @RateLimiter(name = "backendA")
    @GetMapping("limiter")
    public CompletableFuture limiter() throws InterruptedException {
        log.info("************ 进入方法**********");
        TimeUnit.SECONDS.sleep(5);
        log.info("************ 离开方法**********");
        return CompletableFuture.supplyAsync(()->"限流");
    }




}

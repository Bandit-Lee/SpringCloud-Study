package com.bandit.springCloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Bandit
 * @createTime 2022/4/21 23:15
 */
@Service
@Slf4j
public class PaymentService {

    public String paymentNormal() {
        return "正常-ThreadId:" + Thread.currentThread().getName();
    }

    //服务提供方超时3s就熔断，并降级到另一个方法
    @HystrixCommand(fallbackMethod = "timeoutHandler", commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentTimeout() {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            log.info("被打断了[{}]",e.getCause().toString());
        }
        return "超时-ThreadId:" + Thread.currentThread().getName() + "超时时间:6s";
    }

    //这个feign会发现超时
    public String paymentTimeout2() {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            log.info("被打断了[{}]",e.getCause().toString());
        }
        return "超时-ThreadId:" + Thread.currentThread().getName() + "超时时间:20s";
    }

    public String timeoutHandler() {
        log.info("服务提供方超时3s选择降级");
        return "超时了，暂时不可访问" + Thread.currentThread().getName();
    }

    @HystrixCommand(fallbackMethod = "circuitBreakerFallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String circuitBreaker(Integer id) {
        if (id < 0) {
            throw new RuntimeException("id can not be negative");
        }
        String random = UUID.randomUUID().toString().substring(0, 6);
        return Thread.currentThread().getName() + random + "收到id:" + id;
    }

    public String circuitBreakerFallback(Integer id) {
        return "调用断路器的Fallback:" + id;
    }
}

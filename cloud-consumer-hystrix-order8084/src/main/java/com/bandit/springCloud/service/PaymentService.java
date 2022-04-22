package com.bandit.springCloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Bandit
 * @createTime 2022/4/22 10:37
 */
@Service
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-HYSTRIX", fallback = PaymentServiceFallback.class)
public interface PaymentService {

    @GetMapping("/payment/normal")
    String normal();

    @GetMapping("/payment/timeout")
    String timeout();

    @GetMapping("/payment/timeout2")
    String timeout2();

    @GetMapping("/payment/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id);
}

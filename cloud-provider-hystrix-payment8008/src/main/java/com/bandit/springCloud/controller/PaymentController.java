package com.bandit.springCloud.controller;

import com.bandit.springCloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bandit
 * @createTime 2022/4/21 23:21
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/normal")
    public String normal() {
        return paymentService.paymentNormal();
    }

    @GetMapping("/payment/timeout")
    public String timeout() {
        return paymentService.paymentTimeout();
    }

    @GetMapping("/payment/timeout2")
    public String timeout2() {
        return paymentService.paymentTimeout2();
    }

    @GetMapping("/payment/circuitBreaker/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.circuitBreaker(id);
    }

}

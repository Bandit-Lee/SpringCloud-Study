package com.bandit.springCloud.controller;

import com.bandit.springCloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Bandit
 * @createTime 2022/4/21 23:21
 */
@Controller
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

}

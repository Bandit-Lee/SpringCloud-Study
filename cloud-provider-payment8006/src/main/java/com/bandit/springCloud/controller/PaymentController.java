package com.bandit.springCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Bandit
 * @createTime 2022/4/13 14:21
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/info")
    public String paymentConsul() {
        return "springCloud consul:" + serverPort + UUID.randomUUID().toString().substring(0, 6);
    }
}

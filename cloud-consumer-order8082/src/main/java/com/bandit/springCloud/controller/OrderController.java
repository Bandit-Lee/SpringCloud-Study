package com.bandit.springCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bandit
 * @createTime 2022/4/13 14:29
 */
@RestController
@Slf4j
public class OrderController {

    private static final String SERVICE_URL = "http://cloud-provider-payment-8006-test";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/info")
    public String paymentInfo() {
        log.info("consumer...");
        return restTemplate.getForObject(SERVICE_URL + "/payment/info", String.class);
    }

}

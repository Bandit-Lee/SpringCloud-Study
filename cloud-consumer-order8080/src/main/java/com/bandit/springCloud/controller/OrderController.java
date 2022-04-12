package com.bandit.springCloud.controller;

import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.entities.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bandit
 * @createTime 2022/4/12 11:59
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {

    private static final String PAYMENT_URL = "http://localhost:8001";

    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/payment/insert")
    public ResponseResult<Payment> insertPayment(@RequestBody Payment payment) {
        log.info("插入Payment:[{}]", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, ResponseResult.class);
    }

    @PostMapping("/payment/select")
    public ResponseResult<Payment> selectPaymentById(@RequestBody Payment payment) {
        log.info("查询条件:[{}]", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/select", payment, ResponseResult.class);
    }
}

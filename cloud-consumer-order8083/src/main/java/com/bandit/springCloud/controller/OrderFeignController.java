package com.bandit.springCloud.controller;

import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.entities.ResponseResult;
import com.bandit.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Bandit
 * @createTime 2022/4/20 17:37
 */
@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/select")
    public ResponseResult<Payment> selectPayment(@RequestBody Payment payment) {
        return paymentService.selectPayment(payment);
    }

    @PostMapping("/payment/insert")
    public ResponseResult insertPayment(@RequestBody Payment payment) {
        return paymentService.insertPayment(payment);
    }

    @GetMapping("/timeout")
    public ResponseResult timeoutTest() {
        return paymentService.paymentTimeout();
    }
}

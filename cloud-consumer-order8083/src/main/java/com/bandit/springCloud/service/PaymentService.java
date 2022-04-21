package com.bandit.springCloud.service;

import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.entities.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * @author Bandit
 * @createTime 2022/4/20 17:33
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentService {

    @PostMapping("/payment/insert")
    ResponseResult insertPayment(@RequestBody Payment payment);

    @PostMapping("/payment/select")
    ResponseResult selectPayment(@RequestBody Payment payment);

    @GetMapping("/payment/feign/timeout")
    ResponseResult paymentTimeout();
}

package com.bandit.springCloud.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Bandit
 * @createTime 2022/4/22 14:44
 */
@Component
@Slf4j
public class PaymentServiceFallback implements PaymentService{

    @Override
    public String normal() {
        String info = "PaymentServiceFallback类统一处理:[normal]";
        log.info(info);
        return info;
    }

    @Override
    public String timeout() {
        String info = "PaymentServiceFallback类统一处理:[timeout]";
        log.info(info);
        return info;
    }

    @Override
    public String timeout2() {
        String info = "PaymentServiceFallback类统一处理:[timeout2]";
        log.info(info);
        return info;
    }

    @Override
    public String circuitBreaker(Integer id) {
        String info = "PaymentServiceFallback类统一处理:[circuitBreaker]";
        log.info(info);
        return info;
    }
}

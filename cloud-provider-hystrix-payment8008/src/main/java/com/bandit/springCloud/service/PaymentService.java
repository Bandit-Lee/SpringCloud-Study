package com.bandit.springCloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Bandit
 * @createTime 2022/4/21 23:15
 */
@Service
public class PaymentService {

    public String paymentNormal() {
        return "正常-ThreadId:" + Thread.currentThread().getName();
    }

    public String paymentTimeout() {
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "超时-ThreadId:" + Thread.currentThread().getName() + "超时时间:6s";
    }
}

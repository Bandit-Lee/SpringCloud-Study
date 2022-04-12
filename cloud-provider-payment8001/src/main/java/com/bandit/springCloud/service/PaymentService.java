package com.bandit.springCloud.service;

import com.bandit.springCloud.entities.Payment;
import java.util.List;

/**
 * @author Bandit
 * @createTime 2022/4/12 10:05
 */
public interface PaymentService {
    int insertPayment(Payment payment);

    List<Payment> selectPaymentList(Payment payment);
}

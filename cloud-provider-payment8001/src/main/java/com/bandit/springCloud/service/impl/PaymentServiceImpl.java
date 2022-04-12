package com.bandit.springCloud.service.impl;

import com.bandit.springCloud.dao.PaymentDao;
import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Bandit
 * @createTime 2022/4/12 10:05
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentDao paymentDao;

    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.insertPayment(payment);
    }

    @Override
    public List<Payment> selectPaymentList(Payment payment) {
        return paymentDao.selectPaymentList(payment);
    }


}

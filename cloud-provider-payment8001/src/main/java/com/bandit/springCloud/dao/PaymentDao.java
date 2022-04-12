package com.bandit.springCloud.dao;

import com.bandit.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Bandit
 * @createTime 2022/4/12 9:22
 */
@Mapper
public interface PaymentDao {
    int insertPayment(Payment payment);

    Payment selectPaymentById(Payment payment);

    List<Payment> selectPaymentList(Payment payment);
}

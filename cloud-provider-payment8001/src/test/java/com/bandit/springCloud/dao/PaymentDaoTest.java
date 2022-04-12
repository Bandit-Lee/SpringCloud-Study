package com.bandit.springCloud.dao;

import com.bandit.springCloud.entities.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Bandit
 * @createTime 2022/4/12 9:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentDaoTest {

    @Autowired
    PaymentDao paymentDao;

    @Test
    public void test() {
        Payment payment = new Payment(1, "hello");
        List<Payment> payments = paymentDao.selectPaymentList(payment);
        payments.forEach(System.out::println);
    }
}

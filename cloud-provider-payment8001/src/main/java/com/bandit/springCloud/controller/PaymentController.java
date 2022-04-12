package com.bandit.springCloud.controller;

import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.entities.ResponseResult;
import com.bandit.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

/**
 * @author Bandit
 * @createTime 2022/4/12 10:42
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/insert")
    public ResponseResult insertPayment(@RequestBody Payment payment) {
        log.info("插入Payment:[{}]",payment);
        int insertCount = paymentService.insertPayment(payment);
        if (insertCount > 0) {
            log.info("插入成功");
            return new ResponseResult(200, "插入成功");
        } else {
            log.warn("插入失败");
            return new ResponseResult(500, "插入失败");
        }
    }

    @PostMapping("/select")
    public ResponseResult selectPayment(@RequestBody Payment payment) {
        log.info("查询Payment:[{}]", payment);
        List<Payment> paymentList = paymentService.selectPaymentList(payment);
        if (paymentList.isEmpty()) {
            log.warn("查询结果为空");
            return new ResponseResult(500, "查询结果为空");
        } else {
            log.info("查询成功");
            return new ResponseResult(200, "查询成功", paymentList);
        }
    }

}

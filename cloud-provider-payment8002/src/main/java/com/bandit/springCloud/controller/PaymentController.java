package com.bandit.springCloud.controller;

import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.entities.ResponseResult;
import com.bandit.springCloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/insert")
    public ResponseResult insertPayment(@RequestBody Payment payment) {
        log.info("服务:[{}]插入Payment:[{}]", serverPort, payment);
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
        log.info("服务:[{}]查询Payment:[{}]", serverPort, payment);
        List<Payment> paymentList = paymentService.selectPaymentList(payment);
        if (paymentList.isEmpty()) {
            log.warn("查询结果为空");
            return new ResponseResult(500, "查询结果为空");
        } else {
            log.info("查询成功");
            return new ResponseResult(200, "查询成功", paymentList);
        }
    }

    @GetMapping("/info")
    public ResponseResult getServiceInfo() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        services.forEach(log::info);
        serviceInstances.forEach(serviceInstance -> log.info(serviceInstance.toString()));

        return new ResponseResult(200, "success", services);
    }

    @GetMapping("/feign/timeout")
    public ResponseResult paymentTimeout() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseResult(200,"超时test完成");
    }
}

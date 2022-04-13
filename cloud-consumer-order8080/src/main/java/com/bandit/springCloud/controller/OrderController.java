package com.bandit.springCloud.controller;

import com.bandit.springCloud.entities.Payment;
import com.bandit.springCloud.entities.ResponseResult;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.EurekaClientConfig;
import com.netflix.discovery.shared.Applications;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @author Bandit
 * @createTime 2022/4/12 11:59
 */
@RestController
@RequestMapping("/consumer")
@Slf4j
public class OrderController {
    //Provider集群后就不能写死了，需要到eureka里找到服务名称，URL改为服务名称
    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/insert")
    public ResponseResult<Payment> insertPayment(@RequestBody Payment payment) {
        log.info("插入Payment:[{}]", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/insert", payment, ResponseResult.class);
    }

    @PostMapping("/payment/select")
    public ResponseResult<Payment> selectPaymentById(@RequestBody Payment payment) {
        log.info("查询条件:[{}]", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/select", payment, ResponseResult.class);
    }

    @GetMapping("/payment/info")
    public ResponseResult getServiceInfo() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        services.forEach(log::info);
        serviceInstances.forEach(serviceInstance -> log.info(serviceInstance.toString()));

        return new ResponseResult(200, "success", services);
    }
}

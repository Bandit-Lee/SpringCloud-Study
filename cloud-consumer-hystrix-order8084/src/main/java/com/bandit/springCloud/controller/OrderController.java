package com.bandit.springCloud.controller;

import com.bandit.springCloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Bandit
 * @createTime 2022/4/22 10:48
 */
@RestController
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "defaultHandler", commandProperties = {
   @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
})
public class OrderController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payment/normal")
    String normal() {
        return paymentService.normal();
    }

    //消费者超时1.5s就降级
    @HystrixCommand(fallbackMethod = "consumerHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    @GetMapping("/payment/timeout")
    String timeout() {
        return paymentService.timeout();
    }

    //这个会被feign发现超时,由于配置了一个PaymentServiceFallback类来统一处理timeout2，这里不用加其他的
    @GetMapping("/payment/timeout2")
    String timeout2() {
        return paymentService.timeout2();
    }

    //设置了默认的，此处只需要配置@HystrixCommand
    @HystrixCommand
    @GetMapping("/payment/timeout3")
    String timeout3() {
        return paymentService.timeout();
    }

    String consumerHandler() {
        return "我是消费者，提供方超时了，我选择降级";
    }

    String defaultHandler() {
        return "消费方默认Handler";
    }


    /*-------------- 服务熔断 ------------------*/
    @GetMapping("/payment/circuitBreaker/{id}")
    String circuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.circuitBreaker(id);
    }

}

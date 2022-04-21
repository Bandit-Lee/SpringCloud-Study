package com.bandit.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @author Bandit
 * @createTime 2022/4/21 23:10
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class HystrixPaymentApplication8008 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPaymentApplication8008.class, args);
    }
}

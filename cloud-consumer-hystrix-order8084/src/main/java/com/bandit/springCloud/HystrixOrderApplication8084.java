package com.bandit.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Bandit
 * @createTime 2022/4/22 10:37
 */
@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
public class HystrixOrderApplication8084 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixOrderApplication8084.class, args);
    }
}

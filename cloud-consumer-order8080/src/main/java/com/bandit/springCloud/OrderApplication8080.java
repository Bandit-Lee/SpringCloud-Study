package com.bandit.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Bandit
 * @createTime 2022/4/12 11:52
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class OrderApplication8080 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8080.class, args);
    }
}

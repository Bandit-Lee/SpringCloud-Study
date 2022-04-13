package com.bandit.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Bandit
 * @createTime 2022/4/13 12:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplicationZk8081 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationZk8081.class, args);
    }
}

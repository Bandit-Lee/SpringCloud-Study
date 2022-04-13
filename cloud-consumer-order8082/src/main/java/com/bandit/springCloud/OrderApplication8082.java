package com.bandit.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Bandit
 * @createTime 2022/4/13 14:28
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication8082 {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8082.class, args);
    }
}

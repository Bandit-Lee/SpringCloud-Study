package com.bandit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Bandit
 * @createTime 2022/4/26 15:45
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQProvider8801 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQProvider8801.class, args);
    }
}

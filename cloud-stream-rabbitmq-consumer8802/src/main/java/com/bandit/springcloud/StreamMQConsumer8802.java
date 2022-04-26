package com.bandit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Bandit
 * @createTime 2022/4/26 17:39
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQConsumer8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMQConsumer8802.class, args);
    }
}

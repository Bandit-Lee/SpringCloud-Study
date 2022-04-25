package com.bandit.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Bandit
 * @createTime 2022/4/25 18:38
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClient5577 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient5577.class, args);
    }
}

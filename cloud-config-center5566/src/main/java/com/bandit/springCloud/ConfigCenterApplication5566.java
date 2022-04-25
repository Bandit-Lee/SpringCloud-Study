package com.bandit.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Bandit
 * @createTime 2022/4/25 16:47
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterApplication5566 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterApplication5566.class, args);
    }
}

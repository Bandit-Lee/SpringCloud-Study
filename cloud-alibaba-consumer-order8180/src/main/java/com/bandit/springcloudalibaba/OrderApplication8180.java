package com.bandit.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Bandit
 * @createTime 2022/5/4 13:32
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication8180 {

    //Instantiate RestTemplate Instance
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication8180.class, args);
    }
}

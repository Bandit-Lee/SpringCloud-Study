package com.bandit.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author Bandit
 * @createTime 2022/4/23 11:30
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixManager9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixManager9001.class, args);
    }
}

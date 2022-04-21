package com.bandit.springCloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bandit
 * @createTime 2022/4/21 10:02
 */
@Configuration
public class FeignLoggerConfig {

    @Bean
    Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }
}

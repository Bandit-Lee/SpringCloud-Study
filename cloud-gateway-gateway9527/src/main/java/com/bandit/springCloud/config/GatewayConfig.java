package com.bandit.springCloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bandit
 * @createTime 2022/4/25 13:11
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("payment_route_02",route -> route.path("/guonei").uri("https://news.baidu.com/"))
            .route("payment_route_02",route -> route.path("/guoji").uri("https://news.baidu.com/"));
        return routes.build();
    }

}

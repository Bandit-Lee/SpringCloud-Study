package com.bandit.springCloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author Bandit
 * @createTime 2022/4/25 15:01
 */
@Component
@Slf4j
public class MyGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("=====进入全局过滤器:{}=====",new Date());
        String token = exchange.getRequest().getHeaders().getFirst("token");
        if (token == null) {
            log.info("token为空");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.info("token:{}",token);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

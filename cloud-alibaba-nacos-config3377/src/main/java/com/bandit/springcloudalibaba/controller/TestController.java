package com.bandit.springcloudalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bandit
 * @createTime 2022/5/4 17:04
 */
@RestController
@RefreshScope
public class TestController {

    @Value("${user.age}")
    String userAge;

    @Value("${user.name}")
    String userName;

    @GetMapping("/user")
    public String getUserInfo() {
        return "userName: " + userName + "\nuserAge: " + userAge;
    }

}

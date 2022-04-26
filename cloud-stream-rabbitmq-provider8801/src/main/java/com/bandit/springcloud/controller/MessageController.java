package com.bandit.springcloud.controller;

import com.bandit.springcloud.service.IMessageProvider;
import com.bandit.springcloud.service.impl.MessageProviderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bandit
 * @createTime 2022/4/26 16:19
 */
@RestController
public class MessageController {

    @Autowired
    private MessageProviderImpl messageProvider;

    @GetMapping("/send")
    public String sendMessage() {
        return messageProvider.send();
    }

}

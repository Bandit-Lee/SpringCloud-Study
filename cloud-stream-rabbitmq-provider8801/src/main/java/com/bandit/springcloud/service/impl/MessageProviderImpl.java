package com.bandit.springcloud.service.impl;

import com.bandit.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author Bandit
 * @createTime 2022/4/26 15:47
 */
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String substring = UUID.randomUUID().toString().substring(0, 6);
        output.send(MessageBuilder.withPayload(substring).build());
        return substring;
    }
}

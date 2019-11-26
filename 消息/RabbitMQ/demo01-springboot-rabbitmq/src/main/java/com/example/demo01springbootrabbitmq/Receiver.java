package com.example.demo01springbootrabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "hello-world")
    public void process(String hello) {
        log.info("消费者收到消息：{}", hello);
    }
}
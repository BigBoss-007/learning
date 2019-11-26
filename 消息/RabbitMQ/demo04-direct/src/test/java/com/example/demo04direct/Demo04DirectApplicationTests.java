package com.example.demo04direct;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo04DirectApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("direct-name","routing-name-1","往routing-name-1发送消息");
        rabbitTemplate.convertAndSend("direct-name","routing-name-2","往routing-name-2发送消息");
    }

}

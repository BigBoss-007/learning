package com.example.demo05topic;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo05TopicApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {
        rabbitTemplate.convertAndSend("topic-name","log.1","随便发送1");
        rabbitTemplate.convertAndSend("topic-name","log.2","随便发送2");
        rabbitTemplate.convertAndSend("topic-name","log.farg","随便发送3");
        rabbitTemplate.convertAndSend("topic-name","log.4","随便发送4");
    }

}

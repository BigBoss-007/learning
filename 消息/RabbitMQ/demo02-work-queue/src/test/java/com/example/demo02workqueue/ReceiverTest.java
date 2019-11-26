package com.example.demo02workqueue;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sherry
 * @Description
 * @Date Create in 2019/11/26
 * @Modified By:
 */
@SpringBootTest(classes = Demo02WorkQueueApplication.class)
class ReceiverTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void process() {

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                rabbitTemplate.convertAndSend("work-queue", "发送消息咯");
            }).start();
        }

    }
}
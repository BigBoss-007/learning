package com.example.demo01springbootrabbitmq;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author sherry
 * @Description
 * @Date Create in 2019/11/26
 * @Modified By:
 */
@SpringBootTest(classes = Demo01SpringbootRabbitmqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
class ReceiverTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void process() {
        rabbitTemplate.convertAndSend("hello-world","测试发送一笔消息给hello-world队列");
    }
}
package com.example.demo02workqueue;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "work-queue")
    public void process1(Message message, Channel channel) {
        try {
            byte[] body = message.getBody();
            String hello = new String(body, Charset.forName("utf8"));
            log.info("消费者1收到消息：{}", hello);
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                // 返回确认状态
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (Exception e) {
                log.error("RabbitMQ 网关日志ACK异常", e);
            }
        }
    }

    @RabbitHandler
    @RabbitListener(queues = "work-queue")
    public void process2(Message message, Channel channel) {
        try {
            byte[] body = message.getBody();
            String hello = new String(body, Charset.forName("utf8"));
            log.info("消费者2收到消息：{}", hello);
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                // 返回确认状态
                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
            } catch (Exception e) {
                log.error("RabbitMQ 网关日志ACK异常", e);
            }
        }
    }

}
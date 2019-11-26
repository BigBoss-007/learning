package com.example.demo04direct;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @Author sherry
 * @Description
 * @Date Create in 2019/11/26
 * @Modified By:
 */
@Slf4j
@Component
public class MqListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-name-1", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "direct-name", type = ExchangeTypes.DIRECT),
            key = "routing-name-1"
    ))
    public void listener1(Message message, Channel channel) {
        try {
            byte[] body = message.getBody();
            String hello = new String(body, Charset.forName("utf8"));
            log.info("消费者1收到消息：{}", hello);
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

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-name-1_2", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "direct-name", type = ExchangeTypes.DIRECT),
            key = "routing-name-1"
    ))
    public void listener1_2(Message message, Channel channel) {
        try {
            byte[] body = message.getBody();
            String hello = new String(body, Charset.forName("utf8"));
            log.info("消费者1_2收到消息：{}", hello);
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

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-name-2", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "direct-name", type = ExchangeTypes.DIRECT),
            key = "routing-name-2"
    ))
    public void listener2(Message message, Channel channel) {
        try {
            byte[] body = message.getBody();
            String hello = new String(body, Charset.forName("utf8"));
            log.info("消费者2收到消息：{}", hello);
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

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-name-2_2", durable = "false", autoDelete = "true"),
            exchange = @Exchange(value = "direct-name", type = ExchangeTypes.DIRECT),
            key = "routing-name-2"
    ))
    public void listener2_2(Message message, Channel channel) {
        try {
            byte[] body = message.getBody();
            String hello = new String(body, Charset.forName("utf8"));
            log.info("消费者2_2收到消息：{}", hello);
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

package com.example.demo02workqueue;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo02WorkQueueApplication {

    @Bean
    public Queue workQueue() {
        return new Queue("work-queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo02WorkQueueApplication.class, args);
    }

}

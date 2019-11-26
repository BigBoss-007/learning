package com.example.demo01springbootrabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo01SpringbootRabbitmqApplication {

    @Bean
    public Queue helloWorld() {
        return new Queue("hello-world");
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo01SpringbootRabbitmqApplication.class, args);
    }

}

package com.example.redissonlock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedissonLockApplication {

    @Bean
    public RedissonClient redissonClient() {

        Config config = new Config();

//        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("123456");
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient redissonClient = Redisson.create(config);
        return redissonClient;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedissonLockApplication.class, args);
    }

}

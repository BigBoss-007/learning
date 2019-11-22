package com.example.redislock2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;

@SpringBootApplication
public class RedisLock2Application {

    @Bean
    public JedisPool jedisPool(){
        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        return jedisPool;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisLock2Application.class, args);
    }

}

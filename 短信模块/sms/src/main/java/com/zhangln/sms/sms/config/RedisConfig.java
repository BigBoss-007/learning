package com.zhangln.sms.sms.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/7
 * @modified By:
 */
@Configuration
public class RedisConfig {
    @Primary
    @Bean
    public RedisTemplate<String, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 使用其他序列化替代jdk序列化
        RedisSerializer<Object> redisSerializer = getRedisSerializer();
        RedisTemplate<String, Object> template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(redisSerializer);
        template.setValueSerializer(redisSerializer);
        template.setHashKeySerializer(redisSerializer);
        template.setHashValueSerializer(redisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    private RedisSerializer<Object> getRedisSerializer() {
        return new GenericFastJsonRedisSerializer();
    }

}

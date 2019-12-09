package com.zhangln.sms.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.AntPathMatcher;

@SpringBootApplication
public class SmsApplication {

    @Bean
    public AntPathMatcher antPathMatcher() {
        return new AntPathMatcher();
    }

    public static void main(String[] args) {
        SpringApplication.run(SmsApplication.class, args);
    }

}

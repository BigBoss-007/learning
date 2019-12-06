package com.zhangln.push.wspush;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhangliuning
 */
@SpringBootApplication
public class WsPushApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WsPushApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("TODO 下线注册在本实例上的客户端连接");
    }
}

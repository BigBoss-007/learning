package com.example.redislock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;


@SpringBootTest
class RedisLockApplicationTests {

    @Autowired
    private RedisLock redisLock;

    @Test
    void contextLoads() {
    }

    @Test
    public void testLock1() throws InterruptedException {

        System.out.println("test1");
        String token = "";
        try {
            token = redisLock.lock("1", 1000 * 60, 10);
            System.out.println("test1拿到锁：" + token);
//            模拟做业务
            TimeUnit.SECONDS.sleep(20);
        } finally {
            if (!StringUtils.isEmpty(token)) {
                boolean unlock = redisLock.unlock("1", token);
                System.out.println("test1解锁结果：" + unlock);
            } else {
                System.out.println("test1没法解锁");
            }

        }


    }

    @Test
    public void testLock2() throws InterruptedException {
        System.out.println("test2");
        String token = "";
        try {
            token = redisLock.lock("1", 1000 * 60, 30*1000);
            System.out.println("test2拿到锁：" + token);
        } finally {
            if (!StringUtils.isEmpty(token)) {
                boolean unlock = redisLock.unlock("1", token);
                System.out.println("test2解锁结果：" + unlock);
            } else {
                System.out.println("test2没法解锁");
            }

        }


    }
}

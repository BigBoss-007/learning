package com.example.redislock2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@SpringBootTest(classes = RedisLock2Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisLock2ApplicationTests {

    @Autowired
    private RedisLock redisLock;

    @Test
    public void testRedisLock() {
        String resName = "lock-1";
        for (int i = 0; i < 10; i++) {
            boolean lock = redisLock.lock(resName);
            if (!lock) {
                System.out.println(new Date()+"获取锁失败");
            } else {
                System.out.println(new Date()+"获取锁成功");
                redisLock.unlock(resName);
            }
        }


    }

}

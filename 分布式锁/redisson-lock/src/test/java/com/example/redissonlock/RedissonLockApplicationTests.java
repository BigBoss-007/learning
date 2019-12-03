package com.example.redissonlock;

import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = RedissonLockApplication.class)
class RedissonLockApplicationTests {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void contextLoads() {
//        需要被锁住的资源
        String key = "key1";
//        获取锁
        RLock rLock = redissonClient.getLock(key);
        try {
//            加锁
//            rLock.lock(5, TimeUnit.SECONDS);//5秒钟后如果业务还没执行完，会释放锁，同时抛出异常

//            一般使用这种方式加锁加锁
            rLock.lock();//在获取到锁之后，然后开一个守护线程，判断当前线程时候执行结束，如果没有那就重置锁的过期时间

//            模拟执行任务
            TimeUnit.SECONDS.sleep(7);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            释放锁
            rLock.unlock();
        }
    }

}

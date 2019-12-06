package com.zhangln.push.wspush;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhangln.push.wspush.entity.RegUserEntity;
import com.zhangln.push.wspush.service.IRegUserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = WsPushApplication.class)
@RunWith(SpringRunner.class)
class WsPushApplicationTests {

    @Autowired
    private IRegUserService iRegUserService;

    @Test
    void testRegUserQuerySuccess() {
        List<RegUserEntity> list = iRegUserService.list(new QueryWrapper<RegUserEntity>()
                .eq(RegUserEntity.ACCESS_KEY, "username"));
        System.out.println(list);
    }

    @Test
    void testRegUserServiceSaveSuccess() {
        RegUserEntity regUserEntity = RegUserEntity.builder()
                .clientType("APP")
                .accessKey("username")
                .accessSecret("123456")
                .status(1)
                .build();
        iRegUserService.save(regUserEntity);
    }

    @Test
    void contextLoads() {
    }

}

package com.example.demo00twodbsource;

import com.example.demo00twodbsource.dao.SysUserDao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class Demo00TwoDbsourceApplicationTests {

    @Autowired
    private SysUserDao sysUserDao;

    @Test
    void contextLoads() {
        sysUserDao.saveToOne("oneName");
        sysUserDao.saveToTwo("twoName");
        sysUserDao.saveToThree("threeName");
    }

}

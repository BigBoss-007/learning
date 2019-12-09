package com.zhangln.sms.sms;

import com.zhangln.sms.sms.config.prop.AppProp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmsApplicationTests {

    @Autowired
    private AppProp appProp;

    @Test
    void contextLoads() {
        System.out.println(appProp.getDaHanSanTongProp().getUsername());
        System.out.println(appProp.getDaHanSanTongProp().getPassword());
    }

}

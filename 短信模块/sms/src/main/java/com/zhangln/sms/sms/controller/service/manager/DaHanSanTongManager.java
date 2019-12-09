package com.zhangln.sms.sms.controller.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * 大汉三通Manager
 *
 * 接口文档：http://help.dahantc.com/docs/oss/1apkb302nt0tv.html
 *
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */
@Component
public class DaHanSanTongManager {

    @Autowired
    private RestTemplate restTemplate;

}

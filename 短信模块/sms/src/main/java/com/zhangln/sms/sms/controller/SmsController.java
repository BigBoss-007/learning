package com.zhangln.sms.sms.controller;

import com.zhangln.sms.sms.controller.service.ISmsService;
import com.zhangln.sms.sms.pojo.vo.SmsResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {

    @Autowired
    private ISmsService iSmsService;

    /**
     * 普通、国内、默认通道、立即发送
     * @param phone
     * @param content
     * @param sign
     * @return
     */
    @PostMapping(value = "/normal-sms",params = {"phone","content","sign"})
    public ResponseEntity normalSms(String phone, String content, String sign){
//        参数校验
        SmsResVo smsResVo = iSmsService.normalSms(phone, content, sign);
        return ResponseEntity.ok(smsResVo);
    }

}

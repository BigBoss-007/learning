package com.zhangln.sms.sms.controller.service;

import com.zhangln.sms.sms.pojo.vo.SmsResVo;

/**
 * 短信接口
 *
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */

public interface ISmsService {


    /**
     * 普通、国内、默认通道、立即发送
     *
     * @param phone
     * @param content
     * @param sign
     * @return
     */
    SmsResVo normalSms(String phone, String content, String sign);


}

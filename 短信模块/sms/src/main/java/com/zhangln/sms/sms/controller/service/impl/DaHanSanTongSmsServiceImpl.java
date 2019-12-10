package com.zhangln.sms.sms.controller.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhangln.sms.sms.controller.service.ISmsService;
import com.zhangln.sms.sms.controller.service.manager.DaHanSanTongManager;
import com.zhangln.sms.sms.controller.service.manager.dto.DaHanSanTongSubmitResDto;
import com.zhangln.sms.sms.pojo.vo.SmsResVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/10
 * @modified By:
 */
@Service
@Slf4j
public class DaHanSanTongSmsServiceImpl implements ISmsService {

    @Autowired
    private DaHanSanTongManager daHanSanTongManager;

    @Override
    public SmsResVo normalSms(String phone, String content, String sign) {
        DaHanSanTongSubmitResDto daHanSanTongSubmitResDto = daHanSanTongManager.smsSubmit(new HashSet<String>(1) {{
            add("+86" + phone);
        }}, content, sign, null, null);

        SmsResVo smsResVo = createSmsResVoFromSmsSubmit(daHanSanTongSubmitResDto);


        return smsResVo;
    }

    private SmsResVo createSmsResVoFromSmsSubmit(DaHanSanTongSubmitResDto daHanSanTongSubmitResDto) {
        SmsResVo smsResVo = new SmsResVo();
        smsResVo.setMsgId(daHanSanTongSubmitResDto.getMsgid());
        smsResVo.setSmsId(UUID.randomUUID().toString());
        if ("0".equals(daHanSanTongSubmitResDto.getResult())) {
            smsResVo.setSmsStatus(1);
        } else {
            smsResVo.setSmsStatus(2);
        }

        smsResVo.setContent(JSONObject.toJSONString(daHanSanTongSubmitResDto));
        if (StringUtils.isNotEmpty(daHanSanTongSubmitResDto.getFailPhones())) {
            String[] failPhones = StringUtils.split(daHanSanTongSubmitResDto.getFailPhones(), ",");
            List<String> list = Arrays.asList(failPhones);
            smsResVo.setFailPhones(list);
        }
        return smsResVo;
    }
}

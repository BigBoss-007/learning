package com.zhangln.sms.sms.controller.service.manager;

import com.zhangln.sms.sms.pojo.vo.SmsResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */
@Component
@Slf4j
public class SmsManager {

    @Autowired
    private ChuangLanManager chuangLanManager;

    @Autowired
    private DaHanSanTongManager daHanSanTongManager;

    /**
     * 通知短信
     * <p>
     * - 境内
     * - 境外
     * - 创蓝
     * - 大汉三通
     * - 单笔发送
     * - 群发
     *
     * @param phones      手机号
     * @param sign        签名
     * @param subcode     扩展码
     * @param content     短信内容
     * @param channelType 短信通道
     * @param country     国别
     * @param sendTime    定时发送时间
     * @return
     */
    public SmsResVo noticeSms(List<String> phones, String sign, String subcode, String content, String channelType, String country, LocalDateTime sendTime) {
//        TODO
        return null;
    }

    /**
     * 营销短信
     * <p>
     * - 境内
     * - 境外
     * - 创蓝
     * - 大汉三通
     * - 单笔发送
     * - 群发
     *
     * @param phones
     * @param content
     * @param channelType
     * @param country
     * @return
     */
    public SmsResVo marketingSms(List<String> phones, String content, String channelType, String country) {
//        TODO
        return null;
    }

    /**
     * 彩信
     * @return
     */
    public SmsResVo mms(){
        return null;
    }

}

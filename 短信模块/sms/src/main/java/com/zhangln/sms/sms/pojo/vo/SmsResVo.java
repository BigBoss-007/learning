package com.zhangln.sms.sms.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 短信调用结果表
 * <p>
 * 整合了各个短信通道的调用结果
 *
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SmsResVo implements Serializable {

    /**
     * 短信调用返回id，由短信服务商提供
     */
    private String msgId;
    /**
     * 本地调用的id，由本平台生成
     */
    private String smsId;
    /**
     * 短信调用状态
     * 1-调用成功
     * 2-调用失败
     */
    private Integer smsStatus;

    /**
     * 本地调用情况详细说明
     */
    private String content;

    /**
     * 发送失败的手机号码
     */
    private List<String> failPhones;

}

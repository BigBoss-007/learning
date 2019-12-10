package com.zhangln.sms.sms.controller.service.manager.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/10
 * @modified By:
 */
@Data
public class DaHanSanTongSubmitReqDto implements Serializable {

    /*
    account	用户账号
password	密码，需采用MD5加密(32位小写) ，如调用大汉三通提供jar包的话使用明文
msgid	该批短信编号(32位UUID)，需保证唯一，选填，不填的话响应里会给一个系统生成的
phones	接收手机号码，多个手机号码用英文逗号分隔，最多1000个，必填，国际号码格式为+国别号手机号，示例：+85255441234
content	短信内容，最多1000个汉字，必填,内容中不要出现【】[]这两种方括号，该字符为签名专用
sign	短信签名，该签名需要提前报备，生效后方可使用，不可修改，必填，示例如：【大汉三通】
subcode	短信签名对应子码(大汉三通提供)+自定义扩展子码(选填)，必须是数字，选填，未填使用签名对应子码，通常建议不填
sendtime	定时发送时间，格式yyyyMMddHHmm，为空或早于当前时间则立即发送
     */

    private String account;
    private String password;
    private String msgid;
    private String phones;
    private String content;
    private String sign;
    private String subcode;
    private String sendtime;


}

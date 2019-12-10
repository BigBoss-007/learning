package com.zhangln.sms.sms.config.prop.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */

@Data
@Component
@ConfigurationProperties(prefix = "user.sms.auth.dahansantong")
public class DaHanSanTongProp {
//    普通短信账号
    private String username;
//    普通短信密码
    private String password;
//    营销短信账号
    private String musername;
//    营销短信密码
    private String mpassword;

//    普通短信-相同内容多个号码
    private String urlSmsSubmit = "https://www.dh3t.com/json/sms/Submit";
//    普通短信-不同内容多个号码
    private String urlSmsBatchSubmit = "https://www.dh3t.com/json/sms/BatchSubmit";

}

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
    private String username;
    private String password;
}

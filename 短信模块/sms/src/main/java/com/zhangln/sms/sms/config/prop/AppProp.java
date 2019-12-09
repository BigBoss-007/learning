package com.zhangln.sms.sms.config.prop;

import com.zhangln.sms.sms.config.prop.sms.DaHanSanTongProp;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */
@Data
@Component
@ConfigurationProperties(prefix = "user")
public class AppProp {

    private String active;
    private List<String> ignoreUrl;

    @Autowired
    private DaHanSanTongProp daHanSanTongProp;

}

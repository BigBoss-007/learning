package com.zhangln.sms.sms.config.prop;

import lombok.Data;
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

}

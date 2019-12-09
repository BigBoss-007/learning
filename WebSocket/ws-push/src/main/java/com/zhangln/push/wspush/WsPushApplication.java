package com.zhangln.push.wspush;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhangln.push.wspush.service.ILogWsConnectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.util.AntPathMatcher;

/**
 * @author zhangliuning
 */
@SpringBootApplication
@ServletComponentScan
public class WsPushApplication implements CommandLineRunner {

    @Autowired
    private ILogWsConnectService iLogWsConnectService;

    @Bean
    public AntPathMatcher antPathMatcher(){
        return new AntPathMatcher();
    }

    public static void main(String[] args) {
        SpringApplication.run(WsPushApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        全部下线
        iLogWsConnectService.remove(new QueryWrapper<>());
    }
}

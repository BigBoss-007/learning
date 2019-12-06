package com.zhangln.push.wspush;

import com.zhangln.push.wspush.websocket.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 当SpringBoot启动后,加载这个类
 *
 * @author mac
 */
@Component
@Slf4j
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {
            //事件获得上下文对象化后启动服务器
            try {
                WebSocketServer.getInstance()
                        .start(10002);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }


}
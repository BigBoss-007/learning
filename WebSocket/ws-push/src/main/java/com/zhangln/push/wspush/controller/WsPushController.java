package com.zhangln.push.wspush.controller;

import com.zhangln.push.wspush.websocket.UserChannelRelation;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/7
 * @modified By:
 */
@RestController
@RequestMapping("/push")
@Slf4j
public class WsPushController {

    @GetMapping(value = "/test1", params = {"channelId", "msg"})
    public ResponseEntity pushTest(String channelId, String msg) {

        UserChannelRelation.get(channelId)
                .ifPresent(channel -> {
                    channel.writeAndFlush(new TextWebSocketFrame(msg));
                });

        return ResponseEntity.ok("推送成功");
    }

}

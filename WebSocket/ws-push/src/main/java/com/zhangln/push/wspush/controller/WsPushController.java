package com.zhangln.push.wspush.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangln.push.wspush.controller.service.WsPushService;
import com.zhangln.push.wspush.vo.HttpResVo;
import com.zhangln.push.wspush.vo.HttpWsPushCondition;
import com.zhangln.push.wspush.vo.WsRespVo;
import com.zhangln.push.wspush.websocket.UserChannelRelation;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    @Autowired
    private WsPushService wsPushService;

    /**
     * 测试推送
     *
     * @param channelId
     * @param msg
     * @return
     */
    @GetMapping(value = "/test1", params = {"channelId", "msg"})
    public ResponseEntity pushTest(String channelId, String msg) {

        UserChannelRelation.get(channelId)
                .ifPresent(channel -> {
                    channel.writeAndFlush(new TextWebSocketFrame(msg));
                });

        return ResponseEntity.ok("推送成功");
    }

    /**
     * 测试http
     *
     * @return
     */
    @GetMapping("/test2")
    public ResponseEntity httpTest() {
        return ResponseEntity.ok(HttpResVo.success());
    }

    /**
     * 通用推送接口
     *
     * @param condition
     * @return
     */
    @PostMapping("/common")
    public ResponseEntity commonPush(@Validated HttpWsPushCondition condition) {

//        查询channelId

        List<String> channelIds = wsPushService.getChannelIds(condition);

        if (!CollectionUtils.isEmpty(channelIds)) {
            channelIds.stream()
                    .forEach(channelId -> {
                        try {
                            WsRespVo wsRespVo = WsRespVo.builder()
                                    .id(condition.getPushId())
                                    .date(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now()))
                                    .pushType(condition.getPushType())
                                    .code(200)
                                    .msg("正常")
                                    .data(condition.getContent())
                                    .build();

                            String pushStr = JSONObject.toJSONString(wsRespVo);
                            log.info("向{}推送{}", channelId, pushStr);

                            UserChannelRelation.get(channelId)
                                    .ifPresent(channel -> {
                                        channel.writeAndFlush(new TextWebSocketFrame(pushStr));
                                        wsPushService.savePushTask(condition, pushStr, channel);
                                    });
                        } catch (Exception e) {
                            log.error(e.getMessage(), e);
                        }

                    });
        } else {
            return ResponseEntity.ok(HttpResVo.buildError("无有效客户端连接，推送失败"));
        }


        return ResponseEntity.ok(HttpResVo.success());

    }
}

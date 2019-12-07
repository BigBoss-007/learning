package com.zhangln.push.wspush.controller.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhangln.push.wspush.entity.LogWsConnectEntity;
import com.zhangln.push.wspush.service.ILogWsConnectService;
import com.zhangln.push.wspush.vo.HttpWsPushCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/7
 * @modified By:
 */
@Service
@Slf4j
public class WsPushService {

    @Autowired
    private ILogWsConnectService iLogWsConnectService;

    /**
     * 查询
     *
     * @param condition
     * @return
     */
    public List<String> getChannelIds(HttpWsPushCondition condition) {
        List<LogWsConnectEntity> list = iLogWsConnectService.list(new QueryWrapper<LogWsConnectEntity>()
                .eq(LogWsConnectEntity.STATUS, 1)
                .eq(!StringUtils.isEmpty(condition.getClientType()), LogWsConnectEntity.CLIENT_TYPE, condition.getClientType())
                .eq(!StringUtils.isEmpty(condition.getApp()), LogWsConnectEntity.APP, condition.getApp())
                .eq(!StringUtils.isEmpty(condition.getUser()), LogWsConnectEntity.USER, condition.getUser())
                .eq(!StringUtils.isEmpty(condition.getGroup()), LogWsConnectEntity.GROUP, condition.getGroup())
                .eq(!StringUtils.isEmpty(condition.getAreaCode()), LogWsConnectEntity.AREA_CODE, condition.getAreaCode())
                .eq(!StringUtils.isEmpty(condition.getCountry()), LogWsConnectEntity.COUNTRY, condition.getCountry())
        );
        if (!CollectionUtils.isEmpty(list)){
            List<String> ids = list.stream()
                    .map(LogWsConnectEntity::getChannelId)
                    .collect(Collectors.toList());
            return ids;
        }
        return null;
    }
}

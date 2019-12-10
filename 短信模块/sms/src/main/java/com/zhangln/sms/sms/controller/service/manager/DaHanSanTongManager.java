package com.zhangln.sms.sms.controller.service.manager;

import com.alibaba.fastjson.JSONObject;
import com.zhangln.sms.sms.config.prop.AppProp;
import com.zhangln.sms.sms.controller.service.manager.dto.DaHanSanTongSubmitReqDto;
import com.zhangln.sms.sms.controller.service.manager.dto.DaHanSanTongSubmitResDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * 大汉三通Manager
 * <p>
 * https://www.tapd.cn/41964526/prong/stories/view/1141964526001001180
 * <p>
 * 接口文档：http://help.dahantc.com/docs/oss/1apkb302nt0tv.html
 * <p>
 * Manager层，忠实体现接口方给过来的意图，不做过多的设计
 * 甚至不做参数校验
 * 参数校验、优化等内容，交给上层Service
 *
 * @author sherry
 * @description
 * @date Create in 2019/12/9
 * @modified By:
 */
@Component
@Slf4j
public class DaHanSanTongManager {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppProp appProp;


    /**
     * 普通短信 http://help.dahantc.com/docs/oss/1apkb302nt0tv.html
     *
     * @param phones
     * @param content
     * @param sign
     * @param subcode
     * @param sendtime
     * @return
     */
    public DaHanSanTongSubmitResDto smsSubmit(Set<String> phones, String content, String sign, String subcode, LocalDateTime sendtime) {

//        组装请求参数
        DaHanSanTongSubmitReqDto daHanSanTongSubmitReqDto = createDaHanSanTongSubmitReqDto(phones, content, sign, subcode, sendtime);
        HttpEntity httpEntity = createDaHanSanTongSmsSubmitRequest(daHanSanTongSubmitReqDto);
        ResponseEntity<String> responseEntity;

        try {
            responseEntity = restTemplate.exchange(appProp.getDaHanSanTongProp().getUrlSmsSubmit(), HttpMethod.POST, httpEntity, String.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("短信发送失败:" + JSONObject.toJSONString(daHanSanTongSubmitReqDto));
        }

        DaHanSanTongSubmitResDto daHanSanTongSubmitResDto = JSONObject.parseObject(responseEntity.getBody(), DaHanSanTongSubmitResDto.class);

        return daHanSanTongSubmitResDto;
    }

    private HttpEntity createDaHanSanTongSmsSubmitRequest(DaHanSanTongSubmitReqDto daHanSanTongSubmitReqDto) {
        //设置头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json;charset=UTF-8");
        HttpEntity httpEntity = new HttpEntity(JSONObject.toJSONString(daHanSanTongSubmitReqDto), httpHeaders);
        ResponseEntity<DaHanSanTongSubmitResDto> responseEntity = null;
        return httpEntity;
    }

    private DaHanSanTongSubmitReqDto createDaHanSanTongSubmitReqDto(Set<String> phones, String content, String sign, String subcode, LocalDateTime sendtime) {
        DaHanSanTongSubmitReqDto daHanSanTongSubmitReqDto = new DaHanSanTongSubmitReqDto();
        daHanSanTongSubmitReqDto.setAccount(appProp.getDaHanSanTongProp().getUsername());
        daHanSanTongSubmitReqDto.setPassword(DigestUtils.md5DigestAsHex(appProp.getDaHanSanTongProp().getPassword().getBytes()));
        daHanSanTongSubmitReqDto.setPhones(StringUtils.join(phones, ","));
        daHanSanTongSubmitReqDto.setContent(content);
        daHanSanTongSubmitReqDto.setSign(sign);

        if (StringUtils.isNotEmpty(subcode)) {
            daHanSanTongSubmitReqDto.setSubcode(subcode);
        }


        if (sendtime != null) {
            daHanSanTongSubmitReqDto.setSendtime(DateTimeFormatter.ofPattern("yyyyMMddHHmm").format(sendtime));
        }
        return daHanSanTongSubmitReqDto;
    }

}

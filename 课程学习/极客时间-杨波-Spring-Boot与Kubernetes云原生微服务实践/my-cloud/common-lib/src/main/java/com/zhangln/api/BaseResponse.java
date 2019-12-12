package com.zhangln.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zhangln.HttpBusStatus;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 所有的接口返回对象，都继承此类
 *
 * @author sherry
 * @description
 * @date Create in 2019/12/12
 * @modified By:
 */
@Data
public class BaseResponse implements Serializable {
    //    一次返回的唯一标记
    private String id;
    private Integer code;
    private String msg;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private LocalDateTime resTime;

    /**
     * 通用成功对象
     *
     * @return
     */
    public static BaseResponse SUCCESS() {
        return BaseResponse.build(HttpBusStatus.SUCCESS, HttpBusStatus.SUCCESS_MSG);
    }

    /**
     * 通用失败对象
     *
     * @return
     */
    public static BaseResponse ERROR() {
        return BaseResponse.build(HttpBusStatus.ERROR, HttpBusStatus.ERROR_MSG);
    }

    /**
     * 自定义成功消息
     *
     * @param msg
     * @return
     */
    public static BaseResponse buildSuccess(String msg) {
        BaseResponse baseResponse = BaseResponse.SUCCESS();
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    /**
     * 自定义失败消息
     *
     * @param msg
     * @return
     */
    public static BaseResponse buildError(String msg) {
        BaseResponse baseResponse = BaseResponse.ERROR();
        baseResponse.setMsg(msg);
        return baseResponse;
    }


    /**
     * 通用构建返回基础类
     *
     * @param code
     * @param msg
     * @return
     */
    public static BaseResponse build(Integer code, String msg) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setId(UUID.randomUUID().toString());
        baseResponse.setResTime(LocalDateTime.now());
        baseResponse.setCode(code);
        baseResponse.setMsg(msg);
        return baseResponse;
    }

    /**
     * 本次调用结果返回是否正常
     * @return
     */
    public boolean isSuccess() {
        return HttpBusStatus.SUCCESS == this.code;
    }
}

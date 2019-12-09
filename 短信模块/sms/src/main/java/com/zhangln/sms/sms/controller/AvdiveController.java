package com.zhangln.sms.sms.controller;

import com.zhangln.sms.sms.pojo.vo.HttpResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/7
 * @modified By:
 */
@ControllerAdvice
@Slf4j
public class AvdiveController {
    /**
     * 自行抛出的运行时异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity sysRequest(Exception e) {
        return ResponseEntity.ok(HttpResVo.buildError(e.getMessage()));
    }
}

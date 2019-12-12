package com.zhangln;

/**
 * 接口返回状态
 * @author sherry
 * @description
 * @date Create in 2019/12/12
 * @modified By:
 */

public interface HttpBusStatus {

    Integer SUCCESS = 200;
    String SUCCESS_MSG = "成功";

    Integer ERROR= 500;
    String ERROR_MSG = "失败";

}

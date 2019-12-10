package com.zhangln.sms.sms.controller.service.manager.dto;

import java.io.Serializable;

/**
 * 大汉三通普通短信调用返回
 * @author sherry
 * @description
 * @date Create in 2019/12/10
 * @modified By:
 */
public class DaHanSanTongSubmitResDto implements Serializable {

    /**
     * msgid : f02adaaa99c54ea58d626aac2f4ddfa8
     * result : 0
     * desc : 提交成功
     * failPhones : 12935353535,110,130123123
     */

//    该批短信编号
    private String msgid;
//    该批短信提交结果；说明请参照 http://help.dahantc.com/docs/oss/1apkg9ncgtaq9.html
    private String result;
//    状态描述
    private String desc;
//    如果提交的号码中含有错误（格式）号码将在此显示
    private String failPhones;

    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFailPhones() {
        return failPhones;
    }

    public void setFailPhones(String failPhones) {
        this.failPhones = failPhones;
    }
}

package com.zhangln.push.wspush;

import com.alibaba.fastjson.JSONObject;
import com.zhangln.push.wspush.vo.WsRegVo;
import com.zhangln.push.wspush.websocket.DataContent;
import org.junit.jupiter.api.Test;

/**
 * @author sherry
 * @description
 * @date Create in 2019/12/7
 * @modified By:
 */

public class CommonTest {
    @Test
    public void test1() {
        DataContent dataContent = new DataContent();
        dataContent.setAction(1);
        dataContent.setTokenId("TODO");

        WsRegVo wsRegVo = new WsRegVo();
        wsRegVo.setUser("zln");

        dataContent.setJsonObjStr(JSONObject.toJSONString(wsRegVo));

        System.out.println(JSONObject.toJSON(dataContent));
        System.out.println(dataContent.getJsonObjStr());

    }
}

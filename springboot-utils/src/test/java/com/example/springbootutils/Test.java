package com.example.springbootutils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.utils.http.CommunicationUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 */
public class Test {

    @org.junit.Test
    public void send(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","罗祥");
        map.put("mobile","18888888888");
        map.put("conut",100);
        String url = "http://localhost:8080/http/get";
        JSONObject jsonObject = CommunicationUtil.sendPost(url, JSON.toJSONString(map), "czbt", "za");
        System.out.println(jsonObject);
    }
}

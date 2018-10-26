package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.util.DateUtil;
import com.example.util.StringUtil;
import com.example.util.http.CommunicationUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 */
public class Test {

    private final String appid = "tMcCm4akwvGO1WGwAU18zg==";

    private final String bid = "OP20180627100001";

    @org.junit.Test
    public void test01() {
        Map<String, Object> map = new HashMap<>();
        map.put("timeStamp", DateUtil.getNow().getTime());
        map.put("trade", StringUtil.Getnum());
        map.put("name", "李静");
        map.put("mobile", "18888888888");
        map.put("idNo", "211432198804048432");
        map.put("idNoImage", "");
        map.put("plateLicense", "京A88888");
        map.put("carType", "汽车");
        map.put("owner", "李静");
        map.put("address", "北京市朝阳区");
        map.put("useNature", "营运");
        map.put("brandModel", "XXX");
        map.put("identifyCode", "VIN");
        map.put("engineNumber", "aaaaaa");
        map.put("registDate", "2018-01-01");
        map.put("certificateDate", "2018-01-01");
        map.put("drivingLicenseImage", "");
        map.put("orderType", "1");
        map.put("orderAmount", 5000.00);
        map.put("orderTime", "2018-06-12 18:34:22");
        map.put("insureCity", "北京");
        map.put("insureUser", "李静");
        map.put("insurant", "王静");
        map.put("channelName", "za");
        String url = "http://localhost:8080/api/op/order/in";
        String s = JSON.toJSONString(map);
        System.out.println("开始推送数据");
        JSONObject jsonObject = CommunicationUtil.sendPost(url, s, appid, bid, "zhongan");
        System.out.println(jsonObject);
        System.out.println("推送数据结束");
    }

    @org.junit.Test
    public void test02() {
        Map<String, Object> map = new HashMap<>();
        map.put("timeStamp", DateUtil.getNow().getTime());
        map.put("trade", "20180622150147392");
        String url = "http://localhost:8080/api/op/order/query";
        String s = JSON.toJSONString(map);
        System.out.println("查询订单状态开始");
        JSONObject jsonObject = CommunicationUtil.sendPost(url, s, appid, bid, "zhongan");
        System.out.println(jsonObject);
        System.out.println("查询订单状态结束");
    }
}

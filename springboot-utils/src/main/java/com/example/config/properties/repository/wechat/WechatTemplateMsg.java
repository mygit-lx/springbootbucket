package com.example.config.properties.repository.wechat;

import com.example.annotation.NotRequire;

import java.util.TreeMap;


/**
 * 模板消息
 * @author phil
 * @date 2017年7月2日
 *
 */
public class WechatTemplateMsg {
    private String touser; //接收者openid
    private String template_id; //模板ID
    @NotRequire//只是个标识
    private String url; //模板跳转链接
    // "miniprogram":{ 未加入
    // "appid":"xiaochengxuappid12345",
    // "pagepath":"index?foo=bar"
    // },
    private TreeMap<String, TreeMap<String, String>> data; //data数据
    /**
     * 参数
     * @param value
     * @param color 可不填
     * @return
     */
    public static TreeMap<String, String> item(String value, String color) {
        TreeMap<String, String> params = new TreeMap<String, String>();
        params.put("value", value);
        params.put("color", color);
        return params;
    }
}

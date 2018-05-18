package com.example.service;


import com.example.config.properties.repository.wechat.TemplateMsgResult;

public interface WechatMsgService {

    TemplateMsgResult sendTemplate(String accessToken, String data);
}

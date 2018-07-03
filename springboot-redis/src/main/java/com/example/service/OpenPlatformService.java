package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.OpUser;

/**
 *
 */

public interface OpenPlatformService {

    OpUser findAllOpUser(Integer id);

    JSONObject insertOrderData(JSONObject requestData,JSONObject result) throws Exception;

    JSONObject getOrderData(JSONObject requestData, JSONObject result) throws Exception;

    JSONObject noticeOutOrderData(JSONObject requestData, JSONObject result) throws Exception;

    JSONObject queryTradeInfo(JSONObject requestData, JSONObject result) throws Exception;
}

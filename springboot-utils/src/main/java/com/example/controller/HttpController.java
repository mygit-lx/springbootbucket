package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.common.JsonResult;
import com.example.utils.http.CommunicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * http通讯测试
 */
@RestController
@RequestMapping(value = "/http")
public class HttpController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/send")
    public JsonResult sendReuqest(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        map.put("name","罗祥");
        map.put("mobile","18888888888");
        map.put("conut",100);
        return returnSuccess();
    }

    @RequestMapping(value = "/get")
    public JsonResult getRequest(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        logger.info("获取解密后的请求数据:{}",requestData);
        return returnSuccess(requestData);
    }
}

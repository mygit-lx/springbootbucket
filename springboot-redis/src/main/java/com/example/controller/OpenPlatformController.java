package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.common.result.JsonResult;
import com.example.domain.OpUser;
import com.example.service.OpenPlatformService;
import com.example.util.http.CommunicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开放平台API
 */
@RestController
@RequestMapping(value = "/op")
public class OpenPlatformController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private OpenPlatformService openPlatformService;

    /**
     * 测试接口
     * @param id
     */
    @RequestMapping(value = "/getById/{id}")
    public void getOpUser(@PathVariable Integer id){
        OpUser allOpUser = openPlatformService.findAllOpUser(id);
        System.out.println(allOpUser.toString());
    }

    /**
     * 支付接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/order/in")
    public JsonResult orderIn(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        logger.info("接口【/op/order/in】获取解密后的请求数据:{}",requestData);
        JSONObject result = new JSONObject();
        try {
            openPlatformService.insertOrderData(requestData,result);
        } catch (Exception e) {
            logger.error("流水账单入库失败，原因：{}",e.getMessage());
            return returnFaild(e.getMessage());
        }
        logger.info("流水账单入库成功，流水为：{}",result);
        return returnSuccess(result);
    }

    /**
     * 查询订单接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/order/query")
    public JsonResult orderQuery(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        logger.info("接口【/op/order/query】获取解密后的请求数据:{}",requestData);
        JSONObject result = new JSONObject();
        try {
            openPlatformService.getOrderData(requestData,result);
        } catch (Exception e) {
            logger.error("查询订单状态失败，原因：{}",e.getMessage());
            return returnFaild(e.getMessage());
        }
        logger.info("查询订单状态成功，结果为：{}",result);
        return returnSuccess(result);
    }

    /**
     * 出单通知
     * @param request
     * @return
     */
    @RequestMapping(value = "/order/out")
    public JsonResult out(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        logger.info("接口【/op/order/out】获取解密后的请求数据:{}",requestData);
        JSONObject result = new JSONObject();
        try {
            openPlatformService.noticeOutOrderData(requestData,result);
        } catch (Exception e) {
            logger.error("出单通知失败，原因：{}",e.getMessage());
            return returnFaild(e.getMessage());
        }
        logger.info("出单通知成功，结果为：{}",result);
        return returnSuccess(result);
    }

    /**
     * 交易查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/trade/query")
    public JsonResult query(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        logger.info("接口【/op/trade/query】获取解密后的请求数据:{}",requestData);
        JSONObject result = new JSONObject();
        try {
            openPlatformService.queryTradeInfo(requestData,result);
        } catch (Exception e) {
            logger.error("交易查询失败，原因：{}",e.getMessage());
            return returnFaild(e.getMessage());
        }
        logger.info("交易查询成功，结果为：{}",result);
        return returnSuccess(result);
    }
}

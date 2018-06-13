package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.common.JsonResult;
import com.example.utils.http.CommunicationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http通讯测试
 */
@RestController
@RequestMapping(value = "/pay/order")
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

    /**
     * 交易接口
     * @param request
     * @return
     */
    @RequestMapping(value = "/in")
    public JsonResult in(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        System.out.println(requestData);
        logger.info("获取解密后的请求数据:{}",requestData);
        Map<String,Object> map = new HashMap<>();
        map.put("orderId","ZJ4526547225");
        return returnSuccess(map);
    }

    /**
     * 出单通知
     * @param request
     * @return
     */
    @RequestMapping(value = "/out")
    public JsonResult out(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        System.out.println(requestData);
        logger.info("获取解密后的请求数据:{}",requestData);
        Map<String,Object> map = new HashMap<>();
        map.put("orderId","ZJ4526547225");
        return returnSuccess(map);
    }

    /**
     * 交易查询
     * @param request
     * @return
     */
    @RequestMapping(value = "/query")
    public JsonResult query(HttpServletRequest request){
        JSONObject requestData = CommunicationUtil.getRequestData(request);
        System.out.println(requestData);
        logger.info("获取解密后的请求数据:{}",requestData);
        Map<String,Object> order = new HashMap<>();
        order.put("orderId","ZJ4526547225");
        order.put("createTime","2018-06-13 10:00:00");
        order.put("orderType","1");
        order.put("orderStatus","1");
        order.put("tradeStatus","1");
        order.put("tradeAmount",5000.00);
        order.put("term",6);
        order.put("principal",5000);
        order.put("rate",1.00);
        order.put("serviceFee",50.00);

        Map<String,Object> userInfo = new HashMap<>();
        userInfo.put("name","李静");
        userInfo.put("idNo","211411198804044567");
        userInfo.put("mobile","18888888888");

        List<Map<String,Object>> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            Map<String,Object> repaymentPlan = new HashMap<>();
            repaymentPlan.put("periods",i+"");
            repaymentPlan.put("reapyemntDate","2018-06-0"+i+" 00:00:00");
            repaymentPlan.put("principal",900.00);
            repaymentPlan.put("interest",10.00);
            list.add(repaymentPlan);
        }


        Map<String,Object> repayment = new HashMap<>();
        repayment.put("repaymentBank","ZJ4526547225");
        repayment.put("repaymentBankCardNo","ZJ4526547225");
        repayment.put("repaymentPlan",list);

        Map<String,Object> map = new HashMap<>();
        map.put("order",order);
        map.put("userInfo",userInfo);
        map.put("repayment",repayment);
        return returnSuccess(map);
    }
}

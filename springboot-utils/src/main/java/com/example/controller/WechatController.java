package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.param.TemplateParam;
import com.example.template.Template;
import com.example.utils.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * ${title} <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V1.0.0 2018/5/7 20:56 luoxiang 初版<br>
 * <p>
 * Copyright (c) 2017，2117,北京桔子分期电子商务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@RestController
@RequestMapping(value = "/wx")
public class WechatController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(WechatController.class);

    public boolean sendTemplateMsg(String token,Template template){
        boolean flag=false;
        String requestUrl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        requestUrl=requestUrl.replace("ACCESS_TOKEN", token);
        JSONObject jsonResult= CommonUtil.httpsRequest(requestUrl, "POST", template.toJSON());
        System.out.println(jsonResult);
        if(jsonResult!=null){
            int errorCode=jsonResult.getInteger("errcode");
            String errorMessage=jsonResult.getString("errmsg");
            if(errorCode==0){
                flag=true;
            }else{
                System.out.println("模板消息发送失败:"+errorCode+","+errorMessage);
                flag=false;
            }
        }
        return flag;
    }

    @RequestMapping(value = "/send/msg")
    public String sendMsg(HttpServletRequest request, HttpServletResponse response){
        Template tem=new Template();
        tem.setTemplateId("ngqIpbwh8bUfcSsECmogfXcV14J0tQlEpBO27izEYtY");
        tem.setTopColor("#00DD00");
        tem.setToUser("oyodSxHEu5b_2w0DzPtW8YzFzVvo");
        tem.setUrl("");

        List<TemplateParam> paras=new ArrayList<TemplateParam>();
        paras.add(new TemplateParam("first","我们已收到您的货款，开始为您打包商品，请耐心等待: )","#FF3333"));
        paras.add(new TemplateParam("orderMoneySum","¥20.00","#0044BB"));
        paras.add(new TemplateParam("orderProductName","火烧牛干巴","#0044BB"));
        paras.add(new TemplateParam("Remark","感谢你对我们商城的支持!!!!","#AAAAAA"));

        tem.setTemplateParamList(paras);
        String token = "9_8CoFkfRy1GQtHPkNe73kQ3uPhgxuejeIhFtzBnml9UCcFwULYqVmUs0d3VmkMSlEPv4KVJkmRFrQJdmyvadnTRMCQHFHyQ13uV41ByUTtbhj7klqjMosWgypgQMUBLfAJAIPZ";
        boolean result=sendTemplateMsg(token,tem);
        return null;
    }
}

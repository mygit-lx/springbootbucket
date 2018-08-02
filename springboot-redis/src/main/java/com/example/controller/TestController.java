package com.example.controller;

import com.example.common.config.ThreadPoolManager;
import com.example.common.config.security.PreventRecoverySubmit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    ThreadPoolManager tpm;

    @ResponseBody
    @RequestMapping("/pool")
    public Object test() {
        for (int i = 0; i < 10; i++) {
            //模拟并发10条记录
            tpm.processOrders(Integer.toString(i));
        }

        return "ok";
    }

    @PreventRecoverySubmit
    @RequestMapping(value = "/no/1")
    public void test01(){
        System.out.println("-------->拦截测试1<-------");
    }

    @RequestMapping(value = "/no/2")
    public void test02(){
        System.out.println("-------->拦截测试2<-------");
    }
}

package com.example.controller;

import com.example.utils.async.DeferredResultHolder;
import com.example.utils.async.MockQueue;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 并发编程-多线程
 */
@RestController
@RequestMapping(value = "/thread")
public class ThreadController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MockQueue mockQueue;

    @Autowired
    private DeferredResultHolder deferredResultHolder;

    /**
     * 单线程测试
     * @return
     */
    @RequestMapping(value = "/order")
    public String order() throws InterruptedException {
        logger.info("-----主线程开始-----");
        Thread.sleep(1000);
        logger.info("-----主线程结束-----");
        return "success";
    }

    /**
     *用Callable实现异步
     * @return
     */
    @RequestMapping(value = "/orderAsync")
    public Callable orderAsync(){
        logger.info("-----主线程开始-----");
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                logger.info("-----子线程开始-----");
                Thread.sleep(1000);
                logger.info("-----子线程结束-----");
                return "success";
            }
        };
        logger.info("-----主线程结束-----");
        return callable;
    }

    @RequestMapping(value = "/orderQueue")
    public DeferredResult orderQueue() throws InterruptedException {
        logger.info("-----主线程开始-----");
        //随机生成8位数
        String numeric = RandomStringUtils.randomNumeric(8);

        //接到下单请求
        mockQueue.setPalceOrder(numeric);

        DeferredResult deferredResult = new DeferredResult();
        deferredResultHolder.getMap().put(numeric,deferredResult);
        Thread.sleep(1000);
        logger.info("-----主线程返回-----");
        return deferredResult;
    }
}

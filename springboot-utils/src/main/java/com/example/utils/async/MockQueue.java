package com.example.utils.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 模拟消息队列 类
 * Created by luoxiang
 */
@Component
public class MockQueue {
    
    private Logger logger = LoggerFactory.getLogger(getClass());

    //下单消息
    private String palceOrder;

    //订单完成信息
    private String completeOrder;

    public String getPalceOrder() {
        return palceOrder;
    }

    public void setPalceOrder(String palceOrder) {
        new Thread(()->{
            logger.info("-----接到下单请求-----{}",palceOrder);
            //模拟处理
            try {
                 Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            //给completeOrder赋值
            this.completeOrder=palceOrder;
            logger.info("-----下单请求处理完毕-----{}",palceOrder);
        }).start();
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}

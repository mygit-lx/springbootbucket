package com.example.utils.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 *  订单处理情况 中介/持有者
 * Created by luoxiang
 */
@Component
public class DeferredResultHolder {

    /**
     * String： 订单号
     * DeferredResult：处理结果
     */
    Map<String,DeferredResult> map = new HashMap<String,DeferredResult>();

    public Map<String, DeferredResult> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult> map) {
        this.map = map;
    }
}

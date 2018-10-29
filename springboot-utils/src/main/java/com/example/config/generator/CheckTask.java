package com.example.config.generator;

import com.example.utils.WifiUtil;

import java.util.concurrent.Callable;

/**
 * @author zhangwei
 * date 2018/10/22
 * time 14:47
 */
public class CheckTask  implements Callable<Boolean> {

    private String ssid;
    private String password;

    public CheckTask(String ssid, String password) {
        this.ssid = ssid;
        this.password = password;
    }

    public Boolean call() {
        WifiUtil execute = new WifiUtil();
        boolean checked = execute.check(ssid, password);
        return checked;
    }
}

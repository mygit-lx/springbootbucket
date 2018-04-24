package com.example.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;
/**
 * 登录认证接口参数
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class LoginParam {
    /**
     * 用户名
     */
    @ApiComment(value = "用户名",sample = "admin")
    private String username;
    /**
     * 密码
     */
    @ApiComment(value = "密码", sample = "123456")
    private String password;
    /**
     * Application ID
     */
    @ApiComment(value = "Application ID",sample = "com.xncoding.xzpay")
    private String appid;
    /**
     * IMEI码
     */
    @ApiComment(value = "IMEI码",sample = "TUYIUOIU234234YUII")
    private String imei;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}
package com.example.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;

/**
 * 解绑通知参数
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class UnbindParam {
    /**
     * IMEI码
     */
    @ApiComment(value = "IMEI码", sample = "TUYIUOIU234234YUII")
    private String imei;
    /**
     * 网点
     */
    @ApiComment(value = "网点", sample = "广州市天河区交警7区")
    private String location;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

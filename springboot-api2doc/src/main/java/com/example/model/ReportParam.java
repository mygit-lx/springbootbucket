package com.example.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;

/**
 * 报告参数
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class ReportParam {
    /**
     * IMEI码
     */
    @ApiComment(value = "IMEI码（长度1-32位）",sample = "2324DEEFAXX122")
    private String imei;
    /**
     * 位置
     */
    @ApiComment(value = "位置（长度1-255位）",sample = "广东省广州市天河区五山路321号")
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
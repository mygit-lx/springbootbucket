package com.example.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;

/**
 * POS绑定网点参数
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class BindParam {
    /**
     * 机具IMEI码
     */
    @ApiComment(value = "IMEI码（长度1-32位）",sample = "2324DEEFAXX122")
    private String imei;
    /**
     * 归属网点
     */
    @ApiComment(value = "归属网点（长度1-64位）",sample = "昆明市公安局交通警察支队车辆管理所")
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

package com.example.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;
/**
 * APP版本检查接口参数
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class VersionParam {
    /**
     * 机具IMEI码
     */
    @ApiComment(value = "IMEI码", sample = "2324DEEFAXX122")
    private String imei;
    /**
     * 应用ID
     */
    @ApiComment(value = "APP应用ID，每个APP都有唯一的Application Id", sample = "com.xncoding.xzpay")
    private String applicationId;
    /**
     * 当前版本号
     */
    @ApiComment(value = "APP的当前版本号", sample = "1.2.0")
    private String version;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
}

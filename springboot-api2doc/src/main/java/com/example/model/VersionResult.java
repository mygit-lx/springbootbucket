package com.example.model;

import com.terran4j.commons.api2doc.annotations.ApiComment;

import java.util.Date;

/**
 * 版本检查结果
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class VersionResult {
    /**
     * 是否发现新版本
     */
    @ApiComment(value = "是否发现新版本(true:发现新版本，false:没有发现新版本)", sample =  "true")
    private boolean findNew;
    /**
     * APP名称
     */
    @ApiComment(value = "APP名称", sample = "行政收费")
    private String appName;
    /**
     * 新版本号
     */
    @ApiComment(value = "新版本号", sample = "v1.3.8")
    private String version;
    /**
     * 新版本说明
     */
    @ApiComment(value = "新版本说明", sample = "增加人脸识别功能")
    private String tips;
    /**
     * 新版本发布时间
     */
    @ApiComment(value = "新版本发布时间",sample = "2017-12-24 12:32:19")
    private Date publishtime;

    /**
     * 新版本下载地址
     */
    @ApiComment(value = "新版本下载地址",sample = "http://xncoding.net/files/行政收费_1.3.0.apk")
    private String downloadUrl;

    public boolean isFindNew() {
        return findNew;
    }

    public void setFindNew(boolean findNew) {
        this.findNew = findNew;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public Date getPublishtime() {
        return publishtime;
    }

    public void setPublishtime(Date publishtime) {
        this.publishtime = publishtime;
    }
}
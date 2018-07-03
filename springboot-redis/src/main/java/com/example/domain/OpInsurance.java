package com.example.domain;

import java.math.BigDecimal;
import java.util.Date;

public class OpInsurance {
    private Integer id;

    private String trade;

    private String orderId;

    private String insureUser;

    private String insurant;

    private String insureCity;

    private String outOrderStatus;

    private String busiOrderNumber;

    private BigDecimal busiAmount;

    private String ctaliOrderNumber;

    private BigDecimal ctaliAmount;

    private Boolean delFlag;

    private Date createdTime;

    private Date updatedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade == null ? null : trade.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String flowId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getInsureUser() {
        return insureUser;
    }

    public void setInsureUser(String insureUser) {
        this.insureUser = insureUser == null ? null : insureUser.trim();
    }

    public String getInsurant() {
        return insurant;
    }

    public void setInsurant(String insurant) {
        this.insurant = insurant == null ? null : insurant.trim();
    }

    public String getInsureCity() {
        return insureCity;
    }

    public void setInsureCity(String insureCity) {
        this.insureCity = insureCity == null ? null : insureCity.trim();
    }

    public String getOutOrderStatus() {
        return outOrderStatus;
    }

    public void setOutOrderStatus(String outOrderStatus) {
        this.outOrderStatus = outOrderStatus;
    }

    public String getBusiOrderNumber() {
        return busiOrderNumber;
    }

    public void setBusiOrderNumber(String busiOrderNumber) {
        this.busiOrderNumber = busiOrderNumber == null ? null : busiOrderNumber.trim();
    }

    public BigDecimal getBusiAmount() {
        return busiAmount;
    }

    public void setBusiAmount(BigDecimal busiAmount) {
        this.busiAmount = busiAmount;
    }

    public String getCtaliOrderNumber() {
        return ctaliOrderNumber;
    }

    public void setCtaliOrderNumber(String ctaliOrderNumber) {
        this.ctaliOrderNumber = ctaliOrderNumber == null ? null : ctaliOrderNumber.trim();
    }

    public BigDecimal getCtaliAmount() {
        return ctaliAmount;
    }

    public void setCtaliAmount(BigDecimal ctaliAmount) {
        this.ctaliAmount = ctaliAmount;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
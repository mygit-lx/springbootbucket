package com.example.domain;

import java.util.Date;

public class OpBusiness {
    private Integer id;

    private String businessId;

    private String businessName;

    private Boolean state;

    private String businessLogo;

    private String businessRemark;

    private String callbackAddr;

    private String contractOne;

    private String contractTwo;

    private Boolean delFlag;

    private Date createdTime;

    private Date updatedTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName == null ? null : businessName.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo == null ? null : businessLogo.trim();
    }

    public String getBusinessRemark() {
        return businessRemark;
    }

    public void setBusinessRemark(String businessRemark) {
        this.businessRemark = businessRemark == null ? null : businessRemark.trim();
    }

    public String getCallbackAddr() {
        return callbackAddr;
    }

    public void setCallbackAddr(String callbackAddr) {
        this.callbackAddr = callbackAddr == null ? null : callbackAddr.trim();
    }

    public String getContractOne() {
        return contractOne;
    }

    public void setContractOne(String contractOne) {
        this.contractOne = contractOne == null ? null : contractOne.trim();
    }

    public String getContractTwo() {
        return contractTwo;
    }

    public void setContractTwo(String contractTwo) {
        this.contractTwo = contractTwo == null ? null : contractTwo.trim();
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
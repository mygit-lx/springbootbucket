package com.example.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <p>
 * ${title} <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V1.0.0 6/28/18 3:12 PM luoxiang 初版<br>
 * <p>
 * Copyright (c) 2017，2117,北京桔子分期电子商务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@Entity
@Table(name = "op_business", schema = "iou", catalog = "")
public class OpBusinessEntity {
    private int id;
    private String businessId;
    private String businessName;
    private Integer state;
    private String appid;
    private Integer appidState;
    private String businessLogo;
    private String businessRemark;
    private String callbackAddr;
    private String contractOne;
    private String contractTwo;
    private Integer delFlag;
    private Timestamp createdTime;
    private Timestamp updatedTime;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "business_id", nullable = true, length = 18)
    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    @Basic
    @Column(name = "business_name", nullable = true, length = 15)
    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "appid", nullable = true, length = 25)
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    @Basic
    @Column(name = "appid_state", nullable = true)
    public Integer getAppidState() {
        return appidState;
    }

    public void setAppidState(Integer appidState) {
        this.appidState = appidState;
    }

    @Basic
    @Column(name = "business_logo", nullable = true, length = 255)
    public String getBusinessLogo() {
        return businessLogo;
    }

    public void setBusinessLogo(String businessLogo) {
        this.businessLogo = businessLogo;
    }

    @Basic
    @Column(name = "business_remark", nullable = true, length = 255)
    public String getBusinessRemark() {
        return businessRemark;
    }

    public void setBusinessRemark(String businessRemark) {
        this.businessRemark = businessRemark;
    }

    @Basic
    @Column(name = "callback_addr", nullable = true, length = 512)
    public String getCallbackAddr() {
        return callbackAddr;
    }

    public void setCallbackAddr(String callbackAddr) {
        this.callbackAddr = callbackAddr;
    }

    @Basic
    @Column(name = "contract_one", nullable = true, length = 512)
    public String getContractOne() {
        return contractOne;
    }

    public void setContractOne(String contractOne) {
        this.contractOne = contractOne;
    }

    @Basic
    @Column(name = "contract_two", nullable = true, length = 512)
    public String getContractTwo() {
        return contractTwo;
    }

    public void setContractTwo(String contractTwo) {
        this.contractTwo = contractTwo;
    }

    @Basic
    @Column(name = "del_flag", nullable = true)
    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Basic
    @Column(name = "created_time", nullable = true)
    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    @Basic
    @Column(name = "updated_time", nullable = true)
    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpBusinessEntity that = (OpBusinessEntity) o;

        if (id != that.id) return false;
        if (businessId != null ? !businessId.equals(that.businessId) : that.businessId != null) return false;
        if (businessName != null ? !businessName.equals(that.businessName) : that.businessName != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (appid != null ? !appid.equals(that.appid) : that.appid != null) return false;
        if (appidState != null ? !appidState.equals(that.appidState) : that.appidState != null) return false;
        if (businessLogo != null ? !businessLogo.equals(that.businessLogo) : that.businessLogo != null) return false;
        if (businessRemark != null ? !businessRemark.equals(that.businessRemark) : that.businessRemark != null)
            return false;
        if (callbackAddr != null ? !callbackAddr.equals(that.callbackAddr) : that.callbackAddr != null) return false;
        if (contractOne != null ? !contractOne.equals(that.contractOne) : that.contractOne != null) return false;
        if (contractTwo != null ? !contractTwo.equals(that.contractTwo) : that.contractTwo != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;
        if (updatedTime != null ? !updatedTime.equals(that.updatedTime) : that.updatedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (businessId != null ? businessId.hashCode() : 0);
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (appid != null ? appid.hashCode() : 0);
        result = 31 * result + (appidState != null ? appidState.hashCode() : 0);
        result = 31 * result + (businessLogo != null ? businessLogo.hashCode() : 0);
        result = 31 * result + (businessRemark != null ? businessRemark.hashCode() : 0);
        result = 31 * result + (callbackAddr != null ? callbackAddr.hashCode() : 0);
        result = 31 * result + (contractOne != null ? contractOne.hashCode() : 0);
        result = 31 * result + (contractTwo != null ? contractTwo.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}

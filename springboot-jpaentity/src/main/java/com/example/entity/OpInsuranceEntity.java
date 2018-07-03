package com.example.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * <p>
 * ${title} <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V1.0.0 6/28/18 3:13 PM luoxiang 初版<br>
 * <p>
 * Copyright (c) 2017，2117,北京桔子分期电子商务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@Entity
@Table(name = "op_insurance", schema = "iou", catalog = "")
public class OpInsuranceEntity {
    private int id;
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
    @Column(name = "trade", nullable = false, length = 25)
    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    @Basic
    @Column(name = "order_id", nullable = true, length = 25)
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "insure_user", nullable = true, length = 15)
    public String getInsureUser() {
        return insureUser;
    }

    public void setInsureUser(String insureUser) {
        this.insureUser = insureUser;
    }

    @Basic
    @Column(name = "insurant", nullable = true, length = 15)
    public String getInsurant() {
        return insurant;
    }

    public void setInsurant(String insurant) {
        this.insurant = insurant;
    }

    @Basic
    @Column(name = "insure_city", nullable = false, length = 15)
    public String getInsureCity() {
        return insureCity;
    }

    public void setInsureCity(String insureCity) {
        this.insureCity = insureCity;
    }

    @Basic
    @Column(name = "out_order_status", nullable = true, length = 10)
    public String getOutOrderStatus() {
        return outOrderStatus;
    }

    public void setOutOrderStatus(String outOrderStatus) {
        this.outOrderStatus = outOrderStatus;
    }

    @Basic
    @Column(name = "busi_order_number", nullable = true, length = 15)
    public String getBusiOrderNumber() {
        return busiOrderNumber;
    }

    public void setBusiOrderNumber(String busiOrderNumber) {
        this.busiOrderNumber = busiOrderNumber;
    }

    @Basic
    @Column(name = "busi_amount", nullable = true, precision = 2)
    public BigDecimal getBusiAmount() {
        return busiAmount;
    }

    public void setBusiAmount(BigDecimal busiAmount) {
        this.busiAmount = busiAmount;
    }

    @Basic
    @Column(name = "ctali_order_number", nullable = true, length = 15)
    public String getCtaliOrderNumber() {
        return ctaliOrderNumber;
    }

    public void setCtaliOrderNumber(String ctaliOrderNumber) {
        this.ctaliOrderNumber = ctaliOrderNumber;
    }

    @Basic
    @Column(name = "ctali_amount", nullable = true, precision = 2)
    public BigDecimal getCtaliAmount() {
        return ctaliAmount;
    }

    public void setCtaliAmount(BigDecimal ctaliAmount) {
        this.ctaliAmount = ctaliAmount;
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

        OpInsuranceEntity that = (OpInsuranceEntity) o;

        if (id != that.id) return false;
        if (trade != null ? !trade.equals(that.trade) : that.trade != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (insureUser != null ? !insureUser.equals(that.insureUser) : that.insureUser != null) return false;
        if (insurant != null ? !insurant.equals(that.insurant) : that.insurant != null) return false;
        if (insureCity != null ? !insureCity.equals(that.insureCity) : that.insureCity != null) return false;
        if (outOrderStatus != null ? !outOrderStatus.equals(that.outOrderStatus) : that.outOrderStatus != null)
            return false;
        if (busiOrderNumber != null ? !busiOrderNumber.equals(that.busiOrderNumber) : that.busiOrderNumber != null)
            return false;
        if (busiAmount != null ? !busiAmount.equals(that.busiAmount) : that.busiAmount != null) return false;
        if (ctaliOrderNumber != null ? !ctaliOrderNumber.equals(that.ctaliOrderNumber) : that.ctaliOrderNumber != null)
            return false;
        if (ctaliAmount != null ? !ctaliAmount.equals(that.ctaliAmount) : that.ctaliAmount != null) return false;
        if (delFlag != null ? !delFlag.equals(that.delFlag) : that.delFlag != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;
        if (updatedTime != null ? !updatedTime.equals(that.updatedTime) : that.updatedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (trade != null ? trade.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (insureUser != null ? insureUser.hashCode() : 0);
        result = 31 * result + (insurant != null ? insurant.hashCode() : 0);
        result = 31 * result + (insureCity != null ? insureCity.hashCode() : 0);
        result = 31 * result + (outOrderStatus != null ? outOrderStatus.hashCode() : 0);
        result = 31 * result + (busiOrderNumber != null ? busiOrderNumber.hashCode() : 0);
        result = 31 * result + (busiAmount != null ? busiAmount.hashCode() : 0);
        result = 31 * result + (ctaliOrderNumber != null ? ctaliOrderNumber.hashCode() : 0);
        result = 31 * result + (ctaliAmount != null ? ctaliAmount.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}

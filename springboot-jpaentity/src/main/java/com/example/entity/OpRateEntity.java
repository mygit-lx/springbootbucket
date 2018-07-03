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
@Table(name = "op_rate", schema = "iou", catalog = "")
public class OpRateEntity {
    private int id;
    private String businessId;
    private String businessName;
    private String parentName;
    private String prductId;
    private String productName;
    private Integer period;
    private BigDecimal monthRate;
    private Integer enabled;
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
    @Column(name = "parent_name", nullable = true, length = 50)
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Basic
    @Column(name = "prduct_id", nullable = true, length = 50)
    public String getPrductId() {
        return prductId;
    }

    public void setPrductId(String prductId) {
        this.prductId = prductId;
    }

    @Basic
    @Column(name = "product_name", nullable = true, length = 50)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "period", nullable = true)
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Basic
    @Column(name = "month_rate", nullable = true, precision = 8)
    public BigDecimal getMonthRate() {
        return monthRate;
    }

    public void setMonthRate(BigDecimal monthRate) {
        this.monthRate = monthRate;
    }

    @Basic
    @Column(name = "enabled", nullable = true)
    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
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

        OpRateEntity that = (OpRateEntity) o;

        if (id != that.id) return false;
        if (businessId != null ? !businessId.equals(that.businessId) : that.businessId != null) return false;
        if (businessName != null ? !businessName.equals(that.businessName) : that.businessName != null) return false;
        if (parentName != null ? !parentName.equals(that.parentName) : that.parentName != null) return false;
        if (prductId != null ? !prductId.equals(that.prductId) : that.prductId != null) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (period != null ? !period.equals(that.period) : that.period != null) return false;
        if (monthRate != null ? !monthRate.equals(that.monthRate) : that.monthRate != null) return false;
        if (enabled != null ? !enabled.equals(that.enabled) : that.enabled != null) return false;
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) return false;
        if (updatedTime != null ? !updatedTime.equals(that.updatedTime) : that.updatedTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (businessId != null ? businessId.hashCode() : 0);
        result = 31 * result + (businessName != null ? businessName.hashCode() : 0);
        result = 31 * result + (parentName != null ? parentName.hashCode() : 0);
        result = 31 * result + (prductId != null ? prductId.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (period != null ? period.hashCode() : 0);
        result = 31 * result + (monthRate != null ? monthRate.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}

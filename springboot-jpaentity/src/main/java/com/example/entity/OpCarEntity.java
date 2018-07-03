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
 * V1.0.0 6/28/18 3:13 PM luoxiang 初版<br>
 * <p>
 * Copyright (c) 2017，2117,北京桔子分期电子商务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@Entity
@Table(name = "op_car", schema = "iou", catalog = "")
public class OpCarEntity {
    private int id;
    private String trade;
    private String orderId;
    private String owner;
    private String address;
    private String plateLicense;
    private String carType;
    private String useNature;
    private String brandModel;
    private String identifyCode;
    private String engineNumber;
    private Timestamp registDate;
    private Timestamp certificateDate;
    private String drivingLicenseImage;
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
    @Column(name = "owner", nullable = true, length = 15)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "plate_license", nullable = true, length = 10)
    public String getPlateLicense() {
        return plateLicense;
    }

    public void setPlateLicense(String plateLicense) {
        this.plateLicense = plateLicense;
    }

    @Basic
    @Column(name = "car_type", nullable = true, length = 15)
    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Basic
    @Column(name = "use_nature", nullable = true, length = 15)
    public String getUseNature() {
        return useNature;
    }

    public void setUseNature(String useNature) {
        this.useNature = useNature;
    }

    @Basic
    @Column(name = "brand_model", nullable = true, length = 15)
    public String getBrandModel() {
        return brandModel;
    }

    public void setBrandModel(String brandModel) {
        this.brandModel = brandModel;
    }

    @Basic
    @Column(name = "identify_code", nullable = true, length = 10)
    public String getIdentifyCode() {
        return identifyCode;
    }

    public void setIdentifyCode(String identifyCode) {
        this.identifyCode = identifyCode;
    }

    @Basic
    @Column(name = "engine_number", nullable = true, length = 15)
    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    @Basic
    @Column(name = "regist_date", nullable = true)
    public Timestamp getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Timestamp registDate) {
        this.registDate = registDate;
    }

    @Basic
    @Column(name = "certificate_date", nullable = true)
    public Timestamp getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Timestamp certificateDate) {
        this.certificateDate = certificateDate;
    }

    @Basic
    @Column(name = "driving_license_image", nullable = true, length = 50)
    public String getDrivingLicenseImage() {
        return drivingLicenseImage;
    }

    public void setDrivingLicenseImage(String drivingLicenseImage) {
        this.drivingLicenseImage = drivingLicenseImage;
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

        OpCarEntity that = (OpCarEntity) o;

        if (id != that.id) return false;
        if (trade != null ? !trade.equals(that.trade) : that.trade != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (owner != null ? !owner.equals(that.owner) : that.owner != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (plateLicense != null ? !plateLicense.equals(that.plateLicense) : that.plateLicense != null) return false;
        if (carType != null ? !carType.equals(that.carType) : that.carType != null) return false;
        if (useNature != null ? !useNature.equals(that.useNature) : that.useNature != null) return false;
        if (brandModel != null ? !brandModel.equals(that.brandModel) : that.brandModel != null) return false;
        if (identifyCode != null ? !identifyCode.equals(that.identifyCode) : that.identifyCode != null) return false;
        if (engineNumber != null ? !engineNumber.equals(that.engineNumber) : that.engineNumber != null) return false;
        if (registDate != null ? !registDate.equals(that.registDate) : that.registDate != null) return false;
        if (certificateDate != null ? !certificateDate.equals(that.certificateDate) : that.certificateDate != null)
            return false;
        if (drivingLicenseImage != null ? !drivingLicenseImage.equals(that.drivingLicenseImage) : that.drivingLicenseImage != null)
            return false;
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
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (plateLicense != null ? plateLicense.hashCode() : 0);
        result = 31 * result + (carType != null ? carType.hashCode() : 0);
        result = 31 * result + (useNature != null ? useNature.hashCode() : 0);
        result = 31 * result + (brandModel != null ? brandModel.hashCode() : 0);
        result = 31 * result + (identifyCode != null ? identifyCode.hashCode() : 0);
        result = 31 * result + (engineNumber != null ? engineNumber.hashCode() : 0);
        result = 31 * result + (registDate != null ? registDate.hashCode() : 0);
        result = 31 * result + (certificateDate != null ? certificateDate.hashCode() : 0);
        result = 31 * result + (drivingLicenseImage != null ? drivingLicenseImage.hashCode() : 0);
        result = 31 * result + (delFlag != null ? delFlag.hashCode() : 0);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (updatedTime != null ? updatedTime.hashCode() : 0);
        return result;
    }
}

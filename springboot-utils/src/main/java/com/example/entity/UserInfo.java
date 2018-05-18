package com.example.entity;

import java.util.Date;

public class UserInfo {

    /**
     * id : 1
     * borrowerName : 李丽
     * nationality : 中国
     * sex : 1
     * education : 5
     * phone : 13502124452
     * email : test01@163.com
     * idNo : 110254196312016201
     * maritalStatus : 1
     * homeAdress : 北京市海淀区
     * creatTime : 2018-04-03 11:05:30
     */

    private Long id;

    private String borrowerName;

    private String nationality;

    private Integer sex;

    private Integer education;

    private String phone;

    private String email;

    private String idno;

    private Integer maritalStatus;

    private String homeAdress;

    private Date creatTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public void setBorrowerName(String borrowerName) {
        this.borrowerName = borrowerName == null ? null : borrowerName.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno == null ? null : idno.trim();
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress == null ? null : homeAdress.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", borrowerName='" + borrowerName + '\'' +
                ", nationality='" + nationality + '\'' +
                ", sex=" + sex +
                ", education=" + education +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", idno='" + idno + '\'' +
                ", maritalStatus=" + maritalStatus +
                ", homeAdress='" + homeAdress + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }
}
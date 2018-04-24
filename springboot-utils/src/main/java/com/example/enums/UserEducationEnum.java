package com.example.enums;

public enum UserEducationEnum {

    UNKNOEN(0,"未知"),
    PRIMARY(1,"小学"),
    MIDDLE(2,"初中"),
    SENIOR(3,"高中"),
    UNIVERSITY(4,"大学"),
    ELSE(5,"其他");

    private Integer code;
    private String msg;

    private UserEducationEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

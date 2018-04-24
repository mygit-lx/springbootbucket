package com.example.enums;

public enum UserMaritalEnum {

    UNKNOWN(0,"未知"),
    MARRIED(1,"已婚"),
    UNMARRIED(2,"未婚"),
    DISSOCIATON(3,"离异"),
    MISSSPONSE(4,"丧偶");

    private Integer code;
    private String msg;

    private UserMaritalEnum(Integer code, String msg) {
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

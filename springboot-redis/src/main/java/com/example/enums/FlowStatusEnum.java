package com.example.enums;

/**
 * 流水状态
 */
public enum FlowStatusEnum {

    WAIT_ORDER("1","待生成订单"),
    HAS_ORDER("2","已生成订单"),
    FLOW_LOSE("３","交易失效"),
    FLOW_FAIL("４","交易关闭");

    private String status;
    private String msg;

    private FlowStatusEnum(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(String status) {
        for (FlowStatusEnum e : FlowStatusEnum.values()) {
            if (e.getStatus().equals(status)) {
                return e.getMsg();
            }
        }
        return null;
    }

    public static String getCode(String name) {
        for (FlowStatusEnum e : FlowStatusEnum.values()) {
            if (e.getMsg().equals(name)) {
                return e.getStatus();
            }
        }
        return null;
    }
}

package com.example.enums;

/**
 * 流水状态
 */
public enum OrderStatusEnum {

    WAIT_AUDIT("21","待审核"),
    WAIT_REAUDIT("22","交易复核中"),
    ATTESTATION_DISMISSAL("23","认证驳回，已关闭"),
    INSUFFICIENT_AMOUNT("24","额度不足，已关闭"),
    TRANSACTION_DISMISSAL("25","交易驳回，已关闭"),
    AUDIT_SUCCESS("26","审核通过，待出单"),
    ORDER_SUCCESS("27","出单成功，待放款"),
    LOAN_SUCCESS("28","已放款，分期还款中"),
    ORDER_FINISH("29","已完成"),
    ORDER_CANCAL("20","已取消"),
    ATTESTATION_ING("00","认证中");

    private String status;
    private String msg;

    private OrderStatusEnum(String status, String msg) {
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
        for (OrderStatusEnum e : OrderStatusEnum.values()) {
            if (e.getStatus().equals(status)) {
                return e.getMsg();
            }
        }
        return null;
    }

    public static String getCode(String name) {
        for (OrderStatusEnum e : OrderStatusEnum.values()) {
            if (e.getMsg().equals(name)) {
                return e.getStatus();
            }
        }
        return null;
    }
}

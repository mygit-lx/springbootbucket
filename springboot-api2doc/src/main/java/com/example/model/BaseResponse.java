package com.example.model;


import com.terran4j.commons.api2doc.annotations.ApiComment;
/**
 * API接口的基础返回类
 *
 * @author luoxiang
 * @version 1.0
 * @since 2018/3/15
 */
public class BaseResponse<T> {

    /**
     * 是否成功
     */
    @ApiComment(value = "是否成功",sample = "true")
    private boolean success;

    /**
     * 说明
     */
    @ApiComment(value = "返回的详细说明",sample = "成功")
    private String msg;

    /**
     * 返回数据
     */
    @ApiComment(value = "返回的数据",sample = "")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(boolean success, String msg, T data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

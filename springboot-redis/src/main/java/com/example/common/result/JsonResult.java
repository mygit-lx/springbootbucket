package com.example.common.result;


import com.alibaba.fastjson.JSONObject;

public class JsonResult {

    private String msg;
    private boolean success;
    private Object result = new JSONObject();
    private String code;


    public static JsonResult createSuccess() {
        JsonResult jp = new JsonResult();
        jp.setSuccess(true);
        return jp;
    }

    public static JsonResult createSuccess(Object extParams) {
        JsonResult jp = new JsonResult();
        jp.setResult(extParams);
        jp.setSuccess(true);
        return jp;
    }

    public static JsonResult createErrorMsg(String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        return jp;
    }

    public static JsonResult createSuccessMsg(String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        jp.setSuccess(true);
        return jp;
    }

    public static JsonResult createMsg(boolean success, String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        jp.setSuccess(success);
        return jp;
    }

    public static JsonResult createSuccess(Object obj, String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        jp.setSuccess(Boolean.TRUE);
        jp.setResult(obj);
        return jp;
    }

    public static JsonResult createCode(ReturnCode code) {
        JsonResult jp = new JsonResult();
        jp.setMsg(code.getMsg());
        jp.setSuccess(Boolean.TRUE);
        jp.setCode(code.getCode() + "");
        return jp;
    }

    public static JsonResult createCode(ReturnCode code, String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        jp.setSuccess(Boolean.TRUE);
        jp.setCode(code.getCode() + "");
        return jp;
    }

    public static JsonResult createCode(String key, String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        jp.setSuccess(Boolean.TRUE);
        jp.setCode(key);
        return jp;
    }

    public static JsonResult createCode(ReturnCode code, Object obj) {
        JsonResult jp = new JsonResult();
        jp.setMsg(code.getMsg());
        jp.setResult(obj);
        jp.setSuccess(Boolean.TRUE);
        jp.setCode(code.getCode() + "");
        return jp;
    }


    public static JsonResult createSuccessApi(Object obj) {
        JsonResult jp = new JsonResult();
        jp.setMsg(ReturnCode.NOMORE.getMsg());
        jp.setResult(obj);
        jp.setSuccess(Boolean.TRUE);
        jp.setCode(ReturnCode.NOMORE.getCode() + "");
        return jp;
    }


    public static JsonResult createFaildApi() {
        JsonResult jp = new JsonResult();
        jp.setMsg(ReturnCode.EXCEPTION.getMsg());
        jp.setSuccess(Boolean.FALSE);
        jp.setCode(ReturnCode.EXCEPTION.getCode() + "");
        return jp;
    }



    public static JsonResult createFaildApi(String msg) {
        JsonResult jp = new JsonResult();
        jp.setMsg(msg);
        jp.setSuccess(Boolean.FALSE);
        jp.setCode(ReturnCode.EXCEPTION.getCode() + "");
        return jp;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "JsonResult [msg=" + msg + ", success=" + success + ", result=" + result + "]";
    }

}

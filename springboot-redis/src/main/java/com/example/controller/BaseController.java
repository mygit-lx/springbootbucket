package com.example.controller;

import com.example.common.result.JsonResult;
import com.example.common.result.ReturnCode;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
public class BaseController {

    /**
     * <p>
     * 获取HttpServletRequest
     *
     * @author liushouquan
     * @return HttpServletRequest
     * @since XMJR V2.0.2
     * @throws </p>
     */
    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
    }

    public static JsonResult returnSuccess() {
        return JsonResult.createCode(ReturnCode.NOMORE);
    }

    public static JsonResult returnSuccess(Object obj, ReturnCode code) {
        return JsonResult.createCode(code, obj);
    }

    public static JsonResult returnSuccess(Object obj, String msg) {
        return returnSuccess(obj);
    }


    public static JsonResult returnSuccess(Object obj) {
        return JsonResult.createSuccessApi(obj);
    }

    public JsonResult returnFaild(ReturnCode code) {
        return JsonResult.createCode(code);
    }

    public JsonResult returnFaild(String key,String message){

        return JsonResult.createCode(key,message);
    }

    public JsonResult returnFaild() {
        return JsonResult.createFaildApi();
    }

    public JsonResult returnFaild(String msg) {
        return JsonResult.createFaildApi(msg);
    }
}

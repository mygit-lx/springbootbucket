package com.example.controller;

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
}

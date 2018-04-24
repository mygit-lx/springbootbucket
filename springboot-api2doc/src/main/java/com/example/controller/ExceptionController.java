package com.example.controller;

import com.example.model.BaseResponse;
import com.terran4j.commons.api2doc.annotations.Api2Doc;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 注意这个统一异常处理器只对认证过的用户调用接口中的异常有作用，对AuthenticationException没有用
 */
@RestControllerAdvice
@Api2Doc(id = "机具管理接口")
public class ExceptionController {

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse globalException(HttpServletRequest request, Throwable ex) {
        return new BaseResponse(false, "其他异常", null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}

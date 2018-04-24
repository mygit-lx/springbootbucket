package com.example.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义异常处理类
 */
public class MyExceptionResoler implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Object o, Exception e) {
        //如果是shiro无权操作，因为shiro 在操作auno等一部分不进行转发至无权限url
        if(e instanceof UnauthorizedException){
            return new ModelAndView("error/shiro_403");
        }
        return null;
    }
}

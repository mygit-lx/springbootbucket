package com.example.common.filter;

import com.example.common.config.cache.RedisService;
import com.example.common.config.security.PreventRecoverySubmit;
import com.example.util.security.MD5Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class InterceptorConfig  implements HandlerInterceptor, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(InterceptorConfig.class);

    private static final String KEY_PREFIX = "PRS";


    @Autowired
    private RedisService redisService;


    private ObjectMapper objectMapper;

    /**
     * 进入controller层之前拦截请求
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        log.info("---------------------开始进入请求地址拦截----------------------------");
        //HttpSession session = httpServletRequest.getSession();
        //if(!StringUtils.isEmpty(session.getAttribute("userName"))){
        //    return true;
        //}
        //else{
        //    PrintWriter printWriter = httpServletResponse.getWriter();
        //    printWriter.write("{code:0,message:\"session is invalid,please login again!\"}");
        //    return false;
        //}

        String token = getToken(httpServletRequest);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        if (org.apache.commons.lang.StringUtils.isEmpty(token)) {
            httpServletResponse.getWriter().write("{code:1,message:\"token不能为空, 请稍后重试!\"}");
            //JSONUtil.writerHttpMsg(objectMapper, NotDataResult.Failed("您的操作太频繁, 请稍后重试!"), httpServletResponse);
            return false;
        }

        PreventRecoverySubmit recoverySubmit = getPreventRecoverySubmit(o);//获取防重复提交注解对象
        if (recoverySubmit != null) {//如果注解对象不为null，并且请求对象不为空
            String key = getKey(recoverySubmit, o, token);//生成key
            String v = redisService.get(key).toString();
            if (v != null) {
                httpServletResponse.getWriter().write("{code:1,message:\"您的操作太频繁, 请稍后重试!\"}");
                //JSONUtil.writerHttpMsg(objectMapper, NotDataResult.Failed("您的操作太频繁, 请稍后重试!"), httpServletResponse);
                return false;
            }
            int timeout = recoverySubmit.timeout();
            TimeUnit timeUnit = TimeUnit.MINUTES;//时间单位
            if (recoverySubmit.limit() > 0) {//设置了限制多久才能请求一次
                timeout = recoverySubmit.limit();
                timeUnit = recoverySubmit.limitUnit();
            }
            redisService.set(key,o.toString(),timeout,timeUnit);//加入缓存
        }


        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("--------------处理请求完成后视图渲染之前的处理操作---------------");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("---------------视图渲染之后的操作-------------------------0");

        //判断是否设置的请求时间 否则清空缓存
        String token = getToken(httpServletRequest);
        PreventRecoverySubmit recoverySubmit = getPreventRecoverySubmit(o);
        if (recoverySubmit != null && !StringUtils.isEmpty(token)) {
            String key = getKey(recoverySubmit, o, token);
            if (recoverySubmit.limit() < 1) {
                redisService.remove(key);
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        redisService.remove(KEY_PREFIX);
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (token == null)
            token = request.getParameter("token");
        return token;
    }

    private PreventRecoverySubmit getPreventRecoverySubmit(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            return handlerMethod.getMethodAnnotation(PreventRecoverySubmit.class);
        }
        return null;
    }
    /**
     * 生成key
     * @param recoverySubmit
     * @param handler
     * @param token
     * @return
     */
    private String getKey(PreventRecoverySubmit recoverySubmit, Object handler, String token) {
        String key = recoverySubmit.value();
        if (StringUtils.isEmpty(key)) {
            key = MD5Utils.encode(handler.toString());
        }
        return KEY_PREFIX + ":" + token + ":" + key;
    }
}

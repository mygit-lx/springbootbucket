package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 自定义切面 <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V3.0.0 2018年03月07日 luoxiang 初版<br>
 * <p>
 * Copyright (c) 2015，2115,北京小马金融服务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@Aspect
@Component
public class UserAccessAspect {

    @Pointcut(value = "@annotation(com.example.aspect.UserAccess)")
    public void access(){}

    @Before("access()")
    public void deBefore(JoinPoint joinPoint) throws Throwable{
        System.out.println("second before");
    }

    @Around("@annotation(userAccess)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint,UserAccess userAccess){
        //获取注解里的内容
        System.out.println("second arround:"+userAccess.desc());
        try {
            return proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
            return null;
        }
    }
}

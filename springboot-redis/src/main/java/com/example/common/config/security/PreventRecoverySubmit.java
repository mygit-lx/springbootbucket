package com.example.common.config.security;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 用于防止重复提交使用的注解<br>
 * 暂时只用于APP无状态需要认证的请求下，简单说有TOKEN参数才能生效.
 * @author luoxiang
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PreventRecoverySubmit {


    /**
     * 设置重复提交的唯一标识，默认为按方法唯一
     * @return
     */
    @AliasFor("key")
    String value() default "";

    /**
     * 设置重复提交的唯一标识，默认为按方法唯一
     * @return
     */
    @AliasFor("value")
    String key() default "";

    /**
     * 限制多久才能请求一次， 默认为等上次请求成功后就可以立即请求<br>
     * 只能为0以上, 否则为默认效果
     * @return
     */
    int limit() default 0;

    /**
     * 配合(limit)限制多久所使用计数的单位，默认为分钟
     * @return
     */
    TimeUnit limitUnit() default TimeUnit.MINUTES;

    /**
     * 设置请求超时解除限制时间, 单位为分钟, 默认为1分钟<br>
     * 当请求超过这个时间就会自动解开提交限制<br>
     * 如果设置了限制多久请求一次(limit)配置 则该配置会失效
     * @return
     */
    int timeout() default 1;
}

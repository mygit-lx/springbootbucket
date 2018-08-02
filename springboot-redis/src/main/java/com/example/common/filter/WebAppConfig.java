package com.example.common.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * 注册拦截器
 * Created by SYSTEM on 2018/8/2.
 */

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Bean
    public InterceptorConfig getSessionInterceptor() {
        return new InterceptorConfig();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(getSessionInterceptor()).addPathPatterns("/test/**")
                .excludePathPatterns("/**/2");
        //registry.addInterceptor(getSessionInterceptor()).excludePathPatterns("/test/no/2");

        super.addInterceptors(registry);
    }
}

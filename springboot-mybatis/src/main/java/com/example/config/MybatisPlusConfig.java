package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.example.config.properties.DruidProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * <p>
 * MybatisPlus配置<br>
 * @EnableTransactionManagement开启了事务支持。<br>
 * @MapperScan注解扫描DAO类，支持多个包，用逗号隔开。<br>
 * 然后在里面定义了一个数据源的类，另外还定义了分页插件，这个用在分页查询上面，本篇演示还用不到。<br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V3.0.0 2018年03月08日 luoxiang 初版<br>
 * <p>
 * Copyright (c) 2015，2115,北京小马金融服务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
@Configuration
@EnableTransactionManagement(order = 2)
@MapperScan(basePackages = {"com.example.dao.repository"})
public class MybatisPlusConfig {

    @Resource
    private DruidProperties druidProperties;

    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource(){
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}

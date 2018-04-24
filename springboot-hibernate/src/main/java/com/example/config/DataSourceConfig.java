package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.config.properties.DruidProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

/**
 * 数据源配置
 *
 * @author luoxiang
 * @since 2018/3/05 21:58
 */
@Configuration
@EnableTransactionManagement(order = 2)
public class DataSourceConfig {

    @Resource
    private DruidProperties druidProperties;

    /**
     * 单数据源连接池配置
     */
    @Bean
    public DruidDataSource singleDatasource() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }
}

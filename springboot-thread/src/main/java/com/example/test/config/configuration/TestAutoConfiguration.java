package com.example.test.config.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration(value = "testAutoConfiguration")
public class TestAutoConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestAutoConfiguration.class);

    public TestAutoConfiguration() {
        LOGGER.info("创建 TestAutoConfiguration 成功");
    }
}

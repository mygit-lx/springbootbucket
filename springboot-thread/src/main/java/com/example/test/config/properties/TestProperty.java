package com.example.test.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Setter
@Getter
public class TestProperty {

    @Value("${name}")
    private String name;

    @Value("${secret}")
    private String secret;

    @Value("${setup}")
    private Integer setup;

    @Value("${range-int}")
    private Integer rangeInt;

    @Value("${uuid}")
    private String uuid;

    @Value("${domain}")
    private String domain;

    @Value("${user}")
    private String username;

    @Value("${password}")
    private String password;

}

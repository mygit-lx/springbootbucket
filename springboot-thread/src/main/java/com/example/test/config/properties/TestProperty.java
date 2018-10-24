package com.example.test.config.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
//@Setter
//@Getter
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Integer getSetup() {
        return setup;
    }

    public void setSetup(Integer setup) {
        this.setup = setup;
    }

    public Integer getRangeInt() {
        return rangeInt;
    }

    public void setRangeInt(Integer rangeInt) {
        this.rangeInt = rangeInt;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

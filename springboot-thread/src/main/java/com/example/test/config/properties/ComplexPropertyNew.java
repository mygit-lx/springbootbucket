package com.example.test.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * 除了那种内嵌的形式之外,如果说我们只想得到
 * 内嵌类里面的属性或者说只有内嵌类里面有属性,
 * 则我们可以写成以下这种形式,其他的地方都不用变.
 * 这种形式我们称之为relaxed binding
 */
@ConfigurationProperties("test.security")
public class ComplexPropertyNew {

    private String username;
    private String password;
    private List<String> roles;
    private Map<String,String> work;

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
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

    public Map<String, String> getWork() {
        return work;
    }

    public void setWork(Map<String, String> work) {
        this.work = work;
    }
}

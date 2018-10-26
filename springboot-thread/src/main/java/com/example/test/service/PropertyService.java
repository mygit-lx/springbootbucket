package com.example.test.service;

import com.example.test.config.properties.ComplexProperty;
import com.example.test.config.properties.ComplexPropertyNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class PropertyService {

    private final ComplexProperty complexProperty;

    private final ComplexPropertyNew complexPropertyNew;

    @Autowired
    public PropertyService(ComplexProperty complexProperty, ComplexPropertyNew complexPropertyNew) {
        this.complexProperty = complexProperty;
        this.complexPropertyNew = complexPropertyNew;
    }

    public String name(){
        return complexProperty.getName();
    }

    public boolean enabled(){
        return complexProperty.isEnabled();
    }

    public String userName(){
        return complexProperty.getSecurity().getUsername();
    }

    public String password(){
        return complexProperty.getSecurity().getPassword();
    }

    public String roles(){
        StringBuffer stringBuffer = new StringBuffer();
        List<String> roles = complexProperty.getSecurity().getRoles();
        roles.forEach(role -> {
            stringBuffer.append(role).append("-----");
        });
        return stringBuffer.toString();
    }

    public String userNameNew(){
        return complexPropertyNew.getUsername();
    }

    public String passwordNew(){
        return complexPropertyNew.getPassword();
    }

    public String rolesNew(){
        StringBuffer stringBuffer = new StringBuffer();
        List<String> roles = complexPropertyNew.getRoles();
        roles.forEach(role -> {
            stringBuffer.append(role).append("-----");
        });
        return stringBuffer.toString();
    }

    public Map<String, String> work(){
        return complexPropertyNew.getWork();
    }
}

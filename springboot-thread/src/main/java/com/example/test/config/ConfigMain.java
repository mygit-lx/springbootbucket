package com.example.test.config;

import com.example.test.config.properties.PropertyFileReader;
import org.junit.jupiter.api.Test;

/**
 *
 */
public class ConfigMain {

    @Test
    public void test01(){
        String paramError = PropertyFileReader.getItem("100000");
        System.out.println(paramError);
    }
}

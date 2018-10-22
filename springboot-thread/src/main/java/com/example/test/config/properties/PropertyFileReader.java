package com.example.test.config.properties;

import java.util.ResourceBundle;

/**
 *
 */
public class PropertyFileReader {

    public static String getItem(String key){
        return getItem(key,"");
    }

    public static String getItem(String key,String defaultValue){
        ResourceBundle bundle = ResourceBundle.getBundle("config/webresult");
        String value = "";
        try {
            value = new String(bundle.getString(key).getBytes("iso-8859-1"),"gbk");
        }catch (Exception e){
            e.printStackTrace();
        }
        if(value.isEmpty()){
            value = defaultValue;
        }
        return value.trim();
    }
}

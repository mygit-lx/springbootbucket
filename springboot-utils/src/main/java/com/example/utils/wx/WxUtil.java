package com.example.utils.wx;

import com.alibaba.fastjson.JSONObject;
import com.example.config.properties.AppConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * ${title} <br>
 * </p>
 * <p>
 * -----版本-----变更日期-----责任人-----变更内容<br>
 * ─────────────────────────────────────<br>
 * V1.0.0 2018/5/3 13:53 luoxiang 初版<br>
 * <p>
 * Copyright (c) 2017，2117,北京桔子分期电子商务有限公司 All Rights Reserved. LICENSE INFORMATION
 * </p>
 */
public class WxUtil {

    /**
     *
     * @param code 识别得到用户id必须的一个值
     * 得到网页授权凭证和用户id
     * @return
     */
    public static Map<String,Object> oauth2GetOpenid(String code) {
        String appid = AppConfig.appId;//自己的配置appid
        String appsecret = AppConfig.appSecret;//自己的配置APPSECRET;
        String requestUrl = AppConfig.GetPageAccessTokenUrl.replace("APPID", appid).replace("SECRET", appsecret).replace("CODE", code);
        HttpClient client = null;
        Map<String,Object> result =new HashMap<String,Object>();
        try {
            client = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(requestUrl);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(httpget, responseHandler);
            JSONObject OpenidJSONO=JSONObject.parseObject(response);

            //OpenidJSONO可以得到的内容：access_token expires_in  refresh_token openid scope

            String Openid =String.valueOf(OpenidJSONO.get("openid"));
            String AccessToken=String.valueOf(OpenidJSONO.get("access_token"));
            String Scope=String.valueOf(OpenidJSONO.get("scope"));//用户保存的作用域
            String refresh_token=String.valueOf(OpenidJSONO.get("refresh_token"));

            result.put("Openid", Openid);
            result.put("AccessToken", AccessToken);
            result.put("scope",Scope);
            result.put("refresh_token", refresh_token);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
        return result;
    }
}

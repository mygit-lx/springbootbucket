package com.example.utils.http;

import com.alibaba.fastjson.JSONObject;
import com.example.utils.StringUtil;
import com.example.utils.encrypt.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * Http请求工具类
 * Created by luoxiang on 2018-4-27.
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public final static String CHARSETNAME = "UTF-8";

    /**
     * 发送json请求数据
     * @param url
     * @param param
     * @param _charsetName
     * @param key
     * @return
     */
    public static String postJson(String url, Map<String,Object> param, String _charsetName,String key) {

        String sign = MD5Util.encode(StringUtil.getSign(param).append("key=").append(key).toString()).toUpperCase();
        param.put("sign",sign);
        String paramJson = JSONObject.toJSON(param).toString();
        logger.info("请求参数:{}", paramJson);

        String charsetName = null;
        if (StringUtils.isEmpty(_charsetName)) {
            charsetName = CHARSETNAME;
        } else {
            charsetName = _charsetName;
        }
        // 实例化httpClient
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 实例化post方法
        HttpPost httpPost = new HttpPost(url);
        StringEntity reqEntity = new StringEntity(paramJson, charsetName);
        reqEntity.setContentType("application/json; charset=" + charsetName);
        httpPost.setEntity(reqEntity);

        String content = "";
        try {
            // 执行post方法
            CloseableHttpResponse response = httpclient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                content = EntityUtils.toString(response.getEntity(), charsetName);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}


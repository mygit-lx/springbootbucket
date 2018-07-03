package com.example.util.http;

import org.apache.log4j.Logger;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

public class ServiceRequest {
	private static Logger log = Logger.getLogger(ServiceRequest.class);
    private String defaultContentEncoding;

    public ServiceRequest() {
        defaultContentEncoding = "UTF-8";
    }

    public String getDefaultContentEncoding() {
        return defaultContentEncoding;
    }

    public ServiceResponse sendGet(String urlString) throws IOException {
        return send(urlString, "GET", null, null);
    }

    public ServiceResponse sendGet(String urlString, Map<String, String> params) throws IOException {
        return send(urlString, "GET", params, null);
    }

    public ServiceResponse sendGet(String urlString, Map<String, String> params,
            Map<String, String> propertys) throws IOException {
        return send(urlString, "GET", params, propertys);
    }

    public ServiceResponse sendPost(String urlString) throws IOException {
        return send(urlString, "POST", null, null);
    }

    public ServiceResponse sendPost(String urlString, Map<String, String> params)
            throws IOException {
        return send(urlString, "POST", params, null);
    }

    public ServiceResponse sendPost(String urlString, Map<String, String> params,
            Map<String, String> propertys) throws IOException {
        return send(urlString, "POST", params, propertys);
    }

    public void setDefaultContentEncoding(String defaultContentEncoding) {
        this.defaultContentEncoding = defaultContentEncoding;
    }

    private ServiceResponse makeContent(String urlString, HttpURLConnection urlConnection)
            throws IOException {
        ServiceResponse httpResponser = new ServiceResponse();
        try {
            String ecod = urlConnection.getContentEncoding();
            if (ecod == null) {
                ecod = defaultContentEncoding;
            }
            InputStream in = urlConnection.getInputStream();
            BufferedInputStream bufferin=new BufferedInputStream(in);
            ByteArrayOutputStream resout=new ByteArrayOutputStream();
            int read=-1;
            byte[] indata=new byte[512];
            while((read=bufferin.read(indata))!=-1)
            {
                resout.write(indata, 0, read);
            }
            byte[] datas=resout.toByteArray();
            bufferin.close();
            resout.close();
            httpResponser.urlString = urlString;
            httpResponser.defaultPort = urlConnection.getURL().getDefaultPort();
            httpResponser.file = urlConnection.getURL().getFile();
            httpResponser.host = urlConnection.getURL().getHost();
            httpResponser.path = urlConnection.getURL().getPath();
            httpResponser.port = urlConnection.getURL().getPort();
            httpResponser.protocol = urlConnection.getURL().getProtocol();
            httpResponser.query = urlConnection.getURL().getQuery();
            httpResponser.ref = urlConnection.getURL().getRef();
            httpResponser.userInfo = urlConnection.getURL().getUserInfo();
            httpResponser.content = new String(datas, ecod);
            httpResponser.contentEncoding = ecod;
            httpResponser.code = urlConnection.getResponseCode();
            httpResponser.message = urlConnection.getResponseMessage();
            httpResponser.contentType = urlConnection.getContentType();
            httpResponser.method = urlConnection.getRequestMethod();
            httpResponser.connectTimeout = urlConnection.getConnectTimeout();
            httpResponser.readTimeout = urlConnection.getReadTimeout();

            return httpResponser;
        } catch (IOException e) {
            throw e;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    private ServiceResponse send(String urlString, String method, Map<String, String> parameters,
            Map<String, String> propertys) throws IOException {
        HttpURLConnection urlConnection = null;

        if (method.equalsIgnoreCase("GET") && parameters != null) {
            StringBuffer param = new StringBuffer();
            int i = 0;
            for (String key : parameters.keySet()) {
                if (i == 0) {
                    param.append("?");
                } else {
                    param.append("&");
                }
                param.append(key).append("=").append(parameters.get(key));
                i++;
            }
            urlString += param;
        }
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("Content-Type",
                "application/x-www-form-urlencoded; charset=UTF-8");
        urlConnection.setRequestMethod(method);
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);
        if (propertys != null) {
            for (String key : propertys.keySet()) {
                urlConnection.addRequestProperty(key, propertys.get(key));
            }
        }

        if (method.equalsIgnoreCase("POST") && parameters != null) {
            StringBuffer param = new StringBuffer();
            int i = 0;
            for (String key : parameters.keySet()) {
                if (i != 0) {
                    param.append("&");
                    i++;
                }
                param.append(key).append("=").append(URLEncoder.encode(parameters.get(key), "UTF-8"));
            }
            log.error(param.toString());
            urlConnection.getOutputStream().write(param.toString().getBytes("UTF-8"));
            urlConnection.getOutputStream().flush();
            urlConnection.getOutputStream().close();
        }

        return makeContent(urlString, urlConnection);
    }
}

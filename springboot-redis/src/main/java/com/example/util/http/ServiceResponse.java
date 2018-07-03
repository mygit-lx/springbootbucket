package com.example.util.http;

import java.util.Vector;

public class ServiceResponse {

    String urlString;

    int defaultPort;

    String file;

    String host;

    String path;

    int port;

    String protocol;

    String query;

    String ref;

    String userInfo;

    String contentEncoding;

    String content;

    String contentType;

    int code;

    String message;

    String method;

    int connectTimeout;

    int readTimeout;

    Vector<String> contentCollection;

    public int getCode() {
        return code;
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public String getContent() {
        return content;
    }

    public Vector<String> getContentCollection() {
        return contentCollection;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public String getContentType() {
        return contentType;
    }

    public int getDefaultPort() {
        return defaultPort;
    }

    public String getFile() {
        return file;
    }

    public String getHost() {
        return host;
    }

    public String getMessage() {
        return message;
    }

    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getPort() {
        return port;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getQuery() {
        return query;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public String getRef() {
        return ref;
    }

    public String getUrlString() {
        return urlString;
    }

    public String getUserInfo() {
        return userInfo;
    }

}

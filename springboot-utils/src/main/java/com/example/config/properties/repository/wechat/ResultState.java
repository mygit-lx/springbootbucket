package com.example.config.properties.repository.wechat;

/**
 * 微信API返回状态
 *
 * @author phil
 * @date 2017年7月2日
 *
 */
public class ResultState extends AbstractResult {

    private static final long serialVersionUID = 1692432930341768342L;
    private int errcode; // 状态
    private String errmsg; //信息
}

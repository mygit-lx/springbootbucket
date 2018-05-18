package com.example.config.properties;

public class AppConfig {

    public final static String appId = "wx8c503bf33301014d ";

    public final static String appSecret = "296c5bbee271d3593d9ed64512e5d308 ";

    // 网页授权获取code
    public final static String GetPageCode = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=URL&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";

    // 网页授权接口
    public final static String GetPageAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    // 网页授权得到用户基本信息接口
    public final static String GetPageUsersUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
}

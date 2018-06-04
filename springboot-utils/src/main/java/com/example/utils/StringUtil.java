package com.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 字符串转换
 * Created by luoxiang on 2018-4-27.
 */
public class StringUtil {

    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 参数签名中按键值对中键名称的ASCII按从小到大的顺序排序
     * @param params
     * @return
     */
    public static StringBuilder getSign(Map<String, Object> params) {
        Map<String, Object> sortMap = new TreeMap<String, Object>();
        sortMap.putAll(params);
        // 以k1=v1&k2=v2...方式拼接参数
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Object> s : sortMap.entrySet()) {
            String k = s.getKey();
            String v = s.getValue()+"";
            if (StringUtils.isBlank(v)) {// 过滤空值
                continue;
            }
            builder.append(k).append("=").append(v).append("&");
        }
        if (!sortMap.isEmpty()) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder;
    }

    /**
     * 获取现在时间
     * @return返回字符串格式yyyyMMddHHmmss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        System.out.println("TIME:::"+dateString);
        return dateString;
    }
    /**
     * 由年月日时分秒+3位随机数
     * 生成流水号
     * @return
     */
    public static String Getnum(){
        String t = getStringDate();
        int x=(int)(Math.random()*900)+100;
        String serial = t + x;
        return serial;
    }


    /**
     * 生成UUID字符串
     *
     * @return 32位的UUID密钥
     */
    public static String getUUID() throws Exception{
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
        logger.debug("获取32位的UUID的调试日志-->>" + uuid);
        return uuid;
    }

    //主方法测试
    public static void main(String[] args) {
        String m= Getnum();
        System.out.println(m);


        String str= "尊敬的{0}，你好。很高兴来到{1}，此次为您服务的是{2}，祝您旅途愉快！";
        String format = MessageFormat.format(str, "罗祥", "巴厘岛", "刘毅向导");
        System.out.println(format);
    }
}

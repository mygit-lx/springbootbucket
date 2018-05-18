package com.example.utils;

import com.example.utils.encrypt.MD5Util;
import org.apache.commons.lang3.StringUtils;

import java.util.*;


public class Des {

    /**
     * 参数签名中按键值对中键名称的ASCII按从小到大的顺序排序
     * @param params
     * @return
     */
    public static String getSign(Map<String, Object> params) {
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
        return builder.toString();
    }

    /**
     * MD5生成签名字符串
     *
     * @param map
     *            需签名参数
     * @param key
     *            MD5key
     * @return
     */
    public static String MD5sign(Map<String, Object> map, String key) {
        String genSign = "";
        try {
            String data = getSign(map)+"key=" + key;
            System.out.println(data);
            genSign = MD5Util.encode(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return genSign;
    }

    /**
     * MD5验证签名
     * @param map
     * @param key
     * @param sign
     * @return
     */
    public static void vlidateMD5sign(Map<String ,Object> map,String key,String sign) {
        String vsign=MD5sign(map, key);
        System.out.println("MD5验证签名生成的签名："+vsign);
        System.out.println("MD5验证签名生成的签名与原签名是否一致：sign=vsign true?false:"+(vsign.equals(sign)));
    }

    public static void main(String[] args) {

        Map<String ,Object> map=new HashMap<String,Object>();
        map.put("address", "北京上地三街9号");
        map.put("empty_plot", 56);
        map.put("lat", 32.466666);
        map.put("lng", "123.994449");
        map.put("name", "北京上地三街9号院停车场");
        map.put("park_id",1001);
        map.put("phone","13899884433");
        map.put("total_plot",90);
        map.put("rand","0.20354312785198048");
        map.put("union_id",10001);
        /***MD5签名与验签**/
        String key="NQ0eSXs720170114";
        String sign= MD5sign(map,key);
        System.out.println("生成的MD5签名："+sign);
        vlidateMD5sign(map, key, sign) ;
    }
}

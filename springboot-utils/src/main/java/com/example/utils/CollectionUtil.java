package com.example.utils;


import java.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

/**
 * 集合操作类
 */
public class CollectionUtil {

    /**
     * 将map<string,object> 转成 map<string,string> 类型
     */
    public static Map<String, String> mapObjectToMap(Map<String, Object> map, String key) {
        Map<String, String> value = null;
        if (map.containsKey(key) && map.get(key) != null) {
            value = (Map<String, String>) map.get(key);
        }
        return value;
    }

    /**
     * jsonString to ArrayList
     *
     * @param rsContent
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> jsonStringToList(String rsContent) throws Exception {
        JSONArray arry = JSONArray.fromObject(rsContent);


        // System.out.println("json字符串内容如下");
        // System.out.println(arry);
        List<Map<String, Object>> rsList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < arry.size(); i++) {
            JSONObject jsonObject = arry.getJSONObject(i);
            Map<String, Object> map = new HashMap<String, Object>();
            for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
                String key = (String) iter.next();
                String value = jsonObject.get(key).toString();
                map.put(key, value);
            }
            rsList.add(map);
        }
        return rsList;
    }

    /**
     * jsonString 转 HashMap
     *
     * @param rsContent
     * @return
     */
    public static Map<String, Object> jsonStringToMap(String rsContent) {
        JSONObject jsonObject = JSONObject.fromObject(rsContent);
        Map<String, Object> map = new HashMap<String, Object>();
        for (Iterator<?> iter = jsonObject.keys(); iter.hasNext();) {
            String key = (String) iter.next();
            String value = jsonObject.get(key).toString();
            map.put(key, value);
        }


        return map;
    }

    /**
     * 通过request获取请求参赛，返回map
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, Object> requestToMap(HttpServletRequest request) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        Map requestParams = request.getParameterMap(); // 支付宝返回的支付结果
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            // e0994e42e7c1c30d94d0420f4134cb3d
            // K1ib4bQbOykKV3vTWE19azOAJnVw6bZt4v%252BwNO%252BpgHaN9w%253D%253D
            // valueStr = new String(valueStr.getBytes("ISO-8859-1"), "UTF-8");
            params.put(name, valueStr);
        }
        return params;


    }
}

package com.example.util;

import com.example.domain.City;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
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

    /**
     * 获取系统流水号---若欲指定返回值的长度or是否全由数字组成等
     * @return 长度为20的全数字
     */
    public static String getSysJournalNo(){
        return getSysJournalNo(20, true);
    }


    /**
     * 获取系统流水号
     * @param length   指定流水号长度
     * @param isNumber 指定流水号是否全由数字组成
     */
    public static String getSysJournalNo(int length, boolean isNumber){
        //replaceAll()之后返回的是一个由十六进制形式组成的且长度为32的字符串
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        if(uuid.length() > length){
            uuid = uuid.substring(0, length);
        }else if(uuid.length() < length){
            for(int i=0; i<length-uuid.length(); i++){
                uuid = uuid + Math.round(Math.random()*9);
            }
        }
        if(isNumber){
            return uuid.replaceAll("a", "1").replaceAll("b", "2").replaceAll("c", "3").replaceAll("d", "4").replaceAll("e", "5").replaceAll("f", "6");
        }else{
            return uuid;
        }
    }

    /**
     * 判断输入的字符串参数是否为空
     * @return boolean 空则返回true,非空则flase
     */
    public static boolean isEmpty(String input) {
        return null==input || 0==input.length() || 0==input.replaceAll("\\s", "").length();
    }

    /**
     * 判断输入的字节数组是否为空
     * @return boolean 空则返回true,非空则flase
     */
    public static boolean isEmpty(byte[] bytes){
        return null==bytes || 0==bytes.length;
    }

    /**
     * 获取Map中的属性
     * @see 由于Map.toString()打印出来的参数值对,是横着一排的...参数多的时候,不便于查看各参数值
     * @see 故此仿照commons-lang.jar中的ReflectionToStringBuilder.toString()编写了本方法
     * @return String key11=value11 \n key22=value22 \n key33=value33 \n......
     */
    @SuppressWarnings("all")
    public static String getStringFromMap(Map<String, String> map){
        StringBuilder sb = new StringBuilder();
        sb.append(map.getClass().getName()).append("@").append(map.hashCode()).append("[");
        for(Map.Entry<String,String> entry : map.entrySet()){
            sb.append("\n").append(entry.getKey()).append("=").append(entry.getValue());
        }
        return sb.append("\n]").toString();
    }

    //主方法测试
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("name","罗祥");
        map.put("age",20+"");
        String m= Getnum();
        System.out.println(m);
        System.out.println(getSysJournalNo());
        System.out.println(getStringFromMap(map));

        String str= "尊敬的{0}，你好。很高兴来到{1}，此次为您服务的是{2}，祝您旅途愉快！";
        String format = MessageFormat.format(str, "罗祥", "巴厘岛", "刘毅向导");
        System.out.println(format);
    }
}

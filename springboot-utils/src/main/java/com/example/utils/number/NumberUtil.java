package com.example.utils.number;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * 数字转换工具
 * Created by luoxiang on 2018-4-27.
 */
public class NumberUtil {

    private static Logger logger = LoggerFactory.getLogger(NumberUtil.class);

    /************************************** 获取小数随机数 ***************************/
    /**
     * 获取小数随机数
     * @return
     */
    public static String getRandom(){
        DecimalFormat df = new DecimalFormat("#0.0000000000000000");
        return df.format(Math.random() * 10);
    }

    public static void main(String[] args) {
        long time = new Date().getTime();
        System.out.println(time);
    }

    /***************************************** 金额转换 ******************************/
    /***
     * 保留小数点两位
     */
    public static String ConverToDecimalToStringTwo(Object object) {
        String _value = "0.00";
        if (object == null) {
            return _value;
        }
        String value = object.toString();
        if (StringUtils.isBlank(value)) {
            return _value;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        } catch (Exception e) {
            // log.error(e);
            return "0.00";
        }
    }

    public static float ConverToDecimalToTwo(Object object) {
        float _value = 0.00F;
        if (object == null) {
            return _value;
        }
        String value = object.toString();
        if (StringUtils.isBlank(value)) {
            return _value;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
        } catch (Exception e) {
            // log.error(e);
            return 0.00F;
        }
    }

    /***
     * 保留小数点一位
     */
    public static String ConverToDecimalToStringOne(Object object) {
        String _value = "0.0";
        if (object == null) {
            return _value;
        }
        String value = object.toString();
        if (StringUtils.isBlank(value)) {
            return _value;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(value);
            return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).toString();
        } catch (Exception e) {
            // log.error(e);
            return "0.0";
        }
    }

    /**
     * 保留2位小数
     *
     * @param obj
     * @return
     */
    public static String ConverToTwoFloat(Object obj) {
        String str = obj + "";
        double num = 0;
        try {
            num = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            num = 0;
            logger.info("错误提示");
            e.printStackTrace();
        }
        str = String.format("%.2f", num);
        return str;
    }


    /**
     * 自定义保留count位小数
     *
     * @param obj
     * @return
     */
    public static String ConverToDIYFloat(Object obj, int count) {
        String str = obj + "";
        double num = 0;
        try {
            num = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            num = 0;
            logger.info("错误提示");
            e.printStackTrace();
        }
        if (count == 1) {
            str = String.format("%.1f", num);
        } else if (count == 2) {
            str = String.format("%.2f", num);
        } else if (count == 3) {
            str = String.format("%.3f", num);
        } else if (count >= 4) {
            str = String.format("%.4f", num);
        }
        return str;
    }

    /**
     * 金额乘法,保留两位小数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1, double d2) { // 进行乘法运算
        BigDecimal b1 = new BigDecimal(d1+"");
        BigDecimal b2 = new BigDecimal(d2+"");
        double aa= b1.multiply(b2).doubleValue();
        BigDecimal b = new BigDecimal(aa);
        double f1 = (double) b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    public static double mul2(double d1, double d2,int len) { // 进行乘法运算
        BigDecimal b1 = new BigDecimal(d1+"");
        BigDecimal b2 = new BigDecimal(d2+"");
        double aa= b1.multiply(b2).doubleValue();
        BigDecimal b = new BigDecimal(aa);
        double f1 = (double) b.setScale(len, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 金额除法
     *
     * @param d1
     * @param d2
     * @param len
     *            保留几位小数
     * @return
     */
    public static double div(double d1, double d2, int len) {// 进行除法运算
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return (double) b1.divide(b2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 金额除法
     *
     * @param d1
     * @param d2
     * @param len
     *            保留几位小数
     * @return
     */
    public static double div(BigDecimal d1, BigDecimal d2, int len) {// 进行除法运算
        return (double) d1.divide(d2, len, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确加法计算的add方法,保留2为小数
     *
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static double add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
        BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
        return (double) b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); // 四舍五入.doubleValue();
    }
}

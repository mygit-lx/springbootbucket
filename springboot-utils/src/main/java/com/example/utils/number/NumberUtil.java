package com.example.utils.number;

import java.text.DecimalFormat;
import java.util.Date;

/**
 * 数字转换工具
 * Created by luoxiang on 2018-4-27.
 */
public class NumberUtil {

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
}

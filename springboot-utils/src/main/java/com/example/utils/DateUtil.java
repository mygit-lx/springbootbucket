package com.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.enums.DateEnum;
import org.apache.commons.collections.MapUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Minutes;
import org.joda.time.LocalDate;

/**
 * 日期工具类
 * Created by luoxiang on 2018-4-27.
 */
public class DateUtil {

    /**
     * 获取当前时间
     *
     * @return 返回java Date
     * @author zhishuo
     */
    public static Date getNow() {
        return new DateTime().toDate();
    }

    /**
     * 字符串转Date
     * @param str
     * @param format
     * @return
     */
    public static Date getDate(String str, DateEnum format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format.getText());
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间戳转Date
     * @param stamp
     * @return
     */
    public static Date timeStampToDate(Long stamp){
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = format.format(stamp);
        try {
            Date date=format.parse(d);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回传入两个date相差的天数
     * END 大于 start 忽略时分秒
     * 例：start = 2015-06-05 10:40:30
     * end = 2015-06-06 10:40:20
     * 返回值 1
     *
     * @param start
     * @param end
     * @return
     */
    public static int daysBetween(Date start, Date end) {
        int days = Days.daysBetween(new LocalDate(start), new LocalDate(end)).getDays();
        return days;
    }

    /**
     * 返回传入两个date相差的天数
     * END 大于 start 忽略时分秒
     * 例：start = 2015-06-05 10:40:30
     * end = 2015-06-06 10:40:20
     * 返回值 1
     *
     * @param start
     * @param end
     * @return
     */
    public static int minuteBetween(Date start, Date end) {
        int minutes = Minutes.minutesBetween(new LocalDate(start), new LocalDate(end)).getMinutes();
        return minutes;
    }

    /**
     * 计算两个Date之间相差多少分钟
     * @param begin
     * @param end
     * @return
     */
    public static long minutesBetween(Date begin,Date end){
        long between=(end.getTime()-begin.getTime())/1000;//除以1000是为了转换成秒
        return between/60;
    }

    public static void main(String[] args) {
        Date date = DateUtil.timeStampToDate(1528098650245l);
        System.out.println(date);
        String date1 = "2018-06-01 12:30:00";
        String date2 = "2018-06-01 12:34:58";
        Date date3 = getDate(date1, DateEnum.DATE_FORMAT);
        Date date4 = getDate(date2, DateEnum.DATE_FORMAT);
//        int i = minuteBetween(getDate(date1, DateEnum.DATE_FORMAT), getDate(date2, DateEnum.DATE_FORMAT));
        long i = minutesBetween(date3, date4);
        System.out.println(i);
    }
}

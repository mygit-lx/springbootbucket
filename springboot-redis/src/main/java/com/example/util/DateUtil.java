package com.example.util;

import com.example.enums.DateEnum;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.Minutes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 * Created by luoxiang on 2018-4-27.
 */
public class DateUtil {

    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

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

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
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

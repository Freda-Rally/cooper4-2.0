package org.freda.cooper4.framework.utils;

import org.joda.time.DateTimeUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间类型工具包
 *
 * Created by rally on 2016/11/21.
 */
public class DateUtils extends DateTimeUtils
{
    /**
     * 获取指定年份和月份对应的天数
     *
     * @param year
     *            指定的年份
     * @param month
     *            指定的月份
     * @return int 返回天数
     */
    public static int getDaysInMonth(int year, int month)
    {
        if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10)
                || (month == 12))
        {
            return 31;
        }
        else if ((month == 4) || (month == 6) || (month == 9) || (month == 11))
        {
            return 30;
        }
        else
        {
            if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0))
            {
                return 29;
            }
            else
            {
                return 28;
            }
        }
    }

    /**
     * 根据所给的起止时间来计算间隔的天数
     *
     * @param startDate
     *            起始时间
     * @param endDate
     *            结束时间
     * @return int 返回间隔天数
     */
    public static int getIntervalDays(java.sql.Date startDate, java.sql.Date endDate)
    {
        long startdate = startDate.getTime();
        long enddate = endDate.getTime();
        long interval = enddate - startdate;
        int intervalday = (int) (interval / (1000 * 60 * 60 * 24));
        return intervalday;
    }

    /**
     * 根据所给的起止时间来计算间隔的月数
     *
     * @param startDate
     *            起始时间
     * @param endDate
     *            结束时间
     * @return int 返回间隔月数
     */
    public static int getIntervalMonths(java.sql.Date startDate, java.sql.Date endDate)
    {
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        Calendar endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int startDateM = Calendar.MONTH;
        int startDateY = Calendar.YEAR;
        int enddatem = Calendar.MONTH;
        int enddatey = Calendar.YEAR;
        int interval = (enddatey * 12 + enddatem) - (startDateY * 12 + startDateM);
        return interval;
    }

    /**
     * 返回当前日期时间字符串<br>
     * 默认格式:yyyy-mm-dd hh:mm:ss
     *
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime()
    {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        returnStr = f.format(date);
        return returnStr;
    }

    /**
     * 返回自定义格式的当前日期时间字符串
     *
     * @param format
     *            格式规则
     * @return String 返回当前字符串型日期时间
     */
    public static String getCurrentTime(String format)
    {
        String returnStr = null;
        SimpleDateFormat f = new SimpleDateFormat(format);
        Date date = new Date();
        returnStr = f.format(date);
        return returnStr;
    }

    /**
     * 返回当前字符串型日期
     *
     * @return String 返回的字符串型日期
     */
    public static String getCurDate()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = simpledateformat.format(calendar.getTime());
        return strDate;
    }

    /**
     * 返回TimeStamp对象
     *
     * @return
     */
    public static Timestamp getCurrentTimestamp()
    {
        Object obj = TypeCastUtils.convert(getCurrentTime(), "Timestamp", "yyyy-MM-dd HH:mm:ss");
        if (obj != null)
            return (Timestamp) obj;
        else
            return null;
    }

    /**
     * 将字符串型日期转换为日期型
     *
     * @param strDate
     *            字符串型日期
     * @param srcDateFormat
     *            源日期格式
     * @param dstDateFormat
     *            目标日期格式
     * @return Date 返回的util.Date型日期
     */
    public static Date stringToDate(String strDate, String srcDateFormat, String dstDateFormat)
    {
        Date rtDate = null;
        Date tmpDate = (new SimpleDateFormat(srcDateFormat)).parse(strDate, new ParsePosition(0));
        String tmpString = null;
        if (tmpDate != null)
            tmpString = (new SimpleDateFormat(dstDateFormat)).format(tmpDate);
        if (tmpString != null)
            rtDate = (new SimpleDateFormat(dstDateFormat)).parse(tmpString, new ParsePosition(0));
        return rtDate;
    }

    /**
     * 根据日期获取星期
     *
     * @param strdate
     * @return String
     */
    public static String getWeekDayByDate(String strdate)
    {
        final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        SimpleDateFormat sdfInput = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try
        {
            date = sdfInput.parse(strdate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0)
            dayOfWeek = 0;
        return dayNames[dayOfWeek];
    }
}

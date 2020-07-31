/**************************************************************************
 * Copyright (c) 2006-2017 ZheJiang Electronic Port, Inc.
 * All rights reserved.
 *
 * 项目名称：报关服务平台2.0
 * 版权说明：本软件属浙江电子口岸有限公司所有，在未获得浙江电子口岸有限公司正式授权
 *           情况下，任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知
 *           识产权保护的内容。                            
 ***************************************************************************/
package com.demo.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间工具类
 *
 * @author <a href="mailto:yuxh@zjport.gov.cn">yuxh</a>
 * @version $Id$
 * @since 2.0
 */
public class DateUtils {
    public static final String COMMON_DATE = "yyyy-MM-dd";
    public static final String COMMON_DATE_yyyyMMdd = "yyyyMMdd";
    public static final String COMMON_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String COMMON_DATETIME = "yyyyMMddHHmmss";

    /**
     * 方法说明：给日期加上一天
     *
     * @param date
     * @return
     */
    public static java.util.Date addDay(java.util.Date date) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 1);
        return cal.getTime();
    }

    /**
     * 方法说明：给日期加上一月
     *
     * @param date
     * @return
     */
    public static java.util.Date addMonth(java.util.Date date, int month) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }

    /**
     * 方法说明：
     *
     * @param date
     * @param k
     * @return
     */
    public static String addDate(Date date, int k) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, k);
        return format(cal.getTime());
    }

    /**
     * 方法说明：给日期加上指定天数
     *
     * @param date
     * @return
     */
    public static java.util.Date addCertainDays(java.util.Date date,
                                                Integer days) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

    /**
     * 方法说明：给日期加上指定年数
     *
     * @param date
     * @return
     */
    public static java.util.Date addCertainYears(java.util.Date date,
                                                 Integer years) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    /**
     * 方法说明：给日期加上指定年数
     *
     * @param date
     * @return
     */
    public static java.util.Date subtractCertainYears(java.util.Date date,
                                                      Integer years) {
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -years);
        return cal.getTime();
    }

    /**
     * 方法说明：根据时间获取日期
     *
     * @param date
     * @return
     */
    public static java.util.Date getDay(java.util.Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        String s = new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal
                .getTime());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sf.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 方法说明：根据时间获取日期
     *
     * @param date
     * @return
     */
    public static java.util.Date getDayYmd(java.util.Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        String s = new java.text.SimpleDateFormat("yyyyMMdd").format(cal
                .getTime());
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        try {
            return sf.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 方法说明：根据时间获取月初与月末日期
     *
     * @param date
     * @return
     */
    public static java.util.Date[] getMonth(java.util.Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        int lastDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
        java.util.Date begin = cal.getTime();
        cal.set(java.util.Calendar.DAY_OF_MONTH, lastDay);
        java.util.Date end = cal.getTime();
        return new java.util.Date[]{begin, end};
    }

    /**
     * 方法说明：根据一个时间获得这个时间对应的周开始和结束
     *
     * @return
     */
    public static String[] getDayInWeekBeginAndEnd(Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        int week = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1;
        String begin, end;
        if (week == 0) {
            begin = addDate(date, -6);
            end = format(date);
        } else {
            int days = 7 - week;
            begin = addDate(date, -(week - 1));
            end = addDate(date, days);
        }
        return new String[]{begin, end};
    }

    /**
     * 方法说明：得到"yyyy-MM-dd"格式的日期字符串
     *
     * @return
     * @throws ParseException
     */
    public static String getToday() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(cal
                .getTime());
    }

    /**
     * 方法说明：得到"yyyyMMdd"格式的日期字符串
     *
     * @return
     * @throws ParseException
     */
    public static String getTodayYmd() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        return new java.text.SimpleDateFormat("yyyyMMdd").format(cal
                .getTime());
    }

    /**
     * 方法说明：得到 "yyyy年m月d日" 格式的日期字符串
     *
     * @return
     */
    public static String getCNToday() {
        Calendar calendar = GregorianCalendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append(calendar.get(Calendar.YEAR));
        sb.append("年");
        sb.append(calendar.get(Calendar.MONTH) + 1);
        sb.append("月");
        sb.append(calendar.get(Calendar.DAY_OF_MONTH));
        sb.append("日");
        return sb.toString();

    }

    /**
     * 方法说明：
     *
     * @return
     * @throws ParseException
     */
    public static String getCurrentTime() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        return new java.text.SimpleDateFormat(COMMON_TIME).format(cal.getTime());
    }

    /**
     * 方法说明：2个时间进行比较，并把比较结果转成小时/分钟/秒
     *
     * @param date
     * @return
     */
    public static Long[] sec2Hour(java.util.Date date, java.util.Date date2) {
        return sec2Hour(date.getTime(), date2.getTime());
    }

    /**
     * 方法说明：2个时间进行比较，并把比较结果转成小时/分钟/秒
     *
     * @param start
     * @param end
     * @return
     */
    public static Long[] sec2Hour(long start, long end) {
        long times = end - start;
        Long totalSec = (Long) times / 1000;
        Long hour = totalSec / (60 * 60);
        Long min = (totalSec - hour * 60 * 60) / 60;
        Long sec = totalSec - hour * 60 * 60 - min * 60;
        return new Long[]{hour, min, sec};
    }

    /**
     * 方法说明：根据时间获取"yyyy-MM-dd"格式的日期
     *
     * @param date
     * @return
     */
    public static java.util.Date getDay(String date) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 方法说明：获取当前时间，转换成 "yyyy-MM-dd HH:mm:ss" 格式
     *
     * @return
     */
    public static java.util.Date getNowDateTime() {
        Date date = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = dateFormat.format(new Date());
            date = dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 方法说明：返回系统当前时间的月最初和月最某信息
     *
     * @return
     */
    public static java.util.Date[] getDateMonth() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        int lastDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
        java.util.Date begin = cal.getTime();
        cal.set(java.util.Calendar.DAY_OF_MONTH, lastDay);
        java.util.Date end = cal.getTime();
        return new java.util.Date[]{begin, end};
    }

    /**
     * 方法说明：
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        return sf.format(date);
    }

    /**
     * 方法说明：格式化日期
     *
     * @param date
     * @return
     */
    public static String format(Date date) {
        return format(date, "yyyy-MM-dd");
    }

    /**
     * 方法说明：格式化日期
     *
     * @param date
     * @return
     */
    public static String formatYmd(Date date) {
        return format(date, "yyyyMMdd");
    }

    /**
     * 方法说明：格式化日期
     *
     * @param dateStr
     * @return
     */
    public static Date parse(String dateStr) {
        return parse(dateStr, "yyyy-MM-dd");
    }

    /**
     * 方法说明：格式化日期，并指定格式
     *
     * @param dateStr
     * @param formate
     * @return
     */
    public static Date parse(String dateStr, String formate) {
        SimpleDateFormat sf = new SimpleDateFormat(formate);
        try {
            return sf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方法说明：判断时间是否是简单的格式(yyyy-MM-dd)还是yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static boolean isSimpleDate(Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.setTime(date);
        return cal.get(java.util.Calendar.HOUR_OF_DAY) == 0
                && cal.get(java.util.Calendar.MINUTE) == 0
                && cal.get(java.util.Calendar.SECOND) == 0;
    }

    /**
     * 方法说明：判断时间date1是否在时间date2之前
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateBefore(Date date1, Date date2) {
        return date1.before(date2);
    }

    /**
     * 方法说明：判断时间date1是否等于date2或在date2之前
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateBeforeOrEqual(Date date1, Date date2) {
        return date1.before(date2) || date1.equals(date2);
    }

    /**
     * 方法说明：判断时间date是否大于今天 true 大于等于今天 false 小于今天
     *
     * @param date
     * @return
     */
    public static boolean greaterOrEqualThanToday(Date date) {
        String today = getToday();
        String _date = format(date, "yyyy-MM-dd");
        if (_date.compareTo(today) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 方法说明：将指定时间重置为当天凌晨时间
     *
     * @param date
     * @return
     */
    public static Date moveBeginOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 1);
        return c.getTime();
    }

    /**
     * 方法说明：将指定时间重置为当天深夜时间
     *
     * @param date
     * @return
     */
    public static Date moveLastOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTime();
    }

    /**
     * 方法说明：获得日期对应的周信息 注意:日期减一是为了中国的习惯 礼拜一到礼拜天为一周 默认是礼拜天-礼拜六
     *
     * @param date
     * @return
     */
    public static int getWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(java.util.Calendar.DAY_OF_MONTH, -1);
        return cal.get(java.util.Calendar.WEEK_OF_YEAR);
    }

    /**
     * 方法说明：将字符串转化成Date
     *
     * @param value
     * @param format
     * @return
     */
    public static Date convertString2Date(String value, String format) {
        Date date = null;
        SimpleDateFormat df = new SimpleDateFormat(format);
        try {
            date = df.parse(value);
        } catch (Exception ex) {
        }
        return date;
    }

    /**
     * 方法说明：两个时间相差的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long dateDiffDay(Date date1, Date date2) {
        long dayFrom = date1.getTime() / (1000L * 60 * 60 * 24);
        long dayTo = date2.getTime() / (1000L * 60 * 60 * 24);
        return dayTo - dayFrom;
    }


    /**
     * 计算2个时间相差的天数
     *
     * @param date1
     * @param date2
     * @return
     * @throws ParseException
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
        //        System.out.println(day1);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);
        //        System.out.println(day2);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);

        if (year1 != year2)  //不同年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) { //闰年
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                    timeDistance += 366;
                } else { // 不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {// 同年
            return day2 - day1;
        }

    }


    /**
     * 方法说明：两个时间相差的秒数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static Long dateDiffSenc(Date date1, Date date2) {
        long dayFrom = date1.getTime() / (1000l);
        long dayTo = date2.getTime() / (1000l);
        return dayTo - dayFrom;

    }

    /**
     * 比较两个时间大小，date1>=date2返回true，反之返回false
     *
     * @param date1
     * @param date2
     * @return return
     */
    public static boolean compareDate(Date date1, Date date2) {
        long day1 = date1.getTime();
        long day2 = date2.getTime();
        if (day1 >= day2) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 方法说明：计算2个时间的间隔数据 如2010-1-1 2010-1-3 则2着相隔3天
     *
     * @param data1
     * @param data2
     * @return
     */
    public static int calculateIntervalDay(Date data1, Date data2) {
        long begin = data1.getTime();
        int interval = (int) ((data2.getTime() - begin) / (24 * 3600 * 1000));
        return (interval + 1);
    }

    /**
     * 方法说明：替换原日期的时间为指定时间(HH:mm)
     *
     * @param date ,time(HH:mm)
     * @return
     */
    public static java.util.Date moveNewTime(java.util.Date date, String time) {
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
        Date tempDate;
        Calendar tempCalendar = Calendar.getInstance();
        try {
            tempDate = sf.parse(time);
            tempCalendar.setTime(tempDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, tempCalendar.get(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, tempCalendar.get(Calendar.MINUTE));
        c.set(Calendar.SECOND, tempCalendar.get(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, 1);
        return c.getTime();
    }

    /**
     * 方法说明：给日期加上指定小时
     *
     * @param date
     * @return
     */
    public static java.util.Date addCertainTime(java.util.Date date,
                                                double hours) {
        int s = (int) (hours * 60 * 60);
        int hour = s / 3600;
        int min = (s - hour * 3600) / 60;
        int sec = s - hour * 3600 - min * 60;
        java.util.Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        cal.add(Calendar.MINUTE, min);
        cal.add(Calendar.SECOND, sec);
        return cal.getTime();
    }

    /**
     * 获得当前日期 月日
     *
     * @return
     */
    public static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        return month + "月" + day + "日";
    }

    /**
     * 获得近几月
     *
     * @return
     */
    public static String getRecentMonth(int recent) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) - recent + 1;
        if (month < 10) {
            return year + "-0" + month;
        }
        return year + "-" + month;
    }

    /***
     * 获得今天星期
     *
     * @return
     */
    public static String getWeekOfDate() {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = java.util.Calendar.getInstance();
        cal.getTime();
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 方法说明：增加天
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static String addOneDay(String date, int addDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar ca = Calendar.getInstance();
        int year = Integer.parseInt(date.substring(0, 4));// 年
        ca.set(Calendar.YEAR, year);
        int month = Integer.parseInt(date.substring(5, 7));// 月，注意要减1，因为一月对应的是0
        ca.set(Calendar.MONTH, month - 1);
        int day = Integer.parseInt(date.substring(8, 10));// 日，
        // 如果超过了当月的最大天数，Calendar会自动处理
        ca.set(Calendar.DAY_OF_MONTH, day);
        ca.add(Calendar.DAY_OF_MONTH, addDays);
        return sdf.format(ca.getTime());
    }

    /**
     * 方法说明：转换成"yyyy-mm-dd"的格式
     *
     * @param dt
     * @return
     */
    public static String toSmallDateString(Date dt) {
        DateFormat dtSmallFormat = new SimpleDateFormat(COMMON_DATE);
        return dtSmallFormat.format(dt);
    }

    /**
     * 返回某个日期之后（之前）几天的日期
     *
     * @param somedate
     * @param day
     * @return
     */
    public static Date getDateAfterDay(Date somedate, int day) {
        if (somedate == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(somedate);
        cal.add(Calendar.DAY_OF_MONTH, day);
        return new Date(cal.getTime().getTime());
    }

    /**
     * 返回当前年月日前N天
     *
     * @return
     */
    public static String getDate(Integer n) {
        Date d = new Date();
        d = DateUtils.getDateAfterDay(d, n);
        SimpleDateFormat sdf = new SimpleDateFormat(SystemContext.YMD);
        String dateNowStr = sdf.format(d);

        return dateNowStr;
    }

    /**
     * String转换为Date
     *
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(SystemContext.YMD);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
        }

        return date;
    }

    /**
     * @param ihour
     * @return
     * @2018-02-09 获取当前时间，指定前面多少小时的时间  ,返回格式YYYYMMDDHHMMSS
     */
    public static String getBeforeHourTime(int ihour) {
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }

    /**
     * @param ihour
     * @return
     * @2018-03-12 获取当前时间，指定后面多少小时的时间  ,返回格式YYYYMMDDHHMMSS
     */
    public static String getAfterHourTime(int ihour) {
        String returnstr = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + ihour);
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        returnstr = df.format(calendar.getTime());
        return returnstr;
    }


    /**
     * 20180407170000  格式的时间 转成  yyyy-MM-dd HH:mm:ss
     *
     * @param dateString
     * @return
     */
    public static String changeDateFormate(String dateString) {
        String result = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dd = df.parse(dateString);
            result = df1.format(dd);
        } catch (Exception e) {
            return "";
        }
        if (StringUtils.isBlank(dateString)) {
            return "";
        }
        return result;
    }

    /**
     * 获取最近12个月，经常用于统计图表的X轴
     */
    public static String[] getLast12Months() {

        String[] last12Months = new String[12];

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1); //要先+1,才能把本月的算进去</span>
        for (int i = 0; i < 12; i++) {
            cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) - 1); //逐次往前推1个月
            int month = cal.get(Calendar.MONTH) + 1;
            last12Months[11 - i] = cal.get(Calendar.YEAR) + "-" + (month < 10 ? "0" + month : month);
        }

        return last12Months;
    }

    /**
     * 方法说明：根据参数获取上月该日期对应时间
     *
     * @param day
     * @return
     */
    public static Date getLastMonthOfDay(Integer day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, c.get(Calendar.YEAR));
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    /**
     * 根据年月日获取日期
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static Date getDayByYMD(Integer year, Integer month, Integer day) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DAY_OF_MONTH, day);
        return c.getTime();
    }

    /**
     * 判断 date1比date2大 intervalSec秒
     *
     * @param date1 --nowdate
     * @param date2
     * @return
     */
    public static boolean compareDateByInterval(Date date1, Date date2, int intervalSec) {
        boolean flag = false;
        long ts = date2.getTime();
        long nowTs = date1.getTime();
        //String intervalSec = DubConstants.DAY_INTERVAL_TO_CLEAN_ENTRUST_USED_FLAG;
        if (nowTs < ts) {
            return flag;
        }
        if ((nowTs - ts) / 1000 > intervalSec) {
            flag = true;
        }
        return flag;
    }

    /**
     * 返回日时分秒
     *
     * @param second
     * @return
     */
    public static String secondToTime(long second) {
        long days = second / 86400;// 转换天数
        second = second % 86400;// 剩余秒数
        long hours = second / 3600;// 转换小时数
        second = second % 3600;// 剩余秒数
        long minutes = second / 60;// 转换分钟
        second = second % 60;// 剩余秒数
        if (0 < days) {
            return days + "天" + hours + "小时" + minutes + "分" + second + "秒";
        } else if (0 < hours) {
            return hours + "小时" + minutes + "分" + second + "秒";
        } else {
            return minutes + "分" + second + "秒";
        }
    }

    /**
     * 日期格式是否是“yyyyMMdd或者yyyy-MM-dd”
     *
     * @param value
     * @return
     */
    public static boolean isStandardDate(String value, String format) {

        SimpleDateFormat sdf = null;
        ParsePosition pos = new ParsePosition(0);// 指定从所传字符串的首位开始解析

        if (StringUtils.isBlank(value) || StringUtils.isBlank(format)) {
            return false;
        }
        try {
            sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            Date date = sdf.parse(value, pos);
            if (date == null) {
                return false;
            } else {
                pos.getIndex();
                sdf.format(date);
                // 更为严谨的日期,如2011-03-024认为是不合法的
                if (pos.getIndex() > sdf.format(date).length()) {
                    return false;
                }
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 测试方法
     *
     * @param args
     */
    public static void main(String[] args) {
        boolean standardDate = isStandardDate("2020-04-36", "yyyy-MM-dd");
        boolean standardDate2 = isStandardDate("20200406", "yyyyMMdd");

        System.out.println(standardDate);
        System.out.println(standardDate2);
    }
}

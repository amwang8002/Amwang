package com.amwang.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description: 日期时间工具类
 * @author yemulin
 * @create 2012-8-9 下午5:26:26
 */
public class DateUtil {

	/**
	 * @Description: 获取当前系统日期 格式:yyyy-mm-dd
	 * @return String 日期字符串
	 * @throws
	 */
	public static String getCurrentDate() {
		return getCurrentDate("yyyy-MM-dd");
	}

	/**
	 * @Title: getDate
	 * @Description: 获取当前系统日期 格式:yyyymmdd
	 * @return String
	 * @throws
	 */
	public static String getDate() {
		return getCurrentDate("yyyyMMdd");
	}

	/**
	 * 
	 * 功能描述：根据给定的格式将str转化为Date类型
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date getDate(String dateStr, String format) {
		DateFormat formater = new SimpleDateFormat(format);
		Date result;
		try {
			result = formater.parse(dateStr);
		} catch (ParseException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 
	 * @Description: 获取当前系统日期
	 * @param format 日期格式
	 * @return String 日期字符串
	 * @throws
	 */
	public static String getCurrentDate(String format) {
		return getCurrentDateTimeStr(format);
	}

	/**
	 * @Description: 获取当前系统时间 格式:HH:mm:ss
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTime() {
		return getCurrentDate("HH:mm:ss");
	}

	/**
	 * 
	 * @Description: 获取当前系统时间
	 * @param format 时间格式
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTime(String format) {
		return getCurrentDateTimeStr(format);
	}

	/**
	 * @Description: 获取当前系统时间戳 格式:yyyy-mm-dd HH:mm:ss
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTimeStamp() {
		return getCurrentDate("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * @Description: 获取当前系统时间戳 精确到毫秒 格式:yyyy-mm-dd HH:mm:ss:sss
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTimeToMs() {
		return getCurrentDate("yyyy-MM-dd HH:mm:ss:sss");
	}

	/**
	 * 
	 * @Description: 获取当前系统时间戳
	 * @param format 时间格式
	 * @return String 时间字符串
	 * @throws
	 */
	public static String getCurrentTimeStamp(String format) {
		return getCurrentDateTimeStr(format);
	}

	/**
	 * 
	 * @Description: 获取当前日期时间字符串
	 * @param format 日期时间格式
	 * @return String 日期时间字符串
	 * @throws
	 */
	public static String getCurrentDateTimeStr(String format) {
		DateFormat formater = new SimpleDateFormat(format);
		return formater.format(new Date());
	}

	/**
	 * @Title:sourcePlusInterval
	 * @Description:日期增加
	 * @param source yyyy-MM-dd/yyyyMMdd
	 * @param interval
	 * @return
	 * @throws Exception
	 * @return String
	 */
	public static String sourcePlusInterval(String source, int interval) {
		DateFormat informater ;
		if (source.contains("-")) {
			informater = new SimpleDateFormat("yyyy-MM-dd");
		} else {
			informater = new SimpleDateFormat("yyyyMMdd");
		}
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(informater.parse(source));
		} catch (ParseException e) {

		}
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + interval);
		return informater.format(calendar.getTime());
	}

	/**
	 * 
	 * @Description: 将字符串从一种格式转化的
	 * @param @param source 日期原串
	 * @param @param infmt 日期输入格式
	 * @param @param outfmt 日期输出格式
	 * @param @return 目标日期字符串
	 * @throws ParseException
	 */
	public static String getFmtDate(String source, String infmt, String outfmt)
			throws ParseException {
		// 输入格式
		DateFormat informater = new SimpleDateFormat(infmt);
		// 输出格式
		DateFormat outfomater = new SimpleDateFormat(outfmt);

		return outfomater.format(informater.parse(source));
	}

	/**
	 * 
	 * @Description: 将字符串从一种格式转化的
	 * @param @param source 日期原串
	 * @param @param infmt 日期输入格式
	 * @param @param outfmt 日期输出格式
	 * @param @return 目标日期字符串
	 * @throws ParseException
	 */
	public static String getFmtDateStr(String source, String infmt, String outfmt) {
		String result = "";
		try {
			// 输入格式
			DateFormat informater = new SimpleDateFormat(infmt);
			// 输出格式
			DateFormat outfomater = new SimpleDateFormat(outfmt);

			result = outfomater.format(informater.parse(source));

		} catch (Exception e) {
			result = source;
		}

		return result;
	}

	/**
	 * 
	 * <p>Title: getAppointDay</p>  
	 * <p>Description: 得到当前日期前后指定格式的日期</p>  
	 * @param fmt 格式
	 * @param num 加减数
	 * @return
	 */
	public static String getAppointDay(String fmt, int num) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, num);
		Date tmp = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		String date = sdf.format(tmp);
		return date;
	}

	/**
	 * @Title:dataPlusInterval
	 * @Description:日期增加(Date格式操作)
	 * @param source
	 * @param interval
	 * @return Date
	 */
	public static Date dataPlusInterval(Date source, int interval) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(source);
		int day = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.set(Calendar.DAY_OF_YEAR, day + interval);
		return calendar.getTime();
	}

	/**
	 * @Title:dataPlusInterval
	 * @Description:日期增加(string格式操作)
	 * @param source
	 * @param interval
	 * @param format
	 * @return Date
	 */
	public static String datePlusIntervaltoString(Date source, int interval, String format) {
		Date date = dataPlusInterval(source, interval);
		return getDateStr(date, format);
	}

	/**
	 * @Description:日期转化为字符串
	 * @param date 日期
	 * @param format 日期格式
	 * @return 日期字符串
	 */
	public static String getDateStr(Date date, String format) {
		DateFormat dateformat = new SimpleDateFormat(format);
		return dateformat.format(date);
	}

	/**
	 * 
	 * @param date 传入日期
	 * @param item 加减的日期天数
	 * @return yyyy-MM-dd格式日期
	 */
	@SuppressWarnings("static-access")
	public static String getFormatDate(String date, int item) {
		String resDate = "";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date d = format.parse(date);
			Calendar c = Calendar.getInstance();
			c.setTime(d);
			c.add(c.DATE, item);
			Date temp_date = c.getTime();
			resDate = format.format(temp_date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resDate;
	}

	/**
	 * 获取当前时间
	 * <p>Title: getNowDate</p>  
	 * <p>Description: 返回当前系统时间 </p>  
	 * @return
	 */
	public static Date getNowDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = DateUtil.getCurrentTimeStamp();
		Date date = null;
		try {
			date = formatter.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 月份增减
	 * <p>Title: monthPlusToString</p>  
	 * <p>Description: 返回增减后的日期 </p>  
	 * @param month
	 * @param item
	 * @return
	 */
	public static String monthPlusToString(String month,int item){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(month);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar cl = Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.MONTH, item);
		date = cl.getTime();
		return sdf.format(date);
	}
	
	/**
	 * 获得该月 第一天
	 * <p>Title: getFirstDayOfMonth</p>  
	 * <p>Description: </p>  
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int month) {
	     Calendar cal = Calendar.getInstance();
	     // 设置月份
	     cal.set(Calendar.MONTH, month - 1);
	     // 获取某月最小天数
	     int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
	     // 设置日历中月份的最小天数
	     cal.set(Calendar.DAY_OF_MONTH, firstDay);
	     // 格式化日期
	     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     String firstDayOfMonth = sdf.format(cal.getTime())+" 00:00:00";
	     return firstDayOfMonth;
	 }
	/**
	 * 获得该月最后一天
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	 public static String getLastDayOfMonth(int month) {
	    Calendar cal = Calendar.getInstance();
	    // 设置月份
	    cal.set(Calendar.MONTH, month - 1);
	    // 获取某月最大天数
	    int lastDay=0;
	   //2月的平年瑞年天数
	   if(month==2) {
	     lastDay = cal.getLeastMaximum(Calendar.DAY_OF_MONTH);
	   }else {
	      lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	   }
	    // 设置日历中月份的最大天数
	     cal.set(Calendar.DAY_OF_MONTH, lastDay);
	    // 格式化日期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String lastDayOfMonth = sdf.format(cal.getTime())+" 23:59:59";
	    return lastDayOfMonth;
	 }
	 
	/**
	  * 获取本周的第一天
	  * @return String
	  * **/
	 public static String getWeekStart(){
	     Calendar cal=Calendar.getInstance();
		 if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			cal.add(Calendar.DATE, -1);
		 }
	     cal.add(Calendar.WEEK_OF_MONTH, 0);
	     cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
	     Date time=cal.getTime();
	     return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 00:00:00";
	 }
	 /**
	  * 获取本周的最后一天
	  * @return String
	  * **/
	 public static String getWeekEnd(){
	     Calendar cal=Calendar.getInstance();
	     if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	    	 cal.add(Calendar.DATE, -1);
	     }
	     cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
	     cal.add(Calendar.DAY_OF_WEEK, 1);
	     Date time=cal.getTime();
	     return new SimpleDateFormat("yyyy-MM-dd").format(time)+" 23:59:59";
	 }
	 /**
	  * 获取本年的第一天
	  * @return String
	  * **/
	 public static String getYearStart(){
	     return new SimpleDateFormat("yyyy").format(new Date())+"-01-01";
	 }
	 
	 /**
	  * 获取本年的最后一天
	  * @return String
	  * **/
	 public static String getYearEnd(){
	     Calendar calendar = Calendar.getInstance();
	     calendar.set(Calendar.MONTH,calendar.getActualMaximum(Calendar.MONTH));
	     calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
	     Date currYearLast = calendar.getTime();
	     return new SimpleDateFormat("yyyy-MM-dd").format(currYearLast)+" 23:59:59";
	 }
	 /**
	  * 两个日期是否同一天
	  * <p>Description:  </p>  
	  * <p>Title: isSameDay</p>  
	  * @param day1
	  * @param day2
	  * @return
	  */
	 public static boolean isSameDay(Date day1, Date day2) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    String ds1 = sdf.format(day1);
	    String ds2 = sdf.format(day2);
	    if (ds1.equals(ds2)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	 

		/**
		 * 获取当天0点
		 * <p>Description:  </p>  
		 * <p>Title: getCurrentDayStart  yyyy-MM-dd 00:00:00</p>  
		 * @return
		 */
	public static Date getCurrentDayStart() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current = getCurrentDate() +" 00:00:00";
		Date date = null;
		try {
			date = formatter.parse(current);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获取当天24点
	 * <p>Description:  </p>  
	 * <p>Title: getCurrentDayStart  yyyy-MM-dd 23:59:59</p>  
	 * @return
	 */
	public static Date getCurrentDayEnd() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String current = getCurrentDate() +" 23:59:59";
		Date date = null;
		try {
			date = formatter.parse(current);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}

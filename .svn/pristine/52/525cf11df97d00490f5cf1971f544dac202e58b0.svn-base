package com.jixie.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 说明：日期格式化
 * @author yujian
 * @version 2012-10-1 2.0 beta
 */
public class DateFormat {

	/**
	 * 日期格式化-Date
	 * @author yujian
	 * @param date
	 * @return Date date
	 */
	public static Date dateFormat(Date date) {
		if (date != null) {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			return java.sql.Date.valueOf(dateformat.format(date));
		}
		return null;
	}

	/**
	 * 日期格式化-String
	 * @param date
	 * @return String
	 */
	public static String DateToString(Date date){

		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");

		return dateformat.format(date);
	}

	/**
	 * 日期格式化-String
	 * @param date
	 * @return String
	 */
	public static String DateTimeToString(Date date){

		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd hh:mm");

		return dateformat.format(date);
	}

	/**
	 * 日期格式化-date
	 * @param Stringdate,字符串格式的日期
	 * @return Date
	 */
	public static  Date StringToDate(String Stringdate) throws ParseException
	{
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd");
		return dateformat.parse(Stringdate);
	}

	/**
	 * 获取当前时间
	 * @return Date
	 */
	public static Date nowdate(){

		return new Date();
	}

	/**
	 * 日期格式化-String yeah
	 * @param date
	 * @return String
	 */
	public static String year(Date date){
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy");
		return dateformat.format(date);
	}
	
	/**
	 * 日期格式化-String month
	 * @param date
	 * @return String
	 */
	public static String month(Date date){
		SimpleDateFormat dateformat=new SimpleDateFormat("MM");
		return dateformat.format(date);
	}
	
	/**
	 * 日期格式化-String
	 * @return String
	 */
	public static String getDateId(){
		
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		return dateformat.format(new Date());
	}
}
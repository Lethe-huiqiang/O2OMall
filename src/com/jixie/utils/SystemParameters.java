package com.jixie.utils;

import java.util.Date;

public class SystemParameters {

	private static RequestParams parameters;

	/**
	 * 清除全部参数
	 * 
	 */
	public static void clear() {
		parameters.clear();
	}

	/**
	 * 取参数
	 * 
	 * @param name
	 *            参数名
	 * @return 参数值
	 */
	public static Object get(String name) {
		return parameters.getA(name);
	}

	/**
	 * 取布尔型参数
	 * 
	 * @param name
	 *            参数名
	 * @return 参数值
	 */
	public static boolean getBoolean(String name) {
		return parameters.getBoolean(name);
	}

	/**
	 * 取布尔型参数
	 * 
	 * @param name
	 *            参数名
	 * @param defaultvalue
	 *            缺省值
	 * @return 参数值
	 */
	public static boolean getBoolean(String name, boolean defaultvalue) {
		return parameters.getBoolean(name, defaultvalue);
	}

	/**
	 * 取日期型参数
	 * 
	 * @param name
	 *            参数名
	 * @return 参数值
	 */
	public static Date getDate(String name) {
		return parameters.getDate(name);
	}

	/**
	 * 取日期型参数
	 * 
	 * @param name
	 *            参数名
	 * @param format
	 *            日期格式
	 * @return 参数值
	 */
	public static Date getDate(String name, String format) {
		return parameters.getDate(name, format);
	}

	/**
	 * 取浮点型参数
	 * 
	 * @param name
	 *            参数名
	 * @return 参数值
	 */
	public static float getFloat(String name) {
		return parameters.getFloat(name);
	}

	/**
	 * 取浮点型参数
	 * 
	 * @param name
	 *            参数名
	 * @param defaultValue
	 *            缺省值
	 * @return 参数值
	 */
	public static float getFloat(String name, float defaultValue) {
		return parameters.getFloat(name, defaultValue);
	}

	/**
	 * 取整型参数
	 * 
	 * @param name
	 *            参数名
	 * @return 参数值
	 */
	public static int getInt(String name) {
		return parameters.getInt(name);
	}

	/**
	 * 取整型参数
	 * 
	 * @param name
	 *            参数名
	 * @param defaultValue
	 *            缺省值
	 * @return 参数值
	 */
	public static int getInt(String name, int defaultValue) {
		return parameters.getInt(name, defaultValue);
	}

	/**
	 * 取浮点型参数
	 * 
	 * @param name
	 *            参数名
	 * @return 参数值
	 */
	public static String getString(String name) {
		return parameters.getString(name);
	}

	/**
	 * 取字符型参数
	 * 
	 * @param name
	 *            参数名
	 * @param defaultValue
	 *            缺省值
	 * @return 参数值
	 */
	public static String getString(String name, String defaultValue) {
		return parameters.getString(name, defaultValue);
	}

	/**
	 * 初始化系统参数
	 * 
	 * @param params
	 */
	public static void init(RequestParams params) {
		parameters = params;
	}

	/**
	 * 如果该同名参数已经存在则直接退出否则设置一个参数
	 * 
	 * @param name
	 *            参数名
	 * @param value
	 *            参数值
	 */
	public static void put(String name, Object value) {
		parameters.putA(name, value);
	}

	/**
	 * 设置全局参数
	 * 
	 * @param name
	 *            参数名
	 * @param value
	 *            参数值
	 * @param replace
	 *            true如果原来有该参数则更新，否则替换
	 */
	public static void put(String name, Object value, boolean replace) {
		parameters.putA(name, value, replace);
	}

	/**
	 * 清除指定key的参数
	 * 
	 * @param key
	 *            参数名称(key)
	 */
	public static void remove(String key) {
		parameters.removeA(key);
	}

	protected SystemParameters() {

	}

}

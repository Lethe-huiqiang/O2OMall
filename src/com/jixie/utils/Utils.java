package com.jixie.utils;

import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;

public class Utils {
	
	//参数为null转化成"",防止空异常
	public static String null2Str(String source) {
		return null2Str(source, "");
	}
	
	public static String null2Str(String source, String defaultValue) {
		return valueOf(source, defaultValue, 0);
	}
	
	public static String valueOf(String source, String defaultValue,
			int maxlength) {
		return StringUtils.valueOf(source, defaultValue, maxlength);
	}
	
	/**
	 * 当字串超过指定长度时截断
	 * 
	 * @param source
	 *            源串
	 * @param max
	 *            最大长度
	 * @return 限制长度串
	 */
	public static String null2Str(String source, int max) {
		return StringUtils.null2Str(source, max);
	}
	
	/**
	 * 转换普通值--名称列表为IListItem列表，用来名称转换或列表输出
	 * 
	 * @param items
	 *            以值--名称编码的数据项,以半角逗号分隔
	 * @return IListItem列表
	 */
	public static List<IListItem> convertList(String[] items, String split) {
		return ArrayUtils.convertList(items, split);
	}
	
	/**
	 * 通过编码返回名称或标题
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	public static String getTitleByList(List list, int code) {
		return HTMLUtils.getTitleByList(list, code);
	}

	/**
	 * 通过编码返回名称或标题
	 * 
	 * @param list
	 *            IListItem列表
	 * @param code
	 *            编码
	 * @return 名称或标题
	 */
	public static String getTitleByList(List list, String code) {
		return HTMLUtils.getTitleByList(list, code);
	}
	
	/**
	 * 返回下拉列表选项。
	 * 
	 * @param list
	 *            IListItem列表
	 * @param defaultValue
	 *            当前选中的值，可以为空。
	 * @return HTML代码
	 */
	public static String getOptionsByList(List list, int defaultValue) {
		return HTMLUtils.getOptionsByList(list, defaultValue);
	}
	
	/**
	 * 返回下拉列表选项。
	 * 
	 * @param list
	 *            IListItem列表
	 * @param defaultValue
	 *            当前选中的值，可以为空。
	 * @return HTML代码
	 */
	public static String getOptionsByList(List list, String defaultValue) {
		return HTMLUtils.getOptionsByListStr(list, defaultValue);
	}
	
	/**
	 * 
	 * @param name
	 *            The name of Checkbox Control
	 * @param list
	 *            The key-value list of checkbos
	 * @param checkeds
	 *            The values that checked;
	 * @return
	 */
	public static String getCheckBoxGroupByList(String name, List list,
			String[] checkeds) {
		return HTMLUtils.getCheckBoxGroupByList(name, list, checkeds);
	}
	
	public static String getButtonsByList(List list, int defaultValue,
			String buttonName, String ext, boolean radio) {
		return getButtonsByList(list, String.valueOf(defaultValue), buttonName,
				ext, radio);
	}

	public static String getButtonsByList(List list, String defaultValue,
			String buttonName, String ext, boolean radio) {
		return HTMLUtils.getButtonsByList(list, defaultValue, buttonName, ext,
				radio);
	}
	
	/**
	 * 返回timestamp类型的时间。
	 * 
	 * @param date
	 *            date类型时间
	 * @return HTML代码
	 */
	public static Timestamp date2Stamp(Date date){
		if(date==null){
			date = new Date();
		}
		return new Timestamp(date.getTime());
	}
	
	/**
	 * 随机产生32位字符串
	 * 
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	/**
	 * MD5加密算法，返回一个32为经过加密的字符串
	 * 
	 * @author zhurudong
	 * @param password 需要加密的密码
	 * @return 返回一个经过加密的32位字符串。
	 */
	public static String md5(String password){
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = password.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 获取当前时间戳
	 * @return
	 */
	public static Timestamp getCurrentTimestamp(){
		Timestamp creTime = Timestamp.valueOf(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date()));
		return creTime;
	}
	
	/**
	 * 生成订单编号
	 */
	public static String getNumber(Integer hashCode){
		SimpleDateFormat sdf = new SimpleDateFormat("mmssSSS");
		Date date = new Date();
		String string  = sdf.format(date);
		return hashCode+string;
		
	}
	
	/**
	 * 格式化为指定格式的日期，缺省以东八区时间格式化
	 * 
	 * @param date
	 * @param format
	 *            如 yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String format(Date date, String format) {

		return format(date, format, "GMT+8");
	}
	
	/**
	 * 日期格式化函数
	 * 
	 * @param date
	 * @param format
	 * @param timeZone
	 *            时区如东八区GMT+8
	 * @return
	 */
	public static String format(Date date, String format, String timeZone) {

		if (date == null)
			return "";
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		if (timeZone != null && !timeZone.trim().equals(""))
			formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
		return formatter.format(date);
	}
	
	/**
	 * 日期运算
	 * 
	 * @param date
	 *            源
	 * @param part
	 *            操作部份
	 * @param value
	 *            改变值
	 * @return 计算后的日期
	 */
	public static Date add(Date date, int part, int value) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(part, value);
		return calendar.getTime();
	}
	
	/**
	 * 时区转换
	 * 
	 * @param date
	 * @param locate
	 * @return
	 */
	public static Date get(Date date, String locate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		if (locate != null && !locate.trim().equals(""))
			calendar.setTimeZone(TimeZone.getTimeZone(locate));
		return calendar.getTime();
	}
	
	/**
	 * 字符串转换为指定时区时间
	 * 
	 * @param value
	 * @param patterns
	 *            如yyyy-MM-dd HH:mm:ss
	 * @param timeZone如东八区GMT
	 *            +8
	 * @return
	 */
	public static Date valueOf(String value, String patterns, String timeZone) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(patterns);
		Date date = null;
		if (value == null)
			return date;
		if (timeZone != null && !timeZone.trim().equals(""))
			dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			date = dateFormat.parse(value);
		} catch (java.text.ParseException e) {
			System.out.println("[string to date]" + e.getMessage());
		}

		return date;
	}
	
	/**
	 * 生成Len位的随机数，未测试是否重复
	 * @param Len
	 * @return
	 */
	 public static String GetRandomString(int Len) {
         
	        String[] baseString={"0","1","2","3",
	                "4","5","6","7","8","9",
	                "a","b","c","d","e",
	                "f","g","h","i","j",
	                "k","l","m","n","o",
	                "p","q","r","s","t",
	                "u","v","w","x","y",
	                "z","A","B","C","D",
	                "E","F","G","H","I",
	                "J","K","L","M","N",
	                "O","P","Q","R","S",
	                "T","U","V","W","X","Y","Z"};
	        Random random = new Random();
	        int length=baseString.length;
	        String randomString="";
	        for(int i=0;i<length;i++){
	            randomString+=baseString[random.nextInt(length)];
	        }
	        random = new Random(System.currentTimeMillis());
	        String resultStr="";
	        for (int i = 0; i < Len; i++) {
	            resultStr += randomString.charAt(random.nextInt(randomString.length()-1));
	        }
	        return resultStr;
	    }
	
}

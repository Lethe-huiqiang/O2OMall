package com.jixie.utils;

import java.util.List;

public class CommonUtils extends SystemUtils {

	// 获取系统参数类型
	@SuppressWarnings("unchecked")
	public static List getParametersType() {
		return Utils.convertList(SystemParameters.getString("PARAMETERSTYPE")
				.split(";"), ",");
	}


	
	/**
	 * 获取用户专业
	 * @return
	 */
	public static List getMajor(){
		return Utils.convertList(SystemParameters.getString("MAJOR").split(";"), "=");
	}
	

}

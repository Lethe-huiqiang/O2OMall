package com.jixie.utils;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.jixie.bean.Commodity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MallManageUtil {
  
	public static JSONArray formatListToJsonArray(List list)throws Exception{
		if (list.equals(null) || null == list) {
			return null;
		} else {
			JSONArray json = JSONArray.fromObject(list);
			return json;
		}
	}
//		ResultSetMetaData md=rs.getMetaData();
//		int num=md.getColumnCount();
//		JSONArray array=new JSONArray();
//		while(rs.next()){
//			JSONObject mapOfColValues=new JSONObject();
//			for(int i=1;i<=num-3;i++){
//				mapOfColValues.put(md.getColumnName(i), rs.getObject(i));
//			}
//			array.add(mapOfColValues);
//		}
//		return array;
	/**
	 * 判断字符串是否为空
	 */
	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 判断字符串是否不为空
	 */
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	public static void write(HttpServletResponse response,JSONObject jsonObject)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(jsonObject.toString());
		out.flush();
		out.close();
	}
	}


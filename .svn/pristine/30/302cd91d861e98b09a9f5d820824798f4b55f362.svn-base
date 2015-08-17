package com.jixie.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gzbugu.common.commonService.ICommonService;

public class ExportExcelHelper {
	
	
	private static ExportExcelHelper instance = null;
	private final static Object object = new Object();

	public static ExportExcelHelper getInstance() {
		if (instance == null) {
			synchronized (object) {
				if (instance == null) {
					instance = new ExportExcelHelper();
				}
			}
		}
		return instance;
	}

	/**
	 * 通过页面表单展示的数据导出EXCEL表
	 * 
	 * @param obj
	 *            -要操作的实体类型，如导出User所有记录；hql - 导出符合条件的实体；param1
	 *            -excel表头列名数组，与param2属性数组长度要保持一致；param2 -实体对应的属性数组，即要求输出的属性集合
	 * @return InputStream
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public InputStream getExcelInputStream(Object obj, String hql,
			Object[] param1, Object[] param2,ICommonService commonService) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet1");

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = null;
		for (int i = 0; i < param1.length; i++) {
			cell = row.createCell((short) i);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue((String) param1[i]);
		}

		List list = commonService.findListByHQL(hql, null);

		for (int k = 0; k < list.size(); k++) {
			obj = list.get(k);
			row = sheet.createRow(k + 1);
			for (int j = 0; j < param2.length; j++) {
				Object object = null;
				String methodName = "get"
						+ ((String) param2[j]).substring(0, 1).toUpperCase()
						+ ((String) param2[j]).substring(1);
				Class cls = obj.getClass();
				try {
					Method m = cls.getMethod(methodName, null);
					object = m.invoke(obj, null);
				} catch (Exception e) {
					e.printStackTrace();
				}

				cell = row.createCell((short) j);
				cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				cell.setCellValue(String.valueOf(object));
			}

		}

		File file = new File("活动报名情况统计表.xls");

		try {
			OutputStream os = new FileOutputStream(file);
			wb.write(os);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream is = null;
		try {
			is = new FileInputStream(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}


}

package com.jixie.utils;

import java.util.List;

import com.gzbugu.common.commonService.ICommonService;
import com.jixie.bean.Parameters;


public class SystemUtils {


	//更新系统参数
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void loadSystemConfig(ICommonService service) {

		String hql = "from Parameters sp " ;
		List list = service.findListByHQL(hql);
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Parameters item = (Parameters) list.get(i);
				if (item.getName() != null && !item.getName().trim().equals(""))
					SystemParameters.put(item.getName(), item.getValue(), true);
			}
		}
	}

	
}

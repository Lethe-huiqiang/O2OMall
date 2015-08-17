package com.jixie.system.helper;

import com.gzbugu.common.commonService.ICommonService;

/*
 * 后台任务基类
 * */
public class BaseHelper {

	public ICommonService commonService;
	
	//后期可以添加公共方法

	public ICommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(ICommonService commonService) {
		
		this.commonService = commonService;
	}
	
}

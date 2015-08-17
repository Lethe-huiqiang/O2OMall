package com.jixie.utils;

import java.util.Date;

import com.gzbugu.common.commonService.ICommonService;
import com.jixie.bean.UserLog;

public class UserLogUtils {

	/*
	 * 保存会员操作
	 * userId:会员Id
	 * module：会员业务模块
	 * description：操作描述
	 * */
	public static void saveLog(ICommonService service,String userId,int module,String description){
		UserLog log = new UserLog();
		log.setUserId(userId);
		log.setModule(module);
		log.setDescription(Utils.null2Str(description, 512));
		log.setCreateTime(Utils.date2Stamp(new Date()));
		service.save(log);
	}
}

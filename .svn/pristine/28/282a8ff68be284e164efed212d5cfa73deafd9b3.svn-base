package com.jixie.action.repair;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.jixie.bean.*;


import com.jixie.bean.MemberAchievement;

public class MemberAchievementHelper {

	private static MemberAchievementHelper instance;
	private static final Object obj = new  Object();
	
	public static MemberAchievementHelper getInstance(){
        if(instance==null){
            synchronized (obj) {
                if(instance==null){
                    instance = new MemberAchievementHelper();
                }
            }
        }
        return instance;
    }
	
	
	/**
	 * 获取当前时间戳
	 * @author zejian
	 * @return
	 */
	public static Timestamp getCurrentTimestamp(){
		Timestamp creTime = Timestamp.valueOf(new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss").format(new Date()));
		return creTime;
	}
	
	
	public void initMemberAchievement(MemberAchievement memberachievement){
		
	}
	
	
}

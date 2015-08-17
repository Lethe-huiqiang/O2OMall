package com.jixie.action.repsummary;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.repair.RepairClaimHelper;
import com.jixie.action.users.UsersHelper;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.Repsummary;
import com.jixie.utils.Utils;


public class RepsummaryHelper {
	
	private static RepsummaryHelper instance;
	private static final Object obj = new  Object();

	public static RepsummaryHelper getInstance() {
		if(instance==null){
            synchronized (obj) {
                if(instance==null){
                    instance = new RepsummaryHelper();
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
	
	
	
public void initRepsummaryInfo(Repsummary repsummary){
		
		// 获取repairclaim的ID
		
		//初始化总结信息
		if(repsummary!=null){
			repsummary.setId(repsummary.getId());
			repsummary.setRepairmemid(UsersHelper.getUsersFromSession().getId());
			repsummary.setMachine(repsummary.getMachine());
			repsummary.setLabel(repsummary.getLabel());
			repsummary.setSolution(repsummary.getSolution());
			repsummary.setDescription(repsummary.getDescription());
			repsummary.setIsShare((Integer)repsummary.getIsShare());
		}
	}


public static void setRepsummaryToSession(Repsummary repsummary) {
	ServletActionContext.getRequest().getSession().setAttribute("repsummary", repsummary);
}
/**
  * 从session获取repsummary
  */
public static Repsummary getRepsummaryFromSession(){
	return (Repsummary) ServletActionContext.getRequest().getSession().getAttribute("repsummary");		
}
/**
 * 退出登录
 * 从session清掉repsummary
 */
public static void cleanRepsummaryFromSession() {
	ServletActionContext.getRequest().getSession().invalidate();
}

}

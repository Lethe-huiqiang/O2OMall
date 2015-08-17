package com.jixie.action.repair;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.jixie.bean.RepairManagement;
import com.jixie.system.helper.BaseHelper;
import com.jixie.utils.Utils;

public class RepairManagementHelper extends BaseHelper{

	private static RepairManagementHelper instance;
	private static final Object obj = new  Object();
	
	public static RepairManagementHelper getInstance(){
        if(instance==null){
            synchronized (obj) {
                if(instance==null){
                    instance = new RepairManagementHelper();
                }
            }
        }
        return instance;
    }
	
	
	//创建静态方法  
    public static RepairManagementHelper createRepairManagementHelper(){  
         //返回实例化的类的对象  
        return new RepairManagementHelper();  
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
	
	
//
	
	public void initRepairMInfo(RepairManagement repairmanagement) {
		
		if(repairmanagement != null){
		repairmanagement.setId(repairmanagement.getId());
		repairmanagement.setRepairMemId(repairmanagement.getRepairMemId());
		repairmanagement.setDispatchTime(getCurrentTimestamp());
		repairmanagement.setAcceptState(0);
		repairmanagement.setGetTime(getCurrentTimestamp());
		repairmanagement.setUpdateTime(getCurrentTimestamp());
		repairmanagement.setComment(repairmanagement.getComment());
		repairmanagement.setCommentValue((Integer)repairmanagement.getCommentValue());	
		
		}
		
		
		
	}
	
	
	public void updateFailRepairdo(){	
		
		//repairmanagement表超时更新
		String hql = "update RepairManagement r set r.updateTime = ? , r.acceptState = r.acceptState + 3 where r.acceptState = ?";//默认为0，接受为1，拒绝为2，按时间判断未接单为3
		
		commonService.executeHQL(hql,getCurrentTimestamp(),0);
		
		//repairclaim表超时更新
		String hql2 ="update RepairClaim r set r.state = r.state - 1 where r.state = ?";
		
		commonService.executeHQL(hql2,1);
		
		
	}
	

	public static void setRepairMToSession(RepairManagement repairmanagement) {

		ServletActionContext.getRequest().getSession().setAttribute("repairmanagement",repairmanagement);
		
	}
	/**
	  * 从session获取repairclaim
	  */
	public static RepairManagement getRepairMFromSession(){
		return (RepairManagement) ServletActionContext.getRequest().getSession().getAttribute("repairmanagement");		
	}
	/**
	 * 退出登录
	 * 从session清掉repairclaim
	 */
	public static void cleanRepairMFromSession() {
		ServletActionContext.getRequest().getSession().invalidate();
	}
	
}




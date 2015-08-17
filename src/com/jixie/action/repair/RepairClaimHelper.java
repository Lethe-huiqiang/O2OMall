package com.jixie.action.repair;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.jixie.action.users.UsersHelper;
import com.jixie.bean.Activation;
import com.jixie.bean.RepairClaim;
import com.jixie.bean.Users;
import com.jixie.bean.UsersInfo;
import com.jixie.message.email.MailInfo;
import com.jixie.utils.Utils;

public class RepairClaimHelper {
	
	private static RepairClaimHelper instance;
	private static final Object obj = new  Object();
	
	public static RepairClaimHelper getInstance(){
        if(instance==null){
            synchronized (obj) {
                if(instance==null){
                    instance = new RepairClaimHelper();
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
	
	
	/**
	 * 初始化报修登记时的信息
	 */
	public void initRepairInfo(RepairClaim repairClaim){
		
		// UUID号
		String repairclaimId = UUID.randomUUID().toString().replace("-", ""); // repairclaim表id
		Users users = UsersHelper.getUsersFromSession();
		String macOwnerId = users.getId();
		
		//初始化注册信息
		if(repairClaim!=null){
		//	System.out.println(repairclaim.getId()+"daflskdf");
			repairClaim.setId(repairclaimId);//UUID32位
			repairClaim.setMacOwnerId(macOwnerId);
			repairClaim.setState(0);
			repairClaim.setMacOwner(repairClaim.getMacOwner());
			repairClaim.setLongTel(repairClaim.getLongTel());
			repairClaim.setShortTel(repairClaim.getShortTel());
			repairClaim.setAddress(repairClaim.getAddress());
			repairClaim.setMachine(repairClaim.getMachine());
			repairClaim.setSystem(repairClaim.getSystem());
			repairClaim.setStorage(repairClaim.getStorage());
			repairClaim.setDescription(repairClaim.getDescription());			
			repairClaim.setCreTime(Utils.date2Stamp(new Date()));
		}
	}


	/**
	  * 把repairclaim set进session
	  * @param repairclaim
	  */
	public static void setRepairToSession(RepairClaim repairclaim) {
		ServletActionContext.getRequest().getSession().setAttribute("repairclaim", repairclaim);
	}
	/**
	  * 从session获取repairclaim
	  */
	public static RepairClaim getRepairFromSession(){
		return (RepairClaim) ServletActionContext.getRequest().getSession().getAttribute("repairclaim");		
	}
	/**
	 * 退出登录
	 * 从session清掉repairclaim
	 */
	public static void cleanRepairFromSession() {
		ServletActionContext.getRequest().getSession().invalidate();
	}

}

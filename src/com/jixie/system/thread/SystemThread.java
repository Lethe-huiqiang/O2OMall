package com.jixie.system.thread;

import java.util.Calendar;
import java.util.Date;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gzbugu.common.commonService.ICommonService;
import com.jixie.action.repair.RepairManagementAction;
import com.jixie.action.repair.RepairManagementHelper;
import com.jixie.utils.SystemParameters;


public class SystemThread extends Thread {
	
	//委托任务辅助类
	//private RepairManagementHelper repairManagementHelper ;
	
	//初始化辅助类
	private void initHelper(){
		//加载spring配置文件  
        ApplicationContext ac = new FileSystemXmlApplicationContext("file:F:/tomcat6.0/apache-tomcat-6.0.36/webapps/jixieweb/WEB-INF/applicationContext.xml");  
		//ApplicationContext ac = ContextLoader.getCurrentWebApplicationContext() 
      //调用getBean方法取得被实例化的对象。  
        RepairManagementHelper repairManagementHelper = (RepairManagementHelper) ac.getBean("repairManagementHelper");  
		
       // repairManagementHelper  = RepairManagementHelper.createRepairManagementHelper();
        repairManagementHelper.updateFailRepairdo();
        
        
	}
	
	/**
	 * 定时计算
	 * 
	 * 每天执行一次（暂定2点执行）
	 */
	public void run() {		
		
		long last = 0;
		while (true) {
			last = new Date().getTime();
			Calendar date = Calendar.getInstance(); 
			int hour = date.get(Calendar.HOUR_OF_DAY);//得到24小时机制的  
			int minute = date.get(Calendar.MINUTE);//分钟
			int runTime = SystemParameters.getInt("SYSTEM_RUN_TIME", 2);
			//每天凌晨2点执行一次
			if(hour == runTime && minute < 5){
				//对应每天需要执行的业务，例如,爱情档案表,对方在一个星期内如果不回复,则此爱情档案相对于作废处理
				//另行建立XXTaskHelper类
				/*				loveFileHelper.updateFailLoveFilesStatus();
				entrustHelper.updateFailEntrust();*/
				
				//repairManagementHelper.updateFailRepairdo();
				
				initHelper();
				
				System.out.println("任务执行完成");
			}
			
			try {
				long dCur = new Date().getTime();
				long interval = 5 * 60 * 1000 - dCur + last; //除去执行时间
				last = dCur;
				if (interval > 0)
					sleep(interval);// 休眠5分钟
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}

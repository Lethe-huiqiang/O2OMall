package com.jixie.system;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.jixie.system.thread.SystemThread;
import com.jixie.system.StartUp;

public class ThreadsStartUp extends StartUp {

	private static final long serialVersionUID = 7325040584140432587L;

	public void init(ServletConfig servletConfig) throws ServletException {

		super.init(servletConfig);
		try{
			WebApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(servletConfig.getServletContext());
			onLoad(ctx);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	private boolean onLoad(WebApplicationContext ctx) {

		try {
			//后台线程(可以支持多个线程)
			Thread[] tasks = new Thread[] { new SystemThread()};
			for (int i = 0; i < tasks.length; i++) {
				tasks[i].start();
				System.out.println("[deubg]" + tasks[i].getClass().getSimpleName()
						+ " is running[only running]!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[deubg]load default system configuration fail!!!!!!!!");
		}
		return true;
	}

}

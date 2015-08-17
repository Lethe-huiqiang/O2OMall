package com.jixie.system;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.gzbugu.common.commonService.ICommonService;
import com.jixie.utils.RequestParams;
import com.jixie.utils.SystemParameters;
import com.jixie.utils.SystemUtils;

public class StartUp extends HttpServlet {

	private static final long serialVersionUID = 7325040584140432587L;

	public void init(ServletConfig servletConfig) throws ServletException {

		try {

			WebApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(servletConfig.getServletContext());

			if (onLoad(ctx))
				System.out.println("[init]load systemparameters.........success!");
		} catch (Exception e) {
			System.out.println("[init]load systemparamters.........fail!");
		}

	}

	private boolean onLoad(WebApplicationContext ctx) {

		ICommonService service = (ICommonService) ctx
				.getBean("commonServices");
		SystemParameters.init(new RequestParams());
		SystemUtils.loadSystemConfig(service);
		boolean ret = onLoad(ctx, service); 
		return ret;
	}

	protected boolean onLoad(WebApplicationContext ctx,
			ICommonService service) {
		return true;
	}

}

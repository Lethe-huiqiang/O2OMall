package com.jixie.listener;

import java.util.LinkedHashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.jixie.bean.Commodity;

public class MyHttpSessionListener implements HttpSessionListener  {

	public void sessionCreated(HttpSessionEvent se) {
		 se.getSession().setAttribute("cartmap", new LinkedHashMap<Commodity, Integer>());
		 //se.getSession().setAttribute("favoritemap", new LinkedHashMap<Commodity, Integer>());
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}

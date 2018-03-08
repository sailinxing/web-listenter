package com.lixinxin.listenter;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener {
    public MyHttpSessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  {
    	HttpSession session = se.getSession();
		String id = session.getId();
		HttpSession session1 = (HttpSession) se.getSource();
		String id2 = session1.getId();
		System.out.println(id);
		System.out.println(id2);
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    }
	
}

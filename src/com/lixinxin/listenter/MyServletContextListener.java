package com.lixinxin.listenter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

    public MyServletContextListener() {
        
    }

	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	
    	System.out.println("ServletContext����������");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("ServletContext���󱻴�����");
    }
	
}

package com.lixinxin.listenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyTimer implements ServletContextListener {
    public MyTimer() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 

    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	Timer timer=new Timer();
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    	Date date =null;
    	try {
			 date = sdf.parse("2017-12-17 00:00:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	timer.scheduleAtFixedRate(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("랙풀율！！！");
				
			}
		},date, 1000*60*60*24);
//timer.scheduleAtFixedRate(new TimerTask() {
//			
//			@Override
//			public void run() {
//				System.out.println("랙풀율！！！");
//				
//			}
//		},new Date(), 1000*10);
  }
	
}

package com.lixinxin.listenter;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.lixinxin.domain.User;
import com.lixinxin.util.C3P0Utils;
import com.lixinxin.util.MailUtils;

public class BirthdayEmail implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
    public void contextInitialized(ServletContextEvent sce)  { 
    Timer timer=new Timer();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    Date date=null;
	try {
		date = sdf.parse("2017-12-17 00:00:00");
	} catch (ParseException e) {
		e.printStackTrace();
	}
    timer.scheduleAtFixedRate(new TimerTask() {
		
		@Override
		public void run() {
			QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
			String sql="select * from users where birthday like ?";
			SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd");
			String date1 ="%"+sdf1.format(new Date());
			List<User> userList =null;
			try {
				userList = qr.query(sql, new BeanListHandler<User>(User.class),date1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			for(User user:userList){
				String email = user.getEmail();
				String subject = "生日祝福";
				String emailMsg = "猪，你生日快乐！";
				try {
					MailUtils.sendMail(email, subject, emailMsg);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				System.out.println("向"+user.getName()+"发送了生日祝福！");
			}			
		}
	}, date, 1000*60*60*24);
//	 timer.scheduleAtFixedRate(new TimerTask() {
//			
//			@Override
//			public void run() {
//				QueryRunner qr=new QueryRunner(C3P0Utils.getDataSource());
//				String sql="select * from users where birthday like ?";
//				SimpleDateFormat sdf1=new SimpleDateFormat("MM-dd");
//				String date1 ="%"+sdf1.format(new Date());
//				List<User> userList =null;
//				try {
//					userList = qr.query(sql, new BeanListHandler<User>(User.class),date1);
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				for(User user:userList){
//					String email = user.getEmail();
//					String subject = "生日祝福";
//					String emailMsg = "猪，你生日快乐！";
//					try {
//						MailUtils.sendMail(email, subject, emailMsg);
//					} catch (MessagingException e) {
//						e.printStackTrace();
//					}
//					System.out.println("向"+user.getName()+"发送了生日祝福！");
//				}			
//			}
//		}, new Date(),5000);
    }
	
}

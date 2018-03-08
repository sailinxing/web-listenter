package com.lixinxin.listenter;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class MyServletRequestAttributeListener
 *
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MyServletRequestAttributeListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent srae)  { 
    	System.out.println(srae.getName()+"="+srae.getValue()+":���Ա��Ƴ���");
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent srae)  { 

    	 System.out.println(srae.getName()+"="+srae.getValue()+":���Ա������");
    	 }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent srae)  { 
    	 System.out.println(srae.getName()+":���Ա��޸���="+srae.getValue());
    }
	
}

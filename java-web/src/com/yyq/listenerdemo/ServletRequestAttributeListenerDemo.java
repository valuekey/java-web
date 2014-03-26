package com.yyq.listenerdemo;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Application Lifecycle Listener implementation class ServletRequestAttributeListener
 *
 */
public class ServletRequestAttributeListenerDemo implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public ServletRequestAttributeListenerDemo() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestAttributeListenerDemo#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("request add " + arg0.getName() + arg0.getValue());
    }

	/**
     * @see ServletRequestAttributeListenerDemo#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("request remove " + arg0.getName() + arg0.getValue());
    }

	/**
     * @see ServletRequestAttributeListenerDemo#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("request replace " + arg0.getName() + arg0.getValue() + "替换为 " + arg0.getServletRequest().getAttribute(arg0.getName()));
    }
	
}

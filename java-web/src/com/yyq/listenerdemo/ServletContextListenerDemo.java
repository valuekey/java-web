package com.yyq.listenerdemo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletContextListenerDemo implements ServletContextListener{

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("容器销毁-》》》》" + arg0.getServletContext().getRealPath("/"));
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("容器初始化-》》》》" + arg0.getServletContext().getRealPath("/"));
    }
    
}

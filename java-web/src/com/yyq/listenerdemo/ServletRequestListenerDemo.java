package com.yyq.listenerdemo;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequestListenerDemo implements ServletRequestListener{

    @Override
    public void requestDestroyed(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("request 销毁" + arg0.getServletRequest().getRemoteAddr() + "访问了" + arg0.getServletContext().getContextPath());

    }

    @Override
    public void requestInitialized(ServletRequestEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("request 初始化" + arg0.getServletRequest().getRemoteAddr() + "访问了" + arg0.getServletContext().getContextPath());
    }

}

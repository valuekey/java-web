package com.yyq.listenerdemo;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionListenerDemo implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("a session createed " + arg0.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("a session destroyed " + arg0.getSession().getId());
    }

}

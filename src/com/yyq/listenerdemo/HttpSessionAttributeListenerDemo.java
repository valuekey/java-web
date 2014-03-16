package com.yyq.listenerdemo;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class HttpSessionAttributeListenerDemo implements
        HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("session : " + arg0.getSession().getId() + " add " + arg0.getName() + "," + arg0.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("session : " + arg0.getSession().getId() + " remove " + arg0.getName() + "," + arg0.getValue());

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub

        System.out.println("session : " + arg0.getSession().getId() + " replace " + arg0.getName() + "," + arg0.getValue());

    }

}

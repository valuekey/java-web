package com.yyq.listenerdemo;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class LoginUser implements HttpSessionBindingListener{
    private String name;
    public LoginUser(String name) {
        // TODO Auto-generated constructor stub
        this.setName(name);
    }
    
    
    private String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }


    @Override
    public void valueBound(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("在session中保存LoginUser对象(name = "+ this.getName() +"), sessionid = " + arg0.getSession().getId());
    }


    @Override
    public void valueUnbound(HttpSessionBindingEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("在session中移除LoginUser对象(name = "+ this.getName() +"), sessionid = " + arg0.getSession().getId());
    }
}

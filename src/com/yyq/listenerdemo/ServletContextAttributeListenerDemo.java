package com.yyq.listenerdemo;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerDemo implements ServletContextAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("增加属性----》 属性名称：" + arg0.getName() + ",属性内容： " + arg0.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("删除属性----》 属性名称：" + arg0.getName() + ",属性内容： " + arg0.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("替换属性----》 属性名称：" + arg0.getName() + ",属性内容： " + arg0.getValue());
    }

}

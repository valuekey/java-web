package com.yyq.demo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTag2 extends TagSupport{
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = super.pageContext.getOut();
        
        try {
            out.println("1111111122222");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return TagSupport.SKIP_BODY;
    }
}

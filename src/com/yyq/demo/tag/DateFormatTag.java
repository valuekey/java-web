package com.yyq.demo.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class DateFormatTag extends TagSupport{
    private String format = null;
    
    @Override
    public int doStartTag() throws JspException {
        JspWriter out = super.pageContext.getOut();
        SimpleDateFormat format = new SimpleDateFormat(this.format);
        try {
            out.print(format.format(new Date()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return super.SKIP_BODY;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

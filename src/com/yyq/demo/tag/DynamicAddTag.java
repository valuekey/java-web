package com.yyq.demo.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DynamicAddTag extends SimpleTagSupport implements DynamicAttributes{

    private Map<String, Float> num = new HashMap<String, Float>();
    
    @Override
    public void setDynamicAttribute(String arg0, String arg1, Object arg2)
            throws JspException {
        num.put(arg1, Float.parseFloat(arg2.toString()));
        
    }
    
    @Override
    public void doTag() throws JspException, IOException {
        Float sum = 0f;
        Iterator<Entry<String, Float>> attribute = num.entrySet().iterator();
        while (attribute.hasNext()) {
            sum += attribute.next().getValue();
        }
        super.getJspContext().getOut().write(sum + "");
    }
    
}

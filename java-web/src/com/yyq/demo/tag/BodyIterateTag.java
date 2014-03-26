package com.yyq.demo.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class BodyIterateTag extends BodyTagSupport{
    
    private String id;
    private String name;
    private String scope;
    private Iterator<String> iter;
    
    @Override
    public int doStartTag() throws JspException {
        Object value = null;
        if ("page".equals(this.scope)) {
            value = super.pageContext
                    .getAttribute(name, PageContext.PAGE_SCOPE);
        } else if ("request".equals(this.scope)) {
            value = super.pageContext.getAttribute(name,
                    PageContext.REQUEST_SCOPE);
        } else if ("session".equals(this.scope)) {
            value = super.pageContext.getAttribute(name,
                    PageContext.SESSION_SCOPE);
        } else {
            value = super.pageContext.getAttribute(name,
                    PageContext.APPLICATION_SCOPE);
        }
        
        if (value != null && value instanceof List<?>) {
            this.iter = ((List<String>) value).iterator();
            if (this.iter.hasNext()) {
                super.pageContext.setAttribute(id, this.iter.next());
//                this.iter.next();
                return BodyTagSupport.EVAL_BODY_BUFFERED;
            }
            else {
                return BodyTagSupport.SKIP_BODY;
            }
        }
        return BodyTagSupport.SKIP_BODY;
    }
    
    @Override
    public int doAfterBody() throws JspException {
        if (this.iter.hasNext()) {
            super.pageContext.setAttribute(id, this.iter.next());
            return BodyTagSupport.EVAL_BODY_AGAIN;
        }
        return BodyTagSupport.SKIP_BODY;
    }
    
    @Override
    public int doEndTag() throws JspException {
        try {
            super.bodyContent.writeOut(super.pageContext.getOut());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return super.doEndTag();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}

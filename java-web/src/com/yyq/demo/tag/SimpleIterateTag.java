package com.yyq.demo.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class SimpleIterateTag extends SimpleTagSupport{
    private String id = null;
    private String name = null;
    private String scope = null;
    private Iterator<String> iter = null;
    @Override
    public void doTag() throws JspException, IOException {
        Object value = null;
        if ("page".equals(this.scope)) {
            value = super.getJspContext()
                    .getAttribute(name, PageContext.PAGE_SCOPE);
        } else if ("request".equals(this.scope)) {
            value = super.getJspContext().getAttribute(name,
                    PageContext.REQUEST_SCOPE);
        } else if ("session".equals(this.scope)) {
            value = super.getJspContext().getAttribute(name,
                    PageContext.SESSION_SCOPE);
        } else {
            value = super.getJspContext().getAttribute(name,
                    PageContext.APPLICATION_SCOPE);
        }
        
        if (value != null && value instanceof List<?>) {
            this.iter = ((List<String>) value).iterator();
            while (this.iter.hasNext()) {
                super.getJspContext().setAttribute(id, this.iter.next());
                super.getJspBody().invoke(null);
//                this.iter.next();
//                return TagSupport.EVAL_BODY_INCLUDE;
            }
//            else {
//                return TagSupport.SKIP_BODY;
//            }
        }
//        return TagSupport.SKIP_BODY;
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

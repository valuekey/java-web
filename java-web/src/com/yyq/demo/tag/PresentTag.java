package com.yyq.demo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class PresentTag extends TagSupport{
    private String name = null;
    private String scope = null;
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
        if (value == null) {
            return TagSupport.SKIP_BODY;
        } else {
            return TagSupport.EVAL_BODY_INCLUDE;
        }
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

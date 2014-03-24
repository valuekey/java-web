package com.yyq.demo.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TokenForm extends ActionForm{
    @Override
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        return null;
    }
}

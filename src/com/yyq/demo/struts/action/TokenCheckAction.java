package com.yyq.demo.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.yyq.demo.struts.form.TokenCheckForm;

public class TokenCheckAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String name = ((TokenCheckForm) form).getName();
        if (super.isTokenValid(request)) {
            request.setAttribute("name", name);
            super.resetToken(request);
        } else {
            return mapping.getInputForward();
        }
        return mapping.findForward("seccess");
    }
}

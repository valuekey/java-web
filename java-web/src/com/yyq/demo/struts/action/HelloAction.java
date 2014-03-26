package com.yyq.demo.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.yyq.demo.struts.form.HelloForm;

public class HelloAction extends Action{
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HelloForm helloForm = (HelloForm) form;
        String info = helloForm.getInfo();
        ActionMessages errors = new ActionMessages();
        if (info.length() > 5) {
            errors.add("mm", new ActionMessage("error.chao"));
            super.saveMessages(request, errors);
            return mapping.getInputForward();
        }
        request.setAttribute("msg", info);
        return mapping.findForward("show");
    }
}

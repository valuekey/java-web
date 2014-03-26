package com.yyq.demo.struts.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.yyq.common.CommonDataSource;
import com.yyq.demo.struts.form.RegistForm;

public class RegistAction extends Action{
    private Connection conn;
    private RegistForm registForm;
    
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
    ActionMessages errors = new ActionMessages();
    conn = new CommonDataSource().getDs().getConnection();
    
    registForm = (RegistForm) form;
    
    try {
        if (!isMidExist(registForm.getMid())) {
            insertMember();
            errors.add("info", new ActionMessage("info.zhucechenggong"));
            super.saveMessages(request, errors);
            return mapping.findForward("seccess");
        } else {
            errors.add("info", new ActionMessage("error.zhanghaocunzai"));
            super.saveMessages(request, errors);
            return mapping.getInputForward();
        }
    } catch(Exception e) {
        throw e;
    } finally {
        conn.close();
    }
}

private void insertMember() throws Exception{
    String sql = "insert into member(mid, password, name, address, telephone, zipcode, lastdate, lockflag) " +
    		"values(?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, this.registForm.getMid());
    pstmt.setString(2, this.registForm.getPassword());
    pstmt.setString(3, this.registForm.getName());
    pstmt.setString(4, this.registForm.getAddress());
    pstmt.setString(5, this.registForm.getTelephone());
    pstmt.setString(6, this.registForm.getZipcode());
    pstmt.setDate(7, new java.sql.Date(new Date().getTime()));
    pstmt.setBoolean(8, false);
    
    pstmt.execute();
}

private boolean isMidExist(String mid) throws Exception {
    boolean flag = false;
    String sql = "select mid from member where mid = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, mid);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()){
        flag = true;
    }
    return flag;
}
}

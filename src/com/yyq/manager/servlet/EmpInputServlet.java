package com.yyq.manager.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxh.smart.SmartUpload;
import org.lxh.smart.SmartUploadException;

import com.yyq.manager.factory.DAOFactory;
import com.yyq.manager.vo.Dept;
import com.yyq.manager.vo.Emp;
import com.yyq.util.IPTimeStamp;

public class EmpInputServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String photo = null;
        SmartUpload upload = new SmartUpload();
        upload.initialize(super.getServletConfig(), req, resp);
        try {
            upload.upload();
            if (upload.getFiles().getFile(0).getSize() != 0) {
                IPTimeStamp its = new IPTimeStamp(req.getRemoteAddr());
                String ext = upload.getFiles().getFile(0).getFileExt();
                String fileName = its.getIPTimeRand() + "." + ext;
                photo = this.getServletContext().getRealPath("/") + "upload" + java.io.File.separator + fileName;
                upload.getFiles().getFile(0).saveAs(photo);
            }
        } catch (SmartUploadException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (photo == null || "".equals(photo)) {
            photo = this.getServletContext().getRealPath("/") + "upload" + java.io.File.separator + "default.jpg";
        }
        boolean flag = false;
        try {
            Emp emp = new Emp();
            emp.setEmpno(Integer.parseInt(upload.getRequest().getParameter("empno")));
            emp.setEname(upload.getRequest().getParameter("ename"));
            emp.setJob(upload.getRequest().getParameter("job"));
            emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(upload.getRequest().getParameter("hiredate")));
            emp.setSal(Float.parseFloat(upload.getRequest().getParameter("sal")));
            emp.setComm(Float.parseFloat(upload.getRequest().getParameter("comm")));
            emp.setMgr(Integer.parseInt(upload.getRequest().getParameter("mgr")));
            Dept dept = new Dept();
            dept.setDeptno(Integer.parseInt(upload.getRequest().getParameter("deptno")));
            emp.setDept(dept);
            emp.setPhoto(photo);
            
            flag = DAOFactory.getIEmpDAOIntance().doCreate(emp);
            
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (flag) {
            req.getRequestDispatcher("EmpShowServlet?empno=" + upload.getRequest().getParameter("empno")).forward(req, resp);
        } else {
            req.getRequestDispatcher("emp_input.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

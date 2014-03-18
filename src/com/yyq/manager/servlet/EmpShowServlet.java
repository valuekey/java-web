package com.yyq.manager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyq.manager.factory.DAOFactory;
import com.yyq.manager.vo.Emp;

public class EmpShowServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String empno = req.getParameter("empno");
        Emp emp = null;
        if (empno != null && !"".equals(empno) ){
            try {
                emp = DAOFactory.getIEmpDAOIntance().findById(Integer.parseInt(empno));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        req.setAttribute("emp", emp);
        req.getRequestDispatcher("emp_show.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.doGet(req, resp);
    }
}

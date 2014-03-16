package com.yyq.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyq.demo.factory.DAOFactory;
import com.yyq.demo.vo.User;

public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String path = "login.jsp";
        String userid = req.getParameter("userid");
        String password = req.getParameter("password");
        List<String> info = new ArrayList<String>();
        if (userid == null || "".equals(userid)) {
            info.add("用户ID不能为空");
        }
        if (password == null || "".equals(password)) {
            info.add("密码不能为空");
        }
        
        if (info.size() == 0) {
            User user = new User();
            user.setUserid(userid);
            user.setPassword(password);
            try {
                if (DAOFactory.getIUserDAOInstance().findLogin(user)) {
                    info.add("用户登录成功，欢迎" + user.getName() + "光临");
                } else {
                    info.add("用户登录失败，错误的用户名和密码！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                DAOFactory.getIEmpDAOInstance();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        req.setAttribute("info", info);
        req.getRequestDispatcher(path).forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

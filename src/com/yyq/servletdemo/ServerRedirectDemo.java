package com.yyq.servletdemo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServerRedirectDemo extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getSession().setAttribute("name", "严英权");
        req.setAttribute("info", "hhaa");
        RequestDispatcher rd = req.getRequestDispatcher("get_info.jsp");
        rd.forward(req, resp);
        System.out.println("看看");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

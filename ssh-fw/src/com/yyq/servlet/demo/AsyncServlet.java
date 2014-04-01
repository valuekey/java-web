package com.yyq.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yyq.runnable.Executor;

@WebServlet(urlPatterns={"/async"}, asyncSupported=true)
public class AsyncServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getSession().setAttribute("yyq", "严英权");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out =  resp.getWriter();
		out.println("启动异步处理");
		out.flush();
		AsyncContext actx = req.startAsync();
		actx.setTimeout(3*1000);
		actx.start(new Executor(actx));
		out.println("完成启动异步处理");
		out.flush();
		
	}
}

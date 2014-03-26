package com.yyq.servlet.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="firstServlet", urlPatterns={"/firstServlet"}, initParams={
		@WebInitParam(value="www.baidu.com", name="info")
})
public class FirstServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html;charset=UTF-8");
//		resp.getOutputStream().println("严英权");
		resp.getWriter().println("严英权");
//		resp.getWriter().println("严英权");
//		resp.getWriter().println("</html>");
	}
}

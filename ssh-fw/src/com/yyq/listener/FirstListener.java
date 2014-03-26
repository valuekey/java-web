package com.yyq.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener
public class FirstListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	    String DSNAME = sce.getServletContext().getInitParameter("DSNAME");
	    Context ctx = null;
	    DataSource ds = null;
		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DSNAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		sce.getServletContext().setAttribute("DataSource", ds);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		sce.getServletContext().removeAttribute("DataSource");
	}
}

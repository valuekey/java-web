package com.yyq.runnable;

import javax.servlet.AsyncContext;

public class Executor implements Runnable{

	AsyncContext actx = null;
	
	public Executor(AsyncContext actx) {
		// TODO Auto-generated constructor stub
		this.actx = actx;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10*1000);
			actx.getRequest().setAttribute("info", "www.baidu.com");
			actx.dispatch("/async.jsp");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

package com.yyq.struts2.intercepter;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {
	private static final long serialVersionUID = -6338482908501700024L;
	
	private static final String LOGIN = "login";
	
	private static final String USERNAME = "username";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Object action = invocation.getAction();
		
		if (action instanceof LoginAction) {
			return invocation.invoke();
		} else {
			Map<String, Object> session = invocation.getInvocationContext().getSession();
			
			if (session.get(USERNAME) == null) {
				return LOGIN;
			} else {
				return invocation.invoke();
			}
		}
	}
}

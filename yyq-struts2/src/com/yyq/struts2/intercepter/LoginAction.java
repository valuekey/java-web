package com.yyq.struts2.intercepter;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = -7498867485538586756L;

	private String username;

	private Map<String, Object> session;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String login() throws Exception {
		if ("yyq".equals(this.username)) {
			this.session.put("username", this.username);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String toLoginView() throws Exception {
		return "login";
	}
	
	

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
	
}

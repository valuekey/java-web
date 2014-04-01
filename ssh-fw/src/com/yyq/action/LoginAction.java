package com.yyq.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public String execute() throws Exception {
//		// TODO Auto-generated method stub
		if (this.getUsername().equals("yyq") && this.getPassword().equals("123")) {
//			ActionContext.getContext().getSession().put("user", this.getUsername());
			
			ActionContext.getContext().getSession().put("info", "www.baidu.com");
			
			
			return "success";
		} else {
			return "error";
		}
		
	}
}

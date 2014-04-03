package com.yyq.struts2.token;

import com.opensymphony.xwork2.ActionSupport;

public class TokenAction extends ActionSupport {
	private static final long serialVersionUID = -5306728309542239052L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toTokenView() throws Exception {
		return "tokenView";
	}
	
	public String token() throws Exception {
		return SUCCESS;
	}
}

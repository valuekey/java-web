package com.yyq.struts2.action;

import org.apache.struts2.ServletActionContext;


public class HelloWorldAction{
	public String execute() throws Exception {
		
		String path = ServletActionContext.getServletContext().getRealPath("/");
		
		System.out.println(path);
		return "success";
	}
	
	public String save() throws Exception {
		System.out.println("save");
		return "save";
	}
	
	public String upload() throws Exception {
		System.out.println("upload");
		return "upload";
	}
}

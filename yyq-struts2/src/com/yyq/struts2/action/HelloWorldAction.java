package com.yyq.struts2.action;


public class HelloWorldAction{
	public String execute() throws Exception {
		System.out.println("execute");
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

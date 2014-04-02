package com.yyq.struts2.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class RegAction extends ActionSupport {

	private static final long serialVersionUID = -4203168491245758775L;

	private String name;
	private Integer age;
	
	private File photo;
	private String photoFileName;
	private String photoContentType;
	
	
	public File getPhoto() {
		return photo;
	}
	public void setPhoto(File photo) {
		this.photo = photo;
	}
	public String getPhotoFileName() {
		return photoFileName;
	}
	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}
	public String getPhotoContentType() {
		return photoContentType;
	}
	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
	
	public String toRegView() {
		return "regview";
	}
	
	public String reg() {
		
		String ext = this.photoFileName.substring(this.photoFileName.lastIndexOf("."));
		String path = ServletActionContext.getServletContext().getRealPath("/") + getText("upload.file.dir");
		Long l = System.nanoTime();
		
		File newFile = new File(path, l + ext);
		
		this.photo.renameTo(newFile);
		
		return SUCCESS;
	}
	
	
	public void validate() {
		if (name == null || name.isEmpty()) {
			addFieldError("name", getText("errors.empty", new String[]{"用户名"}));
		}
	}
}

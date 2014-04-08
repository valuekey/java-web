package com.yyq.struts2.ognl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.yyq.struts2.model.Address;

public class OgnlAction extends ActionSupport {
	
	private static final long serialVersionUID = 6418254214824609617L;

	private String[] names = new String[10];
	private Object age;
	private List list;
	private Map map;
	
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Object getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String[] getNames() {
		return names;
	}

	public void setNames(String[] names) {
		this.names = names;
	}
	
	public String reg() {
		return SUCCESS;
	}
	
	public String toView() {
		return "view";
	}
	
	public String saveData() {
		ServletActionContext.getRequest().setAttribute("username", "requestusername");
		ServletActionContext.getRequest().getSession().setAttribute("username", "sessionusername");
		ServletActionContext.getServletContext().setAttribute("username", "applicationusername");
		ServletActionContext.getContext().getValueStack().set("username", "vsusername");
		initList();
		return "showView";
	}
	
	private void initList() {
		this.list = new ArrayList<Address>();
		for (int i = 0; i < 10; i++) {
			Address _address = new Address();
			_address.setCity("city" + i);
			_address.setStreet("street" + i);
			this.list.add(_address);
		}
 	}
}

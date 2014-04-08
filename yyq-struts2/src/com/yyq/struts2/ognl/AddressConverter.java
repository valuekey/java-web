package com.yyq.struts2.ognl;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.yyq.struts2.model.Address;

public class AddressConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		for (String temp : values) {
			String[] arr =  temp.split("-");
			Address a = new Address();
			a.setCity(arr[0]);
			a.setStreet(arr[1]);
			return a;
		}
		
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		
		return o.toString();
	}

}

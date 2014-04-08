<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view.jsp</title>
</head>
<body>
<s:form action="OgnlAction_reg" namespace="/ognl" method="post">
	<s:textfield name="names[0]" key="username"/>
	<s:textfield name="names[1]" key="username"/>
	<s:textfield name="names[2]" key="username"/>

	<s:textfield name="age" key="age"/>
	<s:textfield name="list[0]" key="username"/>
	<s:textfield name="list[1]" key="username"/>
	<s:textfield name="list[2]" key="username"/>
	
	<s:textfield name="map[11]" key="username"/>
	<s:textfield name="map[111]" key="username"/>
	<s:textfield name="map[1111]" key="username"/>
	
	<s:textfield name="address" label="dizhi"></s:textfield>
	<s:submit />
	
</s:form>
<s:property value="address"/>
</body>
</html>
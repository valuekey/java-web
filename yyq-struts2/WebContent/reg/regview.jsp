<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>regview.jsp</title>
</head>
<body>
<s:form action="RegAction_reg" namespace="/regns" enctype="multipart/form-data">
	<s:textfield name="name" key="username"/>
	<s:textfield name="age" key="age" />
	<s:file name="photo" key="photo" />
	<s:submit />
</s:form>
</body>
</html>
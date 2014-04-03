<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>tokenView.jsp</title>
</head>
<body>
<s:actionerror/>
<s:form action="TokenAction_token" namespace="/tokenPackge" method="post">
	<s:token />
	<s:textfield name="name" key="username"/>
	<s:submit />
</s:form>
</body>
</html>
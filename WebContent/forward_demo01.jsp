<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>forward_demo01</title>
</head>
<body>
<% String name = new String("哈哈哈"); %>
<jsp:forward page="forward_demo02.jsp">
    <jsp:param value="呵" name="name"/>
    <jsp:param value="27" name="age"/>
</jsp:forward>
</body>
</html>
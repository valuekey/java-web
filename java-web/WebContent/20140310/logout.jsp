<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate();
response.addHeader("refresh", "3;URL=login.jsp");
%>
注销成功，3秒自动跳转到登陆画面，<a href="login.jsp">手动跳转</a>
</body>
</html>
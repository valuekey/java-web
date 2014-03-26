<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean" scope="page" class="com.yyq.demo.SimpleBean">
<%
bean.setName("YYQ");
bean.setAge(27);
%>
姓名：<%=bean.getName() %><br>
年龄：<%=bean.getAge() %>
</jsp:useBean>
</body>
</html>
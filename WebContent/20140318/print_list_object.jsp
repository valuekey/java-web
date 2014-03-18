<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.yyq.manager.vo.Dept"%>
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
Dept dept = null;
List<Dept> all = new ArrayList<Dept>();
dept = new Dept();
dept.setDeptno(10);
dept.setDname("www.baidu.com");
all.add(dept);
dept = new Dept();
dept.setDeptno(20);
dept.setDname("www.google.com");
all.add(dept);
request.setAttribute("info", all);
%>
${info[0] }<br>
${info[1] }
</body>
</html>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
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
Map<String, String> map = new HashMap<String, String>();
map.put("name", "严英权");
map.put("info", "www.baidu.com");
request.setAttribute("myMap", map);
%>
${myMap["name"] }<br>
${myMap.info }
</body>
</html>
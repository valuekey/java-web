<%@page import="java.net.URLEncoder"%>
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
  String name = URLEncoder.encode("严英权", "UTF-8");
  Cookie cookie1 = new Cookie("name",name);
  Cookie cookie2 = new Cookie("age","27");
  response.addCookie(cookie1);
  response.addCookie(cookie2);
  response.sendRedirect("response_demo07.jsp");
%>
</body>
</html>
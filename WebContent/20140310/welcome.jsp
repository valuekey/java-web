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
if (session.getAttribute("loginState") != null && session.getAttribute("loginState").equals("1")) {
    %>
    登录成功！~<a href="logout.jsp">注销</a>
    <%
} else {
    %>
    还没有登陆，<a href="login.jsp">请登陆</a>
    <%
}
%>
</body>
</html>
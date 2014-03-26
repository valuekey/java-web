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
String username = request.getParameter("username");
String password = request.getParameter("password");

if (username != null && username.equals("yyq") && password != null && password.equals("123")) {
        session.setAttribute("loginState", "1");
        %>
        <jsp:forward page="welcome.jsp"></jsp:forward>
        <%
}
else {
    %>
    账号或密码错误，请重新登录！~<br>
    <%
}

%>

<form action="" method="get">
用户名：<input type="text" name="username"><br>
密码：<input type="password" name="password"><input type="submit" value="登陆">
</form>
</body>
</html>
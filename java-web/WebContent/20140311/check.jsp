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
if ("1".equals(session.getAttribute("loginState"))) {
    %>
    <jsp:forward page="goods.jsp"></jsp:forward>
    <%
}

String userid = request.getParameter("userid");
String password = request.getParameter("password");
String imagecode = request.getParameter("imagecode");
String rand = (String) session.getAttribute("rand");
String remenberpwd = request.getParameter("remenberpwd");

Cookie cookie1 = new Cookie("remenberpwd", remenberpwd);
Cookie cookie2 = new Cookie("password", password);
Cookie cookie3 = new Cookie("userid", userid);
cookie1.setMaxAge(60);
cookie2.setMaxAge(60);
cookie3.setMaxAge(3600);
response.addCookie(cookie1);
response.addCookie(cookie2);
response.addCookie(cookie3);


if (!imagecode.equals(rand)) {
    response.sendRedirect("login.jsp?failcode=1");
} else if ("yyq".equals(userid) && "123".equals(password)) {
    session.setAttribute("loginState", "1");
    session.setAttribute("userid", userid);
    response.sendRedirect("goods.jsp");
}
%>
</body>
</html>
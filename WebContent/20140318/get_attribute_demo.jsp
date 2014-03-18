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
pageContext.setAttribute("info", "yyq1");
request.setAttribute("info", "yyq2");
session.setAttribute("info", "yyq3");
this.getServletContext().setAttribute("info", "yyq4");
%>
${info}<br>
${pageScope.info}<br>
${requestScope.info}<br>
${sessionScope.info}<br>
${applicationScope.info}<br>
</body>
</html>
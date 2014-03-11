<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="reg" scope="request"  class="com.yyq.demo.Register"></jsp:useBean>
<jsp:setProperty property="*" name="reg"/>
<%
if (reg.isVaildate()) {
    %>
    <jsp:forward page="seccess.jsp"></jsp:forward>
    <%
} else {
    %>
    <jsp:forward page="index.jsp"></jsp:forward>
    <%
}
%>
</body>
</html>
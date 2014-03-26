<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.yyq.demo.vo.User"%>
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
List<String> info = (List<String>) request.getAttribute("info");
if (info != null) {
    Iterator<String> iter = info.iterator();
    while (iter.hasNext()) {
        %>
        <h4><%=iter.next() %></h4>
        <%
    }
}
%>
<form action="LoginServlet" method="post">
<table>
    <tr>
        <td>用户ID：</td>
        <td><input type="text" name="userid"></td>
    </tr>
    <tr>
        <td>密&nbsp;&nbsp;码：</td>
        <td><input type="password" name="password"></td>
    </tr>
</table>
<input type="submit" value="登录">
</form>
</body>
</html>
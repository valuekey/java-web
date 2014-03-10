<%@page import="java.util.Enumeration"%>
<%@page import="org.apache.catalina.util.Enumerator"%>
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
Enumeration enu = this.getServletContext().getAttributeNames();
while(enu.hasMoreElements()) {
    String name = (String)enu.nextElement();
    %>
    <%=name %> ->>>>>>>> <%=this.getServletContext().getAttribute(name) %><br>
    <%
    
}
%>
</body>
</html>
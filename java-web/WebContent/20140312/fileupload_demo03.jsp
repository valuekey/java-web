<%@page import="java.util.List"%>
<%@page import="com.yyq.util.FileUploadTools"%>
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
FileUploadTools fut = new FileUploadTools(request, 5 * 1024 * 1024, this.getServletContext().getRealPath("/") + "uploadtemp");
String name = fut.getParameter("name");
String[] ints = fut.getParameterValues("inst");
List<String> all = fut.saveAll(this.getServletContext().getRealPath("/") + "upload" + java.io.File.separator);
%>

<%=name %><br>
<% 
for (String temp : ints) {
    %><%=temp%>,<%
}
%><br><%

for (String fileName : all) {
    %><img alt="" src="../upload/<%=fileName%>">&nbsp;&nbsp;&nbsp;<%
}
%>


</body>
</html>
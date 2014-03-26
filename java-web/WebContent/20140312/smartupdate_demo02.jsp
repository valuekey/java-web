<%@page import="com.yyq.util.IPTimeStamp"%>
<%@page import="org.lxh.smart.SmartUpload"%>
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
SmartUpload smartUpload = new SmartUpload();
smartUpload.initialize(pageContext);
smartUpload.upload();
IPTimeStamp its = new IPTimeStamp(request.getRemoteAddr());
String ext = smartUpload.getFiles().getFile(0).getFileExt();
String fileName = its.getIPTimeRand() + "." + ext;
smartUpload.getFiles().getFile(0).saveAs(getServletContext().getRealPath("/") + "upload" + java.io.File.separator + fileName);
String uname = smartUpload.getRequest().getParameter("uname");
%>
<%=uname %><br>
<%=request.getParameter("uname") %><br>
<img alt="" src="../upload/<%=fileName%>">
</body>
</html>
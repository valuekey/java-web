<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.PrintStream"%>
<%@ page import="java.io.File" %>
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
String fileName = request.getParameter("fileName");
String fileContent = request.getParameter("fileContent");
File file = null;

if (fileName != null && !"".equals(fileName) && fileContent != null && !"".equals(fileContent)) {
    String filePath = this.getServletContext().getRealPath("/") + "note" + File.separator;
    
    file = new File(filePath + fileName);
    if (!file.getParentFile().exists()){
        file.getParentFile().mkdir();
    }
    PrintStream ps = null;
    ps = new PrintStream(new FileOutputStream(file));
    ps.println(fileContent);
    ps.close();
    
}

%>
<%
Scanner scan = new Scanner(new FileInputStream(file));
scan.useDelimiter("\n");
StringBuffer buf = new StringBuffer();
while(scan.hasNext()) {
    buf.append(scan.next()).append("<br>");
}

%>
<%=buf.toString().replace(" ", "&nbsp;") %>
<%
%>
</body>
</html>
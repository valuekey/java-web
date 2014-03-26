<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
List<String> all = new ArrayList<String>();
all.add("YYQ1");
all.add("YYQ1");
request.setAttribute("allList", all);

Set<String> all1 = new HashSet<String>();
all1.add("yyq1");
all1.add("yyq2");
all1.add("yyq3");
request.setAttribute("allSet", all1);
%>
${allList[0] }<br>
${allList[1] }<br>
${allList[2] }<br>


</body>
</html>
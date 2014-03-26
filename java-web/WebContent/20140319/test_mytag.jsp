<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="u" uri="yyq_hello" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
List<String> all = new ArrayList<String>();
all.add("www.baidu.com");
all.add("www.youku.com");
all.add("www.sina.com");
request.setAttribute("all", all);
pageContext.setAttribute("info", "haha");
%>

<body>
<u:hello/><br>
<u:hello2/><br>
<u:date format="yyyy-MM-dd"></u:date><br>
<u:present name="all" scope="request">
    <u:iterate name="all" scope="request" id="url">
        <%=url.toUpperCase() %><input type="text"/>
    </u:iterate>
</u:present>
<u:present name="all" scope="request">
    <u:bodyiterate name="all" scope="request" id="url">
        <%=url %>
    </u:bodyiterate>
</u:present>

     <u:simpleiterate name="all" scope="request" id="url">
        ${url }
    </u:simpleiterate> 

<u:add num1="0.417" num2="0.13" num3="1123.7"/>
</body>
</html>
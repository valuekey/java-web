<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/20140322/struts-lib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("info", "yyq");
%>
<logic:notPresent name="info" scope="page">
    不存在
</logic:notPresent>

<logic:present name="info">
    存在
</logic:present>

<logic:empty name="info" scope="page">
    info是空
</logic:empty>

<logic:equal value="yyq" name="info">
    info = yyq
</logic:equal>


<%
String arr[] = {"www.baidu.com","www.sina.com.cn","bilibili.tv"};
request.setAttribute("www", arr);

List<String> list = new ArrayList<String>();
list.add("list.baidu.com");
list.add("list.sina.com.cn");
list.add("list.bilibili.tv");
request.setAttribute("listwww", list);

Map<String, String> map = new HashMap<String, String>();
map.put("百度", "map.baidu.com");
map.put("新浪", "map.sina.com.cn");
map.put("哔哩哔哩", "map.bilibili.tv");
request.setAttribute("mapwww", map);

%>
<h3>数组</h3>
<logic:iterate id="array1" name="www" scope="request">
    <a href="http://${array1}">${array1}</a><br>
</logic:iterate>
<h3>LIST</h3>
<logic:iterate id="array2" name="listwww" scope="request">
    ${array2 }<br>
</logic:iterate>
<h3>MAP</h3>
<logic:iterate id="array3" name="mapwww" scope="request">
    ${array3.key }-->${array3.value }<br>
</logic:iterate>

<logic:redirect forward="hello"></logic:redirect>
</body>
</html>
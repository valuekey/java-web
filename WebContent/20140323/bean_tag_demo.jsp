<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/20140322/struts-lib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html lang="true">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<bean:define id="info1" scope="page">你好</bean:define>
${info1 }
<bean:define id="info1" type="java.lang.String" scope="page" name="info1" toScope="session"/>
${sessionScope.info1 }
<%
List<String> list = new ArrayList<String>();
list.add("www.baidu.com");
list.add("www.imyyq.com");
request.setAttribute("all", list);
%>

<bean:size id="length" name="all" scope="request"/><br>
${length }

<bean:cookie name="userid" id="cookie1" value="www.hao123.com"/>
<%
cookie1.setMaxAge(30);
response.addCookie(cookie1);
Cookie cookies[] = request.getCookies();
for (int i = 0; i < cookies.length; i++) {
    String temp = cookies[i].getName() + "---->" + cookies[i].getValue() + "<br>";
    out.print(temp);
}
%>
<bean:header name="lll" id="header1" value="lllvalue"/>
${header1 }
<br>
${pageContext.request.cookies[0].value }

<%-- <bean:parameter name="u" id="uname"/>
${uname }<br> --%>
${param.u }
<br>
<bean:write name="all"/>
<bean:include id="xmlfile" href="http://www.bilibili.tv"/>
<bean:message key="error.info"/>
</body>
</html:html>
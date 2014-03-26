<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
pageContext.setAttribute("date", new Date());
%>
${date }<br>
<fmt:setLocale value="zh_CN"/>
<fmt:formatDate value="${date }"/><br>
<fmt:setLocale value="en_US"/>
<fmt:formatDate value="${date }"/>

<fmt:setBundle basename="Message" var="message"/>
    <fmt:message key="name" var="yyq" bundle="${message }">
        <fmt:param>你好！~</fmt:param>
    </fmt:message>
${yyq }
<br>

<fmt:message key="info" var="info" bundle="${message }"></fmt:message>
${info }
<br>
<fmt:setTimeZone value="HST"/>
<fmt:formatDate value="${date }" pattern="yyyy-MM-dd hh:mm:ss SSS"/>
</body>
</html>
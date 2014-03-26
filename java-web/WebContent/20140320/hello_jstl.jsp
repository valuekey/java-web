<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:out value="<><>"></c:out>

<br>
<c:catch var="error">
    <%
    int a = 10/0;
    %>
</c:catch>

${error }

<c:if test="${10<30 }" var="ifif">
dui
</c:if>
<br>
${ifif }
<br>

<%
pageContext.setAttribute("num", 11);
%>
<c:choose>
    <c:when test="${num == 10 }">is 10</c:when>
    <c:when test="${num == 20 }">is 20</c:when>
    <c:otherwise>no</c:otherwise>
</c:choose>

<%

Vector vector = new Vector();
vector.add(0, "www.baidu.com");
vector.add(1, "www.google.com");
request.setAttribute("info", vector);
%>
<br>
<c:forEach items="${info }" var="tempinfo" begin="1">
    <c:forTokens items="${tempinfo }" delims="." var="name">
        ${name }-
    </c:forTokens>
</c:forEach>

<%
Map map = new HashMap();
map.put("yyq", "haha");
map.put("ntt", "hehe"); 
Set temp = map.entrySet(); 
/* out.print(((Map.Entry)temp.iterator().next()).getValue()); */

request.setAttribute("map", map);


%><br>
<c:forEach items="${map }" var="mapinfo">
    ${mapinfo.key } ->>>> ${mapinfo.value }
</c:forEach><br>

<%-- <c:import url="http://seo.chinaz.com/" charEncoding="UTF-8">
<c:param name="host" value="www.baidu.com"></c:param>
</c:import> --%>

<c:url var="urlinfo" value="http://www.sina.com">
    
</c:url>

<a href="${urlinfo }">点击</a>

<c:redirect url="http://www.baidu.com"></c:redirect>
</body>
</html>
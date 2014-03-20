<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="x" uri="/WEB-INF/tld/x.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="/20140320/emps.xml" charEncoding="UTF-8" var="xx"/>
<x:parse doc="${xx}" var="addxml"/>
<x:out select="$addxml/emps/emp[1]/empno"/>

</body>
</html>
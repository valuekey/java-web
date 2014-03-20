<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="/WEB-INF/tld/sql.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource dataSource="jdbc/java-web" var="ds"/>
<sql:query var="result" dataSource="${ds }" sql="select empno from emp" />
<c:forEach items="${result.rowsByIndex }" var="row">
    ${row[0] }
</c:forEach>

<br>
<sql:query var="result" dataSource="${ds }" maxRows="1" startRow="1">
    select empno, ename from emp;
</sql:query>
<sql:transaction dataSource="${ds }"></sql:transaction>
</body>
</html>
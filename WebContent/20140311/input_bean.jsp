<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean" scope="page" class="com.yyq.demo.SimpleBean"></jsp:useBean>
<%-- <jsp:setProperty property="*" name="bean"/> --%>
<jsp:setProperty property="name" name="bean" param="age"/>
<jsp:setProperty property="age" name="bean" param="name"/>
<%-- <%=bean.getName() %><br>
<%=bean.getAge() %> --%>

<jsp:getProperty property="name" name="bean"/>
<jsp:getProperty property="age" name="bean"/>
</body>
</html>
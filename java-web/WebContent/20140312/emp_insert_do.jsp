<%@page import="com.yyq.demo.factory.DAOFactory"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="emp" scope="page" class="com.yyq.demo.vo.Emp" ></jsp:useBean>
<%
try {

emp.setEmpno(Integer.parseInt(request.getParameter("empno")));
emp.setEname(request.getParameter("ename"));
emp.setJob(request.getParameter("job"));
emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate")));
emp.setSal(Float.parseFloat(request.getParameter("sal")));

if (DAOFactory.getIEmpDAOInstance().doCreate(emp)){
    %>
    录入成功
    <%
} else {
    %>
    录入失败
    <%
}
} catch (Exception e) {
    e.printStackTrace();
}
%>

</body>
</html>
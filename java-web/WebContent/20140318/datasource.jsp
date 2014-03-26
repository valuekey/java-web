<%@page import="com.yyq.manager.vo.Emp"%>
<%@page import="com.yyq.manager.dao.impl.EmpDAOImpl"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
String DSNAME = "java:comp/env/jdbc/java-web";
Context ctx = new InitialContext();
DataSource ds = (DataSource) ctx.lookup(DSNAME);
Connection conn = ds.getConnection();

EmpDAOImpl dao = new EmpDAOImpl(conn);
Emp emp = null;
emp = dao.findById(1001);
conn.close();
%>
<table>
    <tr>
        <td>雇员编号：</td>
        <td><%=emp.getEmpno() %></td>
    </tr>
    <tr>
        <td>雇员姓名：</td>
        <td><%=emp.getEname() %></td>
    </tr>
    <tr>
        <td>雇员工作：</td>
        <td><%=emp.getJob() %></td>
    </tr>
    <tr>
        <td>雇佣日期：</td>
        <td><%=emp.getHiredate() %></td>
    </tr>
    <tr>
        <td>基本工资：</td>
        <td><%=emp.getSal() %></td>
    </tr>
    <tr>
        <td>奖金：</td>
        <td><%=emp.getComm() %></td>
    </tr>
    <tr>
        <td>领导编号：</td>
        <td><%=emp.getMgr() %></td>
    </tr>
    <tr>
        <td>部门编号：</td>
        <td><%=emp.getDept().getDeptno() %></td>
    </tr>
    <tr>
        <td>照片：</td>
        <td><img alt="" src="<%=emp.getPhoto() %>"></td>
    </tr>
</table>

</body>
</html>
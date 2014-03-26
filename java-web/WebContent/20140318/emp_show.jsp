<%@page import="com.yyq.manager.vo.Emp"%>
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
Emp emp = (Emp) request.getAttribute("emp");
%>
<form action="EmpInputServlet" method="post" enctype="multipart/form-data">
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
<input type="button" value="修改">
</form>

</body>
</html>
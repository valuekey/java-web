<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="EmpInputServlet" method="post" enctype="multipart/form-data">
<table>
    <tr>
        <td>雇员编号：</td>
        <td><input type="text" name="empno"></td>
    </tr>
    <tr>
        <td>雇员姓名：</td>
        <td><input type="text" name="ename"></td>
    </tr>
    <tr>
        <td>雇员工作：</td>
        <td><input type="text" name="job"></td>
    </tr>
    <tr>
        <td>雇佣日期：</td>
        <td><input type="text" name="hiredate"></td>
    </tr>
    <tr>
        <td>基本工资：</td>
        <td><input type="text" name="sal"></td>
    </tr>
    <tr>
        <td>奖金：</td>
        <td><input type="text" name="comm"></td>
    </tr>
    <tr>
        <td>领导编号：</td>
        <td><input type="text" name="mgr"></td>
    </tr>
    <tr>
        <td>部门编号：</td>
        <td><input type="text" name="deptno"></td>
    </tr>
    <tr>
        <td>照片：</td>
        <td><input type="file" name="photo"></td>
    </tr>
</table>
<input type="submit" value="登录"><input type="reset" value="重置">
</form>
</body>
</html>
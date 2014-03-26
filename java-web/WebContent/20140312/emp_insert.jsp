<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="emp_insert_do.jsp" method="post">
<table>
<tr>
<td>员工编号：</td>
<td><input type="text" name="empno"><br></td>
</tr>
<tr>
<td>员工姓名：</td>
<td><input type="text" name="ename"><br></td>
</tr>
<tr>
<td>工作：</td>
<td><input type="text" name="job"><br></td>
</tr>
<tr>
<td>入职日期：</td>
<td><input type="text" name="hiredate"><br></td>
</tr>
<tr>
<td>工资：</td>
<td><input type="text" name="sal"><br></td>
</tr>

</table>
<input type="submit" value="录入">
</form>
</body>
</html>
<%@page import="com.yyq.demo.dao.proxy.IEmpDAOProxy"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yyq.demo.vo.Emp"%>
<%@page import="com.yyq.demo.dbc.DataBaseConntction"%>
<%@page import="java.util.List"%>
<%@page import="com.yyq.util.FileUploadTools"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.yyq.demo.factory.DatabaseConnectionFactory"%>
<%@page import="com.yyq.demo.factory.DAOFactory"%>
<%@page import="java.io.File"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="org.lxh.smart.SmartUpload"%>
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
DataBaseConntction dbc = DatabaseConnectionFactory.getDataBaseConntction();
try {
FileUploadTools fut = new FileUploadTools(request, 5 * 1024 * 1024, this.getServletContext().getRealPath("/") + "uploadtemp");
List<String> all = fut.saveAll(dbc.getConnection());
Emp emp = new Emp();
emp.setEmpno(Integer.parseInt(fut.getParameter("empno")));
emp.setEname(fut.getParameter("ename"));
emp.setJob(fut.getParameter("job"));
emp.setHiredate(new SimpleDateFormat("yyyy-MM-dd").parse(fut.getParameter("hiredate")));
emp.setSal(Float.parseFloat(fut.getParameter("sal")));
emp.setPic(all.get(0));

DAOFactory.getIEmpDAOInstance().doCreate(emp);
} catch (Exception e) {
    e.printStackTrace();
} finally {
    dbc.close();
}
%>
</body>
</html>
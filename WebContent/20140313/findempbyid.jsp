<%@page import="com.yyq.demo.vo.Emp"%>
<%@page import="com.yyq.demo.factory.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="" method="post">
        <input type="text" name="id"><input type="submit"
            value="查询"><br>
        <%
            String id = request.getParameter("id");
            Emp emp = null;
            if (id != null && !"".equals(id)) {
                emp = DAOFactory.getIEmpDAOInstance().findById(
                        Integer.parseInt(id));
            }
            if (emp != null) {
        %>
        <table border="1">
            <tr>
                <td>员工编号：</td>
                <td><%=emp.getEmpno() %></td>
            </tr>
            <tr>
                <td>员工姓名：</td>
                <td><%=emp.getEname() %></td>
            </tr>
            <tr>
                <td>工作：</td>
                <td><%=emp.getJob() %></td>
            </tr>
            <tr>
                <td>入职日期：</td>
                <td><%=emp.getHiredate() %></td>
            </tr>
            <tr>
                <td>工资：</td>
                <td><%=emp.getSal() %></td>
            </tr>
            <tr>
                <td>照片：</td>
                <td><%if(emp.getPic() != null && !"".equals(emp.getPic())){
                    %><img alt="" src="showpic.jsp?picname=<%=emp.getPic() %>"><%
                } %></td>
            </tr>
        </table>
        <%
}
%>
    </form>
</body>
</html>
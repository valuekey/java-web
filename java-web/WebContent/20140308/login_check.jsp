<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="com.yyq.common.CommonConsts"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="com.mysql.jdbc.Connection"%>
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
String userid = request.getParameter("userid"); 
String password = request.getParameter("password");
String name = null;

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
    Class.forName(CommonConsts.MYSQL_DRIVER);
    conn = (Connection)DriverManager.getConnection(CommonConsts.MYSQL_URL, CommonConsts.MYSQL_USER, CommonConsts.MYSQL_PASSWORD);
    String sql = "select t1.name from user t1 where t1.userid = ? and t1.password = ?";
    pstmt = (PreparedStatement)conn.prepareStatement(sql);
    pstmt.setString(1, userid);
    pstmt.setString(2, password);
    
    rs = pstmt.executeQuery();
    if (rs.next()){
        name = rs.getString("name");
        %>
        <jsp:forward page="login_success.jsp">
            <jsp:param value="<%=name %>" name="name"/>
        </jsp:forward>
        <%
    } else {
        %>
        <jsp:forward page="login_failure.jsp"/>
        <%
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    rs.close();
    pstmt.close();
    conn.close();
}
%>

</body>
</html>
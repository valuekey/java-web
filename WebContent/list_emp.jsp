<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.jdbc.PreparedStatement"%>
<%@page import="com.mysql.jdbc.Connection"%>
<%@page import="com.yyq.common.CommonConsts" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
    Class.forName(CommonConsts.MYSQL_DRIVER);
    conn = (Connection) DriverManager.getConnection(CommonConsts.MYSQL_URL, CommonConsts.MYSQL_USER, CommonConsts.MYSQL_PASSWORD);
    String sql = "select id, name, countrycode, district, population from city";
    pstmt = (PreparedStatement) conn.prepareStatement(sql);
    
    rs = pstmt.executeQuery();

%>
<table border="1">
    <tr>
        <td>编号</td>
        <td>城市名称</td>
        <td>国家编码</td>
        <td>地区</td>
        <td>人口</td>
    </tr>
    <%
    while (rs != null && rs.next()) {
        String id = rs.getString(1);
        String name = rs.getString(2);
        String countryCode = rs.getString(3);
        String district = rs.getString(4);
        String population = rs.getString(5);
        %>
        <tr>
            <td><%=id%></td>
            <td><%=name%></td>
            <td><%=countryCode%></td>
            <td><%=district%></td>
            <td><%=population%></td>
        </tr>
        <%
    }
    %>
<%
} catch(Exception e) {
    e.printStackTrace();
} finally {
    try {
        rs.close();
        pstmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>
</table>
</body>
</html>
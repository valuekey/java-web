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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String searchCityName = null;
Integer index = null;
int showOnePageCount = 100;

if (request.getParameter("index") != null && !request.getParameter("index").equals("")) {
    try {
        index = Integer.parseInt(request.getParameter("index")) < 0 ? 0 : Integer.parseInt(request.getParameter("index"));
    } catch (Exception e) {}
} else {
    index = 0;
}

if (request.getParameter("searchCityName") != null && !request.getParameter("searchCityName").equals("")) {
    try {
        searchCityName = request.getParameter("searchCityName");
    } catch (Exception e) {}
} else {
    searchCityName = "Search!~";
}


Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try{
    Class.forName(CommonConsts.MYSQL_DRIVER);
    conn = (Connection) DriverManager.getConnection(CommonConsts.MYSQL_URL, CommonConsts.MYSQL_USER, CommonConsts.MYSQL_PASSWORD);
    String sqlCount = "select count(1) from city";
    String sqlCountSearch = "select count(1) from city where name like ?";
    
    if (!searchCityName.equals("Search!~")) {
        pstmt = (PreparedStatement) conn.prepareStatement(sqlCountSearch);
        pstmt.setString(1, "%" + searchCityName + "%");
    } else {
        pstmt = (PreparedStatement) conn.prepareStatement(sqlCount);
    }
    
    rs = pstmt.executeQuery();
    
    int count = 0;
    
    if (rs.next()) {
        count = rs.getInt(1);
    }
    if (index.intValue() * showOnePageCount > count) {
        index = count/showOnePageCount;
    }
    %>
        <form action="list_emp.jsp" method="post" name="searchAndLink">
            <a href="list_emp.jsp?searchCityName=<%=searchCityName%>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="list_emp.jsp?index=<%=index-1%>&searchCityName=<%=searchCityName%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="list_emp.jsp?index=<%=index+1%>&searchCityName=<%=searchCityName%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="list_emp.jsp?index=<%=count/showOnePageCount%>&searchCityName=<%=searchCityName%>">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="searchCityName" value="<%=searchCityName%>">
        </form>
    <%
    if (index.intValue() * showOnePageCount < count) {
    
    String sql = "select id, name, countrycode, district, population from city limit ?, ?";
    String sqlSearch = "select id, name, countrycode, district, population from city WHERE name like ? limit ?, ?";
    
    if (!searchCityName.equals("Search!~")) {
        pstmt = (PreparedStatement) conn.prepareStatement(sqlSearch);
        pstmt.setString(1, "%" + searchCityName + "%");
        pstmt.setInt(2, index.intValue() * showOnePageCount);
        pstmt.setInt(3, (index.intValue() + 1) * showOnePageCount);
    } else {
        pstmt = (PreparedStatement) conn.prepareStatement(sql);
        pstmt.setInt(1, index.intValue() * showOnePageCount);
        pstmt.setInt(2, (index.intValue() + 1) * showOnePageCount);
    }
    
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
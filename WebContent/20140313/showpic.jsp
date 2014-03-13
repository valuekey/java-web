<%@page import="java.io.OutputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.yyq.demo.factory.DatabaseConnectionFactory"%>
<%@page import="com.yyq.demo.dbc.DataBaseConntction"%>
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
String picname = request.getParameter("picname");
if (picname != null && !"".equals(picname)) {
    DataBaseConntction dbc = DatabaseConnectionFactory.getDataBaseConntction();
    String sql = "select pic from picstore where picname = ?";
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    InputStream input = null;
    pstmt = dbc.getConnection().prepareStatement(sql);
    pstmt.setString(1, picname);
    
    rs = pstmt.executeQuery();
    if (rs.next()) {
        input = rs.getBinaryStream(1);
    }
    response.setContentType("image/jpeg");
    OutputStream output = response.getOutputStream();
    byte[] temp = new byte[500];
    
    while (input.read(temp) != -1) {
        output.write(temp);
    }
    output.flush();
    out.clear();
    out = pageContext.pushBody();
    
    pstmt.close();
    dbc.close();
}

%>
</body>
</html>
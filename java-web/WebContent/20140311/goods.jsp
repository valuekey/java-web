<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
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
HashMap<String,String> goods = new HashMap<String,String>();
goods.put("001", "java编程思想");
goods.put("002", "oracle");
goods.put("003", "mysql");

HashMap<String, String> buy = new HashMap<String,String>();
buy.put("001", "10");
buy.put("001", "20");
buy.put("003", "30");

session.setAttribute("buy", buy);
buy = null;

if ("1".equals(session.getAttribute("loginState"))) {
    
    %>
    欢迎~<%=(String) session.getAttribute("userid") %><a href="logout.jsp">注销</a><br>
    <%
    buy = (HashMap<String,String>) session.getAttribute("buy");
    if (buy != null && buy.size() != 0) {
        Iterator<String> iterator = buy.keySet().iterator();
        while (iterator.hasNext()) {
            String goodid = iterator.next();
            %><%=goods.get(goodid) %><%=buy.get(goodid) %><%
        }
    }

}
%>
</body>
</html>
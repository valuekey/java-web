<%@ page language="java" contentType="text/html; charset=ISO-8859-1" errorPage="error.jsp"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%
Integer x = 0;
Integer y = 0;
x = Integer.parseInt(request.getParameter("x"));
try{
    x = Integer.parseInt(request.getParameter("x"));
    y = Integer.parseInt(request.getParameter("y"));
} catch (Exception e) {
    e.printStackTrace();
}
    for (int i = 0; i < x; i++) {
        %>
        <tr>
        <%
            for (int j = 0; j < y; j++) {
                %>
                <td>
                    <%= i * j %>
                </td>
                <%
            }
        %>
        </tr>
        <%
    }
%>

</table>
</body>
</html>
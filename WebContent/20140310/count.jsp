<%@page import="java.io.PrintStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.math.BigInteger"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! BigInteger count = null; %>
<%!
public BigInteger load(File file) {
    BigInteger _count = null;
    try {
        if (file.exists()) {
            Scanner scan = null;
            scan = new Scanner(new FileInputStream(file));
            if (scan.hasNext()) {
                _count = new BigInteger(scan.next());
            }
            scan.close();
            
        } else {
            _count = new BigInteger("0");
            save(file,count);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return _count;
}

public void save(File file, BigInteger count) {
    try {
        PrintStream ps = null;
        ps = new PrintStream(file);
        ps.println(count);
        ps.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
%>

<%
String fileName = this.getServletContext().getRealPath("/") + "count.txt";
File file = new File(fileName);
if (session.isNew()) {
    synchronized(this) {
        count = load(file);
        count = count.add(new BigInteger("1"));
        save(file,count);
    }
}
%>

您是第<%=count==null?0:count %>位访客
</body>
</html>
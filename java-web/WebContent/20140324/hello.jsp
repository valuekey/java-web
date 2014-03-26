<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/20140322/struts-lib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<html:form action="/20140324/register" method="post" onsubmit="return validateRegisterDemoForm(this)">
账号：<html:text property="mid"></html:text>
年龄：<html:text property="age"></html:text>
生日：<html:text property="birthday"></html:text>
邮箱：<html:text property="email"></html:text>
<html:hidden property="method" value="regist"/>
<html:submit value="注册"></html:submit>
</html:form>
<html:javascript formName="registerDemoForm"/>
</body>
</html>
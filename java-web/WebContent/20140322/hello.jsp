<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="bean" uri="http://www.imyyq.com/struts/bean" %>
<%@ taglib prefix="logic" uri="http://www.imyyq.com/struts/logic" %>
<%@ taglib prefix="html" uri="http://www.imyyq.com/struts/html" %>
<!DOCTYPE html:html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html lang="true">
<head>
    <title>www.imyyq.com</title>
</head>
<body>
<html:errors/>
<logic:present name="msg" scope="request">
<h2>${msg }</h2>
</logic:present>
<html:form action="/20140322/hello.do" method="post" >
请输入信息：<html:text property="info"></html:text>
<html:submit value="显示"></html:submit>
</html:form>
<html:messages id="mmm" message="true">
    ${mmm }
</html:messages>
</body>
</html:html>
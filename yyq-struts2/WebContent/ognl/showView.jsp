<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>showView.jsp</title>
</head>
<body>
request.username=<s:property value="#request.username"/><br>
session.username=<s:property value="#session.username"/><br>
application.username=<s:property value="#application.username"/><br>
attr.username=<s:property value="#attr.username"/><br>
parameters.username=<s:property value="#parameters.username"/><br>
vs.username=<s:property value="username"/><br>
<s:textfield label="%{#application.username}"></s:textfield><br>
<s:property value="'<hr>aa'" escape="false"/>
<hr>
<s:set var="myusername" scope="session" value="#session.username"/>
<s:property value="#session.myusername"/>
<s:push value="#application.username">
	<s:property/>
</s:push>
<hr>
<s:bean name="com.yyq.struts2.model.Address" var="mybean">
	<s:param name="city" value="'dalian'"></s:param>
	<s:property value="city" />
</s:bean>
<s:property value="#mybean.city" />
<hr>
<table border="1">
	<tr>
		<td>count</td>
		<td>index</td>
		<td>city</td>
		<td>street</td>
		<td>编辑</td>
	</tr>
	<s:iterator value="list" status="listindex">
	<tr bgcolor="<s:if test="#listindex.even">RED</s:if> <s:else>BLUE</s:else>  ">
		<td><s:property value="#listindex.count"/></td>
		<td><s:property value="#listindex.index"/></td>
		<td><s:property value="city"/></td>
		<td><s:property value="street"/></td>
		
		<td><a href='<s:url action="UserAction_edit" namespace="/user"><s:param name="city" value="city"/></s:url>'>编辑</a></td>
	</tr>
	</s:iterator>
	
</table>
<hr>


</body>
</html>
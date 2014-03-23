<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.struts.util.LabelValueBean"%>
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
<%
List<LabelValueBean> options = new ArrayList<LabelValueBean>();
LabelValueBean option = null;
for (int i = 0; i < 10; i++) {
    option = new LabelValueBean();
    option.setLabel("item" + i);
    option.setValue(i+"");
    options.add(option);
}
pageContext.setAttribute("selectlist", options);
%>
<html:form action="/20140323/htmltagdemo" method="post">
姓名：<html:text property="name"></html:text><br>
密码：<html:password property="password"></html:password><br>
性别：<html:radio property="sex" value="man">男</html:radio><html:radio property="sex" value="woman">女</html:radio><br>
爱好：<html:checkbox property="inst" value="running">跑步</html:checkbox><html:checkbox property="inst" value="swimming">游泳</html:checkbox><br>
城市：<html:multibox property="city" value="beijing">北京</html:multibox><html:multibox property="city" value="shanghai">上海</html:multibox><br>
简介：<html:textarea property="note" cols="10" rows="3"></html:textarea><br>
<html:select property="item">
<html:optionsCollection name="selectlist" label="label" value="value"/>

</html:select>
<html:submit>提交</html:submit>
<html:reset>重置</html:reset>

</html:form>

</body>
</html>
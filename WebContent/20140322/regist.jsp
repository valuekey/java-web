<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="struts-lib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript">
function changeimg() {
    var image = document.getElementById("image");
    var now = new Date();
    image.src = "image.jsp?code=" + now.getTime();
}
</script>
</head>
<body>
<html:errors/>
<html:messages id="info" message="true">
${info }
</html:messages>
<html:form action="/20140322/regist.do" method="post">
<table>
    <tr>
        <td>用户ID</td>
        <td><html:text property="mid"/></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><html:password property="password"/></td>
    </tr>
    <tr>
        <td>姓名</td>
        <td><html:text property="name"/></td>
    </tr>
    <tr>
        <td>地址</td>
        <td><html:text property="address"/></td>
    </tr>
    <tr>
        <td>电话</td>
        <td><html:text property="telephone"/></td>
    </tr>
    <tr>
        <td>邮政编码</td>
        <td><html:text property="zipcode"/></td>
    </tr>
    <tr>
        <td>验证码</td>
        <td><html:text property="imagecode" maxlength="4" size="4"/><img id = "image" src="image.jsp" onclick="changeimg()" border="1" style="margin-bottom: -7px;" align="right"></td>
    </tr>
</table>
<html:submit value="注册"/>
</html:form>
</body>
</html>
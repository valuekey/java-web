<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function changeimg() {
	var image = document.getElementById("image");
	var now = new Date();
	image.src = "image.jsp?code=" + now.getTime();
}

function check() {
	var checkflg = true;
	
	var useridlab = document.getElementById("useridlab");
	var passwordlab = document.getElementById("passwordlab");
	var imagecodelab = document.getElementById("imagecodelab");
	
	
	if (loginForm.userid.value == "") {
		useridlab.innerText = "不能为空";
		checkflg = false;
	} else {
		useridlab.innerText = "";
	}
    if (loginForm.password.value == "") {
        passwordlab.innerText = "不能为空";
        checkflg = false;
    } else {
    	passwordlab.innerText = "";
    }

    if (loginForm.imagecode.value.length != 4) {
    	imagecodelab.innerText = "长度不对";
        checkflg = false;
    } else {
    	imagecodelab.innerText = "";
    }
	return checkflg;
}
</script>
</head>
<body>
<%
if ("1".equals(session.getAttribute("loginState"))) {
    %>
    <jsp:forward page="goods.jsp"></jsp:forward>
    <%
}

Cookie[] cookie = request.getCookies();
String remenberpwd = null;
String password = null;
String userid = null;
if (cookie != null && cookie.length != 0) {
for (Cookie temp:cookie) {
    out.println(temp.getName() + "-------------->" + temp.getValue());
    if ("remenberpwd".equals(temp.getName())) {
        remenberpwd = temp.getValue();
    }
    if ("password".equals(temp.getName())) {
        password = temp.getValue();
    }
    if ("userid".equals(temp.getName())) {
        userid = temp.getValue();
    }
}
}
%>

<form action="check.jsp" method="post" onsubmit="return check();" name="loginForm">
<table>
<tr>
    <td>账号：</td>
    <td><input type="text" name="userid" value="<%=userid == null ? "" : userid%>"></td>
    <td><label id="useridlab"></label></td>
</tr>
<tr>
    <td>密码：</td>
    <td><input type="password" name="password" value="<%="1".equals(remenberpwd) ? password : ""%>"></td>
    <td><label id="passwordlab"></label></td>
</tr>
<tr>
    <td>验证码：</td>
    <td><input type="text" name="imagecode" size="4" maxlength="4"><img id = "image" src="image.jsp" onclick="changeimg()" border="1" style="margin-bottom: -7px;" align="right"></td>
    <td><label id="imagecodelab"><%= "1".equals(request.getParameter("failcode")) ? "验证码错误" : ""%></label></td>
</tr>
<tr>
<td><input type="checkbox" name="remenberpwd" value="1" <%="1".equals(remenberpwd) ? "checked" : ""%>>记住密码</td>
<td><input type="submit" value="登陆"></td>
</tr>
</table>

</form>

</body>
</html>
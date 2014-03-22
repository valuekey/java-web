<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
var xmlHttp;
var flag = false;
function createXMLHttp() {
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
    } else {
        xmlHttp = new ActiveXObject("Microsoft.XMLHttp");
    }
}

function checkUserid(userid) {
    createXMLHttp();
    xmlHttp.open("POST","CheckServlet?userid=" + userid);
    xmlHttp.onreadystatechange = checkUseridCallBack;
    xmlHttp.send(null);
    document.getElementById("msg").innerHTML = "正在验证...";
}
function checkUseridCallBack() {
    if (xmlHttp.readyState == 4) {
        if (xmlHttp.status == 200) {
            var text = xmlHttp.responseText;
            if (text == "true") {
                flag = false;
                document.getElementById("msg").innerHTML = "用户ID重复，无法使用";
            } else if (text == "false") {
                flag = true;
                document.getElementById("msg").innerHTML = "此用户ID可以使用";
            }
        }
    }
}
function checkForm() {
    return flag;
}
</script>

</head>
<body>
<form action="" onsubmit="return checkForm()">
账号：<input type="text" name="userid" onblur="checkUserid(this.value)"><span id="msg"></span><br>
姓名：<input type="text" name="name"><br>
密码：<input type="password" name="password"><br>
<input type="submit" value="注册"><input type="reset" value="重置">
</form>
</body>
</html>
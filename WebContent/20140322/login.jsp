<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/20140322/struts-lib.jsp" %>
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
</script>
</head>
<body>
<html:form action="" method="post">

</html:form>
</body>
</html>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@page import="java.awt.Color"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public Color getRandColor(int fc, int bc) {
    Random random = new Random();
    if (fc > 255) {
        fc = 255;
    }
    if (bc > 255) {
        bc = 255;
    }
    int r = fc + random.nextInt(bc - fc);
    int g = fc + random.nextInt(bc - fc);
    int b = fc + random.nextInt(bc - fc);
    return new Color(r, g, b);
}
%>

<%
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
int width = 60;
int height = 20;
BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

Graphics g = image.getGraphics();

Random random = new Random();
g.setColor(getRandColor(200, 250));
g.fillRect(0, 0, width, height);
g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
g.setColor(getRandColor(160,200));
for (int i=0;i<155;i++)
{
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        int xl = random.nextInt(12);
        int yl = random.nextInt(12);
        g.drawLine(x,y,x+xl,y+yl);
}

String sRand="";
for (int i=0;i<4;i++){
    String rand=String.valueOf(random.nextInt(10));
    sRand+=rand;
    // 将认证码显示到图象中
    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));//调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
    g.drawString(rand,13*i+6,16);
}

//将认证码存入SESSION
session.setAttribute("rand",sRand);

//图象生效
g.dispose();
//输出图象到页面
ImageIO.write(image, "JPEG", response.getOutputStream());
//下边两行是防止抛出getOutputStream() has already been called for this response异常的
out.clear();
out = pageContext.pushBody();
%>
</body>
</html>
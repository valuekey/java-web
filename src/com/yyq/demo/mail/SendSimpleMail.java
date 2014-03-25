package com.yyq.demo.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.tomcat.jni.File;

public class SendSimpleMail {
	public static void main (String[] args) throws Exception{
		InternetAddress[] address = null;
		String mailserver = "imyyq.com";
		String from = "yyq@imyyq.com";
		String to = "yyq@imyyq.com";
		String subject = "测试一下JavaMail组件";
		String messageText = "www.imyyq.com, 是一个论坛<a href=\"http://www.baidu.com\">点击</a>";
		Properties props = null;
		props = System.getProperties();
		props.put("mail.smtp.host", mailserver);
		props.put("mail.smtp.auth", "true");
		MySecurity msec = new MySecurity("yyq", "123456");
		Session mailSession = Session.getInstance(props, msec);
		mailSession.setDebug(false);
		Message msg = new MimeMessage(mailSession);
		msg.setFrom(new InternetAddress(from));
		address = InternetAddress.parse(to, false);
		msg.setRecipients(Message.RecipientType.TO, address);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		
		Multipart multipart = new MimeMultipart();
		BodyPart messageBodyPart = new MimeBodyPart();
		DataSource source = new FileDataSource("C:\\Users\\Administrator\\Desktop\\11.jpg");
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName("111.jpg");
		multipart.addBodyPart(messageBodyPart);
		messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(messageText, "text/html;charset=UTF-8");
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		
		
//		msg.setText(messageText);
		Transport.send(msg);
		
	}
}

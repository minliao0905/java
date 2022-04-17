package Email;

import java.security.GeneralSecurityException;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.*;
public class SendEmail {
	public  static void main(String[] args){
		String to = "563376985@qq.com";
		String from = "3099722528@qq.com";
		
		String host = "localhost";
		//获取了系统属性
		Properties properties = System.getProperties();
//		System.out.println(System.getProperty(host));   //默认系统属性设置为null；
//		 // 设置邮件服务器
		host = "smtp.qq.com";   //qq服务器
	    properties.setProperty("mail.smtp.host", host);    
//	  	System.out.println(properties.getProperty(host));
	    properties.put("mail.smt.auth","true");
	    MailSSLSocketFactory sf = null;
		try {
			sf = new MailSSLSocketFactory();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        sf.setTrustAllHosts(true);
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.ssl.socketFactory", sf);
        
	      // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("3099722528@qq.com", "pxgvnmclafvcdcej"); //发件人邮件用户名、密码
            }
        });

	      try{
	         // 创建默认的 MimeMessage 对象
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: 头部头字段
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: 头部头字段
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: 头部头字段
	         message.setSubject("This is the Subject Line!");
	 
	         // 设置消息体
	         message.setText("This is actual message");
	 
	         // 发送消息
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}

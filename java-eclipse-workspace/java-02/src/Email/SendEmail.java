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
		//��ȡ��ϵͳ����
		Properties properties = System.getProperties();
//		System.out.println(System.getProperty(host));   //Ĭ��ϵͳ��������Ϊnull��
//		 // �����ʼ�������
		host = "smtp.qq.com";   //qq������
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
        
	      // ��ȡĬ��session����
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("3099722528@qq.com", "pxgvnmclafvcdcej"); //�������ʼ��û���������
            }
        });

	      try{
	         // ����Ĭ�ϵ� MimeMessage ����
	         MimeMessage message = new MimeMessage(session);
	 
	         // Set From: ͷ��ͷ�ֶ�
	         message.setFrom(new InternetAddress(from));
	 
	         // Set To: ͷ��ͷ�ֶ�
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(to));
	 
	         // Set Subject: ͷ��ͷ�ֶ�
	         message.setSubject("This is the Subject Line!");
	 
	         // ������Ϣ��
	         message.setText("This is actual message");
	 
	         // ������Ϣ
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	}
}

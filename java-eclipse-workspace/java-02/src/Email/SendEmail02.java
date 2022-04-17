package Email;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
 
public class SendEmail02
{
   public static void main(String [] args)
   {
     
      // �ռ��˵�������
      String to = "abcd@gmail.com";
 
      // �����˵�������
      String from = "web@gmail.com";
 
      // ָ�������ʼ�������Ϊ localhost
      String host = "localhost";
 
      // ��ȡϵͳ����
      Properties properties = System.getProperties();
 
      // �����ʼ�������
      properties.setProperty("mail.smtp.host", host);
 
      // ��ȡĬ�ϵ� Session ����
      Session session = Session.getDefaultInstance(properties);
 
      try{
         // ����Ĭ�ϵ� MimeMessage ����
         MimeMessage message = new MimeMessage(session);
 
         // Set From: ͷ��ͷ�ֶ�
         message.setFrom(new InternetAddress(from));
 
         // Set To: ͷ��ͷ�ֶ�
         message.addRecipient(Message.RecipientType.TO,
                                  new InternetAddress(to));
 
         // Set Subject: ͷ�ֶ�
         message.setSubject("This is the Subject Line!");
 
         // ���� HTML ��Ϣ, ���Բ���html��ǩ
         message.setContent("<h1>This is actual message</h1>",
                            "text/html" );
 
         // ������Ϣ
         Transport.send(message);
         System.out.println("Sent message successfully....");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
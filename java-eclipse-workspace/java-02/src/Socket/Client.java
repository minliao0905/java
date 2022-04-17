package Socket;

import java.net.*;
import java.io.*;
 
public class Client
{
   public static void main(String [] args)
   {
      String serverName = "127.0.0.1";
      int port = 8080;
      try
      {
         System.out.println("���ӵ�������" + serverName + " ���˿ںţ�" + port);
         //��������
         Socket client = new Socket(serverName, port);
         System.out.println("Զ��������ַ��" + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
 
         out.writeUTF("Hello from " + client.getLocalSocketAddress());
    
         DataInputStream in = new DataInputStream(client.getInputStream());
         System.out.println("��������Ӧ�� " + in.readUTF());
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
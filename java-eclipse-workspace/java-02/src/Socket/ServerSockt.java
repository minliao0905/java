package Socket;

import java.io.*;
import java.net.* ;

public class ServerSockt {
	private ServerSocket serversocket;
	public void serverRun(int port) {
		try {
			serversocket = new ServerSocket(port);
			System.out.println("�ȴ�Զ�����ӣ��˿ںţ�"+ serversocket.getLocalPort()+"...");
			
			Socket server = serversocket.accept();
			System.out.println("server�ˣ�Զ��������ַ��"+ server.getRemoteSocketAddress());
			 DataInputStream in = new DataInputStream(server.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
//	         �������˴�����ͻ��˵���Ϣ
	            out.writeUTF("лл�����ң�" + server.getLocalSocketAddress() + "\nGoodbye!");
			 
			 server.close();
			 
		}catch(IOException e)
		{
			System.out.println("Socket timed out!");
			e.printStackTrace();
		}
	}
	
	public static void main(String []args) throws IOException {
      new ServerSockt().serverRun(8080);
		System.out.println("����serverSocket����");
	}
     
}

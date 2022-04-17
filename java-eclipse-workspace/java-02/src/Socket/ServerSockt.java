package Socket;

import java.io.*;
import java.net.* ;

public class ServerSockt {
	private ServerSocket serversocket;
	public void serverRun(int port) {
		try {
			serversocket = new ServerSocket(port);
			System.out.println("等待远程连接，端口号："+ serversocket.getLocalPort()+"...");
			
			Socket server = serversocket.accept();
			System.out.println("server端：远程主机地址："+ server.getRemoteSocketAddress());
			 DataInputStream in = new DataInputStream(server.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(server.getOutputStream());
//	         服务器端传输给客户端的消息
	            out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
			 
			 server.close();
			 
		}catch(IOException e)
		{
			System.out.println("Socket timed out!");
			e.printStackTrace();
		}
	}
	
	public static void main(String []args) throws IOException {
      new ServerSockt().serverRun(8080);
		System.out.println("创建serverSocket连接");
	}
     
}

package Socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class socket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try {
    	  Socket socket = new Socket(InetAddress.getByName("localhost"),62988);
    	  PrintWriter out = new PrintWriter(
    			  new BufferedWriter(
    					  new OutputStreamWriter(
    							  socket.getOutputStream())));
    			 out.println("hello!") ;
    			 socket.close();
      }catch(IOException e) {
    	  e.printStackTrace();
      }
	}

}

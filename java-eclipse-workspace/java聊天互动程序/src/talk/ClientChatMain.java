package talk;   

//properties 与src同级

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Properties;

import javax.swing.*;

public class ClientChatMain extends JFrame implements ActionListener,KeyListener{
	//文本域
/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	static  private JTextArea  jta;
     //滚动条
	static private JScrollPane jsp;
     //面板
	static private JPanel jp;
//     输入文本框
	static  private JTextField jtf;
     //按钮
	static   private JButton jbtn;
     //
	static private BufferedWriter bw;
     //客户端的IP地址，port  端口号
	 private static String clientIp;
	 static int clientPort;	
     static {
		Properties prop= new Properties();
		try {
			prop.load(new FileReader("chat.properties"));
			clientIp = prop.getProperty("clientIp");
			clientPort = Integer.parseInt(prop.getProperty("clientPort"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
     new ClientChatMain();
	}

   public ClientChatMain() {
	     //初始化组件
	   jta  =new JTextArea();
	   jta.setEditable(false); //文本编辑域不可编辑
	   //创建聊天 ，将文本加入滚动条，实现滚动效果
	   jsp = new JScrollPane(jta);
	   //创建面板； 
	   jp=new JPanel();
	   jtf=new JTextField(10);
	   //按钮
	   jbtn= new JButton("发送");
	   jp.add(jtf);
	   jp.add(jbtn);
	   //将滚动条与面板添加至窗体
	   this.add(jsp,BorderLayout.CENTER);
	   this.add(jp,BorderLayout.SOUTH);
	   
	   //设置窗体  标题，大小
	   this.setTitle("聊天客户端");
	   this.setSize(300,300);
	   this.setLocation(800,300);//位置
	   
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
	   /*******************************TCP 客户端********************************/
	  
	   //创建监听事件
             jbtn.addActionListener(this);
             jtf.addKeyListener(this);
             try { 
            	 //创建客户端的套接字（连接）
            	  Socket  socket = new Socket(clientIp,clientPort);
            	  //获取socket的输入流
            	  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            	 //socket 输出流
            	  bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
              
            	  
            	  //循环读取数据，并拼接到文本域
            	  String line = null;
            	   while ((line = br.readLine())!=null) {
            		   jta.append(line+System.lineSeparator());
            	   }
             //关闭socket通道
            	   socket.close();
             }catch (Exception e) {
            	 e.printStackTrace();
             }
	    
	   /*******************************TCP 客户端********************************/
   }
   
/***************************发送按钮监听事件start************************************/
/**********按钮事件中的发送数据 封装函数 ***********/ 
public void sendDataToSocket() {
	 String text = jtf.getText();
		text="客户端对服务端说："+text;
//		//服务端窗口显示内容
		jta.append(text+System.lineSeparator());
//		//输出流发送
		try {
			bw.write(text);
			bw.newLine();
			bw.flush();
			jtf.setText("");//清空
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();/////////////
		}
}   
@Override
public void actionPerformed(ActionEvent e) {
	System.out.println("客户端发送！");
	//获取文本框的内容
    sendDataToSocket();
}

/***************************发送按钮监听事件start************************************/
/***************************键盘回车键监听事件 start************************************/
@Override
public void keyPressed(KeyEvent e) {
//
//	System.out.println(e);
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		//发送数据到socket 通道中
		sendDataToSocket() ;
	}
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

/***************************键盘回车键监听事件 end************************************/

}

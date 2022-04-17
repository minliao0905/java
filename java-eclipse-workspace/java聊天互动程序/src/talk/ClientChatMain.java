package talk;   

//properties ��srcͬ��

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
	//�ı���
/**
	 * 
	 */
		private static final long serialVersionUID = 1L;

	static  private JTextArea  jta;
     //������
	static private JScrollPane jsp;
     //���
	static private JPanel jp;
//     �����ı���
	static  private JTextField jtf;
     //��ť
	static   private JButton jbtn;
     //
	static private BufferedWriter bw;
     //�ͻ��˵�IP��ַ��port  �˿ں�
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
	     //��ʼ�����
	   jta  =new JTextArea();
	   jta.setEditable(false); //�ı��༭�򲻿ɱ༭
	   //�������� �����ı������������ʵ�ֹ���Ч��
	   jsp = new JScrollPane(jta);
	   //������壻 
	   jp=new JPanel();
	   jtf=new JTextField(10);
	   //��ť
	   jbtn= new JButton("����");
	   jp.add(jtf);
	   jp.add(jbtn);
	   //����������������������
	   this.add(jsp,BorderLayout.CENTER);
	   this.add(jp,BorderLayout.SOUTH);
	   
	   //���ô���  ���⣬��С
	   this.setTitle("����ͻ���");
	   this.setSize(300,300);
	   this.setLocation(800,300);//λ��
	   
	   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   this.setVisible(true);
	   /*******************************TCP �ͻ���********************************/
	  
	   //���������¼�
             jbtn.addActionListener(this);
             jtf.addKeyListener(this);
             try { 
            	 //�����ͻ��˵��׽��֣����ӣ�
            	  Socket  socket = new Socket(clientIp,clientPort);
            	  //��ȡsocket��������
            	  BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            	 //socket �����
            	  bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
              
            	  
            	  //ѭ����ȡ���ݣ���ƴ�ӵ��ı���
            	  String line = null;
            	   while ((line = br.readLine())!=null) {
            		   jta.append(line+System.lineSeparator());
            	   }
             //�ر�socketͨ��
            	   socket.close();
             }catch (Exception e) {
            	 e.printStackTrace();
             }
	    
	   /*******************************TCP �ͻ���********************************/
   }
   
/***************************���Ͱ�ť�����¼�start************************************/
/**********��ť�¼��еķ������� ��װ���� ***********/ 
public void sendDataToSocket() {
	 String text = jtf.getText();
		text="�ͻ��˶Է����˵��"+text;
//		//����˴�����ʾ����
		jta.append(text+System.lineSeparator());
//		//���������
		try {
			bw.write(text);
			bw.newLine();
			bw.flush();
			jtf.setText("");//���
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();/////////////
		}
}   
@Override
public void actionPerformed(ActionEvent e) {
	System.out.println("�ͻ��˷��ͣ�");
	//��ȡ�ı��������
    sendDataToSocket();
}

/***************************���Ͱ�ť�����¼�start************************************/
/***************************���̻س��������¼� start************************************/
@Override
public void keyPressed(KeyEvent e) {
//
//	System.out.println(e);
	if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		//�������ݵ�socket ͨ����
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

/***************************���̻س��������¼� end************************************/

}

package login;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.itheima.jdbc.Logindao;   //����SQL�����





public class Loginlistener implements ActionListener {

	private JComboBox<Object>jco;
	private JPasswordField jpa;  
	private  JFrame jf ;
	public Loginlistener (JComboBox<Object>jco,JPasswordField jpa,JFrame jf) {
		super();
		this.jco = jco;
		this.jpa= jpa;
		this.jf= jf;
	}
	public static void main(String[] args) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//����Ͽ����ȡ��¼���˺ź�����
		String name=(String) jco.getSelectedItem();
		String  pwd=new String(jpa.getPassword());
				
		Logindao logindao = new Logindao();
		Boolean b1 = false;
/**************���ݿ���ʷ���***************/
		//��ѯ��¼�û�������д��û�����������ȷ�򷵻�true;
		try {
			b1=logindao.findUser(name,pwd);
			
		}catch(SQLException e1){
			e1.printStackTrace();
		}
/*************���ݿ���ʷ���*************/
		if(b1) {
			//�˺���ȷ���ȹرյ�ǰJFrame��¼����
			jf.dispose();
			JFrame jfn= new JFrame();  //�´���¼����
			jfn.setSize(364,931);
			jfn.setLocationByPlatform(true);
			jfn.setUndecorated(false);
			jfn.setResizable(true);
			jfn.setVisible(true);
			
			//ΪQQ��ʾ������ӱ���ͼƬ���˳���ť���
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(0,500));
			ImageIcon image =new ImageIcon("image/QQload.png");
			JLabel background = new JLabel(image);
			background.setBounds(0,0,364,931);
			panel.add(background);
			
			//����˳���ť
		    JButton out = new JButton(new ImageIcon("image/up.png"));
		    out.setBounds(330,0,26,26);
		    out.setRolloverIcon(new ImageIcon("image/up.png"));
		    out.setBorderPainted(false);
		    panel.add(out);
		    jfn.add(panel);
		    //Ϊ�˳���ťע����������رյ�ǰ���ڣ�
		    out.addActionListener(event->jfn.dispose());
		}else {
			//QQ�˺Ż�����������󣬵�����ʾ��Ϣ��
			JOptionPane.showMessageDialog(null,"��������˻���������������������룡");
			
		}
		
//		if(name.equals("123456789")&&pwd.equals("123"))
//		{
//			jf.dispose();
//			JFrame jfn= new JFrame();  //�´���¼����
//			jfn.setSize(364,931);
//			jfn.setLocationByPlatform(true);
//			jfn.setUndecorated(false);
//			jfn.setResizable(true);
//			jfn.setVisible(true);
//			
//			JPanel panel = new JPanel();
//			panel.setLayout(null);
//			panel.setPreferredSize(new Dimension(0,500));
//			ImageIcon image =new ImageIcon("src/QQload.png");
//			JLabel background = new JLabel(image);
//			background.setBounds(0,0,364,931);
//			panel.add(background);
//			
//			JButton out = new JButton(new ImageIcon("src/up.png"));
//		    out.setBounds(330,0,26,26);
//		    out.setRolloverIcon(new ImageIcon("src/up.png"));
//		    out.setBorderPainted(false);
//		    panel.add(out);
//		    jfn.add(panel);
//		    //Ϊ�˳���ťע����������رյ�ǰ���ڣ�
//		    out.addActionListener(event->jfn.dispose());
//		}else {
//			//QQ�˺Ż�����������󣬵�����ʾ��Ϣ��
//			JOptionPane.showMessageDialog(null,"��������˻���������������������룡");
//			
//		}
		
	}
}

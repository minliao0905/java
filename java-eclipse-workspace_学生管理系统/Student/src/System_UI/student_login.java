package System_UI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;

import System_Component.BackGroundPanel;
import System_Component.PathUtils;
import System_Component.ScreenUtils;
import System_Component.Yanzhencode;

import System_SQL.users_SQL;


public class student_login {
	public JFrame jf = new JFrame("ѧ������ϵͳ��¼����");
	
	//���ؽ���������
	public void init() throws Exception{
		final int WIDTH = 1000;
	    final int HEIGHT = 600;
		
		
       //���ص�¼����//���ò��֣���ǰ��Ļ�ߺͿ�		
		 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
		 jf.setResizable(false);  
       //2�������Ͻǵ�logo
		 jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("����.png"))));      //�����׳��쳣��
         //3���ô��ڵ�Jpanel
		BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getImagePath("��¼.jfif"))));
		Box vBox =  Box.createVerticalBox(); 

		//�û������
        Box uBox = Box.createHorizontalBox();
		JLabel uLabel = new JLabel("�û���:");
		JTextField  utextfield= new JTextField(15);
		uBox.add(uLabel);
		uBox.add(Box.createHorizontalStrut(10));     //Jlabel���ı�����Ӽ��
		uBox.add(utextfield);
		//�������
		Box pBox = Box.createHorizontalBox();
		//����һ����������
		JLabel pLabel = new JLabel("��   ��:");		
		JPasswordField jppassword = new JPasswordField();
		
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(10));
		pBox.add(jppassword);
		
		Box cBox = Box.createHorizontalBox();
		JLabel cLabel = new JLabel("��֤��:");
		JTextField  ctextfield = new JTextField(8);
		Yanzhencode checkCode = new Yanzhencode(); 
		cBox.add(cLabel);
		cBox.add(ctextfield);
		cBox.add(checkCode);
		//��¼��ע��
		Box bBox =  Box.createHorizontalBox();
		JButton loginBtn = new JButton("��¼");
		JButton registBtn = new JButton("ע�����û�");
		bBox.add(loginBtn);
		bBox.add(Box.createHorizontalStrut(40));
		bBox.add(registBtn);
		
		vBox.add(Box.createVerticalStrut(100));
		vBox.add(uBox);
		vBox.add(Box.createVerticalStrut(40));
		vBox.add(pBox);
		vBox.add(Box.createVerticalStrut(40));
		vBox.add(cBox);
		vBox.add(Box.createVerticalStrut(40));
		vBox.add(bBox);
		
		
		bgPanel.add(vBox);                          //�������
       
		
		
		utextfield.setText("xiaoguo");
		jppassword.setText("123456");
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û����������
				String username = utextfield.getText().trim();
				String password = new String(jppassword.getPassword());
				String code = checkCode.getCode();
				boolean check01=false;
				if(code.equals(ctextfield.getText())) {
					check01 =true;
				}
				
				//�������ݿ����				
				
				Boolean b1 = true;
				users_SQL usersql = new users_SQL();
				try {
					b1 = usersql.findUser(username,password);
				}catch(SQLException el) {
					el.printStackTrace();
				}//��֤������Ƿ�������ȷ
				if(!check01) {
					JOptionPane.showMessageDialog(null,"���������֤��������������룡");
				}else {
					if(b1) {
						System.out.println("��¼�ɹ���");
						try {
							new MainInterface().init();           //���е�¼�ɹ��Ľ���
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						   jf.dispose(); //���ڹر�
//						//�����´���	
					}
					else {
//						System.out.println("��¼ʧ�ܣ�");
						JOptionPane.showMessageDialog(null,"��������˻���������������������룡");
						
					}
				}
				
				
			}
		});
		
		//ע�����û�
		registBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new student_Register().init();
				jf.dispose();    //���ڹر�
				} catch (Exception e1) {
					e1.printStackTrace();
				}		
			}
			
		});
		
		
		
		jf.setSize(WIDTH,HEIGHT);
		jf.add(bgPanel);
		jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	
	

	public static void main(String[] args) {           //��ʹ�������������	new student_login().init() ;��������new student_login().init(),Ҳ������login�е�main�������Դ���������¼����
		try { 
			new student_login().init();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}

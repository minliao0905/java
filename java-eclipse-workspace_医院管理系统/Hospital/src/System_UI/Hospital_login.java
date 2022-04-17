package System_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.*;

import System_Component.BackGroundPanel;
import System_Component.PathUtils;
import System_Component.ScreenUtils;
import System_SQL.login_SQL;

public class Hospital_login {
	JFrame jf = new JFrame("ҽԺ����ϵͳ��¼����");
	
	
	
	
	
	//���ؽ���������
	public void init() throws Exception{
		final int WIDTH = 1000;
	final int HEIGHT = 600;
		
		
       //���ص�¼����//���ò��֣���ǰ��Ļ�ߺͿ�		
		 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
		 jf.setResizable(false);  
       //2�������Ͻǵ�logo
		 jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("ҽԺ.png"))));      //�����׳��쳣��
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
		JLabel pLabel = new JLabel("��   ��:");
		JTextField ptextfield = new JTextField(15);
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(10));
		pBox.add(ptextfield);
		
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
		vBox.add(bBox);
		
		
		bgPanel.add(vBox);                          //�������
		//���ò˵�����  ���ã��˵�
		
		//������¼����¼�ɹ���ѡ���ţ����Ҳ鿴����Ȩ�ޣ�����ע���û�
		//�����ڲ����÷ָ����;  סԺ��Live_in_Hospital�����ﲿSee_doctor��Ա������_employee_management��ҩƷ������Medicine_instrument       //��ɾ������������塣
		//������������ݿ���أ�ͼƬ���أ�
		//UI��¼��壬ע����壬�����Ź�����壬��������
		//
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û����������
				String username = utextfield.getText().trim();
				String password = ptextfield.getText().trim();
				//�������ݿ����
				login_SQL  loginsql = new login_SQL();
				Boolean b1 = true;
//				try {
//					b1 = loginsql.findUser(username,password);
//				}catch(SQLException el) {
//					el.printStackTrace();
//				}
				if(b1) {
					System.out.println("��¼�ɹ���");
					try {
						new MainInterface().init();           //���е�¼�ɹ��Ľ���
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					jf.dispose();    //���ڹر�
//					//�����´���	
				}
				else {
					System.out.println("��¼ʧ�ܣ�");
					JOptionPane.showMessageDialog(null,"��������˻���������������������룡");
				}
				
			}
		});
		
		//ע��
		registBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Hospital_Register().init();
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
	
	
	

	public static void main(String[] args) {
		try {
			new Hospital_login().init();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}

package System_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import System_Component.BackGroundPanel;
import System_Component.PathUtils;
import System_Component.ScreenUtils;
import System_SQL.login_SQL;

public class Hospital_Register {
	JFrame jf = new JFrame("ҽԺ����ϵͳע��");
	
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
		JLabel uLabel = new JLabel("���û���:    ");
		JTextField  utextfield= new JTextField(15);
		uBox.add(uLabel);
		uBox.add(Box.createHorizontalStrut(10));     //Jlabel���ı�����Ӽ��
		uBox.add(utextfield);
		//�������
		Box pBox = Box.createHorizontalBox();
		JLabel pLabel = new JLabel("���û�����:     ");
		JTextField ptextfield = new JTextField(15);
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(10));
		pBox.add(ptextfield);
		//�ֻ�����
		 Box phoneNumberBox = Box.createHorizontalBox();
		 JLabel pNLabel = new JLabel("���û��ֻ�����:");
		 JTextField pNField = new JTextField(15);
		 phoneNumberBox.add(pNLabel);
		 phoneNumberBox.add(Box.createHorizontalStrut(10));   //�������֮��ļ����
		 phoneNumberBox.add(pNField);
		//��װ�Ա�ť	
		 Box gBox = Box.createHorizontalBox();
		 JLabel gLabel = new JLabel("���û��Ա�:");
		 ButtonGroup bg = new ButtonGroup();
		 JRadioButton maleBtn = new JRadioButton("��",true);
		 JRadioButton femaleBtn = new JRadioButton("Ů",false);
	     bg.add(maleBtn);
		 bg.add(femaleBtn);	 
		gBox.add(gLabel);
		gBox.add(Box.createHorizontalStrut(20));
		gBox.add(maleBtn);
		gBox.add(femaleBtn);
		gBox.add(Box.createHorizontalStrut(120));
		//���û�ְ��
		Box pe1Box =  Box.createHorizontalBox();
		JLabel eLabel = new JLabel("ְ������: ");
		JTextField etextfield = new JTextField(15); 
		 pe1Box.add(eLabel);
		 pe1Box.add(etextfield);
		 
		Box pe2Box = Box.createHorizontalBox();
		JLabel peLabel = new JLabel("Ȩ�޹�����:");
		ButtonGroup ebg = new ButtonGroup();
		 JRadioButton ebtn1 = new JRadioButton("��",true);
		 JRadioButton ebtn2 = new JRadioButton("��",false);
		 JRadioButton ebtn3 = new JRadioButton("��",false);
		 ebg.add(ebtn1);
		 ebg.add(ebtn2);
		 ebg.add(ebtn3);
         pe2Box.add(peLabel);
		 pe2Box.add(ebtn1);
		 pe2Box.add(ebtn2);
		 pe2Box.add(ebtn3);
		//�û������
	        Box u2Box = Box.createHorizontalBox();
			JLabel u2Label = new JLabel("�����û���:");
			JTextField  u2textfield= new JTextField(15);
			u2Box.add(u2Label);
			u2Box.add(Box.createHorizontalStrut(10));     //Jlabel���ı�����Ӽ��
			u2Box.add(u2textfield);
			//�������
			Box p2Box = Box.createHorizontalBox();
			JLabel p2Label = new JLabel("��������:");
			JTextField p2textfield = new JTextField(15);
			p2Box.add(p2Label);
			p2Box.add(Box.createHorizontalStrut(10));
			p2Box.add(p2textfield);
			
		 
		//��¼��ע��
		Box bBox =  Box.createHorizontalBox();
		JButton registerBtn = new JButton("ע��");
		JButton backBtn = new JButton("���ص�¼����");
		bBox.add(registerBtn);
		bBox.add(Box.createHorizontalStrut(40));
		bBox.add(backBtn);
		
		
		vBox.add(Box.createVerticalStrut(50));
		vBox.add(uBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(pBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(phoneNumberBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(gBox);
		
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(pe1Box);
		vBox.add(Box.createVerticalStrut(10));
		vBox.add(pe2Box);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(u2Box);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(p2Box);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(bBox);
		bgPanel.add(vBox);  
		
		
		
		//�������
		//���ò˵�����  ���ã��˵�
		
		//������¼����¼�ɹ���ѡ���ţ����Ҳ鿴����Ȩ�ޣ�����ע���û�
		//�����ڲ����÷ָ����;  סԺ��Live_in_Hospital�����ﲿSee_doctor��Ա������_employee_management��ҩƷ������Medicine_instrument       //��ɾ������������塣
		//������������ݿ���أ�ͼƬ���أ�
		//UI��¼��壬ע����壬�����Ź�����壬��������
		//
		
		
		
		//���ذ�ť
		registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//��ȡ�û����������
				String username = u2textfield.getText().trim();
				String password = p2textfield.getText().trim();
				//�������ݿ����
				login_SQL  loginsql = new login_SQL();
				Boolean b1 = false;
//				try {
//					b1 = loginsql.findUser(username,password);
//				}catch(SQLException el) {
//					el.printStackTrace();
//				}
				if(b1) {
					System.out.println("ע��ɹ���");
					try {
						new MainInterface().init();           //���е�¼�ɹ��Ľ���
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					jf.dispose();    //���ڹر�
//					//�����´���	
				}
				else {
					System.out.println("ע��ʧ�ܣ�");
					JOptionPane.showMessageDialog(null,"��������˻���������������������룡");
				}
				
			}
		});
		
		//���ذ�ť
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new Hospital_login();
					jf.dispose();
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
	
	
	

//	public static void main(String[] args) {
//		try {
//			new Hospital_Register().init();
//		} catch (Exception e) {
//		
//			e.printStackTrace();
//		}
//	}

}

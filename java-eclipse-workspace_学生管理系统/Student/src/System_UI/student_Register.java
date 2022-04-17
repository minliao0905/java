package System_UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.*;

import System_Component.BackGroundPanel;
import System_Component.PathUtils;
import System_Component.ScreenUtils;
import System_SQL.users_SQL;

public class student_Register {
	 JFrame jf = new JFrame("ѧ������ϵͳע��");
	
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
		
		  Box vBox = Box.createVerticalBox();
	     //�û��� 
	      Box uBox = Box.createHorizontalBox();
			JLabel uLabel = new JLabel("�û�����");
			JTextField uField = new JTextField(15);
			uBox.add(uLabel);
			uBox.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
			uBox.add(uField);
		//����	
	      Box p1Box = Box.createHorizontalBox();
			JLabel pLabel1 = new JLabel("��    �룺");
			JPasswordField pField1 = new JPasswordField();
			p1Box.add(pLabel1);
			p1Box.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
			p1Box.add(pField1);
		 Box p2Box = Box.createHorizontalBox();
			JLabel pLabel2 = new JLabel("���ٴ���������:");
			JPasswordField pField2 = new JPasswordField();
			p2Box.add(pLabel2);
			p2Box.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
			p2Box.add(pField2);
		//�ֻ�����	
	      Box phoneNumberBox = Box.createHorizontalBox();
			JLabel pNLabel = new JLabel("�ֻ����룺");
			JTextField pNField = new JTextField(15);
			phoneNumberBox.add(pNLabel);
			phoneNumberBox.add(Box.createHorizontalStrut(10));   //�������֮��ļ����
			phoneNumberBox.add(pNField);
		//��װ�Ա�ť	
		 Box gBox = Box.createHorizontalBox();
		 JLabel gLabel = new JLabel("��    ��");
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

		//��װ��ť
		Box btnBox = Box.createHorizontalBox();
		JButton registBtn = new JButton("ע��");
		JButton backBtn = new JButton("���ص�¼ҳ��");
		btnBox.add(registBtn);
		btnBox.add(Box.createHorizontalStrut(80));
		btnBox.add(backBtn);
		
		
	//��װ��������
					vBox.add(Box.createVerticalStrut(40));
					vBox.add(uBox);
					vBox.add(Box.createVerticalStrut(20));
					vBox.add(p1Box);
					vBox.add(Box.createVerticalStrut(20));
					vBox.add(p2Box);
					vBox.add(Box.createVerticalStrut(20));
					vBox.add(gBox);
					vBox.add(Box.createVerticalStrut(20));
					vBox.add(phoneNumberBox);
					vBox.add(Box.createVerticalStrut(20));
					
					vBox.add(btnBox);
					bgPanel.add(vBox);
					
			jf.setSize(WIDTH,HEIGHT);
			jf.add(bgPanel);
			jf.setVisible(true);
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	        
	        
//ע�ᰴť
		registBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//1�û�¼����Ϣ
			   String username = uField.getText().trim();
			   String password1 = new String(pField1.getPassword());
			   String password2 = new String(pField2.getPassword());
			   
			   String phone = pNField.getText().trim();
			   String gender = bg.isSelected(maleBtn.getModel())? maleBtn.getText():femaleBtn.getText();
			   if(password1.equals(password2)) {
				 //���ݴ���			 
				   Map<String,String> params = new LinkedHashMap<>();
				   params.put("username", username);
				   params.put("password", password1);
				   params.put("phone", phone);
				   params.put("gender", gender);
				  
		        	//��������Ƿ�Ϊ��
		        	 Set<String> keySet = params.keySet();        	 
		 	         String id= new String();
		 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
		 	        {   
		 	            String key = it.next();
		 	            // ���˼�����ͨ��map���ϵ�get������ȡ��ȡ���Ӧ��ֵ��
		 	            String value = params.get(key);
		 	           if(value.equals("")) {
		 	        	   JOptionPane.showMessageDialog(jf,"�������ݲ���Ϊ��,����������!"); 
		 	        	     return ;
		 	           }
		 	        } 
				 
	            //�������ݿ���ʶ���
				   users_SQL usersql = new users_SQL();
				   try {
					usersql.Insertuser(params);
				} catch (SQLException e1) {				
					e1.printStackTrace();				
				}
		          JOptionPane.showMessageDialog(jf, "ע��ɹ����������ص�¼����");
		          try {
		              new student_login().init();       //���ص�¼����
		              jf.dispose();
		          } catch (Exception ex) {
		              ex.printStackTrace();
		          }
			}else {
			  JOptionPane.showMessageDialog(jf,"������������벻һ��Ŷ������������");
			//passField ��Ϊ��
			  pField1.setText("");
			  pField2.setText("");
		       }
		   }
          
		});
				
	
		
//���ص�¼��ť��ť
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new student_login().init();   
					jf.dispose();
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
	
	}
	
	
	

//	public static void main(String[] args) {
//		try {
//			new student_Register().init();
//		} catch (Exception e) {
//		
//			e.printStackTrace();
//		}
//	}

}

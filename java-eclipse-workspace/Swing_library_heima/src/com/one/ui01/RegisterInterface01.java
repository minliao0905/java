package com.one.ui01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.itheima.jdbc.Logindao;
import com.one.component.BackGroundPanel;
import com.one.domain.ResultInfo;
import com.one.net.FailListener;
import com.one.net.ImageRequestUtils;
import com.one.net.PostUtils;
import com.one.net.SuccessListener;
import com.one.ui.MainInterface;
import com.one.util.JsonUtils;
import com.one.util.PathUtils;
import com.one.util.ScreenUtils;

public class RegisterInterface01{
	JFrame jf = new JFrame("ע��");
	final int WIDTH =500;
	final int HEIGHT= 400;
	
	//��װ��ͼ
	public void init() throws Exception{
		 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
		 jf.setResizable(false);
     //2�������Ͻǵ�logo
		jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

     //3���ô��ڵ�Jpanel
		BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("regist.jpg"))));
      bgPanel.setBounds(0,0,WIDTH,HEIGHT);
      
      Box vBox = Box.createVerticalBox();
      
      Box uBox = Box.createHorizontalBox();
		JLabel uLabel = new JLabel("�û�����");
		JTextField uField = new JTextField(15);
		uBox.add(uLabel);
		uBox.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
		uBox.add(uField);
		
      Box pBox = Box.createHorizontalBox();
		JLabel pLabel = new JLabel("��    �룺");
		JTextField pField = new JTextField(15);
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
		pBox.add(pField);
		
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
	//��װ��֤�룬��֤��ͼƬ
	Box checkCodeBox = Box.createHorizontalBox();
	JLabel checkCodeLabel = new JLabel("��֤�룺");
	JTextField checkCodeField = new JTextField(4);
	   //��֤��ͼƬ������������
//	JLabel cImg = new JLabel(new ImageIcon(ImageRequestUtils.getImage("http://localhost:8080/code/getCheckCode")));
	JLabel cImg = new JLabel(new ImageIcon("images/logo.png"));
	checkCodeBox.add(checkCodeLabel);
	checkCodeBox.add(Box.createHorizontalStrut(20));
	checkCodeBox.add(checkCodeField);
	checkCodeBox.add(cImg);
	//��cImg��Ӽ����¼��������ͼƬʱ��������ʾ��Ϣ�����ˢ�£�
	cImg.setToolTipText("���ˢ��");
//	cImg.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			cImg.setIcon(new ImageIcon(ImageRequestUtils.getImage("http://localhost:8080/code/getCheckCode")));
//			cImg.updateUI();//������֤��
//		}
//	});
	//��װ��ť
	Box btnBox = Box.createHorizontalBox();
	JButton registBtn = new JButton("ע��");
	JButton backBtn = new JButton("���ص�¼ҳ��");
	btnBox.add(registBtn);
	btnBox.add(Box.createHorizontalStrut(80));
	btnBox.add(backBtn);
	registBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//1�û�¼����Ϣ
		   String username = uField.getText().trim();
		   String password = pField.getText().trim();
		   String phone = pNField.getText().trim();
		   String gender = bg.isSelected(maleBtn.getModel())? maleBtn.getText():femaleBtn.getText();
		   String checkCode = checkCodeField.getText().trim();
		   Map<String,String> params = new HashMap<>();
		   params.put("username", username);
		   params.put("password", password);
		   params.put("phone", phone);
		   params.put("gender", gender);
		   params.put("checkCode", checkCode);
		   Logindao logindao = new Logindao();
		   try {
			logindao.AddUser(username,password);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
			
		}
          JOptionPane.showMessageDialog(jf, "ע��ɹ����������ص�¼����");
          try {
              new MainInterface01().init();      //���ص�¼����
              jf.dispose();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
		}
	});
	
	  backBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              //���ص���¼ҳ�漴��
              try {
                  new MainInterface01().init();
                  jf.dispose();
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
          }
      });

	
	
///////��װ��������
		vBox.add(Box.createVerticalStrut(40));
		vBox.add(uBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(pBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(gBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(phoneNumberBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(checkCodeBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(btnBox);
		bgPanel.add(vBox);
		
		jf.add(bgPanel);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
	
	public static void main(String[] args) {
		try {
			new RegisterInterface01().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
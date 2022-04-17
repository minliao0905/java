package com.one.ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.one.component.BackGroundPanel;
import com.one.domain.ResultInfo;
import com.one.net.FailListener;
import com.one.net.PostUtils;
import com.one.net.SuccessListener;
import com.one.util.JsonUtils;
import com.one.util.PathUtils;
import com.one.util.ScreenUtils;

public class MainInterface {
     JFrame jf= new JFrame("С��ͼ���");
     final int WIDTH = 500;
     final int HEIGHT = 300;
     
     
     //��װ��ͼ   
     public void init() throws Exception{ //�׳��쳣������
    	 //1���ô�����ص�����
    	 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
         jf.setResizable(false);
         //2�������Ͻǵ�logo
			jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

         //3���ô��ڵ�Jpanel
			BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("library.jpg"))));
		//4��װ��¼��Ԫ��
			Box vBox = Box.createVerticalBox();
			//�û���
			Box uBox = Box.createHorizontalBox();
			JLabel uLabel = new JLabel("�û���");
			JTextField uField = new JTextField(15);
			uBox.add(uLabel);
			uBox.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
			uBox.add(uField);
			
			
			//����
			Box pBox = Box.createHorizontalBox();
			JLabel pLabel = new JLabel("��    ��");
			JTextField pField = new JTextField(15);
			pBox.add(pLabel);
			pBox.add(Box.createHorizontalStrut(20));   //�������֮��ļ����
			pBox.add(pField);
			
			
			//�����ť
			Box btnBox = Box.createHorizontalBox();
			JButton loginBtn = new JButton("��¼");
			JButton registBtn = new JButton("ע��");
			btnBox.add(loginBtn);
			btnBox.add(Box.createHorizontalStrut(100));
			btnBox.add(registBtn);
			//5��ť����ʵ�ֽ���
			//////��¼��ť
			loginBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//��ȡ�û����������
					String username = uField.getText().trim();
					String password = pField.getText().trim();
					Map<String,String> params = new HashMap<>();
					params.put("username", username);
					params.put("password", password);
					
					//���ʵ�¼�ӿ�    PostUtils��Ĺ��캯��
					PostUtils.postWithParams("http://localhost:8080/user/login",params,new SuccessListener() {
						//������������Ӧ��
						@Override
						public void success(String result) {  //result���� ���Ƿ�������Ӧ�ص��ַ������ص���json�ַ��� ---���뵽JsonUtils���
							ResultInfo info = JsonUtils.parseResult(result);
						//�ж�info�е�flag���
							if(info.isFlag()) {	//��¼�ɹ�,����ת��ҳ��
								JOptionPane.showMessageDialog(jf, "��¼�ɹ�");
							}else {
								JOptionPane.showMessageDialog(jf, "��¼ʧ��");	
							}
							
						}
						
					},new FailListener() {
						//��������ʧ�ܣ�ִ�иó��򷽷�
						@Override
						public void fail() {
						JOptionPane.showMessageDialog(jf, "�����쳣�����Ժ����ԣ�");
						}
						
					});
					
				}
				
			});
			/////ע�ᰴť
			registBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(jf, "��ת��ע��ҳ��");
					try {
						new RegisterInterface().init();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//��ǰ������ʧ
					jf.dispose();
				}
				
			});
			vBox.add(Box.createVerticalStrut(40));
			vBox.add(uBox);
			vBox.add(Box.createVerticalStrut(20));
			vBox.add(pBox);
			vBox.add(Box.createVerticalStrut(50));
			vBox.add(btnBox);
			 
			bgPanel.add(vBox);
			jf.add(bgPanel);
			jf.setVisible(true);
			
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
     
     public static void main(String[] args) {
    	 try {
			new MainInterface().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    
}


/**��¼�����쳣
 * com.fasterxml.jackson.core.JsonParseException: Unexpected character ('<' (code 60)): expected a valid value (number, String, array, object, 'true', 'false' or 'null')
 at [Source: (String)"<HTML><HEAD><TITLE>Document Error: Not Found</TITLE></HEAD>
<BODY><H2>Access Error: 404 -- Not Found</H2>
</BODY></HTML>
 *ԭ�� ���ڴ����з�װ��JSON���Ǳ�׼��JSON��
 * */

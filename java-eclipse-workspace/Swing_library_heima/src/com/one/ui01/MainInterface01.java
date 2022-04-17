package com.one.ui01;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
//import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.itheima.jdbc.Logindao;
import com.one.component.BackGroundPanel;
import com.one.component.BookManageComponent;
import com.one.ui.ManagerInterface;
import com.one.ui.RegisterInterface;
//import com.one.domain.ResultInfo;
//import com.one.net.FailListener;
//import com.one.net.PostUtils;
//import com.one.net.SuccessListener;
//import com.one.util.JsonUtils;
import com.one.util.PathUtils;
import com.one.util.ScreenUtils;

public class MainInterface01 {
     JFrame jf= new JFrame("小型图书馆");
     final int WIDTH = 500;
     final int HEIGHT = 300;
     
     
     //组装视图   
     public void init() throws Exception{ //抛出异常的艺术
    	 //1设置窗口相关的属性
    	// 位置
    	 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
         jf.setResizable(false);
         //2窗口左上角的logo
			jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

         //3设置窗口的Jpanel
			BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("library.jpg"))));
		//4组装登录的元素
			Box vBox = Box.createVerticalBox();
			//用户名
			Box uBox = Box.createHorizontalBox();
			JLabel uLabel = new JLabel("用户名");
			JTextField uField = new JTextField(15);    
			uBox.add(uLabel);
			uBox.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
			uBox.add(uField);
			
			
			//密码
			Box pBox = Box.createHorizontalBox();
			JLabel pLabel = new JLabel("密    码");
			JTextField pField = new JTextField(15);
			pBox.add(pLabel);
			pBox.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
			pBox.add(pField);
			
			
			//组件按钮
			Box btnBox = Box.createHorizontalBox();
			JButton loginBtn = new JButton("登录");
			JButton registBtn = new JButton("注册");
			btnBox.add(loginBtn);
			btnBox.add(Box.createHorizontalStrut(100));
			btnBox.add(registBtn);
			//5按钮监听实现交互
			//////登录按钮
			uField.setText("123456789");
			pField.setText("123");
			loginBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//获取用户输入的数据
					String username = uField.getText().trim();
					String password = pField.getText().trim();
					Logindao logindao = new Logindao();
					Boolean b1 = false;
					try {
						b1 = logindao.findUser(username,password);
					}catch(SQLException el) {
						el.printStackTrace();
					}
					if(b1) {
						System.out.println("登录成功！");
						try {
							new ManagerInterface01().init();           //运行登录成功的界面
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						jf.dispose();    //窗口关闭
//						//创建新窗口	
					}
					else {
						System.out.println("登录失败！");
						JOptionPane.showMessageDialog(null,"您输入的账户名或密码错误，请重新输入！");
					}
					
				}
			});
			/////注册按钮
			registBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(jf, "跳转到注册页面");
					try {
						new RegisterInterface01().init();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//当前界面消失
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
			new MainInterface01().init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     }
    
}


/**登录出现异常
 * com.fasterxml.jackson.core.JsonParseException: Unexpected character ('<' (code 60)): expected a valid value (number, String, array, object, 'true', 'false' or 'null')
 at [Source: (String)"<HTML><HEAD><TITLE>Document Error: Not Found</TITLE></HEAD>
<BODY><H2>Access Error: 404 -- Not Found</H2>
</BODY></HTML>
 *原因： 由于代码中封装的JSON不是标准的JSON，
 * */

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
     JFrame jf= new JFrame("小型图书馆");
     final int WIDTH = 500;
     final int HEIGHT = 300;
     
     
     //组装视图   
     public void init() throws Exception{ //抛出异常的艺术
    	 //1设置窗口相关的属性
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
			loginBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//获取用户输入的数据
					String username = uField.getText().trim();
					String password = pField.getText().trim();
					Map<String,String> params = new HashMap<>();
					params.put("username", username);
					params.put("password", password);
					
					//访问登录接口    PostUtils里的构造函数
					PostUtils.postWithParams("http://localhost:8080/user/login",params,new SuccessListener() {
						//服务器正常响应；
						@Override
						public void success(String result) {  //result参数 就是服务器响应回的字符，返回的是json字符串 ---传入到JsonUtils组件
							ResultInfo info = JsonUtils.parseResult(result);
						//判断info中的flag标记
							if(info.isFlag()) {	//登录成功,即跳转主页面
								JOptionPane.showMessageDialog(jf, "登录成功");
							}else {
								JOptionPane.showMessageDialog(jf, "登录失败");	
							}
							
						}
						
					},new FailListener() {
						//当该请求失败，执行该程序方法
						@Override
						public void fail() {
						JOptionPane.showMessageDialog(jf, "网络异常，请稍后重试！");
						}
						
					});
					
				}
				
			});
			/////注册按钮
			registBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
//					JOptionPane.showMessageDialog(jf, "跳转到注册页面");
					try {
						new RegisterInterface().init();
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
			new MainInterface().init();
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

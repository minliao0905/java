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
	 JFrame jf = new JFrame("学生管理系统注册");
	
	//加载界面主方法
	public void init() throws Exception{
		final int WIDTH = 1000;
		final int HEIGHT = 600;
		
		
       //加载登录背景//设置布局，当前屏幕高和宽；		
		 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
		 jf.setResizable(false);  
       //2窗口左上角的logo
		 jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("管理.png"))));      //可能抛出异常，
         //3设置窗口的Jpanel
		BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getImagePath("登录.jfif"))));
		
		  Box vBox = Box.createVerticalBox();
	     //用户名 
	      Box uBox = Box.createHorizontalBox();
			JLabel uLabel = new JLabel("用户名：");
			JTextField uField = new JTextField(15);
			uBox.add(uLabel);
			uBox.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
			uBox.add(uField);
		//密码	
	      Box p1Box = Box.createHorizontalBox();
			JLabel pLabel1 = new JLabel("密    码：");
			JPasswordField pField1 = new JPasswordField();
			p1Box.add(pLabel1);
			p1Box.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
			p1Box.add(pField1);
		 Box p2Box = Box.createHorizontalBox();
			JLabel pLabel2 = new JLabel("请再次输入密码:");
			JPasswordField pField2 = new JPasswordField();
			p2Box.add(pLabel2);
			p2Box.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
			p2Box.add(pField2);
		//手机号码	
	      Box phoneNumberBox = Box.createHorizontalBox();
			JLabel pNLabel = new JLabel("手机号码：");
			JTextField pNField = new JTextField(15);
			phoneNumberBox.add(pNLabel);
			phoneNumberBox.add(Box.createHorizontalStrut(10));   //定义组件之间的间隔；
			phoneNumberBox.add(pNField);
		//组装性别按钮	
		 Box gBox = Box.createHorizontalBox();
		 JLabel gLabel = new JLabel("性    别：");
		 ButtonGroup bg = new ButtonGroup();
		 JRadioButton maleBtn = new JRadioButton("男",true);
		 JRadioButton femaleBtn = new JRadioButton("女",false);
		bg.add(maleBtn);
		bg.add(femaleBtn);
		gBox.add(gLabel);
		gBox.add(Box.createHorizontalStrut(20));
		gBox.add(maleBtn);
		gBox.add(femaleBtn);
		gBox.add(Box.createHorizontalStrut(120));

		//组装按钮
		Box btnBox = Box.createHorizontalBox();
		JButton registBtn = new JButton("注册");
		JButton backBtn = new JButton("返回登录页面");
		btnBox.add(registBtn);
		btnBox.add(Box.createHorizontalStrut(80));
		btnBox.add(backBtn);
		
		
	//组装整个界面
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
	        
	        
//注册按钮
		registBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//1用户录入信息
			   String username = uField.getText().trim();
			   String password1 = new String(pField1.getPassword());
			   String password2 = new String(pField2.getPassword());
			   
			   String phone = pNField.getText().trim();
			   String gender = bg.isSelected(maleBtn.getModel())? maleBtn.getText():femaleBtn.getText();
			   if(password1.equals(password2)) {
				 //数据存入			 
				   Map<String,String> params = new LinkedHashMap<>();
				   params.put("username", username);
				   params.put("password", password1);
				   params.put("phone", phone);
				   params.put("gender", gender);
				  
		        	//检查数据是否为空
		        	 Set<String> keySet = params.keySet();        	 
		 	         String id= new String();
		 	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
		 	        {   
		 	            String key = it.next();
		 	            // 有了键可以通过map集合的get方法获取获取其对应的值。
		 	            String value = params.get(key);
		 	           if(value.equals("")) {
		 	        	   JOptionPane.showMessageDialog(jf,"输入内容不能为空,请重新输入!"); 
		 	        	     return ;
		 	           }
		 	        } 
				 
	            //创建数据库访问对象
				   users_SQL usersql = new users_SQL();
				   try {
					usersql.Insertuser(params);
				} catch (SQLException e1) {				
					e1.printStackTrace();				
				}
		          JOptionPane.showMessageDialog(jf, "注册成功，即将返回登录界面");
		          try {
		              new student_login().init();       //返回登录界面
		              jf.dispose();
		          } catch (Exception ex) {
		              ex.printStackTrace();
		          }
			}else {
			  JOptionPane.showMessageDialog(jf,"两次输入的密码不一样哦！请重新输入");
			//passField 置为空
			  pField1.setText("");
			  pField2.setText("");
		       }
		   }
          
		});
				
	
		
//返回登录按钮按钮
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

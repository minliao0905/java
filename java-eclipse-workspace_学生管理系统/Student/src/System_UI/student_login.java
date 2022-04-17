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
	public JFrame jf = new JFrame("学生管理系统登录界面");
	
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
		Box vBox =  Box.createVerticalBox(); 

		//用户名组件
        Box uBox = Box.createHorizontalBox();
		JLabel uLabel = new JLabel("用户名:");
		JTextField  utextfield= new JTextField(15);
		uBox.add(uLabel);
		uBox.add(Box.createHorizontalStrut(10));     //Jlabel和文本框添加间隔
		uBox.add(utextfield);
		//密码组件
		Box pBox = Box.createHorizontalBox();
		//创建一个密码框组件
		JLabel pLabel = new JLabel("密   码:");		
		JPasswordField jppassword = new JPasswordField();
		
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(10));
		pBox.add(jppassword);
		
		Box cBox = Box.createHorizontalBox();
		JLabel cLabel = new JLabel("验证码:");
		JTextField  ctextfield = new JTextField(8);
		Yanzhencode checkCode = new Yanzhencode(); 
		cBox.add(cLabel);
		cBox.add(ctextfield);
		cBox.add(checkCode);
		//登录和注册
		Box bBox =  Box.createHorizontalBox();
		JButton loginBtn = new JButton("登录");
		JButton registBtn = new JButton("注册新用户");
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
		
		
		bgPanel.add(vBox);                          //背景面板
       
		
		
		utextfield.setText("xiaoguo");
		jppassword.setText("123456");
		
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//获取用户输入的数据
				String username = utextfield.getText().trim();
				String password = new String(jppassword.getPassword());
				String code = checkCode.getCode();
				boolean check01=false;
				if(code.equals(ctextfield.getText())) {
					check01 =true;
				}
				
				//引入数据库操作				
				
				Boolean b1 = true;
				users_SQL usersql = new users_SQL();
				try {
					b1 = usersql.findUser(username,password);
				}catch(SQLException el) {
					el.printStackTrace();
				}//验证码检验是否输入正确
				if(!check01) {
					JOptionPane.showMessageDialog(null,"您输入的验证码错误，请重新输入！");
				}else {
					if(b1) {
						System.out.println("登录成功！");
						try {
							new MainInterface().init();           //运行登录成功的界面
						} catch (Exception e1) {
							
							e1.printStackTrace();
						}
						   jf.dispose(); //窗口关闭
//						//创建新窗口	
					}
					else {
//						System.out.println("登录失败！");
						JOptionPane.showMessageDialog(null,"您输入的账户名或密码错误，请重新输入！");
						
					}
				}
				
				
			}
		});
		
		//注册新用户
		registBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new student_Register().init();
				jf.dispose();    //窗口关闭
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
	
	
	

	public static void main(String[] args) {           //当使用其他程序调用	new student_login().init() ;即调用了new student_login().init(),也调用了login中的main方法所以创造两个登录界面
		try { 
			new student_login().init();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}

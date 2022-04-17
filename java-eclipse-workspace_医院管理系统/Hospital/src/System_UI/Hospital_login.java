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
	JFrame jf = new JFrame("医院管理系统登录界面");
	
	
	
	
	
	//加载界面主方法
	public void init() throws Exception{
		final int WIDTH = 1000;
	final int HEIGHT = 600;
		
		
       //加载登录背景//设置布局，当前屏幕高和宽；		
		 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
		 jf.setResizable(false);  
       //2窗口左上角的logo
		 jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("医院.png"))));      //可能抛出异常，
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
		JLabel pLabel = new JLabel("密   码:");
		JTextField ptextfield = new JTextField(15);
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(10));
		pBox.add(ptextfield);
		
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
		vBox.add(bBox);
		
		
		bgPanel.add(vBox);                          //背景面板
		//设置菜单属性  设置，菜单
		
		//总面板登录，登录成功后选择部门，并且查看访问权限，或者注册用户
		//部门内部设置分割面板;  住院部Live_in_Hospital，门诊部See_doctor，员工管理_employee_management，药品和仪器Medicine_instrument       //添删改数据另置面板。
		//所需组件：数据库加载，图片加载，
		//UI登录面板，注册面板，各部门管理面板，总面板加载
		//
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//获取用户输入的数据
				String username = utextfield.getText().trim();
				String password = ptextfield.getText().trim();
				//引入数据库操作
				login_SQL  loginsql = new login_SQL();
				Boolean b1 = true;
//				try {
//					b1 = loginsql.findUser(username,password);
//				}catch(SQLException el) {
//					el.printStackTrace();
//				}
				if(b1) {
					System.out.println("登录成功！");
					try {
						new MainInterface().init();           //运行登录成功的界面
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					jf.dispose();    //窗口关闭
//					//创建新窗口	
				}
				else {
					System.out.println("登录失败！");
					JOptionPane.showMessageDialog(null,"您输入的账户名或密码错误，请重新输入！");
				}
				
			}
		});
		
		//注册
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

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
	JFrame jf = new JFrame("医院管理系统注册");
	
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
		JLabel uLabel = new JLabel("新用户名:    ");
		JTextField  utextfield= new JTextField(15);
		uBox.add(uLabel);
		uBox.add(Box.createHorizontalStrut(10));     //Jlabel和文本框添加间隔
		uBox.add(utextfield);
		//密码组件
		Box pBox = Box.createHorizontalBox();
		JLabel pLabel = new JLabel("新用户密码:     ");
		JTextField ptextfield = new JTextField(15);
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(10));
		pBox.add(ptextfield);
		//手机号码
		 Box phoneNumberBox = Box.createHorizontalBox();
		 JLabel pNLabel = new JLabel("新用户手机号码:");
		 JTextField pNField = new JTextField(15);
		 phoneNumberBox.add(pNLabel);
		 phoneNumberBox.add(Box.createHorizontalStrut(10));   //定义组件之间的间隔；
		 phoneNumberBox.add(pNField);
		//组装性别按钮	
		 Box gBox = Box.createHorizontalBox();
		 JLabel gLabel = new JLabel("新用户性别:");
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
		//新用户职务
		Box pe1Box =  Box.createHorizontalBox();
		JLabel eLabel = new JLabel("职务名称: ");
		JTextField etextfield = new JTextField(15); 
		 pe1Box.add(eLabel);
		 pe1Box.add(etextfield);
		 
		Box pe2Box = Box.createHorizontalBox();
		JLabel peLabel = new JLabel("权限管理级别:");
		ButtonGroup ebg = new ButtonGroup();
		 JRadioButton ebtn1 = new JRadioButton("Ⅰ级",true);
		 JRadioButton ebtn2 = new JRadioButton("Ⅱ级",false);
		 JRadioButton ebtn3 = new JRadioButton("Ⅲ级",false);
		 ebg.add(ebtn1);
		 ebg.add(ebtn2);
		 ebg.add(ebtn3);
         pe2Box.add(peLabel);
		 pe2Box.add(ebtn1);
		 pe2Box.add(ebtn2);
		 pe2Box.add(ebtn3);
		//用户名组件
	        Box u2Box = Box.createHorizontalBox();
			JLabel u2Label = new JLabel("您的用户名:");
			JTextField  u2textfield= new JTextField(15);
			u2Box.add(u2Label);
			u2Box.add(Box.createHorizontalStrut(10));     //Jlabel和文本框添加间隔
			u2Box.add(u2textfield);
			//密码组件
			Box p2Box = Box.createHorizontalBox();
			JLabel p2Label = new JLabel("您的密码:");
			JTextField p2textfield = new JTextField(15);
			p2Box.add(p2Label);
			p2Box.add(Box.createHorizontalStrut(10));
			p2Box.add(p2textfield);
			
		 
		//登录和注册
		Box bBox =  Box.createHorizontalBox();
		JButton registerBtn = new JButton("注册");
		JButton backBtn = new JButton("返回登录界面");
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
		
		
		
		//背景面板
		//设置菜单属性  设置，菜单
		
		//总面板登录，登录成功后选择部门，并且查看访问权限，或者注册用户
		//部门内部设置分割面板;  住院部Live_in_Hospital，门诊部See_doctor，员工管理_employee_management，药品和仪器Medicine_instrument       //添删改数据另置面板。
		//所需组件：数据库加载，图片加载，
		//UI登录面板，注册面板，各部门管理面板，总面板加载
		//
		
		
		
		//返回按钮
		registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//获取用户输入的数据
				String username = u2textfield.getText().trim();
				String password = p2textfield.getText().trim();
				//引入数据库操作
				login_SQL  loginsql = new login_SQL();
				Boolean b1 = false;
//				try {
//					b1 = loginsql.findUser(username,password);
//				}catch(SQLException el) {
//					el.printStackTrace();
//				}
				if(b1) {
					System.out.println("注册成功！");
					try {
						new MainInterface().init();           //运行登录成功的界面
					} catch (Exception e1) {
						
						e1.printStackTrace();
					}
					jf.dispose();    //窗口关闭
//					//创建新窗口	
				}
				else {
					System.out.println("注册失败！");
					JOptionPane.showMessageDialog(null,"您输入的账户名或密码错误，请重新输入！");
				}
				
			}
		});
		
		//返回按钮
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

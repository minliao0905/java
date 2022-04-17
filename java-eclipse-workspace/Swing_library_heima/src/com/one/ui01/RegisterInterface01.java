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
	JFrame jf = new JFrame("注册");
	final int WIDTH =500;
	final int HEIGHT= 400;
	
	//组装试图
	public void init() throws Exception{
		 jf.setBounds((ScreenUtils.getScreenWidth()-WIDTH)/2,(ScreenUtils.getScreenHeight()-HEIGHT)/2,WIDTH,HEIGHT);
		 jf.setResizable(false);
     //2窗口左上角的logo
		jf.setIconImage(ImageIO.read(new File(PathUtils.getRealPath("logo.png"))));

     //3设置窗口的Jpanel
		BackGroundPanel bgPanel = new BackGroundPanel(ImageIO.read(new File(PathUtils.getRealPath("regist.jpg"))));
      bgPanel.setBounds(0,0,WIDTH,HEIGHT);
      
      Box vBox = Box.createVerticalBox();
      
      Box uBox = Box.createHorizontalBox();
		JLabel uLabel = new JLabel("用户名：");
		JTextField uField = new JTextField(15);
		uBox.add(uLabel);
		uBox.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
		uBox.add(uField);
		
      Box pBox = Box.createHorizontalBox();
		JLabel pLabel = new JLabel("密    码：");
		JTextField pField = new JTextField(15);
		pBox.add(pLabel);
		pBox.add(Box.createHorizontalStrut(20));   //定义组件之间的间隔；
		pBox.add(pField);
		
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
	//组装验证码，验证码图片
	Box checkCodeBox = Box.createHorizontalBox();
	JLabel checkCodeLabel = new JLabel("验证码：");
	JTextField checkCodeField = new JTextField(4);
	   //验证码图片服务器端生成
//	JLabel cImg = new JLabel(new ImageIcon(ImageRequestUtils.getImage("http://localhost:8080/code/getCheckCode")));
	JLabel cImg = new JLabel(new ImageIcon("images/logo.png"));
	checkCodeBox.add(checkCodeLabel);
	checkCodeBox.add(Box.createHorizontalStrut(20));
	checkCodeBox.add(checkCodeField);
	checkCodeBox.add(cImg);
	//给cImg添加监听事件，当点击图片时，设置提示信息，点击刷新；
	cImg.setToolTipText("点击刷新");
//	cImg.addMouseListener(new MouseAdapter() {
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			cImg.setIcon(new ImageIcon(ImageRequestUtils.getImage("http://localhost:8080/code/getCheckCode")));
//			cImg.updateUI();//更新验证码
//		}
//	});
	//组装按钮
	Box btnBox = Box.createHorizontalBox();
	JButton registBtn = new JButton("注册");
	JButton backBtn = new JButton("返回登录页面");
	btnBox.add(registBtn);
	btnBox.add(Box.createHorizontalStrut(80));
	btnBox.add(backBtn);
	registBtn.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//1用户录入信息
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
          JOptionPane.showMessageDialog(jf, "注册成功，即将返回登录界面");
          try {
              new MainInterface01().init();      //返回登录界面
              jf.dispose();
          } catch (Exception ex) {
              ex.printStackTrace();
          }
		}
	});
	
	  backBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              //返回到登录页面即可
              try {
                  new MainInterface01().init();
                  jf.dispose();
              } catch (Exception ex) {
                  ex.printStackTrace();
              }
          }
      });

	
	
///////组装整个界面
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
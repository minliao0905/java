package login;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.SwingConstants;

import com.itheima.jdbc.Logindao;

public class CreatePanel {
 private static Loginlistener ll = null;
	public static JPanel createNorthPanel(JFrame jf) {
		JPanel  panel = new JPanel();
		panel.setLayout(null);    //取消面板的默认页面布局
		panel.setPreferredSize(new Dimension(0,140));  //面板尺寸
		ImageIcon image =new  ImageIcon("image/qqloginheader.png");              //添加面板背景图片，定义位置
		 JLabel background = new JLabel(image); 
		 
		 background.setBounds(0,0,426,image.getIconHeight()); 
		 panel.add(background);  
		 
		 JButton out =new JButton(new ImageIcon("image/up.png"));  //添加按钮  在面板顶部
		 out.setBounds(403,0,26,26);
		 out.setRolloverIcon(new ImageIcon("image/up.png"));            //退出时更改图片
		 
		 out.setBorderPainted(false);
		 panel.add(out);                               //取消按钮边框效果
    out.addActionListener(event->jf.dispose());
		return panel;
	}

	public static JPanel createCenterPanel(JFrame jf) {
		
		JPanel  panel = new JPanel();
		panel.setLayout(null);    //取消面板的默认页面布局
		
		//创建下拉框组件，初始化账号
		//原始版本
//	   String str []= {"123456789","3099722528","121231232"};
	   //加入数据库改进版本
//	   
	   Logindao logindao = new Logindao();
	    List<String> list=new ArrayList<String>();
	    try {
	    	  list=logindao.getUsers();
	    }catch(SQLException el) {
	    	el.printStackTrace();
	    }
	    //创建组合框数据容器
		DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
		for(String str:list){
			ComboBoxModel.addElement(str);
		}
		JComboBox<Object> jcoCenter = new JComboBox<Object>(ComboBoxModel);
		panel.add(jcoCenter);
		//设置下拉框可编辑
		jcoCenter.setEditable(true);
		jcoCenter.setBounds(0,15,175,30);
		//设置下拉框内容字体；
		jcoCenter.setFont(new Font("Calibri",0,13));
		//创建一个密码框组件
		JPasswordField jpCenter = new JPasswordField();
		//设置流失布局
		jpCenter.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		jpCenter.setBounds(0,44,175,30);
		jpCenter.setPreferredSize(new Dimension(185,25));
		panel.add(jpCenter);
		//创建小键盘图标组件，并加入到密码框组件中
		ImageIcon image = new ImageIcon("image/key.png");
		JButton jbu = new JButton(image);
		jbu.setPreferredSize(new Dimension(22,30));     //设置尺寸
		jbu.setBorderPainted(false);
		jpCenter.add(jbu);
		//创建两个多选框组件
		JCheckBox  jch1= new JCheckBox("记住密码");
		jch1.setFocusPainted(false);
		jch1.setFont(new Font("宋体",0,13));
		jch1.setBounds(0,85,80,20);
		panel.add(jch1);
		JCheckBox  jch2= new JCheckBox("自动登录");
		jch2.setFocusPainted(false);
		jch2.setFont(new Font("宋体",0,12));
		jch2.setBounds(100,85,80,20);
		panel.add(jch2);
		
		ll= new Loginlistener(jcoCenter,jpCenter,jf);
		
		 return panel;
	}

	public static JPanel createWestPanel() {
		JPanel  panel = new JPanel();
		panel.setLayout(null);    //取消面板的默认页面布局
		panel.setPreferredSize(new Dimension(130,0));  //面板尺寸
		ImageIcon image =new  ImageIcon("image/qq.png");              //添加面板背景图片，定义位置
		 JLabel background = new JLabel(image); 
		 background.setBounds(0,0,120,110); 
		 panel.add(background); 
		return panel;
	}
	
	public static JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,51));
		panel.setLayout(null);
		//创建左下角多人登录图表组件
		JButton  jbSouth = new JButton(new ImageIcon("image/up.png"));
		jbSouth.setPreferredSize(new Dimension(40,40));
		jbSouth.setFocusPainted(false);
		jbSouth.setRolloverIcon(new ImageIcon("image/up.png"));
		jbSouth.setBorderPainted(false);
		 
		//设置不显示按钮区域
		jbSouth.setContentAreaFilled(false);
		jbSouth.setBounds(0,10,40,40);
		jbSouth.setToolTipText("多账号登录");
		//创建底部中间登录图标
		ImageIcon image = new ImageIcon("image/load.png");
		JButton jb= new JButton("登录",image);
		jb.setFont(new Font("宋体",0,13));
		jb.setBounds(130,0,175,40);
		//将文字放在图片中间
//		jb.setHorizontalTextPosition(SwingConstants.CENTER);
//		jb.setFocusPainted(false);
//		jb.setContentAreaFilled(false);
//		jb.setBorderPainted(false);
//		jb.setRolloverIcon(new ImageIcon("src/up.png"));
		//创建右下角图标登录组件
		JButton jbri =new JButton(new ImageIcon("image/二维码.png"));
		jbri.setBounds(380,10,40,40);
		jbri.setFocusPainted(false);
		jbri.setContentAreaFilled(false);
		jbri.setBorderPainted(true);
		jbri.setRolloverIcon(new ImageIcon("image/up.png"));
		jbri.setToolTipText("二维码登录");
		panel.add(jbri);
		panel.add(jb);
		panel.add(jbSouth);
		jb.addActionListener(ll);
		return panel;
	}

	public static JPanel createEastPanel() {
		JPanel panel = new JPanel();
	     panel.setLayout(null);
	     panel.setPreferredSize(new Dimension(100,0));
	     //创建两个Jpanel 标签组件
	     JLabel regeist = new JLabel("注册账号");
	     regeist.setForeground(new Color(100,149,238));
	     regeist.setBounds(0,13,60,30);
	     regeist.setFont(new Font("宋体",0,12));
	     
	     JLabel regetword  = new JLabel("找回密码");
	     regetword.setForeground(new Color(100,149,238));
	     regetword.setBounds(0,43,60,30);
	     regetword.setFont(new Font("宋体",0,12));
		//添加JLabel标签	
	     panel.add(regeist);
	     panel.add(regetword);
	
	
	  return panel;
	}

}

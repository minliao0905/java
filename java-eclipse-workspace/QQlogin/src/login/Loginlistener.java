package login;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.itheima.jdbc.Logindao;   //引入SQL里的类





public class Loginlistener implements ActionListener {

	private JComboBox<Object>jco;
	private JPasswordField jpa;  
	private  JFrame jf ;
	public Loginlistener (JComboBox<Object>jco,JPasswordField jpa,JFrame jf) {
		super();
		this.jco = jco;
		this.jpa= jpa;
		this.jf= jf;
	}
	public static void main(String[] args) {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//从组合框里获取登录的账号和密码
		String name=(String) jco.getSelectedItem();
		String  pwd=new String(jpa.getPassword());
				
		Logindao logindao = new Logindao();
		Boolean b1 = false;
/**************数据库访问方法***************/
		//查询登录用户，如果有此用户并且密码正确则返回true;
		try {
			b1=logindao.findUser(name,pwd);
			
		}catch(SQLException e1){
			e1.printStackTrace();
		}
/*************数据库访问方法*************/
		if(b1) {
			//账号正确，先关闭当前JFrame登录窗口
			jf.dispose();
			JFrame jfn= new JFrame();  //新创登录界面
			jfn.setSize(364,931);
			jfn.setLocationByPlatform(true);
			jfn.setUndecorated(false);
			jfn.setResizable(true);
			jfn.setVisible(true);
			
			//为QQ显示窗口添加背景图片和退出按钮组件
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(0,500));
			ImageIcon image =new ImageIcon("image/QQload.png");
			JLabel background = new JLabel(image);
			background.setBounds(0,0,364,931);
			panel.add(background);
			
			//添加退出按钮
		    JButton out = new JButton(new ImageIcon("image/up.png"));
		    out.setBounds(330,0,26,26);
		    out.setRolloverIcon(new ImageIcon("image/up.png"));
		    out.setBorderPainted(false);
		    panel.add(out);
		    jfn.add(panel);
		    //为退出按钮注册监听器，关闭当前窗口；
		    out.addActionListener(event->jfn.dispose());
		}else {
			//QQ账号或密码输入错误，弹出提示信息；
			JOptionPane.showMessageDialog(null,"您输入的账户名或密码错误，请重新输入！");
			
		}
		
//		if(name.equals("123456789")&&pwd.equals("123"))
//		{
//			jf.dispose();
//			JFrame jfn= new JFrame();  //新创登录界面
//			jfn.setSize(364,931);
//			jfn.setLocationByPlatform(true);
//			jfn.setUndecorated(false);
//			jfn.setResizable(true);
//			jfn.setVisible(true);
//			
//			JPanel panel = new JPanel();
//			panel.setLayout(null);
//			panel.setPreferredSize(new Dimension(0,500));
//			ImageIcon image =new ImageIcon("src/QQload.png");
//			JLabel background = new JLabel(image);
//			background.setBounds(0,0,364,931);
//			panel.add(background);
//			
//			JButton out = new JButton(new ImageIcon("src/up.png"));
//		    out.setBounds(330,0,26,26);
//		    out.setRolloverIcon(new ImageIcon("src/up.png"));
//		    out.setBorderPainted(false);
//		    panel.add(out);
//		    jfn.add(panel);
//		    //为退出按钮注册监听器，关闭当前窗口；
//		    out.addActionListener(event->jfn.dispose());
//		}else {
//			//QQ账号或密码输入错误，弹出提示信息；
//			JOptionPane.showMessageDialog(null,"您输入的账户名或密码错误，请重新输入！");
//			
//		}
		
	}
}

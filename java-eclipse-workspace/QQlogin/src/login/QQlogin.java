package login;


import java.awt.BorderLayout;

import javax.swing.*;

public class QQlogin   {
	private static JFrame jf = new JFrame();
	public static void main(String[] args) {
		
      SwingUtilities.invokeLater(QQlogin::initLogin);     //使用   SwingUtilities 工具类 调用createAndshowGuI() 方法显示GUI程序
	}
	public  static void initLogin() {
		
	
		 jf.setSize(426,300);
		 jf.setLocation(497,242);
		 jf.setUndecorated(true);             //设置窗口边框不显示 ，若不显示，则无法进行自行移动或者更改大小操作
		 jf.setResizable(false);           //改变窗口大小 
		 BorderLayout border = new BorderLayout();      //根据qq界面登录效果，进行布局分配
		 jf.setLayout(border);            //加入面板   ，，borerLayout对象，进行界面分配      
		
		 JPanel panel_north = CreatePanel.createNorthPanel(jf);   //createPanel类 class创建不同面板，
		 jf.add(panel_north,BorderLayout.PAGE_START);      //顶部面板
		 JPanel panel_center = CreatePanel.createCenterPanel(jf);  
		 jf.add(panel_center,BorderLayout.CENTER);          //中部面板
		 JPanel panel_west = CreatePanel.createWestPanel();   
		 jf.add(panel_west,BorderLayout.LINE_START);      //左侧面板
		 JPanel panel_south = CreatePanel.createSouthPanel();   
		 jf.add(panel_south,BorderLayout.PAGE_END);      //底部面板
		 JPanel panel_east = CreatePanel.createEastPanel();   
		 jf.add(panel_east,BorderLayout.LINE_END);      //右侧部面板
         jf.setVisible(true); 
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	}

}

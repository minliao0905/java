package login;


import java.awt.BorderLayout;

import javax.swing.*;

public class QQlogin   {
	private static JFrame jf = new JFrame();
	public static void main(String[] args) {
		
      SwingUtilities.invokeLater(QQlogin::initLogin);     //ʹ��   SwingUtilities ������ ����createAndshowGuI() ������ʾGUI����
	}
	public  static void initLogin() {
		
	
		 jf.setSize(426,300);
		 jf.setLocation(497,242);
		 jf.setUndecorated(true);             //���ô��ڱ߿���ʾ ��������ʾ�����޷����������ƶ����߸��Ĵ�С����
		 jf.setResizable(false);           //�ı䴰�ڴ�С 
		 BorderLayout border = new BorderLayout();      //����qq�����¼Ч�������в��ַ���
		 jf.setLayout(border);            //�������   ����borerLayout���󣬽��н������      
		
		 JPanel panel_north = CreatePanel.createNorthPanel(jf);   //createPanel�� class������ͬ��壬
		 jf.add(panel_north,BorderLayout.PAGE_START);      //�������
		 JPanel panel_center = CreatePanel.createCenterPanel(jf);  
		 jf.add(panel_center,BorderLayout.CENTER);          //�в����
		 JPanel panel_west = CreatePanel.createWestPanel();   
		 jf.add(panel_west,BorderLayout.LINE_START);      //������
		 JPanel panel_south = CreatePanel.createSouthPanel();   
		 jf.add(panel_south,BorderLayout.PAGE_END);      //�ײ����
		 JPanel panel_east = CreatePanel.createEastPanel();   
		 jf.add(panel_east,BorderLayout.LINE_END);      //�Ҳಿ���
         jf.setVisible(true); 
		 jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	}

}

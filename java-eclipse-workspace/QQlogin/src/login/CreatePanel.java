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
		panel.setLayout(null);    //ȡ������Ĭ��ҳ�沼��
		panel.setPreferredSize(new Dimension(0,140));  //���ߴ�
		ImageIcon image =new  ImageIcon("image/qqloginheader.png");              //�����屳��ͼƬ������λ��
		 JLabel background = new JLabel(image); 
		 
		 background.setBounds(0,0,426,image.getIconHeight()); 
		 panel.add(background);  
		 
		 JButton out =new JButton(new ImageIcon("image/up.png"));  //��Ӱ�ť  ����嶥��
		 out.setBounds(403,0,26,26);
		 out.setRolloverIcon(new ImageIcon("image/up.png"));            //�˳�ʱ����ͼƬ
		 
		 out.setBorderPainted(false);
		 panel.add(out);                               //ȡ����ť�߿�Ч��
    out.addActionListener(event->jf.dispose());
		return panel;
	}

	public static JPanel createCenterPanel(JFrame jf) {
		
		JPanel  panel = new JPanel();
		panel.setLayout(null);    //ȡ������Ĭ��ҳ�沼��
		
		//�����������������ʼ���˺�
		//ԭʼ�汾
//	   String str []= {"123456789","3099722528","121231232"};
	   //�������ݿ�Ľ��汾
//	   
	   Logindao logindao = new Logindao();
	    List<String> list=new ArrayList<String>();
	    try {
	    	  list=logindao.getUsers();
	    }catch(SQLException el) {
	    	el.printStackTrace();
	    }
	    //������Ͽ���������
		DefaultComboBoxModel<Object> ComboBoxModel = new DefaultComboBoxModel<>();
		for(String str:list){
			ComboBoxModel.addElement(str);
		}
		JComboBox<Object> jcoCenter = new JComboBox<Object>(ComboBoxModel);
		panel.add(jcoCenter);
		//����������ɱ༭
		jcoCenter.setEditable(true);
		jcoCenter.setBounds(0,15,175,30);
		//�����������������壻
		jcoCenter.setFont(new Font("Calibri",0,13));
		//����һ����������
		JPasswordField jpCenter = new JPasswordField();
		//������ʧ����
		jpCenter.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
		jpCenter.setBounds(0,44,175,30);
		jpCenter.setPreferredSize(new Dimension(185,25));
		panel.add(jpCenter);
		//����С����ͼ������������뵽����������
		ImageIcon image = new ImageIcon("image/key.png");
		JButton jbu = new JButton(image);
		jbu.setPreferredSize(new Dimension(22,30));     //���óߴ�
		jbu.setBorderPainted(false);
		jpCenter.add(jbu);
		//����������ѡ�����
		JCheckBox  jch1= new JCheckBox("��ס����");
		jch1.setFocusPainted(false);
		jch1.setFont(new Font("����",0,13));
		jch1.setBounds(0,85,80,20);
		panel.add(jch1);
		JCheckBox  jch2= new JCheckBox("�Զ���¼");
		jch2.setFocusPainted(false);
		jch2.setFont(new Font("����",0,12));
		jch2.setBounds(100,85,80,20);
		panel.add(jch2);
		
		ll= new Loginlistener(jcoCenter,jpCenter,jf);
		
		 return panel;
	}

	public static JPanel createWestPanel() {
		JPanel  panel = new JPanel();
		panel.setLayout(null);    //ȡ������Ĭ��ҳ�沼��
		panel.setPreferredSize(new Dimension(130,0));  //���ߴ�
		ImageIcon image =new  ImageIcon("image/qq.png");              //�����屳��ͼƬ������λ��
		 JLabel background = new JLabel(image); 
		 background.setBounds(0,0,120,110); 
		 panel.add(background); 
		return panel;
	}
	
	public static JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(0,51));
		panel.setLayout(null);
		//�������½Ƕ��˵�¼ͼ�����
		JButton  jbSouth = new JButton(new ImageIcon("image/up.png"));
		jbSouth.setPreferredSize(new Dimension(40,40));
		jbSouth.setFocusPainted(false);
		jbSouth.setRolloverIcon(new ImageIcon("image/up.png"));
		jbSouth.setBorderPainted(false);
		 
		//���ò���ʾ��ť����
		jbSouth.setContentAreaFilled(false);
		jbSouth.setBounds(0,10,40,40);
		jbSouth.setToolTipText("���˺ŵ�¼");
		//�����ײ��м��¼ͼ��
		ImageIcon image = new ImageIcon("image/load.png");
		JButton jb= new JButton("��¼",image);
		jb.setFont(new Font("����",0,13));
		jb.setBounds(130,0,175,40);
		//�����ַ���ͼƬ�м�
//		jb.setHorizontalTextPosition(SwingConstants.CENTER);
//		jb.setFocusPainted(false);
//		jb.setContentAreaFilled(false);
//		jb.setBorderPainted(false);
//		jb.setRolloverIcon(new ImageIcon("src/up.png"));
		//�������½�ͼ���¼���
		JButton jbri =new JButton(new ImageIcon("image/��ά��.png"));
		jbri.setBounds(380,10,40,40);
		jbri.setFocusPainted(false);
		jbri.setContentAreaFilled(false);
		jbri.setBorderPainted(true);
		jbri.setRolloverIcon(new ImageIcon("image/up.png"));
		jbri.setToolTipText("��ά���¼");
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
	     //��������Jpanel ��ǩ���
	     JLabel regeist = new JLabel("ע���˺�");
	     regeist.setForeground(new Color(100,149,238));
	     regeist.setBounds(0,13,60,30);
	     regeist.setFont(new Font("����",0,12));
	     
	     JLabel regetword  = new JLabel("�һ�����");
	     regetword.setForeground(new Color(100,149,238));
	     regetword.setBounds(0,43,60,30);
	     regetword.setFont(new Font("����",0,12));
		//���JLabel��ǩ	
	     panel.add(regeist);
	     panel.add(regetword);
	
	
	  return panel;
	}

}

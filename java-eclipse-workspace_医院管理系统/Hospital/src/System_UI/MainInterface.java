package System_UI;

import java.awt.CardLayout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;

import javax.swing.*;

import In_patient_department.Inpatient;
import System_Component.PathUtils;
import System_Component.ScreenUtils;

import emplyees_department.employeepanel;
import medicine_department.medicine;
import out_patient_department.outpatient;


public class MainInterface  {
   public JFrame jf = new JFrame("ҽԺ����ϵͳ");
   final int   WIDTH = 1000;
   final int   HEIGHT = 600;
   JPanel Mainpanel = new JPanel();
	public void init() throws Exception{
		//�˵���
	     //��������������
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("ҽԺ.png"))));

        //���ò˵���
        JMenuBar jmb = new JMenuBar();
        JMenu MenuAct = new JMenu("�˺�");
        JMenuItem mAct1 = new JMenuItem("�л��˺�");
        JMenuItem mAct2 = new JMenuItem("�˳�����");
        MenuAct.add(mAct1);
        MenuAct.add(mAct2);
        
        JMenu Menudpart = new JMenu("����");
        JMenuItem MenuIn = new JMenuItem("סԺ��");
        JMenuItem Menuemployee = new JMenuItem("Ա������");
        JMenuItem Menuout = new JMenuItem("���ﲿ");
        JMenuItem Menumedicine = new JMenuItem("ҩ��������");
        Menudpart.add(MenuIn);
        Menudpart.add(Menuout);
        Menudpart.add(Menuemployee);       
        Menudpart.add(Menumedicine);
    
        jmb.add(MenuAct);
        jmb.add(Menudpart);
        
        
        CardLayout layout = new CardLayout();
        Container container = jf.getContentPane();
        JPanel inpanel = Inpatient.init();
        JPanel empanel = employeepanel.init();
        JPanel mepanel = medicine.init();
        JPanel outpanel = outpatient.init();
        container.setLayout(layout); 
        container.add(inpanel, "inpanel");
       container.add(empanel, "empanel");
        container.add(mepanel, "mepanel");
        container.add(outpanel, "outpanel");
      
        //סԺ��
        MenuIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 layout.show(container, "inpanel");
			}
        });
        Menuemployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 layout.show(container, "empanel");
			}
        	
        });
        Menuout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 layout.show(container, "outpanel");
			}
        	
        });
        Menumedicine.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 layout.show(container, "mepanel");
			}
        	
        });
        //�˺Ų˵�
        mAct1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Hospital_login().init();
                    jf.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        mAct2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        jf.setJMenuBar(jmb);
//        jf.add(Mainpanel);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		try {
			new MainInterface().init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}

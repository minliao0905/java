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
   public JFrame jf = new JFrame("医院管理系统");
   final int   WIDTH = 1000;
   final int   HEIGHT = 600;
   JPanel Mainpanel = new JPanel();
	public void init() throws Exception{
		//菜单栏
	     //给窗口设置属性
        jf.setBounds((ScreenUtils.getScreenWidth() - WIDTH) / 2, (ScreenUtils.getScreenHeight() - HEIGHT) / 2, WIDTH, HEIGHT);
        jf.setResizable(false);
        jf.setIconImage(ImageIO.read(new File(PathUtils.getImagePath("医院.png"))));

        //设置菜单栏
        JMenuBar jmb = new JMenuBar();
        JMenu MenuAct = new JMenu("账号");
        JMenuItem mAct1 = new JMenuItem("切换账号");
        JMenuItem mAct2 = new JMenuItem("退出程序");
        MenuAct.add(mAct1);
        MenuAct.add(mAct2);
        
        JMenu Menudpart = new JMenu("部门");
        JMenuItem MenuIn = new JMenuItem("住院部");
        JMenuItem Menuemployee = new JMenuItem("员工管理");
        JMenuItem Menuout = new JMenuItem("门诊部");
        JMenuItem Menumedicine = new JMenuItem("药剂和仪器");
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
      
        //住院部
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
        //账号菜单
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
